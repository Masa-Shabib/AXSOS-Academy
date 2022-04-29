
import Form from '../components/Form'
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import TaskList from '../components/TaskList';
import { padding } from '@mui/system';
const Main = () => {
  const [tasks, setTasks] = useState([]);
  const [errors, setErrors] = useState([]); 
    const [loaded, setLoaded] = useState(false);
  useEffect(()=>{
    axios.get('http://localhost:8000/api/task')
        .then(res=>{
          setTasks(res.data);
            setLoaded(true);
        })
        .catch(err => console.error(err));
},[]);
const removeFromDom = taskId => {
  setTasks(tasks.filter(task => task._id != taskId));
}
const createTask = task => {

    console.log(task)
    axios.post('http://localhost:8000/api/task', task)
        .then(res=>{setTasks([...tasks,res.data]);console.log(res.data)})
        .catch(err=>{
          const errorResponse = err.response.data.errors; // Get the errors from err.response.data
          const errorArr = []; // Define a temp error array to push the messages in
          for (const key of Object.keys(errorResponse)) { // Loop through all errors and get the messages
              errorArr.push(errorResponse[key].message)
          }
          // Set Errors
          setErrors(errorArr);
      })       
}

const update = (id,stat)=>{
  axios.put('http://localhost:8000/api/task/'+id,{status:stat})
        .then(res=>{
          const objIndex = tasks.findIndex(obj=>obj._id === id)
          const tasks1=[...tasks.slice(0,objIndex),{...tasks[objIndex],"status":stat},...tasks.slice(objIndex+1)]
          console.log(tasks1)
          setTasks(tasks1)
        })
        .catch(err => console.error(err));
}
var newTask=[]
var inprogressTask=[]
var doneTask=[]
tasks.map(task=>{
  if(task.status==="todo"){
    newTask.push(task)
  }else if(task.status==="inprogress"){
    inprogressTask.push(task)
  }else{
    doneTask.push(task)
  }
})
        
      
  return (
    <div>
      <h1>Project Mnager</h1>
      <Form  taskProp={createTask}  errorpass={errors} setErrors={setErrors}/>
      <div  style={{margin:"0 auto", width:"100%" , display:"flex", padding:"10px" }}>
        <div  style={{margin:"0 auto", width:"25%",border:"solid black 1px", padding:"10px" }}>
      <TaskList tasks={newTask} removeFromDom={removeFromDom} update={update}/>
      </div>
      <div  style={{margin:"0 auto", width:"25%",border:"solid black 1px", padding:"10px"  }}>
      <TaskList tasks={inprogressTask} removeFromDom={removeFromDom} update={update}/>
      </div>
      <div  style={{margin:"0 auto", width:"25%" ,border:"solid black 1px", padding:"10px" }}>
      <TaskList tasks={doneTask} removeFromDom={removeFromDom} update={update}/>
      </div>
      </div>
    </div>
  )
}

export default Main