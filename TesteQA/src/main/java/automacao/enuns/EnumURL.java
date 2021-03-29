package automacao.enuns;

public enum EnumURL {

	URLBASE("https://api-de-tarefas.herokuapp.com"),
	URLCADASTROCONTATOS("/contacts"),
	URLCADASTROUSUARIOS("/users");
	
	
	private String opcao;
	
	private EnumURL(String opcao){
		this.opcao = opcao;
	}
	
	public String getOpcao(){
		return opcao;
	}
	
	public void setOpcao(String opcao){
		this.opcao = opcao;
	}

}
