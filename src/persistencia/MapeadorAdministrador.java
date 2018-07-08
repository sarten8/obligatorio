package persistencia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Administrador;

/**
 *
 * @author Usuario
 */
public class MapeadorAdministrador implements Mapeador {

    private Administrador adm;
    
    public MapeadorAdministrador() {
    }

    @Override
    public int getOid() {
       return adm.getOid();
    }

    @Override
    public void setOid(int oid) {
        adm.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSelect() {
         return "SELECT * FROM usuarios where tipo='A'";
    }

    @Override
    public void cargarRegistro(ResultSet rs) throws SQLException {
        adm.setOid(rs.getInt("oid"));
        adm.setPass(rs.getString("password"));
        adm.setNombre(rs.getString("nombre"));
        adm.setUser(rs.getString("usuario"));
    }

    @Override
    public void crearNuevo() {
       adm = new Administrador();
    }

    @Override
    public Object getObjeto() {
       return adm;
    }

    @Override
    public void cargarLineas(ResultSet rs) throws SQLException {

    }
    
}
