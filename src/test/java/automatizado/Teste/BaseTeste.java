package automatizado.Teste;

//import org.junit.AfterClass;
//import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import automatizado.Page.BasePO;
import automatizado.Page.LoginPO;


public abstract class BaseTeste {

    public static WebDriver driver;
    public static final String CAMINHO_BASE = "src/test/java/automatizado/resource/chromedriverV130.0.6723.58.exe";
    protected static final String URL_HOMOLOG = "https://testescard.limbersoftware.com.br/#/pages/dashboard";
    protected static final String URL_Produção = "https://card.limbersoftware.com.br/#/pages/dashboard";

    private static LoginPO Login;
    /*Garante que seja executada antes que qualquer outra função (Esta em specifico ocorre primeiro que 
    outras BeforeClass em qualquer outro lugar por ser a base principal) */
    /*@BeforeClass*/

    /*Abrir o google e colocar na tela de login do CARD */
    public static void iniciar(String URL){
        System.setProperty("webdriver.chrome.driver", CAMINHO_BASE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    public static void AbrirCard(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_BASE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_HOMOLOG);

        /*Abrir página de Login */
        Login = new LoginPO(driver);
        /*Logar */
        Login.Logar("Gustavo@limbersoftware.com.br", "Gustavo1!");

        /*Esperar a página carregar */
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*Função para abrir a tela dependendo da URL */
    public static void RedirecionarPag(String URL){
        driver.get(URL);
    }

    /*Garante que seja executada depois de todas as funções */
    //@AfterClass
    public static void finalizar(){
        driver.quit();
    }

    public static void Relogar(){
        RedirecionarPag(URL_HOMOLOG);
        BasePO base = new BasePO(driver) {
        };
        base.quitei();
        Login.Logar("Gustavo@limbersoftware.com.br", "Gustavo1!");
    }
}
