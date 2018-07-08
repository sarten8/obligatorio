package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Persistencia {
    
    private static Persistencia instancia = new Persistencia();
    private BaseDatos base;

    public static Persistencia getInstancia() {
        return instancia;
    }

    private Persistencia() {
        base = BaseDatos.getInstancia();
        base.conectar("root", "rootroot", "jdbc:mysql://localhost:3306/pocker");
    }
    private int proximoOid(){
        int oid=-1;
        ResultSet rs = base.consultar("SELECT valor FROM oid");
        try {
            if(!rs.next()){
                System.out.println("FALTA REGISTRO DE OID");
            }
            oid = rs.getInt("valor")+1;
            base.actualizar("update OID set valor = " + oid);
        } catch (SQLException ex) { 
            System.out.println("Error al obtener oid:" + ex.getMessage());
        }
        return oid;
    }
    public void guardar(Mapeador m){
        if(m.getOid()<1){
            insertar(m);
        }else modificar(m);
    }

    private void insertar(Mapeador m) {
        int oid = proximoOid();
        m.setOid(oid);
        ArrayList<String> sqls = m.getSqlInsert();
        if (!base.transaccion(sqls)){
            m.setOid(0);
        }
         
    }

    private boolean modificar(Mapeador m) {
        ArrayList<String> sqls = m.getSqlUpdate();
        return base.transaccion(sqls);
        
    }
    public void borrar(Mapeador m){
        if(m.getOid()>0){
            String sql = m.getSqlDelete();
            int f = base.actualizar(sql);
            if(f>0){
                m.setOid(0);
            }
        }
    }
    
    public ArrayList obtenerTodos(Mapeador map){
        return buscar(map,null);
    }
    
    public ArrayList buscar(Mapeador map, String filtro){
        ArrayList objetos = new ArrayList();
        String sql = map.getSqlSelect();
        if(filtro!=null)sql += " WHERE " + filtro;
        ResultSet rs = base.consultar(sql);
        try {
            int oidAnt=-1;
            int oidActual;      
            while(rs.next()){
                oidActual = rs.getInt("oid"); //EL CAMPO DEBE LLAMARSE ASI
               if(oidActual!=oidAnt){
                map.crearNuevo();
                map.setOid(oidActual); //el campo debe llamarse asi
                map.cargarRegistro(rs);
                 oidAnt = oidActual;
                
                objetos.add(map.getObjeto());

            }
            map.cargarLineas(rs);
            }
            return objetos;
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.getMessage());
            return null;
        }
    }
    
    //EVALUAR---- FUNCIONA OK PERO COMPLICA EL CAST
    public Object buscarUnico(Mapeador map, String filtro){
        Object obj = new Object();
        String sql = map.getSqlSelect() + " WHERE " + filtro;;
        ResultSet rs = base.consultar(sql);
        try {           
            while(rs.next()){
                
                map.crearNuevo();
                map.setOid(rs.getInt("oid")); //el campo debe llamarse asi
                map.cargarRegistro(rs);
                obj = map.getObjeto();

            }
            return obj;
        }catch (SQLException ex) {
           System.out.println("Error:" + ex.getMessage());
           return null;
        }
    }
}
