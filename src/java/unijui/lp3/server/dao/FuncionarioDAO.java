/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unijui.lp3.server.dao;

import br.edu.unijui.model.Funcionario;
import unijui.lp3.server.GenericDAO;

/**
 *
 * @author Dener
 */
public class FuncionarioDAO extends GenericDAO<Funcionario>{

    public FuncionarioDAO() {
        super(Funcionario.class);
    }
    
    public Funcionario validaLogin(String login, String senha) {
        Object[] func = (Object[]) getSession().createQuery("select idFuncionario, senha from " + clazz.getName() +
                " where login = ?").setString(0, login).uniqueResult();
        if (func == null) {
            
        } else if (!senha.equals(func[1])) {
            
        }
        return (Funcionario) getSession().get(clazz, (Integer) func[0]);
    }
    
}
