import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../../App";
import APIs, { authAPIs, endpoints } from "../../configs/APIs";
import { Navigate } from "react-router";
import { Link } from "react-router-dom";
import cookie from "react-cookies";
import { Button } from "react-bootstrap";

const Manufacturer = () => {
  const user = useContext(MyUserContext);
  const [manufacturer, setManufacturer] = useState([]);

  const loadManufacturer = async () => {
    try {
      let res = await authAPIs(cookie.load("access_token")).get(
        endpoints["manufacturer"]
      );
      setManufacturer(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadManufacturer();
  }, []);

  const deleteManufacturer = () => {
    try {
      let res = APIs.delete(endpoints);
    } catch (ex) {}
  };

  if (user === null) return <Navigate to="/login" />;

  return (
    <div className="col-10 container-fluid">
      <h1 className="text-center">MANUFACTURER MANAGE</h1>
      <div className="card">
        <div className="card-body">
          <table className="table table-striped table-bordered table-hover">
            <thead className="table-dark">
              <tr className="text-center">
                <th>Id</th>
                <th>Name</th>
              </tr>
            </thead>
            <tbody>
              {manufacturer !== undefined &&
                manufacturer.map((m) => (
                  <tr className="text-center">
                    <td>{m.id}</td>
                    <td>{m.name}</td>
                  </tr>
                ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default Manufacturer;
