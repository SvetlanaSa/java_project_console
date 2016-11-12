package com.company;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Света on 05.11.2016.
 */
public class AccountDAOImp implements IAccountDAO{

    public static ConnectionFactory connectionFactory1;
    List<Account> Accounts;

    private ConnectionFactory connectionFactory;

    public AccountDAOImp(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public static void setConnectionFactory1(ConnectionFactory connectionFactory1) {
        AccountDAOImp.connectionFactory1 = connectionFactory1;
    }

    @Override
     public Account getAccount(int Account_ID) throws SQLException {
            PreparedStatement mystm  = null;
            ResultSet result = null;
            Account account = null;
            Connection connection = connectionFactory.getConnection();
            try {
                                mystm = connection.prepareStatement("SELECT * FROM account_c WHERE account_id=?");
                mystm.setInt(1,Account_ID);
                result = mystm.executeQuery();

                while (result.next()) {
                    account = new  Account(result.getString("first_name"),result.getString("last_name"),result.getString("country"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            finally {
              mystm.close();
              connection.close();
            }

            return account;
     }

    @Override
    public void insertAccount(Account account) throws Exception {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement mystm=null;
        try {
            mystm = connection.prepareStatement("INSERT INTO account_c (account_id, first_name,last_name,country) VALUES (account_seq.nextval,?,?,?)");
         //   mystm.setInt(1, account.getAccount_ID());
            mystm.setString(1, account.getFirstName());
            mystm.setString(2, account.getLastName());
            mystm.setString(3, account.getCountry());
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
    public void insertallAccount(List <Account> accounts) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement mystm= null;
        try {
             mystm = connection.prepareStatement("INSERT INTO account_c (account_id, first_name,last_name,country) VALUES (?,?,?,?)");
            for (Account account: accounts) {
                mystm.setInt(1, account.getAccount_ID());
                mystm.setString(2, account.getFirstName());
                mystm.setString(3, account.getLastName());
                mystm.setString(4, account.getCountry());
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
    public void updateAccount(Account account) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement mystm=null;
        try {
            mystm= connection .prepareStatement("UPDATE account_c SET " +
                    "first_name=?, last_name=?, country=?"+ "where account_id=?");
            mystm.setString(1, account.getFirstName());
            mystm.setString(2, account.getLastName());
            mystm.setString(3, account.getCountry());
            mystm.setInt(4, account.getAccount_ID());
            mystm.execute();
        } finally {
            if (mystm != null) {
                 mystm.close();
                 connection.close();
            }
        }
        }




    @Override
    public void deleteAccount(int Account_ID) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement mystm = null;
        Account account = null;
        try {
            mystm = connection.prepareStatement("DELETE FROM account_c WHERE account_id=?");
            mystm.setInt(1,Account_ID);
            mystm.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        finally {
            mystm.close();
            connection.close();
            }
        }


   /* public List<Account> getAllAccount() throws SQLException {
        Connection connection = connectionFactory.getConnection();
        List<Account> accounts = new ArrayList<Account>();
            try {
                Statement mystm = connection.createStatement();
                ResultSet result  = mystm.executeQuery("SELECT * FROM account_c");
                while (result .next()){
                    accounts.add(new Account(result.getString("first_name"),result.getString("last_name"),result.getString("country")));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            finally {
                connection.close();}

        return accounts;
    }*/
   @Override
   public List<Account> getAllAccount() throws SQLException {
       Connection connection = connectionFactory.getConnection();
       List<Account> accounts = new ArrayList<Account>();
        try {
            Statement mystm = connection.createStatement();
            ResultSet result  = mystm.executeQuery("SELECT * FROM account_c");
        while (result.next()){
            accounts.add(new Account(result.getInt("account_id"),result.getString("first_name"),result.getString("last_name"),result.getString("country")));
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
        finally {
            connection.close();
        }
        return accounts;
}


}









