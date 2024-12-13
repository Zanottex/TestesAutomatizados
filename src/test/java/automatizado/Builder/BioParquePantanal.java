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
    private String cpf = geradores
            .geradorCPF();

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

        if (tipo == 1) {
            logger
                    .info("Iniciando pesquisa: Ingresso Bioparque Pantanal");
            ECommercePO.barraDePesquisa
                    .sendKeys("Bioparque pantanal Acesso - Testes automatizados");
        } else if (tipo == 2) {
            logger
                    .info("Iniciando pesquisa: Biopaque pantanal Acesso Prioritário e Preferencial");
            ECommercePO.barraDePesquisa
                    .sendKeys("Biopaque pantanal Acesso Prioritário e Preferencial - Teste automatizado");
        } else if (tipo == 3) {
            logger
                    .info("Iniciando pesquisa: Biopaque pantanal Acesso - Grupos");
            ECommercePO.barraDePesquisa
                    .sendKeys("Biopaque pantanal Acesso - Grupos - Testes Automatizados");
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
        ECommercePO.adicionarCategoria2
                .click();
        if (tipo == 2) {
            ECommercePO.adicionarCategoria3
                    .click();
        }
        ECommercePO.selecionarPaisOrigem
                .click();
        ECommercePO.confirmaPaisOrigem
                .click();
        ECommercePO.CEP_Nas_categorias
                .sendKeys("85509432");

        wait
                .until(d -> ECommercePO.adicionarAoCarrinho
                        .isEnabled());
        ECommercePO.adicionarAoCarrinho
                .click();

        wait
                .until(d -> ECommercePO.nomeUsuario
                        .isDisplayed());
        ECommercePO.nomeUsuario
                .sendKeys(Nome_Cartao);
        ECommercePO.tipodocumento
                .click();
        wait
                .until(d -> ECommercePO.outros
                        .isDisplayed());
        ECommercePO.outros
                .click();
        ECommercePO.documento
                .sendKeys(cpf);
        ECommercePO.data_de_nascimento_ColetaDeDados_PrimeiroUsuario
                .sendKeys("01/01/2000");
        ECommercePO.selecionarPaisOrigem_Na_ColetaDeDados_PrimeiroUsuario
                .click();
        ECommercePO.confirmarPaisOrigem_Na_ColetaDeDados
                .click();
        ECommercePO.CEP_Na_ColetaDeDados_PrimeiroUsuario
                .sendKeys("85509432");

        try {
            Thread
                    .sleep(1000);
        } catch (

        InterruptedException e) {
            e
                    .printStackTrace();
        }

        ECommercePO.nomeUsuario2
                .sendKeys("Cleitin do grau");
        ECommercePO.tipodocumento2
                .click();
        wait
                .until(d -> ECommercePO.outros
                        .isDisplayed());
        ECommercePO.outros
                .click();
        ECommercePO.documento2
                .sendKeys("123456789");
        ECommercePO.data_de_nascimento_ColetaDeDados_SegundoUsuario
                .sendKeys("01/01/2020");
        ECommercePO.selecionarPaisOrigem_Na_ColetaDeDados_SegundoUsuario
                .click();
        try {
            Thread
                    .sleep(1000);
        } catch (InterruptedException e) {
            e
                    .printStackTrace();
        }
        ECommercePO.confirmarPaisOrigem_Na_ColetaDeDados
                .click();
        ECommercePO.CEP_Na_ColetaDeDados_SegundoUsuario
                .sendKeys("85509432");

        if (tipo == 2) {
            ECommercePO.nomeUsuario3
                    .sendKeys("Flavin do pneu");
            ECommercePO.tipodocumento3
                    .click();
            wait
                    .until(d -> ECommercePO.outros
                            .isDisplayed());
            ECommercePO.outros
                    .click();
            ECommercePO.documento3
                    .sendKeys("987654321");
            ECommercePO.data_de_nascimento_ColetaDeDados_TerceiroUsuario
                    .sendKeys("01/01/1990");
            ECommercePO.selecionarPaisOrigem_Na_ColetaDeDados_TerceiroUsuario
                    .click();
            try {
                Thread
                        .sleep(1000);
            } catch (InterruptedException e) {
                e
                        .printStackTrace();
            }
            ECommercePO.confirmarPaisOrigem_Na_ColetaDeDados
                    .click();
            ECommercePO.CEP_Na_ColetaDeDados_TerceiroUsuario
                    .sendKeys("85509432");
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
        assertEquals(
                "Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.",
                mensagem);
        logger
                .info("Pedido finalizado com sucesso!");

    }

    public BioParquePantanal(EcommercePO e) {
        this.ECommercePO = e;
    }
}
