import React from 'react'
import axios from 'axios';
import Button from '@mui/material/Button';
export default props => {
    
    const { authorId, successCallback } = props;
    
    const deleteAuthor = e => {
        axios.delete('http://localhost:8000/api/author/' + authorId)
            .then(res=>{
                successCallback();
            })
    }
    
    return (
        <Button variant="outlined" color="error" onClick={deleteAuthor}>Delete</Button>
        // <button onClick={deleteAuthor}>
        //     Delete
        // </button>
    )
}