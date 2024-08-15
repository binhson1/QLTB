import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../../App";
import APIs, { endpoints } from "../../configs/APIs";
import { Link } from "react-router-dom";

const Category = () => {
  const [categories, setCategories] = useState([]);
  const user = useContext(MyUserContext);
  const loadCates = async () => {
    try {
      let res = await APIs.get(endpoints["categories"]);
      setCategories(res.data);
    } catch (ex) {
      console.error(ex);
    }
  };

  useEffect(() => {
    loadCates();
  }, []);

  return (
    <div classNameName="col-10 container-fluid">
      <table className="table table-striped">
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Action</th>
        </tr>
        {categories !== undefined &&
          categories.map((c) => (
            <tr>
              <td>{c.id}</td>
              <td>{c.name}</td>
              <td>
                <Link className="btn btn-info" to={null}>
                  i
                </Link>
                <Link to={null} className="btn btn-success">
                  &orarr;
                </Link>
                <button
                  onclick="deletes('${uD}', ${c.id}, 'cates')"
                  className="btn btn-danger"
                >
                  &times;
                </button>
              </td>
            </tr>
          ))}
      </table>
    </div>
  );
};

export default Category;
