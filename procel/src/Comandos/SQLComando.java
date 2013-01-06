
package Comandos;

import Abstracto.Icomando;
import Controlador.Controlador;
import DAO.AccesoBaseProliferacion;
import javax.swing.table.DefaultTableModel;

public class SQLComando implements Icomando{

    Controlador controlador;
    String sql;
    
    public SQLComando(Controlador controlador, String sql) {
        this.controlador = controlador;
        this.sql = sql;
    }

    @Override
    public void ejecutar() {
        DefaultTableModel modelo = (DefaultTableModel)AccesoBaseProliferacion.getAccesoDatos().ejecutar(sql);
        controlador.mostrarTabla(modelo);
    }
    
}
