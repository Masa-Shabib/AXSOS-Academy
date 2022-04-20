import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams,useNavigate } from "react-router-dom";
import ProductForm from '../components/ProductForm';
import DeleteButton from '../components/DeleteButton';
    
const Update = (props) => {
    let navigate = useNavigate();
    const { id } = useParams();
    const [product,setProduct]=useState();
    const [loaded, setLoaded] = useState(false);
    useEffect(() => {
        axios.get('http://localhost:8000/api/product/' + id)
            .then(res => {
                setProduct(res.data);
                setLoaded(true);
            })
    }, []);
    
    const updateProduct = product => {
       
        axios.put('http://localhost:8000/api/product/' + id, product)
            .then(res => {console.log(res);navigate("/product")})
            .catch(err => console.error(err));
    }
    
    return (
        <div>
                   { loaded && (
                       <>
                   <ProductForm productProp={updateProduct} initialTitle={product.title} initialDesc={product.desc} initialPrice={product.price} />
                   <DeleteButton productId={product._id} successCallback={()=>navigate("/product")}/></>)}
        </div>
    )
}
    
export default Update;