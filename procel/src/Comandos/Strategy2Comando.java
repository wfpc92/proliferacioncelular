package Comandos;

import Abstracto.Comando;
import Controlador.Controlador;

public class Strategy2Comando extends Comando{
   
    public Strategy2Comando(Controlador controlador){
        this.receptor = controlador;
    }
    
    @Override
    public void ejecutar() {
        receptor.mostrarMensajeStrategy2();
    }    
}
