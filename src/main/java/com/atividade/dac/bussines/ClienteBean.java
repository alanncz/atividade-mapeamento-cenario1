/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atividade.dac.bussines;

import com.atividade.dac.cenario1.Cliente;
import com.atividade.dac.cenario1.Conta;
import java.util.List;

/**
 *
 * @author alann
 */
public interface ClienteBean {
    
    public boolean autentucar(String cpf, String senha);
    
    public void cadastrar(Cliente cliente);
    
    public void remover(Cliente cliente);
    
    public void atualizarCliente(Cliente cliente);
    
    public void atualizarConta(Conta conta);
    
    public Cliente buscar(long pessquisa);
    
    public List<Cliente> listar();
    
    public Cliente buscarPorCpf(String cpf);
    
}
