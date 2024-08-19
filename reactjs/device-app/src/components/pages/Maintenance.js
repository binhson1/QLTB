import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../../App";
import { Link, Navigate } from "react-router-dom";
import APIs, { authAPIs, endpoints } from "../../configs/APIs";
import cookie from "react-cookies";

const Maintenance = () => {
  const user = useContext(MyUserContext);
  const [maintenances, setMaintenances] = useState([]);

  const loadMaintenances = async () => {
    try {
      let res = await authAPIs(cookie.load("access_token")).get(
        endpoints["maintenances"]
      );
      setMaintenances(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadMaintenances();
  }, []);

  if (user === null) return <Navigate to="/login"></Navigate>;
  return (
    <div className="col-10 container-fluid">
      <h1 className="text-center">MAINTENANCE MANAGE</h1>
      <div className="card">
        <div className="card-body">
          <table className="table table-striped table-bordered table-hover">
            <thead className="table-dark">
              <tr className="text-center">
                <th>Id</th>
                <th>Name</th>
                <th>Next</th>
                <th>Last Maintenance</th>
                <th>Next Maintenance</th>
                <th>Interval month</th>
                <th>Maintenance type</th>
              </tr>
            </thead>
            <tbody>
              {maintenances !== undefined &&
                maintenances.map((c) => (
                  <tr className="text-center">
                    <td>{c.id}</td>
                    <td>{c.name}</td>
                    <td>{c.lastMaintenanceDate}</td>
                    <td>{c.nextMaintenanceDate}</td>
                    <td>{c.intervalMonth}</td>
                    <td>{c.maintenanceTypeId.name}</td>
                  </tr>
                ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default Maintenance;
