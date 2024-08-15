import { useContext, useEffect, useState } from "react";
import APIs, { endpoints } from "../../configs/APIs";
import { Navigate } from "react-router";
import { MyUserContext } from "../../App";

const Home = () => {
  const user = useContext(MyUserContext);

  if (user !== null) return <Navigate to="/login" />;
  return (
    <div class="col-10 container-fluid">
      <h1>HOME</h1>
    </div>
  );
};

export default Home;
