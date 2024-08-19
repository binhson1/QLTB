import "bootstrap/dist/css/bootstrap.min.css";
import { Container } from "react-bootstrap";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./components/layout/Header";
import Footer from "./components/layout/Footer";
import Sidebar from "./components/layout/SideBar";
import { createContext, useEffect, useReducer, useState } from "react";
import MyUserReducer from "./reducer/MyUserReducer";
import Category from "./components/pages/Category";
import Login from "./components/pages/Login";
import AddReport from "./components/pages/AddReport";
import Home from "./components/pages/Home";
import Manufacturer from "./components/pages/Manufacture";
import Device from "./components/pages/Device";
import Maintenance from "./components/pages/Maintenance";
import cookie from "react-cookies";
import Register from "./components/pages/Register";
import ScheduleRepair from "./components/pages/ScheduleRepair";
import Report from "./components/pages/Report";
import Post from "./components/pages/Post";
import Forum from "./components/pages/Forum";
import Location from "./components/pages/Location";
import DevicesInArea from "./components/pages/DevicesInArea";
import AddPost from "./components/pages/AddPost";

export const MyUserContext = createContext();
export const MyDispatchContext = createContext();
const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, null);

  const [loading, setLoading] = useState();

  const loadUser = async () => {
    try {
      setLoading(true);
      if (cookie.load("user") != null) {
        await dispatch({
          type: "login",
          payload: cookie.load("user"),
        });
      }
    } catch (ex) {
      console.error(ex);
    } finally {
      setLoading(false);
    }
  };
  useEffect(() => {
    loadUser();
  }, []);

  return (
    <MyUserContext.Provider value={user}>
      <MyDispatchContext.Provider value={dispatch}>
        <BrowserRouter>
          <Header />
          <Container
            className="d-flex p-0 "
            fluid
            style={{ "min-height": "80vh" }}
          >
            <Sidebar />
            <Routes>
              {loading == false && (
                <>
                  <Route path="/" element={<Device />} />
                  <Route path="/category" element={<Category />} />
                  <Route path="/login" element={<Login />} />
                  <Route path="/register" element={<Register />} />
                  <Route path="/location" element={<Location />} />
                  <Route
                    path="/location/:locationId"
                    element={<DevicesInArea />}
                  />
                  <Route path="/report" element={<Report />} />
                  <Route path="/addreport/:deviceId" element={<AddReport />} />
                  <Route
                    path="/device/:deviceId/schedulerepair"
                    element={<ScheduleRepair />}
                  />
                  <Route path="/maintenance" element={<Maintenance />} />
                  <Route path="/manufacturer" element={<Manufacturer />} />
                  <Route path="/forum/" element={<Forum />} />
                  <Route path="/addPost/" element={<AddPost />} />
                  <Route path="/post/:postId/" element={<Post />} />
                </>
              )}
            </Routes>
          </Container>
          <Footer />
        </BrowserRouter>
      </MyDispatchContext.Provider>
    </MyUserContext.Provider>
  );
};

export default App;
