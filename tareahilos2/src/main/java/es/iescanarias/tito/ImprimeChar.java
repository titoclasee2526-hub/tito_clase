package es.iescanarias.tito;

public class ImprimeChar implements Runnable {

    private char caracterSimple;
    private int veces;

    public ImprimeChar(char c, int n) {
        caracterSimple = c;
        veces = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < veces; i++) {
            System.out.println("Se imprime:" + caracterSimple);

        }
    }

}
