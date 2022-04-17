import React, {useState,useEffect} from "react"
import { useHistory } from 'react-router-dom';
const Star = (props) => {
    const [type, setType] = useState("");
    const [id, setId] = useState("");





    return (
        <div>
            
                <p>Search for: </p>
                <select onChange={e => setType(e.target.value)} >
                    <option value="people">Person</option>
                    <option value="planets">Planet</option>
                </select>
                <input onChange={e => setId(e.target.value)} type="number" min={1} />
                <button onClick={() => props.handleClick(type, id)}>Search</button>
           
        </div>
    )
};
export default Star;

