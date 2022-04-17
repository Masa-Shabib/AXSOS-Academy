import axios from 'axios'
import React, { useEffect, useState } from 'react'
import {useParams} from 'react-router';

const Planet = (props) => {
    // CREATE STATE VARIABLE
    const [planets, setPlanets] = useState([])
    // THIS IS DESTRUCTURING INPUT MAYBE??
    const {input1} = useParams();

    // USEEFFECT TO RUN ON FIRST RENDER INSTEAD OF NEEDING TO CLICK A BUTTON
    useEffect( () => {
        axios.get(`https://swapi.dev/api/planets/${input1}`)
        .then(response => {
            console.log(response.data);
            setPlanets(response.data)
        })
        .catch(error => {
            console.log(error);
            setPlanets({error: "These aren't the droids you're looking for..."})
        })
    }, [input1]);

    return (
        planets.error ?
        <p>{planets.error} <br/>
            <img src="https://placekeanu.com/150/200" alt="Obi Wan" />
        </p> :
        <div>
            <h1>{planets.name}</h1>
            <p>Climate: {planets.climate}</p>
            <p>Terrain: {planets.terrain}</p>
            <p>Surface Water: {}</p>
            <p>Populattion: {planets.population}</p>
        </div>
    )
}

export default Planet