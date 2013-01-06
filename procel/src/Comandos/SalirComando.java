
package Comandos;

import Abstracto.Icomando;
import Controlador.Controlador;


public class SalirComando implements Icomando {

    Controlador controlador;
    
    public SalirComando(Controlador controlador){
        this.controlador = controlador;
    }
    
    @Override
    public void ejecutar() {
        controlador.salir();
    }
    
}
