public abstract class Conta {

    protected String numeroDaConta;
    protected String dataDeAbertura;
    protected double saldo;
    protected int agencia;

    public Conta(String numeroDaConta, String dataDeAbertura, double saldo, int agencia) {
        this.numeroDaConta = numeroDaConta;
        this.dataDeAbertura = dataDeAbertura;
        this.saldo = saldo;
        this.agencia = agencia;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public String getDataDeAbertura() {
        return dataDeAbertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void sacar(double valorSaque) {
        if (valorSaque > saldo) {
            System.err.println("Valor de Saque Indisponível.");
        } else {
            saldo -= valorSaque;
            System.out.println("Saque de: R$ " + valorSaque + " realizado com sucesso.");
        }
    }

    public void depositar(double valorDeposito) {
        saldo += valorDeposito;
        System.out.println("Depósito de: R$ " + valorDeposito + " realizado com sucesso.");
    }
}