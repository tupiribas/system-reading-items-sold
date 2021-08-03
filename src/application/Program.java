package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Produto> listProduct = new ArrayList<Produto>();
		
		System.out.println("Digite um o caminho do arquivo: ");
		String path = sc.nextLine();
		
		File p = new File(path);
		String arquivoFonte = p.getParent();
		
		boolean succes = new File(arquivoFonte + "\\out").mkdir(); // criar arquivo out
		
		String arquivoDestino = arquivoFonte + "\\out\\summary.csv";
		
		// Leitura do arquivo da variável path
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while (line != null) {
				String[] vet = line.split(",");
				String nomeProduto = vet[0];
				double precoProduto = Double.parseDouble(vet[1]);
				int quantidadeProduto = Integer.parseInt(vet[2]);
				
				listProduct.add(new Produto(nomeProduto, precoProduto, quantidadeProduto));
				line = br.readLine();
			}
			// Transcrevendo dados tratados para novo arquivo
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoDestino))) {
				
				for (Produto iten : listProduct) {
					bw.write(iten.getNome() + ", " + String.format("%.2f", iten.valorTotal()));
					bw.newLine();
				}
				System.out.println("Arquivo " + arquivoDestino + " criado com sucesso!");
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();

	}
}
