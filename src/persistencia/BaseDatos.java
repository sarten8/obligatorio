package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDatos {
    
    private Connection conexion;
    private Statement stmt;
    
    private static BaseDatos instancia = new BaseDatos();

    public static BaseDatos getInstancia() {
        return instancia;
    }
    private BaseDatos() {
    }
    public void conectar(String usr,String pwd,String url){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(url, usr, pwd);
            stmt = conexion.createStatement();
        } catch (Exception ex) {
            System.out.println("Error al conectar:" + ex.getMessage());
        }
    }
    public void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
           
        }
    }
    public int actualizar(String sql){
        try {
            return stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error al actualizar:" + ex.getMessage());
            System.out.println("SQL:" + sql);
            return -1;
        }
    }
     public ResultSet consultar(String sql){
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error al consultar" + ex.getMessage());
            System.out.println("SQL:" + sql);
            return null;
        }
    }
    public boolean transaccion(ArrayList<String> sqls){
        try {
            conexion.setAutoCommit(false); //begin T
            for(String sql:sqls){
                if(actualizar(sql)==-1){
                    conexion.rollback();
                    return false;
                }
            }
            conexion.commit(); 
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar T:" + ex.getMessage());
        }finally{
            try {
                conexion.setAutoCommit(true); //begin T
            } catch (SQLException ex) {
                
            }
        }
        return true;
    }
    
}
