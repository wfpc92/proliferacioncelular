/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import LogicaNegocio.*;
/**
 *
 * @author yohanna
 */
import java.sql.*;
public class AccesoBaseProliferacion {
    private Connection conn;
    
    public AccesoBaseProliferacion(){
       try{
        Class.forName( "org.sqlite.JDBC" );
       }catch(Exception e){}

     }
    
    private void conectar(){
        try{
        conn = DriverManager.getConnection( "jdbc:sqlite:mydatabase.sqlite" ) ;
        } catch (SQLException e){}
    }
    
    private void desconectar(){
        try{
        conn.close();
        } catch (SQLException e){}
    }
    
    boolean addCelula (Celula ce){
     try
     {
      // Load the database driver
      
      // Get a connection to the database
      this.conectar();
      Statement stmt = conn.createStatement() ;

     // Execute the query
      String datos="'"+String.valueOf(ce.getLongLado())+"','"+String.valueOf(ce.getNumLado())+"'";
      ResultSet rs = stmt.executeQuery( "INSERT INTO CELULA (LONGLADO,NUMLADO) VALUES ("+datos+")" ) ;
      // Loop through the result set
      
      // Close the result set, statement and the connection
      rs.close() ;
      stmt.close() ;
      this.desconectar();
     }
     
  catch( SQLException se )
     {
      System.out.println( "SQL Exception:" + se.getMessage() ) ;
     }
        return true;
    }
    boolean getCelula (Celula ce){
     try
     {
      // Load the database driver
      
      // Get a connection to the database
      this.conectar();
      Statement stmt = conn.createStatement() ;

     // Execute the query
      ResultSet rs = stmt.executeQuery( "SELECT * FROM CELULA;");
      while (rs.next()) {
            System.out.println("IdCelula= "+rs.getString("IDCELULA"));
            System.out.println("Longitud de los lados = "+rs.getString("LONGLADO"));
            System.out.println("Numero de lados = "+rs.getString("NUMLADO"));
            System.out.println("IdTejido = "+rs.getString("IDTEJIDO"));
        }
      // Loop through the result set
      
      // Close the result set, statement and the connection
      rs.close() ;
      stmt.close() ;
      this.desconectar();
     }
     
  catch( SQLException se )
     {
      System.out.println( "SQL Exception:" + se.getMessage() ) ;
     }
        return true;
    }
    boolean addTejido (int idTejido){
     try
     {
      // Load the database driver
      
      // Get a connection to the database
      this.conectar();
      Statement stmt = conn.createStatement() ;

     // Execute the query
      String cadena=String.valueOf(idTejido);
      ResultSet rs = stmt.executeQuery( "INSERT INTO TEJIDO VALUES("+cadena+")");
      // Loop through the result set
      
      // Close the result set, statement and the connection
      rs.close() ;
      stmt.close() ;
      this.desconectar();
     }
     
  catch( SQLException se )
     {
      System.out.println( "SQL Exception:" + se.getMessage() ) ;
     }
        return true;
    }
}
