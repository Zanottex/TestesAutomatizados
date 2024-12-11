package automatizado.Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

    /*Encontra as caixas de texto */
    @FindBy(name = "login")
    public WebElement inputLogin;

    @FindBy(name = "senha")
    public WebElement inputSenha;

    @FindBy(xpath = "/html/body/div[3]/div/div/mat-snack-bar-container/div/div/div/div/simple-snack-bar/div[1]")
    public WebElement spanMensagem;

    @FindBy(xpath = "/html/body/app-root/login/div/mat-card/form/mat-form-field[1]/div[2]/div/mat-error")
    public WebElement usuario;

    @FindBy(xpath = "/html/body/app-root/login/div/mat-card/form/mat-form-field[2]/div[2]/div/mat-error")
    public WebElement senha;

    @FindBy(xpath = "/html/body/app-root/login/div/mat-card/button")
    public WebElement entrar;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/card-sidenav/div/app-menu-item[1]/a/div/span")
    public WebElement dashboard;


    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public void Logar(String email, String senha){
        /*Carregar a página de login */
        inputLogin.clear();
        escrever(inputLogin, email);
        inputSenha.clear();
        escrever(inputSenha, senha);
        if(email == "" || senha == ""){
        inputSenha.sendKeys(Keys.ENTER);  
        }
        else{
        entrar.click();   
        }
        
    }
    
    public String acharMensagem(){
        return this.spanMensagem.getText();
    }

    public String usuariovazio(){
        return this.usuario.getText();
    }

    public String senhavazio(){
        return this.senha.getText();
    }
    
    public String dashboard(){
        return this.dashboard.getText();
    }

}   
