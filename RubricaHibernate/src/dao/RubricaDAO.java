package dao;

import utility.HibernateUtility;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.RubricaModel;

public class RubricaDAO {
	
	public RubricaModel readRubricaConId(long r_id){
		
		RubricaModel r = null;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
	        tx=session.getTransaction();
	        tx.begin();
	        
	        r=session.get(RubricaModel.class,  r_id);
	        
	        tx.commit(); 
            
	    }catch(Exception ex){
	         tx.rollback();

	    }finally{
	         session.close();
	    }
	    
		return r;
		
	}
		
	public RubricaModel readRubricaConNome(String nome){
		
        RubricaModel r = null;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
	
		try{
	        tx=session.getTransaction();
	        tx.begin();
	        
	        String sql="FROM RUBRICA WHERE NOME=: nomeInserito";
			Query query = session.createQuery(sql);
	        
	        query.setString("nomeInserito", nome);
	        r = (RubricaModel) query.uniqueResult();
	        
	        tx.commit(); 
            
	    }catch(Exception ex){
	         tx.rollback();

	    }finally{
	         session.close();
	    }
	    
		return r;
	}
	
	public boolean createRubrica(RubricaModel r){
	
		boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.persist(r);
		        
		       tx.commit(); 
		       res = true;
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return res;
	}
	
    public boolean deleteRubrica(long id_rubrica){
    	
    	boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       //session.persist(r);
		        
		       tx.commit(); 
		       res = true;
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return res;
    }
    
    public boolean aggiornaRubrica(RubricaModel r){
    	boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.update(r);
		        
		       tx.commit(); 
		       res = true;
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return res;
    }

}
