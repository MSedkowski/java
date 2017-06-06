package banksystem;

import java.math.BigDecimal;
//import com.mysql.jdbc.Connection;
import java.sql.*;

import banksystem.model.AccountData;
import banksystem.model.AccountRepository;

public class LoadSaveDatabase  {
    
    static private java.sql.Connection dbConnection;
    static private String databaseName = "banksystem";
    static private String user = "root";
    static private String password = "test";
    static private String jdbcConnectionString = 
        "jdbc:mysql://localhost:3306/" + databaseName + "?useSSL=false";
    
    public static boolean loginMethod(String login, String pass) throws SQLException {
        java.sql.Statement stmt = null;
        ResultSet rs = null;
        dbConnection = (Connection) DriverManager.getConnection(jdbcConnectionString, user, password);
        String query = "SELECT COUNT(id) FROM accountData WHERE accountName = '" + login + "' AND accountPassword = '" + pass +"';";
        stmt = dbConnection.createStatement();
        rs = stmt.executeQuery(query);
        if (rs.next()) {
            if (rs.getBoolean(1)) return true;
            else return false;
        }
        else return false;
    }
    
    public static void loadData(AccountRepository accountRepository) throws SQLException {
        java.sql.Statement stmt = null;
        ResultSet rs = null;
        dbConnection = (Connection) DriverManager.getConnection(jdbcConnectionString, user, password);
        String query = "SELECT * FROM accountData";
        stmt = dbConnection.createStatement();
        rs = stmt.executeQuery(query);
        String name, surname, street, post, city, pesel, accountNumber, login, password, accountType;
        BigDecimal accountBalance;
        Boolean isAdmin;
        while (rs.next()) {
            name = rs.getString("name");
            surname = rs.getString("surname");
            street = rs.getString("street");
            post = rs.getString("post");
            city = rs.getString("city");
            pesel = rs.getString("PESEL");
            accountNumber = rs.getString("accountNumber");
            accountBalance = rs.getBigDecimal("accountBalance");
            login = rs.getString("accountName");
            password = rs.getString("accountPassword");
            accountType = rs.getString("accountType");
            isAdmin = rs.getBoolean("isAdmin");
            accountRepository.addAccount(new AccountData(name, surname, street, post, city, pesel, accountNumber, 
                                                     accountBalance, login, password, accountType, isAdmin));
        }
    }
    
    public static void saveDatabase(AccountRepository accountRepository) throws SQLException {
        java.sql.Statement statement = null;
        dbConnection = (Connection) DriverManager.getConnection(jdbcConnectionString, user, password);
    try {
        String query = "TRUNCATE " + databaseName + ".accountData";
        statement = dbConnection.createStatement();
        statement.executeUpdate(query);
        String name, surname, street, post, city, pesel, accountNumber, login, password, accountType;
        BigDecimal accountBalance;
        for(int i = 0; i < accountRepository.getAccountList().size(); i++) {
            name = accountRepository.getAccountList().get(i).getName();
            surname = accountRepository.getAccountList().get(i).getSurname();
            street = accountRepository.getAccountList().get(i).getStreet();
            post = accountRepository.getAccountList().get(i).getPostCode();
            city = accountRepository.getAccountList().get(i).getCity();
            pesel = accountRepository.getAccountList().get(i).getPesel();
            accountNumber =  accountRepository.getAccountList().get(i).getAccountNumber();
            accountBalance = accountRepository.getAccountList().get(i).getAccountBalance();
            login = accountRepository.getAccountList().get(i).getLogin();
            password = accountRepository.getAccountList().get(i).getPassword();
            accountType = accountRepository.getAccountList().get(i).getAccountType();
         
            query = "INSERT INTO " + databaseName + 
                    ".accountData (name, surname, street, post, city, PESEL, accountNumber, accountBalance, "
                    + "accountName, accountPassword, accountType) " +
                    "VALUES ('" + name + "', '" + surname + "', '" + street + "', '" +
                    post + "', '" + city + "', '" + pesel + "', '" + accountNumber + "', '" + accountBalance
                    + "', '" + login + "', '" + password + "', '" + accountType + "');";
            statement.executeUpdate(query);
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {
        if (statement != null) { 
            try {
                statement.close();
                dbConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
        }
    }
    }

    public static void loadSpecificData(String columnName, String search, AccountRepository accountRepository) throws SQLException {
        java.sql.Statement stmt = null;
        ResultSet rs = null;
        dbConnection = (Connection) DriverManager.getConnection(jdbcConnectionString, user, password);
        String query = "SELECT * FROM accountData WHERE " + columnName + " = " + "'" + search + "'";
        stmt = dbConnection.createStatement();
        rs = stmt.executeQuery(query);
        String name, surname, street, post, city, pesel, accountNumber, login, password, accountType;
        BigDecimal accountBalance;
        Boolean isAdmin;
        while (rs.next()) {
            name = rs.getString("name");
            surname = rs.getString("surname");
            street = rs.getString("street");
            post = rs.getString("post");
            city = rs.getString("city");
            pesel = rs.getString("PESEL");
            accountNumber = rs.getString("accountNumber");
            accountBalance = rs.getBigDecimal("accountBalance");
            login = rs.getString("accountName");
            password = rs.getString("accountPassword");
            accountType = rs.getString("accountType");
            isAdmin = rs.getBoolean("isAdmin");
            accountRepository.addAccount(new AccountData(name, surname, street, post, city, pesel, accountNumber, 
                                                     accountBalance, login, password, accountType, isAdmin));
        }
    }
        
    
}
