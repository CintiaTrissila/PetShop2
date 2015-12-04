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
@Table(name = "vacina")
@NamedQueries({
    @NamedQuery(name = "Vacina.findAll", query = "SELECT v FROM Vacina v"),
    @NamedQuery(name = "Vacina.findByIdVacina", query = "SELECT v FROM Vacina v WHERE v.idVacina = :idVacina"),
    @NamedQuery(name = "Vacina.findByDescricaoVacina", query = "SELECT v FROM Vacina v WHERE v.descricaoVacina = :descricaoVacina"),
    @NamedQuery(name = "Vacina.findByIdadeVacina", query = "SELECT v FROM Vacina v WHERE v.idadeVacina = :idadeVacina"),
    @NamedQuery(name = "Vacina.findByObsVacina", query = "SELECT v FROM Vacina v WHERE v.obsVacina = :obsVacina"),
    @NamedQuery(name = "Vacina.findByFkidTipoAnimal", query = "SELECT v FROM Vacina v WHERE v.fkidTipoAnimal = :fkidTipoAnimal")})
public class Vacina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVacina")
    private Integer idVacina;
    @Column(name = "descricaoVacina")
    private String descricaoVacina;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "idadeVacina")
    private Float idadeVacina;
    @Column(name = "obsVacina")
    private String obsVacina;
    @Column(name = "fk_idTipoAnimal")
    private Integer fkidTipoAnimal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacinaidVacina")
    private List<Vacinacao> vacinacaoList;

    public Vacina() {
    }

    public Vacina(Integer idVacina) {
        this.idVacina = idVacina;
    }

    public Integer getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Integer idVacina) {
        this.idVacina = idVacina;
    }

    public String getDescricaoVacina() {
        return descricaoVacina;
    }

    public void setDescricaoVacina(String descricaoVacina) {
        this.descricaoVacina = descricaoVacina;
    }

    public Float getIdadeVacina() {
        return idadeVacina;
    }

    public void setIdadeVacina(Float idadeVacina) {
        this.idadeVacina = idadeVacina;
    }

    public String getObsVacina() {
        return obsVacina;
    }

    public void setObsVacina(String obsVacina) {
        this.obsVacina = obsVacina;
    }

    public Integer getFkidTipoAnimal() {
        return fkidTipoAnimal;
    }

    public void setFkidTipoAnimal(Integer fkidTipoAnimal) {
        this.fkidTipoAnimal = fkidTipoAnimal;
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
        hash += (idVacina != null ? idVacina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacina)) {
            return false;
        }
        Vacina other = (Vacina) object;
        if ((this.idVacina == null && other.idVacina != null) || (this.idVacina != null && !this.idVacina.equals(other.idVacina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.unijui.model.Vacina[ idVacina=" + idVacina + " ]";
    }

}
