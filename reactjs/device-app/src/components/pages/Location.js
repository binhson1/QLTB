import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../../App";
import { Navigate } from "react-router";
import APIs, { authAPIs, endpoints } from "../../configs/APIs";
import { Link } from "react-router-dom";
import cookie from "react-cookies";

const Location = () => {
  const user = useContext(MyUserContext);
  const [locations, setLocation] = useState([]);

  const loadLocation = async () => {
    try {
      let res = await authAPIs(cookie.load("access_token")).get(
        endpoints["locations"]
      );
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
      <h1 className="text-center my-4">LOCATION MANAGE</h1>
      <div className="card">
        <div className="card-body">
          <table className="table table-striped table-bordered table-hover">
            <thead className="thead-dark">
              <tr>
                <th>Id</th>
                <th>Location Name</th>
                <th>Address</th>
                <th className="text-center">Actions</th>
              </tr>
            </thead>
            <tbody>
              {locations !== undefined &&
                locations.map((l) => (
                  <tr key={l.id}>
                    <td>{l.id}</td>
                    <td>{l.name}</td>
                    <td>{l.address}</td>
                    <td className="text-center">
                      <Link
                        className="btn btn-info btn-sm me-2"
                        to={`/location/${l.id}`}
                      >
                        Info
                      </Link>
                    </td>
                  </tr>
                ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default Location;
