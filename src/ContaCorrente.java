public class ContaCorrente extends Conta {

    private double limiteChequeEspecial = 1000;

    public ContaCorrente(String numeroDaConta, String dataDeAbertura, double saldo, int agencia) {
        super(numeroDaConta, dataDeAbertura, saldo, agencia);
    }

    public boolean sacarChequeEspecial(double valorSaqueCheque) {

        if (valorSaqueCheque <= this.saldo + this.limiteChequeEspecial) {
            System.out.println("Saque no valor de: " + valorSaqueCheque + " Realizado com sucesso.");
            return true;
        } else {
            System.err.println("Saque não realizado. Saldo insuficiente");
            return false;
        }

    }

    @Override
    public void sacar(double valorSaque) {
        if ((saldo - valorSaque) < -1000) {
            System.out.println("Valor de Saque maior que o valor do saque com o limite do cheque especial.");
        } else if (saldo <= 0) {
            saldo -= valorSaque;
            System.out.println("Saque efetuado com limite do cheque especial.");
        } else {
            saldo -= valorSaque;
            System.out.println("Saque de: R$ " + valorSaque + " realizado com sucesso.");
        }

    }

    @Override
    public double getSaldo() {
        System.out.println("Seu saldo atual é: " + saldo);
        return this.saldo;
    }



}
