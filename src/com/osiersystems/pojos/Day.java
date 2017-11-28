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
public class Day
{
  
    private final SimpleIntegerProperty Billno;
    private final SimpleStringProperty name;
    private final SimpleStringProperty Itemname;
    private final SimpleIntegerProperty quantity;
    private final SimpleIntegerProperty total;
 
    public Day(Integer bno,String ccname, String itemname, Integer qty, Integer tot  ) 
    {
        this.Billno = new SimpleIntegerProperty(bno);
        this.name = new SimpleStringProperty(ccname);
        this.Itemname = new SimpleStringProperty(itemname);
        this.quantity = new SimpleIntegerProperty(qty);
        this.total = new SimpleIntegerProperty(tot);
    }
 
    public int getBillno() 
    {
        return Billno.get();
    }
    public void setBillno(Integer bno) 
    {
       Billno.set(bno);
    }
    public String getName() 
    {
        return name.get();
    }
    public void setName(String ccname) 
    {
       name.set(ccname);
    }
    
    
    public String getItemname() 
    {
        return Itemname.get();
    }
    public void setItemname(String itemname) 
    {
       Itemname.set(itemname);
    }
     public int getQuantity() 
     {
        return quantity.get();
    }
    public void setQuantity(Integer qty) 
    {
       quantity.set(qty);
    }
     public int getTotal() 
     {
        return total.get();
    }
    public void setTotal(Integer tot) 
    {
       total.set(tot);
    }
}
