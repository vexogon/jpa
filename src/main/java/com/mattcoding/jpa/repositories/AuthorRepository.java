package com.mattcoding.jpa.repositories;

import com.mattcoding.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age);

    //Select * from author where first_name = 'al'
     List<Author> findAllByFirstName(String fn);


     // select * from author where first_name like al%
     List<Author> findAllByFirstNameIgnoreCase(String fx);

     // select * from author where first-name like 'al%'
     List<Author> findAllByFirstNameContainingIgnoreCase(String fx);



    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    // select * from author where first_name like 'al%'
    List<Author> findAllByFirstNameEndingWithIgnoreCase(String fn);

    // select * from author where firstname in ("ali', 'bou', 'coding'

    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstnames);

    //Custom SQL Query
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAUthors(int age);


}
