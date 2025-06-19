package com.desafio.itau.models;

import java.time.OffsetDateTime;
import java.util.Objects;

public class transaction {
    private double valor;
    private OffsetDateTime dataHora;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof transaction that)) return false;
        return Double.compare(getValor(), that.getValor()) == 0 && Objects.equals(getDataHora(), that.getDataHora());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValor(), getDataHora());
    }
}
