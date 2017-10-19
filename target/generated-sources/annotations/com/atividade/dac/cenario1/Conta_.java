package com.atividade.dac.cenario1;

import com.atividade.dac.cenario1.Transacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-18T22:23:56")
@StaticMetamodel(Conta.class)
public abstract class Conta_ { 

    public static volatile ListAttribute<Conta, Transacao> transacoes;
    public static volatile SingularAttribute<Conta, String> senha;
    public static volatile SingularAttribute<Conta, Integer> codigo;
    public static volatile SingularAttribute<Conta, Integer> digitoAgencia;
    public static volatile SingularAttribute<Conta, String> numeroConta;
    public static volatile SingularAttribute<Conta, Integer> digitoConta;
    public static volatile SingularAttribute<Conta, Float> saldo;
    public static volatile SingularAttribute<Conta, String> agencia;

}