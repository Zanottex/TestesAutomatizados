package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.GrupoDeBilhetesBuilder;
import automatizado.Page.GrupoDeBilhetesPO;

public class GrupoDeBilhetesTeste extends BaseTeste{
    
    private static final String URL_NovoGrupoBilhetes = "https://testescard.limbersoftware.com.br/#/pages/cadastro/grupo-bilhete/novo-grupo";
    private static GrupoDeBilhetesPO grupoPO;

    @Test
    public void TC001_Criar_Grupo_Bilhetes(){
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
        RedirecionarPag(URL_NovoGrupoBilhetes);
        grupoPO = new GrupoDeBilhetesPO(driver);

        GrupoDeBilhetesBuilder grupo = new GrupoDeBilhetesBuilder(grupoPO);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        grupo.
        builder(driver);
    }

}
