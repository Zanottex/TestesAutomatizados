package automatizado.Teste;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.Page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTeste extends BaseTeste{

    /*Page Objects */
    private static LoginPO Login;
    protected static final String URL_HOMOLOG = "https://testescard.limbersoftware.com.br/#/pages/dashboard";
    protected static final String URL_Produção = "https://card.limbersoftware.com.br/#/pages/dashboard";

    /*@Test para o sistema compreender como um teste*/

    @Test
    public void TC002_Logar_Corretamente(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        iniciar(URL_HOMOLOG);
        }
        else{
            
        }
        
        RedirecionarPag(URL_HOMOLOG);
        Login = new LoginPO(driver);
        /*Abrir página de Login */
        
        
        /*Logar */
        Login.Logar("Gustavo@limbersoftware.com.br", "Gustavo1!");

        /*Esperar a página carregar */
       
        
}

    @Test
    public void TC001_Erro_Login_Email_e_Senha_Vazios(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }

        if(aberto == null){
        iniciar(URL_HOMOLOG);
        }
        else{
            RedirecionarPag(URL_HOMOLOG);
            Login = new LoginPO(driver);
            Login.quitei();
        }
        
        RedirecionarPag(URL_HOMOLOG);
        Login = new LoginPO(driver);
        
        /*Logar */
        Login.Logar("", "");
        String mensagemUsuario = Login.usuariovazio();
        assertEquals("Informe o usuário", mensagemUsuario);
        String mensagemSenha = Login.senhavazio();
        assertEquals("Informe a senha", mensagemSenha);

        /*Esperar a página carregar */
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
