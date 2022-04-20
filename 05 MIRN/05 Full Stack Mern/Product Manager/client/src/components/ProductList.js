import React from 'react'
import axios from 'axios';
import {
    BrowserRouter,
    Switch,
    Route,
    Link
  } from "react-router-dom";
import DeleteButton from './DeleteButton';
const ProductList = (props) => {
    const { removeFromDom } = props;
    
    const deleteProduct = (productId) => {
        axios.delete('http://localhost:8000/api/product/' + productId)
            .then(res => {
                removeFromDom(productId)
            })
            .catch(err => console.error(err));
    }
    return (
        <div>
            <h2>All Products:</h2>
            {props.product.map( (product, i) =>
            <p key={i}><Link  to={"/product/"+product._id}>{product.title}  </Link>
            |<Link  to={"/product/"+product._id+"/edit"}>Edit</Link>
            |<DeleteButton productId={product._id} successCallback={()=>removeFromDom(product._id)}/>
                </p>
                
            )}
        </div>
    )
}
    
export default ProductList;