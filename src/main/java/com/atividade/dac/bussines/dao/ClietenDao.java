/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atividade.dac.bussines.dao;

import com.atividade.dac.bussines.ClienteBean;
import com.atividade.dac.cenario1.Cliente;
import com.atividade.dac.cenario1.Conta;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author alann
 */
@Stateless
@Local(ClienteBean.class)
public class ClietenDao implements ClienteBean {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public boolean autentucar(String cpf, String senha) {
        TypedQuery<Cliente> query = em.createNamedQuery("cliente.PorCpf", Cliente.class);
        query.setParameter("cpf", cpf);
        List<Cliente> resultList = query.getResultList();
        Cliente cliente = resultList.isEmpty() ? null : resultList.get(0);
        Conta conta = em.find(Conta.class, cliente.getConta().getCodigo());
        return conta.getSenha().compareTo(senha) == 0;
    }

    @Override
    public void cadastrar(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void atualizarCliente(Cliente cliente) {
        em.merge(cliente);
    }
    
    @Override
    public void atualizarConta(Conta conta){
        em.merge(conta);
    }

    @Override
    public Cliente buscar(long pessquisa) {
        return em.find(Cliente.class, pessquisa);
    }

    @Override
    public List<Cliente> listar() {
        return em.createNamedQuery("cliente.listar", Cliente.class).getResultList();
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        TypedQuery<Cliente> query = em.createNamedQuery("cliente.PorCpf", Cliente.class);
        query.setParameter("cpf", cpf);
        List<Cliente> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    @Override
    public void remover(Cliente cliente) {
        cliente = em.merge(cliente);
        em.remove(cliente);
    }

}
