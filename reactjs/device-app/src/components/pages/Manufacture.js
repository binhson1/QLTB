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

  // if (user === null) return <Navigate to="/login" />;

  return (
    <div className="col-10 container-fluid">
      <h1 className="text-center">MANUFACTURER MANAGE</h1>

      <table className="table table-striped mt-3 text-center">
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th></th>
        </tr>
        {manufacturer !== undefined &&
          manufacturer.map((m) => (
            <tr>
              <td>{m.id}</td>
              <td>{m.name}</td>
              <td>
                <Link className="btn btn-info">i</Link>
                <Link className="btn btn-success">&#x2197;</Link>

                <Button variant="outline-danger">&times;</Button>
              </td>
            </tr>
          ))}
      </table>
    </div>
  );
};

export default Manufacturer;
