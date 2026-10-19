package es.iescanarias;

import java.io.Serializable;

public class DNI implements Serializable {
    // Atributo privado para almacenar el DNI una vez validado
    private String numeroDNI;

    /**
     * Constructor de la clase DNI.
     * Recibe el DNI en formato texto y lo valida antes de crear el objeto.
     */
    public DNI(String dni) {
        // Llama al método privado 'esValido'. Si devuelve 'false', entra en el bloque 'if'
        if (!esValido(dni)) {
            // Lanza una excepción interrumpiendo la creación del objeto.
            // Esto evita que se creen instancias de la clase con un DNI incorrecto.
            throw new IllegalArgumentException("El DNI introducido no es válido: " + dni);
        }
        
        // Si pasó la validación, guarda el DNI convirtiendo la letra a mayúscula por consistencia
        this.numeroDNI = dni.toUpperCase();
    }

    /**
     * Método auxiliar que contiene la lógica matemática y de formato del DNI español.
     */
    private boolean esValido(String dni) {
        // 1. COMPROBACIÓN DE NULOS Y FORMATO BÁSICO (Expresión Regular)
        // - Si el texto es nulo, no se puede validar (evita un NullPointerException).
        // - matches("\\d{8}[A-Za-z]"): Verifica que el texto tenga exactamente 
        //   8 dígitos numéricos (\\d{8}) seguidos de una única letra ([A-Za-z]).
        if (dni == null || !dni.matches("\\d{8}[A-Za-z]")) {
            return false; // Si no cumple el formato básico, el DNI es inválido directamente
        }

        
        // Cadena con las letras del DNI ordenadas según el resto de la división por 23
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        
        // Extrae los primeros 8 caracteres (los números) y los convierte a un tipo entero (int)
        int numeros = Integer.parseInt(dni.substring(0, 8));
        
        // Aplica el operador residuo o módulo (%). Divide el número entre 23 y se queda con el resto.
        // El resto siempre será un número entre 0 y 22, que coincide con los índices de la cadena 'letras'.
        int resto = numeros % 23;
        
        // Obtiene la letra teórica que le corresponde a ese número usando el resto como posición (índice)
        char letraCalculada = letras.charAt(resto);

        // 3. COMPARACIÓN DE LA LETRA
        // Extrae el último carácter de la cadena recibida (posición 8) y lo pasa a mayúscula
        char letraIntroducida = Character.toUpperCase(dni.charAt(8));

        // Retorna 'true' si la letra que calculamos coincide con la letra que metió el usuario.
        
        return letraCalculada == letraIntroducida;
    }

    @Override
    public String toString() {
        return "DNI [numeroDNI=" + numeroDNI + "]";
    }

   

    
}