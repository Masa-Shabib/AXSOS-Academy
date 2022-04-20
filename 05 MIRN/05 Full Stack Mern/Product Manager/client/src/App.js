import React from 'react';
import Main from './views/Main';
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import Detail from './views/Detail';
import Update from './views/Update';
function App() {
  return (
    <BrowserRouter>
    <div className="App">
    <Routes>
      <Route exact path="/product/" element={ <Main />} />
      <Route exact path="/product/:id" element={<Detail />}/>
      <Route path="/product/:id/edit" element={<Update />}/>
      </Routes>
    </div>
  </BrowserRouter>
  );
}
export default App;
