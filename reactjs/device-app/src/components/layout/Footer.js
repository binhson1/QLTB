import { Container, Row, Col } from "react-bootstrap";

const Footer = () => {
  return (
    <footer className="bg-info text-white py-3">
      <Container>
        <Row>
          <Col className="text-center">
            <p className="mb-0">MMS Admin &copy; 2024</p>
          </Col>
        </Row>
      </Container>
    </footer>
  );
};

export default Footer;
