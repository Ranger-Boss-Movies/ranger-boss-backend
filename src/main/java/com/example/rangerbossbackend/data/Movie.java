package com.example.rangerbossbackend.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="movies")

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;
    private String rated;
    private Long year;
    private Double rating;
    private String poster;

    @Column(length = 1024)
    private String plot;

    @ManyToOne
    @JsonIgnoreProperties("movies")
    private Director director;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            targetEntity = Genre.class)
    @JoinTable(
            name="movie_genre",
            joinColumns = {@JoinColumn(name = "movie_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="genre_id", nullable = false, updatable = false)},
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    @JsonIgnoreProperties("relatedMovies")
    private Collection<Genre> genres;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            targetEntity = Actor.class)
    @JoinTable(
            name="movie_actor",
            joinColumns = {@JoinColumn(name = "movie_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="actor_id", nullable = false, updatable = false)},
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    @JsonIgnoreProperties("filmography")
    private Collection<Actor> actors;
}
