import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../../App";
import { Navigate } from "react-router";
import APIs, { authAPIs, endpoints } from "../../configs/APIs";
import { Link, useSearchParams } from "react-router-dom";
import cookie from "react-cookies";
import { Badge, Button } from "react-bootstrap";

const Device = () => {
  const user = useContext(MyUserContext);

  const [q] = useSearchParams();

  const [devices, setDevices] = useState([]);

  const [page, setPage] = useState(1);

  const loadDevices = async () => {
    try {
      console.log(user);
      let url = `${endpoints["devices"]}?page=${page}`;

      let cId = q.get("cateId");
      if (cId !== null) {
        setPage(1);
        url = `${url}&cateId=${cId}`;
      }

      let manuId = q.get("manuId");
      if (manuId !== null) {
        setPage(1);
        url = `${url}&manuId=${manuId}`;
      }

      let k = q.get("kw");
      if (k !== null) {
        setPage(1);
        url = `${url}&q=${k}`;
      }

      let res = await authAPIs(cookie.load("access-token")).get(url);

      if (page === 1) setDevices(res.data);
      else setDevices((current) => [...current, ...res.data]);

      console.info(devices);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadDevices();
  }, [page, q]);

  const loadMore = () => {
    setPage(page + 1);
  };

  const getStatusBadge = (status) => {
    switch (status) {
      case "ACTIVE":
        return <Badge bg="success">Active</Badge>;
      case "PENDING":
        return <Badge bg="warning">Pending</Badge>;
      case "MAINTENANCE":
        return <Badge bg="info">Maintenance</Badge>;
      case "REPAIR":
        return <Badge bg="danger">Repair</Badge>;
      default:
        return <Badge bg="secondary">Unknown</Badge>;
    }
  };

  if (user === null) return <Navigate to="/login"></Navigate>;
  return (
    <div className="col-10 container-fluid">
      <h1 className="text-center">DEVICE MANAGE</h1>
      <div className="card">
        <div className="card-body">
          <table className="table table-striped table-bordered table-hover">
            <thead className="table-dark">
              <tr className="text-center">
                <th></th>
                <th>Id</th>
                <th>Device name</th>
                <th>Bought date</th>
                <th>Category</th>
                <th>Manufacturer</th>
                <th>Status</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {devices !== undefined &&
                devices.map((d) => (
                  <tr className="text-center">
                    <td>
                      <img src={d.image} width="120" />
                    </td>
                    <td>{d.id}</td>
                    <td>{d.name}</td>
                    <td>{new Date(d.boughtDate).toLocaleDateString()}</td>
                    <td>{d.deviceCategoryId.name}</td>
                    <td>{d.manufacturerId.name}</td>
                    <th>{getStatusBadge(d.status)}</th>
                    <td>
                      <Link
                        to={`/addReport/${d.id}/`}
                        className="btn btn-danger"
                      >
                        REPORT
                      </Link>
                      <Link
                        to={`/device/${d.id}/schedulerepair`}
                        className="btn btn-info"
                      >
                        Schedule Repair
                      </Link>
                    </td>
                  </tr>
                ))}
            </tbody>
          </table>
        </div>
      </div>
      <div className="mt-2 text-center mb-1">
        <Button onClick={loadMore} variant="primary">
          Xem thêm
        </Button>
      </div>
    </div>
  );
};

export default Device;
