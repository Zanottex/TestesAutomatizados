package automatizado.Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePO {

    protected WebDriver driver;

   
    @FindBy(xpath = "/html/body/app-root/app-pages/div/div/card-sidenav/div/app-menu-item[1]/a/div/span")
    public WebElement dashboard;

    @FindBy(xpath = "html/body/div[3]/div/div/mat-snack-bar-container/div/div/div/div/simple-snack-bar/div[1]")
    public WebElement spanMensagem;

    @FindBy(xpath = "/html/body/app-root/app-pages/div/card-toolbar/mat-toolbar/a[4]/button")
    public WebElement Sair;

    
    /*Page Object base */
    protected BasePO(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void escrever(WebElement input, String Texto){
        input.clear();
        input.sendKeys(Texto + Keys.TAB);
    }

    public String acharMensagem(){
        return this.spanMensagem.getText();
    }

    public void quitei(){
        Sair.click();
    }
}

