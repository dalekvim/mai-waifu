export const fetchImage = async () => {
  try {
    const response = await fetch("https://api.waifu.im/search");
    const json = await response.json();
    return json.images[0];
  } catch (err) {
    console.error.bind(err);
  }
  return {};
};
