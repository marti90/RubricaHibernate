package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VOCE")
public class VoceModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_voce;
	
	@ManyToOne
	private RubricaModel rubrica;
	
	private String nome="";
	private String cognome="";
	private String telefono="";

	public VoceModel(String nome, String cognome, String telefono) {
	
		this.setNome(nome);
		this.setCognome(cognome);
		this.setTelefono(telefono);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public long getId_voce() {
		return id_voce;
	}

	public void setId_voce(long id_voce) {
		this.id_voce = id_voce;
	}

	
	
    public String toString(){
    	return id_voce+" "+nome+" "+cognome+" "+telefono;
		
	}

	public RubricaModel getRubrica() {
		return rubrica;
	}

	public void setRubrica(RubricaModel rubrica) {
		this.rubrica = rubrica;
	}

}
