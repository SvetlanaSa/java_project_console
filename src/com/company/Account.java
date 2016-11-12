package com.company;

/**
 * Created by Света on 02.11.2016.
 */
public class Account {
        private int Account_ID;
        private String FirstName;
        private String LastName;
        private String Country;

    public int getAccount_ID() {
        return Account_ID;
    }

    public void setAccount_ID(int account_ID) {
        Account_ID = account_ID;
    }

    public Account(String FirstName, String LastName, String Country) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Country = Country;
    }

    public Account(int Account_ID, String FirstName, String LastName, String Country){
               this.Account_ID = Account_ID;
               this.FirstName = FirstName;
               this.LastName = LastName;
               this.Country = Country;
        }

    public Account() {
    }

        public String getFirstName() {
                return FirstName;
        }

        public void setFirstName(String FirstName) {
                this.FirstName = FirstName;
        }


        public String getLastName() {
                return LastName;
        }

        public void setLastName(String LastName) {
                this.LastName = LastName;
        }

        public String getCountry() {
                return Country;
        }

        public void setCountry(String Country) {
                this.Country = Country;
        }

    @Override
    public String toString() {
        return "Account{" +
                "Account_ID=" + Account_ID +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
}
