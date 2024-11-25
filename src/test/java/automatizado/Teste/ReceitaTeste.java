package automatizado.Teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import automatizado.Builder.ReceitaBuilder;
import automatizado.Page.ReceitaPO;

public class ReceitaTeste extends BaseTeste{
    
    
    String URL_Receitas = "https://testescard.limbersoftware.com.br/#/pages/cadastro/receita";
    private ReceitaPO receitaPO;

    @Test
    public void TC001_Criar_Receita(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        AbrirCard();
        }
        RedirecionarPag(URL_Receitas);
        receitaPO = new ReceitaPO(driver);
        ReceitaBuilder receita = new ReceitaBuilder(receitaPO);

        receita.builder(driver);


        
    }


}
