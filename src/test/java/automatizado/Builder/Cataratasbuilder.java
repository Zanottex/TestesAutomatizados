package automatizado.Builder;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.EcommercePO;

public class Cataratasbuilder {

    private EcommercePO ECommercePO;
    private String email_usuario = "gustavozanotto119@gmail.com";
    private String senha_usuario = "1";
    private String Nome_Cartao = "Gustavin Zanottin";
    private String Numero_Cartao = "4000000000000010";
    private String mes_validade = "122500";
    private String codigo_segurança = "123";
    private String CEP = "85509432";
    private String Numero_Casa = "1050";
    private String cpf = "09285844960";

    public void Ingresso(WebDriver driver, int tipo) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);
        wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
        ECommercePO.aceitarcookies.click();
        if (tipo == 1) {
            ECommercePO.barraDePesquisa.sendKeys("Ingresso Brasileiro/Mercosul");
        } else if(tipo == 2){
            ECommercePO.barraDePesquisa.sendKeys("Ingresso Estrangeiro");
        }else if(tipo == 3){
            ECommercePO.barraDePesquisa.sendKeys("Ingresso Experiências");
        }
        wait.until(d -> ECommercePO.bilhete_a_venda_grupo1.isDisplayed());
        ECommercePO.bilhete_a_venda_grupo1.click();
        wait.until(d -> ECommercePO.ProximoMes.isDisplayed());
        ECommercePO.ProximoMes.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(d -> ECommercePO.dia.isEnabled());
        ECommercePO.dia.click();

        wait.until(d -> ECommercePO.localEmbarque.isDisplayed());
        ECommercePO.localEmbarque.click();
        ECommercePO.localEmbarqueConfirmar.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(d -> ECommercePO.horario.isDisplayed());
        ECommercePO.horario.click();
        ECommercePO.confirmarHorario4opcoes.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ECommercePO.proximo.click();

        wait.until(d -> ECommercePO.adicionarCategoria.isDisplayed());
        ECommercePO.adicionarCategoria.click();
        ECommercePO.selecionarPaisOrigem.click();
        if (tipo == 1) {
            ECommercePO.paiserradoIntegrada.click();
        } else if(tipo == 2){
            ECommercePO.confirmaPaisOrigem.click();
            ECommercePO.estado.click();
            ECommercePO.acre.click();
        }

        ECommercePO.adicionarAoCarrinho.click();

        wait.until(d -> ECommercePO.pegarMensagemErro.isDisplayed());
        String erro = null;
        try {
            erro = ECommercePO.pegarMensagemErro.getText();
        } catch (Exception e) {

        }
        int verdadeiro = erro.compareTo("Selecione ao menos uma categoria pagante");
        if (verdadeiro == 0) {

            ECommercePO.adicionarCategoria2.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ECommercePO.adicionarAoCarrinho.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String erro2 = null;
            try {
                erro2 = ECommercePO.pegarMensagemErro.getText();
            } catch (Exception e) {

            }

            int verdadeiro2 = 1;
            if (tipo == 1) {
                wait.until(d -> ECommercePO.pegarMensagemErro.isDisplayed());
                verdadeiro2 = erro2.compareTo("País: Estados Unidos não é válido");
            } else if(tipo == 2){
                wait.until(d -> ECommercePO.pegarMensagemErro.isDisplayed());
                verdadeiro2 = erro2.compareTo("País: Brasil não é válido");
            }else if(tipo == 3){
                verdadeiro2 = 0;
            }

            if (verdadeiro2 == 0) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(tipo != 3){
                ECommercePO.selecionarPaisOrigem.click();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (tipo == 1) {
                    
                    ECommercePO.confirmaPaisOrigemIntegrada.click();
                    ECommercePO.estado.click();
                    ECommercePO.acre.click();
                    
                } else {
                    ECommercePO.paiserradoIntegrada.click();
                }
            }
                ECommercePO.adicionarAoCarrinho.click();
                
                wait.until(d -> ECommercePO.valorBilhete1.isDisplayed());
                StringTokenizer resulBilhete1 = new StringTokenizer(ECommercePO.valorBilhete1.getText());
                String valorbilhete1 = resulBilhete1.nextToken(" ");
                valorbilhete1 = resulBilhete1.nextToken(" ");
                valorbilhete1 = valorbilhete1.replaceAll(",", ".");
                Double valor1 = Double.valueOf(valorbilhete1);

                if (valor1 == 10.00) {
                    wait.until(d -> ECommercePO.registrarEfinalizarPedido.isDisplayed());
                    ECommercePO.registrarEfinalizarPedido.click();

                    wait.until(d -> ECommercePO.Email_ecommerce.isDisplayed());
                    ECommercePO.Email_ecommerce.sendKeys(email_usuario);
                    ECommercePO.senha_ecommerce.sendKeys(senha_usuario);
                    ECommercePO.Logar.click();

                    wait.until(d -> ECommercePO.finalizarPedido.isDisplayed());
                    ECommercePO.finalizarPedido.click();

                    wait.until(d -> ECommercePO.EscreverConfirmarSenha.isDisplayed());
                    ECommercePO.EscreverConfirmarSenha.sendKeys("1");
                    ECommercePO.botaoConfirmarSenha.click();

                    wait.until(d -> ECommercePO.Nome_Do_Cartao.isDisplayed());

                    ECommercePO.Nome_Do_Cartao.sendKeys(Nome_Cartao);

                    ECommercePO.Numero_Cartao.sendKeys(Numero_Cartao);

                    ECommercePO.Mes_Validade.sendKeys(mes_validade);

                    ECommercePO.codigo_segurança.sendKeys(codigo_segurança);

                    ECommercePO.CEP.sendKeys(CEP);

                    ECommercePO.Numero_Casa.sendKeys(Numero_Casa);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    ECommercePO.finalizarCompra.click();

                    wait.until(d -> ECommercePO.confirmarCompra.isDisplayed());
                    String mensagem = ECommercePO.confirmarCompra.getText();
                    assertEquals(
                            "Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.",
                            mensagem);
                } else {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("alert('ERRO: VALOR DO BILHETE INVÁLIDO');");
                }
            } else {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("alert('ERRO: PAIS INVALIDO');");
            }
        } else {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert('ERRO: CATEGORIA PAGANTE NÃO SELECIONADA');");
        }

    }

    public Cataratasbuilder(EcommercePO e) {
        this.ECommercePO = e;
    }
}