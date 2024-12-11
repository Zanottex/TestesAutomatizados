package automatizado.Builder.CARD;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.ReceitaPO;

public class ReceitaBuilder {
    
    private ReceitaPO receitasPO;

    private String nomeReceita = "Receita Zanotto";
    private String NomeEstab = "Bilheteria Zanotto";
    
    public ReceitaBuilder(ReceitaPO receitaPO){
        this.receitasPO = receitaPO;
    } 

    public ReceitaBuilder nomeReceita(String nome){
        this.nomeReceita = nome;
        return this;
    } 

    public ReceitaBuilder nomeEstab(String estab){
        this.NomeEstab = estab;
        return this;
    } 

    public void builder(WebDriver driver){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait.until(d -> receitasPO.nomeReceita.isDisplayed());
        receitasPO.nomeReceita.click();
        receitasPO.nomeReceita.sendKeys(nomeReceita);
        receitasPO.estabReceita.click();

        wait.until(d -> receitasPO.nomeEstab.isDisplayed());
        receitasPO.nomeEstab.sendKeys(NomeEstab + Keys.ARROW_DOWN + Keys.ARROW_UP + Keys.ENTER  );
        //receitasPO.confirmaEstab.click();
        receitasPO.tipoIngresso.click();
        wait.until(d -> receitasPO.SelecionatipoIngresso.isDisplayed());
        receitasPO.SelecionatipoIngresso.click();
        
        wait.until(d -> receitasPO.salvarReceita.isDisplayed());
        receitasPO.salvarReceita.click();

        wait.until(d -> receitasPO.spanMensagem.isDisplayed());
        String mensagem = receitasPO.spanMensagem.getText();
        assertEquals("Receita cadastrada com sucesso", mensagem);
    }
}
