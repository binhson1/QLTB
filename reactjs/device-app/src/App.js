import "bootstrap/dist/css/bootstrap.min.css";
import { Container } from "react-bootstrap";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./layout/Header";
import Footer from "./layout/Footer";
import Home from "./components/Home";
import Sidebar from "./layout/SideBar";
import { createContext, useReducer } from "react";
import MyUserReducer from "./reducer/MyUserReducer";
import Login from "./components/Login";
import Device from "./components/Device";
import Maintenance from "./components/Maintenance";
import Manufacturer from "./components/Manufacture";
import Report from "./components/Report";
import Category from "./components/Category";

export const MyUserContext = createContext();
export const MyDispatchContext = createContext();
const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, null);

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
              <Route path="/" element={<Home />} />
              <Route path="/category" element={<Category />} />
              <Route path="/login" element={<Login />} />
              <Route path="/device" element={<Device />} />
              <Route path="/report" element={<Report />} />
              <Route path="/maintenance" element={<Maintenance />} />
              <Route path="/manufacturer" element={<Manufacturer />} />
            </Routes>
          </Container>
          <Footer />
        </BrowserRouter>
      </MyDispatchContext.Provider>
    </MyUserContext.Provider>
  );
};

export default App;
