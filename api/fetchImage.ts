import { emptyImage } from "../constants/emptyImage";
import { waifuImage } from "../types/waifuImage";

type waifuResponse = {
  images: waifuImage[];
};

export const fetchImage = async (): Promise<waifuImage> => {
  try {
    const response = await fetch("https://api.waifu.im/search");
    const json = (await response.json()) as waifuResponse;
    return json.images[0];
  } catch (err) {
    console.error.bind(err);
  }
  return emptyImage;
};
