package automatizado.Teste;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import automatizado.Builder.Antigo.FundacaoBuilder;
import automatizado.Page.EcommercePOAntigo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FundaçãoTeste extends BaseTeste{
    
    private static EcommercePOAntigo EcommercePOAntigo;
    private static final String ULR_Ecommerce = "https://zanottin.testescard.limber.net.br/";

    @Test
    public void TC001_Bilhete_Simples(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        iniciar(ULR_Ecommerce);
        }
        else{
        RedirecionarPag(ULR_Ecommerce);
        }

        EcommercePOAntigo = new EcommercePOAntigo(driver);
        FundacaoBuilder ecommerce = new FundacaoBuilder(EcommercePOAntigo);

        ecommerce.Builder(driver, 1);
    }

    @Test
    public void TC002_Bilhete_Multiplas_Datas(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        iniciar(ULR_Ecommerce);
        }
        else{
        RedirecionarPag(ULR_Ecommerce);
        }

        EcommercePOAntigo = new EcommercePOAntigo(driver);
        FundacaoBuilder ecommerce = new FundacaoBuilder(EcommercePOAntigo);

        ecommerce.Builder(driver, 2);
    }

    @Test
    public void TC003_Credenciado(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        iniciar(ULR_Ecommerce);
        }
        else{
        RedirecionarPag(ULR_Ecommerce);
        }

        EcommercePOAntigo = new EcommercePOAntigo(driver);
        FundacaoBuilder ecommerce = new FundacaoBuilder(EcommercePOAntigo);

        ecommerce.Builder(driver, 3);
    }

    @Test
    public void TC004_Venda_No_Ecommerce_bilhete_vinculado(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        iniciar(ULR_Ecommerce);
        }
        else{
        RedirecionarPag(ULR_Ecommerce);
        }
        
        EcommercePOAntigo = new EcommercePOAntigo(driver);
        FundacaoBuilder ecommerce = new FundacaoBuilder(EcommercePOAntigo);

        ecommerce.Builder(driver, 4);
          
    }

    @Test
    public void TC005_Venda_No_Ecommerce_Desconto_progressivo(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        iniciar(ULR_Ecommerce);
        }
        else{
        RedirecionarPag(ULR_Ecommerce);
        }
        
        EcommercePOAntigo = new EcommercePOAntigo(driver);
        FundacaoBuilder ecommerce = new FundacaoBuilder(EcommercePOAntigo);

        ecommerce.Builder(driver, 5);
          
    }

    @Test
    public void TC006_Bilhete_quantidade_minima(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        iniciar(ULR_Ecommerce);
        }
        else{
        RedirecionarPag(ULR_Ecommerce);
        }
        
        EcommercePOAntigo = new EcommercePOAntigo(driver);
        FundacaoBuilder ecommerce = new FundacaoBuilder(EcommercePOAntigo);

        ecommerce.Builder(driver, 6);
          
    }
}
