package dao;

public interface AccountDAO {
    boolean transferFunds(int fromId, int toId, double amount);
}

