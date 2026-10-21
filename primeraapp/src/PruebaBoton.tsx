



import React, { Component, useState } from 'react'

type Props = {

}

const PruebaBoton = (props: Props) => {

    const [count, setCount] = useState(0)


    function numeroGenerado(num: number) {

        alert(Math.random() * num)
    }



    function aviso() {
        alert("hola")
    }

    return (
        <div>
            <h4>PruebaBoton         </h4>
            <hr />
            <Contador />
            <hr />
            <button onClick={aviso} >pulsa </button>
            <br /><br />
            <button onClick={() => numeroGenerado(4)} >generar aleatorio de 4 </button>
        </div>
    )
}

export default PruebaBoton





 class Contador extends Component {
   
    
    
    state = { 
        count: 100 ,
        nombre: "ana"
    
    } // inicializamos el state a 0


    
    render() {
        let miVar = 4;
        miVar++;
        const { count } = this.state // extraemos el count del state
        return (
            <div>
                <p>Has hecho click {this.state.count} veces</p>
                <p> el nombre acumulado es: {this.state.nombre}</p>
                { /* Actualizamos el state usando el método setState */}
                <button onClick={() => {
                        alert("hola el valor de miVar es: " + miVar )
                        //this.setState({ count: this.state.count + 1 }) 
                        //this.setState({ nombre: this.state.nombre + "a" }) 
                        this.state.count++;
                    }
                }>
                    Haz click!
                </button>
            </div>
        )
    }
}
