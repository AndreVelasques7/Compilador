public class Token {
	
	public static final int TK_IDENTIFIER  = 0;
	public static final int TK_NUMBER      = 1;
	public static final int TK_OPERATOR    = 2;
	public static final int TK_PONCTUATION = 3;
	public static final int TK_ASSIGN      = 4;
	public static final int TK_ENDL        = 5;
	public static final int TK_ASPAS       = 6;
	public static final int TK_AP          = 7;
	public static final int TK_FP          = 8;
	public static final int TK_VIR         = 9;
	public static final int TK_RESERVADA   = 10;
	
	public static final String TK_TEXT[] = {
			"IDENTIFIER", "NUMBER", "OPERATOR", "PONCTUACTION", "ASSIGNMENT", "ENDLINE", "ASPAS", "AP", "FP", "VIR", "RESERVADA"
	};
	
	private int    type;
	private String text;
	private int    line;
	private int    column;
	
	public Token(int type, String text) {
		super();
		this.type = type;
		this.text = text;
	}

	public Token() {
		super();
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Token [type-> " + type + ", valor -> " + text + "]";
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}
