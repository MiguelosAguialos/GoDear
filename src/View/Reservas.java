/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Alunos
 */
@Entity
@Table(name = "reservas", catalog = "godear", schema = "")
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r")
    , @NamedQuery(name = "Reservas.findByIdRes", query = "SELECT r FROM Reservas r WHERE r.idRes = :idRes")
    , @NamedQuery(name = "Reservas.findByNomeRes", query = "SELECT r FROM Reservas r WHERE r.nomeRes = :nomeRes")
    , @NamedQuery(name = "Reservas.findByCpfRes", query = "SELECT r FROM Reservas r WHERE r.cpfRes = :cpfRes")
    , @NamedQuery(name = "Reservas.findBySalaRes", query = "SELECT r FROM Reservas r WHERE r.salaRes = :salaRes")
    , @NamedQuery(name = "Reservas.findByDataRes", query = "SELECT r FROM Reservas r WHERE r.dataRes = :dataRes")
    , @NamedQuery(name = "Reservas.findByInicioRes", query = "SELECT r FROM Reservas r WHERE r.inicioRes = :inicioRes")
    , @NamedQuery(name = "Reservas.findByFimRes", query = "SELECT r FROM Reservas r WHERE r.fimRes = :fimRes")})
public class Reservas implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_res")
    private Integer idRes;
    @Basic(optional = false)
    @Column(name = "nome_res")
    private String nomeRes;
    @Basic(optional = false)
    @Column(name = "cpf_res")
    private String cpfRes;
    @Basic(optional = false)
    @Lob
    @Column(name = "cel_res")
    private String celRes;
    @Basic(optional = false)
    @Column(name = "sala_res")
    private String salaRes;
    @Basic(optional = false)
    @Column(name = "data_res")
    private String dataRes;
    @Basic(optional = false)
    @Column(name = "inicio_res")
    private String inicioRes;
    @Basic(optional = false)
    @Column(name = "fim_res")
    private String fimRes;

    public Reservas() {
    }

    public Reservas(Integer idRes) {
        this.idRes = idRes;
    }

    public Reservas(Integer idRes, String nomeRes, String cpfRes, String celRes, String salaRes, String dataRes, String inicioRes, String fimRes) {
        this.idRes = idRes;
        this.nomeRes = nomeRes;
        this.cpfRes = cpfRes;
        this.celRes = celRes;
        this.salaRes = salaRes;
        this.dataRes = dataRes;
        this.inicioRes = inicioRes;
        this.fimRes = fimRes;
    }

    public Integer getIdRes() {
        return idRes;
    }

    public void setIdRes(Integer idRes) {
        Integer oldIdRes = this.idRes;
        this.idRes = idRes;
        changeSupport.firePropertyChange("idRes", oldIdRes, idRes);
    }

    public String getNomeRes() {
        return nomeRes;
    }

    public void setNomeRes(String nomeRes) {
        String oldNomeRes = this.nomeRes;
        this.nomeRes = nomeRes;
        changeSupport.firePropertyChange("nomeRes", oldNomeRes, nomeRes);
    }

    public String getCpfRes() {
        return cpfRes;
    }

    public void setCpfRes(String cpfRes) {
        String oldCpfRes = this.cpfRes;
        this.cpfRes = cpfRes;
        changeSupport.firePropertyChange("cpfRes", oldCpfRes, cpfRes);
    }

    public String getCelRes() {
        return celRes;
    }

    public void setCelRes(String celRes) {
        String oldCelRes = this.celRes;
        this.celRes = celRes;
        changeSupport.firePropertyChange("celRes", oldCelRes, celRes);
    }

    public String getSalaRes() {
        return salaRes;
    }

    public void setSalaRes(String salaRes) {
        String oldSalaRes = this.salaRes;
        this.salaRes = salaRes;
        changeSupport.firePropertyChange("salaRes", oldSalaRes, salaRes);
    }

    public String getDataRes() {
        return dataRes;
    }

    public void setDataRes(String dataRes) {
        String oldDataRes = this.dataRes;
        this.dataRes = dataRes;
        changeSupport.firePropertyChange("dataRes", oldDataRes, dataRes);
    }

    public String getInicioRes() {
        return inicioRes;
    }

    public void setInicioRes(String inicioRes) {
        String oldInicioRes = this.inicioRes;
        this.inicioRes = inicioRes;
        changeSupport.firePropertyChange("inicioRes", oldInicioRes, inicioRes);
    }

    public String getFimRes() {
        return fimRes;
    }

    public void setFimRes(String fimRes) {
        String oldFimRes = this.fimRes;
        this.fimRes = fimRes;
        changeSupport.firePropertyChange("fimRes", oldFimRes, fimRes);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRes != null ? idRes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.idRes == null && other.idRes != null) || (this.idRes != null && !this.idRes.equals(other.idRes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Reservas[ idRes=" + idRes + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
