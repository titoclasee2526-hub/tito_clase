package es.iescanarias.aeg.model;

import java.util.function.Consumer;

import javafx.application.Platform;

public class Hilos {

    public void animarBandera(double topeY, double posYInicial, Consumer<Double> actualizarY) {
        Thread hilo = new Thread(() -> {
            double posicionY = posYInicial;
            System.out.println("2. Hilo iniciado. Origen: " + posicionY + " | Destino: " + topeY);
            
            try {
                while (posicionY > topeY) {
                    Thread.sleep(30); 
                    posicionY -= 1; 
                    
                    final double nuevaY = posicionY;

                    if (nuevaY % 50 == 0) {
                        System.out.println("3. Moviendo... Altura actual: " + nuevaY);
                    }
                    
                    Platform.runLater(() -> {
                        actualizarY.accept(nuevaY);
                    });
                }
                System.out.println("4. La bandera ha llegado a la cima.");
            } catch (InterruptedException e) {
                System.out.println("Error en la animación: " + e.getMessage());
            }
        });
        
        hilo.setDaemon(true); 
        hilo.start();
    }
}
