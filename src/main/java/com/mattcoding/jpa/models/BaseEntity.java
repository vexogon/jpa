package com.mattcoding.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass

public class BaseEntity {

    @Id
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.TABLE,
//    generator = "author_id_generator")
//    @TableGenerator(name = "author_id_generator", table = "id_generator", pkColumnName = "id_name",
//            valueColumnName = "id_value", allocationSize = 1)
    private  Integer id;

    private LocalDateTime createdAt;

    private LocalDateTime lastModifiedAt;

    private String createdBy;

    private String lastModifiedBy;


}
