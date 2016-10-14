package dao;




import java.util.Set;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtility;
import model.RubricaModel;
import model.VoceModel;
public class VoceDAO {
	
	public boolean createVoce(VoceModel v){
		
		boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.persist(v);
		        
		       tx.commit(); 
		       res = true;
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return res;
	}
	
	public VoceModel leggiVoceConId(long id_voce){
		
		VoceModel v = null;
		
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       v=session.get(VoceModel.class,  id_voce);
		        
		       tx.commit(); 
		       
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return v;
	}
	
	/*public boolean cancellaVoceConId(long id_voce){
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
	*/
	public boolean aggiornaVoce(VoceModel v){
		
		boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.update(v);
		        
		       tx.commit(); 
		       res = true;
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return res;
	}
	
	public Set<VoceModel> getVociPerUnaRubrica(long id_r){
		
		
		RubricaModel r = null;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
	        tx=session.getTransaction();
	        tx.begin();
	        
	        Query query = session.createQuery("from RubricaModel where id_rubrica =: idInserito");
	        r = (RubricaModel) query.uniqueResult();
	        
	        tx.commit(); 
            
	    }catch(Exception ex){
	         tx.rollback();

	    }finally{
	         session.close();
	    }
	    
		return r.getListaVoci();
		
	}

}
