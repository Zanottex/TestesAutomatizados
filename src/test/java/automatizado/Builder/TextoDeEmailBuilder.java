package automatizado.Builder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.TextoDeEmailPO;

public class TextoDeEmailBuilder {
    
    private TextoDeEmailPO EmailPO;
    private String nomeEmail = "Email bagua";
    private String CorpoEmail = "Email de verificação";
    private String NomeEstab = "Bilheteria Zanotto";

    public TextoDeEmailBuilder(TextoDeEmailPO emailPO){
        this.EmailPO = emailPO;
    }

    public TextoDeEmailBuilder mudarNome(String nome){
        this.nomeEmail = nome;
        return this;
    }

    public TextoDeEmailBuilder mudarCorpo(String corpo){
        this.CorpoEmail = corpo;
        return this;
    }

    public TextoDeEmailBuilder mudarEstab(String estab){
        this.NomeEstab = estab;
        return this;
    }


    public void builder(WebDriver driver){

        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);
        wait.until(d -> EmailPO.nomeEmail.isDisplayed());

        EmailPO.nomeEmail.sendKeys(nomeEmail);
        EmailPO.CorpoEmail.sendKeys(CorpoEmail);
        EmailPO.Permissao.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(d -> EmailPO.AdicionarestabAcesso.isDisplayed());
        EmailPO.AdicionarestabAcesso.click();
        
        wait.until(d -> EmailPO.estabAcesso.isDisplayed());
        EmailPO.estabAcesso.sendKeys(NomeEstab);
        EmailPO.ConfirmaEstab.click();
        EmailPO.salvarEstab.click();
        EmailPO.salvarEmail.click();
    }
}
