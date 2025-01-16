package automatizado.Builder.Antigo;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Generators.geradores;
import automatizado.Page.EcommercePOAntigo;

public class BioParquePantanal {
        private EcommercePOAntigo EcommercePOAntigo;

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

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        public void Ingresso(WebDriver driver, int tipo) {
                Wait<WebDriver> wait = new WebDriverWait(driver, 5000);
                logger
                                .info("Aguardando a barra de pesquisa ser exibida...");

                wait
                                .until(d -> EcommercePOAntigo.barraDePesquisa
                                                .isDisplayed());
                try {
                        try {
                                Thread
                                                .sleep(2000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }

                        EcommercePOAntigo.aceitarcookies
                                        .click();
                } catch (Exception e) {
                }
                logger
                                .info("Aceitando cookies...");

                if (tipo == 1 || tipo == 3) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Bioparque Pantanal");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Bioparque pantanal Acesso - Testes automatizados");
                } else if (tipo == 2) {
                        logger
                                        .info("Iniciando pesquisa: Biopaque pantanal Acesso Prioritário e Preferencial");
                        EcommercePOAntigo.barraDePesquisa
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
                                .until(d -> EcommercePOAntigo.bilhete_a_venda_grupo1
                                                .isDisplayed());
                EcommercePOAntigo.bilhete_a_venda_grupo1
                                .click();
                logger
                                .info("Selecionando bilhete...");

                logger
                                .info("Selecionando data para o dia 1");

                wait
                                .until(d -> EcommercePOAntigo.ProximoMes
                                                .isDisplayed());
                EcommercePOAntigo.ProximoMes
                                .click();

                try {
                        Thread
                                        .sleep(3000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                EcommercePOAntigo.dia
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
                                .until(d -> EcommercePOAntigo.horario
                                                .isEnabled());
                EcommercePOAntigo.horario
                                .click();
                try {
                        Thread
                                        .sleep(1000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                EcommercePOAntigo.confirmarHorario4opcoes
                                .click();
                try {
                        Thread
                                        .sleep(2000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                wait
                                .until(d -> EcommercePOAntigo.proximo
                                                .isDisplayed());
                EcommercePOAntigo.proximo
                                .click();

                logger
                                .info("Adicionando categoria ao carrinho...");
                

                EcommercePOAntigo.adicionarCategoria
                                .click();
                if (tipo == 3) {
                        int i = 0;
                        while (i != 7) {
                                EcommercePOAntigo.adicionarCategoria
                                                .click();
                                i++;
                        }
                        EcommercePOAntigo.adicionarCategoria2
                                        .click();
                }

                if (tipo == 2) {
                        EcommercePOAntigo.adicionarCategoria3
                                        .click();
                }

                EcommercePOAntigo.adicionarCategoria2
                                .click();
                EcommercePOAntigo.selecionarPaisOrigem
                                .click();
                EcommercePOAntigo.confirmaPaisOrigem.click();

                boolean cep = false;
                try {
                        EcommercePOAntigo.CEP_Nas_categorias
                                        .isDisplayed();
                        cep = true;
                } catch (Exception e) {
                        cep = false;
                }
                if (cep) {
                        EcommercePOAntigo.CEP_Nas_categorias
                                        .sendKeys("85509432");
                }

                wait
                                .until(d -> EcommercePOAntigo.adicionarAoCarrinho
                                                .isEnabled());
                EcommercePOAntigo.adicionarAoCarrinho
                                .click();
                                logger
                                .info("Adicionando ao carrinho...");
                wait
                                .until(d -> EcommercePOAntigo.nomeUsuario
                                                .isDisplayed());
                /* nome usuario 1 */
                

                try {
                        Thread
                                        .sleep(1000);
                } catch (

                InterruptedException e) {
                        e
                                        .printStackTrace();
                }

                if (tipo == 2) {
                        /* primeiro usuario segunda categoria */
                        EcommercePOAntigo
                                        .dadosUsuarios(1, 1, geradores
                                                        .geradorCPF(),
                                                        geradores
                                                                        .geradorNome(),
                                                        "03/04/2020", 261, "85502060", driver);
                        EcommercePOAntigo
                                        .dadosUsuarios(2, 1, geradores
                                                        .geradorCPF(),
                                                        geradores
                                                                        .geradorNome(),
                                                        "03/04/2020", 510, "85502060", driver);
                        EcommercePOAntigo
                                        .dadosUsuarios(3, 1, geradores
                                                        .geradorCPF(),
                                                        geradores
                                                                        .geradorNome(),
                                                        "03/04/2020", 759, "85502060", driver);
                } else if (tipo == 3) {
                        int i = 1;
                        int id = 261;

                        while (i != 9) {
                                EcommercePOAntigo
                                                .dadosUsuarios(1, i, geradores
                                                                .geradorCPF(),
                                                                geradores
                                                                                .geradorNome(),
                                                                geradores.geradorDataNascimento_AntigoEcommerce(12,18, driver), id, "85502060", driver);
                                i++;
                                /*
                                 * o numero de id do brasil na hora de selecionar o pais começa em 261 e aumenta
                                 * de 249 em 249 para cada usuario
                                 */
                                id += 249;
                        }
                        EcommercePOAntigo
                                        .dadosUsuarios(2, 1, geradores
                                                        .geradorCPF(),
                                                        geradores
                                                                        .geradorNome(),
                                                        "03/04/2020", 2253, "85502060", driver);
                        EcommercePOAntigo
                                        .dadosUsuarios(2, 2, geradores
                                                        .geradorCPF(),
                                                        geradores
                                                                        .geradorNome(),
                                                        "23/09/2018", 2502, "85502060", driver);

                } else {
                        
                        EcommercePOAntigo
                                        .dadosUsuarios(1, 1, geradores
                                                        .geradorCPF(),
                                                        geradores
                                                                        .geradorNome(),
                                                                        geradores.geradorDataNascimento_AntigoEcommerce(18,99,driver), 261, "85502060", driver);
                        EcommercePOAntigo
                                        .dadosUsuarios(2, 1, geradores
                                                        .geradorCPF(),
                                                        geradores
                                                                        .geradorNome(),
                                                        geradores.geradorDataNascimento_AntigoEcommerce(3,12,driver), 510, "85502060", driver);
                }
                logger
                .info("Preeenchendo os dados dos visitantes...");
                EcommercePOAntigo.confirmardadosusuario
                                .click();

                boolean logado = false;
                try {
                        Thread
                                        .sleep(3000);
                        logado = EcommercePOAntigo.finalizarPedido
                                        .isDisplayed();
                } catch (Exception e) {

                }
                logger
                .info("Verificando se o usuario está logado...");
                if (logado) {

                } else {
                        logger
                                        .info("Finalizando pedido...");
                        wait
                                        .until(d -> EcommercePOAntigo.registrarEfinalizarPedido
                                                        .isDisplayed());
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
                                        .info("Fazendo Login...");
                }

                wait
                                .until(d -> EcommercePOAntigo.finalizarPedido
                                                .isDisplayed());
                EcommercePOAntigo.finalizarPedido
                                .click();
                logger
                                .info("Finalizando pedido...");

                wait
                                .until(d -> EcommercePOAntigo.confirmarCompra
                                                .isDisplayed());
                String mensagem = EcommercePOAntigo.confirmarCompra
                                .getText();
                assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.",
                                mensagem);
                logger
                                .info("Pedido finalizado com sucesso!");

        }

        public BioParquePantanal(EcommercePOAntigo e) {
                this.EcommercePOAntigo = e;
        }
}
