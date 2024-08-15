import { useContext, useEffect, useState } from "react";
import APIs, { endpoints } from "../../configs/APIs";
import { Navigate } from "react-router";
import { MyUserContext } from "../../App";
import Device from "./Device";

const Home = () => {
  const user = useContext(MyUserContext);

  if (user !== null) return <Navigate to="/login" />;
  return <Device></Device>;
};

export default Home;
