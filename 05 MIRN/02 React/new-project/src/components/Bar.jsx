import React from 'react'
import {
    useHistory
  } from "react-router-dom";



const Bar = () => {
    const history = useHistory();
    console.log(history)
    return (
        
        <>
            <p>bar</p>
            <p onClick={() => {history.push("/foo"); console.log(history);}}>foo</p>
        </>

    )
}

export default Bar

  