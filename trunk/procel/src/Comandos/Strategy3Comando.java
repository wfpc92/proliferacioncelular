package Comandos;

import Abstracto.Comando;
import Controlador.Controlador;

public class Strategy3Comando extends Comando{
     
    public Strategy3Comando(Controlador controlador){
        this.receptor = controlador;
    }
    
    @Override
    public void ejecutar() {
        receptor.mostrarMensajeStrategy3();
    }
}
