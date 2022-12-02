import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {

		String arquivoResultado = "resultado.txt";
		String arquivoLeitura = "leitura.txt";

		// ManipuladorArquivo.leitor(arquivoLeitura);
//		ManipuladorArquivo.escritor(arquivoResultado);
//		ManipuladorArquivo.leitor(arquivoResultado);
//		ManipuladorArquivo.escritorELeitura(arquivoResultado, arquivoLeitura);
		
		//MODELO DE VERIFICAÇÃO SE A PALAVRA RESERVADA É UTILIZADA
		String teste = "voides";
		boolean hehe = Constantes.validar(teste);
		System.out.println(hehe);

	}

}
