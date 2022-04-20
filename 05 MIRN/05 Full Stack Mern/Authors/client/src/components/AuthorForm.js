import React, { useState } from 'react'
import {
    Link
  } from "react-router-dom";
export default (props) => {

    const [name, setName] = useState(props.initialName); 

    const onSubmitHandler = e => {
        e.preventDefault();
        props.authorProp({name})
    }
   
    return (
        <form onSubmit={onSubmitHandler}>
            <p>
                <label>Name:</label><br/>
                <input type="text" onChange={(e)=>setName(e.target.value)} value={name}/>
            </p>
            <input type="submit"/>
            <Link  to={"/author"}> Cancel  </Link>
        </form>
    )
}
