package com.itschool.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String country;
    private Integer numberOfStreet;


    @OneToOne(mappedBy = "address")
    private User user;

}
