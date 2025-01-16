package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.Antigo.AquaRioBuilder;
import automatizado.Page.EcommercePOAntigo;

public class AquaRioTeste extends BaseTeste{
    
    private static final String URL_Ecommerce = "https://testeauto_integrada.testescard.limber.net.br/";
    /*Page Objects */
    private static EcommercePOAntigo EcommercePOAntigo;

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

        EcommercePOAntigo = new EcommercePOAntigo(driver);
        AquaRioBuilder Aquario = new AquaRioBuilder(EcommercePOAntigo);

        Aquario
                .Ingresso(driver, 1 /* TIPO 1 = Bilhete avulsso acesso Aquario */);
    }

    @Test
    public void TC002_Bilhete_Aquario_Museu_Mar() {
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
        AquaRioBuilder Aquario = new AquaRioBuilder(EcommercePOAntigo);

        Aquario
                .Ingresso(driver, 2 /* TIPO 2 = bilhete COMBO: aquario + museu de cera + mar de espelhos */);
    }

    @Test
    public void TC003_Bilhete_Aquario_Bioparque() {
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
        AquaRioBuilder Aquario = new AquaRioBuilder(EcommercePOAntigo);

        Aquario
                .Ingresso(driver, 3 /* TIPO 3 = bilhete COMBO: aquario + bioparque */);
    }

    @Test
    public void TC004_Bilhete_Aquario_Corcovado() {
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
        AquaRioBuilder Aquario = new AquaRioBuilder(EcommercePOAntigo);

        Aquario
                .Ingresso(driver, 4/* TIPO 4 = bilhete COMBO: aquario + corcovado */);
    }

    @Test
    public void TC005_Bilhete_Aquario_passaporte_anual() {
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
        AquaRioBuilder Aquario = new AquaRioBuilder(EcommercePOAntigo);

        Aquario
                .Ingresso(driver, 5/* TIPO 5 = bilhete passaporte anual */);
    }

    @Test
    public void TC006_Bilhete_Aquario_mar_de_espelhos() {
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
        AquaRioBuilder Aquario = new AquaRioBuilder(EcommercePOAntigo);

        Aquario
                .Ingresso(driver, 6/* TIPO 6 = bilhete mar de espelhos */);
    }



    @Test
    public void TC007_Bilhete_Aquario_museu_de_cera() {
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
        AquaRioBuilder Aquario = new AquaRioBuilder(EcommercePOAntigo);

        Aquario
                .Ingresso(driver, 7/* TIPO 7 = bilhete museu de cera */);
    }

}
