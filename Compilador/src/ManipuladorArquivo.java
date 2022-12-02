import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

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
			System.out.println("Não foi possível verificar o arquivo");
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
		//DECLARAÇÃO DE VÁRIAVEIS UTILIZADAS
		
		/*BufferedReader buffRead = new BufferedReader(new FileReader(pathLeitura));
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(pathEscrita));
		*/
		scannerArquivo(pathLeitura);
		/*
		int qtdPalavrasReservadas = 0;
		int palavrasReservadas = 0;
		int qtdLinhas = 0;
		
		//VERIFICAÇÃO SE FOI POSSÍVEL LER O ARQUIVO
		if(buffRead != null) {
			String linha = "";
			
			//PERCORRE O ARQUIVO LINHA A LINHA
			while (true) {
				if (linha != null) {
					//PROXIMO_TOKEN
					//validaBlocoDeInstrucao(linha);
					CaracteresEspeciais.teste(linha.toUpperCase());
					//palavrasReservadas = verificarPalavrasReservadas(linha);
					if(linha != "") {
						//System.out.print(linha +"\n");
						buffWrite.append(linha + "\n");
					}else {
						//System.out.print(linha);
						buffWrite.append(linha);
					}
					
				} else {
					break;
				}
				linha = buffRead.readLine();
				qtdLinhas++;
				qtdPalavrasReservadas += palavrasReservadas;
				palavrasReservadas = 0;
			}
			buffWrite.append("\nQuantidade linhas: "+qtdLinhas);
			//FINALIZA O ARQUIVO CASO NÃO TENHA MAIS LINHAS PARA SER LIDO
			buffWrite.close();
			buffRead.close();
		}else {
			System.out.println("Não foi possível verificar o arquivo");
		}
		*/
	}

	private static void scannerArquivo(String pathLeitura) throws IOException {
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("resultado.txt"));
		
		Scanner scanner = new Scanner(pathLeitura);
		Parser  parser = new Parser(scanner);
		
		parser.inicioVerificacao(buffWrite);
		
	}

}