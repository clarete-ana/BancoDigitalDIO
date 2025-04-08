package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

    protected List<Transacao> extrato = new ArrayList<>();

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        if(valor > saldo){
            System.out.println("Saldo insuficiente para saque");
            return;
        }
        saldo -= valor;
        Transacao saque = new Transacao("saque" , valor, LocalDate.now());
        extrato.add(saque);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        Transacao deposito = new Transacao("deposito" , valor, LocalDate.now());
        extrato.add(deposito);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor > saldo){
            System.out.println("Saldo insuficiente para transferência");
            return;
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
        Transacao transferencia = new Transacao("transferencia" , valor, LocalDate.now());
        extrato.add(transferencia);
    }

    protected void imprimirInfosComuns(){
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Número: %d", numero));
        System.out.println(String.format("Saldo: %.2f", saldo));
        System.out.println(String.format("Cliente: %s", cliente));
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("=== Extrato ===");
        for (Transacao t : extrato){
            System.out.println(t);
        }
    }
}
