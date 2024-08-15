import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { authAPIs, endpoints } from "../../configs/APIs";
import cookie from "react-cookies";
import { Table } from "react-bootstrap";

const ScheduleRepair = () => {
  const [scheduleRepair, setScheduleRepair] = useState([]);
  const { deviceId } = useParams();
  const loadScheduleRepair = async () => {
    try {
      console.log(deviceId);
      console.log(endpoints["schedulerepair"](deviceId));
      let res = await authAPIs(cookie.load("access_token")).get(
        endpoints["schedulerepair"](deviceId)
      );
      setScheduleRepair(res.data);
      console.log(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadScheduleRepair();
  }, []);

  return (
    <div className="col-10 container-fluid">
      <h1 className="text-center">Schedule Repair</h1>
      <Table className=" mt-3" striped>
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Date</th>
            <th>Cost</th>
            <th>Repair Type</th>
            <th>Report </th>
          </tr>
        </thead>
        <tbody>
          {scheduleRepair !== undefined &&
            scheduleRepair.map((d) => (
              <tr>
                <td>{d.id}</td>
                <td>{d.name}</td>
                <td>{d.date}</td>
                <td>{d.cost}</td>
                <td>{d.repairTypeId.name}</td>
                <th>{d.reportId.id}</th>
              </tr>
            ))}
        </tbody>
      </Table>
    </div>
  );
};

export default ScheduleRepair;
