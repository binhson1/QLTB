import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../App";
import { Navigate } from "react-router";
import APIs, { endpoints } from "../configs/APIs";
import { Link } from "react-router-dom";

const Device = () => {
  const user = useContext(MyUserContext);
  const [device, setDevice] = useState([]);

  const loadDevice = async () => {
    try {
      let res = await APIs.get(endpoints["device"]);
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
                <img src="${d.image}" width="120" />
              </td>
              <td>{d.id}</td>
              <td>{d.name}</td>
              <td>{d.boughtDate}</td>
              <td></td>
              <td>{d.deviceCategoryId.name}</td>
              <td>{d.manufacturerId.name}</td>
              <th>{d.status}</th>
              <td>
                <Link className="btn btn-info">i</Link>
                <Link className="btn btn-success">&orarr;</Link>

                <button
                  onclick="deletes('${uD}', ${d.id}, 'device')"
                  className="btn btn-danger"
                >
                  &times;
                </button>
              </td>
            </tr>
          ))}
      </table>
    </div>
  );
};

export default Device;
