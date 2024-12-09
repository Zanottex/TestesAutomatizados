package automatizado.Builder;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.omg.CORBA.INTERNAL;
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
    private String Numero_Cartao = geradores
            .geradorNumeroCartao();
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
                    .info("Iniciando pesquisa: Serviços Especiais");
            ECommercePO.barraDePesquisa
                    .sendKeys("Serviços Especiais");
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
                            .sleep(1000);
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
                wait
                        .until(d -> ECommercePO.dia3Receitas
                                .isEnabled());
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

            if (tipo != 3 && tipo != 4 && tipo != 5 && tipo != 6) {
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

            logger
                    .info("Selecionando Horario...");
            if (i == 0) {
                wait
                        .until(d -> ECommercePO.horario
                                .isDisplayed());
                ECommercePO.horario
                        .click();
                ECommercePO.confirmarHorario4opcoes
                        .click();
                try {
                    Thread
                            .sleep(1500);
                } catch (InterruptedException e) {
                    e
                            .printStackTrace();
                }
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
                ECommercePO.horario2Receitas
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

        if (tipo == 1 || tipo == 2 || tipo == 5 || tipo == 6) {
            logger
                    .info("Selecionando país de origem...");

            if (tipo == 1) {
                ECommercePO.selecionarPaisOrigem
                        .click();
                ECommercePO.paiserradoIntegrada
                        .click();
            } else if (tipo == 2) {
                ECommercePO.selecionarPaisOrigem
                        .click();
                ECommercePO.confirmaPaisOrigemIntegrada
                        .click();
                ECommercePO.estado
                        .click();
                ECommercePO.acre
                        .click();
            } else if (tipo == 5) {
                ECommercePO.selecionarPaisOrigem_2Rec
                        .click();
                ECommercePO.confirmaPaisOrigemIntegrada
                        .click();
                ECommercePO.estado_2Rec
                        .click();
                ECommercePO.acre
                        .click();
            } else if (tipo == 6) {
                ECommercePO.selecionarPaisOrigem_3Rec
                        .click();
                ECommercePO.confirmaPaisOrigemIntegrada
                        .click();
                ECommercePO.estado_3Rec
                        .click();
                ECommercePO.acre
                        .click();
            }
        }

        int verdadeiro = 0;
        if (tipo != 4) { // SE FOR 1,2 OU 3 ELE ENTRA
            if (tipo == 5) {
                ECommercePO.adicionarAoCarrinho_2Rec
                        .click();
            } else if (tipo == 6) {
                ECommercePO.adicionarAoCarrinho_3Rec
                        .click();
            }
            verdadeiro = 1;
            wait
                    .until(d -> ECommercePO.pegarMensagemErro
                            .isDisplayed());
            String erro = null;
            try {
                erro = ECommercePO.pegarMensagemErro
                        .getText();
            } catch (Exception e) {
            }
            verdadeiro = erro
                    .compareTo("Selecione ao menos uma categoria pagante");
            logger
                    .info("Trocando Selecionando um pais válido");
        }

        if (verdadeiro == 0) {
            int verdadeiro2 = 0;
            if (tipo != 4) { // SE FOR DIFERENTE DE 4 ENTRAR
                if (tipo == 5) {
                    ECommercePO.adicionarCategoria2_2Rec
                            .click();
                } else if (tipo == 6) {
                    ECommercePO.adicionarCategoria2_3Rec
                            .click();
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

                if (tipo != 3 && tipo != 5 && tipo != 6) {
                    String erro2 = null;
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

                    verdadeiro2 = 1;
                    if (tipo == 1) {
                        wait
                                .until(d -> ECommercePO.pegarMensagemErro
                                        .isDisplayed());
                        verdadeiro2 = erro2
                                .compareTo("País: Estados Unidos não é válido");
                    } else if (tipo == 2) {
                        wait
                                .until(d -> ECommercePO.pegarMensagemErro
                                        .isDisplayed());
                        verdadeiro2 = erro2
                                .compareTo("País: Brasil não é válido");
                    } else if (tipo == 3 || tipo == 4 || tipo == 5 || tipo == 6) {
                        verdadeiro2 = 0;
                    }
                }
            }
            if (verdadeiro2 == 0) {
                try {
                    Thread
                            .sleep(5000);
                } catch (InterruptedException e) {
                    e
                            .printStackTrace();
                }
                if (tipo == 1 || tipo == 2) {
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

                        ECommercePO.confirmaPaisOrigemIntegrada
                                .click();
                        ECommercePO.estado
                                .click();
                        ECommercePO.acre
                                .click();

                    } else {
                        ECommercePO.paiserradoIntegrada
                                .click();
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

                if (tipo == 5 || tipo == 6) {
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

                if (valor1 == 10.00) {
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
                            .info("Preenchendo informações de pagamento: " + " Nome Impresso no Cartão: " + Nome_Cartao
                                    + ", Numero do cartão: " + Numero_Cartao + ", Mes de validade: " + mes_validade
                                    + ", Codifo de Segurança " + codigo_segurança + "...");

                    ECommercePO.CEP
                            .sendKeys(CEP);

                    ECommercePO.Numero_Casa
                            .sendKeys(Numero_Casa);

                    ECommercePO.bandeiracartao
                            .click();
                    ECommercePO.visa
                            .click();
                    logger
                            .info("Preenchendo endereço: CEP: " + CEP + ", Numero da Casa: " + Numero_Casa + "...");
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
        } else {
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