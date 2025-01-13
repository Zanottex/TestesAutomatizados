package automatizado.Builder;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import automatizado.Page.EcommercePO;

public class FundacaoBuilder {

    private EcommercePO ECommercePO;
    private String email_usuario = "gustavozanotto119@gmail.com";
    private String senha_usuario = "1";
    private String Nome_Cartao = "Gustavin Zanottin";

    private String Numero_Cartao = "4000000000000010";
    private String mes_validade = "122500";
    private String codigo_segurança = "123";
    private String CEP = "85509432";
    private String Numero_Casa = "1050";

    public void Builder(WebDriver driver, int tipo) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait
                .until(d -> ECommercePO.barraDePesquisa
                        .isDisplayed());
        ECommercePO.barraDePesquisa
                .sendKeys("Bilhete para fundação");
        ECommercePO.bilhete_a_venda_grupo1
                .click();
        try {
            try {
                Thread
                        .sleep(2000);
            } catch (InterruptedException e) {
                e
                        .printStackTrace();
            }

            ECommercePO.aceitarcookies
                    .click();
        } catch (Exception e) {
        }

        wait
                .until(d -> ECommercePO.barraDePesquisa
                        .isDisplayed());
        if (tipo == 1) {
            ECommercePO.barraDePesquisa
                    .sendKeys("Bilhete Fundação com sessão e embarque");
            ECommercePO.bilhete_a_venda_grupo1
                    .click();
        } else if (tipo == 2) {
            ECommercePO.barraDePesquisa
                    .sendKeys("Bilhete Multiplas Datas de Visita");
            try {
                Thread
                        .sleep(1000);
            } catch (InterruptedException e) {
                e
                        .printStackTrace();
            }
            ECommercePO.bilhete_a_venda_grupo1
                    .click();
        } else if (tipo == 3) {
            ECommercePO.barraDePesquisa
                    .sendKeys("Bilhete Credenciado");
            try {
                Thread
                        .sleep(1000);
            } catch (InterruptedException e) {
                e
                        .printStackTrace();
            }
            ECommercePO.bilhete_a_venda_grupo2
                    .click();
        } else if (tipo == 4) {
            ECommercePO.barraDePesquisa
                    .sendKeys("Bilhete Vinculado 1");
            try {
                Thread
                        .sleep(1000);
            } catch (InterruptedException e) {
                e
                        .printStackTrace();
            }
            ECommercePO.bilhete_a_venda_grupo1
                    .click();
        } else if (tipo == 5) {
            ECommercePO.barraDePesquisa
                    .sendKeys("Bilhete Desconto Progressivo");
            ECommercePO.bilhete_a_venda_grupo1
                    .click();
        } else if (tipo == 6) {

            ECommercePO.barraDePesquisa
                    .sendKeys("Bilhete quantidade mínima");
            try {
                Thread
                        .sleep(1000);
            } catch (InterruptedException e) {
                e
                        .printStackTrace();
            }
            ECommercePO.bilhete_a_venda_grupo1
                    .click();
        }

        wait
                .until(d -> ECommercePO.ProximoMes
                        .isDisplayed());
        ECommercePO.ProximoMes
                .click();

        try {
            Thread
                    .sleep(3000);
        } catch (InterruptedException e) {
            e
                    .printStackTrace();
        }

        wait
                .until(d -> ECommercePO.dia
                        .isDisplayed());
        ECommercePO.dia
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
            ECommercePO.diaFim
                    .click();

            wait
                    .until(d -> ECommercePO.DiaInicio
                            .isDisplayed());
            diaInicio = ECommercePO.DiaInicio
                    .getText();
            DIAINICIO = Integer
                    .parseInt(diaInicio);
            diaTermino = ECommercePO.DiaTermino
                    .getText();
            DIATERMINO = Integer
                    .parseInt(diaTermino);
            MesInicio = ECommercePO.MesInicio
                    .getText();
            MesTermino = ECommercePO.MesTermino
                    .getText();
            AnoInicio = ECommercePO.AnoInicio
                    .getText();
            ANOINICIO = Integer
                    .parseInt(AnoInicio);
            AnoTermino = ECommercePO.AnoTermino
                    .getText();
            ANOTERMINO = Integer
                    .parseInt(AnoTermino);
        }

        wait
                .until(d -> ECommercePO.localEmbarque
                        .isDisplayed());
        ECommercePO.localEmbarque
                .click();
        ECommercePO.localEmbarqueConfirmar
                .click();

        if (tipo == 3) {
            wait
                    .until(d -> ECommercePO.CódigoCredenciado
                            .isDisplayed());
            ECommercePO.CódigoCredenciado
                    .click();

            ECommercePO.ColocarCódigoCredenciado
                    .sendKeys("121525");
            ECommercePO.ConfirmarCredenciado
                    .click();
            wait
                    .until(d -> ECommercePO.ConfirmarCredenciado
                            .isDisplayed());
            ECommercePO.ConfirmarCredenciado
                    .click();
            try {
                Thread
                        .sleep(1000);
            } catch (InterruptedException e) {
                e
                        .printStackTrace();
            }
            wait
                    .until(d -> ECommercePO.horarioCredenciado
                            .isEnabled());
            ECommercePO.horarioCredenciado
                    .click();
            wait
                    .until(d -> ECommercePO.sessaoConfirmar
                            .isEnabled());
            ECommercePO.sessaoConfirmar
                    .click();

        } else {
            try {
                Thread
                        .sleep(6000);
            } catch (InterruptedException e) {
                e
                        .printStackTrace();
            }
            wait
                    .until(d -> ECommercePO.horario
                            .isDisplayed());
            ECommercePO.horario
                    .click();
            ECommercePO.confirmarHorario4opcoes
                    .click();
            ECommercePO.sessao
                    .click();
            wait
                    .until(d -> ECommercePO.sessaoConfirmar
                            .isEnabled());
            ECommercePO.sessaoConfirmar
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
                .until(d -> ECommercePO.proximo
                        .isEnabled());
        ECommercePO.proximo
                .click();

        wait
                .until(d -> ECommercePO.adicionarCategoria
                        .isDisplayed());
        ECommercePO.adicionarCategoria
                .click();

        ECommercePO.selecionarPaisOrigem
                .click();

        ECommercePO
                .Pais(14, driver);

        ECommercePO.adicionarAoCarrinho
                .click();

        try {
            Thread
                    .sleep(1000);
        } catch (InterruptedException e) {
            e
                    .printStackTrace();
        }
        String erro = ECommercePO.pegarMensagemErro
                .getText();
        double valorsomado = 0.0;
        if (erro != null) {
            ECommercePO.selecionarPaisOrigem
                    .click();
            try {
                Thread
                        .sleep(1000);
            } catch (InterruptedException e) {
                e
                        .printStackTrace();
            }
            ECommercePO
                    .Pais(11, driver);
            ECommercePO.estado
                    .click();
            ECommercePO.acre
                    .click();

            if (tipo == 5) {
                wait
                        .until(d -> ECommercePO.valorTotal_nasCategorias
                                .isDisplayed());
                StringTokenizer Result = new StringTokenizer(ECommercePO.valorTotal_nasCategorias
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
                    ECommercePO.adicionarCategoria
                            .click();
                    wait
                            .until(d -> ECommercePO.valorDesconto
                                    .isDisplayed());
                    Result = new StringTokenizer(ECommercePO.valorDesconto
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
                        ECommercePO.tirarcategoria1
                                .click();
                        ECommercePO.tirarcategoria1
                                .click();
                        ECommercePO.adicionarCategoria2Desconto
                                .click();
                        ECommercePO.adicionarCategoria2Desconto
                                .click();
                        wait
                                .until(d -> ECommercePO.valorDesconto
                                        .isDisplayed());
                        Result = new StringTokenizer(ECommercePO.valorDesconto
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
                            ECommercePO.tirarcategoria2
                                    .click();
                            ECommercePO.adicionarCategoria
                                    .click();

                            wait
                                    .until(d -> ECommercePO.valorDesconto
                                            .isDisplayed());
                            Result = new StringTokenizer(ECommercePO.valorDesconto
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
                                ECommercePO.adicionarAoCarrinho
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
                ECommercePO.tirarcategoria1
                        .click();

                boolean possivel = true;
                try {
                    possivel = ECommercePO.adicionarAoCarrinho
                            .isEnabled();
                } catch (Exception e) {
                }

                if (possivel == false) {

                    ECommercePO.adicionarCategoria
                            .click();
                    ECommercePO.adicionarAoCarrinho
                            .click();
                }
            } else {
                ECommercePO.adicionarAoCarrinho
                        .click();
            }
        }

        wait
                .until(d -> ECommercePO.nomeUsuario
                        .isDisplayed());
        ECommercePO
                .Nomeusuario(1, 1, "Gustavo Zanotto", driver);
        ECommercePO.tipodocumento
                .click();
        wait
                .until(d -> ECommercePO.outros
                        .isDisplayed());
        ECommercePO.outros
                .click();

        ECommercePO
                .valorDocumento(1, 1, "123456789", driver);

        if (tipo == 5) {
            ECommercePO
                    .Nomeusuario(2, 1, "Marcelo Leopoldo ", driver);
            ECommercePO
                    .tipoDocumento(2, 1, driver);
            wait
                    .until(d -> ECommercePO.outros
                            .isDisplayed());
            ECommercePO.outros
                    .click();

            ECommercePO
                    .valorDocumento(2, 1, "987654321", driver);
        } else if (tipo == 6) {
            ECommercePO
                    .Nomeusuario(1, 2, "Marcelo Leopoldo ", driver);
            ECommercePO
                    .tipoDocumento(1, 2, driver);
            wait
                    .until(d -> ECommercePO.outros
                            .isDisplayed());
            ECommercePO.outros
                    .click();

            ECommercePO
                    .valorDocumento(1, 2, "987654321", driver);
        }

        ECommercePO.confirmardadosusuario
                .click();

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
        StringTokenizer resulBilhete2 = null;
        if (tipo == 4) {
            if (logado) {
                wait
                        .until(d -> ECommercePO.finalizarPedido
                                .isDisplayed());
                resulBilhete1 = new StringTokenizer(ECommercePO
                        .ValorBilhete_1(2, driver));
                resulBilhete2 = new StringTokenizer(ECommercePO
                        .ValorBilhete_2_vinculado(2, driver));
            } else {
                wait
                        .until(d -> ECommercePO.registrarEfinalizarPedido
                                .isDisplayed());
                resulBilhete1 = new StringTokenizer(ECommercePO
                        .ValorBilhete_1(1, driver));
                resulBilhete2 = new StringTokenizer(ECommercePO
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
                        .until(d -> ECommercePO.finalizarPedido
                                .isDisplayed());
                resulBilhete1 = new StringTokenizer(ECommercePO
                        .valorTotalDoBilhete(3, driver));
            } else {
                wait
                        .until(d -> ECommercePO.valorSomado
                                .isDisplayed());
                resulBilhete1 = new StringTokenizer(ECommercePO.valorSomado
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

        if (valor1 == 10.00 || valor1 == 70.00 || valor1 == 20.00 || valorsomado == 7.50 || valorsomado == 20.00) {
            if (logado) {

            } else {
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
            }

            wait
                    .until(d -> ECommercePO.finalizarPedido
                            .isDisplayed());
            ECommercePO.finalizarPedido
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
                        .until(d -> ECommercePO.datas
                                .isDisplayed());
                StringTokenizer datas = new StringTokenizer(ECommercePO.datas
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

            if (DIAINICIO == DIA1 && DIATERMINO == DIA2 && MESINICIO == MES1 && MESTERMINO == MES2 && ANOINICIO == ANO1
                    && ANOTERMINO == ANO2 || tipo != 2) {
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

                ECommercePO.CEP
                        .sendKeys(CEP);

                ECommercePO.Numero_Casa
                        .sendKeys(Numero_Casa);
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
                assertEquals(
                        "Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.",
                        mensagem);

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

    public FundacaoBuilder(EcommercePO e) {
        this.ECommercePO = e;
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
