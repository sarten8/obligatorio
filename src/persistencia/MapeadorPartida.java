/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Fachada;
import modelo.Juego;
import modelo.Participante;

/**
 *
 * @author Usuario
 */
public class MapeadorPartida implements Mapeador{
    
    private Juego jue; 
    
    public MapeadorPartida(){}
    
    public MapeadorPartida(Juego j){
        jue = j;
    }

    @Override
    public int getOid() {
       return jue.getOid();
    }

    @Override
    public void setOid(int oid) {
        jue.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsert() {
       ArrayList<String> sqls = new ArrayList();
        sqls.add("INSERT INTO partidas VALUES (" + getOid() + "," 
                                                + jue.getMaxJugadores() + 
                ",'"+jue.getFechaInicio()+"',"+jue.getCantidadManos()+","+jue.getTotalApostado()+")" );
        generarParticipantes(sqls);
        return sqls;
    }
    
     private void generarParticipantes(ArrayList<String> sqls){
        int nro=1;
        for(Participante p:jue.getParticipantes()){
            sqls.add("INSERT INTO participantes VALUES (" + getOid() + ","
                                                  + p.getJugador().getOid() + ","
                                                  + p.getSaldoGanado() + "," + p.getSaldoApostado()
                                                  + ",'" + p.getSaldoInicial() + "')"
            );
            nro++;
        }
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
       return "SELECT * FROM partidas a,participantes b where b.partidaid=a.oid";
    }

    @Override
    public void cargarRegistro(ResultSet rs) throws SQLException {
        jue.setOid(rs.getInt("oid"));
        jue.setFechaInicio(rs.getString("FechaInicio"));
        jue.setTotalApostado(rs.getInt("TotalApostado"));
        jue.setMaxJugadores(rs.getInt("CantidadJugadores"));
        jue.setCantidadManos(rs.getInt("CantidadManos"));
        jue.setEstado(Juego.Estado.Finalizado);
        
    }

    @Override
    public void crearNuevo() {
      jue = new Juego();
    }
    
    public void SetearObjeto(Object juego) {
      jue=(Juego)juego;
    }

    @Override
    public Object getObjeto() {
       return jue;
    }

    @Override
    public void cargarLineas(ResultSet rs) throws SQLException{
       Participante p = new Participante();
       p.setSaldoApostado(rs.getInt("b.TotalApostado"));
       p.setSaldoGanado(rs.getInt("TotalGanado"));
       p.setSaldoInicial(rs.getInt("SaldoInicial"));
       p.setJugador(Fachada.getInstancia().buscarJugador(rs.getInt("UsuarioId")));
       
       jue.AgregarParticipante(p);
    }
    
}
