import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../../App";
import { Navigate } from "react-router";
import APIs, { authAPIs, endpoints } from "../../configs/APIs";
import { Link } from "react-router-dom";
import cookie from "react-cookies";

const Location = () => {
  const user = useContext(MyUserContext);
  const [location, setLocation] = useState([]);

  const loadLocation = async () => {
    try {
      let res = await authAPIs(cookie.load("access_token")).get(
        endpoints["location"]
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
                <Link className="btn btn-success">&#x2197;</Link>

                <Button variant="outline-danger">&times;</Button>
              </td>
            </tr>
          ))}
      </table>
    </div>
  );
};

export default Location;
