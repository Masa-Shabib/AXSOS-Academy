import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router';

const People = (props) => {
    // CREATE STATE VARIAVLE
    const [peoples, setPeoples] = useState([])
    // DESTRUCTURE INPUT??
    const { input1 } = useParams();

    // USEEFFECT SO YOU DON'T NEED TO CLICK A BUTTON FOR AXIOS.GET??
    useEffect(() => {
        axios.get(`https://swapi.dev/api/people/${input1}`)
            .then(response => {
                console.log(response.data);
                setPeoples(response.data)
            })
            .catch(error => {
                console.log(error);
                setPeoples({ error: "These aren't the droids you're looking for..." })
            })
    }, [input1]);

    return (
        peoples.error ?
        <p>{peoples.error} <br/>
            <img src="https://placekeanu.com/150/200" alt="Obi Wan" /> 
        </p>
        :
        <div>
            <h1>{peoples.name}</h1>
            <p>Height: {peoples.height}</p>
            <p>Mass: {peoples.mass}</p>
            <p>Hair Color: {peoples.hair_color}</p>
            <p>Skin Color: {peoples.skin_color}</p>
        </div>
    )
}

export default People