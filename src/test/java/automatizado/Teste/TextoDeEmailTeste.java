package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.TextoDeEmailBuilder;
import automatizado.Page.TextoDeEmailPO;

public class TextoDeEmailTeste extends BaseTeste{
    
    private static final String URL_NovoEmail = "https://testescard.limbersoftware.com.br/#/pages/cadastro/texto-email";
    private static TextoDeEmailPO emailPO;

    @Test
    public void TC001_Criar_Texto_Email(){
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
        RedirecionarPag(URL_NovoEmail);
        emailPO = new TextoDeEmailPO(driver);

        TextoDeEmailBuilder email = new TextoDeEmailBuilder(emailPO);
        
        email.builder(driver);

       

    }
}
