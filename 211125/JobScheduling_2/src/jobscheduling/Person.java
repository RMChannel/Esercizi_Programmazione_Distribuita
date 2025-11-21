/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobscheduling;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author robbe
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String firstName;
    private String middleName;
    private String lastName;
    
    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;
    
    @OneToMany(mappedBy = "person")
    private List<Job> jobs = new ArrayList<>();

    public Person() {}
    
    public Person(String firstName, String middleName, String lastName) {
        this.firstName=firstName;
        this.middleName=middleName;
        this.lastName=lastName;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address=address;
    }
    
    public List<Job> getJobs() {
        return jobs;
    }
    
    public void setJobs(List<Job> jobs) {
        this.jobs=jobs;
    }
    
    public void addJob(Job job) {
        jobs.add(job);
    }
    
    public void removeJob(Job job) {
        jobs.remove(job);
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person {\n");
        sb.append("  id = ").append(id).append(",\n");
        sb.append("  firstName = '").append(firstName).append("',\n");
        sb.append("  middleName = '").append(middleName).append("',\n");
        sb.append("  lastName = '").append(lastName).append("',\n");

        sb.append("  address = ");
        if (address != null) {
            sb.append(address.toString());
        } else {
            sb.append("null");
        }
        sb.append(",\n");

        sb.append("  jobsCount = ").append(jobs != null ? jobs.size() : 0).append("\n");
        sb.append("}");
        return sb.toString();
    }

    
}
