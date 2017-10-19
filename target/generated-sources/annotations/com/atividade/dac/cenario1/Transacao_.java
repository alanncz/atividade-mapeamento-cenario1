package com.atividade.dac.cenario1;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-18T22:23:56")
@StaticMetamodel(Transacao.class)
public class Transacao_ { 

    public static volatile SingularAttribute<Transacao, Integer> codigo;
    public static volatile SingularAttribute<Transacao, String> tipoTransacao;
    public static volatile SingularAttribute<Transacao, Float> valorTransacao;
    public static volatile SingularAttribute<Transacao, Date> dataTransacao;

}