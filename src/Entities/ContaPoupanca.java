package Entities;

import java.time.LocalDate;

public class ContaPoupanca extends Conta {

    public static final double TAXA_RENDIMENTO = 0.0006;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void obterRendimentos() {
        double rendimento = saldo * TAXA_RENDIMENTO;
        saldo += rendimento;

        Transacao rendimentos = new Transacao("rendimento", rendimento, LocalDate.now());
        extrato.add(rendimentos);
        System.out.println("Rendimento aplicado");
    }
    @Override
    public void imprimirExtrato() {
        System.out.println("=== Conta Poupança ===");
        super.imprimirInfosComuns();
        super.imprimirExtrato();
    }
}
