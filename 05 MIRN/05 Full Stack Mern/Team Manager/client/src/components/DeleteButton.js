import React from 'react'
import axios from 'axios';
import Button from '@mui/material/Button';
export default props => {
    
    const { playerId, successCallback } = props;
    
    const deletePlayer = e => {
        if (window.confirm("Are you sure you want to delete " + props.playerName)) {
        axios.delete('http://localhost:8000/api/players/' + playerId)
            .then(res=>{
                successCallback();
                
            })
          }
        
    }
    
    return (
        <Button variant="outlined" color="error" onClick={deletePlayer}>Delete</Button>
        // <button onClick={deleteAuthor}>
        //     Delete
        // </button>
    )
}