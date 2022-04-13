import React, {useState,useEffect} from "react"
const Poke = (props) => {
    const [result, setResult] = useState([]);
    const [pokemon, setPokemon] = useState([]);
 
    useEffect(() => {
        fetch('https://pokeapi.co/api/v2/pokemon')
            .then(response => response.json())
            .then(response => setResult(response.results))
            .catch(err=>{
                console.log(err);
            });
            // 
    }, []);
    const handelClick=()=>{
        setPokemon(result)
    }
    return (
        <div>
            <button onClick={handelClick}>Fetch pokemon</button>
            {pokemon.length > 0 && pokemon.map((pokemon, index)=>{
                return (<div key={index}>{pokemon.name}</div>)
            })}
        </div>
    );
}
export default Poke;
