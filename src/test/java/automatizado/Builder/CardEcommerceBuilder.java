package automatizado.Builder;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.CardEcommercePO;

public class CardEcommerceBuilder {
    
    private CardEcommercePO CardECommercePO;
    private String E_Commerce_CARD = "171";
    private String Nome_bilhete = "5150";

    public CardEcommerceBuilder(CardEcommercePO card){
        this.CardECommercePO = card;
    }

    public void builder_ColocarBilheteEcommerce(WebDriver driver){

        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait.until(d -> CardECommercePO.Filtro.isDisplayed());
        CardECommercePO.Filtro.sendKeys(E_Commerce_CARD);

        wait.until(d -> CardECommercePO.SelecionarEcommerce.isDisplayed());
        CardECommercePO.SelecionarEcommerce.click();

        wait.until(d -> CardECommercePO.Grupos.isDisplayed());
        CardECommercePO.Grupos.click();

        wait.until(d -> CardECommercePO.Grupo_TesteAutomatizado.isDisplayed());
        CardECommercePO.Grupo_TesteAutomatizado.click();

        wait.until(d -> CardECommercePO.Grupo_TesteAutomatizado.isEnabled());
        CardECommercePO.Adicionar_Bilhete_grupo.click();

        wait.until(d -> CardECommercePO.Bilhete.isDisplayed());
        CardECommercePO.Bilhete.sendKeys(Nome_bilhete);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(d -> CardECommercePO.seleciona_Bilhete.isDisplayed());
        CardECommercePO.seleciona_Bilhete.click();
        wait.until(d -> CardECommercePO.salva_Bilhete.isDisplayed());
        CardECommercePO.salva_Bilhete.click();
        CardECommercePO.salva_Ecommerce.click();

        wait.until(d -> CardECommercePO.spanMensagem.isDisplayed());
        String mensagem = CardECommercePO.spanMensagem.getText();
        assertEquals("E-commerce salvo com sucesso!", mensagem);
    

    }

}