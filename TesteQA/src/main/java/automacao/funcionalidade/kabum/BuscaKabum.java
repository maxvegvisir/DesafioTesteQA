package automacao.funcionalidade.kabum;

import java.util.ArrayList;

import automacao.dto.kabum.Item;
import automacao.tela.kabum.TelaKabum;

public class BuscaKabum extends TelaKabum {

	private Integer qntItemPagina;
	private String inicioDescricaoItem = "Placa de Vídeo ";
	private Item item;
	private ArrayList<Item> itens;

	public BuscaKabum() {
		item = new Item();
		itens = new ArrayList<>();
	}

	public void preencherBusca(String nomeBusca) {
		barraPesquisa().sendKeys(nomeBusca);
	}

	public void clicarPesquisar() {
		botaoPesquisar().click();
	}

	public ArrayList<Item> recuperarListaPrecoPagina() {
		qntItemPagina = recuperaQntItensPagina();

		for (int i = 1; i <= qntItemPagina; i++) {
			if (validarItemDisponivel(i)) {
				item.setDescricao(recuperarTextoLinkItem(i));
				item.setMarca(recuperarMarcaItem(recuperarTextoLinkItem(i)));
				item.setValorCheio(recuperarPrecoCheio(i));
				item.setValorDesconto(recuperarPrecoDesconto(i));
				itens.add(item);
				System.out.println(item.toString());
				item = new Item();
			}
		}

		if (verificaPaginacaoProximo()) {
			botaoPaginacaoProximo().click();
			recuperarListaPrecoPagina();
		}

		return itens;

	}

	private String recuperarMarcaItem(String descricaoItem) {
		String aux = descricaoItem.replace(inicioDescricaoItem, "");
		return aux.substring(0, aux.indexOf(" "));
	}

	private boolean validarItemDisponivel(int i) {
		if (recuperarItemEstaDisponivel(i).toLowerCase().contains("icone_disponivel")) {
			return true;
		}
		return false;
	}

	public Item verificarMelhorPrecoAvista(ArrayList<Item> itens) {

		double menorValor = 0;
		double valorFormatado = 0;
		Item menorItem = new Item();

		for (Item item : itens) {

			valorFormatado = Double.parseDouble(item.getValorDesconto().substring(3).replace(".", "").replace(",", "."));

			if (menorValor == 0) {
				menorValor = valorFormatado;
				menorItem = item;
			}

			if (valorFormatado < menorValor) {
				menorValor = valorFormatado;
				menorItem = item;
			}

		}

		return menorItem;
	}

	public Item verificarMelhorPrecoAprazo(ArrayList<Item> itens) {
		
		double maiorValor = 0;
		double valorFormatado = 0;
		Item maiorItem = new Item();

		for (Item item : itens) {

			valorFormatado = Double.parseDouble(item.getValorCheio().substring(3).replace(".", "").replace(",", "."));

			if (maiorValor == 0) {
				maiorValor = valorFormatado;
				maiorItem = item;
			}

			if (valorFormatado > maiorValor) {
				maiorValor = valorFormatado;
				maiorItem = item;
			}

		}

		return maiorItem;
	}

}
