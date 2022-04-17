
import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
const People = (props) => {
  const { id } = useParams();
  const [responseData, setResponseData] = useState([]);
  
  useEffect(() => {
      axios.get('https://swapi.dev/api/people/' + id)
          .then(response => { setResponseData(response.data) })
  }, [id]);
  return (
    <div>
    <p>Person ID: {id}</p>

    <h1>{responseData.name}</h1>
    <h3>Height:   {responseData.height} cm</h3>
    <h3>Mass:   {responseData.mass} kg</h3>
    <h3>Eye Color:   {responseData.eye_color}</h3>
    <h3>Birth Year:   {responseData.birth_year}</h3>


</div>
  )
}

export default People