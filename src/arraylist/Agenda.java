package arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class Agenda {
 //Classe principal que serve para armazenar a lista de seus contatos
	//criando um arraylist do tipo contato
	private ArrayList <Contato> contato;
	private int Quantidade_contatos;
	
	public Agenda () {
		this.contato = new ArrayList<>();
		this.Quantidade_contatos = 0;
	}
	public boolean inserir(String Nome, String Telefone) {
		
		Contato teste = new Contato();
		teste.setNome(Nome);
		teste.setTelefone(Telefone);
		Quantidade_contatos += 1;
		return contato.add(teste);
		
	}
	public Contato buscar (String Nome) {
		// o metdodo size retorna um inteiro de quantos elementos tem dentro do arraylist
		for (int i =0; i< contato.size(); i++) {
				// retona o objeto na posiçao I do arraylist
				if (contato.get(i).getNome().equals(Nome)) {
					return contato.get(i);
				}
			}
			
		return null;
				
	}
	public boolean Remover(String Nome) {
		for (int i =0; i< contato.size(); i++) {
			if (contato.get(i).getNome().equals(Nome)) {
				contato.remove(i);
				Quantidade_contatos -=1;
				return true;
			}
		}
		return false;
		
	}
	
	public int getQuantidade_contatos() {
		return Quantidade_contatos;
	}
	public int getTamanho () {
		return contato.size();
	}
	public Contato getContato(int i) {
		return contato.get(i);
	}
	// vai pegar todo o arraylist e fazer as comparaçoes 
	public void ordemalfabetica () {
		Collections.sort(contato);
	}
	public void saveagenda() throws Exception {
		Persistencia.serializaGrava("ContatoRestaurado.dat",contato);
	}
	public void carregandoagenda() throws Exception {
		// transformando o obejto em um arraylist
		ArrayList <Contato> temp = (ArrayList<Contato>) Persistencia.leDeserializa("ContatoRestaurado.dat");
		// conferindo se a variavel é nula 
		if (temp != null) {
			contato = temp;
			Quantidade_contatos = contato.size();
		}
	}
}
