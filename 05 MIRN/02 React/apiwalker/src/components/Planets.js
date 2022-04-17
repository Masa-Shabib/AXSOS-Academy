
import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
const Planets = (props) => {
  const { id } = useParams();
  const [responseData, setResponseData] = useState([]);
  
  useEffect(() => {
      axios.get('https://swapi.dev/api/planets/' + id)
          .then(response => { setResponseData(response.data) })
  }, [id]);
  return (
    <div>
    <h3>{responseData.name}</h3>
    <p>Climate: {responseData.climate} </p>
    <p>Terrain: {responseData.terrain}</p>
    <p>Surface Water: {responseData.surface_water}</p>
    <p>Population: {responseData.population}</p>
</div>
  )
}

export default Planets