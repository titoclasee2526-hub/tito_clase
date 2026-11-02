package es.iescanarias.aeg;

public class HiloSalida extends Thread{
    private Museo museo;

    public HiloSalida(Museo museo, String nombre) {
        super(nombre);
        this.museo = museo;
    }

    @Override 
    public void run() {
        museo.salir();
    }
}
