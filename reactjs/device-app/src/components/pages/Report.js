import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../../App";
import { Navigate } from "react-router";
import APIs, { authAPIs, endpoints } from "../../configs/APIs";
import { Link } from "react-router-dom";
import cookie from "react-cookies";
import { Button, Table } from "react-bootstrap";

const Report = () => {
  const user = useContext(MyUserContext);
  const [report, setReport] = useState([]);

  const loadReport = async () => {
    try {
      let res = await authAPIs(cookie.load("access_token")).get(
        endpoints["report"]
      );
      setReport(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadReport();
  }, []);

  const deleteReport = async () => {
    try {
    } catch (ex) {
      console.error(ex);
    }
  };

  if (user === null) return <Navigate to="/login" />;
  return (
    <div className="col-10 container-fluid">
      <h1 className="text-center my-4">REPORT MANAGE</h1>
      <div className="card">
        <div className="card-body">
          <table className="table table-striped table-bordered table-hover">
            <thead className="table-dark">
              <tr>
                <th>Id</th>
                <th>Description</th>
                <th>Occurrence Date</th>
                <th>Severity</th>
                <th>Device</th>
                <th>User</th>
                <th>Status</th>
                <th className="text-center">Actions</th>
              </tr>
            </thead>
            <tbody>
              {report !== undefined &&
                report.map((r) => (
                  <tr key={r.id}>
                    <td>{r.id}</td>
                    <td>{r.description}</td>
                    <td>{new Date(r.occurrenceDate).toLocaleDateString()}</td>
                    <td>{r.severity}</td>
                    <td>{r.deviceId.name}</td>
                    <td>{r.userId.username}</td>
                    <td>{r.status}</td>
                    <td className="text-center">
                      <Link
                        className="btn btn-info btn-sm me-2"
                        to={`/report/${r.id}`}
                      >
                        View
                      </Link>
                      <Link
                        className="btn btn-warning btn-sm me-2"
                        to={`/report/edit/${r.id}`}
                      >
                        Edit
                      </Link>
                      <button className="btn btn-outline-danger btn-sm">
                        &times;
                      </button>
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

export default Report;
