import java.io.BufferedWriter;
import java.io.IOException;

public class Parser {
	private Scanner scanner; // analisador léxico
	private Token token; // o token atual

	/*
	 * o Parser recebe como parametro no construtor, pois utiliza 
	 * cada procedimento e invoca-o sob demanda
	 */
	public Parser(Scanner scanner) {
		this.scanner = scanner;
	}

	public void inicioVerificacao(BufferedWriter buffWrite) throws IOException {
		verificaToken(buffWrite);
		proximoElemento(buffWrite);

	}

	public void proximoElemento(BufferedWriter buffWrite) throws IOException {
		token = scanner.nextToken();
		if (token != null) {
			operator(buffWrite);
			verificaToken(buffWrite);
			proximoElemento(buffWrite);
		}

	}

	public void verificaToken(BufferedWriter buffWrite) throws IOException {
		token = scanner.nextToken();
		if (token.getType() != Token.TK_IDENTIFIER && token.getType() != Token.TK_NUMBER) {
			System.out.println(token);
			//buffWrite.write(token+"\n");
		}

	}

	public void operator(BufferedWriter buffWrite) throws IOException {
		if (token.getType() != Token.TK_OPERATOR) {
			System.out.println(token);
			//buffWrite.write(token+ "\n");
		}
	}
}
