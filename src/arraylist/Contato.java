package arraylist;

import java.io.Serializable;

public class Contato implements Comparable <Contato>, Serializable{
// Classe para armazenar um contato.
	private String Nome;
	private String Telefone;
	
	public Contato() {
		this.Nome = "";
		this.Telefone = "";
	}

	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}

	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	// reescrevendo o metodo para comparar os contatos
	@Override
	public int compareTo(Contato e) {
		return this.Nome.compareTo(e.getNome());
	}
	
}
