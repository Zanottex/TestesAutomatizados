package automatizado.Builder.CARD;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.PerfilDeVendaPO;

public class PerfilDeVendaBuilder {
    
    private String nomePerfil = "Perfil 1";
    private String nomeEstab = "Bilheteria Zanotto";
    private String NomePerfil = "E-commerce Zanotto";
    private String NomeBilhete = "5150";
    private String QrCode = "BZ";
    private PerfilDeVendaPO perfilPO;

    public PerfilDeVendaBuilder(PerfilDeVendaPO perfil){
        this.perfilPO = perfil;
    }

    public PerfilDeVendaBuilder mudarNome(String nome){
        this.nomePerfil = nome;
        return this;
    }

    public PerfilDeVendaBuilder mudarEstab(String Estab){
        this.nomeEstab = Estab;
        return this;
    }

    public PerfilDeVendaBuilder mudarQrCode(String qrcode){
        this.QrCode = qrcode;
        return this;
    }

    public PerfilDeVendaBuilder mudarNomeBilhete(String nomeBilhete){
        this.NomeBilhete = nomeBilhete;
        return this;
    }

    public PerfilDeVendaBuilder mudarNomePerfil(String perfil){
        this.NomePerfil = perfil;
        return this;
    }

    public void builder(WebDriver driver){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);
        wait.until(d -> perfilPO.nomePerfil.isDisplayed());
        perfilPO.nomePerfil.sendKeys(nomePerfil);
        perfilPO.Estabelecimento.click();
        wait.until(d -> perfilPO.nomeEstab.isDisplayed());
        perfilPO.nomeEstab.sendKeys(nomeEstab);

        wait.until(d -> perfilPO.confirmaEstab.isDisplayed());
        perfilPO.confirmaEstab.click();

        wait.until(d -> perfilPO.ModoDePagamento.isDisplayed());
        perfilPO.ModoDePagamento.click();
        wait.until(d -> perfilPO.ConfirmaModo.isDisplayed());
        perfilPO.ConfirmaModo.click();
        perfilPO.QrCode.sendKeys(QrCode);
        perfilPO.SalvarPerfil.click();
    }

    public void ColocarBilhete(WebDriver driver){
        
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        perfilPO.Filtro.sendKeys(NomePerfil);
        perfilPO.SelecionarPerfil.click();
        perfilPO.Bilhetes.click();
        perfilPO.NomeBilhete.clear();
        perfilPO.NomeBilhete.sendKeys(NomeBilhete);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        perfilPO.AdicionarBilhete.click();
        perfilPO.SalvarPerfil2.click();

        wait.until(d -> perfilPO.spanMensagem.isDisplayed());
        String mensagem = perfilPO.acharMensagem();
        assertEquals("Perfil salvo com sucesso", mensagem);
    }
}
