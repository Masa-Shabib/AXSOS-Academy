import React, { useEffect, useState } from 'react'
import axios from 'axios';
import ProductForm from '../components/ProductForm';
export default () => {
    // useEffect(()=>{
    //     axios.get("http://localhost:8000/api")
    //         .then(res=>setMessage(res.data.message))       
    // }, []);
    return (
        <div>
        <ProductForm/>
        </div>
    )
}