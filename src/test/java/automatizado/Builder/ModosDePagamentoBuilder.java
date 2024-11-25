package automatizado.Builder;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.ModosDePagamentoPO;

public class ModosDePagamentoBuilder {


    private ModosDePagamentoPO modoPO;
    private String descrição = "Modo 1";
    private String nomeEstab = "Bilheteria Zanotto";
    private String ID = "12345";
    private String Autorização = "54321";
    private String EstabAcesso = "Bilheteria Zanotto";

    public ModosDePagamentoBuilder(ModosDePagamentoPO modoPO){
        this.modoPO = modoPO;
    }

    public ModosDePagamentoBuilder mudarDescrição(String descri){
        this.descrição = descri;
        return this;
    }

    public ModosDePagamentoBuilder nomeEsabelecimento(String nome){
        this.nomeEstab = nome;
        return this;
    }

    public ModosDePagamentoBuilder mudaID(String ID){
        this.ID = ID;
        return this;
    }

    public ModosDePagamentoBuilder mudarAutorização(String Autorização){
        this.Autorização = Autorização;
        return this;
    }

    public void builder(WebDriver driver){

        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(d -> modoPO.descrição.isDisplayed());

        modoPO.descrição.sendKeys(descrição);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        modoPO.estab.click();
        
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        modoPO.nomeEstab.sendKeys(nomeEstab + Keys.ARROW_DOWN + Keys.ARROW_UP + Keys.ENTER);
        modoPO.Cartão.click();

        wait.until(d -> modoPO.adquirente.isDisplayed());

        modoPO.adquirente.click();

        wait.until(d -> modoPO.GetNet.isDisplayed());

        modoPO.GetNet.click();
        modoPO.ambiente.click();

        wait.until(d -> modoPO.homologação.isDisplayed());

        modoPO.homologação.click();
        modoPO.editarID.click();
        modoPO.ID.sendKeys(ID);
        modoPO.editarautorização.click();
        modoPO.autorização.sendKeys(Autorização);
        modoPO.Permissoes.click();
        
        wait.until(d -> modoPO.AdicionarestabAcesso.isDisplayed());
        modoPO.AdicionarestabAcesso.click();
        
        wait.until(d -> modoPO.estabAcesso.isDisplayed());
        modoPO.estabAcesso.sendKeys(EstabAcesso);
        
        modoPO.ConfirmaEstab.click();
        modoPO.salvarEstab.click();
        modoPO.salvarModo.click();
        
        wait.until(d -> modoPO.spanMensagem.isDisplayed());
        String mensagem = modoPO.acharMensagem();
        assertEquals(mensagem,"Modo de pagamento cadastrado com sucesso");
    }
}
