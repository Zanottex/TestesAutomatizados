package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.MarcoDasTresFronteirasBuilder;
import automatizado.Page.EcommercePO;

public class MarcoDasTresFronteirasTeste extends BaseTeste{
    
    private static EcommercePO EcommercePO;
    private static final String ULR_Ecommerce = "https://zanottincalendario.testescard.limber.net.br/";

    @Test
    public void TC001_Bilhete_padrão(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        iniciar(ULR_Ecommerce);
        }
        else{
        RedirecionarPag(ULR_Ecommerce);
        }
        
        EcommercePO = new EcommercePO(driver);
        MarcoDasTresFronteirasBuilder ecommerce = new MarcoDasTresFronteirasBuilder(EcommercePO);

        ecommerce.venda_padrao(driver);
    }
}
