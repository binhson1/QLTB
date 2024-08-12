import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../App";
import { Navigate } from "react-router";
import APIs, { endpoints } from "../configs/APIs";

const Report = () => {
  const user = useContext(MyUserContext);
  const [report, setReport] = useState([]);

  const loadReport = async () => {
    try {
      let res = await APIs.get(endpoints["report"]);
      setReport(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadReport();
  }, []);

  if (user === null) return <Navigate to="/login" />;
  return (
    <div classNameName="col-10 container-fluid">
      <h1 className="text-center">REPORT MANAGE</h1>
      <table className="table table-striped mt-3">
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
              <td>
                <a href="${u}" className="btn btn-success">
                  &orarr;
                </a>

                <button
                  onclick="deletes('${uD}', ${r.id}, 'report')"
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

export default Report;
