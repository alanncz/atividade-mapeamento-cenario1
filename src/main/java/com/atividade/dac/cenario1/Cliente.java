/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atividade.dac.cenario1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author alann
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "cliente.listar", query = "select c from Cliente c")
    ,
    @NamedQuery(name = "cliente.PorCpf",
            query = "select c from Cliente c where c.cpf = :cpf")
})
@SequenceGenerator(allocationSize = 1, name = "cliente_seq",
        sequenceName = "cliente_sequence")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(generator = "cliente_seq", strategy = GenerationType.SEQUENCE)
    private int codigo;
    private String cpf;
    private String rg;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    private String telefone;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToOne( cascade = CascadeType.ALL)
    private Conta conta;

    public Cliente() {
    }

    public Cliente(String cpf, String rg, Date dataNascimento, String telefone, Endereco endereco, Conta conta) {
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.conta = conta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

}
