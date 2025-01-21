package automatizado.Builder.Antigo;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Generators.geradores;
import automatizado.Page.EcommercePOAntigo;

public class MarcoDasTresFronteirasBuilder {

        private EcommercePOAntigo EcommercePOAntigo;
        private String email_usuario = "gustavozanotto119@gmail.com";
        private String senha_usuario = "1";
        private String Nome_Cartao = "Gustavin Zanottin";
        private String Numero_Cartao = "4000000000000010";
        private String mes_validade = geradores
                        .geradorValidadeCartao()
                        .toString();
        private String codigo_segurança = "123";
        private String CEP = "85509432";
        private String Numero_Casa = "1050";
        private String cpf = "09285844960";

        public MarcoDasTresFronteirasBuilder(EcommercePOAntigo EcommercePOAntigo) {
                this.EcommercePOAntigo = EcommercePOAntigo;
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

        public void venda_padrao(WebDriver driver) {

                Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

                wait
                                .until(d -> EcommercePOAntigo.aceitarcookies
                                                .isDisplayed());
                EcommercePOAntigo.aceitarcookies
                                .click();

                wait
                                .until(d -> EcommercePOAntigo.proximoMesHome
                                                .isEnabled());
                EcommercePOAntigo.proximoMesHome
                                .click();

                wait
                                .until(d -> EcommercePOAntigo.diaHome
                                                .isDisplayed());
                EcommercePOAntigo.diaHome
                                .click();
                logger
                                .info("Selecionando o dia no calendario.");

                wait
                                .until(d -> EcommercePOAntigo.continuarHome_primeiroBilhete_grupo2
                                                .isEnabled());
                EcommercePOAntigo.continuarHome_primeiroBilhete_grupo2
                                .click();
                logger
                                .info("Selecionando o bilhete disponivel para aquela data.");

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

                wait
                                .until(d -> EcommercePOAntigo.categoria1_PopUp
                                                .isDisplayed());
                EcommercePOAntigo.categoria1_PopUp
                                .click();
                logger
                                .info("Selecionando as categorias que serão compradas.");

                EcommercePOAntigo.PaisDeOrigemPopUP
                                .click();
                EcommercePOAntigo.BrasilPopUp
                                .click();

                EcommercePOAntigo.EstadoPopUp
                                .click();
                wait
                                .until(d -> EcommercePOAntigo.AcrePopUp
                                                .isDisplayed());
                EcommercePOAntigo.AcrePopUp
                                .click();
                logger
                                .info("Colocando pais brasil e o estado.");

                EcommercePOAntigo.adicionarAoCarrinhoPopUP
                                .click();

                wait
                                .until(d -> EcommercePOAntigo.nomeUsuarioPopUp
                                                .isDisplayed());
                EcommercePOAntigo.nomeUsuarioPopUp
                                .sendKeys(Nome_Cartao);
                EcommercePOAntigo.tipoDocumentoPopUp
                                .click();
                wait
                                .until(d -> EcommercePOAntigo.outrosPopUp
                                                .isDisplayed());
                EcommercePOAntigo.outrosPopUp
                                .click();
                EcommercePOAntigo.documentoPopUp
                                .sendKeys(cpf);
                logger
                                .info("Colocando os dados do usuario para a visita");
                EcommercePOAntigo.confirmardadosdoUsuarioPopUp
                                .click();

                wait
                                .until(d -> EcommercePOAntigo.valorBilhete1
                                                .isDisplayed());
                StringTokenizer resulBilhete1 = new StringTokenizer(EcommercePOAntigo.valorBilhete1
                                .getText());
                String valorbilhete1 = resulBilhete1
                                .nextToken(" ");
                valorbilhete1 = resulBilhete1
                                .nextToken(" ");
                valorbilhete1 = valorbilhete1
                                .replaceAll(",", ".");
                Double valor1 = Double
                                .valueOf(valorbilhete1);
                String Captcha = null;
                if (valor1 == 10.0) {

                        EcommercePOAntigo.registrarEfinalizarPedido
                                        .click();
                        wait
                                        .until(d -> EcommercePOAntigo.Email_ecommerce
                                                        .isDisplayed());
                        EcommercePOAntigo.Email_ecommerce
                                        .sendKeys(email_usuario);
                        EcommercePOAntigo.senha_ecommerce
                                        .sendKeys(senha_usuario);
                        EcommercePOAntigo.Logar
                                        .click();
                        logger
                                        .info("Logando na conta do usuario.");
                        try {
                                Thread
                                                .sleep(4000);
                                Captcha = EcommercePOAntigo.pegarMensagemErro
                                                .getText();
                        } catch (Exception e) {
                        }
                        if (Captcha == null) {
                                wait
                                                .until(d -> EcommercePOAntigo.finalizarPedido
                                                                .isDisplayed());
                                EcommercePOAntigo.finalizarPedido
                                                .click();

                                wait
                                                .until(d -> EcommercePOAntigo.Nome_Do_Cartao
                                                                .isDisplayed());

                                EcommercePOAntigo.Nome_Do_Cartao
                                                .sendKeys(Nome_Cartao);

                                EcommercePOAntigo.Numero_Cartao
                                                .sendKeys(Numero_Cartao);

                                EcommercePOAntigo.Mes_Validade
                                                .sendKeys(mes_validade);

                                EcommercePOAntigo.codigo_segurança
                                                .sendKeys(codigo_segurança);

                                EcommercePOAntigo.CEP
                                                .sendKeys(CEP);

                                EcommercePOAntigo.Numero_Casa
                                                .sendKeys(Numero_Casa);
                                logger
                                                .info("Inserindo os dados para finalizar a compra. (CEP, cartão de crédito)");
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }

                                EcommercePOAntigo.finalizarCompra
                                                .click();
                                logger
                                                .info("Compra finalizada.");

                                wait
                                                .until(d -> EcommercePOAntigo.confirmarCompra
                                                                .isDisplayed());
                                String mensagem = EcommercePOAntigo.confirmarCompra
                                                .getText();
                                assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.",
                                                mensagem);
                        } else {
                                JavascriptExecutor js = (JavascriptExecutor) driver;
                                js
                                                .executeScript("alert('ERRO: Bloqueio de Captcha');");
                                logger
                                                .severe("ERRO: Captcha bloqueou o programa.");
                        }
                }
        }

}
