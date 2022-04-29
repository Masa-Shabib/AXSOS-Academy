
import React, { useState } from 'react'
import TextField from '@mui/material/TextField';

const Form = (props) => {
    const [title, setTitle] = useState(); 
    const [date, setDate] = useState(); 
    const onSubmitHandler = e => {
        e.preventDefault();
        props.taskProp({title,date})
        setTitle("")
        setDate("")
        props.setErrors([])
    }
  return (
    <div>
        <form onSubmit={onSubmitHandler}>
        {props.errorpass.map((err, index) => <p key={index}>{err}</p>)}
            <TextField id="outlined-basic" label="Title" variant="outlined" value={title} onChange={(e)=>setTitle(e.target.value)}/>
            <input type="date" onChange={(e)=>setDate(e.target.value)} value={date}></input>
            <input type="submit"/>
         </form>
    </div>
  )
}

export default Form