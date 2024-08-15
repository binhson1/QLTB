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
      <h1 className="text-center">REPORT MANAGE</h1>
      <Table className="mt-3" striped>
        <thead>
          <tr>
            <th>Id</th>
            <th>Description</th>
            <th>Occurrence Date</th>
            <th>Severity</th>
            <th>Device</th>
            <th>User</th>
            <th>Status</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {report !== undefined &&
            report.map((r) => (
              <tr>
                <td>{r.id}</td>
                <td>{r.description}</td>
                <td>{r.occurrenceDate}</td>
                <td>{r.severity}</td>
                <td>{r.deviceId.name}</td>
                <td>{r.userId.username}</td>
                <td>{r.status}</td>
                <td></td>
              </tr>
            ))}
        </tbody>
      </Table>
    </div>
  );
};

export default Report;
