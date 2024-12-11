package automatizado.Builder.CARD;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.BilhetesPO;

public class CriaçãoDeBilhetesBuilder {

    private String nomeBilhete = "Teste";
    private String codigoBilhete = "5208";
    private String nomeEstabelecimento = "Bilheteria Zanotto";
    private String descricaoBilhete = "Teste Teste";
    private String nomeReceita = "3483";
    private String valorReceita = "100.00";
    private String codigoTemporada = "1";
    private String nomeTemporada = "Temporada 1";
    private String bilheteVinculado = "****";

    private BilhetesPO bilhetesPO;

    public CriaçãoDeBilhetesBuilder(BilhetesPO bilhetesPO){
        this.bilhetesPO = bilhetesPO;
    }

    public CriaçãoDeBilhetesBuilder adicionarNomeBilhete(String nome){
        this.nomeBilhete = nome;
        return this;
    }

    public CriaçãoDeBilhetesBuilder adicionarNomeEstab(String nome){
        this.nomeEstabelecimento = nome;
        return this;
    }

    public CriaçãoDeBilhetesBuilder adicionardescBilhete(String descrição){
        this.descricaoBilhete = descrição;
        return this;
    }

    public CriaçãoDeBilhetesBuilder adicionarNomeReceita(String nome){
        this.nomeReceita = nome;
        return this;
    }

    public CriaçãoDeBilhetesBuilder adicionarValorReceita(String valor){
        this.valorReceita = valor;
        return this;
    }

    public CriaçãoDeBilhetesBuilder adicionarCodigoTemporada(String codigo){
        this.codigoTemporada = codigo;
        return this;
    }

    public CriaçãoDeBilhetesBuilder adicionarNomeTemporada(String nome){
        this.nomeTemporada = nome;
        return this;
    }

    public void Builder(WebDriver driver /*Carregar o driver para que seja possivel utilizar a função wait */){
        
        /*Configurações Gerais do Bilhete */
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);
        wait.until(d -> bilhetesPO.inputnome.isDisplayed());
        bilhetesPO.inputnome.sendKeys(nomeBilhete);
        bilhetesPO.Estabelecimento.click();
        bilhetesPO.EstabelecimentoNome.sendKeys(nomeEstabelecimento );
        bilhetesPO.confirmaEstab.click();
        bilhetesPO.tipoBilhete.click();
        bilhetesPO.tipoBilheteria.click();
        bilhetesPO.descricaobilhete.sendKeys(descricaoBilhete);

        /*Configurações de Categoria */
        bilhetesPO.Categorias.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bilhetesPO.AdicionaCategoria.click();

        wait.until(d -> bilhetesPO.AbreSelecãoDeCategoria.isDisplayed());
        bilhetesPO.AbreSelecãoDeCategoria.click();
        bilhetesPO.SelecionaCategoria.click();
        wait.until(d -> bilhetesPO.salvarCategoria.isDisplayed());
        bilhetesPO.salvarCategoria.click();


        /*Configuração das receitas */
        bilhetesPO.abrirReceita.click();
        bilhetesPO.AdicionarReceitaCategoria.click();
        wait.until(d -> bilhetesPO.SelecionaReceita.isDisplayed());
        bilhetesPO.SelecionaReceita.click();;
        bilhetesPO.NomeReceita.sendKeys(nomeReceita);
        bilhetesPO.confirmarReceita.click();
        bilhetesPO.AdicionarValorReceita.sendKeys(valorReceita);
        bilhetesPO.SalvarReceita.click();
        wait.until(d -> bilhetesPO.Temporada.isDisplayed());
        
        /*Temporada */
        bilhetesPO.Temporada.click();

        /*Tentar Cadastrar sem nehuma configuração de temporada */
        if(nomeTemporada == null && codigoTemporada == null){
        bilhetesPO.salvarNovoBilhete.click();
        }
        /*Cadastra o bilhete corretamente*/
        else{
        /*Configurações de Temporada */
        wait.until(d -> bilhetesPO.AdicionarTemporada.isDisplayed());
        bilhetesPO.AdicionarTemporada.click();
        wait.until(d -> bilhetesPO.CodigoTemporada.isDisplayed());
         bilhetesPO.CodigoTemporada.sendKeys(codigoTemporada);
         bilhetesPO.NomeTemporada.sendKeys(nomeTemporada);
         bilhetesPO.AdicionarReceitaTemporada.click();
         bilhetesPO.ConfirmarReceitaTemporada.click();
         bilhetesPO.SalvarTemporada.click();
         wait.until(d -> bilhetesPO.salvarNovoBilhete.isDisplayed());
        bilhetesPO.salvarNovoBilhete.click();

    }   
    }

    public void vinculado(WebDriver driver){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait.until(d -> bilhetesPO.filtro.isDisplayed());
        bilhetesPO.filtro.sendKeys(codigoBilhete);
        bilhetesPO.abrirBilhete.click();

        
        bilhetesPO.Categorias.click();
        wait.until(d -> bilhetesPO.Bilhete_Vinculado.isDisplayed());
        bilhetesPO.Bilhete_Vinculado.click();
        bilhetesPO.permitirvinculado.click();
        bilhetesPO.adicionarbilhetevinculado.click();
        bilhetesPO.selecionarbilhete.click();
        wait.until(d -> bilhetesPO.nomebilhetevinculado.isDisplayed());
        bilhetesPO.nomebilhetevinculado.sendKeys(bilheteVinculado);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bilhetesPO.confirmabilhetevinculado.click();
        bilhetesPO.salvarBilhete.click();

        wait.until(d -> bilhetesPO.spanMensagem.isDisplayed());
        String mensagem = bilhetesPO.spanMensagem.getText();
        assertEquals("Bilhete salvo com sucesso", mensagem);
    }
}
