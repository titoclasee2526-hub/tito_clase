import { useState, useEffect, useRef } from "react";
import type { ChangeEvent, MouseEvent } from "react";

type Tipo = "fruta" | "verdura";

type ItemType = {
  nombre: string;
  tipo: Tipo;
};

function Item({ nombre, tipo }: ItemType) {
  return (
    <li>
      {tipo === "fruta" ? "🍎" : "🥕"} {nombre}
    </li>
  );
}

export default function App() {
  const [texto, setTexto] = useState("");
  const [busqueda, setBusqueda] = useState("");
  const [items, setItems] = useState<ItemType[]>([]);
  const inputRef = useRef<HTMLInputElement>(null);

  useEffect(() => {
    inputRef.current?.focus();
  }, []);

  useEffect(() => {
    document.title = `Elementos: ${items.length}`;
  }, [items]);

  const handleTexto = (e: ChangeEvent<HTMLInputElement>) =>
    setTexto(e.currentTarget.value);

  const handleBusqueda = (e: ChangeEvent<HTMLInputElement>) =>
    setBusqueda(e.currentTarget.value);

  const handleAdd = (e: MouseEvent<HTMLButtonElement>) => {
    const tipo = e.currentTarget.value as Tipo;
    const nombre = texto.trim();
    if (!nombre) return;

    const nombres = items.map((i) => i.nombre.toLowerCase());
    if (nombres.includes(nombre.toLowerCase())) return;

    setItems([...items, { nombre, tipo }]);
    setTexto("");
    inputRef.current?.focus();
  };

  const filtrados = items.filter((i) =>
    i.nombre.toLowerCase().includes(busqueda.toLowerCase())
  );

  return (
    <div>
      <h1>Lista de compra</h1>

      <input
        ref={inputRef}
        value={texto}
        onChange={handleTexto}
        placeholder="Nuevo elemento"
      />
      <button value="fruta" onClick={handleAdd}>Añadir fruta</button>
      <button value="verdura" onClick={handleAdd}>Añadir verdura</button>
      <br/>
      <br/>
      <input
        value={busqueda}
        onChange={handleBusqueda}
        placeholder="Buscar..."
      />

      {filtrados.length === 0 ? (
        <p>No hay elementos</p>
      ) : (
        <ul>
          {filtrados.map((item, index) => (
            <Item key={index} nombre={item.nombre} tipo={item.tipo} />
          ))}
        </ul>
      )}
    </div>
  );
}
