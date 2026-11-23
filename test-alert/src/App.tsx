import { useState } from 'react'
import heroImg from './assets/hero.png'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import './App.css'
import {Prueba} from './Prueba'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <h1>Practica 03.02. Aislamiento de Componentes y </h1>
            <h1>Documentación con Storybook</h1>
      <Prueba/>
    </>
  )
}

export default App
