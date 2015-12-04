package br.edu.unijui.controller;

import br.edu.unijui.model.Funcionario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import unijui.lp3.server.GenericDAO;

@ManagedBean
@SessionScoped
public class FuncionarioController {

    private final GenericDAO<Funcionario> DAO = new GenericDAO<>(Funcionario.class);
    private Funcionario funcionario;

    public FuncionarioController() {
        funcionario = new Funcionario();
    }
    
    
    
    public void cadastrar() {       
        DAO.insert(funcionario);
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    
}
