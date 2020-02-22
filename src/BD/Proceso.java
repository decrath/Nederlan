package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Proceso {
    
    private final String SQL_INSERT="INSERT INTO producto(nombre,bruto,iva,neto) values(?,?,?,?)";
    private final String SQL_SELECT="SELECT *FROM producto;";
    private PreparedStatement PS;
    private DefaultTableModel DT;
    private ResultSet RS;
    private final Conectar CN;
    
    public Proceso(){
        PS=null;
        CN=new Conectar();
    }
    
    //crear  nombre de las columnas
    
    private DefaultTableModel setTitulos(){
        
        DT=new DefaultTableModel();
        
        //esto esta hecho especialmente para las columnas de la tabla
        DT.addColumn("id");
        DT.addColumn("Nombre");
        DT.addColumn("Bruto");
        DT.addColumn("IVA");
        DT.addColumn("Neto");
        
        return DT;
    }
            
    
    
            
    public int insertDatos(String nombre,double bruto,double iva,double neto){
        int res=0;
        try{
            
            PS=CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setString(1,nombre);
            PS.setDouble(2,bruto);
            PS.setDouble(3,iva);
            PS.setDouble(4,neto);
            res=PS.executeUpdate();
            
            if(res>0){
                JOptionPane.showMessageDialog(null, "registro guardado con exito");
            }
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"Error al guardar los datos en la base de datos: "+e.getMessage());
        
        }
        
        return res;
    }
    
    
    
    
    
    //actualizar
    public int updateDatos(String id,String nombre,double bruto,double iva,double neto){
        
            String SQL="UPDATE producto SET nombre='"+nombre+"',bruto='"+bruto+"',iva='"+iva+"',neto='"+neto+"' WHERE id="+id;
            
        int res=0;
        try{
            
            PS=CN.getConnection().prepareStatement(SQL);
            
            res=PS.executeUpdate();
            
            if(res>0){
                JOptionPane.showMessageDialog(null, "registro modificado con exito");
            }
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"Error al modificado los datos en la base de datos: "+e.getMessage());
        
        }
        
        return res;
    }

    

    //eliminar
    public int deleteData(String id){
            
        String SQL="DELETE from producto WHERE id="+id;
            
        int res=0;
        try{
            
            PS=CN.getConnection().prepareStatement(SQL);
            
            res=PS.executeUpdate();
            
            if(res>0){
                JOptionPane.showMessageDialog(null, "registro eliminado con exito");
            }
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"Error al eliminar los datos en la base de datos: "+e.getMessage());
        
        }
        
        return res;
    }
    
    
    
    public DefaultTableModel getDatos(){
        
        try{
            setTitulos();
            PS=CN.getConnection().prepareStatement(SQL_SELECT);
            RS=PS.executeQuery();
            Object[]fila=new Object[5];
            
            while(RS.next()){
             
               
                fila[0]=RS.getInt(1);
                fila[1]=RS.getString(2);
                fila[2]=RS.getInt(3);
                fila[3]=RS.getDouble(4);
                fila[4]=RS.getDouble(5);
                
                DT.addRow(fila);
            }
            
        }catch(SQLException e){
            
            System.out.println("Error al listar los datos "+e.getMessage());
            
        }
        
        return DT;
    }

    
    
    
    
}
