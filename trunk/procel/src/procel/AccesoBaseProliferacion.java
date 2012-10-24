/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procel;

/**
 *
 * @author yohanna
 */
import java.sql.*;
public class AccesoBaseProliferacion {
    private Connection conn;
    
    public AccesoBaseProliferacion(){
       try{
        Class.forName( "com.mysql.jdbc.Driver" );
       }catch(Exception e){}

     }
    
    private void conectar(){
        try{
        conn = DriverManager.getConnection( "jdbc:odbc:Database" ) ;
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
      ResultSet rs = stmt.executeQuery( "INSERT INTO .. " ) ;

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
