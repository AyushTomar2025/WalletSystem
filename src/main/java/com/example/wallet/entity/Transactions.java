package com.example.wallet.entity;

import java.time.LocalDateTime; 

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Entity class for transactions.
 * Many to one relationship with Wallet. Every transactions hold corresponding wallet ID.
 * */
@Entity
public class Transactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tansactionId;
	@Column(name  = "transactions_type")
	private String transactionsType;
	private Integer amount;
	
	@CreationTimestamp
    private LocalDateTime createdAt;

	
	@ManyToOne
    @JoinColumn(name = "wallet_id")  // This is the important part!
    private Wallet wallet;
	
	public Wallet getWallet() {
		return wallet;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public Long getTansactionId() {
		return tansactionId;
	}
	public void setTansactionId(Long tansactionId) {
		this.tansactionId = tansactionId;
	}
	

	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Transactions(Long tansactionId, String transactionsType, Integer amount, LocalDateTime createdAt,
			Wallet wallet) {
		super();
		this.tansactionId = tansactionId;
		this.transactionsType = transactionsType;
		this.amount = amount;
		this.createdAt = createdAt;
		this.wallet = wallet;
	}
	public String getTransactionsType() {
		return transactionsType;
	}
	public void setTransactionsType(String transactionsType) {
		this.transactionsType = transactionsType;
	}
	public Transactions() {
		super();
	}

}