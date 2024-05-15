package com.mattcoding.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
//@Table(name = "AUTHOR_TBL")
@NamedQuery(
        name = "Author.findByNamedQuery",
        query = "select a from Author a where a.age >= :age"
)

@NamedQuery(
        name = "Author.updateByNamedQuery",
        query = "update Author a set a.age = :age"
)



public class Author extends BaseEntity {



//    @Column(
//            name = "f-name",
//            length = 40
//    )
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private Integer age;

    @ManyToMany(mappedBy = "authors") ////Exact field name of list
    private List<Course> courses;

}
