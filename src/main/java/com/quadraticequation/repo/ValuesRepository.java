package com.quadraticequation.repo;

import com.quadraticequation.model.entity.QuadraticValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValuesRepository extends JpaRepository<QuadraticValues, Long> {

}
