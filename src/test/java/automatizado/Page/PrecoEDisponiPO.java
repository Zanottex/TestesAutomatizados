package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrecoEDisponiPO extends BasePO{

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-config-preco/mat-card/div")
    public WebElement abrirPesquisaBilhete;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/mat-option[1]/span/ngx-mat-select-search/div/div/input")
    public WebElement nomeBilhete;
    
    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/mat-option[2]")
    public WebElement selecionaBilhete;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-config-preco/mat-card/mat-tab-nav-panel/lista-tabelas-preco/mat-tab-group/div/mat-tab-body[1]/div/table/thead/tr/th[4]/div/button")
    public WebElement NovaTabelaPreco;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-config-preco/mat-card/mat-tab-nav-panel/lista-tabelas-preco/mat-tab-group/div/mat-tab-body[2]/div/tabela-preco/div[1]/div/div/mat-form-field[1]/div[1]/div/div[2]/input")
    public WebElement NomeTabelaPreco;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-config-preco/mat-card/mat-tab-nav-panel/lista-tabelas-preco/mat-tab-group/div/mat-tab-body[2]/div/tabela-preco/div[1]/mat-card/mat-card-content/table/thead/tr/th[6]/div/button[1]")
    public WebElement autoPreencher;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-config-preco/mat-card/mat-tab-nav-panel/lista-tabelas-preco/mat-tab-group/div/mat-tab-body[2]/div/tabela-preco/div[1]/mat-card/mat-card-content/table/tbody/tr/td[4]/mat-form-field/div[1]/div[2]/div/input")
    public WebElement preço;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-config-preco/mat-card/mat-tab-nav-panel/lista-tabelas-preco/mat-tab-group/div/mat-tab-body[2]/div/tabela-preco/div[1]/mat-card/mat-card-content/table/tbody/tr/td[6]/div/div/button")
    public WebElement salvarlinha;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/app-config-preco/mat-card/mat-tab-nav-panel/lista-tabelas-preco/mat-tab-group/div/mat-tab-body[2]/div/tabela-preco/div[1]/div/div/mat-form-field[2]/div[1]/div/div[2]/input")
    public WebElement cor;

    public PrecoEDisponiPO(WebDriver driver) {
        super(driver);

    }

    
}
