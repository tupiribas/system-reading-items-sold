package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = null;
		File file = new File("C:\\pastaarquivo\\in.txt");
		
		try {
			String i[] = new String[3];
			
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				i = sc.nextLine().split(",");
			}
			
			System.out.println("Informações: ");
			for (String s : i) {
				System.out.print(s);
			}
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
