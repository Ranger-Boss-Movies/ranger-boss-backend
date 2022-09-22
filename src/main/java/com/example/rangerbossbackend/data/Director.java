package com.example.rangerbossbackend.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "director_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "director")
    @JsonIgnoreProperties("director")
    private Collection<Movie> movies;
}
