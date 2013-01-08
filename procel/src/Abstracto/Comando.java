
package Abstracto;

import Controlador.Controlador;

public abstract class Comando {
    protected Controlador receptor = null;
    public abstract void ejecutar();   
    
}
