package automatizado.Teste;

import org.junit.Test;

import automatizado.Builder.CARD.PerfilDeVendaBuilder;
import automatizado.Page.PerfilDeVendaPO;

public class PerfilDeVenda extends BaseTeste {

    private static final String URL_NovoPerfilDeVendas = "";
    private static final String URL_PerfisDeVendas = "";
    private static PerfilDeVendaPO perfilPO;

    @Test
    public void TC001_Criar_Perfil_De_Venda() {
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if (aberto == null) {
            AbrirCard();
        } else {
            driver.get(URL_HOMOLOG);
        }
        RedirecionarPag(URL_NovoPerfilDeVendas);
        perfilPO = new PerfilDeVendaPO(driver);

        PerfilDeVendaBuilder perfil = new PerfilDeVendaBuilder(perfilPO);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        perfil.builder(driver);

    }

    @Test
    public void TC002_Colocar_Bilhete_Perfil() {
        String aberto;
        try {
            aberto = driver.manage().window().getSize().toString();
        } catch (Exception e) {
            aberto = null;
        }
        if (aberto == null) {
            AbrirCard();
        } else {
            driver.get(URL_HOMOLOG);
        }
        RedirecionarPag(URL_PerfisDeVendas);
        perfilPO = new PerfilDeVendaPO(driver);

        PerfilDeVendaBuilder perfil = new PerfilDeVendaBuilder(perfilPO);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        perfil.
                /*Utilizar aqui para diferenciar os perfis que serão modificados */
                //mudarNomePerfil("").
                //mudarNomeBilhete("5238").
                ColocarBilhete(driver);

    }
}
