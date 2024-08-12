import axios from "axios";
import cookie from "react-cookies";
import Maintenance from "../components/Maintenance";

const BASE_URL = "http://localhost:8080/MMSApp/api/";

export const endpoints = {
  categories: "/categories",
  maintenances: "/maintenances",
  manufacturer: "/manufacturers",
  location: "/locations",
  report: "/report",
  login: "/login",
  device: "/device",
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
