package com.company;


import java.sql.Timestamp;

/**
 * Created by Света on 02.11.2016.
 */
public class Transaction {
     private int Transaction_ID;
     private long From_Credit_Card;
     private long To_Credit_Card;
     private double Amount;
     private java.sql.Timestamp Date_tran;

     public Transaction(int transaction_id, long from_Credit_Card, long to_Credit_Card, double amount, java.sql.Timestamp date_trans)
     {
          this.Transaction_ID = transaction_id;
          this.From_Credit_Card = from_Credit_Card;
          this.To_Credit_Card = to_Credit_Card;
          this.Amount=amount;
          this.Date_tran=date_trans;
     }

     public Transaction(long from_Credit_Card, long to_Credit_Card, double amount)
     {
          this.From_Credit_Card = from_Credit_Card;
          this.To_Credit_Card = to_Credit_Card;
          this.Amount=amount;
     }
     public Transaction() {
     }


     public int getTransaction_ID() {
          return  Transaction_ID;
     }

     public void setTransaction_ID(int  Transaction_ID) {
          this. Transaction_ID =  Transaction_ID;
     }

     public long getFrom_Credit_Card() {
          return From_Credit_Card;
     }

     public void setFrom_Credit_Card(long From_Credit_Card) {
          this.From_Credit_Card = From_Credit_Card;
     }

     public long getTo_Credit_Card() {
          return To_Credit_Card;
     }

     public void setTo_Credit_Card(long To_Credit_Card) {
          this.To_Credit_Card = To_Credit_Card;
     }

     public double getAmount() {
          return Amount;
     }

     public void setAmount(double Amount) {
          this.Amount = Amount;
     }

     public java.sql.Timestamp getDate_tran() {
          return Date_tran;
     }

     public void setDate_tran(java.sql.Timestamp Date_tran) {
          this.Date_tran = Date_tran;
     }


     @Override
     public String toString() {
          return "Transaction{" +
                  "Transaction_ID=" + Transaction_ID +
                  ", From_Credit_Card=" + From_Credit_Card +
                  ", To_Credit_Card=" + To_Credit_Card +
                  ", Amount=" + Amount +
                  ", Date_tran=" + Date_tran +
                  '}';
     }
}
