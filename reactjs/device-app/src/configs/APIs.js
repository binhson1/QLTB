import axios from "axios";
import cookie from "react-cookies";

const BASE_URL = "http://localhost:8080/MMSApp/api/";

export const endpoints = {
  generatetoken: "/generatetoken",
  categories: "/categories",
  maintenances: "/maintenances",
  manufacturer: "/manufacturers",
  locations: "/locations",
  report: "/report",
  addReport: "/report/addOrUpdate",
  login: "/login",
  devices: "/device",
  posts: "/posts",
  addPost: "/post/addOrUpdate",
  post: (postId) => `/posts/${postId}`,
  devicelocation: (locationId) => `/location/${locationId}/device`,
  schedulerepair: (deviceId) => `/device/${deviceId}/schedulerepair`,
  "current-user": "/current-user",
  register: "/users",
  comments: "/comments",
  addComment: "/comment/addOrUpdate",
};

export const authAPIs = () => {
  return axios.create({
    baseURL: BASE_URL,
    headers: {
      Authorization: cookie.load("access-token"),
    },
  });
};

export default axios.create({
  baseURL: BASE_URL,
});
