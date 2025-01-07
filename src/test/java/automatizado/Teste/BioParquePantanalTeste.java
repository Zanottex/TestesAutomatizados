package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.BioParquePantanal;
import automatizado.Page.EcommercePO;

public class BioParquePantanalTeste extends BaseTeste{
    
    private static final String URL_Ecommerce = "https://zanottin2.testescard.limber.net.br/";
    private static EcommercePO EcommercePO;

     @Test
    public void TC001_Colocar_Bilhete_Acesso(){
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
            driver.get(URL_Ecommerce);
        }
        EcommercePO = new EcommercePO(driver);

        BioParquePantanal pantanal = new BioParquePantanal(EcommercePO);

        pantanal.Ingresso(driver, 1 /*tipo 1 Bilhete acesso */);
        
    }

    @Test
    public void TC002_Colocar_Bilhete_Acesso_Pessoa_com_deficiência(){
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
            driver.get(URL_Ecommerce);
        }
        EcommercePO = new EcommercePO(driver);

        BioParquePantanal pantanal = new BioParquePantanal(EcommercePO);

        pantanal.Ingresso(driver, 2 /*tipo 2 Bilhete acesso pessoas com deficiência */);
        
    }

    @Test
    public void TC003_Colocar_Bilhete_Acesso_grupos(){
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
            driver.get(URL_Ecommerce);
        }
        EcommercePO = new EcommercePO(driver);

        BioParquePantanal pantanal = new BioParquePantanal(EcommercePO);

        pantanal.Ingresso(driver, 3 /*tipo 3 Bilhete acesso de grupos */);
        
    }
}
