package automatizado.Teste;

import org.junit.Test;
import automatizado.Builder.AguasCorrentesBuilder;
import automatizado.Page.EcommercePO;

public class AquaRioTeste extends BaseTeste {

    private EcommercePO ecommercePO;
    private static final String URL_ECOMMERCE = "https://zanottincalendario.testescard.limber.net.br/";

    @Test
    public void TC002_Bilhete_Atrakto() {
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if (aberto == null) {
            iniciar(URL_ECOMMERCE);
        } else {
            RedirecionarPag(URL_ECOMMERCE); 
        }
        ecommercePO = new EcommercePO(driver);
        AguasCorrentesBuilder builder = new AguasCorrentesBuilder(ecommercePO);
        builder.venda_padrao(driver); 
    }
}
