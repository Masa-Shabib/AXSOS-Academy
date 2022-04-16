
import './App.css';
import {
  BrowserRouter,
  Link ,
  Switch,
  Route,
} from "react-router-dom";
import Home from './components/Home';
import Word from './components/Word';
import Color from './components/Color';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Switch>
        <Route path="/home">
          <Home/>
        </Route>
        <Route exact path="/:word">
          <Word/>
        </Route>
        <Route exact path="/:word/:col1/:col2">
          <Color/>
        </Route>
      </Switch>
    </BrowserRouter>
    </div>
  );
}

export default App;
