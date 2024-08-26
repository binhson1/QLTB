import { useContext, useEffect, useState } from "react";
import cookie from "react-cookies";
import { db } from "../../configs/FireBase";
import {
  addDoc,
  collection,
  getDocs,
  query,
  Timestamp,
  where,
} from "firebase/firestore";
import { Button, ListGroup } from "react-bootstrap";
import { Link, Navigate, useNavigate } from "react-router-dom";
import { MyUserContext } from "../../App";

const AddChat = () => {
  const user = useContext(MyUserContext);
  const nav = useNavigate();
  const [users, setUser] = useState([]);
  const loadUsers = async () => {
    console.log(user);
    const q1 = query(collection(db, "User-Info"), where("uid", "!=", user.uid));
    const querySnapshot = await getDocs(q1);
    const listUser = [];
    querySnapshot.forEach((doc) => {
      listUser.push({ id: doc.id, ...doc.data() });
    });
    setUser(listUser);
  };

  const addUserChat = async (uid) => {
    const listUser = [user.uid, uid];
    const currentDate = Timestamp.now();
    const q1 = query(
      collection(db, "User-Chat"),
      where("users", "array-contains", user.uid)
    );
    try {
      const querySnapshot = await getDocs(q1);
      if (!querySnapshot.empty) {
        let check = false;
        querySnapshot.forEach((doc) => {
          if (doc.data().users.includes(uid)) {
            check = true;
            nav(`/chat/${uid}/`);
          }
        });
        if (check == false) {
          const userCollectionRef = collection(db, "User-Chat");
          const newData = {
            users: listUser,
            created_date: currentDate,
            nummessage0: 0,
            nummessage1: 0,
          };
          const docRef = await addDoc(userCollectionRef, newData);
          console.log("Document added with ID: ", docRef.id);
          nav(`/chat/${uid}/`);
        }
      } else {
        // Trường hợp không có userchats của user hiện tại => không có userchat giữa user hiện tại và user cần thêm
        // Thêm userchats giữa user hiện tại và user cần thêm
        console.log("Query did not return any documents.");
        const userCollectionRef = collection(db, "User-Chat");
        const newData = {
          users: listUser,
          created_date: currentDate,
          nummessage0: 0,
          nummessage1: 0,
        };
        const docRef = await addDoc(userCollectionRef, newData);
        console.log("Document added with ID: ", docRef.id);
        nav(`/chat/${uid}/`);
      }
    } catch (error) {
      console.error("Error loading user chats: ", error);
    }
  };

  useEffect(() => {
    // if (user) {
    loadUsers();
    // }
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

                <Button variant="primary" onClick={() => addUserChat(user.uid)}>
                  Chat
                </Button>
              </ListGroup.Item>
            ))}
          </ListGroup>
        </div>
      </div>
    </div>
  );
};

export default AddChat;
