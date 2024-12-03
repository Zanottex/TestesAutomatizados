package automatizado.Generators;

import java.util.Random;

public class geradores {

    private static final Random random = new Random();

    // Gerador de Nome
    public static String geradorNome() {
        String[] nomes = {"Ana", "João", "Carlos", "Maria", "Pedro", "Fernanda", "Lucas", "Juliana"};
        String[] sobrenomes = {"Silva", "Santos", "Oliveira", "Pereira", "Lima", "Gomes", "Almeida", "Costa"};

        StringBuilder nomeCompleto = new StringBuilder();
        nomeCompleto.append(nomes[random.nextInt(nomes.length)]);

        int quantidadeSobrenomes = random.nextInt(4) + 1; // Min 1, Max 4
        for (int i = 0; i < quantidadeSobrenomes; i++) {
            nomeCompleto.append(" ").append(sobrenomes[random.nextInt(sobrenomes.length)]);
        }

        return nomeCompleto.toString();
    }

    // Gerador de CPF
    public static String geradorCPF() {
        int[] cpf = new int[9];
        for (int i = 0; i < 9; i++) {
            cpf[i] = random.nextInt(10);
        }
        int digito1 = calcularDigitoCPF(cpf, 10);
        int digito2 = calcularDigitoCPF(cpf, 11);

        StringBuilder cpfFormatado = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            cpfFormatado.append(cpf[i]);
            if (i == 2 || i == 5) cpfFormatado.append(".");
        }
        cpfFormatado.append("-").append(digito1).append(digito2);

        return cpfFormatado.toString();
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
            cnpj[i] = random.nextInt(10);
        }
        cnpj[8] = 0; // Filial
        cnpj[9] = 0;
        cnpj[10] = 0;
        cnpj[11] = 1;

        int digito1 = calcularDigitoCNPJ(cnpj, 5, 9);
        int digito2 = calcularDigitoCNPJ(cnpj, 6, 9);

        StringBuilder cnpjFormatado = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            cnpjFormatado.append(cnpj[i]);
            if (i == 1 || i == 4) cnpjFormatado.append(".");
            if (i == 7) cnpjFormatado.append("/");
        }
        cnpjFormatado.append("-").append(digito1).append(digito2);

        return cnpjFormatado.toString();
    }

    private static int calcularDigitoCNPJ(int[] cnpj, int pesoInicio, int pesoFim) {
        int soma = 0;
        int peso = pesoInicio;
        for (int i = 0; i < cnpj.length; i++) {
            soma += cnpj[i] * peso--;
            if (peso < 2) peso = pesoFim;
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }

    // Gerador de Passaporte
    public static String geradorPassaporte() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder passaporte = new StringBuilder();

        passaporte.append(letras.charAt(random.nextInt(letras.length())));
        passaporte.append(letras.charAt(random.nextInt(letras.length())));
        for (int i = 0; i < 6; i++) {
            passaporte.append(random.nextInt(10));
        }

        return passaporte.toString();
    }

    // Gerador de Data de Nascimento
    public static String geradorDataNascimento() {
        int dia = random.nextInt(28) + 1; // Evita problemas com fevereiro
        int mes = random.nextInt(12) + 1;
        int ano = random.nextInt(2023 - 1900 + 1) + 1900; // Entre 1900 e 2023

        return String.format("%02d/%02d/%d", dia, mes, ano);
    }

    // Gerador de Telefone
    public static String geradorTelefone() {
        int ddi = random.nextInt(999) + 1; // DDI de 1 a 999
        int ddd = random.nextInt(99) + 1; // DDD de 1 a 99
        int numero = random.nextInt(900000000) + 100000000; // Número com 9 dígitos

        return String.format("+%d (%02d) %d", ddi, ddd, numero);
    }

    // Gerador de CEP
    public static String geradorCEP() {
        int cep = random.nextInt(90000000) + 10000000; // Gera um CEP válido (8 dígitos)
        return String.format("%05d-%03d", cep / 1000, cep % 1000);
    }
}
