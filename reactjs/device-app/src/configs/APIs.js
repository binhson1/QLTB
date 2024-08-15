import axios from "axios";
import cookie from "react-cookies";

const BASE_URL = "http://localhost:8080/MMSApp/api/";

export const endpoints = {
  categories: "/categories",
  maintenances: "/maintenances",
  manufacturer: "/manufacturers",
  location: "/locations",
  report: "/report",
  addReport: "/report/addOrUpdate",
  login: "/login",
  device: "/device",
  schedulerepair: (deviceId) => `/device/${deviceId}/schedulerepair`,
  "current-user": "/current-user",
  register: "/users",
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
