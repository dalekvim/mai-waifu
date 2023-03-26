import { Image } from "expo-image";
import * as MediaLibrary from "expo-media-library";
import { useEffect, useState } from "react";
import { ActivityIndicator, Alert, StyleSheet, Text, View } from "react-native";
import {
  Gesture,
  GestureDetector,
  TapGesture,
} from "react-native-gesture-handler";
import { fetchImage } from "../api/fetchImage";

export const WaifuImage = ({ doubleTap }: { doubleTap: TapGesture }) => {
  const [isFetching, setFetching] = useState(false);
  const [current, setCurrent] = useState("");
  const [prefetched, setPrefetched] = useState("");
  const [saving, setSaving] = useState(false);

  useEffect(() => {
    fetchImage()
      .then(({ url }) => {
        setCurrent(url);
      })
      .catch((err) => console.error.bind(err));
    fetchImage()
      .then(({ url }) => {
        Image.prefetch(url);
        setPrefetched(url);
      })
      .catch((err) => console.error.bind(err));
  }, []);

  const updateImage = async () => {
    setCurrent(prefetched);
    setFetching(true);
    try {
      const { url } = await fetchImage();
      Image.prefetch(url);
      setPrefetched(url);
    } catch (err) {
      console.error.bind(err);
    }
    setFetching(false);
  };

  const saveImageToLibrary = async () => {
    setSaving(true);
    try {
      await MediaLibrary.saveToLibraryAsync(current);
      Alert.alert("Saved!");
    } catch (err) {
      console.error.bind(err);
      Alert.alert("Something went wrong...");
    }
    setSaving(false);
  };

  const [permissionResponse, requestPermission] = MediaLibrary.usePermissions();

  const saveImage = async () => {
    if (permissionResponse && permissionResponse.granted) {
      await saveImageToLibrary();
    } else {
      const newPermissions = await requestPermission();

      if (newPermissions && newPermissions.granted) {
        await saveImageToLibrary();
      } else {
        Alert.alert("Do not have permission to save.");
      }
    }
  };

  const singleTap = Gesture.Tap()
    .maxDuration(250)
    .onStart(() => {
      if (!saving) {
        updateImage();
      }
    });

  const longPress = Gesture.LongPress().onEnd(async () => {
    if (!saving) {
      await saveImage();
    }
  });

  const tapGesture = Gesture.Exclusive(doubleTap, singleTap);
  const composed = Gesture.Race(tapGesture, longPress);

  return isFetching ? (
    <View style={styles.activityIndicator}>
      <ActivityIndicator size="large" color="white" />
    </View>
  ) : current ? (
    <GestureDetector gesture={composed}>
      <Image style={styles.image} source={current} contentFit="contain" />
    </GestureDetector>
  ) : (
    <Text>Something went wrong...</Text>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  activityIndicator: {
    flex: 1,
    justifyContent: "center",
  },
  image: {
    flex: 1,
    width: "100%",
  },
});
