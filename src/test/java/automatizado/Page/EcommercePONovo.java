package automatizado.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommercePONovo extends BasePO {

        public EcommercePONovo(WebDriver driver) {
                super(driver);
        }

                /* Dentro do E-Commerce */
        @FindBy(xpath = "/html/body/app-root/app-home/main/app-authentication/app-login-client/ec-wrapper/form/mat-form-field/div[1]/div/div[2]/input")
        public WebElement Email_ecommerce;

        @FindBy(xpath = "/html/body/app-root/app-home/main/app-authentication/app-login-client/ec-wrapper/form/button")
        public WebElement Email_Continuar;

        @FindBy(xpath = "/html/body/app-root/app-home/main/app-authentication/app-login-client/ec-wrapper/form/mat-form-field/div[1]/div/div[2]/input")
        public WebElement senha_ecommerce;

        @FindBy(id = "accountButton")
        public WebElement olaFaçaSeuLogin;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav/div/mat-tab-group/div/mat-tab-body[2]/div/menu-content/div/div[1]/mat-list/a[1]/mat-list-item")
        public WebElement meus_pedidos;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav/div/mat-tab-group/div/mat-tab-body[2]/div/menu-content/div/div/div[2]/button[1]")
        public WebElement Entrar;

        @FindBy(xpath = "/html/body/app-root/app-home/main/app-authentication/app-login-client/ec-wrapper/form/div[2]/button")
        public WebElement Logar;

        @FindBy(id = "mat-input-0")
        public WebElement barraDePesquisa;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/meus-pedidos/div/mat-card/mat-card-content[2]/table/tbody/tr[1]/td[1]")
        public WebElement ultima_venda;

        @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-dialog-container/div/div/details-pedido/div/div[1]/div[2]/div/button[3]")
        public WebElement alterar_informações_da_visita;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/alterarhorariocomponent/div/mat-card/mat-card-content/mat-accordion/mat-expansion-panel/div/div/div/mat-card/mat-card-content[2]/mat-card/div[2]/div/mat-form-field[1]/div[1]/div/div[3]/mat-datepicker-toggle/button")
        public WebElement alterar_data_de_visita;

        @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/mat-calendar-header-config/div/div/button[2]")
        public WebElement proximo_mes_remarcação;

        @FindBy(xpath = "/html/body/div[3]/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/div/mat-month-view/table/tbody/tr[5]/td[2]/button")
        public WebElement dia_remarcação;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/alterarhorariocomponent/div/mat-card/mat-card-actions/button[2]")
        public WebElement salvar_remarcação;

        @FindBy(xpath = "/html/body/app-root/app-home/main/app-dashboard/section[2]/app-highlights/div/div[1]/div/app-product-card/div/section/a")
        public WebElement bilhete_a_venda_grupo1;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/dashboard/div/div/div[2]/div[2]/productshighlights/div/div[1]/div/a/productthumb/div[1]")
        public WebElement bilhete_a_venda_grupo2;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/dashboard/div/div/div/div[2]/productshighlights/div/div[1]/div[1]")
        public WebElement bilhete_a_venda_grupo3;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-product-receita/app-title-with-edit[1]/section/div[3]/div/ec-calendar/table/tr[5]/td[4]/div/button")
        public WebElement dia;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div/div[1]/section/div[2]/div/mat-calendar/div/mat-month-view/table/tbody/tr[3]/td[4]/button")
        public WebElement dia2Receitas;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[3]/div/div/div/div/div[1]/section/div[2]/div/mat-calendar/div/mat-month-view/table/tbody/tr[3]/td[4]/button")
        public WebElement dia3Receitas;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[1]/div/div/div/div/div[1]/section/div[2]/div/mat-calendar/div/mat-month-view/table/tbody/tr[4]/td[4]/button")
        public WebElement diaFim;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div[1]/div/div/div[1]/span[2]/span")
        public WebElement valor7dias;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-product-receita/app-title-with-edit[1]/section/div[3]/div/ec-calendar/table/tr[1]/th/div/section/button[2]")
        public WebElement ProximoMes;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div/div[1]/section/div[2]/div/mat-calendar/mat-calendar-header-config/div/div/button[2]")
        public WebElement ProximoMes2Receitas;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[3]/div/div/div/div/div[1]/section/div[2]/div/mat-calendar/mat-calendar-header-config/div/div/button[2]")
        public WebElement ProximoMes3Receitas;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[1]/div/div/div/div/div[1]/div")
        public WebElement horario;

        /*
         * Tem um pequeno conflito na parte de horario e local de embarque pois o
         * embarque quando se tem apareçe antes do horario e caso não tenho embarque o
         * horario fica no lugar dele
         */
        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div/div[1]/div")
        public WebElement horario2Receitas;

        /*
         * esse horario serve para quando se tem tanto local de embarque e selecionar
         * horario ao mesmo tempo que se tem 2 receitas
         */
        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div/div[1]/div[2]")
        public WebElement horario2Receitas_comLocalDeEmbarque;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[3]/div/div/div/div/div[1]/div")
        public WebElement horario3Receitas;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-product-receita/app-title-with-edit[3]/section/div[3]/div/button[1]")
        public WebElement confirmarHorario;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-product-receita/app-title-with-edit[2]/section/div[2]/button")
        public WebElement localEmbarque;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div/div[1]/div[1]/escolha-local-emb/div/section/div[2]")
        public WebElement localEmbarque2Receitas;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[3]/div/div/div/div/div[1]/div[1]/escolha-local-emb/div/section/div[2]")
        public WebElement localEmbarque3Receitas;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-product-receita[2]/app-title-with-edit[2]/section/div[3]/div/button[1]")
        public WebElement localEmbarqueConfirmar;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-options-list/div/div")
        public WebElement confirmarHorario4opcoes;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[1]/div/div/div/div/div[1]/div[3]/escolha-sessao/div/section/div[2]")
        public WebElement sessao;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-options-list/div/div/button")
        public WebElement sessaoConfirmar;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[1]/div/div/div/div/div[2]/div/div[2]/button")
        public WebElement proximo;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div/div[2]/div/div[2]/button")
        public WebElement proximo2Receitas;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[3]/div/div/div/div/div[2]/div/div[2]/button")
        public WebElement proximo3Receitas;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-title-with-edit[2]/section/div[3]/div/app-escolha-categoria[1]/div/div[2]/button[2]")
        public WebElement adicionarCategoria;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[3]/div/div/div/div[1]/div/div[1]/div[2]/button[2]")
        public WebElement adicionarCategoria_2Rec;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[4]/div/div/div/div[1]/div/div[1]/div[2]/button[2]")
        public WebElement adicionarCategoria_3Rec;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div[1]/div/div[3]/div[2]/button[2]")
        public WebElement adicionarCategoria2Desconto;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-title-with-edit[2]/section/div[3]/div/app-escolha-categoria[2]/div/div[2]/button[2]")
        public WebElement adicionarCategoria2;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[3]/div/div/div/div[1]/div/div[2]/div[2]/button[2]")
        public WebElement adicionarCategoria2_2Rec;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[4]/div/div/div/div[1]/div/div[2]/div[2]/button[2]")
        public WebElement adicionarCategoria2_3Rec;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-title-with-edit[2]/section/div[3]/div/app-escolha-categoria[3]/div/div[2]/button[2]")
        public WebElement adicionarCategoria3;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[3]/div/div/div/div[1]/div/div[3]/div[2]/button[2]")
        public WebElement adicionarCategoria3_2Rec;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[4]/div/div/div/div[1]/div/div[3]/div[2]/button[2]")
        public WebElement adicionarCategoria3_3Rec;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div[1]/div/div[2]/div[2]/button[1]")
        public WebElement tirarcategoria1;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div[1]/div/div[3]/div[2]/button[1]")
        public WebElement tirarcategoria2;;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card/div/div/mat-form-field[2]/div[1]/div/div[2]")
        public WebElement selecionarConvenio_coletaDeDados_usuario1;

        @FindBy(xpath = "/html/body/div[2]/div[5]/div/div/mat-option[1]")
        public WebElement primeiro_convenio;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[2]/div/div/mat-form-field[2]/div[1]/div/div[2]")
        public WebElement selecionarConvenio_coletaDeDados_usuario2;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[3]/div/div/mat-form-field[2]/div[1]/div/div[2]")
        public WebElement selecionarConvenio_coletaDeDados_usuario3;

        @FindBy(xpath = "/html/body/div[2]/div[1]/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-title-with-edit[1]/section/div[3]/div/app-endereco-form/form/mat-form-field/div[1]/div/div[2]")
        public WebElement selecionarPaisOrigem;

        @FindBy(id = "mat-select-value-7")
        public WebElement selecionarPaisOrigem_Na_ColetaDeDados_PrimeiroUsuario;

        @FindBy(xpath = "/html/body/div[2]/div[4]/div/div/mat-option[2]")
        public WebElement confirmarPaisOrigem_Na_ColetaDeDados;

        @FindBy(id = "mat-select-38")
        public WebElement selecionarPaisOrigem_Na_ColetaDeDados_SegundoUsuario_segundaCategoria;

        @FindBy(id = "mat-select-10")
        public WebElement selecionarPaisOrigem_Na_ColetaDeDados_SegundoUsuario;

        @FindBy(id = "mat-select-14")
        public WebElement selecionarPaisOrigem_Na_ColetaDeDados_TerceiroUsuario;

        @FindBy(id = "mat-select-0")
        public WebElement selecionarPaisOrigem_2Rec;

        @FindBy(id = "mat-select-value-1")
        public WebElement selecionarPaisOrigem_3Rec;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/mat-option[1]/span/ngx-mat-select-search/div/div/input")
        public WebElement nomePaisOrigem;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card/div/div/mat-form-field[4]/div[1]/div/div[2]/input")
        public WebElement data_de_nascimento_ColetaDeDados_PrimeiroUsuario;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[2]/div/div/mat-form-field[4]/div[1]/div/div[2]/input")
        public WebElement data_de_nascimento_ColetaDeDados_SegundoUsuario;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[3]/div/div/mat-form-field[4]/div[1]/div/div[2]/input")
        public WebElement data_de_nascimento_ColetaDeDados_TerceiroUsuario;

        /*
         * selecionar um pais. O brasil aparece em posições diferentes dependendo do
         * bilhete exemplo o bilhete do aquas correntes é de numero 22 ou 23, já o do
         * fundação é 10 ou 11 ele pode alternar nesses valores
         */
        @FindBy(id = "opcao_Brasil")
        public WebElement confirmaPaisOrigem;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div[1]/app-coleta-pais-estado/div/div/div[2]/mat-form-field/div[1]/div/div[2]/input")
        public WebElement CEP_Nas_categorias;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[1]/div/div/div[3]/mat-form-field[2]/div[1]/div/div[2]/input")
        public WebElement CEP_Na_ColetaDeDados_PrimeiroUsuario;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[2]/div/div/div[3]/mat-form-field[2]/div[1]/div/div[2]/input")
        public WebElement CEP_Na_ColetaDeDados_SegundoUsuario;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[3]/div/div/div[3]/mat-form-field[2]/div[1]/div/div[2]/input")
        public WebElement CEP_Na_ColetaDeDados_TerceiroUsuario;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div[1]/div/div[2]/div[1]/span[1]/b")
        public WebElement Nomecategoria;

        @FindBy(id = "opcao_Estados Unidos")
        public WebElement paiserrado;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-title-with-edit[1]/section/div[3]/div/app-endereco-form/form/mat-form-field[2]/div[1]/div/div[2]")
        public WebElement estado;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[3]/div/div/div/div[1]/app-coleta-pais-estado/div/div/div[2]/mat-form-field/div[1]")
        public WebElement estado_2Rec;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[4]/div/div/div/div[1]/app-coleta-pais-estado/div/div/div[2]/mat-form-field/div[1]")
        public WebElement estado_3Rec;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[1]/div/div/div/div/div[1]/div[2]/escolha-horario-vaga/div/section/div[2]/mat-icon")
        public WebElement horarioCredenciado;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[1]/div/div/div/div/div[1]/div[3]/escolha-sessao/div/section/div[2]/mat-icon")
        public WebElement esperaSessao;

        @FindBy(id = "mat-option-270")
        public WebElement acre;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/termoaceitebilhetecomponent/div/div/div/div[3]/mat-checkbox")
        public WebElement aceitar_termos;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/termoaceitebilhetecomponent/div/div/div/div[4]/div[2]/button")
        public WebElement continuar_termos;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-meu-carrinho/div/div/div[2]/mat-card/div/div[3]/div[1]/div/mat-checkbox")
        public WebElement aceitar_termos_finalizar_pedido;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[1]/div/div/div/div/div[1]/section/div/div[2]/div/div/span")
        public WebElement DiaInicio;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[1]/div/div/div/div/div[1]/section/div/div[2]/div/div/div[1]/span[1]")
        public WebElement MesInicio;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[1]/div/div/div/div/div[1]/section/div/div[2]/div/div/div[1]/span[2]")
        public WebElement AnoInicio;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[1]/div/div/div/div/div[1]/section/div/div[2]/div/div/div[3]/span")
        public WebElement DiaTermino;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[1]/div/div/div/div/div[1]/section/div/div[2]/div/div/div[3]/div/span[1]")
        public WebElement MesTermino;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[1]/div/div/div/div/div[1]/section/div/div[2]/div/div/div[3]/div/span[2]")
        public WebElement AnoTermino;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/div[4]/button")
        public WebElement comprarIngressos;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[3]/div/div/div/div[2]/div[2]/div[2]/div/button")
        public WebElement adicionarAoCarrinho_2Rec;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[4]/div/div/div/div[2]/div[2]/div[2]/div/button")
        public WebElement adicionarAoCarrinho_3Rec;

        @FindBy(xpath = "/html/body/div[2]/div[3]/div/mat-bottom-sheet-container/app-visitors-form/div/div/div[2]/form[1]/mat-form-field/div[1]/div/div[2]/input")
        public WebElement nomeUsuario;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[2]/div/div/mat-form-field[1]/div[1]/div/div[2]/input")
        public WebElement nomeUsuario2;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[3]/div/div/mat-form-field[1]/div[1]/div/div[2]/input")
        public WebElement nomeUsuario3;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card/div[2]/div/mat-form-field[1]/div[1]/div/div[2]/input")
        public WebElement nomeUsuario2brasileiro;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card/div/div/mat-form-field[2]/div[1]/div/div[2]")
        public WebElement tipodocumento;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[2]/div/div/mat-form-field[2]/div[1]/div/div[2]")
        public WebElement tipodocumento2;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[3]/div/div/mat-form-field[2]/div[1]/div/div[2]")
        public WebElement tipodocumento3;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card/div[2]/div/mat-form-field[2]/div[1]/div/div[2]")
        public WebElement tipodocumento2brasileiro;

        @FindBy(xpath = "/html/body/div[2]/div[4]/div/div/mat-option[5]")
        public WebElement outros;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card/div/div/mat-form-field[3]/div[1]/div/div[2]/input")
        public WebElement documento;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[2]/div/div/mat-form-field[3]/div[1]/div/div[2]/input")
        public WebElement documento2;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[3]/div/div/mat-form-field[3]/div[1]/div/div[2]/input")
        public WebElement documento3;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card/div[2]/div/mat-form-field[3]/div[1]/div/div[2]/input")
        public WebElement documento2brasileiro;

        @FindBy(xpath = "/html/body/div[2]/div[3]/div/mat-bottom-sheet-container/app-visitors-form/div/button")
        public WebElement confirmardadosusuario;

        @FindBy(xpath = "/html/body/div[2]/div/div/mat-snack-bar-container/div/div/div/div/my-snackbar/div/div[2]/h4")
        public WebElement pegarMensagemErro;

        @FindBy(xpath = "/html/body/app-root/app-home/main/app-my-cart/ec-wrapper/div[2]/div[6]/button")
        public WebElement irParaPagamento;

        @FindBy(xpath = "/html/body/app-root/app-home/app-footer-cookies-policy/div/section/button[2]")
        public WebElement aceitarcookies;

        @FindBy(xpath = "/html/body/app-root/app-home/main/app-my-cart/ec-wrapper/div[2]/a[2]")
        public WebElement registrarEfinalizarPedido;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/page-pagamento/div/div[5]/div[2]/div/mat-card/mat-card-content/mat-accordion/mat-expansion-panel/div/div/section/span")
        public WebElement datas;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/dashboard/div/div/div/div[1]")
        public WebElement Nome_grupo_ecommerce;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-credenciado/mat-card-content/button[2]")
        public WebElement CódigoCredenciado;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-credenciado/mat-card-content/mat-form-field/div[1]/div/div[2]/input")
        public WebElement ColocarCódigoCredenciado;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-credenciado/div/button[2]")
        public WebElement ConfirmarCredenciado;

        @FindBy(id = "mat-input-8")
        public WebElement EscreverConfirmarSenha;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-bottom-sheet-container/app-minha-conta/div/confirm-password/mat-card/mat-card-actions/button")
        public WebElement botaoConfirmarSenha;

        @FindBy(xpath = "/html/body/app-root/app-home/main/app-my-cart/ec-wrapper/div[1]/div/ec-bilhete-carrinho-card/div/div[2]/div[3]/div[1]/span")
        public WebElement valorBilhete1;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-meu-carrinho/div/div/div[2]/mat-card/div/div[1]/app-bilhete-card/div/div[2]/mat-card/div[2]/div/span[2]")
        public WebElement valorBilhete2_vinculado;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-meu-carrinho/div/div/div[2]/mat-card/div/div[1]/app-bilhete-card/div/div[2]/mat-card/div[1]/div/span[2]")
        public WebElement valorBilhete2;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-meu-carrinho/div/div/div[2]/mat-card/div/div[2]/div[1]/section")
        public WebElement valorSomado;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div[2]/div[1]/div/span/span[2]")
        public WebElement valorTotal_nasCategorias;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div[2]/div/div/div/div[2]/div[1]/div/span/span[3]")
        public WebElement valorDesconto;

        @FindBy(xpath = "/html/body/app-root/app-home/main/page-payment/ec-wrapper/div/div[2]/app-payment-cartao/div/form/mat-form-field[1]/div[1]/div/div[2]/input")
        public WebElement Nome_Do_Cartao;

        @FindBy(xpath = "/html/body/app-root/app-home/main/page-payment/ec-wrapper/div/div[2]/app-payment-cartao/div/form/mat-form-field[2]/div[1]/div/div[2]/input")
        public WebElement Numero_Cartao;

        @FindBy(xpath = "/html/body/app-root/app-home/main/page-payment/ec-wrapper/div/div[2]/app-payment-cartao/div/form/mat-form-field[3]/div[1]/div/div[2]/input")
        public WebElement Mes_Validade;

        @FindBy(xpath = "/html/body/app-root/app-home/main/page-payment/ec-wrapper/div/div[2]/app-payment-cartao/div/form/mat-form-field[4]/div[1]/div/div[2]/input")
        public WebElement codigo_segurança;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/page-pagamento/div/div[4]/div/div/div[3]/mat-form-field[2]/div[1]/div/div[2]/input")
        public WebElement CEP;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/page-pagamento/div/div[4]/div/div/div[3]/mat-form-field[6]/div[1]/div/div[2]/input")
        public WebElement Numero_Casa;

        @FindBy(xpath = "/html/body/app-root/app-home/main/page-payment/ec-wrapper/div/div[2]/app-payment-cartao/div/button")
        public WebElement finalizarCompra;

        @FindBy(xpath = "/html/body/app-root/app-home/main/app-approved-purchase/ec-splash-alert/ec-wrapper/div[2]/h1")
        public WebElement confirmarCompra;

        /* Calendário na home */
        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/dashboard/div/div/home-com-calendario/div/mat-card/div/header/section/button[2]")
        public WebElement proximoMesHome;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/dashboard/div/div/home-com-calendario/div/mat-card/div/div/div/table/tr[4]/td[4]/div/button")
        public WebElement diaHome;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/dashboard/div/div/home-com-calendario/div/section/div/product-card-new/div/div[1]/div/mat-card/section/button")
        public WebElement continuarHome_primeiroBilhete_grupo1;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/dashboard/div/div/home-com-calendario/div/section/div[2]/product-card-new/div/div[1]/div/mat-card/section/button")
        public WebElement continuarHome_primeiroBilhete_grupo2;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-bottom-sheet-container/app-bottom-sheet-overview/div/div[2]/div[2]/app-products-pop-up/div/div[1]/div[1]/mat-card/section/button")
        public WebElement bilhete_extra_popUP_1;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/mat-bottom-sheet-container/app-bottom-sheet-overview/div/div[2]/div[2]/app-products-pop-up/div/div[1]/div[2]/mat-card/section/button")
        public WebElement bilhete_extra_popUP_2;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/dashboard/div/div/home-com-calendario/div/section/div/product-card-new/div/div[1]/div[2]/mat-card/section/button")
        public WebElement continuarHome_segundoBilhete_grupo1;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-info-produtos-new/div/div/div/div[2]/section[2]/div[2]/button")
        public WebElement horarioPopUp;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-info-produtos-new/div/div/div/div[2]/section[2]/div[2]/button")
        public WebElement ConfirmahorarioPopUp;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-info-produtos-new/div/div/div/div[2]/section[3]/div[2]/div/div/button[2]")
        public WebElement categoria1_PopUp;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-info-produtos-new/div/div/div/div[2]/section[3]/div[2]/div[2]/div/button[2]")
        public WebElement categoria2_PopUp;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-info-produtos-new/div/div/div/div[2]/app-coleta-pais-estado/div/div/div[1]/mat-form-field/div[1]/div/div[2]")
        public WebElement PaisDeOrigemPopUP;

        @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/mat-option[2]")
        public WebElement BrasilPopUp;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-info-produtos-new/div/div/div/div[2]/app-coleta-pais-estado/div/div/div[2]/mat-form-field/div[1]/div/div[2]")
        public WebElement EstadoPopUp;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-info-produtos-new/div/div/div/div[2]/app-coleta-pais-estado/div/div/div[2]/mat-form-field/div[1]/div/div[2]/input")
        public WebElement CEPPopUp;

        @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/mat-option[1]")
        public WebElement AcrePopUp;

        @FindBy(xpath = "/html/body/div[2]/div/div/cdk-dialog-container/app-info-produtos-new/div/div/div/div[2]/div[3]/button")
        public WebElement adicionarAoCarrinhoPopUP;

        @FindBy(id = "mat-input-0")
        public WebElement nomeUsuarioPopUp;

        @FindBy(xpath = "/html/body/div[2]/div[3]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card/div/div/mat-form-field[2]/div[1]/div/div[2]")
        public WebElement tipoDocumentoPopUp;

        @FindBy(xpath = "/html/body/div[2]/div[5]/div/div/mat-option[5]")
        public WebElement outrosPopUp;

        @FindBy(xpath = "/html/body/div[2]/div[3]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card/div/div/mat-form-field[3]/div[1]/div/div[2]/input")
        public WebElement documentoPopUp;

        @FindBy(xpath = "/html/body/div[2]/div[3]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-actions/div/button[2]")
        public WebElement confirmardadosdoUsuarioPopUp;

        @FindBy(xpath = "/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/page-pagamento/div/div[4]/div/div/div[2]/mat-form-field[3]/div[1]/div/div[2]")
        public WebElement bandeiracartao;

        @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/mat-option[1]")
        public WebElement visa;

        @FindBy(xpath = "/html/body/app-root/app-home/main/app-authentication/app-login-client/ec-wrapper/ec-error/div/section/span")
        public WebElement captcha;


        public void Nomeusuario( int numero, String nome, WebDriver driver) {
                driver
                                .findElement(By
                                                .xpath("/html/body/div[2]/div[3]/div/mat-bottom-sheet-container/app-visitors-form/div/div/div[2]/form["+numero+"]/mat-form-field[1]/div[1]/div/div[2]/input"))
                                .sendKeys(nome);
        }

        public String ValorBilhete_1(int numero, WebDriver driver) {
                return driver
                                .findElement(By
                                                .xpath("/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-meu-carrinho/div/div/div[2]/mat-card/div/div["
                                                                + numero
                                                                + "]/app-bilhete-card/div/div/mat-card/div[1]/div/span[2]"))
                                .getText();

        }

        public String ValorBilhete_2_vinculado(int numero, WebDriver driver) {
                return driver
                                .findElement(By
                                                .xpath("/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-meu-carrinho/div/div/div[2]/mat-card/div/div["
                                                                + numero
                                                                + "]/app-bilhete-card/div/div[2]/mat-card/div[2]/div/span[2]"))
                                .getText();

        }

        public String valorTotalDoBilhete(int numero, WebDriver driver) {
                return driver
                                .findElement(By
                                                .xpath("/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-meu-carrinho/div/div/div[2]/mat-card/div/div["
                                                                + numero + "]/div[1]/section"))
                                .getText();

        }

        public void tipoDocumento(int grupo, int numero, WebDriver driver) {
                driver
                                .findElement(By
                                                .xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card["
                                                                + grupo + "]/div[" + numero
                                                                + "]/div/mat-form-field[2]/div[1]/div/div[2]"))
                                .click();
        }

        public void estado(int numero, WebDriver driver) {
                driver
                                .findElement(By
                                                .xpath("/html/body/e-commerce/pages/toolbar-menu/div/mat-sidenav-container/mat-sidenav-content/main/app-info-bilhete/div/div/div/mat-card/mat-vertical-stepper/div["+numero+"]/div/div/div/div[1]/app-coleta-pais-estado/div/div/div[2]/mat-form-field/div[1]"))
                                .click();
        }

        public void valorDocumento(int grupo, int numero, String documento, WebDriver driver) {
                driver
                                .findElement(By
                                                .xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card["
                                                                + grupo + "]/div[" + numero
                                                                + "]/div/mat-form-field[3]/div[1]/div/div[2]/input"))
                                .sendKeys(documento);
        }

        public void dataNascimento(int grupo, int numero, String data, WebDriver driver) {
                if (data
                                .equals("")) {
                        driver
                                        .findElement(By
                                                        .xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card["
                                                                        + grupo + "]/div[" + numero
                                                                        + "]/div/mat-form-field[4]/div[1]/div/div[2]/input"))
                                        .clear();
                        ;
                } else {
                        driver
                                        .findElement(By
                                                        .xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card["
                                                                        + grupo + "]/div[" + numero
                                                                        + "]/div/mat-form-field[4]/div[1]/div/div[2]/input"))
                                        .sendKeys(data);
                }
        }

        public void selecionarPaisOrigem(int grupo, int numero, WebDriver driver) {
                driver
                                .findElement(By
                                                .xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card["
                                                                + grupo + "]/div[" + numero
                                                                + "]/div/div[3]/mat-form-field/div[1]/div/div[2]"))
                                .click();
        }

        public void categorias(int numero, WebDriver driver) {
                driver
                                .findElement(By
                                                .xpath("/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-title-with-edit[2]/section/div[3]/div/app-escolha-categoria["+numero+"]/div/div[2]/button[2]"))
                                .click();
        }

        public void Pais(int id, WebDriver driver) {
                driver
                                .findElement(By
                                                .id("mat-option-" + id))
                                .click();
        }

        public void ConfirmarHorarios(int Numeroreceita, int numero, WebDriver driver) {
                driver
                                .findElement(By
                                                .xpath("/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-product-receita["
                                                                + Numeroreceita + "]/app-title-with-edit[" + numero
                                                                + "]/section/div[3]/div/button[1]"))
                                .click();
        }

        public void ProximoMes(int Numeroreceita, WebDriver driver) {
                driver
                                .findElement(By
                                                .xpath("/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-product-receita["
                                                                + Numeroreceita
                                                                + "]/app-title-with-edit[1]/section/div[3]/div/ec-calendar/table/tr[1]/th/div/section/button[2]"))
                                .click();
        }
        
        public void DiaDoMes(int Numeroreceita, WebDriver driver) {
                driver
                                .findElement(By
                                                .xpath("/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/app-product-receita["
                                                                + Numeroreceita
                                                                + "]/app-title-with-edit[1]/section/div[3]/div/ec-calendar/table/tr[5]/td[4]/div/button"))
                                .click();
        }
        
        public void ComprarIngressos(int Numero, WebDriver driver) {
                driver
                                .findElement(By
                                                .xpath("/html/body/div[2]/div/div/cdk-dialog-container/app-product/div/div/div/div[2]/div/div["
                                                                + Numero + "]/button"))
                                .click();
        }

        public void Convenio(int Numero, WebDriver driver) {
                driver
                                .findElement(By
                                                .xpath("/html/body/div[2]/div[3]/div/mat-bottom-sheet-container/app-visitors-form/div/div/div[2]/form["+Numero+"]/mat-form-field[2]/div[1]/div/div[2]"))
                                .click();
        }

        

        

        public void CEP_coletaDeDados(int grupo, int numero, String cep, WebDriver driver) {
                driver
                                .findElement(By
                                                .xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card["
                                                                + grupo + "]/div[" + numero
                                                                + "]/div/div[3]/mat-form-field[2]/div[1]/div/div[2]/input"))
                                .sendKeys(cep);
        }

        public String Erro_ColetaDeDados(int grupo, int numero, WebDriver driver) {
                return driver
                                .findElement(By
                                                .xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-coleta-dados-visitante/div/mat-dialog-content/mat-card[1]/div["
                                                                + numero
                                                                + "]/div/mat-form-field[4]/div[2]/div/mat-error"))
                                .getText();
        }
        
        

        public void dadosUsuarios(int grupo, int numero, String documento, String nome, String data, int id, String cep,
                        WebDriver driver) {
                Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

                Nomeusuario( numero, nome, driver);
                tipoDocumento(grupo, numero, driver);

                wait
                                .until(d -> outros
                                                .isDisplayed());
                outros
                                .click();

                valorDocumento(grupo, numero, documento, driver);
                dataNascimento(grupo, numero, data, driver);
                selecionarPaisOrigem(grupo, numero, driver);
                Pais(id, driver);
                CEP_coletaDeDados(grupo, numero, cep, driver);
        }

}
