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

public class Cataratasbuilder {

        private static final Logger logger = Logger
                        .getLogger(Cataratasbuilder.class
                                        .getName());

        private EcommercePO ECommercePO;
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
                BaseBuilder base = new BaseBuilder(ECommercePO);
                logger
                                .info("Aguardando a barra de pesquisa ser exibida...");

                wait
                                .until(d -> ECommercePO.barraDePesquisa
                                                .isDisplayed());
                try {
                        ECommercePO.aceitarcookies
                                        .click();
                        logger
                                        .info("Aceitando cookies...");
                } catch (Exception e) {
                        // TODO: handle exception
                }

                if (tipo == 1) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Brasileiro/Mercosul");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Ingresso Brasileiro/Mercosul");
                } else if (tipo == 2) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Estrangeiro");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Ingresso Estrangeiro");
                } else if (tipo == 3) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Experiências");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Ingresso Experiências");
                } else if (tipo == 4) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Bike poço preto");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Ingresso Bike poço preto");
                } else if (tipo == 5) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso 2 dias");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Ingresso 2 dias");
                } else if (tipo == 6) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso 3 dias");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Ingresso 3 dias");
                } else if (tipo == 7) {
                        logger
                                        .info("Iniciando pesquisa: Guarda Volumes");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Guarda Volumes");
                } else if (tipo == 8) {
                        logger
                                        .info("Iniciando pesquisa: Bilhete VIP");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Bilhete VIP");
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
                ECommercePO.bilhete_a_venda_grupo1
                                .click();
                logger
                                .info("Selecionando bilhete...");

                int dias = 0;
                if (tipo == 5) {
                        dias = 2;
                } else if (tipo == 6) {
                        dias = 3;
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
                                                .until(d -> ECommercePO.ProximoMes
                                                                .isDisplayed());
                                ECommercePO.ProximoMes
                                                .click();

                                try {
                                        Thread
                                                        .sleep(1500);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }

                                ECommercePO.dia
                                                .click();

                        } else if (i == 1) {
                                wait
                                                .until(d -> ECommercePO.ProximoMes2Receitas
                                                                .isDisplayed());
                                ECommercePO.ProximoMes2Receitas
                                                .click();
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                ECommercePO.dia2Receitas
                                                .click();
                        } else if (i == 2) {
                                wait
                                                .until(d -> ECommercePO.ProximoMes3Receitas
                                                                .isDisplayed());
                                ECommercePO.ProximoMes3Receitas
                                                .click();

                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                ECommercePO.dia3Receitas
                                                .click();
                        }
                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }

                        if (tipo == 1 || tipo == 2) {
                                logger
                                                .info("Selecionando local de embarque...");
                                wait
                                                .until(d -> ECommercePO.localEmbarque
                                                                .isDisplayed());
                                ECommercePO.localEmbarque
                                                .click();
                                ECommercePO.localEmbarqueConfirmar
                                                .click();
                        }

                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        if (tipo != 7 && tipo != 8) {
                                logger
                                                .info("Selecionando Horario...");
                                if (i == 0) {
                                        wait
                                                        .until(d -> ECommercePO.horario
                                                                        .isDisplayed());
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
                                                                        .isEnabled());
                                        ECommercePO.proximo
                                                        .click();
                                } else if (i == 1) {
                                        wait
                                                        .until(d -> ECommercePO.horario2Receitas
                                                                        .isDisplayed());
                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        ECommercePO.horario2Receitas
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
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        ECommercePO.proximo2Receitas
                                                        .click();
                                } else if (i == 2) {
                                        wait
                                                        .until(d -> ECommercePO.horario3Receitas
                                                                        .isDisplayed());
                                        ECommercePO.horario3Receitas
                                                        .click();
                                        ECommercePO.confirmarHorario4opcoes
                                                        .click();
                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        ECommercePO.proximo3Receitas
                                                        .click();
                                }

                                i++;
                        } else {
                                i++;
                        }
                }
                logger
                                .info("Adicionando categoria ao carrinho...");
                if (tipo == 5) {
                        wait
                                        .until(d -> ECommercePO.adicionarCategoria_2Rec
                                                        .isDisplayed());
                        ECommercePO.adicionarCategoria_2Rec
                                        .click();
                } else if (tipo == 6) {
                        wait
                                        .until(d -> ECommercePO.adicionarCategoria_3Rec
                                                        .isDisplayed());
                        ECommercePO.adicionarCategoria_3Rec
                                        .click();
                } else {
                        wait
                                        .until(d -> ECommercePO.adicionarCategoria
                                                        .isDisplayed());
                        ECommercePO.adicionarCategoria
                                        .click();
                }

                if (tipo == 1 || tipo == 2 || tipo == 5 || tipo == 6 || tipo == 3) {
                        logger
                                        .info("Selecionando país de origem...");

                        if (tipo == 1) {
                                wait
                                                .until(d -> ECommercePO.selecionarPaisOrigem
                                                                .isDisplayed());
                                ECommercePO.selecionarPaisOrigem
                                                .click();
                                ECommercePO
                                                .Pais(27, driver);
                        } else if (tipo == 2) {
                                ECommercePO.selecionarPaisOrigem
                                                .click();
                                ECommercePO
                                                .Pais(24, driver);
                                ECommercePO.estado
                                                .click();
                                ECommercePO.acre
                                                .click();
                        } else if (tipo == 5) {
                                ECommercePO.selecionarPaisOrigem_2Rec
                                                .click();
                                ECommercePO
                                                .Pais(24, driver);
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                ECommercePO
                                                .estado(3, driver);
                                ECommercePO.acre
                                                .click();
                        } else if (tipo == 6) {
                                ECommercePO.selecionarPaisOrigem_3Rec
                                                .click();

                                ECommercePO
                                                .Pais(24, driver);
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                try {
                                        ECommercePO
                                                        .estado(4, driver);
                                        ;
                                        ECommercePO.acre
                                                        .click();
                                } catch (Exception e) {
                                        // TODO: handle exception
                                }

                        } else if (tipo == 3) {
                                ECommercePO.selecionarPaisOrigem
                                                .click();
                                ECommercePO
                                                .Pais(24, driver);
                                try {
                                        ECommercePO.estado
                                                        .click();
                                        ECommercePO.acre
                                                        .click();
                                } catch (Exception e) {
                                        // TODO: handle exception
                                }

                        }
                }
                String erro = null;
                if (tipo != 3 && tipo != 4 && tipo != 7 && tipo != 8) { // SE FOR 1 ou 2 ELE ENTRA
                        if (tipo == 5) {
                                ECommercePO.adicionarAoCarrinho_2Rec
                                                .click();
                                erro = "notnull";
                        } else if (tipo == 6) {
                                ECommercePO.adicionarAoCarrinho_3Rec
                                                .click();
                                erro = "notnull";
                        } else {
                                ECommercePO.adicionarAoCarrinho
                                                .click();
                        }

                        wait
                                        .until(d -> ECommercePO.pegarMensagemErro
                                                        .isDisplayed());

                        try {
                                erro = ECommercePO.pegarMensagemErro
                                                .getText();
                        } catch (Exception e) {
                        }

                        logger
                                        .info("Trocando Selecionando um pais válido");
                } else {
                        erro = "notnull";
                }
                String erro2 = null;
                if (erro != null) {

                        if (tipo != 4 && tipo != 7 && tipo != 8) { // SE FOR DIFERENTE DE 4 ENTRAR

                                if (tipo == 5) {
                                        ECommercePO.adicionarCategoria2_2Rec
                                                        .click();
                                } else if (tipo == 6) {
                                        ECommercePO.adicionarCategoria2_3Rec
                                                        .click();
                                } else if (tipo == 8) {

                                } else {
                                        ECommercePO.adicionarCategoria2
                                                        .click();
                                }
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }

                                if (tipo == 1 || tipo == 2) {

                                        ECommercePO.adicionarAoCarrinho
                                                        .click();
                                        try {
                                                Thread
                                                                .sleep(2000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        try {
                                                erro2 = ECommercePO.pegarMensagemErro
                                                                .getText();
                                        } catch (Exception e) {

                                        }

                                } else {
                                        erro2 = "notnull";
                                }
                        } else {
                                erro2 = "notnull";
                        }
                        if (erro2 != null) {
                                try {
                                        Thread
                                                        .sleep(5000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                if (tipo == 1 || tipo == 2 || tipo == 8) {
                                        ECommercePO.selecionarPaisOrigem
                                                        .click();

                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        if (tipo == 1) {

                                                ECommercePO
                                                                .Pais(24, driver);
                                                try {
                                                        ECommercePO.estado
                                                                        .click();
                                                        ECommercePO.acre
                                                                        .click();
                                                } catch (Exception e) {

                                                }

                                        } else if (tipo == 8) {
                                                ECommercePO
                                                                .Pais(47, driver);
                                        } else {
                                                ECommercePO
                                                                .Pais(27, driver);
                                                ;
                                        }
                                }

                                if (tipo == 5) {
                                        ECommercePO.adicionarAoCarrinho_2Rec
                                                        .click();
                                } else if (tipo == 6) {
                                        ECommercePO.adicionarAoCarrinho_3Rec
                                                        .click();
                                } else {
                                        ECommercePO.adicionarAoCarrinho
                                                        .click();
                                }

                                if (tipo == 5 || tipo == 6 || tipo == 8) {
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

                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        if (tipo != 8) {
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

                                        }
                                        ECommercePO.confirmardadosusuario
                                                        .click();
                                }
                                Double valor1 = 0.0;
                                boolean logado = false;
                                try {
                                        Thread
                                                        .sleep(3000);
                                        logado = ECommercePO.finalizarPedido
                                                        .isDisplayed();
                                } catch (Exception e) {

                                }
                                StringTokenizer resulBilhete1 = null;
                                if (logado) {
                                        resulBilhete1 = new StringTokenizer(ECommercePO
                                                        .valorTotalDoBilhete(3, driver));
                                } else {
                                        resulBilhete1 = new StringTokenizer(ECommercePO
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
                                                .info("Verificando o valor dos bilhetes...");

                                if (valor1 == 10.00) {
                                        if (logado) {

                                        } else {
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
                                        }

                                        wait
                                                        .until(d -> ECommercePO.finalizarPedido
                                                                        .isDisplayed());
                                        ECommercePO.finalizarPedido
                                                        .click();
                                        logger
                                                        .info("Finalizando pedido...");

                                        if (tipo == 4) {
                                                wait
                                                                .until(d -> ECommercePO.aceitar_termos
                                                                                .isDisplayed());
                                                ECommercePO.aceitar_termos
                                                                .click();
                                                ECommercePO.continuar_termos
                                                                .click();
                                        }
                                        // wait
                                        // .until(d -> ECommercePO.EscreverConfirmarSenha
                                        // .isDisplayed());
                                        // ECommercePO.EscreverConfirmarSenha
                                        // .sendKeys("1");
                                        // ECommercePO.botaoConfirmarSenha
                                        // .click();

                                        base
                                                        .realizarpagamento(driver);

                                        wait
                                                        .until(d -> ECommercePO.confirmarCompra
                                                                        .isDisplayed());
                                        String mensagem = ECommercePO.confirmarCompra
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
                        } else {
                                JavascriptExecutor js = (JavascriptExecutor) driver;
                                js
                                                .executeScript("alert('ERRO: PAIS INVALIDO');");
                                logger
                                                .severe("ERRO: PAÍS INVALIDO.");
                        }
                } else

                {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js
                                        .executeScript("alert('ERRO: CATEGORIA PAGANTE NÃO SELECIONADA');");
                        logger
                                        .severe("ERRO: CATEGORIA PAGANTE NÃO SELECIONADA.");
                }

        }

        public Cataratasbuilder(EcommercePO e) {
                this.ECommercePO = e;
        }
}
