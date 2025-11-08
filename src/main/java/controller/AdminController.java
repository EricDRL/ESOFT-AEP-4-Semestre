package controller;

import services.AlunoService;
import util.ScannerUtil;

public class AdminController {
    private static final AlunoService alunoService = new AlunoService();

    private AdminController() {}

    public static void exibirTelaInicialAdmin() {
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
            opcao = ScannerUtil.lerInt();

            switch (opcao) {
                case 1 -> menuAlunos();
                case 2 -> System.out.println("Menu de Professores em construção...");
                case 3 -> CursoController.exibirMenuCurso();
                case 0 -> System.out.println("\nEncerrando a aplicação...");
                default -> System.out.println("Opção desconhecida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void menuAlunos() {
        int opcao = 0;
        do {
            System.out.println("\n--- MENU ALUNOS ---");
            System.out.println("1. Listar Alunos");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = ScannerUtil.lerInt();

            switch (opcao) {
                case 1 -> listarAlunos();
            }
        } while (opcao != 0);
    }

    private static void listarAlunos() {
        var alunos = alunoService.getAlunos();

        if (alunos == null || alunos.isEmpty()) {
            System.out.println("\nNenhum aluno cadastrado.");
            return;
        }

        System.out.println("\n--- LISTA DE ALUNOS ---");
        alunos.forEach(a -> {
            System.out.println("- Id: "+a.getId()+", Nome: "+a.getNome()+", Email: "+a.getEmail()+", Data Nascimento: "+a.getDataNascimento());
        });

        ScannerUtil.lerLinha();
    }

}
