import { useEffect, useState } from "react";
import APIs, { endpoints } from "../configs/APIs";

const Home = () => {
  const [category, setCategory] = useState();
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
    <div class="col-10 container-fluid">
      <table class="table table-striped">
        <tr>
          <th>Id</th>
          <th>NAME</th>
          <th>Điều chỉnh</th>
        </tr>
        {category !== undefined &&
          category.map((c) => (
            <tr id="cates${c.id}">
              <td>{c.id}</td>
              <td>{c.name}</td>
              <td>
                <a href="#" class="btn btn-success"></a>
                <button
                  onclick="deletes('${uD}', ${c.id}, 'cates')"
                  class="btn btn-danger"
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

export default Home;
