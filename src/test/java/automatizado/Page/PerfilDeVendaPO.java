package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PerfilDeVendaPO extends BasePO{
    
    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-new-or-edit-perfil/div[1]/mat-card/mat-tab-group/div/mat-tab-body[1]/div/div/block-with-title[1]/div/section/section/mat-form-field[1]/div[1]/div/div[2]/input")
    public WebElement nomePerfil;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-new-or-edit-perfil/div[1]/mat-card/mat-tab-group/div/mat-tab-body[1]/div/div/block-with-title[1]/div/section/section/mat-form-field[2]/div[1]")
    public WebElement Estabelecimento;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/mat-option[1]/span/ngx-mat-select-search/div/div/input")
    public WebElement nomeEstab;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/mat-option[2]")
    public WebElement confirmaEstab;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-new-or-edit-perfil/div[1]/mat-card/mat-tab-group/div/mat-tab-body[1]/div/div/block-with-title[2]/div/section/section/mat-form-field[1]/div[1]")
    public WebElement ModoDePagamento;

    @FindBy(css = "div>div>mat-option")
    public WebElement ConfirmaModo;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-new-or-edit-perfil/div[1]/mat-card/mat-tab-group/div/mat-tab-body[1]/div/div/block-with-title[5]/div/section/div/section[1]/mat-form-field/div[1]/div/div[2]/input")
    public WebElement QrCode;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-new-or-edit-perfil/div[2]/buttons/div/div/button[2]")
    public WebElement SalvarPerfil;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-new-or-edit-perfil/div[2]/buttons/div/div/button[3]")
    public WebElement SalvarPerfil2;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-perfil/lista-cadastros-com-busca/div/mat-card/div/table/tbody/tr[1]/td[7]/button")
    public WebElement SelecionarPerfil;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-new-or-edit-perfil/div[1]/mat-card/mat-tab-group/mat-tab-header/div/div/div/div[3]")
    public WebElement Bilhetes;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-new-or-edit-perfil/div[1]/mat-card/mat-tab-group/div/mat-tab-body[3]/div/div/limber-select-product/div/div[1]/mat-form-field/div[1]/div/div[2]/input")
    public WebElement NomeBilhete;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-new-or-edit-perfil/div[1]/mat-card/mat-tab-group/div/mat-tab-body[3]/div/div/limber-select-product/div/div[3]")
    public WebElement AdicionarBilhete;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-perfil/lista-cadastros-com-busca/div/div/div/search-input/mat-form-field/div[1]/div/div[2]/input")
    public WebElement Filtro;

    public PerfilDeVendaPO(WebDriver driver) {
        super(driver);
    }
}
