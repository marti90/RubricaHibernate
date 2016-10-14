package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import rubrica.VoceModel;
import rubrica.DataSource;


public class VoceDAO {
	
	

	public boolean aggiungiVoce(String nome, String cognome, String telefono, long id_rubrica){
		
		Connection con = null;
		String sql = "INSERT INTO VOCE(NOME,COGNOME,TELEFONO,ID_RUBRICA) VALUES(?,?,?,?)";
		PreparedStatement pst = null;
		boolean res=false;
	
		try {
		    con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, telefono);
			pst.setLong(4, id_rubrica);
			
			int rs= pst.executeUpdate();
			if(rs>0){
				res=true;
			}
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally{
			if (pst != null) try { pst.close(); } catch (SQLException e) {e.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException e) {e.printStackTrace();}
		}
		
		return res;
	
	}
	
	public VoceModel leggiVoceConId(long id_voce){
		
		VoceModel v = null;
		Connection con = null;
		String sql = "SELECT * FROM VOCE WHERE ID_VOCE=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);
			pst.setLong(1, id_voce);
			
			rs = pst.executeQuery();
			
			while(rs.next()){
				long id_v = rs.getLong(1);
				String nome = rs.getString(2);
				String cognome = rs.getString(3);
				String telefono = rs.getString(4);
				long id_r = rs.getLong(5);
				
				v = new VoceModel(id_v,nome,cognome,telefono,id_r);
			}
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally{
			if (rs != null) try { rs.close(); } catch (SQLException e) {e.printStackTrace();}
			if (pst != null) try { pst.close(); } catch (SQLException e) {e.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException e) {e.printStackTrace();}
		}
		
		return v;
	}
	
	public boolean cancellaVoceConId(long id_voce){
		boolean res = false;
		Connection con = null;
		String sql = "DELETE FROM VOCE WHERE ID_VOCE=?";
		PreparedStatement pst = null;
		try {
			 con = DataSource.getInstance().getConnection();
			 pst=con.prepareStatement(sql);
			 pst.setLong(1, id_voce);
			 int rs=pst.executeUpdate();
			 
			 if(rs>0){
				 res = true;
			 }
			 
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally{
			if (pst != null) try { pst.close(); } catch (SQLException e) {e.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException e) {e.printStackTrace();}
		}
		
		return res;
	}
	
	public boolean aggiornaVoce(long id_voce, String nomeNuovo, String cognomeNuovo, String telefonoNuovo, long id_rubrica){
		
		boolean res = false;
		Connection con = null;
		String sql = "UPDATE VOCE SET NOME=?,COGNOME=?,TELEFONO=?,ID_RUBRICA=? WHERE ID_VOCE=?";
		PreparedStatement pst =null;
		
		try {
			con = DataSource.getInstance().getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1, nomeNuovo);
			pst.setString(2, cognomeNuovo);
			pst.setString(3, telefonoNuovo);
			pst.setLong(4, id_rubrica);
			pst.setLong(5, id_voce);
			
			int rs=pst.executeUpdate();
			 
			 if(rs>0){
				 res = true;
			 }
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally{
			if (pst != null) try { pst.close(); } catch (SQLException e) {e.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException e) {e.printStackTrace();}
		}
		
		return res;
	}
	
	public List<VoceModel> leggiTutteVoci(long id_r){
		
		List<VoceModel> voci = new LinkedList<VoceModel>();
		VoceModel v = null;
		Connection con = null;
		String sql = "SELECT * FROM VOCE WHERE ID_RUBRICA=?";
		PreparedStatement pst = null;
		ResultSet res = null;
		
		try {
			con = DataSource.getInstance().getConnection();
			pst =con.prepareStatement(sql);
			pst.setLong(1,id_r);
			res = pst.executeQuery();
			
			while(res.next()){
				long id_v = res.getLong(1);
				String nome = res.getString(2);
				String cognome = res.getString(3);
				String telefono = res.getString(4);
				long id_rubrica = res.getLong(5);
				
				v = new VoceModel(id_v,nome,cognome,telefono,id_rubrica);
				voci.add(v);
			}
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally{
			if (res != null) try { res.close(); } catch (SQLException e) {e.printStackTrace();}
			if (pst != null) try { pst.close(); } catch (SQLException e) {e.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException e) {e.printStackTrace();}
		}
		return voci;
	}

}
