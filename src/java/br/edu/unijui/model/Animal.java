/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unijui.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cintia
 */
@Entity
@Table(name = "animal")
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a"),
    @NamedQuery(name = "Animal.findByIdAnimal", query = "SELECT a FROM Animal a WHERE a.idAnimal = :idAnimal"),
    @NamedQuery(name = "Animal.findByNomeAnimal", query = "SELECT a FROM Animal a WHERE a.nomeAnimal = :nomeAnimal"),
    @NamedQuery(name = "Animal.findByDataNasc", query = "SELECT a FROM Animal a WHERE a.dataNasc = :dataNasc"),
    @NamedQuery(name = "Animal.findByPeso", query = "SELECT a FROM Animal a WHERE a.peso = :peso")})
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAnimal")
    private Integer idAnimal;
    @Column(name = "nomeAnimal")
    private String nomeAnimal;
    @Column(name = "dataNasc")
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animalidAnimal")
    private List<Vacinacao> vacinacaoList;
    @JoinColumn(name = "TipoAnimal_idTipoAnimal", referencedColumnName = "idTipoAnimal")
    @ManyToOne(optional = false)
    private Tipoanimal tipoAnimalidTipoAnimal;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    public Animal() {
    }

    public Animal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public List<Vacinacao> getVacinacaoList() {
        return vacinacaoList;
    }

    public void setVacinacaoList(List<Vacinacao> vacinacaoList) {
        this.vacinacaoList = vacinacaoList;
    }

    public Tipoanimal getTipoAnimalidTipoAnimal() {
        return tipoAnimalidTipoAnimal;
    }

    public void setTipoAnimalidTipoAnimal(Tipoanimal tipoAnimalidTipoAnimal) {
        this.tipoAnimalidTipoAnimal = tipoAnimalidTipoAnimal;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnimal != null ? idAnimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.idAnimal == null && other.idAnimal != null) || (this.idAnimal != null && !this.idAnimal.equals(other.idAnimal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.unijui.model.Animal[ idAnimal=" + idAnimal + " ]";
    }

}
