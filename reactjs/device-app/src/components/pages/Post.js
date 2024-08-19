import { useContext, useEffect, useState } from "react";
import { useParams } from "react-router";
import APIs, { authAPIs, endpoints } from "../../configs/APIs";
import cookie from "react-cookies";
import { MyUserContext } from "../../App";
import { Button, Card } from "react-bootstrap";

const Post = () => {
  const user = useContext(MyUserContext);
  const { postId } = useParams();
  const [post, setPost] = useState([]);

  const loadPost = async () => {
    try {
      let res = await authAPIs(cookie.load("access-token")).get(
        endpoints["post"](postId)
      );
      console.info(res.data);
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
      <Card className="shadow-sm m-3">
        <Card.Body>
          <Card.Title className="display-1">{post.title}</Card.Title>
          <p className="text-muted">
            Posted on: {new Date(post.createDate).toLocaleDateString()}
          </p>
          <hr />
          <Card.Text>
            <div dangerouslySetInnerHTML={{ __html: post.content }} />
          </Card.Text>
          <hr />
          <div className="d-flex justify-content-end">
            {user.id == post.userId && (
              <Button
                variant="primary"
                onClick={() => alert("Edit functionality goes here")}
              >
                Edit Post
              </Button>
            )}
          </div>
        </Card.Body>
      </Card>
    </div>
  );
};

export default Post;
