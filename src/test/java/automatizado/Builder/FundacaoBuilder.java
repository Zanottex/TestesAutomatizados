package automatizado.Builder;

import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.Page.EcommercePO;

public class FundacaoBuilder {

    private EcommercePO ECommercePO;
    private String email_usuario = "gustavozanotto119@gmail.com";
    private String senha_usuario = "1";
    private String Nome_Cartao = "Gustavin Zanottin";
    private String Numero_Cartao = "4000000000000010";
    private String mes_validade = "122500";
    private String codigo_segurança = "123";
    private String CEP = "85509432";
    private String Numero_Casa = "1050"; 
    private String cpf = "09285844960"; 
    
    public void venda_simples(WebDriver driver){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
        
        ECommercePO.barraDePesquisa.sendKeys("Bilhete para fundação");
        ECommercePO.bilhete_a_venda_grupo1.click();

        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            ECommercePO.aceitarcookies.click();
        } catch (Exception e) {
        }
        
        wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
        ECommercePO.barraDePesquisa.sendKeys("Bilhete Fundação com sessão e embarque");
        ECommercePO.bilhete_a_venda_grupo1.click();

        wait.until(d -> ECommercePO.ProximoMes.isDisplayed());
        ECommercePO.ProximoMes.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(d -> ECommercePO.dia.isDisplayed());
        ECommercePO.dia.click();

        wait.until(d -> ECommercePO.localEmbarque.isDisplayed());
        ECommercePO.localEmbarque.click();
        ECommercePO.localEmbarqueConfirmar.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(d -> ECommercePO.esperaHorario.isEnabled());
        ECommercePO.horario.click();
        ECommercePO.confirmarHorario4opcoes.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ECommercePO.sessao.click();
        ECommercePO.sessaoConfirmar.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ECommercePO.proximo.click();

        ECommercePO.adicionarCategoria.click();

        ECommercePO.selecionarPaisOrigem.click();
        
        ECommercePO.paiserrado.click();

        ECommercePO.adicionarAoCarrinho.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String erro = ECommercePO.pegarMensagemErro.getText();

        if(erro != null){
        ECommercePO.selecionarPaisOrigem.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ECommercePO.confirmaPaisOrigem.click();
        ECommercePO.estado.click();
        ECommercePO.acre.click();
        ECommercePO.adicionarAoCarrinho.click();

        wait.until(d -> ECommercePO.nomeUsuario.isDisplayed());
        ECommercePO.nomeUsuario.sendKeys(Nome_Cartao);
        ECommercePO.tipodocumento.click();
        wait.until(d -> ECommercePO.outros.isDisplayed());
        ECommercePO.outros.click();
        ECommercePO.documento.sendKeys(cpf);
        
        ECommercePO.confirmardadosusuario.click();

        wait.until(d -> ECommercePO.valorBilhete1.isDisplayed());
        StringTokenizer resul = new StringTokenizer(ECommercePO.valorBilhete1.getText());
        String valor = resul.nextToken(" ");
        valor = resul.nextToken(" ");
        valor = valor.replaceAll(",", ".");
        Float valor1 = Float.valueOf(valor);

        if(valor1 == 10.00){
            ECommercePO.registrarEfinalizarPedido.click();
            wait.until(d -> ECommercePO.Email_ecommerce.isDisplayed());
            ECommercePO.Email_ecommerce.sendKeys(email_usuario);
            ECommercePO.senha_ecommerce.sendKeys(senha_usuario);
            ECommercePO.Logar.click();

            wait.until(d -> ECommercePO.finalizarPedido.isDisplayed());
            ECommercePO.finalizarPedido.click();

            wait.until(d -> ECommercePO.Nome_Do_Cartao.isDisplayed());

            ECommercePO.Nome_Do_Cartao.sendKeys(Nome_Cartao);
    
            ECommercePO.Numero_Cartao.sendKeys(Numero_Cartao);
    
            ECommercePO.Mes_Validade.sendKeys(mes_validade);
    
            ECommercePO.codigo_segurança.sendKeys(codigo_segurança);
    
            ECommercePO.CEP.sendKeys(CEP);
    
            ECommercePO.Numero_Casa.sendKeys(Numero_Casa);
            try {
                Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
            ECommercePO.finalizarCompra.click();

            wait.until(d -> ECommercePO.confirmarCompra.isDisplayed());
        String mensagem = ECommercePO.confirmarCompra.getText();
        assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.", mensagem);
        }else{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('ERRO: VALOR INVALIDO DO BILHETE');");
    
        }

        }
        else{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('ERRO: PAIS INVALIDO PARA A CATEGORIA!');");
        
        }
    }

    public void multiplas_datas(WebDriver driver){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
        
        ECommercePO.barraDePesquisa.sendKeys("Bilhete para fundação");
        ECommercePO.bilhete_a_venda_grupo1.click();

        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            ECommercePO.aceitarcookies.click();
        } catch (Exception e) {
        }

        wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
        ECommercePO.barraDePesquisa.sendKeys("Bilhete Multiplas Datas de Visita");
        ECommercePO.bilhete_a_venda_grupo1.click();

        wait.until(d -> ECommercePO.ProximoMes.isDisplayed());
        ECommercePO.ProximoMes.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(d -> ECommercePO.dia.isDisplayed());
        ECommercePO.dia.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ECommercePO.diaFim.click();

        wait.until(d -> ECommercePO.DiaInicio.isDisplayed());
            String diaInicio = ECommercePO.DiaInicio.getText();
            int DIAINICIO = Integer.parseInt(diaInicio);
            String diaTermino = ECommercePO.DiaTermino.getText();
            int DIATERMINO = Integer.parseInt(diaTermino);
            String MesInicio = ECommercePO.MesInicio.getText();
            String MesTermino = ECommercePO.MesTermino.getText();
            String AnoInicio = ECommercePO.AnoInicio.getText();
            int ANOINICIO = Integer.parseInt(AnoInicio);
            String AnoTermino = ECommercePO.AnoTermino.getText();
            int ANOTERMINO = Integer.parseInt(AnoTermino);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //wait.until(d -> ECommercePO.localEmbarque.isDisplayed());
        //ECommercePO.localEmbarque.click();
        //try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        // ECommercePO.localEmbarqueConfirmar.click();

        // wait.until(d -> ECommercePO.esperaHorario.isDisplayed());
        // ECommercePO.horario.click();
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // ECommercePO.confirmarHorario4opcoes.click();

        // wait.until(d -> ECommercePO.esperaSessao.isDisplayed());
        // ECommercePO.sessao.click();
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // ECommercePO.sessaoConfirmar.click();

        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        wait.until(d -> ECommercePO.proximo.isEnabled());
        ECommercePO.proximo.click();

        ECommercePO.adicionarCategoria.click();

        ECommercePO.selecionarPaisOrigem.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ECommercePO.paiserrado.click();

        wait.until(d -> ECommercePO.adicionarAoCarrinho.isEnabled());
        ECommercePO.adicionarAoCarrinho.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String erro = ECommercePO.pegarMensagemErro.getText();

        if(erro != null){
        ECommercePO.selecionarPaisOrigem.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ECommercePO.confirmaPaisOrigem.click();
        ECommercePO.estado.click();
        ECommercePO.acre.click();
        ECommercePO.adicionarAoCarrinho.click();

        wait.until(d -> ECommercePO.nomeUsuario.isDisplayed());
        ECommercePO.nomeUsuario.sendKeys(Nome_Cartao);
        ECommercePO.tipodocumento.click();
        wait.until(d -> ECommercePO.outros.isDisplayed());
        ECommercePO.outros.click();
        ECommercePO.documento.sendKeys(cpf);
        
        ECommercePO.confirmardadosusuario.click();

        wait.until(d -> ECommercePO.valorBilhete1.isDisplayed());
        StringTokenizer resul = new StringTokenizer(ECommercePO.valorBilhete1.getText());
        String valor = resul.nextToken(" ");
        valor = resul.nextToken(" ");
        valor = valor.replaceAll(",", ".");
        Float valor1 = Float.valueOf(valor);

        if(valor1 == 70.00){
            ECommercePO.registrarEfinalizarPedido.click();
            wait.until(d -> ECommercePO.Email_ecommerce.isDisplayed());
            ECommercePO.Email_ecommerce.sendKeys(email_usuario);
            ECommercePO.senha_ecommerce.sendKeys(senha_usuario);
            ECommercePO.Logar.click();

            wait.until(d -> ECommercePO.finalizarPedido.isDisplayed());
            ECommercePO.finalizarPedido.click();    

            wait.until(d -> ECommercePO.datas.isDisplayed());
            StringTokenizer datas = new StringTokenizer(ECommercePO.datas.getText());
            String data1 = datas.nextToken("-");
            String resto = datas.nextToken("-");
            StringTokenizer fds = new StringTokenizer(resto);
            String data2 = fds.nextToken(" ");

            StringTokenizer Data1 = new StringTokenizer(data1);
            String dia1 = Data1.nextToken("/");
            int DIA1 = Integer.parseInt(dia1);
            String mes1 = Data1.nextToken("/");
            int MES1 = Integer.parseInt(mes1);
            String ano1 = Data1.nextToken("/");
            ano1 = ano1.replaceAll(" ", "");
            int ANO1 = Integer.parseInt(ano1);
            
 
            StringTokenizer Data2 = new StringTokenizer(data2);
            String dia2 = Data2.nextToken("/");
            int DIA2 = Integer.parseInt(dia2);
            String mes2 = Data2.nextToken("/");
            int MES2 = Integer.parseInt(mes2);
            String ano2 = Data2.nextToken("/");
            ano2 = ano2.replaceAll(" ", "");
            int ANO2 = Integer.parseInt(ano2);

            int MESINICIO = 0;
            int MESTERMINO = 0;
            
            if(MesInicio.equals("Jan")){
                MESINICIO = 1;
            }else if(MesInicio.equals("Feb")){
                MESINICIO = 2;
            }
            else if(MesInicio.equals("Mar")){
                MESINICIO = 3;
            }
            else if(MesInicio.equals("Apr")){
                MESINICIO = 4;
            }
            else if(MesInicio.equals("May")){
                MESINICIO = 5;
            }
            else if(MesInicio.equals("Jun")){
                MESINICIO = 6;
            }
            else if(MesInicio.equals("Jul")){
                MESINICIO = 7;
            }
            else if(MesInicio.equals("Ago")){
                MESINICIO = 8;
            }
            else if(MesInicio.equals("Sep")){
                MESINICIO = 9;
            }
            else if(MesInicio.equals("Oct")){
                MESINICIO = 10;
            }
            else if(MesInicio.equals("Nov")){
                MESINICIO = 11;
            }
            else if(MesInicio.equals("Dec")){
                MESINICIO = 12;
            }

            if(MesTermino.equals("Jan")){
                MESTERMINO = 12;
            }else if(MesTermino.equals("Feb")){
                MESTERMINO = 2;
            }
            else if(MesTermino.equals("Mar")){
                MESTERMINO = 3;
            }
            else if(MesTermino.equals("Apr")){
                MESTERMINO = 4;
            }
            else if(MesTermino.equals("May")){
                MESTERMINO = 5;
            }
            else if(MesTermino.equals("Jun")){
                MESTERMINO = 6;
            }
            else if(MesTermino.equals("Jul")){
                MESTERMINO = 7;
            }
            else if(MesTermino.equals("Ago")){
                MESTERMINO = 8;
            }
            else if(MesTermino.equals("Sep")){
                MESTERMINO = 9;
            }
            else if(MesTermino.equals("Oct")){
                MESTERMINO = 10;
            }
            else if(MesTermino.equals("Nov")){
                MESTERMINO = 11;
            }
            else if(MesTermino.equals("Dec")){
                MESTERMINO = 12;
            }

            if(DIAINICIO == DIA1 && DIATERMINO == DIA2 && MESINICIO == MES1 && MESTERMINO == MES2 && ANOINICIO == ANO1 && ANOTERMINO == ANO2){
                wait.until(d -> ECommercePO.Nome_Do_Cartao.isDisplayed());

            ECommercePO.Nome_Do_Cartao.sendKeys(Nome_Cartao);
    
            ECommercePO.Numero_Cartao.sendKeys(Numero_Cartao);
    
            ECommercePO.Mes_Validade.sendKeys(mes_validade);
    
            ECommercePO.codigo_segurança.sendKeys(codigo_segurança);
    
            ECommercePO.CEP.sendKeys(CEP);
    
            ECommercePO.Numero_Casa.sendKeys(Numero_Casa);
            try {
                Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
            ECommercePO.finalizarCompra.click();

            wait.until(d -> ECommercePO.confirmarCompra.isDisplayed());
            String mensagem = ECommercePO.confirmarCompra.getText();
            assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.", mensagem);
        
            }else{
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("alert('ERRO: DATAS DE VISITAS ERRADAS');");
            }
            
            }else{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert('ERRO: VALOR INVALIDO DO BILHETE');");
        }
        }
        else{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert('ERRO: PAIS INVALIDO PARA A CATEGORIA!');");
        }
    }

    public void credenciado(WebDriver driver){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
        
        ECommercePO.barraDePesquisa.sendKeys("Bilhete para fundação");
        ECommercePO.bilhete_a_venda_grupo1.click();

        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            ECommercePO.aceitarcookies.click();
        } catch (Exception e) {
        }

        wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
        ECommercePO.barraDePesquisa.sendKeys("Bilhete Credenciado");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ECommercePO.bilhete_a_venda_grupo2.click();

        wait.until(d -> ECommercePO.ProximoMes.isDisplayed());
        ECommercePO.ProximoMes.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(d -> ECommercePO.dia.isDisplayed());
        ECommercePO.dia.click();

        ECommercePO.localEmbarque.click();
        ECommercePO.localEmbarqueConfirmar.click();

        wait.until(d -> ECommercePO.CódigoCredenciado.isDisplayed());
        ECommercePO.CódigoCredenciado.click();

        ECommercePO.ColocarCódigoCredenciado.sendKeys("121525");
        ECommercePO.ConfirmarCredenciado.click();
        wait.until(d -> ECommercePO.ConfirmarCredenciado.isDisplayed());
        ECommercePO.ConfirmarCredenciado.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(d -> ECommercePO.esperaHorario.isDisplayed());
        ECommercePO.horario.click();
        ECommercePO.confirmarHorario4opcoes.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ECommercePO.proximo.click();

        ECommercePO.adicionarCategoria.click();

        ECommercePO.selecionarPaisOrigem.click();
        
        ECommercePO.paiserrado.click();

        ECommercePO.adicionarAoCarrinho.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String erro = ECommercePO.pegarMensagemErro.getText();

        if(erro != null){
        ECommercePO.selecionarPaisOrigem.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ECommercePO.confirmaPaisOrigem.click();
        ECommercePO.estado.click();
        ECommercePO.acre.click();
        ECommercePO.adicionarAoCarrinho.click();

        wait.until(d -> ECommercePO.nomeUsuario.isDisplayed());
        ECommercePO.nomeUsuario.sendKeys(Nome_Cartao);
        ECommercePO.tipodocumento.click();
        wait.until(d -> ECommercePO.outros.isDisplayed());
        ECommercePO.outros.click();
        ECommercePO.documento.sendKeys(cpf);
        
        ECommercePO.confirmardadosusuario.click();

        wait.until(d -> ECommercePO.valorBilhete1.isDisplayed());
        StringTokenizer resul = new StringTokenizer(ECommercePO.valorBilhete1.getText());
        String valor = resul.nextToken(" ");
        valor = resul.nextToken(" ");
        valor = valor.replaceAll(",", ".");
        Float valor1 = Float.valueOf(valor);

        if(valor1 == 10.00){
            ECommercePO.registrarEfinalizarPedido.click();
            wait.until(d -> ECommercePO.Email_ecommerce.isDisplayed());
            ECommercePO.Email_ecommerce.sendKeys(email_usuario);
            ECommercePO.senha_ecommerce.sendKeys(senha_usuario);
            ECommercePO.Logar.click();

            wait.until(d -> ECommercePO.finalizarPedido.isDisplayed());
            ECommercePO.finalizarPedido.click();

            wait.until(d -> ECommercePO.Nome_Do_Cartao.isDisplayed());

            ECommercePO.Nome_Do_Cartao.sendKeys(Nome_Cartao);
    
            ECommercePO.Numero_Cartao.sendKeys(Numero_Cartao);
    
            ECommercePO.Mes_Validade.sendKeys(mes_validade);
    
            ECommercePO.codigo_segurança.sendKeys(codigo_segurança);
    
            ECommercePO.CEP.sendKeys(CEP);
    
            ECommercePO.Numero_Casa.sendKeys(Numero_Casa);
            try {
                Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
            ECommercePO.finalizarCompra.click();

            wait.until(d -> ECommercePO.confirmarCompra.isEnabled());
        String mensagem = ECommercePO.confirmarCompra.getText();
        assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.", mensagem);
        }else{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert(''ERRO: VALOR INVALIDO DO BILHETE');");
        }
    }else{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('ERRO: PAIS INVALIDO PARA A CATEGORIA!');");
    }
    }


    public void vinculado(WebDriver driver){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
        
        ECommercePO.barraDePesquisa.sendKeys("Bilhete para fundação");
        ECommercePO.bilhete_a_venda_grupo1.click();

        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            ECommercePO.aceitarcookies.click();
        } catch (Exception e) {
        }

        wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
        ECommercePO.barraDePesquisa.sendKeys("Bilhete Vinculado 1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ECommercePO.bilhete_a_venda_grupo1.click();

        wait.until(d -> ECommercePO.ProximoMes.isDisplayed());
        ECommercePO.ProximoMes.click();
        
            try {
            Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wait.until(d -> ECommercePO.dia.isDisplayed());
            ECommercePO.dia.click();
    
            ECommercePO.localEmbarque.click();
            ECommercePO.localEmbarqueConfirmar.click();
    
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wait.until(d -> ECommercePO.esperaHorario.isDisplayed());
            ECommercePO.horario.click();
            ECommercePO.confirmarHorario4opcoes.click();
    
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        wait.until(d -> ECommercePO.proximo.isEnabled());
        ECommercePO.proximo.click();

        wait.until(d -> ECommercePO.adicionarCategoria.isEnabled());
        ECommercePO.adicionarCategoria.click();

        ECommercePO.selecionarPaisOrigem.click();
        
        ECommercePO.paiserrado.click();

        ECommercePO.adicionarAoCarrinho.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String erro = null;
        try {
          erro = ECommercePO.pegarMensagemErro.getText();
        } catch (Exception e) {
            
        }

        if(erro != null){

            ECommercePO.selecionarPaisOrigem.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ECommercePO.confirmaPaisOrigem.click();
            ECommercePO.estado.click();
            ECommercePO.acre.click();

            wait.until(d -> ECommercePO.valorSomado.isDisplayed());
        StringTokenizer  Result = new StringTokenizer(ECommercePO.valorSomado.getText());
        String valortotal = Result.nextToken(" ");
         valortotal = Result.nextToken(" ");
         valortotal = valortotal.replaceAll(",", ".");
         Double valorsomado = Double.valueOf(valortotal);

         ECommercePO.adicionarAoCarrinho.click();

            wait.until(d -> ECommercePO.nomeUsuario.isDisplayed());
            ECommercePO.nomeUsuario.sendKeys(Nome_Cartao);
            ECommercePO.tipodocumento.click();
            wait.until(d -> ECommercePO.outros.isDisplayed());
            ECommercePO.outros.click();
            ECommercePO.documento.sendKeys(cpf);
            
            ECommercePO.confirmardadosusuario.click();

        wait.until(d -> ECommercePO.valorBilhete1.isDisplayed());
        StringTokenizer resulBilhete1 = new StringTokenizer(ECommercePO.valorBilhete1.getText());
        String valorbilhete1 = resulBilhete1.nextToken(" ");
         valorbilhete1 = resulBilhete1.nextToken(" ");
         valorbilhete1 = valorbilhete1.replaceAll(",", ".");
         Double valor1 = Double.valueOf(valorbilhete1);

        //StringTokenizer resulBilhete2 = new StringTokenizer(ECommercePO.valorBilhete2.getText());
        //String valorbilhete2 = resulBilhete2.nextToken(" ");
         //valorbilhete2 = resulBilhete2.nextToken(" ");
         //valorbilhete2 = valorbilhete2.replaceAll(",", ".");
        Double valor2 = 10.0;//Float.valueOf(valorbilhete2);

        if(valor1 + valor2 == valorsomado){
        
        ECommercePO.registrarEfinalizarPedido.click();
        wait.until(d -> ECommercePO.Email_ecommerce.isDisplayed());
            ECommercePO.Email_ecommerce.sendKeys(email_usuario);
            ECommercePO.senha_ecommerce.sendKeys(senha_usuario);
            ECommercePO.Logar.click();

        wait.until(d -> ECommercePO.finalizarPedido.isDisplayed());
        ECommercePO.finalizarPedido.click();

        wait.until(d -> ECommercePO.Nome_Do_Cartao.isDisplayed());

        ECommercePO.Nome_Do_Cartao.sendKeys(Nome_Cartao);

        ECommercePO.Numero_Cartao.sendKeys(Numero_Cartao);

        ECommercePO.Mes_Validade.sendKeys(mes_validade);

        ECommercePO.codigo_segurança.sendKeys(codigo_segurança);

        ECommercePO.CEP.sendKeys(CEP);

        ECommercePO.Numero_Casa.sendKeys(Numero_Casa);
        try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        ECommercePO.finalizarCompra.click();

        wait.until(d -> ECommercePO.confirmarCompra.isDisplayed());
        String mensagem = ECommercePO.confirmarCompra.getText();
        assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.", mensagem);
        }else{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert(''ERRO: VALOR INVALIDO DO BILHETE');");
        }
    }else{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('ERRO: PAIS INVALIDO PARA A CATEGORIA!');");
        }
    }

    public void progressivo(WebDriver driver){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

        wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
        
        ECommercePO.barraDePesquisa.sendKeys("Bilhete para fundação");
        ECommercePO.bilhete_a_venda_grupo1.click();

        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ECommercePO.aceitarcookies.click();
        } catch (Exception e) {
        }

        wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
        ECommercePO.barraDePesquisa.sendKeys("Bilhete Desconto Progressivo");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ECommercePO.bilhete_a_venda_grupo1.click();

        wait.until(d -> ECommercePO.ProximoMes.isDisplayed());
        ECommercePO.ProximoMes.click();
        
        try {
            Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wait.until(d -> ECommercePO.dia.isDisplayed());
            ECommercePO.dia.click();
    
            ECommercePO.localEmbarque.click();
            ECommercePO.localEmbarqueConfirmar.click();
    
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wait.until(d -> ECommercePO.esperaHorario.isDisplayed());
            ECommercePO.horario.click();
            ECommercePO.confirmarHorario4opcoes.click();
    
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        wait.until(d -> ECommercePO.proximo.isEnabled());
        ECommercePO.proximo.click();

        ECommercePO.adicionarCategoria.click();

        ECommercePO.selecionarPaisOrigem.click();
        
        ECommercePO.paiserrado.click();

        ECommercePO.adicionarAoCarrinho.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String erro = null;
        try {
          erro = ECommercePO.pegarMensagemErro.getText();
        } catch (Exception e) {
            
        }

        if(erro != null){

            ECommercePO.selecionarPaisOrigem.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ECommercePO.confirmaPaisOrigem.click();
            ECommercePO.estado.click();
            ECommercePO.acre.click();
            

        wait.until(d -> ECommercePO.valorSomado.isDisplayed());
        StringTokenizer  Result = new StringTokenizer(ECommercePO.valorSomado.getText());
        String valortotal = Result.nextToken(" ");
         valortotal = Result.nextToken(" ");
         valortotal = valortotal.replaceAll(",", ".");
         Double valorsomado = Double.valueOf(valortotal);

         if(valorsomado == 10.0){
            ECommercePO.adicionarCategoria.click();
            wait.until(d -> ECommercePO.valorDesconto.isDisplayed());
            Result = new StringTokenizer(ECommercePO.valorDesconto.getText());
            valortotal = Result.nextToken(" ");
            valortotal = Result.nextToken(" ");
            valortotal = valortotal.replaceAll(",", ".");
            valorsomado = Double.valueOf(valortotal);

            if(valorsomado == 10.0){
                ECommercePO.tirarcategoria1.click();
                ECommercePO.tirarcategoria1.click();
                ECommercePO.adicionarCategoria2Desconto.click();
                ECommercePO.adicionarCategoria2Desconto.click();
                wait.until(d -> ECommercePO.valorDesconto.isDisplayed());
                Result = new StringTokenizer(ECommercePO.valorDesconto.getText());
                valortotal = Result.nextToken(" ");
                valortotal = Result.nextToken(" ");
                valortotal = valortotal.replaceAll(",", ".");
                valorsomado = Double.valueOf(valortotal);

                if(valorsomado == 5.0){
                    ECommercePO.tirarcategoria2.click();
                    ECommercePO.adicionarCategoria.click();
                
                    wait.until(d -> ECommercePO.valorDesconto.isDisplayed());
                    Result = new StringTokenizer(ECommercePO.valorDesconto.getText());
                    valortotal = Result.nextToken(" ");
                    valortotal = Result.nextToken(" ");
                    valortotal = valortotal.replaceAll(",", ".");
                    valorsomado = Double.valueOf(valortotal);

                    if(valorsomado == 7.50){
                    ECommercePO.adicionarAoCarrinho.click();

                    wait.until(d -> ECommercePO.nomeUsuario.isDisplayed());
                    ECommercePO.nomeUsuario.sendKeys(Nome_Cartao);
                    ECommercePO.tipodocumento.click();
                    wait.until(d -> ECommercePO.outros.isDisplayed());
                    ECommercePO.outros.click();
                    ECommercePO.documento.sendKeys(cpf);
            
                    ECommercePO.nomeUsuario2.sendKeys("Cleitin do grau");
                    ECommercePO.tipodocumento2.click();
                    wait.until(d -> ECommercePO.outros.isDisplayed());
                    ECommercePO.outros.click();
                    ECommercePO.documento2.sendKeys("123456789");
                    ECommercePO.confirmardadosusuario.click();

                    wait.until(d -> ECommercePO.registrarEfinalizarPedido.isDisplayed());
                    ECommercePO.registrarEfinalizarPedido.click();
                    wait.until(d -> ECommercePO.Email_ecommerce.isDisplayed());
                    ECommercePO.Email_ecommerce.sendKeys(email_usuario);
                    ECommercePO.senha_ecommerce.sendKeys(senha_usuario);
                    ECommercePO.Logar.click();

                    wait.until(d -> ECommercePO.finalizarPedido.isDisplayed());
                    ECommercePO.finalizarPedido.click();

                    wait.until(d -> ECommercePO.Nome_Do_Cartao.isDisplayed());

                    ECommercePO.Nome_Do_Cartao.sendKeys(Nome_Cartao);

                    ECommercePO.Numero_Cartao.sendKeys(Numero_Cartao);

                    ECommercePO.Mes_Validade.sendKeys(mes_validade);

                    ECommercePO.codigo_segurança.sendKeys(codigo_segurança);

                    ECommercePO.CEP.sendKeys(CEP);

                    ECommercePO.Numero_Casa.sendKeys(Numero_Casa);
                    try {
                        Thread.sleep(1000);
                        } catch (InterruptedException e) {
                           e.printStackTrace();
                       }

                    ECommercePO.finalizarCompra.click();
                    wait.until(d -> ECommercePO.confirmarCompra.isDisplayed());
                    String mensagem = ECommercePO.confirmarCompra.getText();
                    assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.", mensagem);
                }                   
                            else{
                            JavascriptExecutor js = (JavascriptExecutor) driver;
                            js.executeScript("alert('ERRO: VALOR INVALIDO DO DESCONTO COM DIFERENTES CATEGORIAS É MAIOR OU MENOR');");
                            }
                        }else{
                            JavascriptExecutor js = (JavascriptExecutor) driver;
                            js.executeScript("alert('ERRO: VALOR INVALIDO DO DESCONTO VALOR MAIOR OU MENOR');");
                        }
                    }else{
                      JavascriptExecutor js = (JavascriptExecutor) driver;
                      js.executeScript("alert('ERRO: VALOR INVALIDO DO DESCONTO VALOR MAIOR OU MENOR');");
                    }
            }else{
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("alert('ERRO: VALOR INVALIDO DO DESCONTO QUANTIDADE DE BILHETES MENOR QUE A REQUERIDA');");  
             }
    }else{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('ERRO: PAIS INVALIDO PARA A CATEGORIA!');");
    }
}

public void quantidadeMinima(WebDriver driver){
    Wait<WebDriver> wait = new WebDriverWait(driver, 5000);

    wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
    
    ECommercePO.barraDePesquisa.sendKeys("Bilhete para fundação");
    ECommercePO.bilhete_a_venda_grupo1.click();

    try {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ECommercePO.aceitarcookies.click();
    } catch (Exception e) {
    }

    wait.until(d -> ECommercePO.barraDePesquisa.isDisplayed());
    ECommercePO.barraDePesquisa.sendKeys("Bilhete quantidade mínima");
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    ECommercePO.bilhete_a_venda_grupo1.click();

    wait.until(d -> ECommercePO.ProximoMes.isDisplayed());
    ECommercePO.ProximoMes.click();
    
    try {
        Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(d -> ECommercePO.dia.isDisplayed());
        ECommercePO.dia.click();

        ECommercePO.localEmbarque.click();
        ECommercePO.localEmbarqueConfirmar.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(d -> ECommercePO.esperaHorario.isDisplayed());
        ECommercePO.horario.click();
        ECommercePO.confirmarHorario4opcoes.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    wait.until(d -> ECommercePO.proximo.isEnabled());
    ECommercePO.proximo.click();

    wait.until(d -> ECommercePO.adicionarCategoria.isEnabled());
    ECommercePO.adicionarCategoria.click();

    ECommercePO.selecionarPaisOrigem.click();
    
    ECommercePO.paiserrado.click();
    
    ECommercePO.adicionarAoCarrinho.click();


    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    String erro = null;
    try {
      erro = ECommercePO.pegarMensagemErro.getText();
    } catch (Exception e) {
        
    }

    if(erro != null){

        ECommercePO.selecionarPaisOrigem.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ECommercePO.confirmaPaisOrigem.click();
        ECommercePO.estado.click();
        ECommercePO.acre.click();

        ECommercePO.tirarcategoria1.click();

        boolean possivel = true;
        try {
            possivel = ECommercePO.adicionarAoCarrinho.isEnabled();
        } catch (Exception e) {
         // TODO: handle exception
        }

    if(possivel == false){

        ECommercePO.adicionarCategoria.click();

        wait.until(d -> ECommercePO.valorSomado.isDisplayed());
    StringTokenizer  Result = new StringTokenizer(ECommercePO.valorSomado.getText());
    String valortotal = Result.nextToken(" ");
     valortotal = Result.nextToken(" ");
     valortotal = valortotal.replaceAll(",", ".");
     Double valorsomado = Double.valueOf(valortotal);
    
     if(20.00 == valorsomado){
    
        ECommercePO.adicionarAoCarrinho.click();

        wait.until(d -> ECommercePO.nomeUsuario.isDisplayed());
        ECommercePO.nomeUsuario.sendKeys(Nome_Cartao);
        ECommercePO.tipodocumento.click();
        wait.until(d -> ECommercePO.outros.isDisplayed());
        ECommercePO.outros.click();
        ECommercePO.documento.sendKeys(cpf);

        ECommercePO.nomeUsuario2brasileiro.sendKeys("Cleitin do grau");
        ECommercePO.tipodocumento2brasileiro.click();
        wait.until(d -> ECommercePO.outros.isDisplayed());
        ECommercePO.outros.click();
        ECommercePO.documento2brasileiro.sendKeys("123456789");
        ECommercePO.confirmardadosusuario.click();
        
        wait.until(d -> ECommercePO.registrarEfinalizarPedido.isDisplayed());
        ECommercePO.registrarEfinalizarPedido.click();
   
        wait.until(d -> ECommercePO.Email_ecommerce.isDisplayed());
        ECommercePO.Email_ecommerce.sendKeys(email_usuario);
        ECommercePO.senha_ecommerce.sendKeys(senha_usuario);
        ECommercePO.Logar.click();

    
        wait.until(d -> ECommercePO.finalizarPedido.isDisplayed());
        ECommercePO.finalizarPedido.click();

        wait.until(d -> ECommercePO.Nome_Do_Cartao.isDisplayed());

        ECommercePO.Nome_Do_Cartao.sendKeys(Nome_Cartao);

        ECommercePO.Numero_Cartao.sendKeys(Numero_Cartao);

        ECommercePO.Mes_Validade.sendKeys(mes_validade);

        ECommercePO.codigo_segurança.sendKeys(codigo_segurança);

        ECommercePO.CEP.sendKeys(CEP);

        ECommercePO.Numero_Casa.sendKeys(Numero_Casa);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ECommercePO.finalizarCompra.click();

        wait.until(d -> ECommercePO.confirmarCompra.isDisplayed());
        String mensagem = ECommercePO.confirmarCompra.getText();
        assertEquals("Em breve você receberá os ingressos em seu e-mail e também poderá realizar a impressão dos mesmos acessando 'Minhas Reservas'.", mensagem);
     }else{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert(''ERRO: VALOR INVALIDO DO BILHETE');");
     }
    }else{
        JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("alert('ERRO: QUANTIDADE MINIMA NÃO ATINGIDA');");
    }
}else{
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("alert('ERRO: PAIS INVALIDO PARA A CATEGORIA!');");
    }
}
    public FundacaoBuilder (EcommercePO e ){
        this.ECommercePO = e;
    }

    public FundacaoBuilder mudarNome_Cartao(String nome){
        this.Nome_Cartao = nome;
        return this;
    }

    public FundacaoBuilder mudarNumero_Cartao(String numero){
        this.Numero_Cartao = numero;
        return this;
    }

    public FundacaoBuilder mudarMes_validade(String mes){
        this.mes_validade = mes;
        return this;
    }

    public FundacaoBuilder mudarsenha_usuario(String senha){
        this.senha_usuario = senha;
        return this;
    }

    public FundacaoBuilder mudarCodigo_Segurança(String codigo){
        this.codigo_segurança = codigo;
        return this;
    }

    public FundacaoBuilder mudarCEP(String cep){
        this.CEP = cep;
        return this;
    }

    public FundacaoBuilder mudarNumero_Casa(String numero_Casa){
        this.Numero_Casa = numero_Casa;
        return this;
    }

    
 
}
