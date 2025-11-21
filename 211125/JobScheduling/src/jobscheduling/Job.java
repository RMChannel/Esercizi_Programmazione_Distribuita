/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobscheduling;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author robbe
 */
@Entity
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String title;
    private float salary;
    private String employeeld;
    
    @ManyToOne
    @JoinColumn(name = "person_id") // Nome della colonna FK in Job
    private Person person;

    public Job() {}
    
    public Job(String title, float salary, String employeeld) {
        this.title=title;
        this.salary=salary;
        this.employeeld=employeeld;
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
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Job {\n");
        sb.append("  id = ").append(id).append(",\n");
        sb.append("  title = '").append(title).append("',\n");
        sb.append("  salary = ").append(salary).append(",\n");
        sb.append("  employeeld = '").append(employeeld).append("',\n");

        sb.append("  personId = ");
        if (person != null && person.getId() != null) {
            sb.append(person.getId());
        } else {
            sb.append("null");
        }
        sb.append("\n");

        sb.append("}");
        return sb.toString();
    }

    
}
