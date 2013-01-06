
package Comandos;

import Abstracto.Icomando;
import Controlador.Controlador;


public class EstadisticasComando implements Icomando {
    Controlador controlador;
    public EstadisticasComando(Controlador controlador) {
        this.controlador=controlador;
    }

    @Override
    public void ejecutar() {
        controlador.graficaEstadistica();
    }
    
}
