package automatizado.Builder.CARD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.GrupoDeCategoriasPO;

public class GrupoDeCategoriasBuilder {
    private String nomeGrupo = "Grupo 1";
    private String nomeEstab = "Bilheteria Zanotto";
    private GrupoDeCategoriasPO grupoPO;

    public GrupoDeCategoriasBuilder(GrupoDeCategoriasPO grupoPO){
        this.grupoPO = grupoPO;
    }

    public GrupoDeCategoriasBuilder adicionarNome(String nome){
        this.nomeGrupo = nome;
        return this;
    }

    public GrupoDeCategoriasBuilder adicionarEstab(String nomeEstab){
        this.nomeEstab = nomeEstab;
        return this;
    }

    public void builder(WebDriver driver){
       
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);
        
        wait.until(d -> grupoPO.nomeGrupo.isDisplayed());
        grupoPO.nomeGrupo.sendKeys(nomeGrupo);
        grupoPO.estab.click();
        
        wait.until(d -> grupoPO.nomeEstab.isDisplayed());
        grupoPO.nomeEstab.sendKeys(nomeEstab);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        grupoPO.confirmaEstab.click();
        grupoPO.salvarGrupo.click();
    }
}
