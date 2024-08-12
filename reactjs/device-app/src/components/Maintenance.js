import { useContext, useState } from "react";
import { MyUserContext } from "../App";
import { Link, Navigate } from "react-router-dom";
import APIs, { endpoints } from "../configs/APIs";

const Maintenance = () => {
  const user = useContext(MyUserContext);
  const [maintenances, setMaintenances] = useState([]);

  const loadMaintenances = async () => {
    try {
      let res = await APIs.get(endpoints["maintenances"]);
      setMaintenances(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };
  if (user === null) return <Navigate to="/login"></Navigate>;
  return (
    <div classNameName="col-10 container-fluid">
      <table className="table table-striped">
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Action</th>
        </tr>
        {maintenances !== undefined &&
          maintenances.map((c) => (
            <tr>
              <td>{c.id}</td>
              <td>{c.name}</td>
              <td>
                <Link className="btn btn-info">i</Link>
                <Link className="btn btn-success">&orarr;</Link>
                <button
                  onclick="deletes('${uD}', ${c.id}, 'cates')"
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

export default Maintenance;
