// Importamos React y el hook useState para manejar estado dentro del componente
import React, { useState } from 'react';

// Definimos los tipos de las props que recibe el componente (TypeScript).
// "tabla" es el número de la tabla de multiplicar (por ejemplo, 5 para la tabla del 5)
type Props = {
  tabla: number;
}

// Componente que muestra UNA tabla de multiplicar con un botón para avanzar
const Practica10 = (props: Props) => {
  // Estado "multiplicador": guarda por qué número estamos multiplicando ahora.
  // - multiplicador: valor actual (empieza en 1)
  // - setMultiplicador: función para cambiarlo (al cambiarlo, React vuelve a pintar el componente)
  
  const [multiplicador, setMultiplicador] = useState(1);

  // Función que se ejecuta al pulsar el botón
  const manejarClick = () => {
    if (multiplicador >= 10) {
      // Si ya llegamos a 10, volvemos a empezar desde 1
      setMultiplicador(1);
    } else {
      // Si no, sumamos 1 al multiplicador actual
      setMultiplicador(multiplicador + 1);
    }
  };

  // Calcula el número que se mostrará en el botón (el siguiente multiplicador).
  // Usa el operador ternario: condición ? valorSiVerdadero : valorSiFalso
  // Si estamos en 10, el siguiente es 1; si no, es el actual + 1.
  const siguienteMultiplicador = multiplicador >= 10 ? 1 : multiplicador + 1;

  return (
    // Contenedor con estilos en línea: una "tarjeta" con borde, centrada y con márgenes
    <div style={{ display: 'inline-block', border: '1px solid black', padding: '10px', margin: '5px', textAlign: 'center' }}>
      {/* Título con el número de la tabla que recibimos por props */}
      <h4>Tabla del {props.tabla}</h4>

      {/* Muestra la operación actual y su resultado, ej: 5 * 3 = 15 */}
      <p>{props.tabla} * {multiplicador} = {props.tabla * multiplicador}</p>

      {/* Botón que avanza al siguiente multiplicador. 
          Su texto muestra la operación que aparecerá al pulsarlo (ej: 5 * 4) */}
      <button onClick={manejarClick}>
        {props.tabla} * {siguienteMultiplicador}
      </button>
    </div>
  );
}

// Componente que muestra TODAS las tablas (del 2 al 10) usando Practica10
const TodasLasTablas = () => {
  // Array con los números de las tablas que queremos mostrar
  let arr: Array<number> = [2, 3, 4, 5, 6, 7, 8, 9, 10];

  return (
    <div>
      {
        // map recorre el array y devuelve un componente Practica10 por cada número.
        // - el: el número de la tabla (2, 3, 4...)
        // - idx: la posición en el array
        // "key" es obligatoria en listas de React para identificar cada elemento.
        // "tabla" es la prop que le pasamos a cada Practica10.
        arr.map((el, idx) => (
          <Practica10 key={idx} tabla={el} />
        ))
      }
    </div> 
  );
}

// Exportamos el componente por defecto para poder importarlo desde otros archivos
export default Practica10;