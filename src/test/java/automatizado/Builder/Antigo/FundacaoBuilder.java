package automatizado.Builder.Antigo;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import automatizado.Page.EcommercePOAntigo;

public class FundacaoBuilder {

        private static final Logger logger = Logger
                        .getLogger(Cataratasbuilder.class
                                        .getName());

        private EcommercePOAntigo EcommercePOAntigo;
        private String email_usuario = "gustavozanotto119@gmail.com";
        private String senha_usuario = "1";
        private String Nome_Cartao = "Gustavin Zanottin";

        private String Numero_Cartao = "4000000000000010";
        private String mes_validade = "122500";
        private String codigo_segurança = "123";
        private String CEP = "85509432";
        private String Numero_Casa = "1050";

        static {
                // Configuração do handler de log para exibir logs no console
                ConsoleHandler consoleHandler = new ConsoleHandler();
                consoleHandler
                                .setLevel(Level.ALL);
                logger
                                .addHandler(consoleHandler);
        }

        public void Builder(WebDriver driver, int tipo) {
                Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

                wait
                                .until(d -> EcommercePOAntigo.barraDePesquisa
                                                .isDisplayed());
                EcommercePOAntigo.barraDePesquisa
                                .sendKeys("Bilhete para fundação");
                EcommercePOAntigo.bilhete_a_venda_grupo1
                                .click();
                logger
                                .info("Redirecionando do ecommerce guarda chuva para o ecommerce dos bilhetes...");
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

                wait
                                .until(d -> EcommercePOAntigo.barraDePesquisa
                                                .isDisplayed());
                logger
                                .info("Pesquisando o bilhete na barra de pesquisa...");
                if (tipo == 1) {
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Bilhete Fundação com sessão e embarque");
                        logger
                                        .info("Iniciando pesquisa: Bilhete Fundação com sessão e embarque");
                        EcommercePOAntigo.bilhete_a_venda_grupo1
                                        .click();

                } else if (tipo == 2) {
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Bilhete Multiplas Datas de Visita");
                        logger
                                        .info("Iniciando pesquisa: Bilhete Multiplas Datas de Visita");
                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        EcommercePOAntigo.bilhete_a_venda_grupo1
                                        .click();
                } else if (tipo == 3) {
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Bilhete Credenciado");
                        logger
                                        .info("Iniciando pesquisa: Bilhete Credenciado");
                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        EcommercePOAntigo.bilhete_a_venda_grupo2
                                        .click();
                } else if (tipo == 4) {
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Bilhete Vinculado 1");
                        logger
                                        .info("Iniciando pesquisa: Bilhete Vinculado 1");
                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        EcommercePOAntigo.bilhete_a_venda_grupo1
                                        .click();
                } else if (tipo == 5) {
                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Bilhete Desconto Progressivo");
                        logger
                                        .info("Iniciando pesquisa: Bilhete Desconto Progressivo");
                        EcommercePOAntigo.bilhete_a_venda_grupo1
                                        .click();
                } else if (tipo == 6) {

                        EcommercePOAntigo.barraDePesquisa
                                        .sendKeys("Bilhete quantidade mínima");
                        logger
                                        .info("Iniciando pesquisa: Bilhete quantidade mínima");
                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        EcommercePOAntigo.bilhete_a_venda_grupo1
                                        .click();
                }
                logger
                                .info("Selecionando mês...");
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
                logger
                                .info("Selecionando dia...");
                wait
                                .until(d -> EcommercePOAntigo.dia
                                                .isDisplayed());
                EcommercePOAntigo.dia
                                .click();

                String diaInicio = null;
                int DIAINICIO = 0;
                String diaTermino = null;
                int DIATERMINO = 0;
                String MesInicio = null;
                String MesTermino = null;
                String AnoInicio = null;
                int ANOINICIO = 0;
                String AnoTermino = null;
                int ANOTERMINO = 0;
                if (tipo == 2) {
                        logger
                                        .info("Selecionando data fim da visita...");
                        EcommercePOAntigo.diaFim
                                        .click();

                        wait
                                        .until(d -> EcommercePOAntigo.DiaInicio
                                                        .isDisplayed());
                        diaInicio = EcommercePOAntigo.DiaInicio
                                        .getText();
                        DIAINICIO = Integer
                                        .parseInt(diaInicio);
                        diaTermino = EcommercePOAntigo.DiaTermino
                                        .getText();
                        DIATERMINO = Integer
                                        .parseInt(diaTermino);
                        MesInicio = EcommercePOAntigo.MesInicio
                                        .getText();
                        MesTermino = EcommercePOAntigo.MesTermino
                                        .getText();
                        AnoInicio = EcommercePOAntigo.AnoInicio
                                        .getText();
                        ANOINICIO = Integer
                                        .parseInt(AnoInicio);
                        AnoTermino = EcommercePOAntigo.AnoTermino
                                        .getText();
                        ANOTERMINO = Integer
                                        .parseInt(AnoTermino);
                }
                logger
                                .info("Selecionando local de embarque...");
                wait
                                .until(d -> EcommercePOAntigo.localEmbarque
                                                .isDisplayed());
                EcommercePOAntigo.localEmbarque
                                .click();
                EcommercePOAntigo.localEmbarqueConfirmar
                                .click();

                if (tipo == 3) {
                        logger
                                        .info("Colocando código do credenciado...");
                        wait
                                        .until(d -> EcommercePOAntigo.CódigoCredenciado
                                                        .isDisplayed());
                        EcommercePOAntigo.CódigoCredenciado
                                        .click();

                        EcommercePOAntigo.ColocarCódigoCredenciado
                                        .sendKeys("121525");
                        EcommercePOAntigo.ConfirmarCredenciado
                                        .click();
                        wait
                                        .until(d -> EcommercePOAntigo.ConfirmarCredenciado
                                                        .isDisplayed());
                        EcommercePOAntigo.ConfirmarCredenciado
                                        .click();
                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        logger
                                        .info("Escolhendo horario...");
                        wait
                                        .until(d -> EcommercePOAntigo.horarioCredenciado
                                                        .isEnabled());
                        EcommercePOAntigo.horarioCredenciado
                                        .click();
                        logger
                                        .info("Escolhendo sessão");
                        wait
                                        .until(d -> EcommercePOAntigo.sessaoConfirmar
                                                        .isEnabled());
                        EcommercePOAntigo.sessaoConfirmar
                                        .click();

                } else {
                        try {
                                Thread
                                                .sleep(6000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        logger
                                        .info("Escolhendo horario...");
                        wait
                                        .until(d -> EcommercePOAntigo.horario
                                                        .isDisplayed());
                        EcommercePOAntigo.horario
                                        .click();
                        EcommercePOAntigo.confirmarHorario4opcoes
                                        .click();
                        logger
                                        .info("Escolhendo sessao...");
                        EcommercePOAntigo.sessao
                                        .click();
                        wait
                                        .until(d -> EcommercePOAntigo.sessaoConfirmar
                                                        .isEnabled());
                        EcommercePOAntigo.sessaoConfirmar
                                        .click();
                }

                try {
                        Thread
                                        .sleep(3000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                wait
                                .until(d -> EcommercePOAntigo.proximo
                                                .isEnabled());
                EcommercePOAntigo.proximo
                                .click();
                logger
                                .info("Adicionando categoria...");
                wait
                                .until(d -> EcommercePOAntigo.adicionarCategoria
                                                .isDisplayed());
                EcommercePOAntigo.adicionarCategoria
                                .click();
                logger
                                .info("Escolhendo pais de origem incorreto...");
                EcommercePOAntigo.selecionarPaisOrigem
                                .click();

                EcommercePOAntigo
                                .Pais(14, driver);
                logger
                                .info("Adicionando no carrinho...");
                EcommercePOAntigo.adicionarAoCarrinho
                                .click();

                try {
                        Thread
                                        .sleep(1000);
                } catch (InterruptedException e) {
                        e
                                        .printStackTrace();
                }
                String erro = EcommercePOAntigo.pegarMensagemErro
                                .getText();
                double valorsomado = 0.0;
                logger
                                .info("Verificando se o pais incorreto gera o alerta em tela...");
                if (erro != null) {
                        logger
                                        .info("Selecioanndo pais correto...");
                        EcommercePOAntigo.selecionarPaisOrigem
                                        .click();
                        try {
                                Thread
                                                .sleep(1000);
                        } catch (InterruptedException e) {
                                e
                                                .printStackTrace();
                        }
                        EcommercePOAntigo
                                        .Pais(11, driver);
                        logger
                                        .info("Adicionando estado...");
                        EcommercePOAntigo.estado
                                        .click();
                        EcommercePOAntigo.acre
                                        .click();

                        if (tipo == 5) {
                                logger
                                                .info("Verificando valor do bilhete com desconto...");
                                wait
                                                .until(d -> EcommercePOAntigo.valorTotal_nasCategorias
                                                                .isDisplayed());
                                StringTokenizer Result = new StringTokenizer(EcommercePOAntigo.valorTotal_nasCategorias
                                                .getText());
                                String valortotal = Result
                                                .nextToken(" ");
                                valortotal = Result
                                                .nextToken(" ");
                                valortotal = valortotal
                                                .replaceAll(",", ".");
                                valorsomado = Double
                                                .valueOf(valortotal);

                                if (valorsomado == 10.0) {
                                        EcommercePOAntigo.adicionarCategoria
                                                        .click();
                                        wait
                                                        .until(d -> EcommercePOAntigo.valorDesconto
                                                                        .isDisplayed());
                                        Result = new StringTokenizer(EcommercePOAntigo.valorDesconto
                                                        .getText());
                                        valortotal = Result
                                                        .nextToken(" ");
                                        valortotal = Result
                                                        .nextToken(" ");
                                        valortotal = valortotal
                                                        .replaceAll(",", ".");
                                        valorsomado = Double
                                                        .valueOf(valortotal);

                                        if (valorsomado == 10.0) {
                                                EcommercePOAntigo.tirarcategoria1
                                                                .click();
                                                EcommercePOAntigo.tirarcategoria1
                                                                .click();
                                                EcommercePOAntigo.adicionarCategoria2Desconto
                                                                .click();
                                                EcommercePOAntigo.adicionarCategoria2Desconto
                                                                .click();
                                                wait
                                                                .until(d -> EcommercePOAntigo.valorDesconto
                                                                                .isDisplayed());
                                                Result = new StringTokenizer(EcommercePOAntigo.valorDesconto
                                                                .getText());
                                                valortotal = Result
                                                                .nextToken(" ");
                                                valortotal = Result
                                                                .nextToken(" ");
                                                valortotal = valortotal
                                                                .replaceAll(",", ".");
                                                valorsomado = Double
                                                                .valueOf(valortotal);

                                                if (valorsomado == 5.0) {
                                                        EcommercePOAntigo.tirarcategoria2
                                                                        .click();
                                                        EcommercePOAntigo.adicionarCategoria
                                                                        .click();

                                                        wait
                                                                        .until(d -> EcommercePOAntigo.valorDesconto
                                                                                        .isDisplayed());
                                                        Result = new StringTokenizer(EcommercePOAntigo.valorDesconto
                                                                        .getText());
                                                        valortotal = Result
                                                                        .nextToken(" ");
                                                        valortotal = Result
                                                                        .nextToken(" ");
                                                        valortotal = valortotal
                                                                        .replaceAll(",", ".");
                                                        valorsomado = Double
                                                                        .valueOf(valortotal);

                                                        if (valorsomado == 7.50) {
                                                                EcommercePOAntigo.adicionarAoCarrinho
                                                                                .click();

                                                        } else {
                                                                JavascriptExecutor js = (JavascriptExecutor) driver;
                                                                js
                                                                                .executeScript("alert('ERRO: VALOR INVALIDO DO DESCONTO DO BILHETE');");
                                                        }
                                                } else {
                                                        JavascriptExecutor js = (JavascriptExecutor) driver;
                                                        js
                                                                        .executeScript("alert('ERRO: VALOR INVALIDO DO DESCONTO DO BILHETE');");
                                                }
                                        } else {
                                                JavascriptExecutor js = (JavascriptExecutor) driver;
                                                js
                                                                .executeScript("alert('ERRO: VALOR INVALIDO DO DESCONTO DO BILHETE');");
                                        }
                                }
                        } else if (tipo == 6) {
                                logger
                                                .info("Verifica se é possivel adicionar ao carrinho sem ter uma categoria pagante..");
                                EcommercePOAntigo.tirarcategoria1
                                                .click();

                                boolean possivel = true;
                                try {
                                        possivel = EcommercePOAntigo.adicionarAoCarrinho
                                                        .isEnabled();
                                } catch (Exception e) {
                                }

                                if (possivel == false) {

                                        EcommercePOAntigo.adicionarCategoria
                                                        .click();
                                        EcommercePOAntigo.adicionarAoCarrinho
                                                        .click();
                                }
                        } else {
                                EcommercePOAntigo.adicionarAoCarrinho
                                                .click();
                        }
                }
                logger
                                .info("Adicionando no carrinho...");
                wait
                                .until(d -> EcommercePOAntigo.nomeUsuario
                                                .isDisplayed());
                logger
                                .info("Informando os dados dos visitantes...");
                EcommercePOAntigo
                                .Nomeusuario(1, 1, "Gustavo Zanotto", driver);
                EcommercePOAntigo.tipodocumento
                                .click();
                wait
                                .until(d -> EcommercePOAntigo.outros
                                                .isDisplayed());
                EcommercePOAntigo.outros
                                .click();

                EcommercePOAntigo
                                .valorDocumento(1, 1, "123456789", driver);

                if (tipo == 5) {
                        EcommercePOAntigo
                                        .Nomeusuario(2, 1, "Marcelo Leopoldo ", driver);
                        EcommercePOAntigo
                                        .tipoDocumento(2, 1, driver);
                        wait
                                        .until(d -> EcommercePOAntigo.outros
                                                        .isDisplayed());
                        EcommercePOAntigo.outros
                                        .click();

                        EcommercePOAntigo
                                        .valorDocumento(2, 1, "987654321", driver);
                } else if (tipo == 6) {
                        EcommercePOAntigo
                                        .Nomeusuario(1, 2, "Marcelo Leopoldo ", driver);
                        EcommercePOAntigo
                                        .tipoDocumento(1, 2, driver);
                        wait
                                        .until(d -> EcommercePOAntigo.outros
                                                        .isDisplayed());
                        EcommercePOAntigo.outros
                                        .click();

                        EcommercePOAntigo
                                        .valorDocumento(1, 2, "987654321", driver);
                }

                EcommercePOAntigo.confirmardadosusuario
                                .click();

                Double valor1 = 0.0;
                boolean logado = false;
                logger
                                .info("Verificando se o usuario está logado...");
                try {
                        Thread
                                        .sleep(3000);
                        logado = EcommercePOAntigo.finalizarPedido
                                        .isDisplayed();
                } catch (Exception e) {

                }
                StringTokenizer resulBilhete1 = null;
                StringTokenizer resulBilhete2 = null;
                if (tipo == 4) {
                        if (logado) {
                                wait
                                                .until(d -> EcommercePOAntigo.finalizarPedido
                                                                .isDisplayed());
                                resulBilhete1 = new StringTokenizer(EcommercePOAntigo
                                                .ValorBilhete_1(2, driver));
                                resulBilhete2 = new StringTokenizer(EcommercePOAntigo
                                                .ValorBilhete_2_vinculado(2, driver));
                        } else {
                                wait
                                                .until(d -> EcommercePOAntigo.registrarEfinalizarPedido
                                                                .isDisplayed());
                                resulBilhete1 = new StringTokenizer(EcommercePOAntigo
                                                .ValorBilhete_1(1, driver));
                                resulBilhete2 = new StringTokenizer(EcommercePOAntigo
                                                .ValorBilhete_2_vinculado(1, driver));
                        }

                        String valorbilhete1 = resulBilhete1
                                        .nextToken(" ");
                        valorbilhete1 = resulBilhete1
                                        .nextToken(" ");
                        valorbilhete1 = valorbilhete1
                                        .replaceAll(",", ".");
                        valor1 = Double
                                        .valueOf(valorbilhete1);

                        String valorbilhete2_vinculado = resulBilhete2
                                        .nextToken(" ");
                        valorbilhete2_vinculado = resulBilhete2
                                        .nextToken(" ");
                        valorbilhete2_vinculado = valorbilhete2_vinculado
                                        .replaceAll(",", ".");
                        Double valor2 = Double
                                        .valueOf(valorbilhete2_vinculado);
                        valorsomado = valor2 + valor1;
                } else {

                        if (logado) {
                                wait
                                                .until(d -> EcommercePOAntigo.finalizarPedido
                                                                .isDisplayed());
                                resulBilhete1 = new StringTokenizer(EcommercePOAntigo
                                                .valorTotalDoBilhete(3, driver));
                        } else {
                                wait
                                                .until(d -> EcommercePOAntigo.valorSomado
                                                                .isDisplayed());
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
                }
                logger
                                .info("Verifica o valor do bilhete...");
                String Captcha = null;
                if (valor1 == 10.00 || valor1 == 70.00 || valor1 == 20.00 || valorsomado == 7.50
                                || valorsomado == 20.00) {
                        if (logado) {

                        } else {
                                logger
                                                .info("Logando na conta do usuario...");
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
                                try {
                                        Thread
                                                        .sleep(4000);
                                        Captcha = EcommercePOAntigo.pegarMensagemErro
                                                        .getText();
                                } catch (Exception e) {
                                }
                        }
                        if (Captcha == null) {
                                logger
                                                .info("Finalizar pedido...");
                                wait
                                                .until(d -> EcommercePOAntigo.finalizarPedido
                                                                .isDisplayed());
                                EcommercePOAntigo.finalizarPedido
                                                .click();
                                int MESTERMINO = 13;
                                int MESINICIO = 13;
                                String data1 = null;
                                String resto = null;
                                String data2 = null;
                                String dia1 = null;
                                int DIA1 = 13;
                                String mes1 = null;
                                int MES1 = 13;
                                String ano1 = null;
                                int ANO1 = 13;
                                String dia2 = null;
                                int DIA2 = 13;
                                String mes2 = null;
                                int MES2 = 13;
                                String ano2 = null;
                                int ANO2 = 13;
                                if (tipo == 2) {
                                        wait
                                                        .until(d -> EcommercePOAntigo.datas
                                                                        .isDisplayed());
                                        StringTokenizer datas = new StringTokenizer(EcommercePOAntigo.datas
                                                        .getText());
                                        data1 = datas
                                                        .nextToken("-");
                                        resto = datas
                                                        .nextToken("-");
                                        StringTokenizer fds = new StringTokenizer(resto);
                                        data2 = fds
                                                        .nextToken(" ");

                                        StringTokenizer Data1 = new StringTokenizer(data1);
                                        dia1 = Data1
                                                        .nextToken("/");
                                        DIA1 = Integer
                                                        .parseInt(dia1);
                                        mes1 = Data1
                                                        .nextToken("/");
                                        MES1 = Integer
                                                        .parseInt(mes1);
                                        ano1 = Data1
                                                        .nextToken("/");
                                        ano1 = ano1
                                                        .replaceAll(" ", "");
                                        ANO1 = Integer
                                                        .parseInt(ano1);

                                        StringTokenizer Data2 = new StringTokenizer(data2);
                                        dia2 = Data2
                                                        .nextToken("/");
                                        DIA2 = Integer
                                                        .parseInt(dia2);
                                        mes2 = Data2
                                                        .nextToken("/");
                                        MES2 = Integer
                                                        .parseInt(mes2);
                                        ano2 = Data2
                                                        .nextToken("/");
                                        ano2 = ano2
                                                        .replaceAll(" ", "");
                                        ANO2 = Integer
                                                        .parseInt(ano2);

                                        if (MesInicio
                                                        .equals("Jan")) {
                                                MESINICIO = 1;
                                        } else if (MesInicio
                                                        .equals("Feb")) {
                                                MESINICIO = 2;
                                        } else if (MesInicio
                                                        .equals("Mar")) {
                                                MESINICIO = 3;
                                        } else if (MesInicio
                                                        .equals("Apr")) {
                                                MESINICIO = 4;
                                        } else if (MesInicio
                                                        .equals("May")) {
                                                MESINICIO = 5;
                                        } else if (MesInicio
                                                        .equals("Jun")) {
                                                MESINICIO = 6;
                                        } else if (MesInicio
                                                        .equals("Jul")) {
                                                MESINICIO = 7;
                                        } else if (MesInicio
                                                        .equals("Ago")) {
                                                MESINICIO = 8;
                                        } else if (MesInicio
                                                        .equals("Sep")) {
                                                MESINICIO = 9;
                                        } else if (MesInicio
                                                        .equals("Oct")) {
                                                MESINICIO = 10;
                                        } else if (MesInicio
                                                        .equals("Nov")) {
                                                MESINICIO = 11;
                                        } else if (MesInicio
                                                        .equals("Dec")) {
                                                MESINICIO = 12;
                                        }

                                        if (MesTermino
                                                        .equals("Jan")) {
                                                MESTERMINO = 1;
                                        } else if (MesTermino
                                                        .equals("Feb")) {
                                                MESTERMINO = 2;
                                        } else if (MesTermino
                                                        .equals("Mar")) {
                                                MESTERMINO = 3;
                                        } else if (MesTermino
                                                        .equals("Apr")) {
                                                MESTERMINO = 4;
                                        } else if (MesTermino
                                                        .equals("May")) {
                                                MESTERMINO = 5;
                                        } else if (MesTermino
                                                        .equals("Jun")) {
                                                MESTERMINO = 6;
                                        } else if (MesTermino
                                                        .equals("Jul")) {
                                                MESTERMINO = 7;
                                        } else if (MesTermino
                                                        .equals("Ago")) {
                                                MESTERMINO = 8;
                                        } else if (MesTermino
                                                        .equals("Sep")) {
                                                MESTERMINO = 9;
                                        } else if (MesTermino
                                                        .equals("Oct")) {
                                                MESTERMINO = 10;
                                        } else if (MesTermino
                                                        .equals("Nov")) {
                                                MESTERMINO = 11;
                                        } else if (MesTermino
                                                        .equals("Dec")) {
                                                MESTERMINO = 12;
                                        }
                                }
                                logger
                                                .info("Verificando data de inicio e de termino da visita...");
                                if (DIAINICIO == DIA1 && DIATERMINO == DIA2 && MESINICIO == MES1 && MESTERMINO == MES2
                                                && ANOINICIO == ANO1 && ANOTERMINO == ANO2 || tipo != 2) {
                                        logger
                                                        .info("Colocando dados para realizar o pagamento...");
                                        wait
                                                        .until(d -> EcommercePOAntigo.Nome_Do_Cartao
                                                                        .isDisplayed());

                                        EcommercePOAntigo.Nome_Do_Cartao
                                                        .sendKeys(Nome_Cartao);

                                        EcommercePOAntigo.Numero_Cartao
                                                        .sendKeys(Numero_Cartao);

                                        EcommercePOAntigo.Mes_Validade
                                                        .sendKeys(mes_validade);

                                        EcommercePOAntigo.codigo_segurança
                                                        .sendKeys(codigo_segurança);

                                        EcommercePOAntigo.CEP
                                                        .sendKeys(CEP);

                                        EcommercePOAntigo.Numero_Casa
                                                        .sendKeys(Numero_Casa);
                                        try {
                                                Thread
                                                                .sleep(1000);
                                        } catch (InterruptedException e) {
                                                e
                                                                .printStackTrace();
                                        }
                                        logger
                                                        .info("Finalizar compra...");
                                        EcommercePOAntigo.finalizarCompra
                                                        .click();

                                        wait
                                                        .until(d -> EcommercePOAntigo.confirmarCompra
                                                                        .isDisplayed());
                                        String mensagem = EcommercePOAntigo.confirmarCompra
                                                        .getText();
                                        assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.",
                                                        mensagem);
                                        logger
                                                        .info("Compra fializada...");
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
                                                .executeScript("alert('ERRO: VALOR INVALIDO DO BILHETE');");

                        }

                } else {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js
                                        .executeScript("alert('ERRO: VALOR INVALIDO DO BILHETE!');");

                }
        }

        public FundacaoBuilder(EcommercePOAntigo e) {
                this.EcommercePOAntigo = e;
        }

        public FundacaoBuilder mudarNome_Cartao(String nome) {
                this.Nome_Cartao = nome;
                return this;
        }

        public FundacaoBuilder mudarNumero_Cartao(String numero) {
                this.Numero_Cartao = numero;
                return this;
        }

        public FundacaoBuilder mudarMes_validade(String mes) {
                this.mes_validade = mes;
                return this;
        }

        public FundacaoBuilder mudarsenha_usuario(String senha) {
                this.senha_usuario = senha;
                return this;
        }

        public FundacaoBuilder mudarCodigo_Segurança(String codigo) {
                this.codigo_segurança = codigo;
                return this;
        }

        public FundacaoBuilder mudarCEP(String cep) {
                this.CEP = cep;
                return this;
        }

        public FundacaoBuilder mudarNumero_Casa(String numero_Casa) {
                this.Numero_Casa = numero_Casa;
                return this;
        }

}
