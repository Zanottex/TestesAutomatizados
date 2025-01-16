package automatizado.Builder.Antigo;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.EcommercePOAntigo;
import automatizado.Generators.geradores;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BioParqueDoRioBuilder {

        private static final Logger logger = Logger
                        .getLogger(BioParqueDoRioBuilder.class
                                        .getName());

        private EcommercePOAntigo EcommercePOAntigo;
        private String email_usuario = "gustavozanotto119@gmail.com";
        private String senha_usuario = "1";
        private String Nome_Cartao = geradores
                        .geradorNome();
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
                BaseBuilder base = new BaseBuilder(EcommercePOAntigo);
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

                if (tipo == 1) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Bioparque do Rio");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("ingresso Biopaque do Rio - Teste automatizado");
                } else if (tipo == 2) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Bioparque do Rio Anual");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Passaporte anual Bioparque do Rio - Testes Automatizados");
                } else if (tipo == 3) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Bioparque do Rio + AquaRio");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Combo BioParque do Rio + AquaRio - Testes Automatizados");
                } else if (tipo == 4) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Bioparque do Rio + Cristo Redentor");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Combo BioParque do Rio + Paineiras Corcovado - Testes Automatizados");
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

                int dias = 0;
                if (tipo == 3 || tipo == 4) {
                        dias = 2;
                } else {
                        dias = 1;
                }
                int i = 0;
                logger
                                .info("Número de dias do ingresso: " + dias);

                while (i != dias) {
                        logger
                                        .info("Selecionando data para o dia " + (i + 1));
                        if (i == 0) {
                                wait
                                                .until(d -> EcommercePOAntigo.ProximoMes
                                                                .isDisplayed());
                                EcommercePOAntigo.ProximoMes
                                                .click();

                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }

                                EcommercePOAntigo.dia
                                                .click();

                        } else if (i == 1) {
                                wait
                                                .until(d -> EcommercePOAntigo.ProximoMes2Receitas
                                                                .isDisplayed());
                                EcommercePOAntigo.ProximoMes2Receitas
                                                .click();
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                EcommercePOAntigo.dia2Receitas
                                                .click();

                                if (tipo == 4) {
                                        wait
                                                        .until(d -> EcommercePOAntigo.localEmbarque2Receitas
                                                                        .isDisplayed());
                                        EcommercePOAntigo.localEmbarque2Receitas
                                                        .click();
                                        EcommercePOAntigo.localEmbarqueConfirmar
                                                        .click();
                                }
                        }

                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }

                        logger
                                        .info("Selecionando Horario...");
                        if (i == 0) {
                                if (tipo != 2) {
                                        wait
                                                        .until(d -> EcommercePOAntigo.horario
                                                                        .isDisplayed());
                                        EcommercePOAntigo.horario
                                                        .click();
                                        try {
                                                Thread
                                                                .sleep(2000);
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
                                }
                        } else if (i == 1) {
                                wait
                                                .until(d -> EcommercePOAntigo.horario2Receitas
                                                                .isDisplayed());
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                EcommercePOAntigo.horario2Receitas
                                                .click();
                                EcommercePOAntigo.confirmarHorario4opcoes
                                                .click();
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                EcommercePOAntigo.proximo2Receitas
                                                .click();
                        }
                        i++;

                }
                logger
                                .info("Adicionando categoria ao carrinho...");
                if (tipo == 3 || tipo == 4) {
                        wait
                                        .until(d -> EcommercePOAntigo.adicionarCategoria_2Rec
                                                        .isDisplayed());
                        EcommercePOAntigo.adicionarCategoria_2Rec
                                        .click();
                } else {
                        wait
                                        .until(d -> EcommercePOAntigo.adicionarCategoria
                                                        .isDisplayed());
                        EcommercePOAntigo.adicionarCategoria
                                        .click();
                }

                logger
                                .info("Selecionando país de origem...");

                if (tipo == 4 || tipo == 3) {
                        EcommercePOAntigo.selecionarPaisOrigem_2Rec
                                        .click();
                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        EcommercePOAntigo
                                        .Pais(24, driver);
                        try {
                                EcommercePOAntigo.estado_2Rec
                                                .click();
                                EcommercePOAntigo.acre
                                                .click();
                        } catch (Exception e) {

                        }

                        EcommercePOAntigo.adicionarCategoria2_2Rec
                                        .click();
                        EcommercePOAntigo.adicionarCategoria3_2Rec
                                        .click();
                        EcommercePOAntigo.adicionarAoCarrinho_2Rec
                                        .click();

                } else {
                        EcommercePOAntigo.adicionarCategoria2
                                        .click();

                        EcommercePOAntigo.selecionarPaisOrigem
                                        .click();
                        EcommercePOAntigo
                                        .Pais(24, driver);

                        try {
                                EcommercePOAntigo.CEP_Nas_categorias
                                                .sendKeys("85509432");

                        } catch (Exception e) {

                        }

                        wait
                                        .until(d -> EcommercePOAntigo.adicionarAoCarrinho
                                                        .isEnabled());
                        EcommercePOAntigo.adicionarAoCarrinho
                                        .click();

                }

                if (tipo == 2) {
                        wait
                                        .until(d -> EcommercePOAntigo.nomeUsuario
                                                        .isDisplayed());
                        EcommercePOAntigo.nomeUsuario
                                        .sendKeys(Nome_Cartao);
                        EcommercePOAntigo.tipodocumento
                                        .click();
                        wait
                                        .until(d -> EcommercePOAntigo.outros
                                                        .isDisplayed());
                        EcommercePOAntigo.outros
                                        .click();
                        EcommercePOAntigo.documento
                                        .sendKeys(cpf);

                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }

                        EcommercePOAntigo.nomeUsuario2
                                        .sendKeys("Cleitin do grau");
                        EcommercePOAntigo.tipodocumento2
                                        .click();
                        wait
                                        .until(d -> EcommercePOAntigo.outros
                                                        .isDisplayed());
                        EcommercePOAntigo.outros
                                        .click();
                        EcommercePOAntigo.documento2
                                        .sendKeys("123456789");

                        EcommercePOAntigo.confirmardadosusuario
                                        .click();
                }
                logger
                                        .info("Verificar se o usuario ja estálogado...");
                boolean logado = false;
                try {
                        Thread
                                        .sleep(3000);
                        logado = EcommercePOAntigo.finalizarPedido
                                        .isDisplayed();
                } catch (Exception e) {

                }
                Double valor1 = 0.0;
                StringTokenizer resulBilhete1 = null;
                if (logado) {

                        resulBilhete1 = new StringTokenizer(EcommercePOAntigo
                                        .valorTotalDoBilhete(3, driver));
                } else {
                        resulBilhete1 = new StringTokenizer(EcommercePOAntigo.valorSomado
                                        .getText());

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
                                .info("Verificando o valor do bilhete..");
                if (valor1 == 15.00) {
                        logger
                                        .info("Finalizando pedido...");

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
                        // wait
                        // .until(d -> EcommercePOAntigo.EscreverConfirmarSenha
                        // .isDisplayed());
                        // EcommercePOAntigo.EscreverConfirmarSenha
                        // .sendKeys("1");
                        // EcommercePOAntigo.botaoConfirmarSenha
                        // .click();

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
                                        .info("Pedido finalizado com sucesso!");
                } else {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js
                                        .executeScript("alert('ERRO: VALOR DO BILHETE INVÁLIDO');");
                        logger
                                        .severe("ERRO: VALOR DO BILHETE INVÁLIDO.");
                }

        }

        public BioParqueDoRioBuilder(EcommercePOAntigo e) {
                this.EcommercePOAntigo = e;
        }
}
