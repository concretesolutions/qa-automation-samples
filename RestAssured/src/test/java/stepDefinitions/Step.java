package stepDefinitions;

import massa.Massa;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

public class Step {


	private static final String BASE_URL =  "https://reqres.in";
	private static Response response;
	private ValidatableResponse json;

	Map<String, Object> jsonBodyUsingMap = new HashMap<String,Object>();



	@Quando("fazer uma solicitacao")
	public void fazerUmaRequisicao() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request =  (RequestSpecification) RestAssured.when();
		response = request.get("/api/users/"+2);
	}

	@Entao("devo visualizar os dados do usuario")
	public void devoVisualizarOsDados() {
		json = response.then().statusCode(200)
				.body("data.id", Matchers.is(2))
				.body("data.email", Matchers.is("janet.weaver@reqres.in"))
				.body("data.first_name", Matchers.is("Janet"))
				.body("data.last_name", Matchers.is("Weaver"));
	}





	@Dado("que quero adicionar um novo usuario")
	public void ajdQueroAdicionarUmNovoUsuario() {
		jsonBodyUsingMap.put("name","Ériton");
		jsonBodyUsingMap.put("job","QA");

	}

	@Quando("fazer um post")
	public void fazerUmPost() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = (RequestSpecification) RestAssured.when();
		request.header("Content-Type","application/json") ;   
		response = request.body(jsonBodyUsingMap)
				.post("/api/users");

	}

	@Entao("devo realizar cadastro com sucesso")
	public void devoReceberCadastroComSucesso() {

		json = response.then().statusCode(201)
				.body("name", Matchers.is("Ériton"))
				.body("job", Matchers.is("QA"))
				.body("id", Matchers.notNullValue())
				.body("createdAt", Matchers.notNullValue());

	}


}
