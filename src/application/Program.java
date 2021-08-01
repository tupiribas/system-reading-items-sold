package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import entities.Produto;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = null;
		File file = new File("C:\\pastaarquivo\\in.txt");
		
		try {
			String[] i = new String[3];
			
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				i = sc.nextLine().split(", ");
			}
			
			Produto product = new Produto(i[0], Double.parseDouble(i[1]), Integer.parseInt(i[2]));
			
			System.out.println("Nome do produto: " + product.getNome());
			System.out.println("Preço do produto: " + product.getPreco());
			System.out.println("Preço do produto: " + product.getQuantidade());
			
		}
		catch (IOException e) {
			System.out.println("Erro >>> " + e.getMessage());
		}
		finally {
			if (sc != null) {
				sc.close();
			}
		}
		
		
		sc.close();
	}
}
