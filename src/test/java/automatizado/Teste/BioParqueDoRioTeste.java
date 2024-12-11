package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.BioParqueDoRioBuilder;
import automatizado.Page.EcommercePO;

public class BioParqueDoRioTeste extends BaseTeste{
    
    private static final String URL_Ecommerce = "https://testeauto_integrada.testescard.limber.net.br/?divisao=0";
    private static EcommercePO EcommercePO;

     @Test
    public void TC001_Bilhete_BioParqueDoRio() {
        String aberto;
        try {
            aberto = driver
                    .manage()
                    .window()
                    .getSize()
                    .toString();
        } catch (Exception e) {
            aberto = null;
        }
        if (aberto == null) {
            iniciar(URL_Ecommerce);
        } else {
            RedirecionarPag(URL_Ecommerce);
        }

        EcommercePO = new EcommercePO(driver);
        BioParqueDoRioBuilder Bioparque = new BioParqueDoRioBuilder(EcommercePO);

        Bioparque
                .Ingresso(driver, 1 /* TIPO 1 = BioParqueDoRio */);
    }

}
