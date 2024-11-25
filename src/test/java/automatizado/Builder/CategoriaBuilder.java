package automatizado.Builder;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.CategoriaPO;

public class CategoriaBuilder {
    
    private String nomeCategoria = "Categoria Inteira";
    private String EstabAcesso = "Bilheteria Zanotto";
    public static WebDriver driver;

    public CategoriaBuilder(CategoriaPO categoriaPO){
        this.categoriaPO = categoriaPO;
    }

    public CategoriaBuilder Nome(String nome){
        this.nomeCategoria = nome;
        return this;
    }

    public CategoriaBuilder EstabAcesso(String estabAcesso){
        this.EstabAcesso = estabAcesso;
        return this;
    }

    private CategoriaPO categoriaPO;

    public void builder(WebDriver driver){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait.until(d -> categoriaPO.nomeCategoria.isDisplayed());
        categoriaPO.nomeCategoria.sendKeys(nomeCategoria);
        if(EstabAcesso == null){
        categoriaPO.salvarCategoria.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(d -> categoriaPO.spanMensagem.isDisplayed());
        String mensagem = categoriaPO.acharMensagem();
        assertEquals("Adicione pelo menos 1 permissão de acesso", mensagem);
        }
        else{
        wait.until(d -> categoriaPO.PermissãoDeAcesso.isDisplayed());
        categoriaPO.PermissãoDeAcesso.click();
        //wait.until(d -> categoriaPO.AdicionarestabAcesso.isDisplayed());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        categoriaPO.AdicionarestabAcesso.click();
        wait.until(d -> categoriaPO.estabAcesso.isDisplayed());
        categoriaPO.estabAcesso.sendKeys(EstabAcesso);
        categoriaPO.ConfirmaEstab.click();
        categoriaPO.salvarEstab.click();
        wait.until(d -> categoriaPO.salvarCategoria.isDisplayed());
        categoriaPO.salvarCategoria.click();

        wait.until(d -> categoriaPO.spanMensagem.isDisplayed());
        String mensagem = categoriaPO.acharMensagem();
        assertEquals("Categoria editada com sucesso", mensagem);
        }
    }
}
