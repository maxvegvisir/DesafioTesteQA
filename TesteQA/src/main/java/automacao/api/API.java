package automacao.api;

import java.io.File;

import org.json.JSONObject;

import automacao.enuns.EnumMetodos;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class API {

	private Response response;
	private RequestSpecification request;
	private String BASE_URL_LOCAL;
	private String BASE_URI;
	private String BASE_ROUTE = "";
	private JSONObject jsonPlayLoad;
	
	public void init(){
		
	}
	
	public void setDirectUri(String route, String uri){
		this.setRoutePath(route);
		this.BASE_URL_LOCAL = uri;
		RestAssured.baseURI = this.BASE_URL_LOCAL + this.BASE_URI;
	}
	
	public void setBaseUri(String uri){
		this.BASE_URI = uri;
	}
	
	public void setRoutePath(String route){
		this.BASE_ROUTE = route;
	}
	
	public void setRoute(String route){
		RestAssured.baseURI = route;
		request = RestAssured.given();
	}
	
	public void setRouteProxy(String route){
		
		/*System.setProperty("http.proxyHost", "");
		System.setProperty("http.proxyPort", "");
		System.setProperty("https.proxyHost", "");
		System.setProperty("https.proxyPort", "");*/
		
		RestAssured.baseURI = route;
		request = RestAssured.given();
	}
	
	public void setRouteNoProxy(String route){
		
		System.setProperty("http.proxyHost", "");
		System.setProperty("http.proxyPort", "");
		System.setProperty("https.proxyHost", "");
		System.setProperty("https.proxyPort", "");
		
		RestAssured.baseURI = route;
		request = RestAssured.given().relaxedHTTPSValidation();
	}
	
	public void setHeader(String key, String value){
		request.header(key, value);
	}
	
	public void setRequestBody(JSONObject json){
		request.body(json.toString());
	}
	
	public void setFile(String file){
		request.multiPart("file", new File(file));
	}
	
	public void setMetodo(String metodo){
		switch (EnumMetodos.valueOf(metodo.toUpperCase())) {
		case POST:
			response = request.when().post(this.BASE_ROUTE);
			break;
		case GET:
			response = request.when().get(this.BASE_ROUTE);
			break;
		case DELETE:
			response = request.when().delete(this.BASE_ROUTE);
			break;
		case PATCH:
			response = request.when().patch(this.BASE_ROUTE);
			break;
		case PUT:
			response = request.when().put(this.BASE_ROUTE);
			break;
		default:
			System.out.println("Metodo selecionado nÃ£o existe");
			break;
		}
	}
	
	public void iniJson(){
		this.jsonPlayLoad = new JSONObject();
	}
	
	public void setAtributoJson(String key, String value){
		jsonPlayLoad.put(key, value);
	}
	
	public void submitRequestBody(){
		request.body(this.jsonPlayLoad.toString());
	}
	
	public void setBodyForm(String key, String value){
		request.formParam(key, value);
	}
	
	public void setPathParam(String key, String value){
		request.pathParam(key, value);
		String stringKey = "{"+key+"}";
		this.BASE_ROUTE = BASE_ROUTE.replace(key, stringKey);
	}
	
	public void setQueryParam(String key, String value){
		if(value.equalsIgnoreCase("VAZIO")){
			value = "";
		}
		request.queryParam(key, value);
	}
	
	public String getResponseUri(){
		return "URI: " + RestAssured.baseURI;
	}
	
	public String getResponseHeader(){
		return "HEADER: \n" + response.headers().toString();
	}
	
	public String getResponse(){
		return response.prettyPrint().toString();
	}
	
	public String getResponseString(){
		return response.asString();
	}
	
	public int getStatusCode(){
		return response.getStatusCode();
	}
	
	
	public void validoCampoValorResposta(String campo, String valor){
		if(valor.equals("")){
			Assert.assertEquals("A informação do campo "+ campo+ " não é igual a " + valor,
					response.jsonPath().getString(campo), null);
		}else{
			Assert.assertEquals("A informação do campo "+ campo+ " não é igual a " + valor,
					response.jsonPath().getString(campo), valor);
		}
	}

	public void realizarReplaceUrl(String stringReplace, String ddd) {
		String route = RestAssured.baseURI;
		
		route = route.replace(stringReplace, ddd);
		this.BASE_ROUTE = BASE_ROUTE.replace(stringReplace, ddd);
		RestAssured.baseURI = route;
		request = RestAssured.given().relaxedHTTPSValidation();
	}
}
