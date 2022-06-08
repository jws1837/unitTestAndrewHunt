package iloveyouboss;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class AssertTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

    @Test
    public void FloatPointTest() {
//        assertThat(2.32 * 3, equalTo(6.96)); //fail
        assertEquals(2.32 * 3, 6.96, 0.000001); //success, delta는 오차
    }

    @Test
//            (expected = InsufficientFundsException.class)
    public void throwsWhenWithdrwawingTooMuch() {
        try {
            account.withdraw(100);
            fail(); //<<에러 안뜨는데?
        } catch (InsufficientFundsException exception) {

        }
    }

    @Test
    public void expectionRule() {
        thrown.expect(InsufficientFundsException.class);
        thrown.expectMessage("balance only 0");

        account.withdraw(100);

    }

    @Test
    public void readsFromTestFile() throws IOException {
        String filename = "test.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        bw.write("hello world");
        bw.close();


        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringBuilder result = new StringBuilder();
        String a = "";
        result.append(br.readLine());
        System.out.println(result);
        br.close();
    }


}

