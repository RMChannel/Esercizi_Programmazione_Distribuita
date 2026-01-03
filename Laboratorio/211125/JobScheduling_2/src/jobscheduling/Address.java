/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobscheduling;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author robbe
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;
    
    public Address() {}
    
    public Address(String street1, String street2, String city, String state, String zip) {
        this.street1=street1;
        this.street2=street2;
        this.city=city;
        this.state=state;
        this.zip=zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address {\n");
        sb.append("  id = ").append(id).append(",\n");
        sb.append("  street1 = '").append(street1).append("',\n");
        sb.append("  street2 = '").append(street2).append("',\n");
        sb.append("  city = '").append(city).append("',\n");
        sb.append("  state = '").append(state).append("',\n");
        sb.append("  zip = '").append(zip).append("'\n");
        sb.append("}");
        return sb.toString();
    }

    
}
