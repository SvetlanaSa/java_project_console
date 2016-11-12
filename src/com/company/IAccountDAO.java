package com.company;

import java.util.List;
import java.sql.SQLException;
/**
 * Created by Света on 04.11.2016.
 */
public interface IAccountDAO {
    public List<Account> getAllAccount() throws SQLException;
    public Account getAccount(int Account_ID) throws SQLException;
       public void insertAccount(Account account)throws Exception;
       public void insertallAccount(List <Account> account)throws Exception;
       public void updateAccount(Account account) throws SQLException;
       public void deleteAccount(int account)throws SQLException;


}

