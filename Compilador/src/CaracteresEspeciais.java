public enum CaracteresEspeciais {
	
	PONTO_E_VIRGULA(";", 34),
	A_PARENTESES("(", 35),
	F_PARENTESES(")", 36),
    VIRGULA(",", 36),
    IGUAL("=", 37),
	QUEBRA_DE_LINHA("\n", 38),
    TABULACAO("\t", 39),
    BACKSPACE("\b", 40),
    RETORNO_DE_LINHA("\r", 41),
    BARRA_INVERTIDA("\\", 42),
    ASPAS("\"", 43),
    APOSTROFO("\'", 44),
    A_CHAVES("{", 45),
    F_CHAVES("}", 46);
	
	
	private String valor;
	private int codigo;

	private CaracteresEspeciais(String valor, int codigo) {
		this.codigo = codigo;
		this.valor = valor;
	}

	public static CaracteresEspeciais validar(String constEnum) {
		try {
			CaracteresEspeciais ret = null;
			if (constEnum != null) {
				ret = CaracteresEspeciais.valueOf(constEnum);
			}
			return ret;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static boolean teste(String constEnum) {
		try {
			CaracteresEspeciais arr[] = CaracteresEspeciais.values();
			
			for (CaracteresEspeciais col : arr) {
				if(col.getValor().equals(constEnum)) {
					return true;
				}
				//System.out.println("Teste obtendo todos valores -> Caracter: "+ col + " Valor: " +  col.getValor() + "\n");
			}
			
			return false;
		} catch (Exception e) {
			return false;
		}
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
