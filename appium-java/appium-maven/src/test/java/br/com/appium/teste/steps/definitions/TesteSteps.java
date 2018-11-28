package br.com.appium.teste.steps.definitions;

import br.com.appium.teste.screens.login.InitialScreen;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class TesteSteps {

    InitialScreen initialScreen;

    public TesteSteps() {

        initialScreen = new InitialScreen();
    }


    @Dado("^que tenha  aberto o app$")
    public void que_tenha_aberto_o_app() {
    }

    @Quando("^clicar no formulário$")
    public void clicar_no_formulário() {
        this.initialScreen.clickFormulario();
    }

    @Quando("^e colocar o meu nome \"([^\"]*)\"$")
    public void e_colocar_o_meu_nome(String nome) {
        this.initialScreen.inputNome(nome);

    }

    @Quando("^salvar a alteração$")
    public void salvar_a_alteração() {
        this.initialScreen.saveClick();

    }

    @Entao("^irei visualizar o meu nome na tela$")
    public void irei_visualizar_o_meu_nome_na_tela() {
        this.initialScreen.assertNome("Fulano");
    }

}
