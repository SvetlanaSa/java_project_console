package com.company;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static IAccountDAO accountDAO = null;
    private static ICreditCardDAO creditDAO = null;
    private static ITransactionDAO transactionDAO = null;

    static {

        accountDAO = new AccountDAOImp((ConnectionFactory.getInstance()));
        creditDAO= new CreditClassDAO((ConnectionFactory.getInstance()));
        transactionDAO= new TransactionDAO((ConnectionFactory.getInstance()));

    }

    public static void main(String[] args) throws Exception {

        String st[] = {"gfh", "ngfn", "ncnhgn", "ncn", "ngffcn", "ngfm", "fhfht", "Kdkjjd", "JHfhjgjh", "fgfgfg", "Sdpsofo", "fgfxxx", "fgfffh"};

        for (int i = 1; i <=1000; i++) {
            Account account1 = new Account(st[new Random().nextInt(st.length)], st[new Random().nextInt(st.length)], st[new Random().nextInt(st.length)]);
            accountDAO.insertAccount(account1);
        }


        List<Account> accounts = accountDAO.getAllAccount();
        Random r = new Random();
        for (int i = 1; i <=1200; i++) {
            int Account_ID1 = accounts.get(r.nextInt(accounts.size())).getAccount_ID();
            Credit_Card creditCard1 = new Credit_Card(Account_ID1,r.nextDouble()*15);
            creditDAO.insertCredit_Card(creditCard1);
        }

        List<Credit_Card> credit_Card = creditDAO.getAllCredit();
        for (int i = 1; i <=1400; i++) {
            long from_Credit_Card1 = credit_Card.get(r.nextInt(credit_Card.size())).getCredit_Card_ID();
            long to_Credit_Card1  = credit_Card.get(r.nextInt(credit_Card.size())).getCredit_Card_ID();
            if (from_Credit_Card1!=to_Credit_Card1) {
                Transaction transaction1 = new Transaction(from_Credit_Card1, to_Credit_Card1, r.nextDouble() * 5);
                transactionDAO.insertTransaction(transaction1);
            }
            else {
                i--;
            }
        }


        Account last = null;
        System.out.println("1 ------------------------View Account-------------------------------");
        for (Account account : accountDAO.getAllAccount()) {
            System.out.println(account);
            last = account;
        }

        Credit_Card last1 = null;
        System.out.println("2 --------------------------View Credit Card---------------------------");
        for (Credit_Card credit_Card1: creditDAO.getAllCredit()) {
            System.out.println(credit_Card1);
            last1 = credit_Card1;
        }

        Transaction last2 = null;
        System.out.println("3 -------------------View Transaction----------------------------------");
        for (Transaction transaction1 : transactionDAO.getAllTrasaction()) {
            System.out.println(transaction1);
            last2 = transaction1;
        }

        System.out.println("4 ------------------------Update Account-------------------------------");
        System.out.println(last);
        accountDAO.updateAccount(last);
        accountDAO.getAllAccount().forEach(System.out::println);

        System.out.println("5 ------------------------Update Credit Card-----------------------------");
        System.out.println(last1);
        creditDAO.updateCredit_Card(last1);
        creditDAO.getAllCredit().forEach(System.out::println);

        System.out.println("6 ------------------------Update Transaction-----------------------------");
        System.out.println(last2);
        transactionDAO.updateTransaction(last2);
        transactionDAO.getAllTrasaction().forEach(System.out::println);

        System.out.println("7 ------------------------Delete Account-------------------------------");
        System.out.println(last.getAccount_ID());
        accountDAO.deleteAccount(last.getAccount_ID());
        accountDAO.getAllAccount().forEach(System.out::println);

        System.out.println("8 ------------------------Delete Credit Card------------------------------");
        System.out.println(last1.getCredit_Card_ID());
        creditDAO.deleteCredit_Card(last1.getCredit_Card_ID());
        creditDAO.getAllCredit().forEach(System.out::println);


        System.out.println("9 ------------------------Delete Transaction-----------------------------");
        System.out.println(last2.getTransaction_ID());
        transactionDAO.deleteTransaction(last2.getTransaction_ID());
        transactionDAO.getAllTrasaction().forEach(System.out::println);
    }


}


