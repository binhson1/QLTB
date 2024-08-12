import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../App";
import { Navigate } from "react-router";
import APIs, { endpoints } from "../configs/APIs";
import { Link } from "react-router-dom";

const Location = () => {
  const user = useContext(MyUserContext);
  const [location, setLocation] = useState([]);

  const loadLocation = async () => {
    try {
      let res = await APIs.get(endpoints["location"]);
      setLocation(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadLocation();
  }, []);

  if (user === null) return <Navigate to="/login"></Navigate>;

  return (
    <div className="col-10 container-fluid">
      <h1 className="text-center">LOCATION MANAGE</h1>
      <table className="table table-striped mt-3">
        <tr>
          <th>Id</th>
          <th>Location name</th>
          <th>Address</th>
          <th></th>
        </tr>
        {location !== undefined &&
          location.map((l) => (
            <tr>
              <td>{l.id}</td>
              <td>{l.name}</td>
              <td>{l.address}</td>
              <td>
                <Link className="btn btn-info">i</Link>
                <Link className="btn btn-success">&orarr;</Link>
                <button
                  onclick="deletes('${uD}', ${l.id}, 'location')"
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

export default Location;
