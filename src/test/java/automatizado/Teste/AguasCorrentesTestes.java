package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.AguasCorrentesBuilder;
import automatizado.Page.EcommercePO;

public class AguasCorrentesTestes extends BaseTeste{
    
    private static final String URL_Ecommerce = "https://zanottincalendario.testescard.limber.net.br/";
    /*Page Objects */
    private static EcommercePO ECommercePO;

    @Test
    public void TC001_Bilhete_AguasCorrentes() {
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
        AguasCorrentesBuilder aguas = new AguasCorrentesBuilder(ECommercePO);

        aguas
                .avulsso(driver, 1 /* TIPO 1 = Bilhete avulsso acesso Aquas */);
    }

    @Test
    public void TC002_Bilhete_AguasCorrentes_5dias() {
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
        AguasCorrentesBuilder aguas = new AguasCorrentesBuilder(ECommercePO);

        aguas
                .avulsso(driver, 2 /* TIPO 2 = Bilhete 5 pessoas */);
    }

}
