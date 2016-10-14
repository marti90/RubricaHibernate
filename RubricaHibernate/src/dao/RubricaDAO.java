package dao;

import utility.HibernateUtility;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.RubricaModel;

public class RubricaDAO {
	
	public RubricaModel readRubrica(String nome){
		
        RubricaModel r = null;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		String sql="FROM RUBRICA WHERE NOME=: 1";
		Query query = session.createQuery(sql);
		
		try{
	        tx=session.getTransaction();
	        tx.begin();
	        
	        query.setString(1, nome);
	        r = (RubricaModel) query.uniqueResult();
	        
	        tx.commit(); 
            
	    }catch(Exception ex){
	         tx.rollback();

	    }finally{
	         session.close();
	    }
	    
		return r;
	}
	
	public void creaRubrica(RubricaModel r){
	
		Session session=HibernateUtility.openSession();
		
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.persist(r);
		        
		       tx.commit(); 
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
	}
	
    public RubricaModel leggiRubricaConId(long id){
		
		RubricaModel r = null;
		
		Connection con = null;
        String sql = "SELECT * FROM RUBRICA WHERE ID_RUBRICA=?";
		ResultSet res = null;
		PreparedStatement pst = null;
		
		try {
			con = DataSource.getInstance().getConnection();
			pst= con.prepareStatement(sql);
			pst.setLong(1, id);
			res= pst.executeQuery();
			
			if(res.next()){
				long id_rubrica= res.getLong(1);
				String nome = res.getString(2);
				
				r= new RubricaModel(id_rubrica,nome);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		
		}finally{
			if (res != null) try { res.close(); } catch (SQLException e) {e.printStackTrace();}
			if (pst != null) try { pst.close(); } catch (SQLException e) {e.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException e) {e.printStackTrace();}
		}
		
		return r;
	}
    
    public boolean eliminaRubrica(long id_rubrica){
    	
    	boolean res = false;
    	Connection con = null;
    	String sql = "DELETE FROM RUBRICA WHERE ID_RUBRICA=?";
    	PreparedStatement pst = null;
    	
    	try {
			 con = DataSource.getInstance().getConnection();
			 pst = con.prepareStatement(sql);
			 pst.setLong(1, id_rubrica);
			 int rs =pst.executeUpdate();
			 if(rs>0){
				 res=true;
			 }
			 
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally{
			//if (res != null) try { res.close(); } catch (SQLException e) {e.printStackTrace();}
			if (pst != null) try { pst.close(); } catch (SQLException e) {e.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException e) {e.printStackTrace();}
		}
    	return res;
    }

}
