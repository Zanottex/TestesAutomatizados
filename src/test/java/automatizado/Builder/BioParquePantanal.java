package automatizado.Builder;

import static org.junit.Assert.assertEquals;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Generators.geradores;
import automatizado.Page.EcommercePO;

public class BioParquePantanal {
        private EcommercePO ECommercePO;

        private static final Logger logger = Logger
                        .getLogger(BioParqueDoRioBuilder.class
                                        .getName());

        private String email_usuario = "gustavozanotto119@gmail.com";
        private String senha_usuario = "1";

        static {
                // Configuração do handler de log para exibir logs no console
                ConsoleHandler consoleHandler = new ConsoleHandler();
                consoleHandler
                                .setLevel(Level.ALL);
                logger
                                .addHandler(consoleHandler);
        }

        public void Ingresso(WebDriver driver, int tipo) {
                Wait<WebDriver> wait = new WebDriverWait(driver, 5000);
                logger
                                .info("Aguardando a barra de pesquisa ser exibida...");

                wait
                                .until(d -> ECommercePO.barraDePesquisa
                                                .isDisplayed());
                ECommercePO.aceitarcookies
                                .click();
                logger
                                .info("Aceitando cookies...");

                if (tipo == 1 || tipo == 3) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Bioparque Pantanal");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Bioparque pantanal Acesso - Testes automatizados");
                } else if (tipo == 2) {
                        logger
                                        .info("Iniciando pesquisa: Biopaque pantanal Acesso Prioritário e Preferencial");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Biopaque pantanal Acesso Prioritário e Preferencial - Teste automatizado");
                } else {
                        logger
                                        .warning("Tipo de pesquisa inválido: " + tipo);
                }

                try {
                        Thread
                                        .sleep(1000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                wait
                                .until(d -> ECommercePO.bilhete_a_venda_grupo1
                                                .isDisplayed());
                ECommercePO.bilhete_a_venda_grupo1
                                .click();
                logger
                                .info("Selecionando bilhete...");

                logger
                                .info("Selecionando data para o dia 1");

                wait
                                .until(d -> ECommercePO.ProximoMes
                                                .isDisplayed());
                ECommercePO.ProximoMes
                                .click();

                try {
                        Thread
                                        .sleep(2000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                ECommercePO.dia
                                .click();

                try {
                        Thread
                                        .sleep(2000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }

                logger
                                .info("Selecionando Horario...");

                wait
                                .until(d -> ECommercePO.horario
                                                .isEnabled());
                ECommercePO.horario
                                .click();
                try {
                        Thread
                                        .sleep(1000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                ECommercePO.confirmarHorario4opcoes
                                .click();
                try {
                        Thread
                                        .sleep(2000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                wait
                                .until(d -> ECommercePO.proximo
                                                .isDisplayed());
                ECommercePO.proximo
                                .click();

                logger
                                .info("Adicionando categoria ao carrinho...");
                logger
                                .info("Selecionando país de origem...");

                ECommercePO.adicionarCategoria
                                .click();
                if (tipo == 3) {
                        int i = 0;
                        while (i != 7) {
                                ECommercePO.adicionarCategoria
                                                .click();
                                i++;
                        }
                        ECommercePO.adicionarCategoria2
                                        .click();
                }

                if (tipo == 2) {
                        ECommercePO.adicionarCategoria3
                                        .click();
                }

                ECommercePO.adicionarCategoria2
                                .click();
                ECommercePO.selecionarPaisOrigem
                                .click();
                ECommercePO.confirmaPaisOrigem
                                .click();

                boolean cep = false;
                try {
                        ECommercePO.CEP_Nas_categorias
                                        .isDisplayed();
                        cep = true;
                } catch (Exception e) {
                        cep = false;
                }
                if (cep) {
                        ECommercePO.CEP_Nas_categorias
                                        .sendKeys("85509432");
                }

                wait
                                .until(d -> ECommercePO.adicionarAoCarrinho
                                                .isEnabled());
                ECommercePO.adicionarAoCarrinho
                                .click();

                wait
                                .until(d -> ECommercePO.nomeUsuario
                                                .isDisplayed());
                /* nome usuario 1 */
                ECommercePO
                                .dadosUsuarios(1, 1, "09285844960", "Gustavo Zanotto", "12/02/1990", 261, "85509432",
                                                driver);

                try {
                        Thread
                                        .sleep(1000);
                } catch (

                InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                /* Segundo usuario */
                ECommercePO
                                .dadosUsuarios(1, 2, geradores
                                                .geradorCPF(),
                                                geradores
                                                                .geradorNome(),
                                                geradores
                                                                .geradorDataNascimento(),
                                                510, "85502060", driver);
                try {
                        Thread
                                        .sleep(1000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }

                if (tipo == 2 || tipo == 3) {
                        /* primeiro usuario segunda categoria */
                        ECommercePO
                                        .dadosUsuarios(2, 1, geradores
                                                        .geradorCPF(),
                                                        geradores
                                                                        .geradorNome(),
                                                        "03/04/2020", 2253, "85502060", driver);
                }
                if (tipo == 3) {
                        int i = 3;
                        int id = 759;
                        while (i != 9) {
                                ECommercePO
                                                .dadosUsuarios(1, i, geradores
                                                                .geradorCPF(),
                                                                geradores
                                                                                .geradorNome(),
                                                                geradores
                                                                                .geradorDataNascimento(),
                                                                id, "85502060",
                                                                driver);
                                i++;
                                /*o numero de id do brasil na hora de selecionar o pais começa em 261 e aumenta de 249 em 249 para cada usuario*/
                                id += 249;
                        }
                        ECommercePO
                                        .dadosUsuarios(2,2, geradores
                                                        .geradorCPF(),
                                                        geradores
                                                                        .geradorNome(),
                                                        "23/09/2018", 2502, "85502060", driver);

                }

                ECommercePO.confirmardadosusuario
                                .click();

                logger
                                .info("Finalizando pedido...");
                wait
                                .until(d -> ECommercePO.registrarEfinalizarPedido
                                                .isDisplayed());
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
                logger
                                .info("Fazendo Login...");

                wait
                                .until(d -> ECommercePO.finalizarPedido
                                                .isDisplayed());
                ECommercePO.finalizarPedido
                                .click();
                logger
                                .info("Finalizando pedido...");

                wait
                                .until(d -> ECommercePO.confirmarCompra
                                                .isDisplayed());
                String mensagem = ECommercePO.confirmarCompra
                                .getText();
                assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.",
                                mensagem);
                logger
                                .info("Pedido finalizado com sucesso!");

        }

        public BioParquePantanal(EcommercePO e) {
                this.ECommercePO = e;
        }
}
