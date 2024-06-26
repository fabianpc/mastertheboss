package com.mastertheboss.model;
import jakarta.persistence.*;


@Entity
@Cacheable
@NamedQueries(
{
@NamedQuery(
name = "Customers.findAll",
query = "SELECT c FROM Customer c ORDER BY c.id",
hints = { @QueryHint(name = "org.hibernate.cacheable", value =
"true") }  
)
})

 
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customerSequence",
            sequenceName = "customerId_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSequence")
    private Long id;
    @Column(length = 40)
    private String name;
    @Column(length = 40)
    private String surname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}