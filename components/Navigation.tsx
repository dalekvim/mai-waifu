import { useState } from "react";
import { Gesture } from "react-native-gesture-handler";
import { Menu } from "./Menu";
import { WaifuImage } from "./WaifuImage";

export const Navigation = () => {
  const [isMenu, setMenu] = useState(true);

  const doubleTap = Gesture.Tap()
    .maxDuration(250)
    .numberOfTaps(2)
    .onStart(() => {
      setMenu((curMenu) => !curMenu);
    });

  return isMenu ? (
    <Menu doubleTap={doubleTap} />
  ) : (
    <WaifuImage doubleTap={doubleTap} />
  );
};
