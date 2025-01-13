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

    @Test
    public void TC002_Bilhete_BioParqueDoRio_Passaporte_Anual() {
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
                .Ingresso(driver, 2 /* TIPO 2 = Passaporte Anual */);
    }

    @Test
    public void TC003_Bilhete_BioParqueDoRio_AquaRio() {
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
                .Ingresso(driver, 3 /* TIPO 3 = Aquario + Bioparque do Rio */);
    }

    @Test
    public void TC004_Bilhete_BioParqueDoRio_Corcovado() {
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
                .Ingresso(driver, 4 /* TIPO 4 = Cristo + Bioparque do Rio */);
    }

}
