package br.com.itego.bean;

import java.util.ArrayList;

import java.util.List;
import br.com.itego.dao.AutorDAO;
import br.com.itego.dao.LivroDAO;
import br.com.itego.modelo.Autor;
import br.com.itego.modelo.Livro;

public class Teste {

	/*
	 * No projeto LivrariaJSF de voc�s crie uma classe de teste (Caso ela j� exista,
	 * apenas reutilize-a) para rodar (Java Application) as seguintes consultas
	 * (crie um m�todo para cada):
	 * 
	 * 1) Traga a Quantidade de Livros Cadastrados // ~~~~~~~~~~~~~~~~~~~~~~OK! 
	 * 2) Traga Todos os autores e
	 * a quantidade de livros que cada um escreveu (traga tamb�m os que n�o
	 * escreveram) 
	 * 3) Traga todos os autores e o t�tulo dos livros que escreveram.
	 * 4) Traga os autores ordenador de forma crescente por nome. ~~~~~~~~~~~~~~~~// OK!
	 * 
	 * Para pr�xima aula: Envie como resposta a esse e-mail o arquivo de teste afim
	 * de compararmos as solu��es com as dos colegas. No corpo do e-mail, comente
	 * sobre quais foram as dificuldades, se passou por alguma situa��o de exce��o
	 * de Lazy ou outras exce��es.
	 */

	public static void main(String[] args) {
		
		// Para executar, basta chamar os m�todos dentro deste main, Ex: getQuantidadeLivrosJPQL();
		// getQuantidadeLivrosJPQL(); // Quest�o 1;
		 getAutoresDoLivroJPQL(); // Quest�o 2;
 		// getAutoresTitulosJPQL(); // Quest�o 3;
		//listarAutoresJPQL(); // Quest�o 4;

	}

	public static void getQuantidadeLivrosJPQL() { // Quest�o 1;

		Long qtde = new LivroDAO().quantidadeLivrosJPQL();

		System.out.println("Quantidade de Livros Cadastrados: " + qtde);
	}

	public static void getAutoresDoLivroJPQL() { // Quest�o 2;

		AutorDAO dao = new AutorDAO();
		List<Object[]> rst = dao.getAutoresDoLivroJPQL();
		for (Object[] autoresdolivro  : rst) {
				System.out.println("Nome do Autor: " + autoresdolivro[0] + " \nQuantidade de Livros: " + autoresdolivro[1]);

		}
	}
	
	public static void getAutoresTitulosJPQL() { // Quest�o 3;
		AutorDAO dao = new AutorDAO();
		List<Livro> livros =  dao.getAutoresTitulosJPQL();
		
		for (Livro lvr : livros) {
			for (Autor atr : lvr.getAutores()) {
				System.out.println("Nome do Autor: " + atr.getNome() + "\nT�tulo do Livro: " + lvr.getTitulo());
			}
			
		}
		
	}

	public static void listarAutoresJPQL() { // Quest�o 4;
		List<Autor> autores = new AutorDAO().listarAutoresJPQL();
		for (Autor a : autores) {
			System.out.println("Nome do Autor: " + a.getNome());
		}
	}
	
	

}
