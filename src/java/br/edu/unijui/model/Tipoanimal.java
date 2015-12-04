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
@Table(name = "tipoanimal")
@NamedQueries({
    @NamedQuery(name = "Tipoanimal.findAll", query = "SELECT t FROM Tipoanimal t"),
    @NamedQuery(name = "Tipoanimal.findByIdTipoAnimal", query = "SELECT t FROM Tipoanimal t WHERE t.idTipoAnimal = :idTipoAnimal"),
    @NamedQuery(name = "Tipoanimal.findByDescricao", query = "SELECT t FROM Tipoanimal t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "Tipoanimal.findByGeneroAnimal", query = "SELECT t FROM Tipoanimal t WHERE t.generoAnimal = :generoAnimal")})
public class Tipoanimal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoAnimal")
    private Integer idTipoAnimal;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "generoAnimal")
    private String generoAnimal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAnimalidTipoAnimal")
    private List<Animal> animalList;

    public Tipoanimal() {
    }

    public Tipoanimal(Integer idTipoAnimal) {
        this.idTipoAnimal = idTipoAnimal;
    }

    public Integer getIdTipoAnimal() {
        return idTipoAnimal;
    }

    public void setIdTipoAnimal(Integer idTipoAnimal) {
        this.idTipoAnimal = idTipoAnimal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGeneroAnimal() {
        return generoAnimal;
    }

    public void setGeneroAnimal(String generoAnimal) {
        this.generoAnimal = generoAnimal;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAnimal != null ? idTipoAnimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoanimal)) {
            return false;
        }
        Tipoanimal other = (Tipoanimal) object;
        if ((this.idTipoAnimal == null && other.idTipoAnimal != null) || (this.idTipoAnimal != null && !this.idTipoAnimal.equals(other.idTipoAnimal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.unijui.model.Tipoanimal[ idTipoAnimal=" + idTipoAnimal + " ]";
    }

}
