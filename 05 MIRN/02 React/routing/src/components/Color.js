import React from 'react'
import { useParams } from "react-router";
const Color = (props) => {
    const { word } = useParams();
    const { col1 } = useParams();
    const { col2 } = useParams();
  return (
    <div>
        {(isNaN(word))?<p style={{color: col2, backgroundColor:col1}}>The word is: {word}</p>:<p style={{color: {col2}, backgroundColor:{col1}}}>The num is: {word}</p>}

    </div>
  )
}

export default Color