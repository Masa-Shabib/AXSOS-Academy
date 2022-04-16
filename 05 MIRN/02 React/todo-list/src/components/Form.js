import React, { useState } from "react";

const Form = (props) => {
    const [todo, setTodo] = useState([]);
    const [note, setNote] = useState("");
    const todoItem={
        text:note,
        status:false
    }
    const submitt = (e) => {
        e.preventDefault();
        if(note.length == 0){
            return;
        }
        setTodo(todo.concat(todoItem));
        console.log(todoItem)
        console.log(todo)
        setNote("");
    };
    const deletetodo=(e,i)=>{
        e.preventDefault();
        const filterdArr= todo.filter((todo,ind)=>{
            return i != ind;
        });
        setTodo(filterdArr)

    }
     const handelstatus = (e,i) => {
         e.preventDefault();
         const newArr= todo.map((todo,ind)=>{
            if(i == ind ){
                todo.status = !todo.status
            }
            return todo;
        });
        setTodo(newArr)
        console.log(todo[i])
     };
    return (
        <div>
        <form onSubmit={submitt}>
            <div>
                <input type="text" placeholder="Todo" onChange={(e) =>setNote(e.target.value)} value={note} />
                <input type="submit" Submit/>
            </div>
        </form>
        <div>
            <ul>
        {todo.map((item,i) =>{
        <li key={i}>
            <div>
            <input type="checkbox" checked={item.status} onChange={(e) => handelstatus(e, i)} />
                {item.text}  <button onClick={(e) => deletetodo(e, i)}>Delete</button>
                </div>
        </li>
})}
            </ul>
        </div>
        </div>
    )
    
};
export default Form;

