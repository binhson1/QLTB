import { useEffect, useState } from "react";
import APIs, { authAPIs, endpoints } from "../../configs/APIs";
import cookie from "react-cookies";

const Forum = () => {
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

  return (
    <div className="col-10 container-fluid">
      <h1>FORUM</h1>
    </div>
  );
};

export default Forum;
