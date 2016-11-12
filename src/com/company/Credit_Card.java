package com.company;

/**
 * Created by Света on 02.11.2016.
 */
public class Credit_Card {
     private long Credit_Card_ID;
     private int Account_ID;
     private double Cash_amount;

     public Credit_Card(long credit_Card_ID, int account_ID, double cash_amount) {
          this.Credit_Card_ID = credit_Card_ID;
          this.Account_ID = account_ID;
          this.Cash_amount = cash_amount;
     }

     public Credit_Card(int account_ID, double cash_amount) {
          this.Account_ID = account_ID;
          this.Cash_amount = cash_amount;
     }

     public Credit_Card() {
     }

     public long getCredit_Card_ID() {
          return Credit_Card_ID;
     }

     public void setAccount_ID(int account_ID) {
          Account_ID = account_ID;
     }
     public void setCredit_Card_ID(long Credit_Card_ID) {
          this.Credit_Card_ID = Credit_Card_ID;
     }

     public int getAccount_ID() {
          return Account_ID;
     }

     public void setGroupId(int Account_ID) {
          this.Account_ID = Account_ID;
     }

     public double getCash_amount() {
          return Cash_amount;
     }

     public void setCash_amount(double Cash_amount) {
          this.Cash_amount = Cash_amount;
     }


     @Override
     public String toString() {
          return "Credit_Card{" +
                  "Credit_Card_ID=" + Credit_Card_ID +
                  ", Account_ID=" + Account_ID +
                  ", Cash_amount=" + Cash_amount +
                  '}';
     }

 }

