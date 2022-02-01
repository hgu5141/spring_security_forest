package com.sparta.forest.repository;

import com.sparta.forest.model.Forest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForestRepository extends JpaRepository<Forest, Long> {
    List<Forest> findAllByOrderByModifiedAtDesc();
}