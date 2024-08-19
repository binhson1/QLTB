import { useEffect, useState } from "react";
import APIs, { authAPIs, endpoints } from "../../configs/APIs";
import cookie from "react-cookies";
import { Button, Card, Col, Row } from "react-bootstrap";
import { Link } from "react-router-dom";

const Forum = () => {
  const [posts, setPost] = useState([]);

  const loadPost = async () => {
    try {
      let res = await authAPIs(cookie.load("access-token")).get(
        endpoints["posts"]
      );
      setPost(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadPost();
  }, []);

  return (
    <div className="col-10 container-fluid">
      <h1 className="text-center mb-4">FORUM</h1>
      <Row>
        {posts !== undefined &&
          posts.map((p, index) => (
            <Col md={6} lg={4} className="mb-4" key={index}>
              <Card className="h-100">
                <Card.Body>
                  <Card.Title>{p.title}</Card.Title>
                  <Link to={`/post/${p.id}`}>
                    <Button variant="primary" size="sm">
                      Read More
                    </Button>
                  </Link>
                </Card.Body>
                <Card.Footer>
                  <small className="text-muted">
                    Posted on: {new Date(p.createDate).toLocaleDateString()}
                  </small>
                </Card.Footer>
              </Card>
            </Col>
          ))}
      </Row>
    </div>
  );
};

export default Forum;
