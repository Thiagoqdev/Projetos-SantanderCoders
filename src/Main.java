import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        /*
        ContaCorrente contaCorrente1 = new ContaCorrente("123", "1", 0, 456);
        contaCorrente1.depositar(100);
        contaCorrente1.sacar(50);
        contaCorrente1.getSaldo();
        */

//        ContaCorrente contaCorrente = new ContaCorrente("123", "458", 100, 5);
//        Usuario usuario = new Usuario("123", "484", 100, 123, "aaa", "123456789", "asnodhasoid", contaCorrente);
//        Usuario usuario2 = new Usuario("123", "484", 100, 123, "aaa", "123456789", "asnodhasoid", contaCorrente);
//        Usuario usuario3 = new Usuario("123", "484", 100, 123, "aaa", "123456789", "asnodhasoid", contaCorrente);
//        Usuario usuario4 = new Usuario("123", "484", 100, 123, "aaa", "123456789", "asnodhasoid", contaCorrente);
//        Usuario usuario5 = new Usuario("123", "484", 100, 123, "aaa", "123456789", "asnodhasoid", contaCorrente);
//        Usuario usuario6 = new Usuario("123", "484", 100, 123, "aaa", "123456789", "asnodhasoid", contaCorrente);
//
//        usuario.adicionaUsuarioNaLista(usuario);
//        usuario.adicionaUsuarioNaLista(usuario2);
//        usuario.adicionaUsuarioNaLista(usuario3);
//        usuario.adicionaUsuarioNaLista(usuario4);
//        usuario.adicionaUsuarioNaLista(usuario5);
//        usuario.adicionaUsuarioNaLista(usuario6);
//
//       for(Usuario u : usuario.listaUsuarios){
//       System.out.println("Lista: " + u);
//       }

        List<Usuario> listaUsuarios = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            titulo();
            menu();
            int opcao = stdin.nextInt();
            stdin.nextLine();

            switch (opcao) {
                case 1:
                    // Cadastrar cliente
                    System.out.println("Digite o nome do titular:");
                    String titular = stdin.nextLine();
                    System.out.println("Digite o telefone:");
                    String telefone = stdin.nextLine();
                    System.out.println("Digite o email:");
                    String email = stdin.nextLine();

                    Usuario usuario = new Usuario(titular, telefone, email);

                    System.out.println("Escolha o tipo de conta: 1 para Conta Corrente, 2 para Conta Poupança:");
                    int tipoConta = stdin.nextInt();
                    stdin.nextLine(); // Limpar o buffer

                    if (tipoConta == 1) {
                        // Solicitar informações específicas para Conta Corrente
                        System.out.println("Digite o número da conta:");
                        String numeroDaConta = stdin.nextLine();
                        System.out.println("Digite a data de abertura do conta:");
                        String dataDeAbertura = stdin.nextLine();
                        System.out.println("Digite o saldo inicial:");
                        double saldoInicial = stdin.nextDouble();
                        System.out.println("Digite o número da agência:");
                        int agencia = stdin.nextInt();
                        stdin.nextLine();

                        ContaCorrente contaCorrente = new ContaCorrente(numeroDaConta, dataDeAbertura, saldoInicial, agencia);
                        usuario.adicionarConta(contaCorrente);
                    } else {
                        // Solicitar informações específicas para Conta Poupança
                        System.out.println("Digite o número da conta:");
                        String numeroDaConta = stdin.nextLine();
                        System.out.println("Digite a data de abertura da conta:");
                        String dataDeAbertura = stdin.nextLine();
                        System.out.println("Digite o saldo inicial:");
                        double saldoInicial = stdin.nextDouble();
                        System.out.println("Digite o número da agência:");
                        int agencia = stdin.nextInt();
                        stdin.nextLine();

                        ContaPoupanca contaPoupanca = new ContaPoupanca(numeroDaConta, dataDeAbertura, saldoInicial, agencia);
                        usuario.adicionarConta(contaPoupanca);
                    }

                    listaUsuarios.add(usuario);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    // Detalhes de cliente
                    System.out.println("Digite o nome do titular para exibir detalhes:");
                    String nomeBusca = stdin.nextLine();
                    for (Usuario u : listaUsuarios) {
                        if (u.getTitular().equalsIgnoreCase(nomeBusca)) {
                            System.out.println("Detalhes do cliente: " + u);
                        }
                    }
                    break;
                case 3:
                    // Editar informações de cliente
                    System.out.println("Digite o nome do titular para editar:");
                    String nomeEditar = stdin.nextLine();
                    for (Usuario u : listaUsuarios) {
                        if (u.getTitular().equalsIgnoreCase(nomeEditar)) {
                            System.out.println("Digite o novo telefone:");
                            u.setTelefone(stdin.nextLine());
                            System.out.println("Digite o novo email:");
                            u.setEmail(stdin.nextLine());
                            System.out.println("Informações atualizadas com sucesso!");
                        }
                    }
                    break;
                case 4:
                    // Remover cliente
                    System.out.println("Digite o nome do titular para remover:");
                    String nomeRemover = stdin.nextLine();
                    listaUsuarios.removeIf(u -> u.getTitular().equalsIgnoreCase(nomeRemover));
                    System.out.println("Cliente removido com sucesso!");
                    break;
                case 5:
                    // Listar todos os clientes
                    System.out.println("Lista de todos os clientes:");
                    for (Usuario u : listaUsuarios) {
                        System.out.println(u);
                    }
                    break;
                case 6:
                    // Sair do menu
                    continuar = false;
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        stdin.close();
    }

    public static void menu() {
        System.out.println("Menu selecione as opções:");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Detalhes de cliente");
        System.out.println("3. Editar informações de cliente");
        System.out.println("4. Remover cliente");
        System.out.println("5. Listar todos os clientes");
        System.out.println("6. Sair do menu.");
    }

    public static void titulo() {
        System.out.println();
        System.out.println("################################");
        System.out.println("######## BANCO BUGSOFT #########");
        System.out.println("################################");
        System.out.println();
    }
}




















        /*
        List<String> listaDeNomes = new ArrayList<>();
        List<Long> listaDeNumeros = new ArrayList<>();
        List<String> listaDeEmails = new ArrayList<>();

        int indice = -1;

        boolean menuOn = true;

        while (menuOn) {
            titulo();
            if (listaDeNomes.isEmpty()) {
                String red = "\u001B[31m";
                String reset = "\u001B[0m";
                System.out.println(red + "Empty." + reset);
                System.out.println();
            } else {
                for (int i = 0; i < listaDeNumeros.size(); i++) {
                    indice = i;
                    System.out.println(indice + 1 + "  | " + listaDeNomes.get(indice) + " | " + listaDeNumeros.get(indice) + " | " + listaDeEmails.get(indice));
                }
                System.out.println();
            }

            menu();
            try {
                int option = stdin.nextInt();
                stdin.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("Informe o nome do contato: ");
                        listaDeNomes.add(stdin.nextLine());
                        boolean numeroValido = false;
                        while (numeroValido == false) {
                            System.out.println("Informe o numero do contato: ");
                            try {
                                listaDeNumeros.add(stdin.nextLong());
                                stdin.nextLine();
                                numeroValido = true;
                            } catch (InputMismatchException errou) {
                                System.out.println("Nosso planeta não utiliza letras em números de telefone.");
                                stdin.nextLine();
                            }
                        }
                        System.out.println("Informe o email do contato: ");
                        listaDeEmails.add(stdin.next());
                        break;

                    case 2:
                        indice = -1;
                        if (listaDeNomes.isEmpty()) {
                            System.err.println("Prezado, a lista está vazia.");
                            break;
                        }
                        System.out.println("Informe o nome do contato a ser detalhado: ");
                        String nameDetail = stdin.nextLine();
                        for (int i = 0; i < listaDeNomes.size(); i++) {
                            if (listaDeNomes.get(i).equalsIgnoreCase(nameDetail)) {
                                indice = i;
                            }
                        }
                        if (indice < 0) {
                            System.out.println(nameDetail + " não localizado.");
                            System.out.println("Prezado(a), erros de digitação não são ignorados.");
                            System.out.println();
                        } else {
                            System.out.println("ID | Nome        | Telefone    | E-mail");
                            System.out.println(indice + 1 + "  | " + listaDeNomes.get(indice) + " | " + listaDeNumeros.get(indice) + " | " + listaDeEmails.get(indice));
                            break;
                        }
                        break;

                    case 3:
                        indice = -1;
                        if (listaDeNomes.isEmpty()) {
                            System.err.println("Prezado, a lista está vazia.");
                            break;
                        }
                        System.out.println("Informe o nome do contato a ser editado: ");
                        String nameEdit = stdin.nextLine();
                        for (int i = 0; i < listaDeNomes.size(); i++) {
                            if (listaDeNomes.get(i).equalsIgnoreCase(nameEdit)) {
                                indice = i;
                            }
                        }
                        if (indice < 0) {
                            System.out.println("Nome não localizado na lista.");
                            System.out.println("Prezado(a), erros de digitação não são ignorados.");
                        } else {
                            System.out.println();
                            System.out.println("Digite o novo nome do contato: ");
                            String newName = stdin.nextLine();
                            listaDeNomes.set(indice, newName);
                            boolean newNumeroValido = false;
                            while (newNumeroValido == false) {
                                try {
                                    System.out.println("Digite o novo Telefone do contato: ");
                                    Long newTelefone = stdin.nextLong();
                                    stdin.nextLine();
                                    listaDeNumeros.set(indice, newTelefone);
                                    newNumeroValido = true;
                                } catch (InputMismatchException errei) {
                                    System.out.println("Nosso planeta não utiliza letras em números de telefone.");
                                    stdin.nextLine();
                                }
                            }
                            System.out.println("Digite o novo E-mail do contato: ");
                            String newEmail = stdin.next();
                            listaDeEmails.set(indice, newEmail);
                        }
                        break;
                    case 4:
                        indice = -1;
                        if (listaDeNomes.isEmpty()) {
                            System.err.println("Prezado, a lista está vazia.");
                            break;
                        }
                        System.out.println("Informe o nome do contato a ser removido: ");
                        String nameRemove = stdin.nextLine();
                        for (int i = 0; i < listaDeNomes.size(); i++) {
                            if (listaDeNomes.get(i).equalsIgnoreCase(nameRemove)) {
                                indice = i;
                            }
                        }
                        if (indice < 0) {
                            System.out.println("Contato não localizado na lista.");
                            System.out.println("Prezado(a), erros de digitação não são ignorados.");
                        } else {
                            listaDeNomes.remove(indice);
                            listaDeNumeros.remove(indice);
                            listaDeEmails.remove(indice);
                            System.out.println("Contato " + nameRemove + " removido com sucesso.");
                        }
                        break;
                    case 5:
                        menuOn = false;
                        System.out.println("Saindo do menu.");
                        break;
                    default:
                        System.err.println("Você é alfabetizado, digite um número coerente com o Menu.");
                        System.out.println();
                }
            } catch (Exception errei) {
                System.err.println("Você é alfabetizado, digite um número coerente com o Menu.");
                stdin.nextLine();
            }
        }
        stdin.close();
    }

    public static void menu() {
        System.out.println("Menu Lista de Contato:");
        System.out.println("1. Inserir Contato");
        System.out.println("2. Detalhar Contato");
        System.out.println("3. Editar Contato");
        System.out.println("4. Remover Contato");
        System.out.println("5. Sair do menu.");
    }

    public static void titulo() {
        System.out.println();
        System.out.println("#######################");
        System.out.println("########AGENDA#########");
        System.out.println("#######################");
        System.out.println();
        System.out.println(">>>>>>>Contatos<<<<<<<<");
        System.out.println("ID | Nome        | Telefone    | E-mail");

      */
