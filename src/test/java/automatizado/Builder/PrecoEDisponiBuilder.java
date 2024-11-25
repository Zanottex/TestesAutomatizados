package automatizado.Builder;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.PrecoEDisponiPO;

public class PrecoEDisponiBuilder {

    private PrecoEDisponiPO precoPO;

    private String nomeBilhete = "5000";
    private String nomeTabelaPreco = "teste";
    //private String valor = "1200";
    

    public PrecoEDisponiBuilder nomeBilhete(String nome){
    this.nomeBilhete = nome;
        return this;
    }

    public PrecoEDisponiBuilder nomeTabelaPreco(String nome){
        this.nomeTabelaPreco = nome;
            return this;
    }

    //public PrecoEDisponiBuilder mudarValor(String valor){
    //    this.valor = valor;
    //        return this;
    //}

    public PrecoEDisponiBuilder(PrecoEDisponiPO perfil){
        this.precoPO = perfil;
    }

    public void builder(WebDriver driver){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait.until(d -> precoPO.abrirPesquisaBilhete.isDisplayed());
        precoPO.abrirPesquisaBilhete.click();
        wait.until(d -> precoPO.nomeBilhete.isDisplayed());
        precoPO.nomeBilhete.sendKeys(nomeBilhete);
        precoPO.selecionaBilhete.click();

        wait.until(d -> precoPO.NovaTabelaPreco.isDisplayed());
        precoPO.NovaTabelaPreco.click();
        
        precoPO.NomeTabelaPreco.sendKeys(nomeTabelaPreco + Keys.TAB + Keys.ENTER + Keys.ARROW_UP);
        precoPO.cor.sendKeys("#545454");
        
        //precoPO.autoPreencher.click();
        //precoPO.preço.sendKeys(valor);
        //precoPO.salvarlinha.click();
        

    }
}
