import logo from './logo.svg';
import './App.css';
import React from 'react';
import Main from './views/Main';
import Detail from './views/Detail';
import Update from './views/Update';
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import Create from './views/Create';
function App() {
  return (
    <div className="App">
<BrowserRouter>
    <div className="App">
    <Routes>
      <Route path="/author/" element={ <Main />} />
      <Route path="/author/new" element={ <Create />} />
      <Route path="/author/:id" element={<Detail />}/>
      <Route path="/author/:id/edit" element={<Update />}/>
      </Routes>
    </div>
  </BrowserRouter>
    </div>
  );
}

export default App;
