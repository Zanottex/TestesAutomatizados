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

public class AquaRioBuilder {

        private static final Logger logger = Logger
                        .getLogger(AquaRioBuilder.class
                                        .getName());

                                        /*Dados dos usuarios */
        private EcommercePO ECommercePO;
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
                                        .info("Iniciando pesquisa: Ingresso Aquario");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Ingresso Aquario - Teste Automatizado");
                } else if (tipo == 2) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso Aquario + mar de espelho + museu de cera");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Ingresso Aquario + mar de espelho + museu de cera");
                } else if (tipo == 3) {
                        logger
                                        .info("Iniciando pesquisa: Combo AquaRio + BioParque - Teste Automatizado");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Combo AquaRio + BioParque - Teste Automatizado");
                } else if (tipo == 4) {
                        logger
                                        .info("Iniciando pesquisa: Combo AquaRio + Corcovado - Teste Automatizado");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Combo AquaRio + Corcovado - Teste Automatizado");
                } else if (tipo == 5) {
                        logger
                                        .info("Iniciando pesquisa: Ingresso passaporte anual");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("Ingresso passaporte anual - testes automatizados");
                } else if (tipo == 6) {
                        logger
                                        .info("Iniciando pesquisa: Mar de Espelhos");
                        ECommercePO.barraDePesquisa
                                        .sendKeys("mar de espelhos - teste automatizados");
                } else if (tipo == 7) {
                        logger
                                        .info("Iniciando pesquisa: Museu de cera");
                        ECommercePO.barraDePesquisa
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
                ECommercePO.bilhete_a_venda_grupo1
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
                                wait
                                                .until(d -> ECommercePO.dia3Receitas
                                                                .isEnabled());
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

                        if (tipo != 2 && tipo != 5) {
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
                                                                        .isDisplayed());
                                        ECommercePO.proximo
                                                        .click();
                                } else if (i == 1) {

                                        if (tipo == 4) {
                                                logger
                                                                .info("Selecionando local de embarque...");
                                                wait
                                                                .until(d -> ECommercePO.localEmbarque2Receitas
                                                                                .isDisplayed());
                                                ECommercePO.localEmbarque2Receitas
                                                                .click();
                                                ECommercePO.localEmbarqueConfirmar
                                                                .click();
                                                wait
                                                                .until(d -> ECommercePO.horario2Receitas_comLocalDeEmbarque
                                                                                .isDisplayed());
                                                try {
                                                        Thread
                                                                        .sleep(1000);
                                                } catch (InterruptedException e) {
                                                        e
                                                                        .printStackTrace();
                                                }
                                                ECommercePO.horario2Receitas_comLocalDeEmbarque
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
                                        } else {
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
                                        }
                                        wait
                                                        .until(d -> ECommercePO.proximo2Receitas
                                                                        .isEnabled());
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
                        }

                        i++;

                }
                logger
                                .info("Adicionando categoria ao carrinho...");
                if (tipo == 3 || tipo == 4) {
                        wait
                                        .until(d -> ECommercePO.adicionarCategoria_2Rec
                                                        .isDisplayed());
                        ECommercePO.adicionarCategoria_2Rec
                                        .click();
                } else if (tipo == 2) {
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

                if (tipo != 6 && tipo != 7) {
                        logger
                                        .info("Selecionando país de origem...");

                        ECommercePO.selecionarPaisOrigem
                                        .click();
                        ECommercePO.confirmaPaisOrigem
                                        .click();
                }
                if (tipo == 2) {
                        ECommercePO.estado_3Rec
                                        .click();
                        ECommercePO.acre
                                        .click();
                } else if (tipo == 3 || tipo == 4) {
                        ECommercePO.estado_2Rec
                                        .click();
                        ECommercePO.acre
                                        .click();
                } else if (tipo == 5) {
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
                } else if (tipo == 7 || tipo == 6) {

                } else {
                        boolean cep = false;
                        try {
                                ECommercePO.estado
                                                .isDisplayed();
                                cep = true;
                        } catch (Exception e) {
                                cep = false;
                        }
                        if (cep) {
                                ECommercePO.estado
                                                .click();
                                ECommercePO.acre
                                                .click();
                        }

                }

                if (tipo == 3 || tipo == 4) {
                        ECommercePO.adicionarCategoria2_2Rec
                                        .click();
                        ECommercePO.adicionarCategoria3_2Rec
                                        .click();
                } else if (tipo == 2) {
                        ECommercePO.adicionarCategoria2_3Rec
                                        .click();
                        ECommercePO.adicionarCategoria3_3Rec
                                        .click();
                } else if (tipo == 5 || tipo == 6 || tipo == 7) {
                        ECommercePO.adicionarCategoria2
                                        .click();

                } else {
                        ECommercePO.adicionarCategoria2
                                        .click();
                        ECommercePO.adicionarCategoria2Desconto
                                        .click();
                }
                try {
                        Thread
                                        .sleep(1000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                if (tipo == 3 || tipo == 4) {
                        ECommercePO.adicionarAoCarrinho_2Rec
                                        .click();
                } else if (tipo == 2) {
                        ECommercePO.adicionarAoCarrinho_3Rec
                                        .click();
                } else {
                        ECommercePO.adicionarAoCarrinho
                                        .click();
                }

                try {
                        Thread
                                        .sleep(2000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                if (tipo != 6 && tipo != 7) {
                        wait
                                        .until(d -> ECommercePO.nomeUsuario
                                                        .isDisplayed());
                        ECommercePO.nomeUsuario
                                        .sendKeys(Nome_Cartao);
                        wait
                                        .until(d -> ECommercePO.nomeUsuario2
                                                        .isDisplayed());
                        ECommercePO.nomeUsuario2
                                        .sendKeys(Nome_Cartao);
                        if (tipo != 5) {

                                ECommercePO.nomeUsuario3
                                                .sendKeys(Nome_Cartao);
                                ECommercePO.selecionarConvenio_coletaDeDados_usuario3
                                                .click();
                                wait
                                                .until(d -> ECommercePO.primeiro_convenio
                                                                .isDisplayed());
                                ECommercePO.primeiro_convenio
                                                .click();

                                ECommercePO.selecionarConvenio_coletaDeDados_usuario2
                                                .click();
                                wait
                                                .until(d -> ECommercePO.primeiro_convenio
                                                                .isDisplayed());

                                ECommercePO.primeiro_convenio
                                                .click();

                        } else {
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

                                try {
                                        Thread
                                                        .sleep(1000);
                                } catch (InterruptedException e) {
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
                        }

                        ECommercePO.confirmardadosusuario
                                        .click();
                }
                wait
                                .until(d -> ECommercePO.valorBilhete1
                                                .isDisplayed());
                StringTokenizer resulBilhete1 = new StringTokenizer(ECommercePO.valorBilhete1
                                .getText());
                String valorbilhete1 = resulBilhete1
                                .nextToken(" ");
                valorbilhete1 = resulBilhete1
                                .nextToken(" ");
                valorbilhete1 = valorbilhete1
                                .replaceAll(",", ".");
                Double valor1 = Double
                                .valueOf(valorbilhete1);

                if (valor1 == 15.00) {
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
                        // wait
                        // .until(d -> ECommercePO.EscreverConfirmarSenha
                        // .isDisplayed());
                        // ECommercePO.EscreverConfirmarSenha
                        // .sendKeys("1");
                        // ECommercePO.botaoConfirmarSenha
                        // .click();

                        wait
                                        .until(d -> ECommercePO.Nome_Do_Cartao
                                                        .isDisplayed());

                        ECommercePO.Nome_Do_Cartao
                                        .sendKeys(Nome_Cartao);

                        ECommercePO.Numero_Cartao
                                        .sendKeys(Numero_Cartao);

                        ECommercePO.Mes_Validade
                                        .sendKeys(mes_validade);

                        ECommercePO.codigo_segurança
                                        .sendKeys(codigo_segurança);

                        logger
                                        .info("Preenchendo informações de pagamento: " + " Nome Impresso no Cartão: "
                                                        + Nome_Cartao + ", Numero do cartão: " + Numero_Cartao
                                                        + ", Mes de validade: " + mes_validade
                                                        + ", Codifo de Segurança " + codigo_segurança + "...");

                        ECommercePO.CEP
                                        .sendKeys(CEP);

                        ECommercePO.Numero_Casa
                                        .sendKeys(Numero_Casa);

                        ECommercePO.bandeiracartao
                                        .click();
                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        ECommercePO.visa
                                        .click();
                        logger
                                        .info("Preenchendo endereço: CEP: " + CEP + ", Numero da Casa: " + Numero_Casa
                                                        + "...");
                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }

                        ECommercePO.finalizarCompra
                                        .click();

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

        }

        public AquaRioBuilder(EcommercePO e) {
                this.ECommercePO = e;
        }
}
