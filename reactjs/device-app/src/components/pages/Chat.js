import { Navigate, useParams } from "react-router";
import {
  Card,
  ListGroup,
  Button,
  Form,
  Row,
  Col,
  Image,
} from "react-bootstrap";
import moment from "moment";
import cookie from "react-cookies";
import React, { useContext, useState, useEffect, useRef } from "react";
import {
  addDoc,
  collection,
  onSnapshot,
  orderBy,
  query,
  where,
  getDocs,
  Timestamp,
  getDoc,
  updateDoc,
  doc,
  arrayUnion,
  serverTimestamp,
} from "firebase/firestore";
import { db } from "../../configs/FireBase";
import { MyUserContext } from "../../App";

const Chat = () => {
  const user = useContext(MyUserContext);
  const { id } = useParams();
  const [chatData, setChatData] = useState([]);
  const [newMessage, setNewMessage] = useState("");
  const [userInfo, setUserInfo] = useState({});
  const [otherUserInfo, setOtherUserInfo] = useState({});
  const chatEndRef = useRef(null);

  useEffect(() => {
    if (!user?.uid || !id) return;

    fetchUserInfo();
    fetchOtherUserInfo();
  }, [user]);

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
        const chatDataRef = query(
          collection(db, "User-Chat", chatDoc.id, "Chat"),
          orderBy("created_date")
        );
        const chatDataSnapshot = await getDocs(chatDataRef);
        const chatData = chatDataSnapshot.docs.map((doc) => doc.data());
        console.log("Updated chat data:", chatData);
        setChatData(chatData);
      }
    });

    return () => unsubscribe();
  };

  const fetchUserInfo = async () => {
    const userQuery = query(
      collection(db, "User-Info"),
      where("uid", "in", [user.uid])
    );
    const userSnapshot = await getDocs(userQuery);
    if (!userSnapshot.empty) {
      setUserInfo(userSnapshot.docs[0].data());
    }
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
          const chatDataRef = collection(db, "User-Chat", chatDoc.id, "Chat");
          await addDoc(chatDataRef, {
            created_date: Timestamp.fromDate(new Date()),
            from: user.uid,
            messages: newMessage,
          });
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

  useEffect(() => {
    if (user) {
      fetchOtherUserInfo();
      fetchUserInfo();
      scrollToBottom();
    }
  }, []);

  useEffect(() => {
    loadChat();
  }, [user]);

  if (user === null) return <Navigate to="/login"></Navigate>;

  return (
    <div className="col-10 container">
      <div
        className="overflow-y-auto"
        ref={chatEndRef}
        style={{ maxHeight: "665px", padding: "10px", overflowX: "hidden" }}
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
                  maxWidth: "200px",
                  padding: "10px",
                  borderRadius: "10px",
                  backgroundColor:
                    msg.from === user.uid ? "#007bff" : "#e5e5e5",
                  color: msg.from === user.uid ? "white" : "black",
                }}
              >
                {msg.messages}
              </div>
            </Col>
            {msg.from === user.uid && (
              <Col xs="auto">
                <Image
                  src={userInfo.avatar}
                  roundedCircle
                  style={{ width: "40px", height: "40px" }}
                />
              </Col>
            )}
          </Row>
        ))}
        <div />
      </div>
      <Form className="mt-3">
        <Row>
          <Col>
            <Form.Control
              type="text"
              value={newMessage}
              onChange={(e) => setNewMessage(e.target.value)}
              placeholder="Type a message..."
            />
          </Col>
          <Col xs="auto">
            <Button variant="primary" onClick={sendMessage}>
              Send
            </Button>
          </Col>
        </Row>
      </Form>
    </div>
  );
};

export default Chat;
