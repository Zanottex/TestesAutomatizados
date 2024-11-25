package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.TermoDeAceiteBuilder;
import automatizado.Page.TermoDeAceitePO;

public class TermoDeAceiteTeste extends BaseTeste{
    
    private static final String URL_NovoTermo = "https://testescard.limbersoftware.com.br/#/pages/cadastro/termo-aceite";
    private static TermoDeAceitePO termoPO;

    @Test
    public void TC001_Criar_Termo(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        AbrirCard();
        }
        else{
        }
        RedirecionarPag(URL_NovoTermo);
        termoPO = new TermoDeAceitePO(driver);

        TermoDeAceiteBuilder termo = new TermoDeAceiteBuilder(termoPO);
        
        termo.builder(driver);
    }
}
