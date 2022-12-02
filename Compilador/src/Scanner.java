import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

//import br.com.professorisidro.compiler.exceptions.IsiLexicalException;
//import br.com.professorisidro.compiler.lexico.Token;

public class Scanner {

	private char[] content;
	private int estado;
	private int pos;
	private int line;
	private int column;

	public Scanner(String filename) {
		try {
			line = 1;
			column = 0;
			String txtConteudo;
			txtConteudo = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
			content = txtConteudo.toCharArray();
			pos = 0;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Token nextToken() throws IOException {
		char currentChar;
		Token token;
		String term = "";
		if (isEOF()) {
			return null;
		}
		estado = 0;
		while (true) {
			currentChar = nextChar();
			column++;

			switch (estado) {
			case 0:
				if (isChar(currentChar)) {
					term += currentChar;
					estado = 1;
				} else if (isDigit(currentChar)) {
					estado = 2;
					term += currentChar;
				} else if (isSpace(currentChar)) {
					estado = 0;
				} else if (isOperator(currentChar)) {
					term += currentChar;
					token = new Token();
					token.setType(Token.TK_OPERATOR);
					token.setText(term);
					token.setLine(line);
					token.setColumn(column - term.length());
					return token;
				} else if (isEndLine(currentChar)) {
					estado = 5;
					term += currentChar;
				} else if (isAspas(currentChar)) {
					estado = 6;
					term += currentChar;
				} else if (isAP(currentChar)) {
					estado = 7;
					term += currentChar;
				} else if (isFP(currentChar)) {
					estado = 8;
					term += currentChar;
				} else {
					// System.out.println("Simbolo não reconhecido -> " + currentChar);
				}
				break;
			case 1:
				if (isChar(currentChar) || isDigit(currentChar)) {
					estado = 1;
					term += currentChar;
				} else if (isSpace(currentChar) || isOperator(currentChar) || isEOF(currentChar)) {
					if (!isEOF(currentChar))
						back();
					if (isReservada(term)) {
						token = new Token();
						token.setType(Token.TK_RESERVADA);
						token.setText(term);
						token.setLine(line);
						token.setColumn(column - term.length());
						return token;
					} else {
						token = new Token();
						token.setType(Token.TK_IDENTIFIER);
						token.setText(term);
						token.setLine(line);
						token.setColumn(column - term.length());
						return token;
					}

				} else {
				}
				break;
			case 2:
				if (isDigit(currentChar) || currentChar == '.') {
					estado = 2;
					term += currentChar;
				} else if (!isChar(currentChar) || isEOF(currentChar)) {
					if (!isEOF(currentChar))
						back();
					token = new Token();
					token.setType(Token.TK_NUMBER);
					token.setText(term);
					token.setLine(line);
					token.setColumn(column - term.length());
					return token;
				} else {
					// throw new IsiLexicalException("Unrecognized Number");
				}
				break;
			case 5:
				if (isEndLine(currentChar)) {
					token = new Token();
					token.setType(Token.TK_ENDL);
					token.setText(term);
					token.setLine(line);
					token.setColumn(column - term.length());
					return token;
				}
				break;
			case 6:
				if (isAspas(currentChar)) {
					token = new Token();
					token.setType(Token.TK_ASPAS);
					token.setText(term);
					token.setLine(line);
					token.setColumn(column - term.length());
					return token;
				}
				break;
			case 7:
				if (isAP(currentChar)) {
					token = new Token();
					token.setType(Token.TK_AP);
					token.setText(term);
					token.setLine(line);
					token.setColumn(column - term.length());
					return token;
				}
				break;
			case 8:
				if (isFP(currentChar)) {
					token = new Token();
					token.setType(Token.TK_FP);
					token.setText(term);
					token.setLine(line);
					token.setColumn(column - term.length());
					return token;
				}
				break;
			case 9:
				if (isVirgula(currentChar)) {
					token = new Token();
					token.setType(Token.TK_VIR);
					token.setText(term);
					token.setLine(line);
					token.setColumn(column - term.length());
					return token;
				}
				break;
			}

		}

	}

	private boolean isReservada(String currentChar) {
		return PalavrasReservadas.validacaoReservada(currentChar);
	}

	private boolean isAP(char c) {
		return c == '(';
	}

	private boolean isFP(char c) {
		return c == ')';
	}

	private boolean isAspas(char c) {
		return c == '"';
	}

	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	private boolean isChar(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}

	private boolean isOperator(char c) {
		return c == '>' || c == '<' || c == '=' || c == '!' || c == '+' || c == '-' || c == '*' || c == '/';
	}

	private boolean isEndLine(char c) {
		return c == ';';
	}

	private boolean isVirgula(char c) {
		return c == ',';
	}

	private boolean isSpace(char c) {
		if (c == '\n' || c == '\r') {
			line++;
			column = 0;
		}
		return c == ' ' || c == '\t' || c == '\n' || c == '\r';
	}

	private char nextChar() {
		if (isEOF()) {
			return '\0';
		}
		return content[pos++];
	}

	private boolean isEOF() {
		return pos >= content.length;
	}

	private void back() {
		pos--;
		column--;
	}

	private boolean isEOF(char c) {
		return c == '\0';
	}

}
