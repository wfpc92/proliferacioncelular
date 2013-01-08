
package Comandos;

import Abstracto.Comando;
import Controlador.Controlador;


public class SalirComando extends Comando {

    public SalirComando(Controlador controlador){
        this.receptor = controlador;
    }
    
    @Override
    public void ejecutar() {
        receptor.salir();
    }
    
}
