package com.hyperskill.cinema.repositories;

import com.hyperskill.cinema.models.Purchase;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PurchaseRepository {
    List<Purchase> purchaseList = new ArrayList<>();

    public void add(Purchase purchase){
        purchaseList.add(purchase);
    }

    public List<Purchase> getAll(){
        return this.purchaseList;
    }

    public void remove(Purchase purchase){
        purchaseList.remove(purchase);
    }

}
