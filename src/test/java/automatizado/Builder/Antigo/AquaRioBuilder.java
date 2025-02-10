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

public class AquaRioBuilder {

        private static final Logger logger = Logger
                        .getLogger(AquaRioBuilder.class
                                        .getName());

        /* Dados dos usuarios */
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
                } catch (Exception e) {

                }
                logger
                                .info("Aceitando cookies...");

                if (tipo == 1) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Aquario");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Ingresso Aquario - Teste Automatizado");
                } else if (tipo == 2) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Aquario + mar de espelho + museu de cera");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Ingresso Aquario + mar de espelho + museu de cera");
                } else if (tipo == 3) {
                        logger
                                        .info("Iniciando pesquisa: Combo AquaRio + BioParque - Teste Automatizado");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Combo AquaRio + BioParque - Teste Automatizado");
                } else if (tipo == 4) {
                        logger
                                        .info("Iniciando pesquisa: Combo AquaRio + Corcovado - Teste Automatizado");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Combo AquaRio + Corcovado - Teste Automatizado");
                } else if (tipo == 5) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso passaporte anual");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Ingresso passaporte anual - testes automatizados");
                } else if (tipo == 6) {
                        logger
                                        .info("Iniciando pesquisa: Mar de Espelhos");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("mar de espelhos - teste automatizados");
                } else if (tipo == 7) {
                        logger
                                        .info("Iniciando pesquisa: Museu de cera");
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Museu de cera - testes automatizados");
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
                if (tipo == 3 || tipo == 4) {
                        dias = 2;
                } else if (tipo == 2) {
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
                                                        .sleep(1500);
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
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                wait
                                                .until(d -> EcommercePOAntigo.dia3Receitas
                                                                .isEnabled());
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

                        if (tipo != 2 && tipo != 5) {
                                logger
                                                .info("Selecionando Horario...");
                                if (i == 0) {
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
                                } else if (i == 1) {

                                        if (tipo == 4) {
                                                logger
                                                                .info("Selecionando local de embarque...");
                                                wait
                                                                .until(d -> EcommercePOAntigo.localEmbarque2Receitas
                                                                                .isDisplayed());
                                                EcommercePOAntigo.localEmbarque2Receitas
                                                                .click();
                                                try {
                                                        Thread
                                                                        .sleep(1000);
                                                } catch (InterruptedException e) {
                                                        e
                                                                        .printStackTrace();
                                                }
                                                EcommercePOAntigo.localEmbarqueConfirmar
                                                                .click();
                                                wait
                                                                .until(d -> EcommercePOAntigo.horario2Receitas_comLocalDeEmbarque
                                                                                .isDisplayed());
                                                try {
                                                        Thread
                                                                        .sleep(2000);
                                                } catch (InterruptedException e) {
                                                        e
                                                                        .printStackTrace();
                                                }
                                                EcommercePOAntigo
                                                                .Horario(2, 2, driver);
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
                                                                        .sleep(1000);
                                                } catch (InterruptedException e) {
                                                        e
                                                                        .printStackTrace();
                                                }
                                        } else {
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
                                                                        .sleep(1000);
                                                } catch (InterruptedException e) {
                                                        e
                                                                        .printStackTrace();
                                                }
                                        }

                                        wait
                                                        .until(d -> EcommercePOAntigo.proximo2Receitas
                                                                        .isEnabled());
                                        EcommercePOAntigo.proximo2Receitas
                                                        .click();
                                } else if (i == 2) {
                                        wait
                                                        .until(d -> EcommercePOAntigo.horario3Receitas
                                                                        .isDisplayed());
                                        EcommercePOAntigo.horario3Receitas
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
                                        EcommercePOAntigo.proximo3Receitas
                                                        .click();
                                }
                        }

                        i++;

                }
                logger
                                .info("Adicionando categoria ao carrinho...");
                if (tipo == 3 || tipo == 4) {
                        wait
                                        .until(d -> EcommercePOAntigo.adicionarCategoria_2Rec
                                                        .isDisplayed());
                        EcommercePOAntigo
                                        .categorias(3, 1, driver);
                } else if (tipo == 2) {
                        wait
                                        .until(d -> EcommercePOAntigo.adicionarCategoria_3Rec
                                                        .isDisplayed());
                        EcommercePOAntigo
                                        .categorias(4, 1, driver);

                } else {
                        wait
                                        .until(d -> EcommercePOAntigo.adicionarCategoria
                                                        .isDisplayed());
                        EcommercePOAntigo
                                        .categorias(2, 1, driver);
                }
                logger
                                .info("Selecionando país de origem...");
                if (tipo != 6 && tipo != 7) {

                        EcommercePOAntigo.selecionarPaisOrigem
                                        .click();
                        try {
                                EcommercePOAntigo
                                                .Pais(24, driver);
                                EcommercePOAntigo
                                                .Pais(25, driver);
                        } catch (Exception e) {
                                // TODO: handle exception
                        }

                }
                if (tipo == 2) {
                        try {
                                Thread
                                                .sleep(2000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        try {
                                EcommercePOAntigo
                                                .estado(4, driver);
                                EcommercePOAntigo.acre
                                                .click();
                        } catch (Exception e) {
                                // TODO: handle exception
                        }

                } else if (tipo == 3 || tipo == 4) {
                        try {
                                EcommercePOAntigo
                                                .estado(3, driver);
                                EcommercePOAntigo.acre
                                                .click();
                        } catch (Exception e) {

                        }

                } else if (tipo == 5) {
                        boolean cep = false;
                        try {
                                cep = EcommercePOAntigo.CEP_Nas_categorias
                                                .isDisplayed();
                        } catch (Exception e) {
                                cep = false;
                        }
                        if (cep) {
                                EcommercePOAntigo.CEP_Nas_categorias
                                                .sendKeys("85509432");
                        }
                } else if (tipo == 7 || tipo == 6) {

                } else {
                        try {

                                EcommercePOAntigo.estado
                                                .click();
                                EcommercePOAntigo.acre
                                                .click();
                        } catch (Exception e) {

                        }

                }
                logger
                                .info("Adicionando as outras categorias...");
                if (tipo == 3 || tipo == 4) {
                        EcommercePOAntigo.adicionarCategoria2_2Rec
                                        .click();
                        EcommercePOAntigo.adicionarCategoria3_2Rec
                                        .click();
                } else if (tipo == 2) {
                        EcommercePOAntigo.adicionarCategoria2_3Rec
                                        .click();
                        EcommercePOAntigo.adicionarCategoria3_3Rec
                                        .click();
                } else if (tipo == 5 || tipo == 6 || tipo == 7) {
                        EcommercePOAntigo.adicionarCategoria2
                                        .click();

                } else {
                        EcommercePOAntigo.adicionarCategoria2
                                        .click();
                        EcommercePOAntigo.adicionarCategoria2Desconto
                                        .click();
                }
                try {
                        Thread
                                        .sleep(1500);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                logger
                                .info("Adicionando ao carrinho...");
                if (tipo == 3 || tipo == 4) {
                        EcommercePOAntigo.adicionarAoCarrinho_2Rec
                                        .click();
                } else if (tipo == 2) {
                        EcommercePOAntigo.adicionarAoCarrinho_3Rec
                                        .click();
                } else {
                        EcommercePOAntigo.adicionarAoCarrinho
                                        .click();
                }

                try {
                        Thread
                                        .sleep(2000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                logger
                                .info("Preenchendo os dados dos visitantes...");
                if (tipo != 6 && tipo != 7) {
                        wait
                                        .until(d -> EcommercePOAntigo.nomeUsuario
                                                        .isDisplayed());
                        EcommercePOAntigo.nomeUsuario
                                        .sendKeys(Nome_Cartao);
                        wait
                                        .until(d -> EcommercePOAntigo.nomeUsuario2
                                                        .isDisplayed());
                        EcommercePOAntigo.nomeUsuario2
                                        .sendKeys(Nome_Cartao);
                        if (tipo != 5) {

                                EcommercePOAntigo.nomeUsuario3
                                                .sendKeys(Nome_Cartao);
                                EcommercePOAntigo.selecionarConvenio_coletaDeDados_usuario3
                                                .click();
                                wait
                                                .until(d -> EcommercePOAntigo.primeiro_convenio
                                                                .isDisplayed());
                                EcommercePOAntigo.primeiro_convenio
                                                .click();

                                EcommercePOAntigo.selecionarConvenio_coletaDeDados_usuario2
                                                .click();
                                wait
                                                .until(d -> EcommercePOAntigo.primeiro_convenio
                                                                .isDisplayed());

                                EcommercePOAntigo.primeiro_convenio
                                                .click();

                        } else {
                                EcommercePOAntigo.tipodocumento
                                                .click();
                                wait
                                                .until(d -> EcommercePOAntigo.outros
                                                                .isDisplayed());
                                EcommercePOAntigo.outros
                                                .click();
                                EcommercePOAntigo.documento
                                                .sendKeys(cpf);
                                EcommercePOAntigo.data_de_nascimento_ColetaDeDados_PrimeiroUsuario
                                                .sendKeys("01/01/2000");

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
                                EcommercePOAntigo.data_de_nascimento_ColetaDeDados_SegundoUsuario
                                                .sendKeys("01/01/2020");
                        }

                        EcommercePOAntigo.confirmardadosusuario
                                        .click();
                }
                logger
                                .info("Verificando se o usuario está logado...");
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
                        wait
                                        .until(d -> EcommercePOAntigo.finalizarPedido
                                                        .isDisplayed());
                        resulBilhete1 = new StringTokenizer(EcommercePOAntigo
                                        .ValorBilhete_1(2, driver));
                } else {
                        wait
                                        .until(d -> EcommercePOAntigo.registrarEfinalizarPedido
                                                        .isDisplayed());
                        resulBilhete1 = new StringTokenizer(EcommercePOAntigo
                                        .ValorBilhete_1(1, driver));
                }
                logger
                                .info("Verificando valor do bilhete...");
                String valorbilhete1 = resulBilhete1
                                .nextToken(" ");
                valorbilhete1 = resulBilhete1
                                .nextToken(" ");
                valorbilhete1 = valorbilhete1
                                .replaceAll(",", ".");
                valor1 = Double
                                .valueOf(valorbilhete1);
                String Captcha = null;
                if (valor1 == 15.00) {
                        logger
                                        .info("Finalizando pedido...");
                        if (logado) {

                        } else {
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
                                                .executeScript("alert('ERRO: Captcha bloqueou o programa');");
                                logger
                                                .severe("ERRO: Captcha bloqueou o programa.");
                        }
                } else

                {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js
                                        .executeScript("alert('ERRO: VALOR DO BILHETE INVÁLIDO');");
                        logger
                                        .severe("ERRO: VALOR DO BILHETE INVÁLIDO.");
                }

        }

        public AquaRioBuilder(EcommercePOAntigo e) {
                this.EcommercePOAntigo = e;
        }
}
