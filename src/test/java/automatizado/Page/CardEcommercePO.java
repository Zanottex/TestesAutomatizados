package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardEcommercePO extends BasePO{

    public CardEcommercePO(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/ec-config/lista-cadastros-com-busca/div/div/div/search-input/mat-form-field/div[1]/div/div[2]/input")
    public WebElement Filtro;
    
    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/ec-config/lista-cadastros-com-busca/div/mat-card/div/table/tbody/tr/td[5]/button")
    public WebElement SelecionarEcommerce;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-ec-config/div[1]/mat-card/mat-tab-group/mat-tab-header/div/div/div/div[4]")
    public WebElement Grupos;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-ec-config/div[1]/mat-card/mat-tab-group/div/mat-tab-body[4]/div/div/div/div[2]/mat-accordion/mat-expansion-panel[1]")
    public WebElement Grupo_TesteAutomatizado;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-ec-config/div[1]/mat-card/mat-tab-group/div/mat-tab-body[4]/div/div/div/div[2]/mat-accordion/mat-expansion-panel[1]/div/div/mat-card/div/div[2]/div/button")
    public WebElement Adicionar_Bilhete_grupo;

    @FindBy(xpath  = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/limber-select-product/div/div[1]/mat-form-field/div[1]/div/div[2]/input")
    public WebElement Bilhete;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/limber-select-product/div/div[3]")
    public WebElement seleciona_Bilhete;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/limber-select-product/div/div[4]/button[2]")
    public WebElement salva_Bilhete;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-ec-config/div[2]/buttons/div/div/button[3]")
    public WebElement salva_Ecommerce;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-ec-config/div[1]/mat-card/mat-tab-group/div/mat-tab-body[4]/div/div/div/div[2]/mat-accordion/mat-expansion-panel[1]/div/div/mat-card/div/div[2]/view-product[1]/mat-card/div/span")
    public WebElement nomeBilhete1;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-ec-config/div[1]/mat-card/mat-tab-group/div/mat-tab-body[4]/div/div/div/div[2]/mat-accordion/mat-expansion-panel[1]/div/div/mat-card/div/div[2]/view-product[2]/mat-card/div/span")
    public WebElement nomeBilhete2;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-ec-config/div[1]/mat-card/mat-tab-group/div/mat-tab-body[4]/div/div/div/div[2]/mat-accordion/mat-expansion-panel[1]/div/div/mat-card/div/div[2]/view-product[3]/mat-card/div/span")
    public WebElement nomeBilhete3;

    @FindBy(css = "view-product[1]")
    public WebElement tirarBilhete1;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-ec-config/div[1]/mat-card/mat-tab-group/div/mat-tab-body[4]/div/div/div/div[2]/mat-accordion/mat-expansion-panel[1]/div/div/mat-card/div/div[2]/view-product[2]")
    public WebElement tirarBilhete2;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-ec-config/div[1]/mat-card/mat-tab-group/div/mat-tab-body[4]/div/div/div/div[2]/mat-accordion/mat-expansion-panel[1]/div/div/mat-card/div/div[2]/view-product[3]")
    public WebElement tirarBilhete3;

    @FindBy(xpath = "html/body/div[3]/div/div/mat-snack-bar-container/div/div/div/div/simple-snack-bar/div[1]")
    public WebElement spanMensagem;

}
