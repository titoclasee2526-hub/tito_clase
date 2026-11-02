package es.iescanarias.aeg;

public class HiloEntrada extends Thread {
    private Museo museo;

    public HiloEntrada(Museo museo, String nombre) {
        super(nombre);
        this.museo = museo;
    }

    @Override 
    public void run() {
        museo.entrar();
    }
   
}
