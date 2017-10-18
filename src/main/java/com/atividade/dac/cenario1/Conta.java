/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atividade.dac.cenario1;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author alann
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("CN")
@SequenceGenerator(allocationSize = 1, name = "conta_seq", 
        sequenceName = "conta_sequence")
public abstract class Conta implements Serializable {
    
    @Id
    @GeneratedValue(generator = "conta_seq", strategy = GenerationType.SEQUENCE)
    private int codigo;
    private String numeroConta;
    private String agencia;
    private int digitoAgencia;
    private int digitoConta;
    private String senha;
    private float saldo;
    
    public Conta(){}

    public Conta(String numeroConta, int digitoConta, String senha) {
        this.numeroConta = numeroConta;
        this.agencia = "0040";
        this.digitoAgencia = 4;
        this.digitoConta = digitoConta;
        this.senha = senha;
        this.saldo = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public int getDigitoAgencia() {
        return digitoAgencia;
    }

    public void setDigitoAgencia(int digitoAgencia) {
        this.digitoAgencia = digitoAgencia;
    }

    public int getDigitoConta() {
        return digitoConta;
    }

    public void setDigitoConta(int digitoConta) {
        this.digitoConta = digitoConta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public abstract void creditar(float valor);
    
    public abstract void debitar(float valor);
}
