package com.company;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by Света on 06.11.2016.
 */
public class CreditClassDAO implements ICreditCardDAO {
    public static ConnectionFactory connectionFactory1;
    List<Account> Accounts;

    private ConnectionFactory connectionFactory;

    public CreditClassDAO(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public static void setConnectionFactory1(ConnectionFactory connectionFactory1) {
        AccountDAOImp.connectionFactory1 = connectionFactory1;
    }

    @Override
    public List<Credit_Card> getAllCredit() throws SQLException {
        Connection connection = connectionFactory.getConnection();
        List<Credit_Card> credit_Card = new ArrayList<Credit_Card>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result= statement.executeQuery("SELECT * FROM credit_card");
            while (result.next()){
                credit_Card.add(new Credit_Card(result.getLong("credit_card_id"),result.getInt("account_id"),result.getDouble("cash_amount")));
            }
        }  catch (SQLException e) {
        System.out.println(e.getMessage());
    }
            finally {
           connection.close();
            }
        return credit_Card;
    }


    @Override
    public Credit_Card getCredit_Card(long Credit_Card_ID) throws SQLException {
        PreparedStatement mystm  = null;
        ResultSet result = null;
        Credit_Card credit_Card = null;
        Connection connection = connectionFactory.getConnection();
        try {
            mystm = connection.prepareStatement("SELECT * FROM credit_card WHERE credit_card_id=?");
            mystm.setLong(1,Credit_Card_ID);
            result = mystm.executeQuery();

            while (result.next()) {
                credit_Card = new  Credit_Card(result.getLong("credit_card_id"),result.getInt("account_id"),result.getDouble("cash_amount"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
               mystm.close();
           connection.close();
        }
        return credit_Card;
    }

    @Override
    public void insertCredit_Card(Credit_Card credit_Card) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement mystm=null;
        try {
            mystm = connection.prepareStatement("INSERT INTO credit_card (credit_card_id, account_id, cash_amount) VALUES (credit_seq.NEXTVAL,?,?)");
            mystm.setInt(1, credit_Card.getAccount_ID());
            mystm.setDouble(2,credit_Card.getCash_amount());
            mystm.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
           finally {
             mystm.close();
            connection.close();
            }
    }

    @Override
    public void insertallCredit_Card(List<Credit_Card> credit_Cards) throws Exception {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement mystm= null;
        try {
             mystm = connection.prepareStatement("INSERT INTO credit_card (credit_card_id, account_id, cash_amount) VALUES (credit_seq.NEXTVAL,?,?)");
            for (Credit_Card credit_Card: credit_Cards) {
                mystm.setInt(1, credit_Card.getAccount_ID());
                mystm.setDouble(2,credit_Card.getCash_amount());
                mystm.addBatch();
            }
            mystm.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            mystm.close();
            connection.close();
            }
    }


    @Override
    public void updateCredit_Card(Credit_Card credit_Card) throws SQLException {
        PreparedStatement mystm=null;
        Connection connection = connectionFactory.getConnection();
        try {
            mystm= connection.prepareStatement("UPDATE credit_card SET " +
                    "account_id=?, cash_amount=?"+ "where credit_card_id=?");
            mystm.setLong(3,credit_Card.getCredit_Card_ID());
            mystm.setInt(1, credit_Card.getAccount_ID());
            mystm.setDouble(2,credit_Card.getCash_amount());
            mystm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (mystm != null) {
                mystm.close();
            }
        }
    }


    @Override
    public void deleteCredit_Card(long Credit_Card_ID) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement mystm = null;
        Credit_Card credit_Card = null;
        try {
            mystm = connection.prepareStatement("DELETE FROM credit_card WHERE credit_card_id=?");
            mystm.setLong(1,Credit_Card_ID);
            mystm.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            mystm.close();
            connection.close();
        }
    }
    }

