/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atividade.dac.cenario1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author alann
 */

@Entity
@SequenceGenerator(allocationSize = 1, name = "transacao_seq", 
        sequenceName = "transacao_sequence")
public class Transacao implements Serializable {
    
    @Id
    @GeneratedValue(generator = "transacao_seq", strategy = GenerationType.SEQUENCE)
    private int codigo;
    private String tipoTransacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataTransacao;
    private float valorTransacao;
    
    public Transacao(){}

    public Transacao(String tipoTransacao, Date dataTransacao, float valorTransacao) {
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
        this.valorTransacao = valorTransacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public float getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(float valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    
    
}
