import logo from './logo.svg';
import './App.css';
import React, { useState } from 'react';
import {
  BrowserRouter,
  Switch,
  Route,
} from "react-router-dom";
import Survey from './components/Survay';
import Foo from './components/Foo';
function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Survey />
        <Switch>
          <Route path="/results">
            <Foo/>
          </Route>
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
