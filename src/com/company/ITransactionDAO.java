package com.company;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Света on 04.11.2016.
 */
public interface ITransactionDAO {

    public List<Transaction> getAllTrasaction() throws SQLException;;
    public Transaction getTransaction(int Transaction_ID) throws SQLException;;
    public void insertallTransaction(List <Transaction> transactions)throws Exception;
    public void insertTransaction(Transaction transaction) throws SQLException;
    public void updateTransaction(Transaction transaction) throws SQLException;
    public void deleteTransaction(int transaction) throws SQLException;

}
