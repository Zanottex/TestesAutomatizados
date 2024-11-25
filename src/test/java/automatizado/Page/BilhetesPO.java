package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BilhetesPO extends BasePO{

    /*Achar os elementos na tela de criação de bilhetes */
    /* Configurações Gerais */
    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/div/mat-tab-body[1]/div/div/form/div[2]/mat-form-field[1]/div[1]/div/div[2]/input")
    public WebElement inputnome;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/mat-tab-header/div/div/div/div[1]")
    public WebElement ConfiguraçõesGerais;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/div/mat-tab-body[1]/div/div/form/div[2]/mat-form-field[3]/div[1]")
    public WebElement Estabelecimento;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/mat-option[1]/span/ngx-mat-select-search/div/div/input")
    public WebElement EstabelecimentoNome;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/mat-option[2]")
    public WebElement confirmaEstab;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/div/mat-tab-body[1]/div/div/form/div[2]/mat-form-field[4]/div[1]")
    public WebElement tipoBilhete;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/mat-option[1]")
    public WebElement tipoBilheteria;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/div/mat-tab-body[1]/div/div/form/section/mat-form-field[4]/div[1]/div/div[2]/textarea")
    public WebElement descricaobilhete;
    
    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[2]/buttons/div/div/button[2]")
    public WebElement salvarNovoBilhete;


    /* Temporada */
    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/mat-tab-header/div/div/div/div[7]")
    public WebElement Temporada;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/div/mat-tab-body[7]/div/div[1]/title-btn-add/div/button/span[4]")
    public WebElement AdicionarTemporada;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/add-temporada/mat-dialog-content/mat-tab-group/div/mat-tab-body[1]/div/form/mat-form-field[1]/div[1]/div/div[2]/input")
    public WebElement CodigoTemporada;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/add-temporada/mat-dialog-content/mat-tab-group/div/mat-tab-body[1]/div/form/mat-form-field[2]/div[1]/div/div[2]/input")
    public WebElement NomeTemporada;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/add-temporada/mat-dialog-content/mat-tab-group/div/mat-tab-body[1]/div/form/mat-form-field[3]/div[1]/div/div[2]/mat-select")
    public WebElement AdicionarReceitaTemporada;

    @FindBy(xpath = "/html/body/div[3]/div[4]/div/div/mat-option")
    public WebElement ConfirmarReceitaTemporada;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/add-temporada/div[2]/button[2]")
    public WebElement SalvarTemporada;


    /* Categoria */
    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/mat-tab-header/div/div/div/div[2]")
    public WebElement Categorias;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/div/mat-tab-body[2]/div/bilhete-configuracao-venda/div/form/div/div/title-btn-add/div/button/span[4]")
    public WebElement AdicionaCategoria;
    
    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/add-categoria/div[1]/mat-form-field/div[1]/div/div[2]/mat-select/div")
    public WebElement AbreSelecãoDeCategoria;

    @FindBy(xpath = "/html/body/div[3]/div[4]/div/div/div/mat-option[1]/span")
    public WebElement SelecionaCategoria;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/add-categoria/div[2]/buttons/div/div/button[2]")
    public WebElement salvarCategoria;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/div/mat-tab-body[2]/div/bilhete-configuracao-venda/div/form/div/div/title-btn-add/div/button/span[4]")
    public WebElement AbrirCategoria;
   

    /* Receitas */
    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/div/mat-tab-body[2]/div/bilhete-configuracao-venda/div/form/div/div/div/mat-accordion/mat-expansion-panel/mat-expansion-panel-header")
    public WebElement abrirReceita;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/div/mat-tab-body[2]/div/bilhete-configuracao-venda/div/form/div/div/div/mat-accordion/mat-expansion-panel/div/div/div/title-btn-add/div/button")
    public WebElement AdicionarReceitaCategoria;

    @FindBy(xpath = "/html/body/div[3]/div[4]/div/div/mat-option[1]/span/ngx-mat-select-search/div/div/input")
    public WebElement NomeReceita;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/add-receitas/div/form/mat-form-field[1]/div[1]")
    public WebElement SelecionaReceita;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/add-receitas/div/form/mat-form-field[2]/div[1]/div/div[2]/input")
    public WebElement AdicionarValorReceita;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/add-receitas/div/div/button[2]")
    public WebElement SalvarReceita;

    @FindBy(xpath = "/html/body/div[3]/div[4]/div/div/mat-option[2]")
    public WebElement confirmarReceita;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/lista-bilhetes/lista-cadastros-com-busca/div/div/div/search-input/mat-form-field/div[1]/div/div[2]/input")
    public WebElement filtro;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/lista-bilhetes/lista-cadastros-com-busca/div/mat-card/div/table/tbody/tr/td[5]/button")
    public WebElement abrirBilhete;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/div/mat-tab-body[2]/div/bilhete-configuracao-venda/div/mat-selection-list/mat-list-option[8]")
    public WebElement Bilhete_Vinculado;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/div/mat-tab-body[2]/div/bilhete-configuracao-venda/div/form/div/div/mat-slide-toggle/div/button")
    public WebElement permitirvinculado;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/div/mat-tab-body[2]/div/bilhete-configuracao-venda/div/form/div/div/button")
    public WebElement adicionarbilhetevinculado;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[1]/mat-card/mat-tab-group/div/mat-tab-body[2]/div/bilhete-configuracao-venda/div/form/div/form/mat-form-field[1]/div[1]")
    public WebElement selecionarbilhete;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/mat-option[1]/span/ngx-mat-select-search/div/div/input")
    public WebElement nomebilhetevinculado;

    @FindBy(id = "mat-option-397")
    public WebElement confirmabilhetevinculado;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/div/new-or-edit-bilhete/div[2]/buttons/div/div/button[3]")
    public WebElement salvarBilhete;

    /*Mensagens em tela */
    @FindBy(xpath = "html/body/div[3]/div/div/mat-snack-bar-container/div/div/div/div/simple-snack-bar/div[1]")
    public WebElement spanMensagem;


    /*Funções para se utilizar */
    public BilhetesPO(WebDriver driver) {
        super(driver);
    }

    public String acharMensagem(){
        return this.spanMensagem.getText();
    }
    

}
