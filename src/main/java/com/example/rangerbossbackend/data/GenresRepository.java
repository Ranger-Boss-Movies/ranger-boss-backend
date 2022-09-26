package com.example.rangerbossbackend.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genre, Long> {
    public Genre findByName(String genreName);
}
