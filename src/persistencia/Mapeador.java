package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Mapeador {

    public int getOid();
    
    public void setOid(int oid);

    public ArrayList<String> getSqlInsert();

    public ArrayList<String> getSqlUpdate();

    public String getSqlDelete();

    public String getSqlSelect();

    public void cargarRegistro(ResultSet rs) throws SQLException;

    public void crearNuevo();

    public Object getObjeto();

    public void cargarLineas(ResultSet rs)throws SQLException;
    
}
