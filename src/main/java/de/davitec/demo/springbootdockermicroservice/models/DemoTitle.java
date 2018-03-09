package de.davitec.demo.springbootdockermicroservice.models;

import javax.persistence.*;

@Entity
@Table(name="DEMOITEM")
public class DemoTitle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    
    @Column(name="TITLE")
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
