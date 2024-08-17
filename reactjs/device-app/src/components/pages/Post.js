import { useEffect, useState } from "react";
import { useParams } from "react-router";
import APIs from "../../configs/APIs";

const Post = () => {
  const { postId } = useParams();
  const [post, setPost] = useState([]);

  const loadPost = async () => {
    try {
      let res = await APIs;
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
