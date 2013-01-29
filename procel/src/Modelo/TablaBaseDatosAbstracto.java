/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.event.MouseEvent;

/**
 *
 * @author waruano
 */
public interface TablaBaseDatosAbstracto {
    
    public abstract void generarSql(MouseEvent evt) throws Exception;
}
