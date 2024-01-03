package arraylist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


// classe que grava os objetos

public class Persistencia  {
	public static void serializaGrava(String caminhoNome, Object objeto) throws Exception {
		// criando um objeto que recebe o caminho, especificamente um arquivo de saida
		FileOutputStream arqSaida;
		ObjectOutputStream streamSaida;
		try{
			arqSaida = new FileOutputStream(caminhoNome); // cria um caminho do codigo para ser salvo
			streamSaida = new ObjectOutputStream (arqSaida); // reescrever o arquivo selecionado anteriormente
			// grava o objeto selecionado
			streamSaida.writeObject(objeto);
			streamSaida.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static Object leDeserializa(String caminhoNome) throws Exception {
		FileInputStream arqEntrada;
		ObjectInputStream streamEntrada;
		try{
			 arqEntrada = new FileInputStream (caminhoNome); // pega o arquivo 
			streamEntrada = new ObjectInputStream (arqEntrada); // interpreta o arquivo 
			
			Object objetoLido = streamEntrada.readObject(); // pega o objeto do arquivo
			streamEntrada.close(); 
			return objetoLido; 
		}catch(IOException e) {
			e.printStackTrace();
			return null;
			
		}
		
		
	}
}
