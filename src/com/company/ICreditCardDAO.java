package com.company;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Света on 04.11.2016.
 */
public interface ICreditCardDAO {
    public List<Credit_Card> getAllCredit() throws SQLException;
    public Credit_Card getCredit_Card(long Credit_Card_ID) throws SQLException;
    public void insertCredit_Card(Credit_Card credit_Card) throws Exception;
    public void insertallCredit_Card(List <Credit_Card> credit_Card)throws Exception;
    public void updateCredit_Card(Credit_Card credit_Card) throws SQLException;
    public void deleteCredit_Card(long credit_Card) throws SQLException;


}
