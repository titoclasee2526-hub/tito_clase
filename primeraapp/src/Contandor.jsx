import { useState } from "react";

export default function Contador() {
  const [n, setN] = useState(0);
  return (
    <button onClick={() => setN(n + 1)}>
      Has hecho clic {n} veces
    </button>
  );
}