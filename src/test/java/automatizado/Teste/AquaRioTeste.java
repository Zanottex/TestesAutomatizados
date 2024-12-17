package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.AquaRioBuilder;
import automatizado.Page.EcommercePO;

public class AquaRioTeste extends BaseTeste{
    
    private static final String URL_Ecommerce = "https://testeauto_integrada.testescard.limber.net.br/";
    /*Page Objects */
    private static EcommercePO ECommercePO;

    @Test
    public void TC001_Bilhete_Aquario() {
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

        ECommercePO = new EcommercePO(driver);
        AquaRioBuilder Aquario = new AquaRioBuilder(ECommercePO);

        Aquario
                .Ingresso(driver, 1 /* TIPO 1 = BioParqueDoRio */);
    }
}
