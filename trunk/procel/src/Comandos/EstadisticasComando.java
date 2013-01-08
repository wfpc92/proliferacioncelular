
package Comandos;

import Abstracto.Comando;
import Controlador.Controlador;


public class EstadisticasComando extends Comando {
    
    public EstadisticasComando(Controlador controlador) {
        this.receptor=controlador;
    }

    @Override
    public void ejecutar() {
        receptor.graficaEstadistica();
    }
    
}
