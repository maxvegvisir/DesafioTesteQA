package automacao.enuns;

public enum EnumMetodos {
	
	GET("GET"),
	POST("POST"),
	DELETE("DELETE"),
	PATCH("PATCH"),
	PUT("PUT");
	
	private String opcao;
	
	private EnumMetodos(String opcao){
		this.opcao = opcao;
	}
	
	public String getOpcao(){
		return opcao;
	}
	
	public void setOpcao(String opcao){
		this.opcao = opcao;
	}

}
