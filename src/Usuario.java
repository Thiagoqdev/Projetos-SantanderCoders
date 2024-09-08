import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String titular;
    private String telefone;
    private String email;
    private List<Conta> contas;

    public Usuario(String titular, String telefone, String email) {
        this.titular = titular;
        this.telefone = telefone;
        this.email = email;
        this.contas = new ArrayList<>();
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "titular='" + titular + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", contas=" + contas +
                '}';
    }
}




//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Usuario extends Conta {
//
//    Scanner scanner = new Scanner(System.in);
//
//    private String titular;
//    //private ArrayList<Conta> contas = new ArrayList<Conta>();
//    private String telefone;
//    private String email;
//    private ContaCorrente contaCorrente;
//    private ContaPoupanca contaPoupanca;
//
//    List<Usuario> listaUsuarios = new ArrayList<>();
//
//    public Usuario(String numeroDaConta, String dataDeAbertura, double saldo, int agencia, String titular, String telefone, String email, ContaCorrente contaCorrente) {
//        super(numeroDaConta, dataDeAbertura, saldo, agencia);
//        this.titular = titular;
//        this.telefone = telefone;
//        this.email = email;
//        this.contaCorrente = contaCorrente;
//    }
//
//    public Usuario(String numeroDaConta, String dataDeAbertura, double saldo, int agencia, String titular, String telefone, String email, ContaPoupanca contaPoupanca) {
//        super(numeroDaConta, dataDeAbertura, saldo, agencia);
//        this.titular = titular;
//        this.telefone = telefone;
//        this.email = email;
//        this.contaPoupanca = contaPoupanca;
//    }
//
//    public String getTitular() {
//        return titular;
//    }
//
//    public void setTitular(String titular) {
//        this.titular = titular;
//    }
//
//   /* public ArrayList<Conta> getContas() {
//        return contas;
//    }
//    public void setContas(ArrayList<Conta> contas) {
//        this.contas = contas;
//    }*/
//
//
//    public String getTelefone() {
//        return telefone;
//    }
//
//    public void setTelefone(String telefone) {
//        this.telefone = telefone;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//
//    public void adicionaUsuarioNaLista(Usuario usuario) {
//        listaUsuarios.add(usuario);
//    }
//}
