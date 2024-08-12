import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../App";
import APIs, { endpoints } from "../configs/APIs";
import { Navigate } from "react-router";
import { Link } from "react-router-dom";

const Manufacturer = () => {
  const user = useContext(MyUserContext);
  const [manufacturer, setManufacturer] = useState([]);

  const loadManufacturer = async () => {
    try {
      let res = await APIs.get(endpoints["manufacturer"]);
      setManufacturer(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadManufacturer();
  }, []);

  if (user === null) return <Navigate to="/login" />;

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
                <Link className="btn btn-success">&orarr;</Link>

                <button
                  onClick="deletes('${uD}', ${m.id}, 'manu')"
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

export default Manufacturer;
