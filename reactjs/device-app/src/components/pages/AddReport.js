import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../../App";
import { Navigate } from "react-router";
import { authAPIs, endpoints } from "../../configs/APIs";
import cookie from "react-cookies";

const AddReport = () => {
  const [device, setDevice] = useState([]);
  const [deviceId, setDeviceId] = useState();
  const [description, setDescription] = useState();
  const [severity, setSeverity] = useState();
  const [occurrenceDate, setOccurrenceDate] = useState();
  const user = useContext(MyUserContext);

  const loadDevice = async () => {
    try {
      let res = await authAPIs(cookie.load("access_token")).get(
        `${endpoints["device"]}?status=ACTIVE`
      );
      setDevice(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadDevice();
  }, []);

  const add = async () => {
    try {
      let res = await authAPIs(cookie.load("access_token")).post(
        endpoints["addReport"],
        {
          description: description,
          occurrenceDate: occurrenceDate,
          severity: severity,
          status: "PENDING",
          userId: user.id,
          deviceId: deviceId,
        }
      );
      console.info(res.status);
    } catch (ex) {
      console.error(ex);
    }
  };

  if (user === null) return <Navigate to="/login" />;

  return (
    <div className="col-10 container-fluid">
      <h1 className="text-center text-primary mt-1">ADD REPORT</h1>

      <form onSubmit={add} method="post" modelAttribute="report">
        <div className="mb-3 mt-3">
          <label for="description" className="form-label">
            Description
          </label>
          <input
            type="text"
            onChange={(e) => setDescription(e.target.value)}
          ></input>
        </div>
        <div className="mb-3 mt-3">
          <label for="severity" className="form-label">
            Severity
          </label>
          <input
            type="text"
            onChange={(e) => setSeverity(e.target.value)}
          ></input>
        </div>
        <div className="mb-3 mt-3">
          <label for="occurrenceDate" className="form-label">
            Occurrence date
          </label>
          <input
            type="date"
            onChange={(e) => setOccurrenceDate(e.target.value)}
          ></input>
        </div>
        <div className="mb-3 mt-3">
          <label htmlFor="deviceDropdown" className="form-label">
            Device
          </label>
          <select
            id="deviceDropdown"
            className="form-control"
            onChange={(e) => {
              setDeviceId(e.target.value);
            }}
          >
            <option value="" disabled selected>
              Select a device
            </option>
            {device.length > 0 &&
              device.map((d) => (
                <option key={d.id} value={d.id}>
                  {d.name} (ID: {d.id})
                </option>
              ))}
          </select>
        </div>
        <button className="btn btn-success" type="submit">
          ADD
        </button>
      </form>
    </div>
  );
};

export default AddReport;
