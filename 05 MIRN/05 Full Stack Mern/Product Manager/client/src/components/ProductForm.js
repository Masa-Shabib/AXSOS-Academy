import React, { useState } from 'react'
import axios from 'axios';
export default (props) => {
    //keep track of what is being typed via useState hook
    const [title, setTitle] = useState(props.initialTitle); 
    const [desc, setDesc] = useState(props.initialDesc); 
    const [price, setPrice] = useState(props.initialPrice);
    //handler when the form is submitted
    const onSubmitHandler = e => {
        e.preventDefault();
        props.productProp({title,desc,price})
    }
   
    return (
        <form onSubmit={onSubmitHandler}>
            <p>
                <label>Title</label><br/>
                <input type="text" onChange={(e)=>setTitle(e.target.value)} value={title}/>
            </p>
            <p>
                <label>Price</label><br/>
                <input type="number" onChange={(e)=>setPrice(e.target.value)} value={price}/>
            </p>
            <p>
                <label>Descreption</label><br/>
                <textarea onChange={(e)=>setDesc(e.target.value)} value={desc}></textarea>
            </p>
            <input type="submit"/>
        </form>
    )
}
