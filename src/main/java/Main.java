import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");
    private static final List<Funcionario> funcionarios = new ArrayList<>();

    public static void main(String[] args) {
        inserirFuncionarios();
        removerFuncionario("João");
        imprimirFuncionarios();
        aplicarAumentoSalario(10);
        Map<String, List<Funcionario>> funcionariosPorFuncao = agruparFuncionariosPorFuncao();
        imprimirFuncionariosPorFuncao(funcionariosPorFuncao);
        imprimirAniversarios(10);
        imprimirAniversarios(12);
        imprimirFuncionarioMaisVelho();
        imprimirFuncionariosOrdenados();
        imprimirTotalSalarios();
        imprimirSalariosMinimos();
    }

    private static void inserirFuncionarios() {
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operado"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordernador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eltricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
    }

    private static void removerFuncionario(String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    private static void imprimirFuncionarios() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + ", " + f.getDataNascimento().format(formatter) + ", " +
                    f.getSalario().toString().replace(".", ",") + ", " + f.getFuncao());
        }
    }

    private static void aplicarAumentoSalario(double percentual) {
        for (Funcionario f : funcionarios) {
            BigDecimal aumento = f.getSalario().multiply(BigDecimal.valueOf(percentual / 100));
            f.setSalario(f.getSalario().add(aumento));
        }
    }

    private static Map<String, List<Funcionario>> agruparFuncionariosPorFuncao() {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    private static void imprimirFuncionariosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            for (Funcionario f : entry.getValue()) {
                System.out.println(" - " + f.getNome());
            }
        }
    }

    private static void imprimirAniversarios(int mes) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Funcionario f : funcionarios) {
            if (f.getDataNascimento().getMonthValue() == mes) {
                System.out.println(f.getNome() + ", " + f.getDataNascimento().format(formatter));
            }
        }
    }

    private static void imprimirFuncionarioMaisVelho() {
        Funcionario maisVelho = Collections.max(funcionarios, Comparator.comparing(Pessoa::getDataNascimento));
        int idade = LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear();
        System.out.println("Funcionário mais velho: " + maisVelho.getNome() + ", Idade: " + idade);
    }

    private static void imprimirFuncionariosOrdenados() {
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> System.out.println(f.getNome()));
    }

    private static void imprimirTotalSalarios() {
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total dos salários: " + totalSalarios.toString().replace(".", ","));
    }

    private static void imprimirSalariosMinimos() {
        for (Funcionario f : funcionarios) {
            BigDecimal salariosMinimos = f.getSalario().divide(SALARIO_MINIMO, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + " ganha " + salariosMinimos.toString().replace(".", ",") + " salários mínimos.");
        }
    }
}