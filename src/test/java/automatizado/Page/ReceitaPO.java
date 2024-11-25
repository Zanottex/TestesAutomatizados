package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReceitaPO extends BasePO{

    @FindBy(css = "[formcontrolname=\"nome\"]")
    public WebElement nomeReceita;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-receita/div[1]/mat-card/div/mat-form-field[2]/div[1]")
    public WebElement estabReceita;

    @FindBy(css = "ngx-mat-select-search>div>div>input")
    public WebElement nomeEstab;

    @FindBy(id = "mat-option-284")
    public WebElement confirmaEstab;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-receita/div[2]/buttons/div/div/button[2]")
    public WebElement salvarReceita;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-receita/div[1]/mat-card/div/mat-form-field[3]/div[1]/div/div[2]/mat-select/div/div[1]/span")
    public WebElement tipoIngresso;

    @FindBy(id = "mat-option-2")
    public WebElement SelecionatipoIngresso;

    @FindBy(xpath = "html/body/div[3]/div/div/mat-snack-bar-container/div/div/div/div/simple-snack-bar/div[1]")
    public WebElement spanMensagem;

    public ReceitaPO(WebDriver driver) {
        super(driver);
    }
}
