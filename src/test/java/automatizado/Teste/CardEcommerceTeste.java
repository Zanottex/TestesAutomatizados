package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.CardEcommerceBuilder;
import automatizado.Page.CardEcommercePO;


public class CardEcommerceTeste extends BaseTeste{

    /*Page Objects */
    private static final String URL_CardEcommerce = "https://testescard.limbersoftware.com.br/#/pages/ecommerce/ec-configs";
    private static CardEcommercePO CardPo;

    /*@Test para o sistema compreender como um teste*/
    @Test
    public void TC001_Colocar_Bilhete_Ecommerce(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        AbrirCard();
        }
        else{
            driver.get(URL_HOMOLOG);
        }
        driver.get(URL_HOMOLOG);
        RedirecionarPag(URL_CardEcommerce);
        CardPo = new CardEcommercePO(driver);

        CardEcommerceBuilder card = new CardEcommerceBuilder(CardPo);

        card.builder_ColocarBilheteEcommerce(driver);
        
    }
}