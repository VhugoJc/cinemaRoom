package com.hyperskill.cinema.repositories;

import com.hyperskill.cinema.models.Purchase;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PurchaseRepository {
    List<Purchase> purchaseList = new ArrayList<>(); // create empy list of Purchased seats

    // Adds a purchase to the repository.
    public void add(Purchase purchase){
        purchaseList.add(purchase);
    }
    // Retrieves all purchases from the repository.
    public List<Purchase> getAll(){
        return this.purchaseList;
    }

    // Removes a purchase from the repository.
    public void remove(Purchase purchase){
        purchaseList.remove(purchase);
    }

}
