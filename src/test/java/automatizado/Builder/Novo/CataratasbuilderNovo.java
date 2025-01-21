package automatizado.Builder.Novo;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.EcommercePONovo;
import automatizado.Generators.geradores;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CataratasbuilderNovo {

        private static final Logger logger = Logger
                        .getLogger(CataratasbuilderNovo.class
                                        .getName());

        private EcommercePONovo EcommercePONovo;
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
                BaseBuilderNovo base = new BaseBuilderNovo(EcommercePONovo);
                logger
                                .info("Aguardando a barra de pesquisa ser exibida...");

                wait
                                .until(d -> EcommercePONovo.barraDePesquisa
                                                .isDisplayed());

                try {
                        EcommercePONovo.aceitarcookies
                                        .click();
                        logger
                                        .info("Aceitando cookies...");
                } catch (Exception e) {

                }
                if (tipo == 1) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Brasileiro/Mercosul");
                        EcommercePONovo.barraDePesquisa
                                        .sendKeys("Ingresso Brasileiro/Mercosul");
                } else if (tipo == 2) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Estrangeiro");
                        EcommercePONovo.barraDePesquisa
                                        .sendKeys("Ingresso Estrangeiro");
                } else if (tipo == 3) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Experiências");
                        EcommercePONovo.barraDePesquisa
                                        .sendKeys("Ingresso Experiências");
                } else if (tipo == 4) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Bike poço preto");
                        EcommercePONovo.barraDePesquisa
                                        .sendKeys("Ingresso Bike poço preto");
                } else if (tipo == 5) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso 2 dias");
                        EcommercePONovo.barraDePesquisa
                                        .sendKeys("Ingresso 2 dias");
                } else if (tipo == 6) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso 3 dias");
                        EcommercePONovo.barraDePesquisa
                                        .sendKeys("Ingresso 3 dias");
                } else if (tipo == 7) {
                        logger
                                        .info("Iniciando pesquisa: Guarda Volumes");
                        EcommercePONovo.barraDePesquisa
                                        .sendKeys("Guarda Volumes");
                } else if (tipo == 8) {
                        logger
                                        .info("Iniciando pesquisa: Bilhete VIP");
                        EcommercePONovo.barraDePesquisa
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
                EcommercePONovo.bilhete_a_venda_grupo1
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
                                try {
                                        Thread
                                                        .sleep(3000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }

                                EcommercePONovo.ProximoMes
                                                .click();

                                try {
                                        Thread
                                                        .sleep(1500);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }

                                EcommercePONovo
                                                .DiaDoMes(1, driver);
                                ;

                        } else if (i == 1) {
                                try {
                                        Thread
                                                        .sleep(2000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }

                                EcommercePONovo
                                                .ProximoMes(2, driver);
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                EcommercePONovo
                                                .DiaDoMes(2, driver);
                                ;
                        } else if (i == 2) {
                                try {
                                        Thread
                                                        .sleep(2000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                EcommercePONovo
                                                .ProximoMes(3, driver);

                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                EcommercePONovo
                                                .DiaDoMes(3, driver);
                                ;
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
                                                .until(d -> EcommercePONovo.localEmbarque
                                                                .isDisplayed());
                                EcommercePONovo.localEmbarque
                                                .click();
                                // EcommercePONovo.localEmbarqueConfirmar
                                // .click();
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
                                        // wait
                                        // .until(d -> EcommercePONovo.horario
                                        // .isDisplayed());
                                        // EcommercePONovo.horario
                                        // .click();
                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        if (tipo == 6) {
                                                EcommercePONovo
                                                                .ConfirmarHorarios(1, 2, driver);
                                        } else if (tipo == 3) {
                                                EcommercePONovo
                                                                .ConfirmarHorarios(1, 2, driver);
                                        } else {
                                                EcommercePONovo.confirmarHorario
                                                                .click();
                                        }

                                } else if (i == 1) {

                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        EcommercePONovo
                                                        .ConfirmarHorarios(2, 2, driver);
                                        ;
                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }

                                } else if (i == 2) {
                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        EcommercePONovo
                                                        .ConfirmarHorarios(3, 2, driver);

                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }

                                }

                                i++;
                        } else {
                                i++;
                        }
                }

                if (tipo == 1 || tipo == 2 || tipo == 5 || tipo == 6 || tipo == 3) {
                        logger
                                        .info("Selecionando país de origem...");

                        wait
                                        .until(d -> EcommercePONovo.selecionarPaisOrigem
                                                        .isDisplayed());
                        EcommercePONovo.selecionarPaisOrigem
                                        .click();
                        EcommercePONovo.confirmaPaisOrigem
                                        .click();
                        if (tipo == 1) {
                                EcommercePONovo.estado
                                                .click();
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                // TODO: Trocar pelo pais estrangeiro
                                EcommercePONovo.acre
                                                .click();
                        } else {
                                EcommercePONovo.estado
                                                .click();
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                EcommercePONovo.acre
                                                .click();
                        }

                }

                logger
                                .info("Adicionando categoria ao carrinho...");

                wait
                                .until(d -> EcommercePONovo.adicionarCategoria
                                                .isDisplayed());
                EcommercePONovo.adicionarCategoria
                                .click();

                String erro = null;
                if (tipo != 3 && tipo != 4 && tipo != 7 && tipo != 8) { // SE FOR 1 ou 2 ELE ENTRA
                        if (tipo == 5) {
                                EcommercePONovo
                                                .ComprarIngressos(10, driver);

                        } else if (tipo == 6) {
                                EcommercePONovo
                                                .ComprarIngressos(10, driver);

                        } else if (tipo == 2) {
                                EcommercePONovo
                                                .ComprarIngressos(3, driver);
                        } else {
                                EcommercePONovo.comprarIngressos
                                                .click();
                        }

                        try {
                                erro = EcommercePONovo.pegarMensagemErro
                                                .getText();
                        } catch (Exception e) {
                        }

                } else {
                        erro = "notnull";
                }
                String erro2 = null;
                if (erro != null) {

                        if (tipo != 4 && tipo != 7 && tipo != 8) { // SE FOR DIFERENTE DE 4 ENTRAR

                                if (tipo == 5) {
                                        EcommercePONovo.adicionarCategoria2_2Rec
                                                        .click();
                                } else if (tipo == 6) {
                                        EcommercePONovo.adicionarCategoria2_3Rec
                                                        .click();
                                } else if (tipo == 8) {

                                } else {
                                        EcommercePONovo.adicionarCategoria2
                                                        .click();
                                }
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }

                                if (/* tipo == 1 || */ tipo == 2) {

                                        EcommercePONovo.comprarIngressos
                                                        .click();
                                        try {
                                                Thread
                                                                .sleep(2000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        try {
                                                erro2 = EcommercePONovo.pegarMensagemErro
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
                                if (/* tipo == 1 || */ tipo == 2 || tipo == 8) {
                                        EcommercePONovo.selecionarPaisOrigem
                                                        .click();

                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        if (tipo == 1) {

                                                EcommercePONovo
                                                                .Pais(24, driver);
                                                try {
                                                        EcommercePONovo.estado
                                                                        .click();
                                                        EcommercePONovo.acre
                                                                        .click();
                                                } catch (Exception e) {

                                                }

                                        } else if (tipo == 8) {
                                                EcommercePONovo
                                                                .Pais(47, driver);
                                        } else {
                                                EcommercePONovo
                                                                .Pais(27, driver);
                                                ;
                                        }
                                }

                                if (tipo == 5) {
                                        EcommercePONovo.adicionarAoCarrinho_2Rec
                                                        .click();
                                } else if (tipo == 6) {
                                        EcommercePONovo.adicionarAoCarrinho_3Rec
                                                        .click();
                                } else {
                                        EcommercePONovo
                                                        .ComprarIngressos(3, driver);
                                }

                                if (tipo == 5 || tipo == 6 || tipo == 8) {
                                        wait
                                                        .until(d -> EcommercePONovo.nomeUsuario
                                                                        .isDisplayed());
                                        EcommercePONovo.nomeUsuario
                                                        .sendKeys(Nome_Cartao);
                                        EcommercePONovo.tipodocumento
                                                        .click();
                                        wait
                                                        .until(d -> EcommercePONovo.outros
                                                                        .isDisplayed());
                                        EcommercePONovo.outros
                                                        .click();
                                        EcommercePONovo.documento
                                                        .sendKeys(cpf);

                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        if (tipo != 8) {
                                                EcommercePONovo.nomeUsuario2
                                                                .sendKeys("Cleitin do grau");
                                                EcommercePONovo.tipodocumento2
                                                                .click();
                                                wait
                                                                .until(d -> EcommercePONovo.outros
                                                                                .isDisplayed());
                                                EcommercePONovo.outros
                                                                .click();
                                                EcommercePONovo.documento2
                                                                .sendKeys("123456789");

                                        }
                                        EcommercePONovo.confirmardadosusuario
                                                        .click();
                                }
                                try {
                                        Thread
                                                        .sleep(3000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                Double valor1 = 0.0;
                                boolean logado = false;
                                try {
                                        Thread
                                                        .sleep(2000);
                                        logado = EcommercePONovo.irParaPagamento
                                                        .isDisplayed();
                                } catch (Exception e) {

                                }
                                StringTokenizer resulBilhete1 = null;
                                if (logado) {
                                        resulBilhete1 = new StringTokenizer(EcommercePONovo.valorBilhete1
                                                        .getText());
                                } else {
                                        resulBilhete1 = new StringTokenizer(EcommercePONovo.valorBilhete1
                                                        .getText());
                                }

                                String valorbilhete1 = resulBilhete1
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
                                                                .until(d -> EcommercePONovo.registrarEfinalizarPedido
                                                                                .isDisplayed());
                                                EcommercePONovo.registrarEfinalizarPedido
                                                                .click();

                                                wait
                                                                .until(d -> EcommercePONovo.Email_ecommerce
                                                                                .isDisplayed());
                                                EcommercePONovo.Email_ecommerce
                                                                .sendKeys(email_usuario);
                                                EcommercePONovo.Email_Continuar
                                                                .click();
                                                try {
                                                        Thread
                                                                        .sleep(1000);
                                                } catch (InterruptedException e) {
                                                        e
                                                                        .printStackTrace();
                                                }
                                                wait
                                                                .until(d -> EcommercePONovo.senha_ecommerce
                                                                                .isDisplayed());
                                                EcommercePONovo.senha_ecommerce
                                                                .sendKeys(senha_usuario);
                                                EcommercePONovo.Logar
                                                                .click();
                                                logger
                                                                .info("Fazendo Login...");
                                        }

                                        wait
                                                        .until(d -> EcommercePONovo.irParaPagamento
                                                                        .isDisplayed());
                                        EcommercePONovo.irParaPagamento
                                                        .click();
                                        logger
                                                        .info("Finalizando pedido...");

                                        if (tipo == 4) {
                                                wait
                                                                .until(d -> EcommercePONovo.aceitar_termos
                                                                                .isDisplayed());
                                                EcommercePONovo.aceitar_termos
                                                                .click();
                                                EcommercePONovo.continuar_termos
                                                                .click();
                                        }
                                        // wait
                                        // .until(d -> EcommercePONovo.EscreverConfirmarSenha
                                        // .isDisplayed());
                                        // EcommercePONovo.EscreverConfirmarSenha
                                        // .sendKeys("1");
                                        // EcommercePONovo.botaoConfirmarSenha
                                        // .click();

                                        base
                                                        .realizarpagamento(driver);

                                        wait
                                                        .until(d -> EcommercePONovo.confirmarCompra
                                                                        .isDisplayed());
                                        String mensagem = EcommercePONovo.confirmarCompra
                                                        .getText();
                                        assertEquals("Seu pagamento foi aprovado!",
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

        public CataratasbuilderNovo(EcommercePONovo e) {
                this.EcommercePONovo = e;
        }
}
