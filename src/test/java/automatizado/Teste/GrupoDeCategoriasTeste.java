package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.GrupoDeCategoriasBuilder;
import automatizado.Page.GrupoDeCategoriasPO;

public class GrupoDeCategoriasTeste extends BaseTeste{
    
    public static final String URL_GrupoDeCategorias = "https://testescard.limbersoftware.com.br/#/pages/cadastro/grupo-categoria/novo-grupo";
    private static GrupoDeCategoriasPO grupoPO;

    @Test
    public void TC001_Criar_Grupo_Categoria(){
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
        RedirecionarPag(URL_GrupoDeCategorias);
        grupoPO = new GrupoDeCategoriasPO(driver);

        GrupoDeCategoriasBuilder grupo = new GrupoDeCategoriasBuilder(grupoPO);

        grupo.builder(driver);

        
    }
}
