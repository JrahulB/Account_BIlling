/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osiersystems.pojos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author user
 */
public class Balance {

    private final SimpleStringProperty name;
    private final SimpleIntegerProperty stock;
    private final SimpleIntegerProperty price;
 
    public Balance(String pname, Integer pstock, Integer prate)
    {
        this.name = new SimpleStringProperty(pname);
        this.stock = new SimpleIntegerProperty(pstock);
        this.price = new SimpleIntegerProperty(prate);
    }
 
    public String getName() 
    {
        return name.get();
    }
    public void setName(String pname) 
    {
        name.set(pname);
    }
        
    public int getStock() 
    {
        return stock.get();
    }
    public void setStock(Integer pstock) 
    {
        stock.set(pstock);
    }
    
    public int getPrice() 
    {
        return price.get();
    }
    public void setPrice(Integer prate) 
    {
       price.set(prate);
    }
}
