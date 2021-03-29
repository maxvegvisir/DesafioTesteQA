package automacao.steps.kabum;

import java.util.ArrayList;

import automacao.dto.kabum.Item;
import automacao.funcionalidade.kabum.BuscaKabum;
import automacao.util.ChromeContext;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;

public class BuscaKabumStep extends ChromeContext {

	private BuscaKabum buscaKabum;
	private ArrayList<Item> itens;
	private Item item;

	public BuscaKabumStep() {
		buscaKabum = new BuscaKabum();
		itens = new ArrayList<>();
		item = new Item();
	}

	@Dado("^que tenho uma rota valida para o site da \"([^\"]*)\"$")
	public void que_tenho_uma_rota_valida_para_o_site_da(String site) throws Throwable {
		startWebDriver();

		switch (site.toUpperCase()) {

		case "KABUM":
			inputURL("https://www.kabum.com.br/");
			break;

		default:
			break;
		}

	}

	@Dado("^realizo a busca da placa de video \"([^\"]*)\"$")
	public void realizo_a_busca_da_placa_de_video(String nomeBusca) throws Throwable {
		buscaKabum.preencherBusca(nomeBusca);
		buscaKabum.clicarPesquisar();
	}

	@Quando("^armazeno os dados$")
	public void armazeno_os_dados() throws Throwable {
		itens = buscaKabum.recuperarListaPrecoPagina();
	}
	
	@Quando("^vejo o melhor preço a vista$")
	public void vejo_o_melhor_preço_a_vista() throws Throwable {
		item = buscaKabum.verificarMelhorPrecoAvista(itens);
		System.out.println("Menor preço a vista: " + item.getValorDesconto() + ", da Marca: " + item.getMarca() + " " + item.getDescricao());
	}
	
	@Quando("^vejo o melhor preço a prazo$")
	public void vejo_o_melhor_preço_a_prazo() throws Throwable {
		item = buscaKabum.verificarMelhorPrecoAprazo(itens);
		System.out.println("Maior preço a prazo: " + item.getValorDesconto() + ", da Marca: " + item.getMarca() + " " + item.getDescricao());
	}

	@Quando("^finalizo a busca$")
	public void finalizo_a_busca() throws Throwable {
		stopWebDriver();
	}

}
