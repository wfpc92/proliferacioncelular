
package Comandos;

import Abstracto.Comando;
import Controlador.Controlador;


public class NuevoTejidoComando extends Comando {

   public NuevoTejidoComando(Controlador controlador){
        this.receptor = controlador;
    }
    
    @Override
    public void ejecutar() {
        receptor.nuevoTejido();       
    }
    
    
}
