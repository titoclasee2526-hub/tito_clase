
import React, { useState, useEffect } from 'react'

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

const numeroAleatorio = (): number => Math.floor(Math.random() * animales.length);


const Animales = () => {

    //let botonDeshabilitarBoton: boolean = false;
    const  [botonDeshabilitado, setBotonDeshabilitado ] = useState(false);

    const [numeroSecreto, setNumeroSecreto] = useState<number>(numeroAleatorio)
    const [resultado, setResultado] = useState<string>("");
    

    const adivinarAnimal = (i: number) => {

        if (i === numeroSecreto) {
           setResultado("¡Acertaste! El animal era " + animales[numeroSecreto].nombreAnimal);
        } else {
            //setBotonDeshabilitado(true);
            setBotonDeshabilitado(true);

        }


    }

    const botonReiniciar = () => {
        setNumeroSecreto(numeroAleatorio);
        alert("Se reinicio la partida");
    }

    return (
        <>
            <h1>Adiniva el animal</h1>

            <p>{animales[numeroSecreto].definicion}</p>

            {animales.map((animal, i) => (
                <button key={animal.nombreAnimal} onClick={() => adivinarAnimal(i)}>
                    {animal.nombreAnimal}
                </button>
                
            ))}
            <p> {resultado}</p>
            <button onClick={botonReiniciar} disabled={botonDeshabilitado}>Reiniciar Partida</button>

            

        </>
    )
}

export default Animales
