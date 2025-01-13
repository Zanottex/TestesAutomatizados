package automatizado.Generators;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import automatizado.Page.EcommercePO;

public class geradores {

        private static final Random random = new Random();
        private static EcommercePO ECommercePO;

        // Gerador de Nome
        public static String geradorNome() {
                String[] nomes = { "Ana", "João", "Carlos", "Maria", "Pedro", "Fernanda", "Lucas", "Juliana" };
                String[] sobrenomes = { "Silva", "Santos", "Oliveira", "Pereira", "Lima", "Gomes", "Almeida", "Costa" };

                StringBuilder nomeCompleto = new StringBuilder();
                nomeCompleto
                                .append(nomes[random
                                                .nextInt(nomes.length)]);

                int quantidadeSobrenomes = random
                                .nextInt(4) + 1; // Min 1, Max 4
                for (int i = 0; i < quantidadeSobrenomes; i++) {
                        nomeCompleto
                                        .append(" ")
                                        .append(sobrenomes[random
                                                        .nextInt(sobrenomes.length)]);
                }

                return nomeCompleto
                                .toString();
        }

        // Gerador de CPF
        public static String geradorCPF() {
                int[] cpf = new int[9];
                for (int i = 0; i < 9; i++) {
                        cpf[i] = random
                                        .nextInt(10);
                }
                int digito1 = calcularDigitoCPF(cpf, 10);
                int digito2 = calcularDigitoCPF(cpf, 11);

                StringBuilder cpfFormatado = new StringBuilder();
                for (int i = 0; i < 9; i++) {
                        cpfFormatado
                                        .append(cpf[i]);
                        if (i == 2 || i == 5)
                                cpfFormatado
                                                .append(".");
                }
                cpfFormatado
                                .append("-")
                                .append(digito1)
                                .append(digito2);

                return cpfFormatado
                                .toString();
        }

        private static int calcularDigitoCPF(int[] cpf, int peso) {
                int soma = 0;
                for (int num : cpf) {
                        soma += num * peso--;
                }
                int resto = soma % 11;
                return (resto < 2) ? 0 : 11 - resto;
        }

        // Gerador de CNPJ
        public static String geradorCNPJ() {
                int[] cnpj = new int[12];
                for (int i = 0; i < 8; i++) {
                        cnpj[i] = random
                                        .nextInt(10);
                }
                cnpj[8] = 0; // Filial
                cnpj[9] = 0;
                cnpj[10] = 0;
                cnpj[11] = 1;

                int digito1 = calcularDigitoCNPJ(cnpj, 5, 9);
                int digito2 = calcularDigitoCNPJ(cnpj, 6, 9);

                StringBuilder cnpjFormatado = new StringBuilder();
                for (int i = 0; i < 12; i++) {
                        cnpjFormatado
                                        .append(cnpj[i]);
                        if (i == 1 || i == 4)
                                cnpjFormatado
                                                .append(".");
                        if (i == 7)
                                cnpjFormatado
                                                .append("/");
                }
                cnpjFormatado
                                .append("-")
                                .append(digito1)
                                .append(digito2);

                return cnpjFormatado
                                .toString();
        }

        private static int calcularDigitoCNPJ(int[] cnpj, int pesoInicio, int pesoFim) {
                int soma = 0;
                int peso = pesoInicio;
                for (int i = 0; i < cnpj.length; i++) {
                        soma += cnpj[i] * peso--;
                        if (peso < 2)
                                peso = pesoFim;
                }
                int resto = soma % 11;
                return (resto < 2) ? 0 : 11 - resto;
        }

        // Gerador de Passaporte
        public static String geradorPassaporte() {
                String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                StringBuilder passaporte = new StringBuilder();

                passaporte
                                .append(letras
                                                .charAt(random
                                                                .nextInt(letras
                                                                                .length())));
                passaporte
                                .append(letras
                                                .charAt(random
                                                                .nextInt(letras
                                                                                .length())));
                for (int i = 0; i < 6; i++) {
                        passaporte
                                        .append(random
                                                        .nextInt(10));
                }

                return passaporte
                                .toString();
        }

        static boolean datainvalida = true;

        // Gerador de Data de Nascimento
        public static String geradorDataNascimento(int idademinima, int idademaxima, WebDriver driver) {
                String datanascimento = null;
                boolean dataValida = true;

                while (dataValida) {
                        int dia = random
                                        .nextInt(28) + 1; // Evita problemas com fevereiro
                        int mes = random
                                        .nextInt(12) + 1;
                        int ano = random
                                        .nextInt(2023 - 1900 + 1) + 1900; // Entre 1900 e 2023
                        LocalDate datagerada = LocalDate
                                        .of(ano, mes, dia);
                        LocalDate datahoje = LocalDate
                                        .now();

                        // Calcular a diferença entre as duas datas

                        Period periodo = Period
                                        .between(datagerada, datahoje);

                        int diferencaAnos = periodo
                                        .getYears();
                        if (datainvalida) {
                                if (idademinima > 0) {

                                        if (diferencaAnos < idademinima) {
                                                datanascimento = String
                                                                .format("%02d/%02d/%d", dia, mes, ano);
                                                String erro = null;
                                                ECommercePO = new EcommercePO(driver);
                                                ECommercePO
                                                                .dataNascimento(1, 1, datanascimento, driver);

                                                try {
                                                        ECommercePO.nomeUsuario
                                                                        .click();
                                                        Thread
                                                                        .sleep(1000);
                                                } catch (InterruptedException e) {
                                                        e
                                                                        .printStackTrace();
                                                }
                                                erro = ECommercePO
                                                                .Erro_ColetaDeDados(1, 1, driver);
                                                ECommercePO
                                                                .dataNascimento(1, 1, "", driver);
                                                if (erro != null) {
                                                        datainvalida = false;
                                                }

                                        } else {
                                                dia = random
                                                                .nextInt(28) + 1; // Evita problemas com fevereiro
                                                mes = random
                                                                .nextInt(12) + 1;
                                                ano = random
                                                                .nextInt(2023 - 1900 + 1) + 1900; // Entre 1900 e 2023
                                                periodo = Period
                                                                .between(datagerada, datahoje);

                                                // Obter a diferença em anos
                                                diferencaAnos = periodo
                                                                .getYears();
                                        }
                                } else {
                                        datainvalida = false;
                                }
                        } else if (diferencaAnos > idademinima && diferencaAnos < idademaxima) {
                                datanascimento = String
                                                .format("%02d/%02d/%d", dia, mes, ano);
                                dataValida = false;
                        }
                }
                return datanascimento;
        }

        // Gerador de Telefone
        public static String geradorTelefone() {
                int ddi = random
                                .nextInt(999) + 1; // DDI de 1 a 999
                int ddd = random
                                .nextInt(99) + 1; // DDD de 1 a 99
                int numero = random
                                .nextInt(900000000) + 100000000; // Número com 9 dígitos

                return String
                                .format("+%d (%02d) %d", ddi, ddd, numero);
        }

        // Gerador de CEP
        public static String geradorCEP() {
                int cep = random
                                .nextInt(90000000) + 10000000; // Gera um CEP válido (8 dígitos)
                return String
                                .format("%05d-%03d", cep / 1000, cep % 1000);
        }

        // Gerador de Número de Cartão
        public static String geradorNumeroCartao() {
                StringBuilder numeroCartao = new StringBuilder();
                for (int i = 0; i < 16; i++) { // Cartão com 16 dígitos
                        numeroCartao
                                        .append(random
                                                        .nextInt(10));
                        if (i % 4 == 3 && i < 15)
                                numeroCartao
                                                .append(" "); // Formata em blocos de 4
                }
                return numeroCartao
                                .toString();
        }

        // Gerador de Validade do Cartão
        public static String geradorValidadeCartao() {
                int mes = random
                                .nextInt(12) + 1; // Mês de 1 a 12
                int ano = random
                                .nextInt(10) + 2024; // Ano atual até 10 anos no futuro
                return String
                                .format("%02d/%d", mes, ano);
        }

        // Gerador de Código de Segurança
        public static String geradorCodigoSeguranca() {
                int codigo = random
                                .nextInt(900) + 100; // Código com 3 dígitos (100 a 999)
                return String
                                .valueOf(codigo);
        }

        // Gerador de Número de Casa
        public static String geradorNumeroCasa() {
                return String
                                .valueOf(random
                                                .nextInt(9999) + 1); // Número de 1 a 9999
        }

        // Gerador de Complemento
        public static String geradorComplemento() {
                String[] complementos = { "Apto 101", "Bloco B", "Casa 2", "Térreo", "Cobertura", "Fundos", "Esquina",
                                "Sala 302" };
                return complementos[random
                                .nextInt(complementos.length)];
        }
}