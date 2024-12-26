package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.TrocaDeDadosDaVisitaBuilder;
import automatizado.Page.EcommercePO;

public class TrocaDeDadosDaVisitaTeste extends BaseTeste {
    
    private static final String URL_Ecommerce = "https://zanottincalendario.testescard.limber.net.br/";
    private static EcommercePO ecommercePO;

    @Test
    public void TC001_Remarcar_dia(){
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
            driver.get(URL_HOMOLOG);
        }
        RedirecionarPag(URL_Ecommerce);
        ecommercePO = new EcommercePO(driver);

        TrocaDeDadosDaVisitaBuilder remarcação = new TrocaDeDadosDaVisitaBuilder(ecommercePO);
        
        remarcação.builder(driver, 1);

       

    }
}
