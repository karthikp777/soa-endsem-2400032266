
package com.klef.soa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tourists")
@Data
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String destination;
}
