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