import { useContext, useEffect, useState } from "react";
import { useParams } from "react-router";
import APIs, { authAPIs, endpoints } from "../../configs/APIs";
import cookie from "react-cookies";
import { MyUserContext } from "../../App";
import { Button, Card, Form, ListGroup } from "react-bootstrap";

const Post = () => {
  const user = useContext(MyUserContext);
  const { postId } = useParams();
  const [post, setPost] = useState([]);
  const [comment, setComment] = useState();
  const [listComment, setListComment] = useState([]);
  const loadPost = async () => {
    try {
      let res = await authAPIs(cookie.load("access-token")).get(
        endpoints["post"](postId)
      );
      // console.info(res.data);
      setPost(res.data);
      const url = `${endpoints["comments"]}?postId=${postId}`;
      console.log(url);
      let comments = await authAPIs(cookie.load("access-token")).get(url);
      setListComment(comments.data);
      console.log(comments.data);
    } catch (ex) {
      console.error(ex);
    }
  };


  const handleSubmit = async (e) => {
    e.preventDefault();
    let newComment = {
      postId: postId,
      userId: user.id,
      content: comment
    };
    let res = await authAPIs(cookie.load("access-token")).post(endpoints["addComment"], newComment);
    const url = `${endpoints["comments"]}?postId=${postId}`;
    console.log(url);
    let comments = await authAPIs(cookie.load("access-token")).get(url);
    setListComment(comments.data);
    console.log(comments.data);
  }

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
      <hr></hr>
      <Form onSubmit={handleSubmit} className="m-3">
        <Form.Group controlId="commentForm" className="d-flex">
          <Form.Control
            type="text"
            placeholder="Nhập comment..."
            value={comment}
            onChange={(e) => setComment(e.target.value)}
            style={{ width: "90%" }}
          />
          <Button variant="primary" className="ms-3" type="submit">
            Gửi
          </Button>
        </Form.Group>

      </Form>
      <ListGroup>
        {listComment.map((comment) => (
          <>

            <ListGroup.Item key={comment.id} className="d-flex mb-2">
              <img src={comment.userId.avatar} className="me-3" style={{ width: "50px", height: "50px", borderRadius: "100%" }} />
              <div>
                <h4 className="m-0">{comment.userId.username}</h4>
                <p className="m-0">{comment.content}</p>
              </div>
              <div className="ms-auto">
                <p>Đã gửi 21112</p>
              </div>
            </ListGroup.Item>
          </>
        ))}
      </ListGroup>
    </div>
  );
};

export default Post;
