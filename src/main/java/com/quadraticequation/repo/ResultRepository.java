package com.quadraticequation.repo;

import com.quadraticequation.model.entity.QuadraticAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<QuadraticAnswers, Long> {
}
