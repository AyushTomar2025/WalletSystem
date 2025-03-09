package com.example.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wallet.entity.Transactions;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Repository Interface for Transaction
 * */
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

}
