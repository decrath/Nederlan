package BD;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    
    private static Connection conn;
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String password="";
    private static final String url="jdbc:mysql://localhost:3306/inventario";
    
    public Conectar(){
        conn=null;
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
            if(conn !=null){
                JOptionPane.showMessageDialog(null,"conexion exitosa");
                //JOptionPane.showMessageDialog(null,"marico, por fin conecto");
            }
        
        }catch(ClassNotFoundException | SQLException e){
            //JOptionPane.showMessageDialog(null,"no conecta marico...");
            JOptionPane.showMessageDialog(null,"no conecta");
            
        }
    }
    
    //este metodo nos retorna la conexion
    public Connection getConnection(){
        return conn;
    }
    
    
    //con este metodo nos desconectamos de la base de datos
    public void close(){
      try{
          conn.close();
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "error al cerrar la base datos ");
      }
    }
    
    
    
}
