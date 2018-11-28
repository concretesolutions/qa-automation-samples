package br.com.appium.teste.screens.login;

import br.com.appium.teste.screens.base.BaseScreen;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.concurrent.TimeUnit;

public class InitialScreen extends BaseScreen {

    @WithTimeout(time = 5000, unit = TimeUnit.SECONDS)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Formulário']")
    private MobileElement clickFormulario;

    @AndroidFindBy(accessibility = "nome")
    private MobileElement inputNome;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='save']/android.widget.TextView")
    private MobileElement save;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Nome')]")
    private MobileElement assertName;

    public void clickFormulario() {
        this.clickFormulario.click();
    }

    public void inputNome(String nome) {

        this.inputNome.sendKeys(nome);
    }

    public void saveClick() {

        this.save.click();
    }

    public boolean assertNome(String nome) {
        return this.assertName.getText().contains(nome);

    }


}
