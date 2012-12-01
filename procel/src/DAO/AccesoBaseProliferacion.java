/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Tejido;
import Modelo.Celula;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AccesoBaseProliferacion {

    public static final String cadenaConexionDDBB = "jdbc:sqlite:mydatabase.sqlite";
    private static AccesoBaseProliferacion accesoDatos;
    private static Connection conn;
    //<editor-fold defaultstate="collapsed" desc=" DDL de la base de datos ">
    public static String crearCelula =
            "CREATE TABLE IF NOT EXISTS CELULA("
            + "IDCELULA INTEGER PRIMARY KEY, "
            + "IDTEJIDO INTEGER REFERENCES TEJIDO(IDTEJIDO))";
    public static String crearTejido =
            "CREATE TABLE IF NOT EXISTS TEJIDO("
            + "IDTEJIDO INTEGER PRYMARY KEY, "
            + "NOMBRE VARCHAR(15))";
    public static String crearLado =
            "CREATE TABLE IF NOT EXISTS LADO( "
            + "IDCELULAVECINO INTEGER NOT NULL, "
            + "IDLADO INTEGER NOT NULL, "
            + "LONGITUD FLOAT(4) NOT NULL, "
            + "IDCELULA INTEGER NULL, "
            + "CONSTRAINT PK_LADO PRIMARY KEY (IDLADO,IDCELULA), "
            + "CONSTRAINT FK_LADO_VECINO FOREIGN KEY (IDCELULAVECINO) REFERENCES CELULA(IDCELULA), "
            + "CONSTRAINT FK_LADO_CELULA FOREIGN KEY (IDCELULA) REFERENCES CELULA(IDCELULA))";
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Implementacion Patron Singleton ">
    private synchronized static void createInstance() {
        if (accesoDatos == null) {
            accesoDatos = new AccesoBaseProliferacion();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static AccesoBaseProliferacion getAccesoDatos() {
        createInstance();
        return accesoDatos;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructor Privado de Clase ">
    private AccesoBaseProliferacion() {
        //JOptionPane.showMessageDialog(new JFrame(), System.getProperty("java.class.path"));
        
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "No se encontro el controlador de la base de datos.");
        } finally {

            if (conectar()) {
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(crearTejido);
                    stmt.execute(crearCelula);
                    stmt.execute(crearLado);
                    conn.commit();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "No se pudo ejecutar el ldd.");
                } finally {
                    desconectar();
                }
            }
        }
    }
    //</editor-fold>

    //hace la conexion con una base de datos
    public final boolean conectar() {
        try {
            conn = DriverManager.getConnection(cadenaConexionDDBB);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    //Desconecta la base de datos.
    public final void desconectar() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
            conn = null;
        }
    }

    //Funciones que realizan funciones del lenguaje de definicion de datos.
    public boolean insertarRegistro(Object... o) {
        Object retorno = intentarEjecutarSentenciaSQL("INSERT", o);
        return retorno != null ? (boolean) retorno : false;
    }

    public DefaultTableModel seleccionarRegistro(Object... o) {
        return (DefaultTableModel) intentarEjecutarSentenciaSQL("SELECT", o);
    }

    public boolean eliminarRegistro(Object... o) {
        Object retorno = intentarEjecutarSentenciaSQL("DELETE", o);
        return retorno != null ? (boolean) retorno : false;
    }

    public boolean modificarRegistro(Object... o) {
        Object retorno = intentarEjecutarSentenciaSQL("UPDATE", o);
        return retorno != null ? (boolean) retorno : false;
    }

    //intenta realizar una sentencia SQL, sino la ejecuta retorna un objecto
    //segun el tipo de sentencia.
    public Object intentarEjecutarSentenciaSQL(String strTipo, Object... o) {
        Object resultado = null;
        try {
            // Hacer la conexion con la base de datos
            if (this.conectar()) {
                try (Statement stmt = conn.createStatement()) {
                    resultado = ejecutarSentenciaSQL(strTipo, stmt, o);
                }
                this.desconectar();
            } else {
                throw new SQLException("NO SE PUDO ABRIR BASE DE DATOS");
            }
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(new JFrame(), se.getMessage());
            if ("INSERT".equals(strTipo) || "DELETE".equals(strTipo) || "UPDATE".equals(strTipo)) {
                resultado = Boolean.valueOf("false");
            }
            if ("SELECT".equals(strTipo)) {
                resultado = null;
            }
        }
        return resultado;
    }

    //ejecuta una sentencia SQL segun el tipo de instruccion DML
    private Object ejecutarSentenciaSQL(String strTipo, Statement stmt, Object... o)
            throws SQLException {
        String sql = armarSentenciaSQL(strTipo, o);
        switch (strTipo) {
            case "INSERT":
            case "UPDATE":
            case "DELETE":
                try {
                    stmt.executeUpdate(sql);
                    return true;
                } catch (SQLException se) {
                    throw new SQLException(
                            "Error en tabla "
                            + o[0].getClass().getSimpleName()
                            + "\nDetailMessage: " + se.getMessage()
                            + "\nQuery: " + sql);
                }
            case "SELECT":
                try {
                    return generarTabla(stmt.executeQuery(sql));
                } catch (SQLException se) {
                    throw new SQLException(
                            "Error en tabla "
                            + o[0].getClass().getSimpleName()
                            + "\nDetailMessage: " + se.getMessage()
                            + "\nQuery: " + sql);
                }
        }
        return null;
    }

    //Determina a que tabla va la consulta y el tipo de consulta
    //extrae datos y retorna una cadena-consulta-SQL
    private String armarSentenciaSQL(String strTipo, Object[] o)
            throws SQLException {
        String strTabla = null;
        String strId = null;
        Tejido t = null;
        Celula c = null;

        try {
            strTabla = o[0].getClass().getSimpleName();
            switch (strTabla) {
                case "Tejido":
                    t = (Tejido) o[0];
                    break;
                case "Celula":
                    c = (Celula) o[0];
                    break;
            }
            if (t == null && c == null) {
                throw new SQLException("NO Existe Tabla con ese tipo de objeto.");
            }
        } catch (Exception e) {
            throw new SQLException("Requiere un objeto, para ejecutar sentencia");
        }

        try {
            if ("Celula".equals(strTabla) && "UPDATE".equals(strTipo)) {
                strId = String.valueOf(((Celula) o[1]).getId());
            }
            if ("Tejido".equals(strTabla) && "UPDATE".equals(strTipo)) {
                strId = String.valueOf(((Tejido) o[1]).getId());
            }

        } catch (Exception e) {
            throw new SQLException("UDPATE Tabla celula requiere (int).");
        }

        //SE EVALUA EL TIPO DE SENTENCIA DML QUE SE PIDE
        switch (strTipo) {
            case "INSERT":
                switch (strTabla) {
                    case "Tejido":
                        return "INSERT INTO TEJIDO "
                                + "VALUES ("
                                + t.getId()
                                + ")";
                    case "Celula":
                        return "INSERT INTO CELULA "
                                + "VALUES("
                                + c.getId() + ","
                                + c.getNumLado() + ","
                                + c.getLongLado() + ","
                                + strId
                                + ")";
                }
                break;
            case "UPDATE":
                switch (strTabla) {
                    case "Tejido":
                        System.out.print(t.getId());
                        return "UPDATE TEJIDO "
                                + "SET IDTEJIDO = "
                                + strId
                                + " WHERE IDTEJIDO = "
                                + t.getId();
                    case "Celula":
                        return "UPDATE CELULA "
                                + "SET IDCELULA = "
                                + strId
                                + " WHERE IDCELULA = "
                                + c.getId();
                }
                break;
            case "DELETE":
                switch (strTabla) {
                    case "Tejido":
                        return "DELETE FROM TEJIDO "
                                + "WHERE "
                                + "IDTEJIDO = " + t.getId();
                    case "Celula":
                        return "DELETE FROM CELULA "
                                + "WHERE "
                                + "IDCELULA = " + c.getId();
                }
                break;
            case "SELECT":
                switch (strTabla) {
                    case "Tejido":
                        return "SELECT * FROM TEJIDO";
                    case "Celula":
                        return "SELECT * FROM CELULA";
                }
                break;
        }
        return null;
    }

    public DefaultTableModel generarTabla(ResultSet rs) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        ResultSetMetaData rsMd = rs.getMetaData();
        int cantidadColumnas = rsMd.getColumnCount();
        //Establecer como cabezeras el nombre de las columnas
        for (int i = 1; i <= cantidadColumnas; i++) {
            modelo.addColumn(rsMd.getColumnLabel(i));
        }
        //Creando las filas para el JTable
        while (rs.next()) {
            Object[] fila = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            modelo.addRow(fila);
        }
        return modelo;
    }

    public Object ejecutar(String sql)
            throws SQLException {
        try {
            // Hacer la conexion con la base de datos
            if (this.conectar()) {
                try (Statement stmt = conn.createStatement()) {
                    if (stmt.execute(sql)) {
                        return generarTabla(stmt.getResultSet());
                    } else {
                        throw new SQLException("no se puede ejecutar sql");
                    }
                } catch (SQLException e) {
                    throw e;
                }
            } else {
                throw new SQLException("NO SE PUDO ABRIR BASE DE DATOS");
            }
        } catch (SQLException se) {
            throw se;
        }
    }
}
