package service;

import dao.RubricaDAO;
import dao.VoceDAO;
import model.RubricaModel;
import model.VoceModel;

public class ServiziRubrica {
	
	private RubricaDAO rDao = new RubricaDAO();
	private VoceDAO vDao = new VoceDAO();
	
	public boolean registraRubrica(String nome){
		
		boolean res = false;
		RubricaModel r = new RubricaModel(nome);
		res=rDao.createRubrica(r);
		
		return res;
	}
	
	public boolean aggiungiVoce(RubricaModel r, String nome, String cognome, String tel){
		
		boolean res = false;
		VoceModel v = new VoceModel(nome,cognome,tel);
		v.setRubrica(r);
		r.addVoce(v);
		
		res= vDao.createVoce(v);
		rDao.aggiornaRubrica(r);
		
		return res;
	}


}
