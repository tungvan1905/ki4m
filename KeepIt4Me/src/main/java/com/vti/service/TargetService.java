package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.Target;
import com.vti.repository.TargetRepository;

@Service
@Transactional
public class TargetService {

   @Autowired
   private TargetRepository targetRepository;
    
   public List<Target> listAll() {
       return targetRepository.findAll();
   }
    
   public void save(Target target) {
	   targetRepository.save(target);
   }
    
   public Target get(int id) {
       return targetRepository.findById(id).get();
   }
    
   public void delete(int id) {
	   targetRepository.deleteById(id);
   }
}