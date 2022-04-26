import logo from './logo.svg';
import './App.css';
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import React from 'react';
import Main from './views/Main';
import Create from './views/Create';
import Header from './components/Header';
import PlayerStatus from './components/PlayerStatus';
import PlayerStatus2 from './components/PlayerStatus2';
import PlayerStatus3 from './components/PlayerStatus3';

function App() {
  return (
    <div className="App">
    <BrowserRouter>
        <div className="App">
        <Header/>
        <Routes>
          <Route path="/players/list" element={ <Main/>} />
          <Route path="/players/addplayer" element={ <Create/>} />
          <Route path="/status/game/1" element={ <PlayerStatus />} />
          <Route path="/status/game/2" element={ <PlayerStatus2 />} />
          <Route path="/status/game/3" element={ <PlayerStatus3/>} />

          </Routes>
        </div>
      </BrowserRouter>
        </div>
  );
}

export default App;
