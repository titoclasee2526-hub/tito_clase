import React from 'react'

type Props = {
info?:string

}

function aviso(){
    alert("Hola gonorreita")

}
const Tiempos = (props: Props) => {
  return (
    <div>
    <div>TiempoTS se ha recibido por props:{props.info}</div>
    <button onClick={aviso}>Pulsar</button>
    </div>
)
}

export default Tiempos
