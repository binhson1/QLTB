// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getFirestore } from "firebase/firestore";
import { getAuth } from "firebase/auth";
import firebase from "firebase/compat/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyD5FOE3j4APbOyWjrqaIYdGcR2cj36CiiA",
  authDomain: "device-app-5a68d.firebaseapp.com",
  projectId: "device-app-5a68d",
  storageBucket: "device-app-5a68d.appspot.com",
  messagingSenderId: "758950222028",
  appId: "1:758950222028:web:02431202bc16c6cc40ca69",
  measurementId: "G-481TTTV8MR",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

export const db = getFirestore(app);
export const auth = getAuth(app);
