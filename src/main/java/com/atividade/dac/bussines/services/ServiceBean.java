/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atividade.dac.bussines.services;

import com.atividade.dac.bussines.ClienteBean;
import com.atividade.dac.cenario1.Cliente;
import com.atividade.dac.cenario1.Conta;
import com.atividade.dac.cenario1.ContaCorrente;
import com.atividade.dac.cenario1.ContaPoupanca;
import com.atividade.dac.cenario1.Endereco;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alann
 */

@Named
@SessionScoped
public class ServiceBean implements Serializable {
    
    @Inject
    private ClienteBean bean;
    private Cliente cliente;
    private Conta conta;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String autenticar(String cpf, String senha) {
        if (this.buscarPorCpf(cpf) == null) return "index?faces-redirect=true" ;
        this.cliente = buscarPorCpf(cpf);
        if (cliente != null )conta = this.buscarPorCpf(cpf).getConta();
        return this.bean.autentucar(cpf, senha) ? "home?faces-redirect=true": null;
        
    }
    
    public Conta criarConta(String tipoConta, String cpf, String senha){
        if (tipoConta.compareTo("cc") == 0) return new ContaCorrente(cpf, senha);
        else return new ContaPoupanca(cpf, senha);
    }

    public String cadastrar(String cpf, String rg, String telefone, String bairro,
            String cidade, String senha, String tipoConta) {
        Date data = new Date();
        Endereco endereco = new Endereco(bairro, cidade);
        Conta novaConta = criarConta(tipoConta,cpf, senha);
        Cliente novoCliente = new Cliente(cpf,rg,data,telefone, endereco, novaConta);
        bean.cadastrar(novoCliente);
        return "index?faces-redirect=true";
    }

    public String remover() {
        bean.remover(cliente);
        return "index?faces-redirect=true";
    }

    public void atualizarCliente(Cliente cliente) {
        bean.atualizarCliente(cliente);
    }

    public Cliente buscar(long pessquisa) {
        return bean.buscar(pessquisa);
    }

    public List<Cliente> listar() {
        return bean.listar();
    }

    public Cliente buscarPorCpf(String cpf) {
        return bean.buscarPorCpf(cpf);
    }
    
    public String auterarSenha(String senha){
        this.conta.setSenha(senha);
        bean.atualizarConta(conta);
        return "home?faces-redirect=true";
    }
    
    public String depositar(String valor){
        this.conta.creditar(converter(valor));
        bean.atualizarConta(conta);
        return "home?faces-redirect=true";
    }
    
    public String sacar(String valor){
        this.conta.debitar(converter(valor));
        bean.atualizarConta(conta);
        return "home?faces-redirect=true";
    }
    
    public float converter(String valor){
        return Float.parseFloat(valor);
    }
    
}
