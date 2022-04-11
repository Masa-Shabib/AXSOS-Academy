import React, { useState } from  'react';
import './UserForm.css';
    
const UserForm = () => {
    const [firstrName, setFirstName] = useState("");
    const [firstrNameError, setFirstNameError] = useState("");

    const [lastName, setLastName] = useState("");
    const [lastNameError, setlastNameError] = useState("");

    const [email, setEmail] = useState("");
    const [emailError, setEmailError] = useState("");

    const [password, setPassword] = useState("");
    const [passwordError, setPasswordError] = useState("");

    const [cnPassword, setCnPassword] = useState("");
    const [cnPasswordError, setCnPasswordError] = useState("");


    const handleFirstName = (e) => {
        if(e.target.value.length < 2) {
            setFirstNameError("First Name must be 2 characters or longer!");
        }else{
            setFirstNameError("")
            setFirstName(e.target.value);
        }
    }
    const handleLastName = (e) => {
        if(e.target.value.length < 2) {
            setlastNameError("Last Name must be 2 characters or longer!");
        }else{
            setlastNameError("")
            setLastName(e.target.value);
        }
    }
    const handleEmail = (e) => {
        if(e.target.value.length < 5) {
            setEmailError("Email must be 5 characters or longer!");
        }else{
            setEmailError("")
            setEmail(e.target.value);
        }
    }
    const handlePassword = (e) => {
        if(e.target.value.length < 8) {
            setPasswordError("Password must be 8 characters or longer!");
        }else{
            setPasswordError("")
            setPassword(e.target.value);
        }
    }
    const handleCnPassword = (e) => {
        if(e.target.value.length < 8) {
            setCnPasswordError("Password must be 8 characters or longer!");
        }else if(e.target.value != password){
            setCnPasswordError("Passwords must match!");
        }
        else{
            setCnPasswordError("")
            setCnPassword(e.target.value);
        }
    }
    
    return(
    <div>
        <form  className="form">
            <div>
                <label>First Name:</label> 
                <input type="text" onChange={ handleFirstName } />
            </div>
            <p style={{color:'red'}}>{ firstrNameError }</p>
            <div>
                <label>Last Name:</label> 
                <input type="text" onChange={ handleLastName }  />
            </div>
            <p style={{color:'red'}}>{ lastNameError }</p>
            <div>
                <label>Email Address: </label> 
                <input type="text" onChange={ handleEmail } />
            </div>
            <p style={{color:'red'}}>{ emailError }</p>
            <div>
                <label>Password: </label>
                <input type="text" onChange={ handlePassword } />
            </div>
            <p style={{color:'red'}}>{ passwordError }</p>
            <div>
                <label>Confirm Password: </label>
                <input type="text" onChange={handleCnPassword} />
            </div>
                <p style={{color:'red'}}>{ cnPasswordError }</p>
        </form>
        <p>First Name: {firstrName}</p>
        <p>Last Name: {lastName}</p>
        <p>Email Address: {email}</p>
        <p>Password: {password}</p>
        <p>Confirm Password: {cnPassword}</p>
    </div>
    );
};
    
export default UserForm