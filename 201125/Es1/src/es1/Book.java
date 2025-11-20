/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es1;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author robbe
 */
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String title;
    private String description;
    private double price;
    private String ISBN;
    private String categoria;
    
    public Book() {}

    public Book(String title, String description, double price, String ISBN, String categoria) {
        this.title=title;
        this.description=description;
        this.price=price;
        this.ISBN=ISBN;
        this.categoria=categoria;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
   public void setTitle(String newTitle) {
       this.title=newTitle;
   }
   
   public String getDescription() {
       return description;
   }
   
   public void setDescription(String newDescription) {
       this.description=newDescription;
   }
   
   public double getPrice() {
       return price;
   }
   
   public void setPrice(double newPrice) {
       this.price=newPrice;
   }
   
   public String getISBN() {
       return ISBN;
   }
   
   public void setISBN(String newISBN) {
       this.ISBN=newISBN;
   }
   
   public String getCategoria() {
       return categoria;
   }
   
   public void setCategoria(String newCategoria) {
       this.categoria=newCategoria;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es1.Book[ id=" + id + " titolo="+title+"]";
    }
    
}
