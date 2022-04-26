import React, { useEffect, useState } from 'react'
import axios from 'axios';
import {
    Link
  } from "react-router-dom";
import PlayersList from '../components/PlayersList';
import Header from '../components/Header';
export default (props) => {
    const [player, setPlayer] = useState([]);
    const [loaded, setLoaded] = useState(false);
    
    useEffect(()=>{
        axios.get('http://localhost:8000/api/players/list')
            .then(res=>{
                setPlayer(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    },[]);
    const removeFromDom = playerId => {
        setPlayer(player.filter(player => player._id != playerId));
    }
    
    return (
        <div className="App">
           {loaded && <PlayersList player={player} removeFromDom={removeFromDom}/>}
        </div>
    )
}