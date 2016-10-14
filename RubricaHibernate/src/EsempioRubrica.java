

import model.RubricaModel;
import dao.RubricaDAO;
import service.ServiziRubrica;


public class EsempioRubrica {

	public static void main(String[] args) {
         
		ServiziRubrica sr = new ServiziRubrica();
//		
//        System.out.println("La rubrica è stata creata? "+sr.registraRubrica("Rubrica3"));
         
         
		RubricaDAO rDao = new RubricaDAO();
		
		RubricaModel r =rDao.readRubricaConId(2);
		
	   // System.out.println(r.getNome());
		
		sr.aggiungiVoce(r, "Martina", "Debernardi", "011");
		
		

	}

}
