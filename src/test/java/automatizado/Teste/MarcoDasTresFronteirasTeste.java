package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.Antigo.MarcoDasTresFronteirasBuilder;
import automatizado.Page.EcommercePOAntigo;

public class MarcoDasTresFronteirasTeste extends BaseTeste {

    private static EcommercePOAntigo EcommercePOAntigo;
    private static final String ULR_Ecommerce = "";

    @Test
    public void TC001_Bilhete_padrão() {
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if (aberto == null) {
            iniciar(ULR_Ecommerce);
        } else {
            RedirecionarPag(ULR_Ecommerce);
        }

        EcommercePOAntigo = new EcommercePOAntigo(driver);
        MarcoDasTresFronteirasBuilder ecommerce = new MarcoDasTresFronteirasBuilder(EcommercePOAntigo);

        ecommerce.venda_padrao(driver);
    }
}
