package automacao.dto.kabum;

public class Item {

	private String descricao;

	private String marca;

	private String valorCheio;

	private String valorDesconto;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getValorCheio() {
		return valorCheio;
	}

	public void setValorCheio(String valorCheio) {
		this.valorCheio = valorCheio;
	}

	public String getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(String valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	@Override
	public String toString() {
		return "Item [descricao=" + descricao + ", marca=" + marca + ", valorCheio=" + valorCheio + ", valorDesconto="
				+ valorDesconto + "]";
	}

	
}
