import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../../App";
import { Navigate, useParams } from "react-router";
import { authAPIs, endpoints } from "../../configs/APIs";
import cookie from "react-cookies";
import { Button, Form } from "react-bootstrap";

const AddReport = () => {
  const [device, setDevice] = useState([]);
  const { deviceId } = useParams();
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
      if (res.status === 201) <Navigate to="/device"></Navigate>;
    } catch (ex) {
      console.error(ex);
    }
  };

  if (user === null) return <Navigate to="/login" />;

  return (
    <div className="col-10 container-fluid">
      <h1 className="text-center text-primary mt-3">ADD REPORT</h1>
      <Form onSubmit={add}>
        <Form.Group className="mb-3" controlId="description">
          <Form.Label>Description</Form.Label>
          <Form.Control
            type="text"
            placeholder="Enter description"
            onChange={(e) => setDescription(e.target.value)}
          />
        </Form.Group>
        <Form.Group className="mb-3" controlId="severity">
          <Form.Label>Severity</Form.Label>
          <Form.Control
            type="text"
            placeholder="Enter severity"
            onChange={(e) => setSeverity(e.target.value)}
          />
        </Form.Group>
        <Form.Group className="mb-3" controlId="occurrenceDate">
          <Form.Label>Occurrence Date</Form.Label>
          <Form.Control
            type="date"
            onChange={(e) => setOccurrenceDate(e.target.value)}
          />
        </Form.Group>
        <Button variant="success" type="submit" className="w-100">
          ADD
        </Button>
      </Form>
    </div>
  );
};

export default AddReport;
