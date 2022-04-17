
import './App.css';
import { useHistory } from 'react-router-dom';
import {
  BrowserRouter,
  Switch,
  Route,
} from "react-router-dom";
import Star from './components/Star';
import People from './components/People';
import Planets from './components/Planets';

function App() {
  const history = useHistory();
  const handleClick = (selected, number) => {
        console.log(`/${selected}/${number}`);
        history.push(`/${selected}/${number}`);
  }
  return (
      <BrowserRouter>
    <div className="App">
      <Star handleClick={handleClick} />
      <Switch>
        <Route path="/people/:id" >
        <People/>
        </Route>
        <Route path="/planets/:id" >
        <Planets />
        </Route>
      </Switch>
    </div>
    </BrowserRouter>
  );
}


export default App;
