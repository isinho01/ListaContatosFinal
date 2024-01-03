package arraylist;

import java.util.Scanner;

public class Teste {
	// Classe main que deve executar a agenda
	public static void main(String[] args) {
		Agenda agenda = new Agenda ();
		Scanner tec = new Scanner (System.in);
		int numerodigitado = 1;
		String nome;
		String telefone;
		while (numerodigitado >0 || numerodigitado <4) {
			System.out.println("1: Inserir Contato ");
			System.out.println("2: Buscar Contato ");
			System.out.println("3: Remover Contato  ");
			numerodigitado = tec.nextInt();
			tec.nextLine();
			switch (numerodigitado) {
				 
			case 1:
				System.out.println("Insira o nome ! ");
				nome = tec.nextLine();
				System.out.println("Insira o telefone");
				telefone = tec.nextLine();
				if (agenda.inserir(nome, telefone)) {
					System.out.println("Contato cadastrado ! ");
					break;
				}
				System.out.println(" nao foi possivel cadastrar. ");
			break;
				
			case 2:
				
				System.out.println("por favor insira um nome para buscar ");
				nome = tec.nextLine();
				if (agenda.buscar(nome) == null) {
					System.out.println("contato nao encontrado !");
					break;
				}
				System.out.println("foi encontrado um contato !");
				System.out.println(agenda.buscar(nome).getNome());
				System.out.println(agenda.buscar(nome).getTelefone());
				break;
				
		
				
			case 3:
				System.out.println("por favor insira um nome para remover ");
				nome = tec.nextLine();
				if (agenda.Remover(nome)) {
				System.out.println("contato removido com sucesso ");
				break;
				}
				System.out.println("este contato nao existe. ");
			break;
			
			default: 
				System.out.println("Encerrando o programa !");
			break;
			}
				
		}
	}

}
