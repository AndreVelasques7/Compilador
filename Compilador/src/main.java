import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {

		String arquivoResultado = "resultado.txt";
		String arquivoLeitura = "leitura.txt";

//		ManipuladorArquivo.leitor(arquivoLeitura);
//		ManipuladorArquivo.escritor(arquivoResultado);
//		ManipuladorArquivo.leitor(arquivoResultado);
		ManipuladorArquivo.escritorELeitura(arquivoResultado, arquivoLeitura);
		
		//MODELO DE VERIFICAÇÃO SE A PALAVRA RESERVADA É UTILIZADA - Passo o valor recebido para maiusculo por hora.
		/*
		String teste = "void";
		PalavrasReservadas hehe = PalavrasReservadas.validar(teste.toUpperCase());
		System.out.println(hehe);
		*/

	}

}
