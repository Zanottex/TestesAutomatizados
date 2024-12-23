package automatizado.Builder;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.EcommercePO;
import automatizado.Generators.geradores;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AguasCorrentesBuilder {

    private EcommercePO ECommercePO;
    private String email_usuario = "gustavozanotto119@gmail.com";
    private String senha_usuario = "1";
    private String Nome_Cartao = geradores
            .geradorNome();
    private String Numero_Cartao = "4000000000000010";
    private String mes_validade = geradores
            .geradorValidadeCartao();
    private String codigo_segurança = geradores
            .geradorCodigoSeguranca();
    private String CEP = geradores
            .geradorCEP();
    private String Numero_Casa = geradores
            .geradorNumeroCasa();

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

    public void avulsso(WebDriver driver, int tipo) {

        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait
                .until(d -> ECommercePO.aceitarcookies
                        .isDisplayed());
        ECommercePO.aceitarcookies
                .click();

        wait
                .until(d -> ECommercePO.proximoMesHome
                        .isEnabled());
        ECommercePO.proximoMesHome
                .click();

        wait
                .until(d -> ECommercePO.diaHome
                        .isDisplayed());
        ECommercePO.diaHome
                .click();

        if (tipo == 1) {
            wait
                    .until(d -> ECommercePO.continuarHome_primeiroBilhete_grupo1
                            .isEnabled());
            ECommercePO.continuarHome_primeiroBilhete_grupo1
                    .click();
        } else if (tipo == 2) {
            wait
                    .until(d -> ECommercePO.continuarHome_segundoBilhete_grupo1
                            .isEnabled());
            ECommercePO.continuarHome_segundoBilhete_grupo1
                    .click();
        }

        wait
                .until(d -> ECommercePO.horarioPopUp
                        .isDisplayed());
        ECommercePO.horarioPopUp
                .click();

        wait
                .until(d -> ECommercePO.horarioPopUp
                        .isDisplayed());
        ECommercePO.horarioPopUp
                .click();

        wait
                .until(d -> ECommercePO.categoria1_PopUp
                        .isDisplayed());
        ECommercePO.categoria1_PopUp
                .click();
        if (tipo == 1) {
            wait
                    .until(d -> ECommercePO.categoria2_PopUp
                            .isDisplayed());
            ECommercePO.categoria2_PopUp
                    .click();
        }

        ECommercePO.PaisDeOrigemPopUP
                .click();
        ECommercePO.BrasilPopUp
                .click();
        try {
            Thread
                    .sleep(2000);
        } catch (InterruptedException e) {
            e
                    .printStackTrace();
        }

        ECommercePO.CEPPopUp
                .sendKeys("85509432");

        wait
                .until(d -> ECommercePO.adicionarAoCarrinhoPopUP
                        .isDisplayed());
        try {
            Thread
                    .sleep(1000);
        } catch (InterruptedException e) {
            e
                    .printStackTrace();
        }
        ECommercePO.adicionarAoCarrinhoPopUP
                .click();

        if (tipo == 1) {
            ECommercePO.bilhete_extra_popUP_2
                    .click();
        } else if (tipo == 2) {
            ECommercePO.bilhete_extra_popUP_1
                    .click();
        }

        wait
                .until(d -> ECommercePO.horarioPopUp
                        .isDisplayed());
        ECommercePO.horarioPopUp
                .click();

        wait
                .until(d -> ECommercePO.horarioPopUp
                        .isDisplayed());
        ECommercePO.horarioPopUp
                .click();

        wait
                .until(d -> ECommercePO.categoria1_PopUp
                        .isDisplayed());
        ECommercePO.categoria1_PopUp
                .click();

        ECommercePO.PaisDeOrigemPopUP
                .click();
        ECommercePO.BrasilPopUp
                .click();
        try {
            Thread
                    .sleep(2000);
        } catch (InterruptedException e) {
            e
                    .printStackTrace();
        }

        ECommercePO.CEPPopUp
                .sendKeys("85509432");

        wait
                .until(d -> ECommercePO.adicionarAoCarrinhoPopUP
                        .isDisplayed());
        ECommercePO.adicionarAoCarrinhoPopUP
                .click();

        wait
                .until(d -> ECommercePO.valorBilhete1
                        .isDisplayed());
        StringTokenizer resulBilhete1 = new StringTokenizer(ECommercePO.valorBilhete1
                .getText());
        String valorbilhete1 = resulBilhete1
                .nextToken(" ");
        valorbilhete1 = resulBilhete1
                .nextToken(" ");
        valorbilhete1 = valorbilhete1
                .replaceAll(",", ".");
        Double valor1 = Double
                .valueOf(valorbilhete1);

        StringTokenizer resulBilhete2 = new StringTokenizer(ECommercePO.valorBilhete2
                .getText());
        String valorbilhete2 = resulBilhete2
                .nextToken(" ");
        valorbilhete2 = resulBilhete2
                .nextToken(" ");
        valorbilhete2 = valorbilhete2
                .replaceAll(",", ".");
        Double valor2 = Double
                .valueOf(valorbilhete2);

        double valorsomado = valor1 + valor2;
        if (valorsomado == 17.0 || valorsomado == 120.0) {

            ECommercePO.registrarEfinalizarPedido
                    .click();
            wait
                    .until(d -> ECommercePO.Email_ecommerce
                            .isDisplayed());
            ECommercePO.Email_ecommerce
                    .sendKeys(email_usuario);
            ECommercePO.senha_ecommerce
                    .sendKeys(senha_usuario);
            ECommercePO.Logar
                    .click();

                    
            wait
                    .until(d -> ECommercePO.aceitar_termos_finalizar_pedido
                            .isDisplayed());
            ECommercePO.aceitar_termos_finalizar_pedido
                    .click();
                    

            wait
                    .until(d -> ECommercePO.finalizarPedido
                            .isDisplayed());
            ECommercePO.finalizarPedido
                    .click();

            wait
                    .until(d -> ECommercePO.Nome_Do_Cartao
                            .isDisplayed());

            ECommercePO.Nome_Do_Cartao
                    .sendKeys(Nome_Cartao);

            ECommercePO.Numero_Cartao
                    .sendKeys(Numero_Cartao);

            ECommercePO.Mes_Validade
                    .sendKeys(mes_validade);

            ECommercePO.codigo_segurança
                    .sendKeys(codigo_segurança);

            ECommercePO.CEP
                    .sendKeys(CEP);

            ECommercePO.Numero_Casa
                    .sendKeys(Numero_Casa);
            try {
                Thread
                        .sleep(1000);
            } catch (InterruptedException e) {
                e
                        .printStackTrace();
            }

            ECommercePO.finalizarCompra
                    .click();

            wait
                    .until(d -> ECommercePO.confirmarCompra
                            .isDisplayed());
            String mensagem = ECommercePO.confirmarCompra
                    .getText();
            assertEquals(
                    "Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.",
                    mensagem);
        } else {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js
                    .executeScript("alert('ERRO: VALOR DO BILHETE INVÁLIDO');");
            logger
                    .severe("ERRO: VALOR DO BILHETE INVÁLIDO.");
        }
    }

    public AguasCorrentesBuilder(EcommercePO e) {
        this.ECommercePO = e;
    }
}
