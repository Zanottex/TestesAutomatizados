package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.ModosDePagamentoBuilder;
import automatizado.Page.ModosDePagamentoPO;


public class ModosDePagamentoTeste extends BaseTeste{

    /*Page Objects */
    private static final String URL_Metodo_Pagamento = "https://testescard.limbersoftware.com.br/#/pages/cadastro/modoPagamento";
    private static ModosDePagamentoPO modoPO;

    /*@Test para o sistema compreender como um teste*/
    @Test
    public void TC001_Criar_Modo(){
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
            Relogar();
        }
        driver.get(URL_HOMOLOG);
        RedirecionarPag(URL_Metodo_Pagamento);
        modoPO = new ModosDePagamentoPO(driver);

        ModosDePagamentoBuilder modo = new ModosDePagamentoBuilder(modoPO);
        
        modo.builder(driver);

       
    }
}
