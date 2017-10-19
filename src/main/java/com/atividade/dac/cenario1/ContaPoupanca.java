/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atividade.dac.cenario1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author alann
 */

@Entity
@DiscriminatorValue(value = "CP")
public class ContaPoupanca extends Conta{

    public ContaPoupanca() {}

    public ContaPoupanca(String numeroConta, String senha) {
        super(numeroConta, 2, senha);
    }

    @Override
    public void creditar(float valor) {
        float credito = (float) (valor + 0.56);
        this.setSaldo(this.getSaldo() + credito);
        addTransacao("Deposito", valor);
    }

    @Override
    public void debitar(float valor) {
        
        if (valor > 0 & valor <= this.getSaldo()){
            this.setSaldo(this.getSaldo() - valor);
            addTransacao("Retirada", valor);
        }
    }
    
}
