package es.iescanarias.aeg;

public class Museo {
    private int VisitantesActuales = 100;

    public synchronized void entrar() {
        VisitantesActuales ++;

        System.out.println("[i] " + Thread.currentThread().getName() + " Entra un visitante e inicia la visita");
        System.out.println(VisitantesActuales + "nº actuales de visitantes en el museo");
    }

    public synchronized void salir() {
        if (VisitantesActuales > 0) {
            VisitantesActuales --;
        }

        System.out.println("[i] " + Thread.currentThread().getName() + " Sale un visitante y abandona la visita");
        System.out.println(VisitantesActuales + "nº actuales de visitantes en el museo");
    }
}
