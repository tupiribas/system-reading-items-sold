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

import entities.Produto;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		List<Produto> listProduct = new ArrayList<Produto>();
		String path = "C:\\pastaarquivo\\a.csv";
		
		File p = new File(path);
		String arquivoFonte = p.getParent();
		
		boolean succes = new File(arquivoFonte + "\\out").mkdir();
		
		String arquivoDestino = arquivoFonte + "\\out\\summary.csv";
		
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
		

	}
}
