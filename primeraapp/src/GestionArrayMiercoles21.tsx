import React, { useState } from 'react'

type Props = {}

type Empleado = {
    nombre: string,
    id: number
}


const GestionArrayMiercoles21 = (props: Props) => {

    const [inputNombre, setInputNombre] = useState("")
    const [inputIdempleado, setInputIdempleado] = useState("")
    const [empleadosArray, setEmpleadosArray] = useState<Empleado[]>([{nombre:"na",id:21} ])
    const [inputBorrar, setInputBorrar] = useState("")
    const [inputActualizar, setInputActualizar] = useState("")
    const [inputNombreActualizar, setInputNombreActualizar] = useState("")


    function borrarEmpleado(){
        let idBorrable: number = parseInt(inputBorrar);
        let nuevaLista = empleadosArray.filter( emp=> emp.id != idBorrable)
        setEmpleadosArray(nuevaLista);
    }

    function ActualizarEmpleado(){
        let idActualizable: number = parseInt(inputActualizar);
        let nuevaLista = empleadosArray.map(emp => 
            emp.id === idActualizable? {...emp, nombre: inputNombreActualizar} : emp
        ); 
        setEmpleadosArray(nuevaLista);
    }
    
    function agregarEmpleado() {

        let empleado: Empleado = {
            nombre: inputNombre,
            id: parseInt(inputIdempleado)
        }
     
        setEmpleadosArray([...empleadosArray, empleado] )

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
            value={inputIdempleado}
            />

            <button onClick={agregarEmpleado}> Agregar a Array </button>

            <p>
                <br/>
                {
                    Math.random()
                }
            </p>
            <div>
                {JSON.stringify(empleadosArray)}
            </div>

            <div>
                <h4>Borrar empleado</h4>
                <input 
                    type="text" 
                    name="inputBorrar" 
                    id="inputBorrar" 
                    onChange={(evt)=>setInputBorrar(evt.currentTarget.value)}
                    value={inputBorrar}
                />
                <button onClick={borrarEmpleado}>
                    borrar
                </button>

            </div>

                            <div>
                <h4>Actualizar empleado</h4>
                <input 
                    type="text" 
                    name="inputNombreActualizar" 
                    id="inputNombreActualizar" 
                    onChange={(evt)=>setInputNombreActualizar(evt.currentTarget.value)}
                    value={inputNombreActualizar}
                />
                <input 
                    type="text" 
                    name="inputActualizar" 
                    id="inputActualizar" 
                    onChange={(evt)=>setInputActualizar(evt.currentTarget.value)}
                    value={inputActualizar}
                />
                <button onClick={ActualizarEmpleado}>
                    actualizar
                </button>

            </div>

        </div>
    )
}

export default GestionArrayMiercoles21;