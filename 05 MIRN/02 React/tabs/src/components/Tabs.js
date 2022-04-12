import React,{useState}from 'react'
import './tabs.css';
const Tabs = (props) => {
    const [tabName,setName]=useState("")
    const handelName=(e,name)=>{
        setName(name +" content is showing")
    }
  return (
    <div>
        <ul>
        {props.items.map((item,i) =>
            <li key={i} onClick={(e) => handelName(e, item)} value={item}>
                <button type="button" class="btn btn-outline-dark">{item}</button>
            </li>
            
        )}
        </ul>
        <p>{tabName}</p>
    </div>
  )
}

export default Tabs