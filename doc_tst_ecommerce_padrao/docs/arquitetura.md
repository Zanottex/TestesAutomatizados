# Arquitetura do Software

## Base do Código
O código inicial é baseado em **Java** e **Selenium**, usando a estrutura padrão para softwares de teste com essa base.

## Estrutura do Projeto
A arquitetura e disposição dos repositórios está baseada em:
Teste
Page/PO
Builder

- **Teste**:
  - Inicializador do código.
  - Arquivos nomeados como `nomedofluxoTeste.java`.
  
- **Page/PO**:
  - Repositório que contém os arquivos com a nomenclatura `nomedofluxoPO.java`.
  - Localiza, interage e destaca o status dos elementos em uma tela do e-commerce testado.

- **Builder**:
  - Fluxo principal do código, onde são desenvolvidas regras e passos necessários no e-commerce.
  - Arquivos nomeados como `nomedofluxoBuilder.java`.

## Ferramentas
- **Maven**: Gestor de projeto.
- **Selenium**: Conector com o navegador usado nos testes.
