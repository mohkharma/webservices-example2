package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

/***
 * This is Category entity
 * An entity in JPA represents a table stored in a database.
 * Author: Mohammed Kharma
 */


@Data
//Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields
@AllArgsConstructor   //automatically generates a constructor with a parameter for each field in your class
@NoArgsConstructor     // generates a constructor with no parameter

@Entity                 // specifies that the class is an entity and is mapped to a database table
@Table(  //allows you to specify the details of the table that will be used to persist the entity in the database
        name = "category_tbl", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)

//Example of unique constraint on a composite key
//@Table(uniqueConstraints = {
//        @UniqueConstraint(name = "UniqueNameAndIsActive", columnNames = {"name", "isActive"}),
//        })

public class Category {


    @Id   //declare the primary key
    @GeneratedValue(
            strategy = GenerationType.IDENTITY //indicates that the persistence provider must assign primary keys for the entity using a database identity column.This means they are auto-incremented
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @Column
    private String CreatedBy;

    @Column
    private Boolean isActive;

    @Column
    private Date CreationDate;
}
