package com.mattcoding.jpa.specification;

import com.mattcoding.jpa.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AuthSpecification {

    public static Specification<Author> hasAge(int age) {
        return (Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            if(age < 0) {
                return null;
            }
            return builder.equal(root.get("age"), age);
        };
    }
    public static Specification<Author> firstnameContains(String firstname) {
        return (Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            if(firstname == null) {
                return null;
            }
            return builder.like(root.get("firstName"), "%" + firstname +"%");
        };
    }
}
