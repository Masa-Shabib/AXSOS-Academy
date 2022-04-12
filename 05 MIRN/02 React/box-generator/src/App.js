
import './App.css';
import Form from "./components/Form"
import React, { useState } from "react";
import Display from "./components/Display"


function App() {
  const [boxes, setBoxes] = useState([]);
  
  const createbox = (color,dim) => {
    setBoxes(boxes.concat([[color,dim]]))
  }



  return (
    <div className='App'>
      <Form box={createbox}/>
      <Display boxes={boxes}/>

    </div>
  );
}

export default App;


