package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.Antigo.BioParquePantanal;
import automatizado.Page.EcommercePOAntigo;

public class BioParquePantanalTeste extends BaseTeste{
    
    private static final String URL_Ecommerce = "https://zanottin2.testescard.limber.net.br/";
    private static EcommercePOAntigo EcommercePOAntigo;

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
        EcommercePOAntigo = new EcommercePOAntigo(driver);

        BioParquePantanal pantanal = new BioParquePantanal(EcommercePOAntigo);

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
        EcommercePOAntigo = new EcommercePOAntigo(driver);

        BioParquePantanal pantanal = new BioParquePantanal(EcommercePOAntigo);

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
        EcommercePOAntigo = new EcommercePOAntigo(driver);

        BioParquePantanal pantanal = new BioParquePantanal(EcommercePOAntigo);

        pantanal.Ingresso(driver, 3 /*tipo 3 Bilhete acesso de grupos */);
        
    }
}
