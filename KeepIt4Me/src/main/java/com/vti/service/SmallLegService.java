package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.SmallLeg;
import com.vti.repository.SmallLegRepository;

@Service
@Transactional
public class SmallLegService {

   @Autowired
   private SmallLegRepository smallLegRepository;
    
   public List<SmallLeg> listAll() {
       return smallLegRepository.findAll();
   }
    
   public void save(SmallLeg smallLeg) {
	   smallLegRepository.save(smallLeg);
   }
    
   public SmallLeg get(int id) {
       return smallLegRepository.findById(id).get();
   }
    
   public void delete(int id) {
	   smallLegRepository.deleteById(id);
   }
}