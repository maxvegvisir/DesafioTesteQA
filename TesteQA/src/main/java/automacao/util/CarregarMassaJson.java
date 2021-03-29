package automacao.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class CarregarMassaJson {

	private static String caminhoMassa = "\\src\\main\\java\\automacao\\massa\\";

	public JSONObject recuperarMassaJson(String nomeMassa) throws IOException {
		String caminhoProjeto = System.getProperty("user.dir");

		String text = new String(Files.readAllBytes(Paths.get(caminhoProjeto + caminhoMassa + nomeMassa)),
				StandardCharsets.UTF_8);

		JSONObject json = new JSONObject(text);

		return json;
	}

}
