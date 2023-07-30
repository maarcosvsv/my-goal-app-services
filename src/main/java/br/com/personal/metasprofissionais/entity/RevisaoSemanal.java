package br.com.personal.metasprofissionais.entity;

import java.time.LocalDate;

public class RevisaoSemanal {

    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String objetivo;
    private Double percentualConcluido;
    private Meta meta;
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Double getPercentualConcluido() {
        return percentualConcluido;
    }

    public void setPercentualConcluido(Double percentualConcluido) {
        this.percentualConcluido = percentualConcluido;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
