package es.iescanarias.tito;

public class ImprimeNumero implements Runnable {

    private int muestra;

    public ImprimeNumero(int n) {
        muestra = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < muestra; i++) {
            System.out.println("Muestra el numero:"+  muestra);
        }
    }

}
