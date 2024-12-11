package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriaPO extends BasePO{

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-categoria/div[2]/mat-card/mat-tab-group/div/mat-tab-body[1]/div/form/div/div[1]/div[2]/mat-form-field[1]/div[1]/div/div[2]/input")
    public WebElement nomeCategoria;

    @FindBy(css = "mat-form-field>div>div>div>input")
    public WebElement estabAcesso;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-categoria/div[2]/mat-card/mat-tab-group/div/mat-tab-body[2]/div/lista-permissoes/div/title-btn-add/div/button/span[4]")
    public WebElement AdicionarestabAcesso;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/add-permissao-acesso-dialog/div/table-with-selection/div/div[2]/cdk-virtual-scroll-viewport/div[1]/table/tbody/tr[1]/td[1]/mat-checkbox/div/div/input")
    public WebElement ConfirmaEstab;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-categoria/div[2]/mat-card/mat-tab-group/mat-tab-header/div/div/div/div[2]")
    public WebElement PermissãoDeAcesso;

    @FindBy(css = "add-permissao-acesso-dialog > div > div > button.mdc-button.mdc-button--raised.mat-mdc-raised-button.mat-primary.mat-mdc-button-base")
    public WebElement salvarEstab;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-categoria/div[3]/buttons/div/div/button[2]")
    public WebElement salvarCategoria;

    public CategoriaPO(WebDriver driver) {
        super(driver);
    }
}
