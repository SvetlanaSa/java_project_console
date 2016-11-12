package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Света on 07.11.2016.
 */
public class TransactionDAO implements ITransactionDAO {

    public static ConnectionFactory connectionFactory1;
    List<Transaction> Transactions;

    private ConnectionFactory connectionFactory;


    public TransactionDAO(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public static void setConnectionFactory1(ConnectionFactory connectionFactory1) {
        AccountDAOImp.connectionFactory1 = connectionFactory1;
    }

    @Override
    public  List<Transaction> getAllTrasaction() throws SQLException {
        Connection connection = connectionFactory.getConnection();
        List<Transaction> transactions = new ArrayList<Transaction>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM transsaction");
            while (result.next()){
                transactions.add(new Transaction(result.getInt("transsaction_id"),result.getLong("from_credit_card"),result.getLong("to_credit_card"),result.getDouble("amount"),result.getTimestamp("date_tran")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            connection.close();}
        return transactions;
    }

        @Override
        public Transaction getTransaction(int Transaction_ID) throws SQLException {
            PreparedStatement mystm  = null;
            ResultSet result = null;
            Transaction transaction = null;
            Connection connection = connectionFactory.getConnection();
            try {
                mystm = connection.prepareStatement("SELECT * FROM transsaction WHERE transsaction_id=?");
                mystm.setInt(1,Transaction_ID);
                result = mystm.executeQuery();

                while (result.next()) {
                    transaction = new Transaction(result.getInt("transsaction_id"),result.getLong("from_credit_card"),result.getLong("to_credit_card"),result.getDouble("amount"),result.getTimestamp("date_tran"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            finally {
                mystm.close();
                connection.close();
            }
            return transaction;
        }

    @Override
    public void insertallTransaction(List<Transaction> transactions) throws Exception {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement mystm= null;
        try {
            mystm = connection.prepareStatement("INSERT INTO transsaction (transsaction_id, from_credit_card,to_credit_card,amount,date_tran) VALUES (trans_seq.NEXTVAL,?,?,?,sysdate)");
            for (Transaction transaction:transactions) {
                mystm.setLong(1,transaction.getFrom_Credit_Card());
                mystm.setLong(2,transaction.getTo_Credit_Card());
                mystm.setDouble(3,transaction.getAmount());
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
        public void insertTransaction(Transaction transaction) throws SQLException {
            PreparedStatement mystm  = null;
                Connection connection = connectionFactory.getConnection();
            try {
                mystm = connection.prepareStatement("INSERT INTO transsaction (transsaction_id, from_credit_card, to_credit_card, amount, date_tran) VALUES (trans_seq.NEXTVAL,?,?,?,sysdate)");
                mystm.setLong(1,transaction.getFrom_Credit_Card());
                mystm.setLong(2,transaction.getTo_Credit_Card());
                mystm.setDouble(3,transaction.getAmount());
                mystm.execute();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            finally {
                mystm.close();
                connection.close();}
        }

        @Override
        public void updateTransaction(Transaction transaction) throws SQLException {
            Connection connection = connectionFactory.getConnection();
            PreparedStatement mystm = null;
            try {
                mystm =connection.prepareStatement("UPDATE transsaction SET from_credit_card=?,to_credit_card=?,amount=?,date_tran=? WHERE transsaction_id=?");
                mystm.setLong(1,transaction.getFrom_Credit_Card());
                mystm.setLong(2,transaction.getTo_Credit_Card());
                mystm.setTimestamp(3,transaction.getDate_tran());
                mystm.setDouble(4,transaction.getAmount());
                mystm.setInt(5,transaction.getTransaction_ID());
                mystm.executeQuery();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            finally {
                if (mystm != null) {
                    mystm.close();
                }
            }
        }

    @Override
    public void deleteTransaction(int Transaction_ID) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement mystm = null;
        Transaction transaction = null;
        try {
            mystm = connection.prepareStatement("DELETE FROM transsaction WHERE transsaction_id=?");
            mystm.setInt(1,Transaction_ID);
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

