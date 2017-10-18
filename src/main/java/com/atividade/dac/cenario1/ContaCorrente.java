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
@DiscriminatorValue(value = "CC")
public class ContaCorrente extends Conta {

    public ContaCorrente() {}

    public ContaCorrente(String numeroConta,String senha) {
        super(numeroConta, 1, senha);
    }
    
    @Override
    public void creditar(float valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    @Override
    public void debitar(float valor) {
        float debito = (float) (valor + 0.75);
        this.setSaldo(this.getSaldo() - debito);
    }
    
}
