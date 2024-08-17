import { useContext, useEffect, useState } from "react";
import {
  Badge,
  Button,
  Col,
  Container,
  Form,
  Image,
  Nav,
  Navbar,
  NavDropdown,
  Row,
} from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import APIs, { endpoints } from "../../configs/APIs";
import { MyDispatchContext, MyUserContext } from "../../App";

const Header = () => {
  const user = useContext(MyUserContext);
  const [category, setCategory] = useState();
  const dispatch = useContext(MyDispatchContext);
  const [kw, setKw] = useState("");
  const nav = useNavigate();
  const loadCategory = async () => {
    try {
      let res = await APIs.get(`${endpoints["categories"]}`);
      setCategory(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadCategory();
  }, []);

  const submit = (e) => {
    e.preventDefault();

    nav(`/?kw=${kw}`);
  };

  return (
    <Navbar expand="lg" className="bg-dark navbar-dark shadow-sm">
      <Container fluid>
        <Navbar.Brand href="/" className="fw-bold">
          MMS Website
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="navbar-nav" />
        <Navbar.Collapse id="navbar-nav">
          <Nav className="me-auto">
            <Link className="nav-link text-light" to="/">
              Trang chủ
            </Link>

            {user === null ? (
              <>
                <Link className="nav-link text-light" to="/login">
                  &#129489; Đăng nhập
                </Link>
                <Link className="nav-link text-light" to="/register">
                  &#129489; Đăng ký
                </Link>
              </>
            ) : (
              <>
                <Link
                  className="nav-link d-flex align-items-center text-light"
                  to="/profile"
                >
                  <Image
                    src={user.avatar}
                    width="30"
                    height="30"
                    roundedCircle
                    className="me-2"
                  />
                  Chào {user.username}!
                </Link>
                <Button
                  className="rounded-pill"
                  variant="danger"
                  onClick={() => dispatch({ type: "logout" })}
                >
                  Đăng xuất
                </Button>
              </>
            )}
          </Nav>
          <Form className="d-flex" onSubmit={submit}>
            <Row className="align-items-center g-2">
              <Col>
                <Form.Control
                  type="text"
                  placeholder="Tìm thiết bị..."
                  className="rounded-pill"
                  value={kw}
                  onChange={(e) => setKw(e.target.value)}
                />
              </Col>
              <Col xs="auto">
                <Button type="submit" className="rounded-pill">
                  Tìm
                </Button>
              </Col>
            </Row>
          </Form>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default Header;
