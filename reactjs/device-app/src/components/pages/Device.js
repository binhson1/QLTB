import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../../App";
import { Navigate } from "react-router";
import APIs, { authAPIs, endpoints } from "../../configs/APIs";
import { Link } from "react-router-dom";
import cookie from "react-cookies";
import { Button } from "react-bootstrap";

const Device = () => {
  const user = useContext(MyUserContext);

  const [q] = useSearchParams();

  const [device, setDevice] = useState([]);

  const loadDevice = async () => {
    try {
      let res = await authAPIs(cookie.load("access_token")).get(
        endpoints["device"]
      );
      setDevice(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadDevice();
  }, []);

  if (user === null) return <Navigate to="/login"></Navigate>;
  return (
    <div className="col-10 container-fluid">
      <h1 className="text-center">DEVICE MANAGE</h1>
      <table className="table table-striped mt-3">
        <tr>
          <th></th>
          <th>Id</th>
          <th>Device name</th>
          <th>Bought date</th>
          <th>Location</th>
          <th>Category</th>
          <th>Manufacturer</th>
          <th>Status</th>
          <th></th>
        </tr>
        {device !== undefined &&
          device.map((d) => (
            <tr>
              <td>
                <img src={d.image} width="120" />
              </td>
              <td>{d.id}</td>
              <td>{d.name}</td>
              <td>{d.boughtDate}</td>
              <td></td>
              <td>{d.deviceCategoryId.name}</td>
              <td>{d.manufacturerId.name}</td>
              <th>{d.status}</th>
              <td>
                <Link to={`/addReport/${d.id}/`} className="btn btn-danger">
                  REPORT
                </Link>
                <Link
                  to={`/device/${d.id}/schedulerepair`}
                  className="btn btn-info"
                >
                  Schedule Repair
                </Link>
              </td>
            </tr>
          ))}
      </table>
    </div>
  );
};

export default Device;
