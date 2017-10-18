/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atividade.dac.cenario1;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author alann
 */

@Entity
@SequenceGenerator(allocationSize = 1, name = "endereco_seq", 
        sequenceName = "endereco_sequence")
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(generator = "endereco_seq", strategy = GenerationType.SEQUENCE)
    private int codigo;
    private String bairro;
    private String cidade;
    
    public Endereco(){}

    public Endereco(String bairro, String cidade) {
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    
}
