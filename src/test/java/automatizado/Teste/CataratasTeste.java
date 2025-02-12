package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.Antigo.Cataratasbuilder;
import automatizado.Builder.Novo.CataratasbuilderNovo;
import automatizado.Page.EcommercePOAntigo;
import automatizado.Page.EcommercePONovo;

public class CataratasTeste extends BaseTeste {

    private static EcommercePOAntigo EcommercePOAntigo;
    private static final String URL_Ecommerce = "https://testeauto_integrada.testescard.limber.net.br/";
    private static EcommercePONovo EcommercePONovo;

    @Test
    public void TC001_Bilhete_Brasileiro_Mercosul() {
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
        Cataratasbuilder cataratas = new Cataratasbuilder(EcommercePOAntigo);

        cataratas
                .Ingresso(driver, 1 /* TIPO 1 = Brasileiro */);
    }

    @Test
    public void TC002_Bilhete_Estrangeiro() {
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
        Cataratasbuilder cataratas = new Cataratasbuilder(EcommercePOAntigo);

        cataratas
                .Ingresso(driver, 2 /* TIPO 2 = Estrangeiro */);
    }

    @Test
    public void TC003_Bilhete_Expêriencias() {
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
        Cataratasbuilder cataratas = new Cataratasbuilder(EcommercePOAntigo);

        cataratas
                .Ingresso(driver, 3 /* TIPO 3 = Expeiências */);
    }

    @Test
    public void TC004_Bilhete_Bike_poço_preto() {
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
        Cataratasbuilder cataratas = new Cataratasbuilder(EcommercePOAntigo);

        cataratas
                .Ingresso(driver, 4 /*
                                     * TIPO 4 = Bike poço preto
                                     */);
    }

    @Test
    public void TC005_Ingresso_2_dias() {
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
        Cataratasbuilder cataratas = new Cataratasbuilder(EcommercePOAntigo);

        cataratas
                .Ingresso(driver, 5 /* TIPO 5 = Ingresso 2 dias */);
    }

    @Test
    public void TC006_Ingresso_3_dias() {
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
        Cataratasbuilder cataratas = new Cataratasbuilder(EcommercePOAntigo);

        cataratas
                .Ingresso(driver, 6 /* TIPO 6 = Ingresso 3 dias */);
    }

    @Test
    public void TC007_Ingresso_guarda_volumes() {
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
        Cataratasbuilder cataratas = new Cataratasbuilder(EcommercePOAntigo);

        cataratas
                .Ingresso(driver, 7 /* TIPO 7 = Guarda-Volumes */);
    }

    @Test
    public void TC008_Ingresso_VIP() {
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
        Cataratasbuilder cataratas = new Cataratasbuilder(EcommercePOAntigo);

        cataratas
                .Ingresso(driver, 8 /*TIPO 8 = ingresso VIP*/);
    }
    
    @Test
    public void NE_TC001_Bilhete_Brasileiro_Mercosul() {
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
        CataratasbuilderNovo cataratas = new CataratasbuilderNovo(EcommercePONovo);

        cataratas
                .Ingresso(driver, 1);
    }

    @Test
    public void NE_TC002_Bilhete_Estrangeiro() {
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
        CataratasbuilderNovo cataratas = new CataratasbuilderNovo(EcommercePONovo);

        cataratas
                .Ingresso(driver, 2);
    }

    @Test
    public void NE_TC003_Bilhete_Expêriencias() {
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
        CataratasbuilderNovo cataratas = new CataratasbuilderNovo(EcommercePONovo);

        cataratas
                .Ingresso(driver, 3);
    }

    @Test
    public void NE_TC004_Bilhete_Bike_poço_preto() {
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
        CataratasbuilderNovo cataratas = new CataratasbuilderNovo(EcommercePONovo);

        cataratas
                .Ingresso(driver, 4);
    }
}
