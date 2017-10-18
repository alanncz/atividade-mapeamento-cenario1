/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atividade.dac.controllers;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author alann
 */

@Named
@SessionScoped
public class UsuarioController implements Serializable {
    
    public String autenticar(String conta, String senha){
        return "";
    }
    
}
