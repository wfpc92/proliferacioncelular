
package Comandos;

import Abstracto.Comando;
import Controlador.Controlador;
import DAO.AccesoBaseProliferacion;
import javax.swing.table.DefaultTableModel;

public class SQLComando extends Comando{

    String sql;
    
    public SQLComando(Controlador controlador) {
        this.receptor = controlador;
    }

    @Override
    public void ejecutar() {
        DefaultTableModel modelo = (DefaultTableModel)AccesoBaseProliferacion.getAccesoDatos().ejecutar(sql);
        receptor.mostrarTabla(modelo);
    }
    
    public void setTabla(String tabla){
        sql = AccesoBaseProliferacion.getAccesoDatos().getSentencia(tabla);
    }
    
}
