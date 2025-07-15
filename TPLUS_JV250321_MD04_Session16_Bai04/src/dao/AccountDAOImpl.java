package dao;

import util.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.Connection;

public class AccountDAOImpl implements AccountDAO {
    @Override
    public boolean transferFunds(int fromId, int toId, double amount) {
        try (Connection conn = ConnectionDB.getConnection()) {
            CallableStatement cs = conn.prepareCall("{CALL transfer_funds(?, ?, ?)}");
            cs.setInt(1, fromId);
            cs.setInt(2, toId);
            cs.setDouble(3, amount);
            cs.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
}

