package model;

import java.time.LocalDate;

public class Transacao {

    private String tipo;
    private double valor;
    private LocalDate data;

    public Transacao(String tipo, double valor, LocalDate data) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Transacao: {" +
                "tipo: " + tipo + '\'' +
                ", valor: " + valor +
                ", data: " + data +
                '}';
    }
}
