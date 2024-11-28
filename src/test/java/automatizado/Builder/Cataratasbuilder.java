package automatizado.Builder;

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

    public void Brasileiro_Mercosul(WebDriver driver){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
        ECommercePO.aceitarcookies.click();
        ECommercePO.barraDePesquisa.sendKeys("Ingresso Brasileiro/Mercosul");
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

        wait.until(d -> ECommercePO.proximo.isDisplayed());
        ECommercePO.proximo.click();

        wait.until(d -> ECommercePO.adicionarCategoria.isDisplayed());
        ECommercePO.adicionarCategoria.click();
        ECommercePO.selecionarPaisOrigem.click();
        ECommercePO.paiserrado.click();
        ECommercePO.adicionarAoCarrinho.click();

        wait.until(d -> ECommercePO.pegarMensagemErro.isDisplayed());
        String erro = null;
        try {
          erro = ECommercePO.pegarMensagemErro.getText();
        } catch (Exception e) {
            
        }
        int verdadeiro = erro.compareTo("Selecione ao menos uma categoria pagante");
        if(verdadeiro == 0){
            
            ECommercePO.adicionarCategoria2.click();
            ECommercePO.adicionarAoCarrinho.click();
            String erro2 = null;
            try {
             erro2 = ECommercePO.pegarMensagemErro.getText();
            } catch (Exception e) {
            
            }
            wait.until(d -> ECommercePO.pegarMensagemErro.isDisplayed());
            int verdadeiro2 = erro2.compareTo("País: Angola não é válido");

            if(verdadeiro2 == 0){
                ECommercePO.selecionarPaisOrigem.click();
                ECommercePO.confirmaPaisOrigem.click();
                ECommercePO.adicionarAoCarrinho.click();

                wait.until(d -> ECommercePO.valorBilhete1.isDisplayed());
                StringTokenizer resulBilhete1 = new StringTokenizer(ECommercePO.valorBilhete1.getText());
                String valorbilhete1 = resulBilhete1.nextToken(" ");
                valorbilhete1 = resulBilhete1.nextToken(" ");
                valorbilhete1 = valorbilhete1.replaceAll(",", ".");
                Double valor1 = Double.valueOf(valorbilhete1);
                
                if(valor1 == 10.00){
                    
                }
                else{
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("alert('ERRO: VALOR DO BILHETE INVÁLIDO');");
                }
            }
            else{
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("alert('ERRO: PAIS INVALIDO PARA A CATEGORIA!');");
            }
        }
        else{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert('ERRO: NÃO FOI SELECIONADO CATEGORIA PAGANTE!');");
        }



    }

    public Cataratasbuilder (EcommercePO e ){
        this.ECommercePO = e;
    }
}
