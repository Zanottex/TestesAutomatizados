package automatizado.Teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import automatizado.Builder.CriaçãoDeBilhetesBuilder;
import automatizado.Page.BilhetesPO;


public class BilheteTeste extends BaseTeste{

    private static final String URL_Novobilhete = "https://testescard.limbersoftware.com.br/#/pages/cadastro/bilhete/novo";
    private static final String URL_Bilhetes = "https://testescard.limbersoftware.com.br/#/pages/cadastro/bilhete";
    /*Page Objects */
    private static BilhetesPO BilhetePO;

    /*@Test para o sistema compreender como um teste*/
    @Test
    public void TC001_Criação_De_Bilhetes_Correta(){

        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        AbrirCard();
        }
        else{
            Relogar();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*Carrega a página e seus elementos no sistema  */
        RedirecionarPag(URL_Novobilhete);
        BilhetePO = new BilhetesPO(driver);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*Criar Bilhete */
        CriaçãoDeBilhetesBuilder bilhete = new CriaçãoDeBilhetesBuilder(BilhetePO);

        //Configurações Gerais - Bilhete Completo
       
        bilhete.adicionarNomeBilhete("Bilhete Multiplas Datas de Visita").
        Builder(driver);

        finalizar();
    }

    /*
    Caso queira da pra criar varios testes em 1 como por exemplo tentar cadastrar a temporada sem receita ou 
    semcodigo ou sem nome no mesmo teste assim testando todas as variaveis com a temporada existentes em um so 
    teste.
     */
    @Test
    public void TC002_Criar_Bilhete_Sem_temporada(){
        /*Direcionar para a pagina de bilhete */
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        AbrirCard();
        }
        else{
            Relogar();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*Carrega a página e seus elementos no sistema  */
        RedirecionarPag(URL_Novobilhete);
        BilhetePO = new BilhetesPO(driver);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*Criar Bilhete */
        CriaçãoDeBilhetesBuilder bilhete = new CriaçãoDeBilhetesBuilder(BilhetePO);

        /*Teste Sem configurar nada na temporada */
        bilhete.
        adicionarNomeTemporada(null).
        adicionarCodigoTemporada(null).
        Builder(driver);
        try {
            Thread.sleep(0000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String mensagem = BilhetePO.acharMensagem();
        assertEquals("Favor informar ao menos uma Temporada!", mensagem);
        finalizar();
        
    }

    @Test
    public void TC003_Configurar_Bilhete_Vinculado(){
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if(aberto == null){
        AbrirCard();
        }
        else{
            Relogar();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*Carrega a página e seus elementos no sistema  */
        RedirecionarPag(URL_Bilhetes);
        BilhetePO = new BilhetesPO(driver);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*Criar Bilhete */
        CriaçãoDeBilhetesBuilder bilhete = new CriaçãoDeBilhetesBuilder(BilhetePO);

        bilhete.vinculado(driver);
        finalizar();
    }
}
