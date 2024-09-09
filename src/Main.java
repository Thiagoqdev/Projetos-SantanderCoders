import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        List<Usuario> listaUsuarios = new ArrayList<>();
        boolean continuar = true;
        boolean achou = false;

        titulo();

        while (continuar) {
            try {
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

                        System.out.println("Escolha o tipo de conta: \n1- para Conta Corrente \n2- para Conta Poupança:");
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
                        if(listaUsuarios.size()==0)
                            System.out.println("Ainda nao ha clientes");
                        else {
                            System.out.println("Digite o nome do titular para exibir detalhes:");
                            String nomeBusca = stdin.nextLine();
                            achou = false;
                            for (Usuario u : listaUsuarios) {
                                if (u.getTitular().equalsIgnoreCase(nomeBusca)) {
                                    System.out.println("Detalhes do cliente: " + u);
                                    achou = true;
                                }
                            }
                            if(!achou)
                                System.out.println("Nao ha titular com esse nome.");
                        }
                        break;
                    case 3:
                        // Editar informações de cliente
                        if(listaUsuarios.size()==0)
                            System.out.println("Ainda nao ha clientes");
                        else {
                            System.out.println("Digite o nome do titular para editar:");
                            String nomeEditar = stdin.nextLine();
                            achou = false;
                            for (Usuario u : listaUsuarios) {
                                if (u.getTitular().equalsIgnoreCase(nomeEditar)) {
                                    System.out.println("Digite o novo telefone:");
                                    u.setTelefone(stdin.nextLine());
                                    System.out.println("Digite o novo email:");
                                    u.setEmail(stdin.nextLine());
                                    System.out.println("Informações atualizadas com sucesso!");
                                    achou = true;
                                }
                            }
                            if(!achou)
                                System.out.println("Nao ha titular com esse nome.");
                        }
                        break;
                    case 4:
                        // Remover cliente
                        if(listaUsuarios.size()==0)
                            System.out.println("Ainda nao ha clientes");
                        else {
                            System.out.println("Digite o nome do titular para remover:");
                            String nomeRemover = stdin.nextLine();
                            if(listaUsuarios.removeIf(u -> u.getTitular().equalsIgnoreCase(nomeRemover)))
                                System.out.println("Cliente removido com sucesso!");
                            else 
                                System.out.println("Nao ha titular com esse nome.");
                        }
                        break;
                    case 5:
                        // Listar todos os clientes
                        if(listaUsuarios.size()==0)
                            System.out.println("Ainda nao ha clientes");
                        else {
                        System.out.println("Lista de todos os clientes:");
                            for (Usuario u : listaUsuarios) {
                                System.out.println(u);
                            }
                        }
                        break;
                    case 6:
                        if(listaUsuarios.size()==0)
                            System.out.println("Ainda nao ha clientes");
                        else {
                            achou = false;
                            System.out.println("Quer conferir o saldo de qual titular?");
                            String nomeConsultar = stdin.nextLine();
                            for (Usuario u : listaUsuarios) {
                                if (u.getTitular().equalsIgnoreCase(nomeConsultar)) {
                                    System.out.println(u.getContas().get(0).getSaldo());
                                    achou = true;
                                    break;
                                }
                            }
                        }
                        break;
                    case 7:
                        if(listaUsuarios.size()==0)
                            System.out.println("Ainda nao ha clientes");
                        else {
                            achou = false;
                            System.out.println("Quer sacar da conta de qual titular?");
                            String nomeSacar = stdin.nextLine();
                            for (Usuario u : listaUsuarios) {
                                if (u.getTitular().equalsIgnoreCase(nomeSacar)) {
                                    List<Conta> contaConsulta = u.getContas();
                                    if(contaConsulta.get(0) instanceof ContaCorrente) {
                                        ContaCorrente conta = (ContaCorrente) contaConsulta.get(0);
                                        System.out.println("1. Sacar\n2. Sacar cheque especial");
                                        int escolha = stdin.nextInt();
                                        stdin.nextLine();
                                        if(escolha == 1) {
                                            System.out.println("Qual o valor do saque?");
                                            double saque = stdin.nextDouble();
                                            stdin.nextLine();
                                            conta.sacar(saque);
                                        } else if(escolha==2) {
                                            System.out.println("Qual o valor do saque do cheque especial?");
                                            double saqueEspecial = stdin.nextDouble();
                                            stdin.nextLine();
                                            conta.sacarChequeEspecial(saqueEspecial);
                                        } else
                                            System.out.println("Voce nao escolha nenhuma opcao existente.\nCaso queria fazer uma consulta, escolha uma opcao valida.");
                                        break;
                                    } else {
                                        ContaPoupanca contaP = (ContaPoupanca) contaConsulta.get(0);
                                        System.out.println("Qual o valor do saque?");
                                        double saque = stdin.nextDouble();
                                        contaP.sacar(saque);
                                        stdin.nextLine();
                                    }
                                } else
                                    System.out.println("Nao ha clintes com esse nome.");
                            }
                        }
                        break;
                    case 8:
                        // Sair do menu
                        continuar = false;
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Voce inseriu um valor errado.\nDa proxima vez, insira o valor correto para o bom funcionamento do programa...");
                stdin.nextLine();
            } catch (Exception ex) {
                System.err.println("Ocorreu um erro inesperado.");
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
        System.out.println("6. Consultar saldo");
        System.out.println("7. Sacar");
        System.out.println("8. Sair do menu.");
    }

    public static void titulo() {
        System.out.println();
        System.out.println("################################");
        System.out.println("######## BANCO BUGSOFT #########");
        System.out.println("################################");
        System.out.println();
    }
}