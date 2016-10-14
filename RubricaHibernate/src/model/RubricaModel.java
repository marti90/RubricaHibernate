package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name="RUBRICA")
public class RubricaModel {
	
	private String nome="";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_rubrica;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="rubrica",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<VoceModel> listaVoci = new HashSet<VoceModel>();
	
	public RubricaModel(){
		
	}
	
	public RubricaModel(String nome) {
	
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId_rubrica() {
		return id_rubrica;
	}

	public void setId_rubrica(long id_rubrica) {
		this.id_rubrica = id_rubrica;
	}
	

	public Set<VoceModel> getListaVoci() {
		return listaVoci;
	}

	public void setListaVoci(Set<VoceModel> listaVoci) {
		this.listaVoci = listaVoci;
	}
	
	public void addVoce(VoceModel v){
		this.listaVoci.add(v);
	}
	
	/*public VoceModel leggiVoce(long id_voce){
		
		VoceDAO vDao = new VoceDAO();
		return vDao.leggiVoceConId(id_voce);
	}
	
	public boolean cancellaVoce(long id_voce){
		
		VoceDAO vDao = new VoceDAO();
		return vDao.cancellaVoceConId(id_voce);
	}
	
	public boolean aggiornaVoce(long id_voce, String nuovoNome, String nuovoCognome, String nuovoTelefono){
		
		VoceDAO vDao = new VoceDAO();
		return vDao.aggiornaVoce(id_voce, nuovoNome, nuovoCognome, nuovoTelefono, this.id_rubrica);
	}
	
	public List<VoceModel> leggiTutteLeVoci(){
		
		VoceDAO vDao = new VoceDAO();
		return vDao.leggiTutteVoci(this.id_rubrica);
	}
	
	public String toString(){
		return id_rubrica+" "+nome;
	}
	*/

}
