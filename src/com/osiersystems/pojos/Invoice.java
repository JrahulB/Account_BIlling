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
public class Invoice {
    private final SimpleIntegerProperty serial;
    private final SimpleStringProperty items;
    private final SimpleIntegerProperty hsn;
    private final SimpleIntegerProperty quantity;
    private final SimpleIntegerProperty price;
    private final SimpleIntegerProperty amount;
    private final SimpleIntegerProperty discount;
    private final SimpleIntegerProperty taxable;
    private final SimpleIntegerProperty pricec;
    private final SimpleIntegerProperty amountc;
    private final SimpleIntegerProperty prices;
    private final SimpleIntegerProperty amounts;
    private final SimpleIntegerProperty total;
 
    public Invoice(Integer ser, String item, Integer hsncode, Integer quantity1,Integer price, Integer amount, Integer dis, Integer value, Integer cprice, Integer camt, Integer sprice, Integer samt, Integer tot ) {
        this.serial = new SimpleIntegerProperty(ser);
        this.items = new SimpleStringProperty(item);
        this.hsn = new SimpleIntegerProperty(hsncode);
        this.quantity = new SimpleIntegerProperty(quantity1);
        this.price = new SimpleIntegerProperty(price);
        this.amount = new SimpleIntegerProperty(amount);
        this.discount = new SimpleIntegerProperty(dis);
        this.taxable = new SimpleIntegerProperty(value);
        this.pricec = new SimpleIntegerProperty(cprice);
        this.amountc = new SimpleIntegerProperty(camt);
        this.prices = new SimpleIntegerProperty(sprice);
        this.amounts = new SimpleIntegerProperty(samt);
        this.total = new SimpleIntegerProperty(tot);
    }
   public int getSerial() {
        return serial.get();
    }
    public void setSerial(Integer ser) {
        serial.set(ser);
    }
    public String getItems() {
        return items.get();
    }
    public void setItems(String item) {
        items.set(item);
    }
    public int getHsn() {
        return hsn.get();
    }
    public void setHsn(Integer hsncode) {
        hsn.set(hsncode);
    }
  
    public int getQuantity() {
        return quantity.get();
    }
    public void setQuantiy(Integer quantity1) {
        quantity.set(quantity1);
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
     public int getDiscount() {
        return discount.get();
    }
    public void setDiscount(Integer dis) {
        discount.set(dis);
    }
       public int getTaxable() {
        return taxable.get();
    }
    public void setTaxable(Integer value) {
        taxable.set(value);
    }
     public int getPricec() {
        return pricec.get();
    }
    public void setPricec(Integer cprice) {
        pricec.set(cprice);
    }
    public int getAmountc() {
        return amountc.get();
    }
    public void setAmountc(Integer camount) {
        amountc.set(camount);
    }
     public int getrices() {
        return prices.get();
    }
    public void setPrices(Integer sprice) {
        prices.set(sprice);
    }
    public int getAmounts() {
        return amounts.get();
    }
    public void setSgstAmounts(Integer samount) {
        amounts.set(samount);
    }
    public int getTotal() {
        return total.get();
    }
    public void setTotal(Integer tot) {
        total.set(tot);
    }
}
