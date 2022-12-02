
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {

	public static void leitor(String pathLeitura) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(pathLeitura));
		if(buffRead != null) {
			String linha = "";
			while (true) {
				if (linha != null) {
					System.out.println(linha);

				} else
					break;
				linha = buffRead.readLine();
			}
			buffRead.close();
		}else {
			System.out.println("N�o foi poss�vel verificar o arquivo");
		}
		
	}

	public static void escritor(String pathEscrita) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(pathEscrita));
		buffWrite.append("Teste escrita");
		buffWrite.close();
/*
		String linha = "";
		Scanner in = new Scanner(System.in);
		//System.out.println("Escreva algo: ");
		linha = in.nextLine();
		*/
	}
	
	public static void escritorELeitura(String pathEscrita, String pathLeitura) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(pathLeitura));
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(pathEscrita));
		
		if(buffRead != null) {
			String linha = "";
			int qtdPalavrasReservadas = 0;
			int palavrasReservadas = 0;
			int qtdLinhas = 0;
			while (true) {
				if (linha != null) {
					palavrasReservadas = verificarPalavrasReservadas(linha);
					System.out.print(linha+"\n");
					buffWrite.append(linha+"\n");
				} else {
					break;
				}
				linha = buffRead.readLine();
				qtdLinhas++;
				qtdPalavrasReservadas += palavrasReservadas;
				palavrasReservadas = 0;
			}
			buffWrite.append("Quantidade linhas: "+qtdLinhas);
			buffWrite.close();
			buffRead.close();
		}else {
			System.out.println("N�o foi poss�vel verificar o arquivo");
		}
		
	}

	private static int verificarPalavrasReservadas(String linha) {
		if(linha.contains("")) {
			
		}
		
		return 0;
	}

}