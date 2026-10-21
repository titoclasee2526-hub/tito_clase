
import React, { useState, useEffect } from 'react';

type Animales = {
    nombreAnimal: string;
    definicion: string;
}

const animales: Animales[] = [ //Define el array de los animales con sus nombres y definiciones
    {
        nombreAnimal: "León",
        definicion:
            'Felino de gran tamaño conocido como el "rey de la selva", donde los machos poseen una gran melena y las hembras se encargan de la mayor parte de la caza en grupo.',
    },
    {
        nombreAnimal: "Elefante",
        definicion:
            "Mamífero terrestre de gran tamaño caracterizado por una larga trompa prensil, grandes orejas y colmillos de marfil.",
    },
    {
        nombreAnimal: "Ballena azul",
        definicion:
            "Cetáceo marino que ostenta el título de ser el animal más grande del planeta, alimentándose principalmente de diminutos crustáceos llamados kril.",
    },
    {
        nombreAnimal: "Murciélago",
        definicion:
            "Único mamífero capaz de volar activamente, el cual utiliza la ecolocalización para guiarse y cazar insectos en la oscuridad.",
    },
    {
        nombreAnimal: "Águila",
        definicion:
            "Ave rapaz de gran tamaño con una vista excepcionalmente aguda, pico ganchudo y fuertes garras para capturar a sus presas en pleno vuelo.",
    },
    {
        nombreAnimal: "Pingüino",
        definicion:
            "Ave marina no voladora, adaptada perfectamente al buceo y al frío, que camina de forma erecta y habita principalmente en el hemisferio sur.",
    },
    {
        nombreAnimal: "Camaleón",
        definicion:
            "Reptil famoso por su capacidad de cambiar de color para camuflarse, sus ojos que se mueven de forma independiente y su lengua larga y pegajosa.",
    },
    {
        nombreAnimal: "Abeja",
        definicion:
            "Insecto volador fundamental para el ecosistema debido a su labor de polinización, que vive en colonias organizadas y produce miel.",
    },
    {
        nombreAnimal: "Pulpo",
        definicion:
            "Molusco marino inteligente que carece de esqueleto interno, posee tres corazones, sangre azul y ocho brazos llenos de ventosas.",
    },
    {
        nombreAnimal: "Tiburón blanco",
        definicion:
            "Gran depredador marino con un esqueleto compuesto de cartílago en lugar de hueso y múltiples filas de dientes aserrados y reemplazables.",
    },
];

// Función que devuelve un número aleatorio entre 0 y (cantidad de animales - 1).
// Math.random() da un decimal entre 0 y 0.99..., al multiplicarlo por la longitud
// y redondear hacia abajo con Math.floor obtenemos una posición válida del array.
const numeroAleatorio = (): number => Math.floor(Math.random() * animales.length);


// Componente principal del juego.
const Animales = () => {

    // Estado: true cuando el usuario falla y hay que bloquear algo en pantalla.
    // Empieza en false (nada bloqueado).
    const [botonDeshabilitado, setBotonDeshabilitado] = useState(false);

    // Estado: posición (índice) del animal secreto dentro del array.
    // Le pasamos la función numeroAleatorio sin paréntesis para que React la ejecute
    // solo la primera vez y no en cada render.
    const [numeroSecreto, setNumeroSecreto] = useState<number>(numeroAleatorio);

    // Estado: mensaje que se muestra al acertar. Empieza vacío.
    const [resultado, setResultado] = useState<string>("");


    // Se ejecuta al pulsar un botón de animal. Recibe "i", la posición del animal pulsado.
    const adivinarAnimal = (i: number) => {

        if (i === numeroSecreto) {
            // Acierto: guardamos el mensaje con el nombre del animal secreto.
            setResultado("¡Acertaste! El animal era " + animales[numeroSecreto].nombreAnimal);
        } else {
            // Fallo: activamos el estado de deshabilitado.
            setBotonDeshabilitado(true);
        }
    }

    // Se ejecuta al pulsar "Reiniciar Partida".
    const botonReiniciar = () => {
        setNumeroSecreto(numeroAleatorio());  // Nuevo animal secreto (con paréntesis: llamamos a la función)
        setResultado("");                     // Borramos el mensaje anterior
        setBotonDeshabilitado(false);         // Volvemos a habilitar el botón
        alert("Se reinició la partida");      // Aviso al usuario
    }

    // Lo que se dibuja en pantalla. El <> ... </> es un contenedor invisible
    // que permite devolver varios elementos juntos.
    return (
        <>
            <h1>Adivina el animal</h1>

            {/* Muestra la definición del animal secreto como pista */}
            <p>{animales[numeroSecreto].definicion}</p>

            {/* Recorre el array y crea un botón por cada animal.
                key ayuda a React a identificar cada botón.
                Al hacer clic llama a adivinarAnimal pasando la posición del animal. */}
            {animales.map((animal, i) => (
                <button key={animal.nombreAnimal} onClick={() => adivinarAnimal(i)}>
                    {animal.nombreAnimal}
                </button>
            ))}

            {/* Aquí aparece el mensaje de acierto (vacío mientras no aciertes) */}
            <p>{resultado}</p>

            {/* Botón para empezar de nuevo. disabled lo bloquea cuando botonDeshabilitado es true */}
            <button onClick={botonReiniciar} disabled={botonDeshabilitado}>Reiniciar Partida</button>
        </>
    )
}

// Permite importar este componente desde otros archivos (por ejemplo App.tsx).
export default Animales