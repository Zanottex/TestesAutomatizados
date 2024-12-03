package automatizado.Builder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.TermoDeAceitePO;

public class TermoDeAceiteBuilder {

    private TermoDeAceitePO termoPO;

    private String nomeTermo = "Termo";
    private String TextoTermo = "Termo de uso de voz e imagem";
    private String NomeEstab = "Bilheteria Zanotto";
    
    public TermoDeAceiteBuilder(TermoDeAceitePO termo){
        this.termoPO = termo;
    }

    public TermoDeAceiteBuilder mudarNome(String nome){
        this.nomeTermo = nome;
        return this;
    }

    public TermoDeAceiteBuilder mudarTextoTermo(String Texto){
        this.TextoTermo = Texto;
        return this;
    }

    public TermoDeAceiteBuilder mudarNomeEstab(String nomeEstab){
        this.NomeEstab = nomeEstab;
        return this;
    }

    public void builder(WebDriver driver){

        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);
        wait.until(d -> termoPO.nomeTermo.isDisplayed());
        termoPO.nomeTermo.sendKeys(nomeTermo);
        termoPO.TextoTermo.sendKeys(TextoTermo);
        termoPO.Permissao.click();

        wait.until(d -> termoPO.AdicionarestabAcesso.isDisplayed());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        termoPO.AdicionarestabAcesso.click();
        
        wait.until(d -> termoPO.estabAcesso.isDisplayed());
        termoPO.estabAcesso.sendKeys(NomeEstab);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        termoPO.ConfirmaEstab.click();
        termoPO.salvarEstab.click();
        termoPO.salvarTermo.click();

    }
}
