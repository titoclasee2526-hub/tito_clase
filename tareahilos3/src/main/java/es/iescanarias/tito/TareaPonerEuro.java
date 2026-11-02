package es.iescanarias.tito;

public class TareaPonerEuro implements Runnable {
    
     private final CuentaCorriente c;
     public TareaPonerEuro(CuentaCorriente c){
     this.c = c;
    }
    
    @Override
    public void run() {
        c.deposito(1);
    }
    
}
