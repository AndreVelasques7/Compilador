
public enum Atributos {
	
	VAR_ID("var", 1),
	VAR_SOMA("+", 2),
	VAR_MULTIPLICACAO("*", 3),
	VAR_SUBTRACAO("-", 4),
	VAR_LEITURA("print", 5),
	VAR_LEITURA_E_LINHA("println", 5),
	VAR_ATRIBUICAO("=", 6),
	INICIO_PROG("main()", 7),
	FINAL_PROG("end",8),
	FINAL_LINHA(";", 9);
	
	private String valor;
	private int codigo;

	private Atributos(String valor, int codigo) {
		this.codigo = codigo;
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
