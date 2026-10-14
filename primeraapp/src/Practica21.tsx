import { normalize } from 'path';
import React, { useState, useEffect } from 'react';

const Practica21 = () => {
  const [secreto, setSecreto] = useState<number>(0);
  const nombre : string = "Ludopatia"
  const [mensaje, setMensaje] = useState<string[]>([nombre]);

  useEffect(() => {
    const aleatorio = Math.floor(Math.random() * 10);
    setSecreto(aleatorio);
  }, []);

  const apostar = (num: number) => {
    let mensaje = "";
    if (num === secreto) {
      mensaje = "Acertaste:" + {num};
    } else if (num < secreto) {
      mensaje = {num}+"< secreto";
    } else {
      mensaje = {num} +"> secreto";
    }
    
    setMensaje([mensaje]);
  };

  const botones = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

  return (
    <div>
      <h2>Acertar número</h2>
      
      <div>
        {botones.map((num) => (
          <button key={num} onClick={() => apostar(num)}>
            {num}
          </button>
        ))}
      </div>
      
      <br />
      
      <div>
        {JSON.stringify(mensaje)}
      </div>
    </div>
  );
};

export default Practica21;