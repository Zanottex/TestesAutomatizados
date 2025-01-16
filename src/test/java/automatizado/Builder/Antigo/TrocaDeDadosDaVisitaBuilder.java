package automatizado.Builder.Antigo;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.EcommercePOAntigo;

public class TrocaDeDadosDaVisitaBuilder {

        private EcommercePOAntigo EcommercePOAntigo;

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

        public TrocaDeDadosDaVisitaBuilder(EcommercePOAntigo EcommercePOAntigo) {
                this.EcommercePOAntigo = EcommercePOAntigo;
        }

        public void builder(WebDriver driver, int tipo) {

                Wait<WebDriver> wait = new WebDriverWait(driver, 5000);
                logger
                                .info("Abrindo a tela de Login no E-Commerce.");
                wait
                                .until(d -> EcommercePOAntigo.olaFaçaSeuLogin
                                                .isDisplayed());
                EcommercePOAntigo.aceitarcookies
                                .click();
                EcommercePOAntigo.olaFaçaSeuLogin
                                .click();
                EcommercePOAntigo.Entrar
                                .click();

                wait
                                .until(d -> EcommercePOAntigo.Email_ecommerce
                                                .isDisplayed());
                EcommercePOAntigo.Email_ecommerce
                                .sendKeys("gustavozanotto119@gmail.com");
                EcommercePOAntigo.senha_ecommerce
                                .sendKeys("1");
                logger
                                .info("Logando na conta como um usuario comum.");
                EcommercePOAntigo.Logar
                                .click();

                wait
                                .until(d -> EcommercePOAntigo.proximoMesHome
                                                .isDisplayed());
                EcommercePOAntigo.olaFaçaSeuLogin
                                .click();
                EcommercePOAntigo.meus_pedidos
                                .click();
                logger
                                .info("Abrindo a aba de 'Meus Pedidos'.");
                wait
                                .until(d -> EcommercePOAntigo.ultima_venda
                                                .isDisplayed());
                EcommercePOAntigo.ultima_venda
                                .click();
                try {
                        Thread
                                        .sleep(1000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                logger
                                .info("Arindo a ultima venda.");
                /* Verifica se o bilhete tem a opção de alterar as informações da visita. */
                if (EcommercePOAntigo.alterar_informações_da_visita
                                .isEnabled()) {

                        EcommercePOAntigo.alterar_informações_da_visita
                                        .click();
                        wait
                                        .until(d -> EcommercePOAntigo.alterar_data_de_visita
                                                        .isDisplayed());
                        logger
                                        .info("Trocando a data da visita do bilhete.");
                        EcommercePOAntigo.alterar_data_de_visita
                                        .click();
                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        EcommercePOAntigo.proximo_mes_remarcação
                                        .click();
                        try {
                                Thread
                                                .sleep(2000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        EcommercePOAntigo.dia_remarcação
                                        .click();
                        EcommercePOAntigo.salvar_remarcação
                                        .click();
                        logger
                                        .info("Data da visita alterada.");
                        /*
                         * TODO: achar uma forma de confirmar que a dara da visita foi trocada
                         * corretamente
                         */
                } else {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js
                                        .executeScript("alert('Bilhete sem remarcação liberado!');");
                }

        }

}
