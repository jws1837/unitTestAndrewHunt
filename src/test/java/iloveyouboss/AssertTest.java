package iloveyouboss;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AssertTest {
  private Account account;

  class Account {

    int balance;
    String name;

    Account(String name) {
      this.name = name;
    }

    void deposit(int dollars) {
      balance += dollars;
    }

    void withdraw(int dollars) {
      if (balance < dollars) {
        throw new InsufficientFundsException("balance only " + balance);
      }
      balance -= dollars;
    }

    public String getName() {
      return name;
    }

    public int getBalance() {
      return balance;
    }

    public boolean hasPositiveBalance() {
      return balance > 0;
    }
  }

  @Before
  public void createAccount() {
    account = new Account("an account name");
  }

  class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
      super(message);
    }

    private static final long serialVersionUID = 1L;
  }

  @Test
  public void hasPositiveBalance() {
    account.deposit(50);
    assertTrue(account.hasPositiveBalance());
  }

  @Test
  public void depositIncreasesBalance() {
    int initialBalance = account.getBalance();
    account.deposit(100);
    assertTrue(account.getBalance() > initialBalance);
    assertThat(account.getBalance(), equalTo(100));
  }
}
