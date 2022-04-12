import React, { useState } from "react";
import './display.css';
const Display=(props)=>{

return (
    <div className="boxes">

        {props.boxes.map((box,i) =>
            <div className="box"
            key={i}
            style={{
                backgroundColor:box[0],
                width:box[1]+"px",
                height:box[1]+"px",

            }}
            ></div>
            
        )}
            </div>
)


}
export default Display
