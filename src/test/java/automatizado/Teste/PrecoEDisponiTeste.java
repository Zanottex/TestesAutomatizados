package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.PrecoEDisponiBuilder;
import automatizado.Page.PrecoEDisponiPO;

public class PrecoEDisponiTeste extends BaseTeste{

    private static final String URL_PrecoeDisponi = "https://testescard.limbersoftware.com.br/#/pages/calendarioPrecoDisp/config";
    private static PrecoEDisponiPO precoPO;

    @Test
    public void TC001_Configurar_Corretamente(){
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
            driver.get(URL_HOMOLOG);
        }
        RedirecionarPag(URL_PrecoeDisponi);
        precoPO = new PrecoEDisponiPO(driver);
        PrecoEDisponiBuilder tabelas = new PrecoEDisponiBuilder(precoPO);

        tabelas.builder(driver);
       
    }
    
}
