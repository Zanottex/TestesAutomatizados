package automatizado.Builder.Novo;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Generators.geradores;
import automatizado.Page.EcommercePONovo;

public class BaseBuilder {

    private static final Logger logger = Logger
            .getLogger(BaseBuilder.class
                    .getName());

    private EcommercePONovo EcommercePONovo;
    private String Nome_Cartao = geradores
            .geradorNome();
    private String Numero_Cartao = "4000000000000010";
    private String mes_validade = "12/2050";
    private String codigo_segurança = geradores
            .geradorCodigoSeguranca();
    private String CEP = geradores
            .geradorCEP();
    private String Numero_Casa = geradores
            .geradorNumeroCasa();

    static {
        // Configuração do handler de log para exibir logs no console
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler
                .setLevel(Level.ALL);
        logger
                .addHandler(consoleHandler);
    }

    public BaseBuilder(EcommercePONovo e) {
        this.EcommercePONovo = e;
}

    public void realizarpagamento(WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);
        wait
                .until(d -> EcommercePONovo.Nome_Do_Cartao
                        .isDisplayed());

        EcommercePONovo.Nome_Do_Cartao
                .sendKeys(Nome_Cartao);

        EcommercePONovo.Numero_Cartao
                .sendKeys(Numero_Cartao);

        EcommercePONovo.Mes_Validade
                .sendKeys(mes_validade);

        EcommercePONovo.codigo_segurança
                .sendKeys(codigo_segurança);

        logger
                .info("Preenchendo informações de pagamento: " + " Nome Impresso no Cartão: " + Nome_Cartao
                        + ", Numero do cartão: " + Numero_Cartao + ", Mes de validade: " + mes_validade
                        + ", Codifo de Segurança " + codigo_segurança + "...");

        EcommercePONovo.CEP
                .sendKeys(CEP);

        EcommercePONovo.Numero_Casa
                .sendKeys(Numero_Casa);

        EcommercePONovo.bandeiracartao
                .click();
        try {
            Thread
                    .sleep(1000);
        } catch (InterruptedException e) {
            e
                    .printStackTrace();
        }
        EcommercePONovo.visa
                .click();
        logger
                .info("Preenchendo endereço: CEP: " + CEP + ", Numero da Casa: " + Numero_Casa + "...");
        try {
            Thread
                    .sleep(1000);
        } catch (InterruptedException e) {
            e
                    .printStackTrace();
        }

        EcommercePONovo.finalizarCompra
                .click();
    }
}
