import React, { useState } from  'react';
import './UserForm.css';
    
const UserForm = () => {
    const [firstrname, setFirstname] = useState("");
    const [lasttrname, setLastname] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [cnPassword, setCnPassword] = useState("");
    
    
    return(
    <div>
        <form  className="form">
            <div>
                <label>First Name:</label> 
                <input type="text" onChange={ (e) => setFirstname(e.target.value) } />
            </div>
            <div>
                <label>Last Name:</label> 
                <input type="text" onChange={ (e) => setLastname(e.target.value) } />
            </div>
            <div>
                <label>Email Address: </label> 
                <input type="text" onChange={ (e) => setEmail(e.target.value) } />
            </div>
            <div>
                <label>Password: </label>
                <input type="text" onChange={ (e) => setPassword(e.target.value) } />
            </div>
            <div>
                <label>Confirm Password: </label>
                <input type="text" onChange={ (e) => setCnPassword(e.target.value) } />
            </div>
        </form>
        <p>First Name: {firstrname}</p>
        <p>Last Name: {lasttrname}</p>
        <p>Email Address: {email}</p>
        <p>Password: {password}</p>
        <p>Confirm Password: {cnPassword}</p>
    </div>
    );
};
    
export default UserForm