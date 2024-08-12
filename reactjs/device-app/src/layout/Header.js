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
import { Link } from "react-router-dom";
import APIs, { endpoints } from "../configs/APIs";
import { MyDispatchContext, MyUserContext } from "../App";

const Header = () => {
  const user = useContext(MyUserContext);
  const [category, setCategory] = useState();
  const dispatch = useContext(MyDispatchContext);
  const loadCategory = async () => {
    try {
      let res = await APIs.get(`${endpoints["categories"]}`);
      console.info(res.data);
      setCategory(res.data);
      console.info(category);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadCategory();
  }, []);
  return (
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <Navbar.Brand href="#home">MMS Website</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Link className="nav-link" to="/">
              Trang chủ
            </Link>

            <NavDropdown title="Danh mục" id="basic-nav-dropdown"></NavDropdown>

            {user === null ? (
              <>
                <Link className="nav-link text-success" to="/login">
                  &#129489; Đăng nhập
                </Link>
                <Link className="nav-link text-success" to="/register">
                  &#129489; Đăng ký
                </Link>
              </>
            ) : (
              <>
                <Link className="nav-link text-success" to="/login">
                  <Image src="" width="25" roundedCircle />
                  Chào !
                </Link>
                <Button
                  variant="danger"
                  onClick={() => dispatch({ type: "logout" })}
                >
                  Đăng xuất
                </Button>
              </>
            )}
            <Link className="nav-link text-danger" to="/cart">
              &#128722; <Badge bg="danger">{null}</Badge>
            </Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default Header;
