package automatizado.Builder;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.EcommercePO;
import automatizado.Generators.geradores;

public class AquaRioBuilder {

    private EcommercePO ECommercePO;
    private String email_usuario = "gustavozanotto119@gmail.com";
    private String senha_usuario = "1";
    private String Nome_Cartao = geradores.geradorNome();;
    private String Numero_Cartao = geradores.geradorNumeroCartao();
    private String mes_validade = geradores.geradorValidadeCartao();
    private String codigo_segurança = geradores.geradorCodigoSeguranca();
    private String CEP = geradores.geradorCEP();
    private String Numero_Casa = geradores.geradorNumeroCasa(); 
    private String cpf = geradores.geradorCPF(); 
    
    public AquaRioBuilder(EcommercePO ecommercePO){
        this.ECommercePO = ecommercePO;
    }

    public void venda_padrao(WebDriver driver){

         Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

         wait.until(d -> ECommercePO.aceitarcookies.isDisplayed());
         ECommercePO.aceitarcookies.click();

         wait.until(d -> ECommercePO.proximoMesHome.isEnabled());
         ECommercePO.proximoMesHome.click();

         wait.until(d -> ECommercePO.diaHome.isDisplayed());
         ECommercePO.diaHome.click();

         wait.until(d -> ECommercePO.continuar.isEnabled());
         ECommercePO.continuar.click();

         wait.until(d -> ECommercePO.horarioPopUp.isDisplayed());
         ECommercePO.horarioPopUp.click();

         wait.until(d -> ECommercePO.horarioPopUp.isDisplayed());
         ECommercePO.horarioPopUp.click();

         wait.until(d -> ECommercePO.categoriaPopUp.isDisplayed());
         ECommercePO.categoriaPopUp.click();

         ECommercePO.PaisDeOrigemPopUP.click();
         ECommercePO.BrasilPopUp.click();

         ECommercePO.CEP.click();
         ECommercePO.CEP.sendKeys(CEP);

         ECommercePO.EstadoPopUp.click();
         wait.until(d -> ECommercePO.AcrePopUp.isDisplayed());
         ECommercePO.AcrePopUp.click();

         ECommercePO.adicionarAoCarrinhoPopUP.click();

         wait.until(d -> ECommercePO.nomeUsuarioPopUp.isDisplayed());
        ECommercePO.nomeUsuarioPopUp.sendKeys(Nome_Cartao);
        ECommercePO.tipoDocumentoPopUp.click();
        wait.until(d -> ECommercePO.outrosPopUp.isDisplayed());
        ECommercePO.outrosPopUp.click();
        ECommercePO.documentoPopUp.sendKeys(cpf);

        ECommercePO.confirmardadosdoUsuarioPopUp.click();

        wait.until(d -> ECommercePO.valorBilhete1.isDisplayed());
        StringTokenizer resulBilhete1 = new StringTokenizer(ECommercePO.valorBilhete1.getText());
        String valorbilhete1 = resulBilhete1.nextToken(" ");
         valorbilhete1 = resulBilhete1.nextToken(" ");
         valorbilhete1 = valorbilhete1.replaceAll(",", ".");
         Double valor1 = Double.valueOf(valorbilhete1);

         if(valor1 == 10.0){

            ECommercePO.registrarEfinalizarPedido.click();
        wait.until(d -> ECommercePO.Email_ecommerce.isDisplayed());
            ECommercePO.Email_ecommerce.sendKeys(email_usuario);
            ECommercePO.senha_ecommerce.sendKeys(senha_usuario);
            ECommercePO.Logar.click();

        wait.until(d -> ECommercePO.finalizarPedido.isDisplayed());
        ECommercePO.finalizarPedido.click();

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
        assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.", mensagem);
         }
    }

}
