import { useEffect, useState } from "react";
import { useParams } from "react-router";
import APIs, { authAPIs, endpoints } from "../../configs/APIs";
import cookie from "react-cookies";

const Post = () => {
  const { postId } = useParams();
  const [post, setPost] = useState([]);

  const loadPost = async () => {
    try {
      let res = await authAPIs(cookie.load("access-token")).get(endpoints[""]);
      setPost(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadPost();
  }, []);

  <div className="col-10 container-fluid">
    <h1>POST</h1>
  </div>;
};

export default Post;
