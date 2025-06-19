package com.desafio.itau.models.dto;

import com.desafio.itau.models.Transaction;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.OffsetDateTime;
import java.util.Objects;

public class TransactionDTO {
    @NotNull
    @Positive
    private Double valor;

    @NotNull
    @PastOrPresent
    private OffsetDateTime dataHora;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
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
        if (!(o instanceof Transaction that)) return false;
        return Double.compare(getValor(), that.getValor()) == 0 && Objects.equals(getDataHora(), that.getDataHora());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValor(), getDataHora());
    }
}
