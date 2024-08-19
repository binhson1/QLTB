import { useContext, useState } from "react";
import { authAPIs, endpoints } from "../../configs/APIs";
import { CKEditor } from "@ckeditor/ckeditor5-react";
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import { Alert, Button, Card, Col, Row } from "react-bootstrap";
import { Form, Navigate, useNavigate } from "react-router-dom";
import { MyUserContext } from "../../App";
import cookie from "react-cookies";

const AddPost = () => {
  const user = useContext(MyUserContext);
  const [title, setTitle] = useState("");
  const [postContent, setPostContent] = useState("");
  const [message, setMessage] = useState("");
  const [messageType, setMessageType] = useState("");
  const navigate = useNavigate();
  const handleEditorChange = (event, editor) => {
    const data = editor.getData();
    setPostContent(data);
  };

  const getCurrentDate = () => {
    const now = new Date();
    return now.toISOString().split("T")[0];
  };

  const handleSubmit = async () => {
    try {
      let res = await authAPIs(cookie.load("access-token")).post(
        endpoints["addPost"],
        {
          title: title,
          content: postContent,
          createDate: getCurrentDate(),
          userId: user.id,
        }
      );
      setMessage("Post created successfully!");
      setMessageType("success");

      setTimeout(() => {
        navigate("/forum");
      }, 5000);
    } catch (ex) {
      console.error(ex);
      setMessage("Failed to create post. Please try again.");
      setMessageType("danger");
    }
  };

  return (
    <div className="col-10 container-fluid">
      <Card className="m-3">
        <Card.Body>
          <h2 className="mb-4 text-center">Create a New Post</h2>
          {message && (
            <Alert
              variant={messageType}
              onClose={() => setMessage("")}
              dismissible
            >
              {message}
            </Alert>
          )}
          <div className="mb-3">
            <label htmlFor="title" className="form-label">
              Title
            </label>
            <input
              type="text"
              id="title"
              className="form-control"
              placeholder="Enter post title"
              value={title}
              onChange={(e) => setTitle(e.target.value)}
            />
          </div>

          <div className="mb-3">
            <label htmlFor="content" className="form-label">
              Content
            </label>
            <CKEditor
              editor={ClassicEditor}
              data={postContent}
              onChange={handleEditorChange}
            />
          </div>

          <Button variant="primary" onClick={handleSubmit}>
            Submit
          </Button>
        </Card.Body>
      </Card>
    </div>
  );
};

export default AddPost;
