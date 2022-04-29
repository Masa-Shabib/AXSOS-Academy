import React from 'react'
import axios from 'axios';
const TaskList = (props) => {
    const deleteTask = id => {
        axios.delete('http://localhost:8000/api/task/' + id)
            .then(res=>{
                props.removeFromDom(id);
                
            })
          
        
    }
  return (
    <div>
        {props.tasks.map((task, index) => 
        <div key={index}>
        <p >{task.title} </p>
        <button onClick={(e)=>task.status === "todo"?props.update(task._id,"inprogress"):task.status === "inprogress"?props.update(task._id,"done"):deleteTask(task._id)}>
        {task.status === "todo"?"move to progress":task.status === "inprogress"?"move to done":"delet"}</button></div>)}
    </div>
  )
}

export default TaskList