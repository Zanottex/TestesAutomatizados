package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.Cataratasbuilder;
import automatizado.Page.EcommercePO;

public class CataratasTeste extends BaseTeste{
    
    private static EcommercePO EcommercePO;
    private static final String URL_Ecommerce = "https://testeauto_integrada.testescard.limber.net.br/";

    @Test
    public void TC001_Bilhete_Brasileiro_Mercosul(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        iniciar(URL_Ecommerce);
        }
        else{
        RedirecionarPag(URL_Ecommerce);
        }

        EcommercePO = new EcommercePO(driver);
        Cataratasbuilder cataratas = new Cataratasbuilder(EcommercePO);

        cataratas.Ingresso(driver, 1 /*TIPO 1 = Brasileiro */);
    }

    @Test
    public void TC002_Bilhete_Estrangeiro(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        iniciar(URL_Ecommerce);
        }
        else{
        RedirecionarPag(URL_Ecommerce);
        }

        EcommercePO = new EcommercePO(driver);
        Cataratasbuilder cataratas = new Cataratasbuilder(EcommercePO);

        cataratas.Ingresso(driver, 2 /*TIPO 2 = Estrangeiro*/);
    }

    @Test
    public void TC003_Bilhete_Expêriencias(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        iniciar(URL_Ecommerce);
        }
        else{
        RedirecionarPag(URL_Ecommerce);
        }

        EcommercePO = new EcommercePO(driver);
        Cataratasbuilder cataratas = new Cataratasbuilder(EcommercePO);

        cataratas.Ingresso(driver, 3 /*TIPO 3 = Expeiências*/);
    }
}
