package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.Antigo.AguasCorrentesBuilder;
import automatizado.Builder.Novo.AguasCorrentesBuilderNovo;
import automatizado.Page.EcommercePOAntigo;
import automatizado.Page.EcommercePONovo;

public class AguasCorrentesTestes extends BaseTeste{
    
    private static final String URL_Ecommerce = "https://zanottincalendario.testescard.limber.net.br/";
    /*Page Objects */
    private static EcommercePOAntigo EcommercePOAntigo;
    private static EcommercePONovo EcommercePONovo;

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

        EcommercePOAntigo = new EcommercePOAntigo(driver);
        AguasCorrentesBuilder aguas = new AguasCorrentesBuilder(EcommercePOAntigo);

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

        EcommercePOAntigo = new EcommercePOAntigo(driver);
        AguasCorrentesBuilder aguas = new AguasCorrentesBuilder(EcommercePOAntigo);

        aguas
                .avulsso(driver, 2 /* TIPO 2 = Bilhete 5 pessoas */);
    }

    // @Test
    public void Novo_Ecommerce() {
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

        EcommercePONovo = new EcommercePONovo(driver);
        AguasCorrentesBuilderNovo aguas = new AguasCorrentesBuilderNovo(EcommercePONovo);

        aguas
                .avulsso(driver, 2 /* TIPO 2 = Bilhete 5 pessoas */);
    }

}
