/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniusapp;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class PoItems {
    String SuppName,SuppEmail,SuppPostal,ShipToname,ShipToEmail,ShipToMobile,ItemDesc;
    float UnitPrice,LineTotal;
Date DeliverBy;
float Qty;
    public PoItems(String SuppName, String SuppEmail, String SuppPostal, String ShipToname, String ShipToEmail, String ShipToMobile, String ItemDesc, float Qty, float UnitPrice, float LineTotal,Date DeliverBy) {
        this.SuppName = SuppName;
        this.SuppEmail = SuppEmail;
        this.SuppPostal = SuppPostal;
        this.ShipToname = ShipToname;
        this.ShipToEmail = ShipToEmail;
        this.ShipToMobile = ShipToMobile;
        this.ItemDesc = ItemDesc;
        this.Qty = Qty;
        this.UnitPrice = UnitPrice;
        
        this.LineTotal = LineTotal;
        this.DeliverBy=DeliverBy;
    }

    public Date getDeliverBy() {
        return DeliverBy;
    }
public void setDeliverBy(Date DeliverBy) {
        this.DeliverBy = DeliverBy;
    }

   public String getSuppEmail() {
        return SuppEmail;
    }
    public void setSuppName(String SuppName) {
        this.SuppName = SuppName;
    }

    public String getSuppName() {
        return SuppName;
    }

    public void setSuppEmail(String SuppEmail) {
        this.SuppEmail = SuppEmail;
    }

    public String getSuppPostal() {
        return SuppPostal;
    }

    public void setSuppPostal(String SuppPostal) {
        this.SuppPostal = SuppPostal;
    }

    public String getShipToname() {
        return ShipToname;
    }

    public void setShipToname(String ShipToname) {
        this.ShipToname = ShipToname;
    }

    public String getShipToEmail() {
        return ShipToEmail;
    }

    public void setShipToEmail(String ShipToEmail) {
        this.ShipToEmail = ShipToEmail;
    }

    public String getShipToMobile() {
        return ShipToMobile;
    }

    public void setShipToMobile(String ShipToMobile) {
        this.ShipToMobile = ShipToMobile;
    }

    public String getItemDesc() {
        return ItemDesc;
    }

    public void setItemDesc(String ItemDesc) {
        this.ItemDesc = ItemDesc;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

   

    public float getLineTotal() {
        return LineTotal;
    }

    public void setLineTotal(float LineTotal) {
        this.LineTotal = LineTotal;
    }
    
}
