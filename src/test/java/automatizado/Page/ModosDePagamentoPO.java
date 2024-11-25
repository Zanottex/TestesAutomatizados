package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModosDePagamentoPO extends BasePO{
    
    public ModosDePagamentoPO(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-modo-pagamento/div[1]/mat-card/mat-tab-group/div/mat-tab-body[1]/div/div/mat-form-field[1]/div[1]/div/div[2]/input")
    public WebElement descrição;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-modo-pagamento/div[1]/mat-card/mat-tab-group/div/mat-tab-body[1]/div/div/mat-form-field[3]/div[1]/div/div[1]/div[2]")
    public WebElement estab;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/mat-option[1]/span/ngx-mat-select-search/div/div/input")
    public WebElement nomeEstab;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-modo-pagamento/div[1]/mat-card/mat-tab-group/mat-tab-header/div/div/div/div[3]")
    public WebElement Cartão;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-modo-pagamento/div[1]/mat-card/mat-tab-group/div/mat-tab-body[3]/div/div/div[1]/mat-form-field[1]/div[1]")
    public WebElement adquirente;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/mat-option[1]")
    public WebElement GetNet;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-modo-pagamento/div[1]/mat-card/mat-tab-group/div/mat-tab-body[3]/div/div/div[1]/mat-form-field[2]/div[1]")
    public WebElement ambiente;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/mat-option[1]/span")
    public WebElement homologação;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-modo-pagamento/div[1]/mat-card/mat-tab-group/div/mat-tab-body[3]/div/div/div[2]/mat-form-field[1]/div[1]/div/div[3]")
    public WebElement editarID;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-modo-pagamento/div[1]/mat-card/mat-tab-group/div/mat-tab-body[3]/div/div/div[2]/mat-form-field[1]/div[1]/div/div[2]/input")
    public WebElement ID;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-modo-pagamento/div[1]/mat-card/mat-tab-group/div/mat-tab-body[3]/div/div/div[2]/mat-form-field[2]/div[1]/div/div[3]")
    public WebElement editarautorização;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-modo-pagamento/div[1]/mat-card/mat-tab-group/div/mat-tab-body[3]/div/div/div[2]/mat-form-field[2]/div[1]/div/div[2]/input")
    public WebElement autorização;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-modo-pagamento/div[1]/mat-card/mat-tab-group/mat-tab-header/div/div/div/div[2]")
    public WebElement Permissoes;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-modo-pagamento/div[1]/mat-card/mat-tab-group/div/mat-tab-body[2]/div/lista-permissoes/div/title-btn-add/div/button")
    public WebElement adicionarPermissao;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-modo-pagamento/div[1]/mat-card/mat-tab-group/div/mat-tab-body[2]/div/lista-permissoes/div/title-btn-add/div/button")
    public WebElement AdicionarestabAcesso;

    @FindBy(css = "mat-form-field>div>div>div>input")
    public WebElement estabAcesso;

    @FindBy(css = "add-permissao-acesso-dialog > div > div > button.mdc-button.mdc-button--raised.mat-mdc-raised-button.mat-primary.mat-mdc-button-base")
    public WebElement salvarEstab;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/add-permissao-acesso-dialog/div/table-with-selection/div/div[2]/cdk-virtual-scroll-viewport/div[1]/table/tbody/tr[1]/td[1]/mat-checkbox/div/div/input")
    public WebElement ConfirmaEstab;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-modo-pagamento/div[2]/buttons/div/div/button[2]")
    public WebElement salvarModo;
    
}
