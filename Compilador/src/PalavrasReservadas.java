public enum PalavrasReservadas {
	
	//PALAVRAS RESERVADAS
	ASM("asm", 1),
	AUTO("auto", 2),
	BREAK("break", 3),
	CASE("case",4),
	CHAR("char", 5),
	CONST("const", 6),
	CONTINUE("continue", 7),
	DEFAULT("default", 8),
	DO("do", 9),
	DOUBLE("double",10),
	ELSE("else",11),
	ENUM("enum",12),
	EXTERN("extern",13),
	FLOAT("float",14),
	FOR("for",15),
	GOTO("goto",16),
	IF("if",17),
	INT("int",18),
	LONG("long",19),
	REGISTER("register",20),
	RETURN("return",21),
	SHORT("short",22),
	SIGNED("signed",23),
	SIZEOF("sizeof",24),
	STATIC("static",25),
	STRUCT("struct",26),
	SWITCH("switch",27),
	TYPEDEF("typedef",28),
	UNION("union",29),
	UNSIGNED("unsigned",30),
	VOID("void",30),
	VOLATILE("volatile",30),
	WHILE("while",30),
	FALSE("false", 31),
	TRUE("true", 32);
	
	
	
	private String sigla;
	private int codigo;

	private PalavrasReservadas(String sigla, int codigo) {
		this.codigo = codigo;
		this.sigla = sigla;
	}

	public static PalavrasReservadas validar(String constEnum) {
		try {
			PalavrasReservadas ret = null;
			if (constEnum != null) {
				ret = PalavrasReservadas.valueOf(constEnum);
			}
			return ret;
		} catch (Exception e) {
			PalavrasReservadas ret = null;
			return ret;
		}
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
