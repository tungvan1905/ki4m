package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

   @Autowired
   private AccountRepository accountRepository;
   
   public List<Account> listAll() {
       return accountRepository.findAll();
   }
    
   public void save(Account account) {
	   accountRepository.save(account);
   }
    
   public Account get(int id) {
       return accountRepository.findById(id).get();
   }
    
   public void delete(int id) {
	   accountRepository.deleteById(id);
   }
}