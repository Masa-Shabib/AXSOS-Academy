import React, { useState } from 'react'
import {
    Link
  } from "react-router-dom";
  import TextField from '@mui/material/TextField';
  import Button from '@mui/material/Button';
export default (props) => {
    const [name, setName] = useState(props.initialName); 
    const [position, setPosition] = useState(props.initialPosition); 

    const onSubmitHandler = e => {
        e.preventDefault();
        props.playerProp({name,position})
    }
   
    return (
        <form onSubmit={onSubmitHandler}>
            {props.errorpass.map((err, index) => <p key={index}>{err}</p>)}
            <p>
                <TextField id="outlined-basic" label="Name:" variant="outlined" onChange={(e)=>setName(e.target.value)} value={name}/>
            </p>
            <p>
            <TextField id="outlined-basic" label="Position:" variant="outlined"  onChange={(e)=>setPosition(e.target.value)} value={position}/>
            </p>
            <input type="submit"/>
            <Button variant="outlined" size="medium">
            <Link  to={"/players/list"}> Cancel  </Link>
        </Button>
            
        </form>
    )
}
