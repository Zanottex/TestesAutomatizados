package automatizado.Builder.Antigo;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Generators.geradores;
import automatizado.Page.EcommercePOAntigo;

public class BaseBuilder {

    private static final Logger logger = Logger
            .getLogger(AquaRioBuilder.class
                    .getName());

    private EcommercePOAntigo EcommercePOAntigo;
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

    public BaseBuilder(EcommercePOAntigo e) {
        this.EcommercePOAntigo = e;
}

    public void realizarpagamento(WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);
        wait
                .until(d -> EcommercePOAntigo.Nome_Do_Cartao
                        .isDisplayed());

        EcommercePOAntigo.Nome_Do_Cartao
                .sendKeys(Nome_Cartao);

        EcommercePOAntigo.Numero_Cartao
                .sendKeys(Numero_Cartao);

        EcommercePOAntigo.Mes_Validade
                .sendKeys(mes_validade);

        EcommercePOAntigo.codigo_segurança
                .sendKeys(codigo_segurança);

        logger
                .info("Preenchendo informações de pagamento: " + " Nome Impresso no Cartão: " + Nome_Cartao
                        + ", Numero do cartão: " + Numero_Cartao + ", Mes de validade: " + mes_validade
                        + ", Codifo de Segurança " + codigo_segurança + "...");

        EcommercePOAntigo.CEP
                .sendKeys(CEP);

        EcommercePOAntigo.Numero_Casa
                .sendKeys(Numero_Casa);

        EcommercePOAntigo.bandeiracartao
                .click();
        try {
            Thread
                    .sleep(1000);
        } catch (InterruptedException e) {
            e
                    .printStackTrace();
        }
        EcommercePOAntigo.visa
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

        EcommercePOAntigo.finalizarCompra
                .click();
    }
}
