package controller;

import services.AlunoService;

import java.util.Scanner;

public class AlunoController {
    private final AlunoService alunoService = new AlunoService();
    private final Scanner sc;

    public AlunoController(Scanner sc) {
        this.sc = sc;
    }

    public void iniciarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("\n--- MENU ALUNOS ---");
            System.out.println("1. Listar Alunos");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    listar();
                    break;
                case 2:

                    break;
                // ...
            }
        } while (opcao != 0);
    }

    private void listar() {
        var alunos = alunoService.getAlunos();
        alunos.forEach(a -> System.out.println(a.getNome()));
    }
}
