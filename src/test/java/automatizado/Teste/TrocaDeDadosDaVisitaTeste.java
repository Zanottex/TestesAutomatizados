package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.Antigo.TrocaDeDadosDaVisitaBuilder;
import automatizado.Page.EcommercePOAntigo;

public class TrocaDeDadosDaVisitaTeste extends BaseTeste {
    
    private static final String URL_Ecommerce = "https://testeauto_integrada.testescard.limber.net.br/";
    private static EcommercePOAntigo EcommercePOAntigo;

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
        EcommercePOAntigo = new EcommercePOAntigo(driver);

        TrocaDeDadosDaVisitaBuilder remarcação = new TrocaDeDadosDaVisitaBuilder(EcommercePOAntigo);
        
        remarcação.builder(driver, 1);

       

    }
}
