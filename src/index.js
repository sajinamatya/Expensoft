// For Firebase JS SDK v7.20.0 and later, measurementId is optional
import {initializeApp}  from 'firebase/app'
import{
getFirestore, collection,getDocs,addDocs
} from 'firebase/firestore'

const firebaseConfig = {
  apiKey: "AIzaSyAy5F4XmwU-n0PWPhNNwhOEfz7cDiF3JsQ",
  authDomain: "sajin-b7a9f.firebaseapp.com",
  projectId: "sajin-b7a9f",
  storageBucket: "sajin-b7a9f.appspot.com",
  messagingSenderId: "98367795533",
  appId: "1:98367795533:web:5bf50e138df210fb038704",
  measurementId: "G-HER1R6E9CX"
};
// initlalize the firebase
initializeApp(firebaseConfig)

// initialize  firestore the services
const db = getFirestore()
// collection ref
const colRef = collection(db,'books')
// getting collection data



