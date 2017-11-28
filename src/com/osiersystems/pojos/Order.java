/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osiersystems.pojos;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/* *
 *
 * @author user
 */
public class Order {
    
    private final SimpleStringProperty items ;
    private final SimpleIntegerProperty quantity;
    private final SimpleStringProperty units;
    private final SimpleIntegerProperty price;
    private final SimpleIntegerProperty amount;
    private final SimpleIntegerProperty cgstrate;
    private final SimpleFloatProperty prodcgst;
    private final SimpleIntegerProperty sgstrate;
    private final SimpleFloatProperty prodsgst;
    private final SimpleFloatProperty taxtotal;
    private final SimpleFloatProperty finaltotal;
    private final SimpleIntegerProperty hsnprod;
 
    public Order(String item, Integer quantity1, String unit,Integer rate1, Integer amount1,Integer prodamt1, Float cgst1,Integer prodsamt1, Float sgst1,Float taxtotal1,Float finaltotal1, Integer hsnprod1) {
        this.items = new SimpleStringProperty(item);
        this.quantity = new SimpleIntegerProperty(quantity1);
        this.units = new SimpleStringProperty(unit);
        this.price = new SimpleIntegerProperty(rate1);
        this.amount = new SimpleIntegerProperty(amount1);
        this.cgstrate = new SimpleIntegerProperty(prodamt1);
        this.prodcgst = new SimpleFloatProperty(cgst1);
         this.sgstrate = new SimpleIntegerProperty(prodsamt1);
        this.prodsgst = new SimpleFloatProperty(sgst1);
        this.taxtotal = new SimpleFloatProperty(taxtotal1);
        this.finaltotal = new SimpleFloatProperty(finaltotal1);
        this.hsnprod = new SimpleIntegerProperty(hsnprod1);
    }

    public Order(String string, int parseInt, String string0, int parseInt0, int i, int i0, float f, int i1, float f0, int parseInt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    public String getItems() {
        return items.get();
    }
    public void setItems(String item) {
        items.set(item);
    }
        
    public int getQuantity() {
        return quantity.get();
    }
    public void setQuantiy(Integer quantity1) {
        quantity.set(quantity1);
    }
    
    public String getUnits() {
        return units.get();
    }
    public void setUnits(String unit) {
        units.set(unit);
    }
      public int getPrice() {
        return price.get();
    }
    public void setPrice(Integer rate1) {
        price.set(rate1);
    }
     public int getAmount() {
        return amount.get();
    }
    public void setAmount(Integer amount1) {
        amount.set(amount1);
    }
    public int getCgstrate() {
        return cgstrate.get();
    }
    public void setCgstrate(Integer prodamt1) {
        cgstrate.set(prodamt1);
    }
    public float getProdcgst() {
        return prodcgst.get();
    }
    public void setProdcgst(Float cgst1) {
        prodcgst.set(cgst1);
    }
    public int getSgstrate() {
        return sgstrate.get();
    }
    public void setSgstrate(Integer prodsamt1) {
        sgstrate.set(prodsamt1);
    }
    public float getProdsgst() {
        return prodsgst.get();
    }
    public void setProdsgst(Float sgst1) {
        prodsgst.set(sgst1);
    }
     public float getTaxtotal() {
        return taxtotal.get();
    }
    public void setTaxtotal(Float taxtotal1) {
       taxtotal.set(taxtotal1);
    }
     public float getFinaltotal() {
        return finaltotal.get();
    }
    public void setFinaltotal(Float finaltotal1) {
       finaltotal.set(finaltotal1);
    }
     public int getHsnprod() {
        return hsnprod.get();
    }
    public void setHsnprod(Integer hsnprod1) {
        hsnprod.set(hsnprod1);
    }
}

