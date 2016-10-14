

//import model.RubricaModel;
import model.VoceModel;
//import dao.RubricaDAO;
import dao.VoceDAO;
//import service.ServiziRubrica;


public class EsempioRubrica {

	public static void main(String[] args) {
         
//		ServiziRubrica sr = new ServiziRubrica();
//		
//        System.out.println("La rubrica è stata creata? "+sr.registraRubrica("Rubrica3"));
         
         
		//RubricaDAO rDao = new RubricaDAO();
		
		//RubricaModel r =rDao.readRubricaConId(2);
		
	   // System.out.println(r.getNome());
		
		/*sr.aggiungiVoce(r, "Martina", "Debernardi", "011");
		sr.aggiungiVoce(r, "Luca", "Umoretto", "25639");
		sr.aggiungiVoce(r, "Irene", "Aimone", "74896");
		*/
		
		VoceDAO vDao = new VoceDAO();
		
		VoceModel v = vDao.leggiVoceConId(5);
		System.out.println(v.getNome());

	}

}
