import React, {useState} from 'react';
import { useHistory } from 'react-router-dom';

const Form = (props) => {
    const [category, setCategory] = useState("");
    const [id, setId] = useState("");
    const history = useHistory();

    const submitForm = (e) => {
        e.preventDefault();
        console.log(category + ":" + id);
        history.push(`/${category}/${id}`)
        // setCategory("");
        // setId("");
    };

    return (
        <div>
            <form onSubmit={submitForm}>
                <label>Search for: </label>
                <select onChange={ (e) => setCategory(e.target.value)}>
                    <option disabled selected>--Select a Category--</option>
                    <option value="Planets">Planets</option>
                    <option value="People">People</option>
                </select>
                <label>ID: </label>
                <input type="number" onChange={ (e) => setId(e.target.value)} value={id}/>
                <button>Submit</button>
            </form>
        </div>
    )
}

export default Form