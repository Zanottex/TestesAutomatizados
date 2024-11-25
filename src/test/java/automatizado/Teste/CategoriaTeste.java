package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.CategoriaBuilder;
import automatizado.Page.CategoriaPO;


public class CategoriaTeste extends BaseTeste{

    /*Page Objects */
    private static final String URL_Categorias = "https://testescard.limbersoftware.com.br/#/pages/cadastro/categoria";
    private static CategoriaPO categoriaPO;

    /*@Test para o sistema compreender como um teste*/
    @Test
    public void TC001_Criar_Categoria(){
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
            driver.get(URL_HOMOLOG);
        }
        driver.get(URL_HOMOLOG);
        driver.navigate().refresh();
        RedirecionarPag(URL_Categorias);
        categoriaPO = new CategoriaPO(driver);

        CategoriaBuilder categoria = new CategoriaBuilder(categoriaPO);

        categoria.builder(driver);
        
    }

    @Test
    public void TC002_Categoria_Sem_Estab(){
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
            driver.get(URL_HOMOLOG);
        }
        RedirecionarPag(URL_Categorias);
        categoriaPO = new CategoriaPO(driver);

        CategoriaBuilder categoria = new CategoriaBuilder(categoriaPO);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        categoria.
        EstabAcesso(null).
        builder(driver);
        

       
    }
}