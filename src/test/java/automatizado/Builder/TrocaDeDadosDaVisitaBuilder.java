package automatizado.Builder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.EcommercePO;

public class TrocaDeDadosDaVisitaBuilder {

    private EcommercePO ECommercePO;

    public TrocaDeDadosDaVisitaBuilder(EcommercePO ecommercePO) {
        this.ECommercePO = ecommercePO;
    }

    public void builder(WebDriver driver, int tipo) {

        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait
                .until(d -> ECommercePO.olaFaçaSeuLogin
                        .isDisplayed());
        ECommercePO.aceitarcookies
                .click();
        ECommercePO.olaFaçaSeuLogin
                .click();
        ECommercePO.Entrar
                .click();
        wait
                .until(d -> ECommercePO.Email_ecommerce
                        .isDisplayed());
        ECommercePO.Email_ecommerce
                .sendKeys("gustavozanotto119@gmail.com");
        ECommercePO.senha_ecommerce
                .sendKeys("1");
        ECommercePO.Logar
                .click();

        wait
                .until(d -> ECommercePO.proximoMesHome
                        .isDisplayed());
        ECommercePO.olaFaçaSeuLogin
                .click();
        ECommercePO.meus_pedidos
                .click();
        wait
                .until(d -> ECommercePO.ultima_venda
                        .isDisplayed());
        ECommercePO.ultima_venda
                .click();
        wait
                .until(d -> ECommercePO.alterar_informações_da_visita
                        .isDisplayed());
        ECommercePO.alterar_informações_da_visita
                .click();
        wait
                .until(d -> ECommercePO.alterar_data_de_visita
                        .isDisplayed());
        ECommercePO.alterar_data_de_visita
                .click();
        try {
            Thread
                    .sleep(1000);
        } catch (InterruptedException e) {
            e
                    .printStackTrace();
        }
        ECommercePO.proximo_mes_remarcação
                .click();
        try {
            Thread
                    .sleep(2000);
        } catch (InterruptedException e) {
            e
                    .printStackTrace();
        }
        ECommercePO.dia_remarcação
                .click();
        ECommercePO.salvar_remarcação
                .click();

    }

}
