import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { authAPIs, endpoints } from "../../configs/APIs";
import cookie from "react-cookies";
import { Image, Table } from "react-bootstrap";

const DevicesInArea = () => {
  const { locationId } = useParams();
  const [location, SetLocation] = useState([]);
  const [devices, setDevice] = useState([]);

  const loadDevice = async () => {
    try {
      let res = await authAPIs(cookie.load("access-token")).get(
        endpoints["devicelocation"](locationId)
      );
      setDevice(res.data);
      res = await authAPIs(cookie.load("access-token")).get(
        `${endpoints["locations"]}/${locationId}/`
      );
      SetLocation(res.data);
      console.log(location);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadDevice();
  }, []);

  return (
    <div className="col-10 container-fluid">
      <div className="text-center text-info">
        <h1>DEVICES IN {location.name}</h1>
      </div>
      <div className="card">
        <div className="card-body">
          <table className="table table-striped table-bordered table-hover">
            <thead className="table-dark">
              <tr className="text-center">
                <th></th>
                <th>Id</th>
                <th>Device Name</th>
                <th>Manufacturer</th>
              </tr>
            </thead>
            <tbody>
              {devices &&
                devices.map((d) => (
                  <tr key={d.id} className="text-center">
                    <td>
                      <Image src={d.image} width="120" rounded />
                    </td>
                    <td>{d.id}</td>
                    <td>{d.name}</td>
                    <td>{d.manufacturerId.name}</td>
                  </tr>
                ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};
export default DevicesInArea;
