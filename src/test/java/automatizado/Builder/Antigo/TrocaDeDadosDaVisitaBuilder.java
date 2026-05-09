package automatizado.Builder.Antigo;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.EcommercePOAntigo;

public class TrocaDeDadosDaVisitaBuilder {

    private EcommercePOAntigo EcommercePOAn tigo;

    private static final Logger logger = Logger
    .getLogger(Aqu

    aRioB  getName());

        
    static {
        // Con and
        ler consoleHandler = new ConsoleHandler();
        consoleHandler

        
                 .setLevel(Level.ALL);
            logger
                     .addHa
            ndler(consoleHandler);
                
            
    }
 
                aVisitaBuilder(Eco m mercePOAn
                tigo EcommercePOAntigo) {
        this.EcommercePOAntigo = EcommercePOAntigo 
                 
                 ilder(Web
                Driver  
                 Dr
                iver> wait = new 
                 e Login no E-Commerce.");
                
        wait mercePOAntigo
                .olaFaçaSeuLogi .i
                sDisplayed()); OAntigo.a
                ceitarcookies 
                 
        EcommercePOAntigo.olaFaçaSeuLogin .c
                lick();
                    
                
                .click();
                    
 
                             wait
                .until(d -> EcommercePOAntigo.Email_ecommerce
                        .isDisplayed()); mmerce
                     );{
                        
                    
                    }
        EcommercePOAntigo.senha_ecommerc 
                        
                    
        logger suario comum.");
                            
                        
        EcommercePOAntigo.Logar ();
                             
                            
        wait
                            
                            
                            -> EcommercePO yed());
                            go


    
        
            
                
                    
                         
                             
                            .olaFaçaSeuLogin

        .click();
        EcommercePOAntigo.meus_pedidos
                .click();
        logger
                .info("Abrindo a aba de 'Meus Pedidos'.");
        wait
                .until(d -> EcommercePOAntigo.ultima_venda
                .isDisplayed());
        EcommercePOAntigo.ultima_venda
                .click();
        try {
            Thread
                    .sleep(1000);
        } catch (InterruptedException e) {
            e
                    .printStackTrace();
        }
        logger
                .info("Arindo a ultima venda.");
        /* Verifica se o bilhete tem a opção de alterar as informações da visita. */
        if (EcommercePOAntigo.alterar_informações_da_visita
                .isEnabled()) {

            EcommercePOAntigo.alterar_informações_da_visita
                    .click();
            wait
                    .until(d -> EcommercePOAntigo.alterar_data_de_visita
                    .isDisplayed());
            logger
                    .info("Trocando a data da visita do bilhete.");
            EcommercePOAntigo.alterar_data_de_visita
                    .click();
            try {
                Thread
                        .sleep(1000);
            } catch (InterruptedException e) {
                e
                        .printStackTrace();
            }
            EcommercePOAntigo.proximo_mes_remarcação
                    .click();
            try {
                Thread
                        .sleep(2000);
            } catch (InterruptedException e) {
                e
                        .printStackTrace();
            }
            EcommercePOAntigo.dia_remarcação
                    .click();
            EcommercePOAntigo.salvar_remarcação
                    .click();
            logger
                    .info("Data da visita alterada.");
            /*
                         * TODO: achar uma forma de confirmar que a dara da visita foi trocada
                         * corretamente
             */
        } else {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js
                    .executeScript("alert('Bilhete sem remarcação liberado!');");
        }

    }

}
