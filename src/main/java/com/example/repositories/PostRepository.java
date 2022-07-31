package com.example.repositories;

import com.example.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAll();

    Optional<Post> findByFileName(String name);

    long count();

    List<Post> findAllById(Iterable<Long> longs);

    @Transactional
    @Modifying
    void deleteById(Integer aLong);
}
