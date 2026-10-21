import { useState } from 'react'

// 1. TIPO: cómo es un libro
type libros = {
    id: number;
    titulo: string;
    autor: string;
    paginas: number;
    prestado: boolean;
}

export default function GestionBiblioteca() {

    // 2. ESTADO PRINCIPAL: la lista, con un libro de ejemplo
    const [libros, setlibros] = useState<libros[]>([
        { id: 1, titulo: "Trenza del mar Esmeralda", autor: "Brandon Sanderson", paginas: 560, prestado: true }
    ])

    // 3. ESTADOS DE LOS INPUTS
    // Todos son string, porque un input siempre da texto.
    // Los números se convierten con parseInt solo cuando hace falta.
    const [inputID, setinputID] = useState("")
    const [inputTitulo, setinputTitulo] = useState("")
    const [inputAutor, setinputAutor] = useState("")
    const [inputPaginas, setinputPaginas] = useState("")

    const [inputBorrar, setinputBorrar] = useState("")
    const [inputActualizarID, setinputActualizarID] = useState("")
    const [inputActualizarTitulo, setinputActualizarTitulo] = useState("")
    const [inputFiltro, setinputFiltro] = useState("")

    // 4. ESTADO DEL ERROR: texto vacío = no hay error
    const [error, setError] = useState("")

    // 5. AGREGAR
    function agregarLibro() {
        const id = parseInt(inputID)            // "5" -> 5
        const paginas = parseInt(inputPaginas)

        // Validaciones: si alguna falla, guardo el mensaje y salgo con return
        if (inputTitulo.trim() === "" || inputAutor.trim() === "") {
            setError("Título y autor no pueden estar vacíos")
            return
        }
        if (isNaN(id)) {                        // isNaN = "no es un número"
            setError("El id debe ser un número")
            return
        }
        if (libros.some(l => l.id === id)) {    // some = ¿algún libro tiene ese id?
            setError("Ese id ya existe")
            return
        }
        if (isNaN(paginas) || paginas <= 0) {
            setError("Las páginas deben ser un número mayor que 0")
            return
        }

        // Creo el libro nuevo (prestado empieza en false)
        const libro: libros = {
            id: id,
            titulo: inputTitulo,
            autor: inputAutor,
            paginas: paginas,
            prestado: false,
        }

        // SPREAD: copia todos los libros y añade el nuevo al final
        setlibros([...libros, libro])

        // Vaciar inputs y quitar el error
        setinputID("")
        setinputTitulo("")
        setinputAutor("")
        setinputPaginas("")
        setError("")
    }

    // 6. BORRAR
    function borrarLibro() {
        const id = parseInt(inputBorrar)
        if (isNaN(id)) {
            setError("El id a borrar debe ser un número")
            return
        }
        // FILTER: me quedo con todos los libros MENOS el que tiene ese id
        setlibros(libros.filter(l => l.id !== id))
        setinputBorrar("")
        setError("")
    }

    // 7. ACTUALIZAR
    function actualizarLibro() {
        const id = parseInt(inputActualizarID)
        if (isNaN(id) || inputActualizarTitulo.trim() === "") {
            setError("Pon un id válido y un título nuevo")
            return
        }
        // MAP: recorre todos los libros.
        // Si el id coincide, devuelve una copia con el título nuevo.
        // Si no coincide, lo deja igual.
        setlibros(libros.map(l =>
            l.id === id ? { ...l, titulo: inputActualizarTitulo } : l
        ))
        setinputActualizarID("")
        setinputActualizarTitulo("")
        setError("")
    }

    // 8. PRESTAR / DEVOLVER (mismo truco que actualizar)
    function alternarPrestado(id: number) {
        // !l.prestado invierte el valor: true -> false, false -> true
        setlibros(libros.map(l =>
            l.id === id ? { ...l, prestado: !l.prestado } : l
        ))
    }

    // 9. FILTRO POR AUTOR
    // Crea una lista nueva solo para mostrar. El array original no cambia.
    // includes = ¿el autor contiene el texto escrito?
    const librosFiltrados = libros.filter(l =>
        l.autor.toLowerCase().includes(inputFiltro.toLowerCase())
    )

    // 10. ESTADÍSTICAS: se calculan directamente, no necesitan estado
    const total = libros.length
    const prestados = libros.filter(l => l.prestado).length
    // reduce suma las páginas de todos los libros (empieza en 0)
    const sumaPaginas = libros.reduce((suma, l) => suma + l.paginas, 0)
    const media = total === 0 ? 0 : sumaPaginas / total

    return (
        <div>
            <h1>Biblioteca</h1>

            {/* Si error tiene texto, se muestra. Si está vacío, no se muestra nada */}
            {error && <p style={{ color: "red" }}>{error}</p>}

            {/* AGREGAR */}
            <h2>Añadir libro</h2>
            <input placeholder="Id" value={inputID}
                onChange={(e) => setinputID(e.currentTarget.value)} />
            <input placeholder="Título" value={inputTitulo}
                onChange={(e) => setinputTitulo(e.currentTarget.value)} />
            <input placeholder="Autor" value={inputAutor}
                onChange={(e) => setinputAutor(e.currentTarget.value)} />
            <input placeholder="Páginas" value={inputPaginas}
                onChange={(e) => setinputPaginas(e.currentTarget.value)} />
            <button onClick={agregarLibro}>Agregar</button>

            {/* BORRAR */}
            <h2>Borrar libro</h2>
            <input placeholder="Id a borrar" value={inputBorrar}
                onChange={(e) => setinputBorrar(e.currentTarget.value)} />
            <button onClick={borrarLibro}>Borrar</button>

            {/* ACTUALIZAR */}
            <h2>Actualizar título</h2>
            <input placeholder="Id" value={inputActualizarID}
                onChange={(e) => setinputActualizarID(e.currentTarget.value)} />
            <input placeholder="Nuevo título" value={inputActualizarTitulo}
                onChange={(e) => setinputActualizarTitulo(e.currentTarget.value)} />
            <button onClick={actualizarLibro}>Actualizar</button>

            {/* LISTA */}
            <h2>Lista de libros</h2>
            <input placeholder="Filtrar por autor" value={inputFiltro}
                onChange={(e) => setinputFiltro(e.currentTarget.value)} />

            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Título</th>
                        <th>Autor</th>
                        <th>Páginas</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    {/* MAP: una fila <tr> por cada libro. key = id (único) */}
                    {librosFiltrados.map(l => (
                        <tr
                            key={l.id}
                            // ESTILO CONDICIONAL: si está prestado, gris y tachado
                            style={{
                                color: l.prestado ? "gray" : "inherit",
                                textDecoration: l.prestado ? "line-through" : "none"
                            }}
                        >
                            <td>{l.id}</td>
                            <td>{l.titulo}</td>
                            <td>{l.autor}</td>
                            <td>{l.paginas}</td>
                            <td>
                                {/* El texto del botón cambia según prestado */}
                                <button onClick={() => alternarPrestado(l.id)}>
                                    {l.prestado ? "Devolver" : "Prestar"}
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>

            {/* ESTADÍSTICAS */}
            <h2>Estadísticas</h2>
            <p>Total de libros: {total}</p>
            <p>Prestados: {prestados}</p>
            <p>Media de páginas: {media.toFixed(0)}</p>
        </div>
    )
}