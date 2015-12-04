/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unijui.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cintia
 */
@Entity
@Table(name = "vacinacao")
@NamedQueries({
    @NamedQuery(name = "Vacinacao.findAll", query = "SELECT v FROM Vacinacao v"),
    @NamedQuery(name = "Vacinacao.findByIdVacinacao", query = "SELECT v FROM Vacinacao v WHERE v.idVacinacao = :idVacinacao"),
    @NamedQuery(name = "Vacinacao.findByDataVacinacao", query = "SELECT v FROM Vacinacao v WHERE v.dataVacinacao = :dataVacinacao")})
public class Vacinacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVacinacao")
    private Integer idVacinacao;
    @Basic(optional = false)
    @Column(name = "dataVacinacao")
    @Temporal(TemporalType.DATE)
    private Date dataVacinacao;
    @JoinColumn(name = "Animal_idAnimal", referencedColumnName = "idAnimal")
    @ManyToOne(optional = false)
    private Animal animalidAnimal;
    @JoinColumn(name = "Vacina_idVacina", referencedColumnName = "idVacina")
    @ManyToOne(optional = false)
    private Vacina vacinaidVacina;
    @JoinColumn(name = "vacinador_idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(optional = false)
    private Funcionario vacinadoridFuncionario;

    public Vacinacao() {
    }

    public Vacinacao(Integer idVacinacao) {
        this.idVacinacao = idVacinacao;
    }

    public Vacinacao(Integer idVacinacao, Date dataVacinacao) {
        this.idVacinacao = idVacinacao;
        this.dataVacinacao = dataVacinacao;
    }

    public Integer getIdVacinacao() {
        return idVacinacao;
    }

    public void setIdVacinacao(Integer idVacinacao) {
        this.idVacinacao = idVacinacao;
    }

    public Date getDataVacinacao() {
        return dataVacinacao;
    }

    public void setDataVacinacao(Date dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }

    public Animal getAnimalidAnimal() {
        return animalidAnimal;
    }

    public void setAnimalidAnimal(Animal animalidAnimal) {
        this.animalidAnimal = animalidAnimal;
    }

    public Vacina getVacinaidVacina() {
        return vacinaidVacina;
    }

    public void setVacinaidVacina(Vacina vacinaidVacina) {
        this.vacinaidVacina = vacinaidVacina;
    }

    public Funcionario getVacinadoridFuncionario() {
        return vacinadoridFuncionario;
    }

    public void setVacinadoridFuncionario(Funcionario vacinadoridFuncionario) {
        this.vacinadoridFuncionario = vacinadoridFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVacinacao != null ? idVacinacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacinacao)) {
            return false;
        }
        Vacinacao other = (Vacinacao) object;
        if ((this.idVacinacao == null && other.idVacinacao != null) || (this.idVacinacao != null && !this.idVacinacao.equals(other.idVacinacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.unijui.model.Vacinacao[ idVacinacao=" + idVacinacao + " ]";
    }

}
