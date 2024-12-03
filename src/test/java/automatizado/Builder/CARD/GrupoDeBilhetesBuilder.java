package automatizado.Builder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.GrupoDeBilhetesPO;

public class GrupoDeBilhetesBuilder {
    
    private String nomeGrupo = "Grupo 1";
    private String nomeEstab = "Bilheteria Zanotto";
    private GrupoDeBilhetesPO grupoPO;

    public GrupoDeBilhetesBuilder(GrupoDeBilhetesPO grupoPO){
        this.grupoPO = grupoPO;
    }

    public GrupoDeBilhetesBuilder adicionarNome(String nome){
        this.nomeGrupo = nome;
        return this;
    }

    public GrupoDeBilhetesBuilder adicionarEstab(String nomeEstab){
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
        wait.until(d -> grupoPO.confirmaEstab.isDisplayed());
        grupoPO.confirmaEstab.click();
        grupoPO.salvarGrupo.click();
    }

}
