import React, { useState } from 'react';
import Animales from './Animales';
import GestionArrayMiercoles21 from './GestionArrayMiercoles21';

import Practica10 from './Practica10';
import Practica14 from './Practica14';
import Practica21 from './Practica21';
import Frutas from './Frutas'
import Biblioteca from './Biblioteca';


type Practica = {
  nombre: string;
  componente: React.ComponentType;
};

const practicas: Practica[] = [
  { nombre: 'Animales', componente: Animales },
  { nombre: 'Gestión Array Miércoles 21', componente: GestionArrayMiercoles21 }, 
  { nombre: 'Práctica 14', componente: Practica14 },
  { nombre: 'Práctica 21', componente: Practica21 },
  {nombre : 'Frutas', componente: Frutas},
  {nombre: 'Biblioteca', componente: Biblioteca}
  
];

const App: React.FC = () => {
  // índice de la práctica seleccionada, o 'todas' para verlas apiladas
  const [seleccion, setSeleccion] = useState<number | 'todas'>('todas');

  const estiloBoton = (activo: boolean): React.CSSProperties => ({
    padding: '8px 14px',
    border: '1px solid #888',
    borderRadius: 6,
    cursor: 'pointer',
    background: activo ? '#2563eb' : '#f3f4f6',
    color: activo ? '#fff' : '#111',
  });

  return (
    <div style={{ padding: 16 }}>
      <nav
        style={{
          display: 'flex',
          flexWrap: 'wrap',
          gap: 8,
          marginBottom: 24,
          position: 'sticky',
          top: 0,
          background: '#fff',
          padding: '8px 0',
          zIndex: 10,
        }}
      >
        <button
          style={estiloBoton(seleccion === 'todas')}
          onClick={() => setSeleccion('todas')}
        >
          Ver todas
        </button>
        {practicas.map((p, i) => (
          <button
            key={p.nombre}
            style={estiloBoton(seleccion === i)}
            onClick={() => setSeleccion(i)}
          >
            {p.nombre}
          </button>
        ))}
      </nav>

      {seleccion === 'todas' ? (
        practicas.map(({ nombre, componente: Componente }) => (
          <section
            key={nombre}
            style={{
              border: '1px solid #ddd',
              borderRadius: 8,
              padding: 16,
              marginBottom: 24,
            }}
          >
            <h2>{nombre}</h2>
            <Componente />
          </section>
        ))
      ) : (
        (() => {
          const { nombre, componente: Componente } = practicas[seleccion];
          return (
            <section>
              <h2>{nombre}</h2>
              <Componente />
            </section>
          );
        })()
      )}
    </div>
  );
};

export default App;