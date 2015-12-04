/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unijui.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Cintia
 */
@Entity
@Table(name = "funcionario")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario"),
    @NamedQuery(name = "Funcionario.findByNomeFuncionario", query = "SELECT f FROM Funcionario f WHERE f.nomeFuncionario = :nomeFuncionario"),
    @NamedQuery(name = "Funcionario.findByTelefoneFuncionario", query = "SELECT f FROM Funcionario f WHERE f.telefoneFuncionario = :telefoneFuncionario"),
    @NamedQuery(name = "Funcionario.findByEnderecoFuncionario", query = "SELECT f FROM Funcionario f WHERE f.enderecoFuncionario = :enderecoFuncionario"),
    @NamedQuery(name = "Funcionario.findByLogin", query = "SELECT f FROM Funcionario f WHERE f.login = :login"),
    @NamedQuery(name = "Funcionario.findBySenha", query = "SELECT f FROM Funcionario f WHERE f.senha = :senha")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idFuncionario")
    private Integer idFuncionario;
    @Column(name = "nomeFuncionario")
    private String nomeFuncionario;
    @Column(name = "telefoneFuncionario")
    private String telefoneFuncionario;
    @Column(name = "enderecoFuncionario")
    private String enderecoFuncionario;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacinadoridFuncionario")
    private List<Vacinacao> vacinacaoList;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Funcionario(Integer idFuncionario, String login, String senha) {
        this.idFuncionario = idFuncionario;
        this.login = login;
        this.senha = senha;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public String getEnderecoFuncionario() {
        return enderecoFuncionario;
    }

    public void setEnderecoFuncionario(String enderecoFuncionario) {
        this.enderecoFuncionario = enderecoFuncionario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Vacinacao> getVacinacaoList() {
        return vacinacaoList;
    }

    public void setVacinacaoList(List<Vacinacao> vacinacaoList) {
        this.vacinacaoList = vacinacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.unijui.model.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }

}
