package controller;

import model.Aluno;
import services.AlunoService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuController {
    private final Scanner sc;
    private final AlunoService alunoService = new AlunoService();

    public MenuController(Scanner scanner) {
        this.sc = scanner;
    }

    public void iniciar() {
        int opcao = 0;

        do {
            System.out.println("\n==================================");
            System.out.println("           BEM-VINDO(A)           ");
            System.out.println("==================================");
            System.out.println("1. Entrar (Login)");
            System.out.println("2. Cadastrar Novo Usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    // Chama a lógica de autenticação
                    tentarLogin();
                    break;
                case 2:
                    // Vai diretamente para o cadastro de Aluno (Novo Usuário)
                    cadastrarNovoUsuario();
                    break;
                case 0:
                    System.out.println("\nEncerrando a aplicação...");
                    break;
                default:
                    System.out.println("Opção desconhecida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    //--------------------- PASSAR ESSES DOIS MÉTODOS PARA UM CONTROLLER DE AUTENTICAÇÃO ------------------------
    private void tentarLogin() {
        System.out.println("\n--- TENTAR LOGIN ---");
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        // Autenticacao provisória para testes
        if (email.equals("admin") && senha.equals("123")) {
            System.out.println("\n✅ Login bem-sucedido! Bem-vindo!");
            exibirTelaInicialAdmin();
        } else {
            System.err.println("❌ Credenciais inválidas. Tente novamente.");
        }
    }

    private void cadastrarNovoUsuario() {
        System.out.println("\n--- FAZER CADASTRO ---");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        System.out.print("Data nascimento (DD/MM/YYYY): ");
        String dataNascimento = sc.nextLine();

        try {
            Aluno aluno = new Aluno(
                    nome, email, senha,
                    LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            );
            alunoService.cadastrarAluno(aluno);
            System.out.println("✅ Aluno cadastrado com sucesso!");
        } catch (Exception e) {
            System.err.println("❌ Erro ao cadastrar: " + e.getMessage());
        }
    }
    //-------------------------------------------------------------------------------------

    private void exibirTelaInicialAdmin() {
        int opcao = 0;

        do {
            System.out.println("\n==================================");
            System.out.println("       SISTEMA ACADÊMICO JAVA       ");
            System.out.println("==================================");
            System.out.println("1. Menu Alunos");
            System.out.println("2. Menu Professores");
            System.out.println("3. Menu Cursos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    new AlunoController(sc).iniciarMenu();
                    break;
                case 2:
                    System.out.println("Menu de Professores em construção...");
                    // new ProfessorController(scanner).iniciarMenu();
                    break;
                case 3:
                    System.out.println("Menu de Cursos em construção...");
                    // new CursoController(scanner).iniciarMenu();
                    break;
                case 0:
                    System.out.println("\nEncerrando a aplicação...");
                    break;
                default:
                    System.out.println("Opção desconhecida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void exibirTelaInicial() {
        //Tela inicial para alunos
    }




}
