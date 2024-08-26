import { useContext, useEffect, useRef, useState } from "react";
import { MyUserContext } from "../../App";
import {
  addDoc,
  collection,
  doc,
  getDocs,
  increment,
  onSnapshot,
  orderBy,
  query,
  Timestamp,
  updateDoc,
  where,
} from "firebase/firestore";
import { db } from "../../configs/FireBase";
import { Button, Col, Form, Image, ListGroup, Row } from "react-bootstrap";
import moment from "moment";

const CustomerService = () => {
  const user = useContext(MyUserContext);
  const [id, setId] = useState("");
  const [users, setUser] = useState([]);
  const [chatData, setChatData] = useState([]);
  const [newMessage, setNewMessage] = useState("");
  const [otherUserInfo, setOtherUserInfo] = useState({});
  const chatEndRef = useRef(null);

  const loadUsers = async () => {
    const q1 = query(collection(db, "User-Info"), where("uid", "!=", user.uid));
    const querySnapshot = await getDocs(q1);
    const listUser = [];
    querySnapshot.forEach((doc) => {
      listUser.push({ id: doc.id, ...doc.data() });
    });
    setUser(listUser);
  };

  const fetchOtherUserInfo = async () => {
    const otherUserQuery = query(
      collection(db, "User-Info"),
      where("uid", "in", [id])
    );
    const otherUserSnapshot = await getDocs(otherUserQuery);
    if (!otherUserSnapshot.empty) {
      setOtherUserInfo(otherUserSnapshot.docs[0].data());
    }
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
            setId(uid);
            fetchOtherUserInfo();
            loadChat();
            // nav(`/chat/${uid}/`);
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
          // nav(`/chat/${uid}/`);
          setId(uid);
          fetchOtherUserInfo();
          loadChat();
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
        // nav(`/chat/${uid}/`);
        setId(uid);
        fetchOtherUserInfo();
        loadChat();
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

  const loadChat = async () => {
    const q = query(
      collection(db, "User-Chat"),
      where("users", "array-contains", user.uid)
    );

    const unsubscribe = onSnapshot(q, async (snapshot) => {
      const chatDoc = snapshot.docs
        .map((doc) => ({ id: doc.id, ...doc.data() }))
        .find((chat) => chat.users.includes(id));

      if (chatDoc) {
        if (chatDoc.users[0] != user.uid) {
          updateDoc(doc(db, "User-Chat", chatDoc.id), { nummessage0: 0 });
          console.log(chatDoc.ref);
          console.log(chatDoc);
        } else {
          updateDoc(doc(db, "User-Chat", chatDoc.id), { nummessage1: 0 });
          console.log(chatDoc.ref);
          console.log(chatDoc);
        }
        const chatDataRef = query(
          collection(db, "User-Chat", chatDoc.id, "Chat"),
          orderBy("created_date")
        );
        const chatDataSnapshot = await getDocs(chatDataRef);
        const chatData = chatDataSnapshot.docs.map((doc) => doc.data());
        chatDataSnapshot.forEach((doc) => {
          const messages = doc.data();
          if (messages.from != user.uid && messages.status == "đã gửi") {
            updateDoc(doc.ref, { status: "đã xem" });
          }
        });
        console.log("Updated chat data:", chatData);
        setChatData(chatData);
      }
    });

    return () => unsubscribe();
  };

  const sendMessage = async () => {
    if (newMessage.trim()) {
      try {
        const chatQuery = query(
          collection(db, "User-Chat"),
          where("users", "array-contains", user.uid)
        );
        const chatSnapshot = await getDocs(chatQuery);
        const chatDoc = chatSnapshot.docs
          .map((doc) => ({ id: doc.id, ...doc.data() }))
          .find((chat) => chat.users.includes(id));

        if (chatDoc) {
          if (chatDoc.users[0] == user.uid) {
            updateDoc(doc(db, "User-Chat", chatDoc.id), {
              nummessage0: increment(1),
            });
          } else {
            updateDoc(doc(db, "User-Chat", chatDoc.id), {
              nummessage1: increment(1),
            });
          }
          const chatDataRef = collection(db, "User-Chat", chatDoc.id, "Chat");
          await addDoc(chatDataRef, {
            created_date: Timestamp.fromDate(new Date()),
            from: user.uid,
            messages: newMessage,
            status: "đã gửi",
          });
          console.log("loi3");
          setNewMessage("");
          loadChat();
        }
      } catch (error) {
        console.error("Error sending message: ", error);
      }
    }
  };

  const scrollToBottom = () => {
    chatEndRef.current?.scrollIntoView({ behavior: "smooth" });
  };

  return (
    <div className="container-fluid row">
      <div className="col-2 overflow">
        <div className="card m-3" style={{ height: "85vh" }}>
          <div className="card-body p-0">
            <ListGroup>
              {users.map((user) => (
                <ListGroup.Item
                  key={user.id}
                  className="d-flex align-items-center p-2 mb-2 border-0 rounded shadow-sm"
                  style={{ backgroundColor: "#f8f9fa", cursor: "pointer" }}
                  onClick={() => addUserChat(user.uid)}
                >
                  <img
                    src={user.avatar}
                    alt={user.username}
                    className="rounded-circle mr-3"
                    style={{
                      width: "50px",
                      height: "50px",
                      objectFit: "cover",
                    }}
                  />
                  <div className="flex-grow-1">
                    <h5 className="mb-0">{user.username}</h5>
                  </div>
                </ListGroup.Item>
              ))}
            </ListGroup>
          </div>
        </div>
      </div>
      <div className="col-10">
        <div
          className="overflow-auto"
          ref={chatEndRef}
          style={{
            maxHeight: "80vh",
            padding: "10px",
            overflowX: "hidden",
            height: "80vh",
            backgroundColor: "#f5f5f5",
            borderRadius: "5px",
          }}
        >
          {chatData.map((msg, index) => (
            <Row
              key={index}
              className={`mb-3 ${
                msg.from === user.uid
                  ? "justify-content-end"
                  : "justify-content-start"
              }`}
            >
              {msg.from !== user.uid && (
                <Col xs="auto">
                  <Image
                    src={otherUserInfo.avatar}
                    roundedCircle
                    style={{ width: "40px", height: "40px" }}
                  />
                </Col>
              )}
              <Col xs="auto">
                <div
                  style={{
                    maxWidth: "250px",
                    padding: "10px",
                    borderRadius: "15px",
                    backgroundColor:
                      msg.from === user.uid ? "#007bff" : "#e5e5e5",
                    color: msg.from === user.uid ? "white" : "black",
                  }}
                >
                  {msg.messages}
                </div>
                <p className="text-muted small mt-1 mb-0">
                  {msg.status} -{" "}
                  {moment.unix(msg.created_date.seconds).fromNow()}
                </p>
              </Col>
              {msg.from === user.uid && (
                <Col xs="auto">
                  <Image
                    src={user.avatar}
                    roundedCircle
                    style={{ width: "40px", height: "40px" }}
                  />
                </Col>
              )}
            </Row>
          ))}
        </div>
        <Form className="mt-3">
          <Row className="align-items-center">
            <Col>
              <Form.Control
                type="text"
                value={newMessage}
                onChange={(e) => setNewMessage(e.target.value)}
                placeholder="Type a message..."
                className="rounded-pill p-2"
              />
            </Col>
            <Col xs="auto">
              <Button
                variant="primary"
                onClick={sendMessage}
                className="rounded-pill px-3"
              >
                Send
              </Button>
            </Col>
          </Row>
        </Form>
      </div>
    </div>
  );
};

export default CustomerService;
