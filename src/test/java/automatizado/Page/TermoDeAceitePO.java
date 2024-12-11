package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TermoDeAceitePO extends BasePO{

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/neworedittermoaceite/div[1]/mat-card/mat-tab-group/div/mat-tab-body[1]/div/div/mat-form-field/div[1]/div/div[2]/input")
    public WebElement nomeTermo;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/neworedittermoaceite/div[1]/mat-card/mat-tab-group/div/mat-tab-body[1]/div/div/mat-card/angular-editor/div/div/div")
    public WebElement TextoTermo;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/neworedittermoaceite/div[1]/mat-card/mat-tab-group/mat-tab-header/div/div/div/div[2]")
    public WebElement Permissao;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/neworedittermoaceite/div[1]/mat-card/mat-tab-group/div/mat-tab-body[2]/div/div/lista-permissoes/div/title-btn-add/div/button")
    public WebElement AdicionarestabAcesso;

    @FindBy(css = "mat-form-field>div>div>div>input")
    public WebElement estabAcesso;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/add-permissao-acesso-dialog/div/table-with-selection/div/div[2]/cdk-virtual-scroll-viewport/div[1]/table/tbody/tr[1]/td[1]/mat-checkbox/div/div/input")
    public WebElement ConfirmaEstab;

    @FindBy(css = "add-permissao-acesso-dialog > div > div > button.mdc-button.mdc-button--raised.mat-mdc-raised-button.mat-primary.mat-mdc-button-base")
    public WebElement salvarEstab;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/neworedittermoaceite/div[2]/buttons/div/div/button[2]")
    public WebElement salvarTermo;


    public TermoDeAceitePO(WebDriver driver) {
        super(driver);

    }
}
