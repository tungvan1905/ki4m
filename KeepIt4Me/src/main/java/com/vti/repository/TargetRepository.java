package com.vti.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Target;

public interface TargetRepository extends JpaRepository<Target, Integer> {

}