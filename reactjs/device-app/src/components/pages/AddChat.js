import { useContext, useEffect, useState } from "react";
import cookie from "react-cookies";
import { db } from "../../configs/FireBase";
import { collection, getDocs, query, where } from "firebase/firestore";
import { Button, ListGroup } from "react-bootstrap";
import { Link, Navigate } from "react-router-dom";
import { MyUserContext } from "../../App";

const AddChat = () => {
  const [users, setUser] = useState([]);
  const user = useContext(MyUserContext);
  const loadUsers = async () => {
    const q1 = query(collection(db, "User-Info"), where("uid", "!=", user.uid));

    const querySnapshot = await getDocs(q1);
    const listUser = [];
    querySnapshot.forEach((doc) => {
      listUser.push({ id: doc.id, ...doc.data() });
    });
    // console.log(listUser);
    setUser(listUser);
  };

  useEffect(() => {
    loadUsers();
  }, []);

  if (user === null) return <Navigate to="/login"></Navigate>;

  return (
    <div className="col-10 container-fluid">
      <div className="card">
        <div className="card-body">
          <ListGroup>
            {users.map((user) => (
              <ListGroup.Item
                key={user.id}
                className="d-flex align-items-center p-3 mb-2 border rounded shadow-sm"
                style={{ backgroundColor: "#f8f9fa" }}
              >
                <div className="mr-3">
                  <img
                    src={user.avatar}
                    alt={user.username}
                    className="rounded-circle"
                    style={{
                      width: "50px",
                      height: "50px",
                      objectFit: "cover",
                    }}
                  />
                </div>
                <div className="flex-grow-1">
                  <h5 className="mb-1" style={{ marginBottom: "0.5rem" }}>
                    {user.username}
                  </h5>
                </div>
                <Link to={`/chat/${user.uid}/`}>
                  <Button variant="primary">Chat</Button>
                </Link>
              </ListGroup.Item>
            ))}
          </ListGroup>
        </div>
      </div>
    </div>
  );
};

export default AddChat;
