package automatizado.Builder;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.EcommercePO;

public class MarcoDasTresFronteirasBuilder {

    private EcommercePO ECommercePO;
    private String email_usuario = "gustavozanotto119@gmail.com";
    private String senha_usuario = "1";
    private String Nome_Cartao = "Gustavin Zanottin";
    private String Numero_Cartao = "4000000000000010";
    private String mes_validade = "122500";
    private String codigo_segurança = "123";
    private String CEP = "85509432";
    private String Numero_Casa = "1050"; 
    private String cpf = "09285844960"; 
    
    public MarcoDasTresFronteirasBuilder(EcommercePO ecommercePO) {
        this.ECommercePO = ecommercePO;
    }
    
    private static final Logger logger = Logger
                        .getLogger(AquaRioBuilder.class
                                        .getName());

        static {
                // Configuração do handler de log para exibir logs no console
                ConsoleHandler consoleHandler = new ConsoleHandler();
                consoleHandler
                                .setLevel(Level.ALL);
                logger
                                .addHandler(consoleHandler);
        }

    public void venda_padrao(WebDriver driver){

         Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

         wait.until(d -> ECommercePO.aceitarcookies.isDisplayed());
         ECommercePO.aceitarcookies.click();

         wait.until(d -> ECommercePO.proximoMesHome.isEnabled());
         ECommercePO.proximoMesHome.click();

         wait.until(d -> ECommercePO.diaHome.isDisplayed());
         ECommercePO.diaHome
                 .click();
                 logger
                 .info("Selecionando o dia no calendario.");

         wait.until(d -> ECommercePO.continuarHome_primeiroBilhete_grupo2.isEnabled());
         ECommercePO.continuarHome_primeiroBilhete_grupo2
                 .click();
                 logger
                 .info("Selecionando o bilhete disponivel para aquela data.");

         wait.until(d -> ECommercePO.horarioPopUp.isDisplayed());
         ECommercePO.horarioPopUp.click();

         wait.until(d -> ECommercePO.horarioPopUp.isDisplayed());
         ECommercePO.horarioPopUp.click();

         wait.until(d -> ECommercePO.categoria1_PopUp.isDisplayed());
         ECommercePO.categoria1_PopUp
                 .click();
                 logger
                 .info("Selecionando as categorias que serão compradas.");

         ECommercePO.PaisDeOrigemPopUP.click();
         ECommercePO.BrasilPopUp.click();

         ECommercePO.EstadoPopUp.click();
         wait.until(d -> ECommercePO.AcrePopUp.isDisplayed());
         ECommercePO.AcrePopUp
                 .click();
                 logger
                 .info("Colocando pais brasil e o estado.");

         ECommercePO.adicionarAoCarrinhoPopUP.click();

         wait.until(d -> ECommercePO.nomeUsuarioPopUp.isDisplayed());
        ECommercePO.nomeUsuarioPopUp.sendKeys(Nome_Cartao);
        ECommercePO.tipoDocumentoPopUp.click();
        wait.until(d -> ECommercePO.outrosPopUp.isDisplayed());
        ECommercePO.outrosPopUp.click();
        ECommercePO.documentoPopUp.sendKeys(cpf);
        logger
        .info("Colocando os dados do usuario para a visita");
        ECommercePO.confirmardadosdoUsuarioPopUp.click();

        wait.until(d -> ECommercePO.valorBilhete1.isDisplayed());
        StringTokenizer resulBilhete1 = new StringTokenizer(ECommercePO.valorBilhete1.getText());
        String valorbilhete1 = resulBilhete1.nextToken(" ");
         valorbilhete1 = resulBilhete1.nextToken(" ");
         valorbilhete1 = valorbilhete1.replaceAll(",", ".");
         Double valor1 = Double.valueOf(valorbilhete1);

         if(valor1 == 10.0){

            ECommercePO.registrarEfinalizarPedido.click();
        wait.until(d -> ECommercePO.Email_ecommerce.isDisplayed());
            ECommercePO.Email_ecommerce.sendKeys(email_usuario);
            ECommercePO.senha_ecommerce.sendKeys(senha_usuario);
            ECommercePO.Logar
                    .click();
                    logger
                    .info("Logando na conta do usuario.");

        wait.until(d -> ECommercePO.finalizarPedido.isDisplayed());
        ECommercePO.finalizarPedido.click();

        wait.until(d -> ECommercePO.Nome_Do_Cartao.isDisplayed());

        ECommercePO.Nome_Do_Cartao.sendKeys(Nome_Cartao);

        ECommercePO.Numero_Cartao.sendKeys(Numero_Cartao);

        ECommercePO.Mes_Validade.sendKeys(mes_validade);

        ECommercePO.codigo_segurança.sendKeys(codigo_segurança);

        ECommercePO.CEP.sendKeys(CEP);

        ECommercePO.Numero_Casa
                .sendKeys(Numero_Casa);
                logger
                .info("Inserindo os dados para finalizar a compra. (CEP, cartão de crédito, CEP)");
        try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ECommercePO.finalizarCompra
                    .click();
                    logger
                    .info("Compra finalizada.");

        wait.until(d -> ECommercePO.confirmarCompra.isDisplayed());
        String mensagem = ECommercePO.confirmarCompra.getText();
        assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.", mensagem);
         }
    }

}
