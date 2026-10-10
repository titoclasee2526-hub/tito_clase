import React from 'react';
import logo from './logo.svg';
import './App.css';
import ComponenteApp from './ComponenteApp';

import Operacion from './Operacion';
import Practica10 from './Practica10';
import Practica14 from './Practica14';
import Practica21 from './Practica21';

function App() {
  return (
    <div className="App">
      <h3>Hola</h3>
      <ComponenteApp/>
      <Operacion num1={25} num2 = {3}/>

      <Practica10 tabla={1}/>
      <Practica14/>
      <Practica21/>
      </div>
  );
}

export default App;
