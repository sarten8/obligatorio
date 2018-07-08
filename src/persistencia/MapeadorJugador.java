/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Jugador;

public class MapeadorJugador implements Mapeador {
    
    private Jugador jug;
    
    public MapeadorJugador() {
        
    }
    
    public MapeadorJugador(Jugador jug) {
        this.jug = jug;
    }
    
    @Override
    public int getOid() {
        return jug.getOid();
    }

    @Override
    public void setOid(int oid) {
        jug.setOid(oid);
    }

    @Override
    public void crearNuevo() {
        jug = new Jugador();
    }

    @Override
    public Object getObjeto() {
        return jug;
    }

//    @Override
//    public String getSqlDelete() {
//        return "DELETE FROM producto WHERE oid=" + prod.getOid();
//    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM usuarios where tipo='J'";
    }

    //FINALIZAR CON LAS TABLAS DEFINIDAS
    //----------------------------------
    //----------------------------------
    //----------------------------------
    @Override
    public ArrayList<String> getSqlInsert() {
        ArrayList<String> sqls = new ArrayList();
//        sqls.add("INSERT INTO producto values ();
        return sqls;
    }
    //----------------------------------
    //----------------------------------
    //----------------------------------

    //FINALIZAR CON LAS TABLAS DEFINIDAS
    //----------------------------------
    //----------------------------------
    //----------------------------------
//    @Override
//    public ArrayList<String> getSqlUpdate() {
//         ArrayList<String> sqls = new ArrayList();   
//         sqls.add("UPDATE producto SET stock = '" + prod.getStockDisponible()
//                 + "' WHERE oid=" + getOid() );
//         return sqls;
//    }
    //----------------------------------
    //----------------------------------
    //----------------------------------

    //PARA TERMINAR
    //----------------------------------
    //----------------------------------
    //----------------------------------
    @Override
    public void cargarRegistro(ResultSet rs) throws SQLException {
        jug.setOid(rs.getInt("oid"));
        jug.setPass(rs.getString("password"));
        jug.setNombre(rs.getString("nombre"));
        jug.setUser(rs.getString("usuario"));
        jug.setSaldo(rs.getInt("Saldo"));
        
       
    }
    //----------------------------------
    //----------------------------------
    //----------------------------------

    @Override
    public ArrayList<String> getSqlUpdate() {
       ArrayList<String> sqls = new ArrayList();   
         sqls.add("UPDATE usuarios SET Saldo = " + jug.getSaldo()
                 + " WHERE oid=" + getOid() );
         return sqls;
    }

    @Override
    public String getSqlDelete() {
       return "";
    }

    @Override
    public void cargarLineas(ResultSet rs) throws SQLException {

    }
    
}
