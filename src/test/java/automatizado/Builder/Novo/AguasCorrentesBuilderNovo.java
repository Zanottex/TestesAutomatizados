package automatizado.Builder.Novo;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import automatizado.Page.EcommercePONovo;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AguasCorrentesBuilderNovo {

        private EcommercePONovo EcommercePONovo;
        private String email_usuario = "gustavozanotto119@gmail.com";
        private String senha_usuario = "1";
        

        private static final Logger logger = Logger
                        .getLogger(AguasCorrentesBuilderNovo.class
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
                BaseBuilderNovo base = new BaseBuilderNovo(EcommercePONovo);
                try {
                        Thread
                                        .sleep(2000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                try {
                        EcommercePONovo.aceitarcookies
                                        .click();
                        logger
                                        .info("Aceitando os cookies.");
                } catch (Exception e) {
                        
                }

                wait
                                .until(d -> EcommercePONovo.proximoMesHome
                                                .isEnabled());
                EcommercePONovo.proximoMesHome
                                .click();
                logger
                                .info("Selecionando o mes.");

                wait
                                .until(d -> EcommercePONovo.diaHome
                                                .isDisplayed());
                EcommercePONovo.diaHome
                                .click();
                logger
                                .info("Selecionando o dia.");

                if (tipo == 1) {
                        wait
                                        .until(d -> EcommercePONovo.continuarHome_primeiroBilhete_grupo1
                                                        .isEnabled());
                        EcommercePONovo.continuarHome_primeiroBilhete_grupo1
                                        .click();
                        logger
                                        .info("Selecionando o bilhete avulsso.");
                } else if (tipo == 2) {
                        wait
                                        .until(d -> EcommercePONovo.continuarHome_segundoBilhete_grupo1
                                                        .isEnabled());
                        EcommercePONovo.continuarHome_segundoBilhete_grupo1
                                        .click();
                        logger
                                        .info("Selecionando o bilhete combo 5 ingressos.");
                }

                wait
                                .until(d -> EcommercePONovo.horarioPopUp
                                                .isDisplayed());
                EcommercePONovo.horarioPopUp
                                .click();
                logger
                                .info("Seleconando o horario.");

                /* confirma o horario */
                wait
                                .until(d -> EcommercePONovo.horarioPopUp
                                                .isDisplayed());
                EcommercePONovo.horarioPopUp
                                .click();

                wait
                                .until(d -> EcommercePONovo.categoria1_PopUp
                                                .isDisplayed());
                EcommercePONovo.categoria1_PopUp
                                .click();
                if (tipo == 1) {
                        wait
                                        .until(d -> EcommercePONovo.categoria2_PopUp
                                                        .isDisplayed());
                        EcommercePONovo.categoria2_PopUp
                                        .click();
                }
                logger
                                .info("Seleconando o as categorias");
                EcommercePONovo.PaisDeOrigemPopUP
                                .click();
                EcommercePONovo.BrasilPopUp
                                .click();
                try {
                        Thread
                                        .sleep(2000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }

                EcommercePONovo.CEPPopUp
                                .sendKeys("85509432");
                logger
                                .info("Colocando pais e estado.");

                wait
                                .until(d -> EcommercePONovo.adicionarAoCarrinhoPopUP
                                                .isDisplayed());
                try {
                        Thread
                                        .sleep(1000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                EcommercePONovo.adicionarAoCarrinhoPopUP
                                .click();

                if (tipo == 1) {
                        EcommercePONovo.bilhete_extra_popUP_2
                                        .click();
                } else if (tipo == 2) {
                        EcommercePONovo.bilhete_extra_popUP_1
                                        .click();
                }
                logger
                                .info("Adicionando o bilhete extra do POPUP.");

                wait
                                .until(d -> EcommercePONovo.horarioPopUp
                                                .isDisplayed());
                EcommercePONovo.horarioPopUp
                                .click();

                wait
                                .until(d -> EcommercePONovo.horarioPopUp
                                                .isDisplayed());
                EcommercePONovo.horarioPopUp
                                .click();

                logger
                                .info("Seleconando o horario.");

                wait
                                .until(d -> EcommercePONovo.categoria1_PopUp
                                                .isDisplayed());
                EcommercePONovo.categoria1_PopUp
                                .click();
                logger
                                .info("Seleconando o categoria.");

                EcommercePONovo.PaisDeOrigemPopUP
                                .click();
                EcommercePONovo.BrasilPopUp
                                .click();
                logger
                                .info("Seleconando o pais");
                try {
                        Thread
                                        .sleep(2000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }

                EcommercePONovo.CEPPopUp
                                .sendKeys("85509432");
                logger
                                .info("Colocando o CEP.");
                wait
                                .until(d -> EcommercePONovo.adicionarAoCarrinhoPopUP
                                                .isDisplayed());
                EcommercePONovo.adicionarAoCarrinhoPopUP
                                .click();
                logger
                                .info("Bilhete extra adicionado ao carrinho.");

                Double valor1 = 0.0;
                boolean logado = false;
                try {
                        Thread
                                        .sleep(3000);
                        logado = EcommercePONovo.irParaPagamento
                                        .isDisplayed();
                } catch (Exception e) {

                }
                StringTokenizer resulBilhete1 = null;
                if (logado) {
                        resulBilhete1 = new StringTokenizer(EcommercePONovo
                                        .valorTotalDoBilhete(3, driver));
                } else {
                        resulBilhete1 = new StringTokenizer(EcommercePONovo
                                        .valorTotalDoBilhete(2, driver));
                }
                String valorbilhete1 = resulBilhete1
                                .nextToken(" ");
                valorbilhete1 = resulBilhete1
                                .nextToken(" ");
                valorbilhete1 = resulBilhete1
                                .nextToken(" ");
                valorbilhete1 = valorbilhete1
                                .replaceAll(",", ".");
                valor1 = Double
                                .valueOf(valorbilhete1);

                logger
                                .info("Verificando os preços dos bilhetes.");
                String Captcha = null; 
                if (valor1 == 17.0 || valor1 == 120.0) {
                        if (logado) {

                        } else {
                                EcommercePONovo.registrarEfinalizarPedido
                                                .click();
                                wait
                                                .until(d -> EcommercePONovo.Email_ecommerce
                                                                .isDisplayed());
                                EcommercePONovo.Email_ecommerce
                                                .sendKeys(email_usuario);
                                EcommercePONovo.senha_ecommerce
                                                .sendKeys(senha_usuario);
                                logger
                                                .info("Logando na conta do usuario.");
                                EcommercePONovo.Logar
                                                .click();
                                try {
                                        Thread
                                                        .sleep(4000);
                                        Captcha = EcommercePONovo.pegarMensagemErro
                                                        .getText();
                                } catch (Exception e) {
                                }
                        }
                        if (Captcha == null) {

                                wait
                                                .until(d -> EcommercePONovo.aceitar_termos_finalizar_pedido
                                                                .isDisplayed());
                                EcommercePONovo.aceitar_termos_finalizar_pedido
                                                .click();
                                logger
                                                .info("Aceitando termos e condições.");

                                wait
                                                .until(d -> EcommercePONovo.irParaPagamento
                                                                .isDisplayed());
                                EcommercePONovo.irParaPagamento
                                                .click();
                                logger
                                                .info("Finalizando pedido.");

                                base
                                                .realizarpagamento(driver);

                                wait
                                                .until(d -> EcommercePONovo.confirmarCompra
                                                                .isDisplayed());
                                String mensagem = EcommercePONovo.confirmarCompra
                                                .getText();
                                assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.",
                                                mensagem);
                                logger
                                                .info("Confirmação de bilhete vendido.");
                        } else {
                                JavascriptExecutor js = (JavascriptExecutor) driver;
                        js
                                        .executeScript("alert('ERRO: Captcha bloqueou o programa');");
                        logger
                                        .severe("ERRO: Captcha bloqueou o programa.");
                        }
                }else

        {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js
                                        .executeScript("alert('ERRO: VALOR DO BILHETE INVÁLIDO');");
                        logger
                                        .severe("ERRO: VALOR DO BILHETE INVÁLIDO.");
                }
        }

        public AguasCorrentesBuilderNovo(EcommercePONovo e) {
                this.EcommercePONovo = e;
        }
}
