import React from 'react'
import { useParams } from "react-router";
const Word = (props) => {
    const { word } = useParams();
  return (
    <div>
        {(isNaN(word))?<p>The word is: {word}</p>:<p>The num is: {word}</p>}
    </div>
  )
}

export default Word