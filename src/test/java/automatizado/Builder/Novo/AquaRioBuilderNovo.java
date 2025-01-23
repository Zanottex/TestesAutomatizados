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

public class AquaRioBuilderNovo {

        private static final Logger logger = Logger
                        .getLogger(AquaRioBuilderNovo.class
                                        .getName());

        /* Dados dos usuarios */
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
                } catch (Exception e) {

                }
                logger
                                .info("Aceitando cookies...");

                if (tipo == 1) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Aquario");
                        EcommercePONovo.barraDePesquisa
                                        .sendKeys("Ingresso Aquario - Teste Automatizado");
                } else if (tipo == 2) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Aquario + mar de espelho + museu de cera");
                        EcommercePONovo.barraDePesquisa
                                        .sendKeys("Ingresso Aquario + mar de espelho + museu de cera");
                } else if (tipo == 3) {
                        logger
                                        .info("Iniciando pesquisa: Combo AquaRio + BioParque - Teste Automatizado");
                        EcommercePONovo.barraDePesquisa
                                        .sendKeys("Combo AquaRio + BioParque - Teste Automatizado");
                } else if (tipo == 4) {
                        logger
                                        .info("Iniciando pesquisa: Combo AquaRio + Corcovado - Teste Automatizado");
                        EcommercePONovo.barraDePesquisa
                                        .sendKeys("Combo AquaRio + Corcovado - Teste Automatizado");
                } else if (tipo == 5) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso passaporte anual");
                        EcommercePONovo.barraDePesquisa
                                        .sendKeys("Ingresso passaporte anual - testes automatizados");
                } else if (tipo == 6) {
                        logger
                                        .info("Iniciando pesquisa: Mar de Espelhos");
                        EcommercePONovo.barraDePesquisa
                                        .sendKeys("mar de espelhos - teste automatizados");
                } else if (tipo == 7) {
                        logger
                                        .info("Iniciando pesquisa: Museu de cera");
                        EcommercePONovo.barraDePesquisa
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
                EcommercePONovo.bilhete_a_venda_grupo1
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
                                try {
                                        Thread
                                                        .sleep(2000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                EcommercePONovo
                                                .ProximoMes(1, driver);

                                try {
                                        Thread
                                                        .sleep(1500);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }

                                EcommercePONovo.dia
                                                .click();

                        } else if (i == 1) {
                                wait
                                                .until(d -> EcommercePONovo.ProximoMes2Receitas
                                                                .isDisplayed());
                                EcommercePONovo.ProximoMes2Receitas
                                                .click();
                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                EcommercePONovo.dia2Receitas
                                                .click();

                        } else if (i == 2) {
                                wait
                                                .until(d -> EcommercePONovo.ProximoMes3Receitas
                                                                .isDisplayed());
                                EcommercePONovo.ProximoMes3Receitas
                                                .click();

                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }
                                wait
                                                .until(d -> EcommercePONovo.dia3Receitas
                                                                .isEnabled());
                                EcommercePONovo.dia3Receitas
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
                                        try {
                                                Thread
                                                                .sleep(2000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        EcommercePONovo
                                                        .ConfirmarHorarios(1, 2, driver);
                                        ;
                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }

                                } else if (i == 1) {

                                        if (tipo == 4) {
                                                logger
                                                                .info("Selecionando local de embarque...");
                                                wait
                                                                .until(d -> EcommercePONovo.localEmbarque2Receitas
                                                                                .isDisplayed());
                                                EcommercePONovo.localEmbarque2Receitas
                                                                .click();
                                                EcommercePONovo.localEmbarqueConfirmar
                                                                .click();
                                                wait
                                                                .until(d -> EcommercePONovo.horario2Receitas_comLocalDeEmbarque
                                                                                .isDisplayed());
                                                try {
                                                        Thread
                                                                        .sleep(1000);
                                                } catch (InterruptedException e) {
                                                        e
                                                                        .printStackTrace();
                                                }
                                                EcommercePONovo.horario2Receitas_comLocalDeEmbarque
                                                                .click();
                                                try {
                                                        Thread
                                                                        .sleep(1000);
                                                } catch (InterruptedException e) {
                                                        e
                                                                        .printStackTrace();
                                                }
                                                EcommercePONovo.confirmarHorario4opcoes
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
                                                                .until(d -> EcommercePONovo.horario2Receitas
                                                                                .isDisplayed());
                                                try {
                                                        Thread
                                                                        .sleep(1000);
                                                } catch (InterruptedException e) {
                                                        e
                                                                        .printStackTrace();
                                                }
                                                EcommercePONovo.horario2Receitas
                                                                .click();
                                                try {
                                                        Thread
                                                                        .sleep(1000);
                                                } catch (InterruptedException e) {
                                                        e
                                                                        .printStackTrace();
                                                }
                                                EcommercePONovo.confirmarHorario4opcoes
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
                                                        .until(d -> EcommercePONovo.proximo2Receitas
                                                                        .isEnabled());
                                        EcommercePONovo.proximo2Receitas
                                                        .click();
                                } else if (i == 2) {
                                        wait
                                                        .until(d -> EcommercePONovo.horario3Receitas
                                                                        .isDisplayed());
                                        EcommercePONovo.horario3Receitas
                                                        .click();
                                        EcommercePONovo.confirmarHorario4opcoes
                                                        .click();
                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        EcommercePONovo.proximo3Receitas
                                                        .click();
                                }
                        }

                        i++;

                }

                logger
                                .info("Selecionando país de origem...");

                if (tipo == 5) {
                        boolean cep = false;
                        try {
                                cep = EcommercePONovo.CEP_Nas_categorias
                                                .isDisplayed();
                        } catch (Exception e) {
                                cep = false;
                        }
                        if (cep) {
                                EcommercePONovo.CEP_Nas_categorias
                                                .sendKeys("85509432");
                        }
                } else {
                        EcommercePONovo.selecionarPaisOrigem
                                        .click();
                        EcommercePONovo.confirmaPaisOrigem
                                        .click();

                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        EcommercePONovo.estado
                                        .click();
                        EcommercePONovo.acre
                                        .click();

                }

                logger
                                .info("Adicionando categoria ao carrinho...");
                if (tipo == 3 || tipo == 4) {
                        wait
                                        .until(d -> EcommercePONovo.adicionarCategoria_2Rec
                                                        .isDisplayed());
                        EcommercePONovo
                                        .categorias(3, 1, driver);
                } else if (tipo == 2) {
                        wait
                                        .until(d -> EcommercePONovo.adicionarCategoria_3Rec
                                                        .isDisplayed());
                        EcommercePONovo
                                        .categorias(4, 1, driver);

                } else {
                        wait
                                        .until(d -> EcommercePONovo.adicionarCategoria
                                                        .isDisplayed());
                        EcommercePONovo.adicionarCategoria
                                        .click();
                        ;
                }

                logger
                                .info("Adicionando as outras categorias...");
                if (tipo == 3 || tipo == 4) {
                        EcommercePONovo.adicionarCategoria2_2Rec
                                        .click();
                        EcommercePONovo.adicionarCategoria3_2Rec
                                        .click();
                } else if (tipo == 2) {
                        EcommercePONovo.adicionarCategoria2_3Rec
                                        .click();
                        EcommercePONovo.adicionarCategoria3_3Rec
                                        .click();
                } else if (tipo == 5 || tipo == 6 || tipo == 7) {
                        EcommercePONovo.adicionarCategoria2
                                        .click();

                } else {
                        EcommercePONovo.adicionarCategoria2
                                        .click();
                        EcommercePONovo.adicionarCategoria3
                                        .click();
                }
                try {
                        Thread
                                        .sleep(1000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                logger
                                .info("Adicionando ao carrinho...");
                if (tipo == 3 || tipo == 4) {
                        EcommercePONovo.adicionarAoCarrinho_2Rec
                                        .click();
                } else if (tipo == 2) {
                        EcommercePONovo.adicionarAoCarrinho_3Rec
                                        .click();
                } else {
                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        EcommercePONovo
                                        .ComprarIngressos(3, driver);
                        ;
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
                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        EcommercePONovo
                                        .Nomeusuario(1, Nome_Cartao, driver);

                        EcommercePONovo
                                        .Nomeusuario(2, "Cleitin do grau", driver);
                        ;
                        if (tipo != 5) {

                                EcommercePONovo
                                                .Nomeusuario(3, "Marcelo Leopoldo", driver);
                                ;
                                EcommercePONovo
                                                .Convenio(2, driver);
                                wait
                                                .until(d -> EcommercePONovo.primeiro_convenio
                                                                .isDisplayed());
                                EcommercePONovo.primeiro_convenio
                                                .click();

                                EcommercePONovo
                                                .Convenio(3, driver);
                                ;
                                wait
                                                .until(d -> EcommercePONovo.primeiro_convenio
                                                                .isDisplayed());

                                EcommercePONovo.primeiro_convenio
                                                .click();

                        } else {
                                EcommercePONovo.tipodocumento
                                                .click();
                                wait
                                                .until(d -> EcommercePONovo.outros
                                                                .isDisplayed());
                                EcommercePONovo.outros
                                                .click();
                                EcommercePONovo.documento
                                                .sendKeys(cpf);
                                EcommercePONovo.data_de_nascimento_ColetaDeDados_PrimeiroUsuario
                                                .sendKeys("01/01/2000");

                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
                                        e
                                                        .printStackTrace();
                                }

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
                                EcommercePONovo.data_de_nascimento_ColetaDeDados_SegundoUsuario
                                                .sendKeys("01/01/2020");
                        }

                        EcommercePONovo.confirmardadosusuario
                                        .click();
                }
                logger
                                .info("Verificando se o usuario está logado...");
                Double valor1 = 0.0;
                boolean logado = false;
                try {
                        Thread
                                        .sleep(3000);
                        logado = EcommercePONovo.irParaPagamento
                                        .isDisplayed();
                } catch (Exception e) {

                }
                StringTokenizer resulBilhete1 = null;

                if (logado) {
                        wait
                                        .until(d -> EcommercePONovo.irParaPagamento
                                                        .isDisplayed());
                        resulBilhete1 = new StringTokenizer(EcommercePONovo
                                        .ValorBilhete_1(2, driver));
                } else {
                        wait
                                        .until(d -> EcommercePONovo.registrarEfinalizarPedido
                                                        .isDisplayed());
                        resulBilhete1 = new StringTokenizer(EcommercePONovo.valorBilhete1
                                        .getText());
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
                                                                .isEnabled());
                                EcommercePONovo.senha_ecommerce
                                                .sendKeys(senha_usuario);
                                EcommercePONovo.Logar
                                                .click();
                                logger
                                                .info("Fazendo Login...");
                        }
                        if (Captcha == null) {
                                wait
                                                .until(d -> EcommercePONovo.irParaPagamento
                                                                .isDisplayed());
                                EcommercePONovo.irParaPagamento
                                                .click();
                                logger
                                                .info("Finalizando pedido...");

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
                                assertEquals("Seu pagamento foi aprovado!", mensagem);
                                logger
                                                .info("Pedido finalizado com sucesso!");
                        } else {

                                JavascriptExecutor js = (JavascriptExecutor) driver;
                                js
                                                .executeScript("alert('ERRO: Captcha bloqueou o programa');");
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

        }


        public AquaRioBuilderNovo(EcommercePONovo e) {
                this.EcommercePONovo = e;
        }
}
