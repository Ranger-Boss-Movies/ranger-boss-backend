package com.example.rangerbossbackend.data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "genre_name", nullable = false)
    private String name;
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            targetEntity = Movie.class)
    @JoinTable(
            name="movie_genre",
            joinColumns = {@JoinColumn(name = "genre_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="movie_id", nullable = false, updatable = false)},
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    @JsonIgnoreProperties("genres")
    private List<Movie> relatedMovies;

}
