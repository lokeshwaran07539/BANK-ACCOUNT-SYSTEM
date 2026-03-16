package dao;

import model.Account;
import util.DBConnection;

import java.sql.*;

public class AccountDAO {

    public void createAccount(Account account) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO accounts VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, account.getAccountNumber());
            ps.setString(2, account.getHolderName());
            ps.setDouble(3, account.getBalance());

            ps.executeUpdate();

            System.out.println("Account Created Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account getAccount(int accNo) {

        Account acc = null;

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM accounts WHERE accountNumber=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, accNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                acc = new Account(
                        rs.getInt("accountNumber"),
                        rs.getString("holderName"),
                        rs.getDouble("balance")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return acc;
    }

    public void deposit(int accNo, double amount) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE accounts SET balance = balance + ? WHERE accountNumber=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, accNo);

            ps.executeUpdate();

            System.out.println("Deposit Successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdraw(int accNo, double amount) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE accounts SET balance = balance - ? WHERE accountNumber=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, accNo);

            ps.executeUpdate();

            System.out.println("Withdrawal Successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkBalance(int accNo) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT balance FROM accounts WHERE accountNumber=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, accNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Balance: " + rs.getDouble("balance"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}