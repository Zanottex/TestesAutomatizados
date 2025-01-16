package automatizado.Builder.Antigo;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import automatizado.Page.EcommercePOAntigo;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AguasCorrentesBuilder {

        private EcommercePOAntigo EcommercePOAntigo;
        private String email_usuario = "gustavozanotto119@gmail.com";
        private String senha_usuario = "1";
        

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
                BaseBuilder base = new BaseBuilder(EcommercePOAntigo);
                try {
                        Thread
                                        .sleep(2000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                try {
                        EcommercePOAntigo.aceitarcookies
                                        .click();
                        logger
                                        .info("Aceitando os cookies.");
                } catch (Exception e) {
                        
                }

                wait
                                .until(d -> EcommercePOAntigo.proximoMesHome
                                                .isEnabled());
                EcommercePOAntigo.proximoMesHome
                                .click();
                logger
                                .info("Selecionando o mes.");

                wait
                                .until(d -> EcommercePOAntigo.diaHome
                                                .isDisplayed());
                EcommercePOAntigo.diaHome
                                .click();
                logger
                                .info("Selecionando o dia.");

                if (tipo == 1) {
                        wait
                                        .until(d -> EcommercePOAntigo.continuarHome_primeiroBilhete_grupo1
                                                        .isEnabled());
                        EcommercePOAntigo.continuarHome_primeiroBilhete_grupo1
                                        .click();
                        logger
                                        .info("Selecionando o bilhete avulsso.");
                } else if (tipo == 2) {
                        wait
                                        .until(d -> EcommercePOAntigo.continuarHome_segundoBilhete_grupo1
                                                        .isEnabled());
                        EcommercePOAntigo.continuarHome_segundoBilhete_grupo1
                                        .click();
                        logger
                                        .info("Selecionando o bilhete combo 5 ingressos.");
                }

                wait
                                .until(d -> EcommercePOAntigo.horarioPopUp
                                                .isDisplayed());
                EcommercePOAntigo.horarioPopUp
                                .click();
                logger
                                .info("Seleconando o horario.");

                /* confirma o horario */
                wait
                                .until(d -> EcommercePOAntigo.horarioPopUp
                                                .isDisplayed());
                EcommercePOAntigo.horarioPopUp
                                .click();

                wait
                                .until(d -> EcommercePOAntigo.categoria1_PopUp
                                                .isDisplayed());
                EcommercePOAntigo.categoria1_PopUp
                                .click();
                if (tipo == 1) {
                        wait
                                        .until(d -> EcommercePOAntigo.categoria2_PopUp
                                                        .isDisplayed());
                        EcommercePOAntigo.categoria2_PopUp
                                        .click();
                }
                logger
                                .info("Seleconando o as categorias");
                EcommercePOAntigo.PaisDeOrigemPopUP
                                .click();
                EcommercePOAntigo.BrasilPopUp
                                .click();
                try {
                        Thread
                                        .sleep(2000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }

                EcommercePOAntigo.CEPPopUp
                                .sendKeys("85509432");
                logger
                                .info("Colocando pais e estado.");

                wait
                                .until(d -> EcommercePOAntigo.adicionarAoCarrinhoPopUP
                                                .isDisplayed());
                try {
                        Thread
                                        .sleep(1000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                EcommercePOAntigo.adicionarAoCarrinhoPopUP
                                .click();

                if (tipo == 1) {
                        EcommercePOAntigo.bilhete_extra_popUP_2
                                        .click();
                } else if (tipo == 2) {
                        EcommercePOAntigo.bilhete_extra_popUP_1
                                        .click();
                }
                logger
                                .info("Adicionando o bilhete extra do POPUP.");

                wait
                                .until(d -> EcommercePOAntigo.horarioPopUp
                                                .isDisplayed());
                EcommercePOAntigo.horarioPopUp
                                .click();

                wait
                                .until(d -> EcommercePOAntigo.horarioPopUp
                                                .isDisplayed());
                EcommercePOAntigo.horarioPopUp
                                .click();

                logger
                                .info("Seleconando o horario.");

                wait
                                .until(d -> EcommercePOAntigo.categoria1_PopUp
                                                .isDisplayed());
                EcommercePOAntigo.categoria1_PopUp
                                .click();
                logger
                                .info("Seleconando o categoria.");

                EcommercePOAntigo.PaisDeOrigemPopUP
                                .click();
                EcommercePOAntigo.BrasilPopUp
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

                EcommercePOAntigo.CEPPopUp
                                .sendKeys("85509432");
                logger
                                .info("Colocando o CEP.");
                wait
                                .until(d -> EcommercePOAntigo.adicionarAoCarrinhoPopUP
                                                .isDisplayed());
                EcommercePOAntigo.adicionarAoCarrinhoPopUP
                                .click();
                logger
                                .info("Bilhete extra adicionado ao carrinho.");

                Double valor1 = 0.0;
                boolean logado = false;
                try {
                        Thread
                                        .sleep(3000);
                        logado = EcommercePOAntigo.finalizarPedido
                                        .isDisplayed();
                } catch (Exception e) {

                }
                StringTokenizer resulBilhete1 = null;
                if (logado) {
                        resulBilhete1 = new StringTokenizer(EcommercePOAntigo
                                        .valorTotalDoBilhete(3, driver));
                } else {
                        resulBilhete1 = new StringTokenizer(EcommercePOAntigo
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
                
                if (valor1 == 17.0 || valor1 == 120.0) {
                        if (logado) {

                        } else {
                                EcommercePOAntigo.registrarEfinalizarPedido
                                                .click();
                                wait
                                                .until(d -> EcommercePOAntigo.Email_ecommerce
                                                                .isDisplayed());
                                EcommercePOAntigo.Email_ecommerce
                                                .sendKeys(email_usuario);
                                EcommercePOAntigo.senha_ecommerce
                                                .sendKeys(senha_usuario);
                                logger
                                                .info("Logando na conta do usuario.");
                                EcommercePOAntigo.Logar
                                                .click();
                                
                        }
wait
                                                .until(d -> EcommercePOAntigo.aceitar_termos_finalizar_pedido
                                                                .isDisplayed());
                                EcommercePOAntigo.aceitar_termos_finalizar_pedido
                                                .click();
                        logger
                                        .info("Aceitando termos e condições.");

                        wait
                                        .until(d -> EcommercePOAntigo.finalizarPedido
                                                        .isDisplayed());
                        EcommercePOAntigo.finalizarPedido
                                        .click();
                        logger
                                        .info("Finalizando pedido.");

                        base
                                        .realizarpagamento(driver);

                        wait
                                        .until(d -> EcommercePOAntigo.confirmarCompra
                                                        .isDisplayed());
                        String mensagem = EcommercePOAntigo.confirmarCompra
                                        .getText();
                        assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.",
                                        mensagem);
                        logger
                                        .info("Confirmação de bilhete vendido.");
                } else {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js
                                        .executeScript("alert('ERRO: VALOR DO BILHETE INVÁLIDO');");
                        logger
                                        .severe("ERRO: VALOR DO BILHETE INVÁLIDO.");
                }
        }

        public AguasCorrentesBuilder(EcommercePOAntigo e) {
                this.EcommercePOAntigo = e;
        }
}
