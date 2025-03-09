package com.example.wallet.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Entity class for Wallet.
 * One to many relationship with Wallet. Holds list of transactions.
 * One to one relationship with User.
 * */
@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long walletId;
	private Integer balance;
	
    @OneToOne(mappedBy = "wallet")
    private Users user;
	
    

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transactions> transactions = new ArrayList<>();

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Long getWalletId() {
		return walletId;
	}

	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}

	public Wallet(Long walletId) {
		super();
		this.walletId = walletId;
	}

	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}

}
