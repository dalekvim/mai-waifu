import { StyleSheet, Text, View } from "react-native";
import { GestureDetector, TapGesture } from "react-native-gesture-handler";

export const Menu = ({ doubleTap }: { doubleTap: TapGesture }) => {
  return (
    <GestureDetector gesture={doubleTap}>
      <View style={styles.container}>
        <Text style={styles.baseText}>
          <Text style={styles.title}>Mai Waifu</Text>
          {"\n"}
          {"\n"}
          <Text>
            Welcome to Mai Waifu the easy to use app for pictures of cute anime
            girls.
          </Text>
          {"\n"}
          {"\n"}
          <Text>
            <Text style={styles.bold}>Double tap</Text> to start using and
            toggle this menu.
          </Text>
          {"\n"}
          {"\n"}
          <Text>
            <Text style={styles.bold}>Long press</Text> on a girl you like to
            save.
          </Text>
          {"\n"}
          {"\n"}
          <Text>
            And <Text style={styles.bold}>tap</Text> to get a new picture.
          </Text>
          {"\n"}
          {"\n"}
          <Text>This app was made possible by the wonderful waifu.im API.</Text>
        </Text>
      </View>
    </GestureDetector>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 30,
    justifyContent: "center",
  },
  baseText: {
    color: "white",
    textAlign: "center",
    fontSize: 15,
  },
  title: {
    fontSize: 45,
  },
  bold: {
    fontWeight: "bold",
  },
});
