import React, { useState } from "react";

const Form = (props) => {
    const [color, setColor] = useState("");
    const [dim, setDim] = useState(0);
    const submitt = (e) => {
        e.preventDefault();
        props.box(color,dim);
        setColor("");
        setDim(0);
    };
    return (
        <div>

        <form onSubmit={submitt}>
            <div>
                <input type="text" placeholder="color" onChange={(e) =>setColor(e.target.value) }  value={color}/>
                <input type="number" onChange={(e) =>setDim(e.target.value) }  value={dim}/>
                <input type="submit" Submit/>
            </div>
        </form>
        </div>
    )
    
};
export default Form;

