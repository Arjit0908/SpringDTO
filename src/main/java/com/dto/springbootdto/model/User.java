package com.dto.springbootdto.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name="dto")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    private String password;


    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name="location_id")
    private Location location;

}
