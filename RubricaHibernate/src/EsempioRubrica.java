import model.RubricaModel;
import dao.RubricaDAO;
//import service.ServiziRubrica;


public class EsempioRubrica {

	public static void main(String[] args) {
		
		//ServiziRubrica sr = new ServiziRubrica();
		
		//System.out.println("La rubrica è stata creata? "+sr.registraRubrica("Rubrica1"));
		
		RubricaDAO rDao = new RubricaDAO();
		RubricaModel r = rDao.readRubricaConId(1);
		
		long l = r.getId_rubrica();
		System.out.println(r.getNome()+" "+l);

	}

}
