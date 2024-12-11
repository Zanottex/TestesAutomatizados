package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GrupoDeBilhetesPO extends BasePO{
    
    public GrupoDeBilhetesPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/ng-component/div/mat-card/mat-form-field[1]/div[1]/div/div[2]/input")
    public WebElement nomeGrupo;

    @FindBy(css = "ngx-mat-select-search>div>div>input")
    public WebElement nomeEstab;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/ng-component/div/div[2]/buttons/div/div/button[2]")
    public WebElement salvarGrupo;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/ng-component/div/mat-card/mat-form-field[2]/div[1]")
    public WebElement estab;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/mat-option[2]")
    public WebElement confirmaEstab;

}
