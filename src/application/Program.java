package application;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite as informações do produto: ");
		String info = sc.nextLine();
		
		String i[] = new String[3];
		i = info.split(",");
		
		for (String s : i) {
			System.out.print(s);
		}
		
		
		sc.close();
	}
}
