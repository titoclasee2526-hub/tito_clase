 import React, { useState } from 'react'

type Props = {}

type Empleado = {
    nombre: string;
    id: number;
}



const GestionArray = (props: Props) => {
    const [inputNombre, setInputNombre] = useState("")
    const [inputIdempleado, setInputIdempleado] = useState("")

    const [empleados, setEmpleados] = useState<Empleado[]>([])

    const [contador, setContador] = useState(1);
    const [inputBorrar, setInputBorrar] = useState("");
 
    function agregarEmpleado() {

        let empleado: Empleado = {
            nombre: inputNombre,
            id: parseInt(inputIdempleado)
        }
        //Crear, borrar y actualizar
        empleados.push(empleado);
        let neoArray: Empleado[] = [];
        
       // let neoArray = [];
       /* for (let i = 0; i < neoArray.length; i++) {
            neoArray.push(empleados[i]);
            
        } */
        

        neoArray.push(empleado);
        

        empleados.forEach(e => neoArray.push(e))

        setEmpleados(neoArray);

        setEmpleados([...empleados])

        //setEmpleados(2c)
        //setEmpleados(7v)

        setContador((contador + 1) % 2);
 
    }

    function borrarEmpleado(){
           let  idBorrable: number = parseInt(inputBorrar) 
           let neoArray = [];
           for (let i = 0; i < empleados.length; i++) {
            if(empleados[i].id != idBorrable){
                //Agrega uno detras de otro
                neoArray.push(empleados[i]);
            }
            let empleadosMaria = empleados.filter( emp => emp.nombre = "maria")
            let nuevaLista = empleados.filter (emp => emp.id != idBorrable)
            // La funcion filter genera un nuevo Array
            setEmpleados(nuevaLista);
            
           }
        }

        function actualizarEmpleado(){


        }

        function anadirEmpleado(){

            let idAgregar: number = parseInt(inputBorrar)

            let actualizarLista = empleados.filter (emp => emp.id === idAgregar)
            setEmpleados(actualizarLista);
            
        }
    return (

        <div>
            <h3>Empleado</h3>
            <input type="text"
                name="nombre"
                id="nombre"
                onChange={(evt) => setInputNombre(evt.currentTarget.value)}
                value={inputNombre}
            />

            <input type="text"
                name="idempleado"
                id="idempleado"
                onChange={(evt) => setInputIdempleado(evt.currentTarget.value)}
                value={inputIdempleado} />

            <button onClick={agregarEmpleado} >
                agregar a Array
            </button>

            <p>
                contador: {contador}
                <br />
                {
                    Math.random()
                }

            </p>

            <div>
                {JSON.stringify(empleados)}
            </div>
            <div>
                <h4>Borrar Empleado</h4>
                <input type="text" 
                name="inputBorrar" 
                id="inputBorrar"
                 onChange={(evt)=> setInputBorrar(evt.currentTarget.value)}
                 value={inputBorrar}
                 />

                <button type="button" onClick={borrarEmpleado}>Borrar</button>
            </div>
            

        </div>
    )
}

export default GestionArray