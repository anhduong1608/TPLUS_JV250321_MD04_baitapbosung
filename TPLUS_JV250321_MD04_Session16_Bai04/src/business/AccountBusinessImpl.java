package business;

import dao.AccountDAO;
import dao.AccountDAOImpl;

public class AccountBusinessImpl implements AccountBusiness {
    private AccountDAO dao = new AccountDAOImpl();

    @Override
    public void transfer(int fromId, int toId, double amount) {
        boolean result = dao.transferFunds(fromId, toId, amount);
        System.out.println(result ? "Chuyển tiền thành công!" : "Chuyển tiền thất bại!");
    }
}
