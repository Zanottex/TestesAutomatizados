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

public class Cataratasbuilder {

        private static final Logger logger = Logger
                        .getLogger(Cataratasbuilder.class
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
                        EcommercePOAntigo.aceitarcookies
                                        .click();
                        logger
                                        .info("Aceitando cookies...");
                } catch (Exception e) {

                }
                if (tipo == 1) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Brasileiro/Mercosul");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Ingresso Brasileiro/Mercosul");
                } else if (tipo == 2) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Estrangeiro");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Ingresso Estrangeiro");
                } else if (tipo == 3) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Experiências");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Ingresso Experiências");
                } else if (tipo == 4) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Bike poço preto");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Ingresso Bike poço preto");
                } else if (tipo == 5) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso 2 dias");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Ingresso 2 dias");
                } else if (tipo == 6) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso 3 dias");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Ingresso 3 dias");
                } else if (tipo == 7) {
                        logger
                                        .info("Iniciando pesquisa: Guarda Volumes");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Guarda Volumes");
                } else if (tipo == 8) {
                        logger
                                        .info("Iniciando pesquisa: Bilhete VIP");
                        EcommercePOAntigo.barraDePesquisa
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
                EcommercePOAntigo.bilhete_a_venda_grupo1
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
                                                .until(d -> EcommercePOAntigo.ProximoMes
                                                                .isDisplayed());
                                EcommercePOAntigo.ProximoMes
                                                .click();

                                try {
                                        Thread
                                                        .sleep(2000);
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
                        } else if (i == 2) {
                                wait
                                                .until(d -> EcommercePOAntigo.ProximoMes3Receitas
                                                                .isDisplayed());
                                EcommercePOAntigo.ProximoMes3Receitas
                                                .click();

                                try {
                                        Thread
                                                        .sleep(1500);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                EcommercePOAntigo.dia3Receitas
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
                                                .until(d -> EcommercePOAntigo.localEmbarque
                                                                .isDisplayed());
                                EcommercePOAntigo.localEmbarque
                                                .click();
                                EcommercePOAntigo.localEmbarqueConfirmar
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
                                        try {
                                                Thread
                                                                .sleep(2500);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        if (tipo == 5 || tipo == 6 || tipo == 3) {
                                                EcommercePOAntigo
                                                                .Horario(1, 1, driver);
                                        } else {
                                                EcommercePOAntigo
                                                                .Horario(1, 2, driver);
                                        }
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
                                                                        .isEnabled());
                                        EcommercePOAntigo.proximo
                                                        .click();
                                } else if (i == 1) {

                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }

                                        EcommercePOAntigo
                                                        .Horario(2, 1, driver);

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
                                                        .until(d -> EcommercePOAntigo.proximo2Receitas
                                                                        .isDisplayed());
                                        EcommercePOAntigo.proximo2Receitas
                                                        .click();
                                } else if (i == 2) {
                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        EcommercePOAntigo
                                                        .Horario(3, 1, driver);
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
                                                                .sleep(1500);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        wait
                                                        .until(d -> EcommercePOAntigo.proximo3Receitas
                                                                        .isDisplayed());
                                        EcommercePOAntigo.proximo3Receitas
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
                                        .until(d -> EcommercePOAntigo.adicionarCategoria_2Rec
                                                        .isDisplayed());
                        EcommercePOAntigo.adicionarCategoria_2Rec
                                        .click();
                } else if (tipo == 6) {
                        wait
                                        .until(d -> EcommercePOAntigo.adicionarCategoria_3Rec
                                                        .isDisplayed());
                        EcommercePOAntigo.adicionarCategoria_3Rec
                                        .click();
                } else {
                        wait
                                        .until(d -> EcommercePOAntigo.adicionarCategoria
                                                        .isDisplayed());
                        EcommercePOAntigo.adicionarCategoria
                                        .click();
                }

                if (tipo == 1 || tipo == 2 || tipo == 5 || tipo == 6 || tipo == 3) {
                        logger
                                        .info("Selecionando país de origem...");

                        if (tipo == 1) {
                                wait
                                                .until(d -> EcommercePOAntigo.selecionarPaisOrigem
                                                                .isDisplayed());
                                EcommercePOAntigo.selecionarPaisOrigem
                                                .click();

                                EcommercePOAntigo
                                                .Pais(28, driver);

                        } else if (tipo == 2) {
                                EcommercePOAntigo.selecionarPaisOrigem
                                                .click();
                                try {
                                        EcommercePOAntigo
                                                        .Pais(24, driver);
                                        EcommercePOAntigo
                                                        .Pais(25, driver);
                                } catch (Exception e) {

                                }
                                try {
                                        EcommercePOAntigo.estado
                                                        .click();
                                        EcommercePOAntigo.acre
                                                        .click();
                                } catch (Exception e) {
                                }

                        } else if (tipo == 5) {
                                EcommercePOAntigo.selecionarPaisOrigem_2Rec
                                                .click();
                                try {
                                        EcommercePOAntigo
                                                        .Pais(24, driver);
                                        EcommercePOAntigo
                                                        .Pais(25, driver);
                                } catch (Exception e) {

                                }
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                try {
                                        EcommercePOAntigo
                                                        .estado(3, driver);
                                        EcommercePOAntigo.acre
                                                        .click();
                                } catch (Exception e) {

                                }

                        } else if (tipo == 6) {
                                EcommercePOAntigo.selecionarPaisOrigem_3Rec
                                                .click();

                                try {
                                        EcommercePOAntigo
                                                        .Pais(24, driver);
                                        EcommercePOAntigo
                                                        .Pais(25, driver);
                                } catch (Exception e) {

                                }
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                try {
                                        EcommercePOAntigo
                                                        .estado(4, driver);
                                        ;
                                        EcommercePOAntigo.acre
                                                        .click();
                                } catch (Exception e) {

                                }

                        } else if (tipo == 3) {
                                EcommercePOAntigo.selecionarPaisOrigem
                                                .click();
                                try {
                                        EcommercePOAntigo
                                                        .Pais(24, driver);
                                        EcommercePOAntigo
                                                        .Pais(25, driver);
                                } catch (Exception e) {

                                }

                                try {
                                        EcommercePOAntigo.estado
                                                        .click();
                                        EcommercePOAntigo.acre
                                                        .click();
                                } catch (Exception e) {

                                }

                        }
                }
                String erro = null;
                if (tipo != 3 && tipo != 4 && tipo != 7 && tipo != 8) { // SE FOR 1 ou 2 ELE ENTRA
                        if (tipo == 5) {
                                wait
                                                .until(d -> EcommercePOAntigo.adicionarAoCarrinho_2Rec
                                                                .isEnabled());
                                EcommercePOAntigo.adicionarAoCarrinho_2Rec
                                                .click();
                        } else if (tipo == 6) {
                                wait
                                                .until(d -> EcommercePOAntigo.adicionarAoCarrinho_3Rec
                                                                .isEnabled());
                                EcommercePOAntigo.adicionarAoCarrinho_3Rec
                                                .click();
                        } else {
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                EcommercePOAntigo.adicionarAoCarrinho
                                                .click();
                        }

                        wait
                                        .until(d -> EcommercePOAntigo.pegarMensagemErro
                                                        .isDisplayed());

                        try {
                                erro = EcommercePOAntigo.pegarMensagemErro
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
                                        EcommercePOAntigo.adicionarCategoria2_2Rec
                                                        .click();
                                } else if (tipo == 6) {
                                        EcommercePOAntigo.adicionarCategoria2_3Rec
                                                        .click();
                                } else if (tipo == 8) {

                                } else {
                                        wait
                                                        .until(d -> EcommercePOAntigo.adicionarCategoria2
                                                                        .isDisplayed());
                                        EcommercePOAntigo.adicionarCategoria2
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

                                        EcommercePOAntigo.adicionarAoCarrinho
                                                        .click();
                                        try {
                                                Thread
                                                                .sleep(2000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        try {
                                                erro2 = EcommercePOAntigo.pegarMensagemErro
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
                                        EcommercePOAntigo.selecionarPaisOrigem
                                                        .click();

                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        if (tipo == 1) {
                                                try {
                                                        EcommercePOAntigo
                                                                        .Pais(24, driver);
                                                        EcommercePOAntigo
                                                                        .Pais(25, driver);
                                                } catch (Exception e) {

                                                }

                                                try {
                                                        EcommercePOAntigo.estado
                                                                        .click();
                                                        EcommercePOAntigo.acre
                                                                        .click();
                                                } catch (Exception e) {

                                                }

                                        } else if (tipo == 8) {
                                                EcommercePOAntigo
                                                                .Pais(47, driver);
                                        } else {
                                                EcommercePOAntigo
                                                                .Pais(28, driver);
                                                ;
                                        }
                                }

                                if (tipo == 5) {
                                        EcommercePOAntigo.adicionarAoCarrinho_2Rec
                                                        .click();
                                } else if (tipo == 6) {
                                        EcommercePOAntigo.adicionarAoCarrinho_3Rec
                                                        .click();
                                } else {
                                        EcommercePOAntigo.adicionarAoCarrinho
                                                        .click();
                                }

                                if (tipo == 5 || tipo == 6 || tipo == 8) {
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
                                        if (tipo != 8) {
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

                                        }
                                        EcommercePOAntigo.confirmardadosusuario
                                                        .click();
                                }
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
                                                .info("Verificando o valor dos bilhetes...");

                                String Captcha = null;
                                if (valor1 == 10.00) {
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

                                                try {
                                                        Thread
                                                                        .sleep(4000);
                                                        Captcha = EcommercePOAntigo.pegarMensagemErro
                                                                        .getText();
                                                } catch (Exception e) {
                                                }

                                        }

                                        if (Captcha == null) {

                                                wait
                                                                .until(d -> EcommercePOAntigo.finalizarPedido
                                                                                .isDisplayed());
                                                EcommercePOAntigo.finalizarPedido
                                                                .click();
                                                logger
                                                                .info("Finalizando pedido...");
                                                if (tipo == 4) {
                                                        wait
                                                                        .until(d -> EcommercePOAntigo.aceitar_termos
                                                                                        .isDisplayed());
                                                        EcommercePOAntigo.aceitar_termos
                                                                        .click();
                                                        EcommercePOAntigo.continuar_termos
                                                                        .click();
                                                }

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
                                                                .executeScript("alert('ERRO: Bloqueio de Captcha');");
                                                logger
                                                                .severe("ERRO: Captcha bloqueou o programa.");
                                        }
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

        public Cataratasbuilder(EcommercePOAntigo e) {
                this.EcommercePOAntigo = e;
        }
}
