import React from "react"

const Operacion = (props) => {
    return (
        <p>Datos recibido en el componente: {props.num1} y {props.num2} es {props.num1 + props.num2}</p>
    )
}
export default Operacion;