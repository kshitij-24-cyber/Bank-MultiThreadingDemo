package Exectuion;/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 20-02-2022
 */

import Defination.Bank;

public class Main {
    public static void main(String[] args) {
        Bank accoutnt1 = new Bank(1, 1000);
        Bank accoutnt2 = new Bank(2, 2000);

        myThread[] thread = new myThread[6];
        //thread for account1
        thread[1] = new myThread(accoutnt1, true, 500);
        thread[2] = new myThread(accoutnt1, false, 300);
        thread[3] = new myThread(accoutnt1, true, 2500);

        //threads for account2
        thread[4] = new myThread(accoutnt2, true, 1500);
        thread[5] = new myThread(accoutnt2, true, 5200);
        thread[6] = new myThread(accoutnt2, false, 2500);

        // loop for starting thread
        for (int threads = 0; threads <6 ; threads++) {

        }
        //loop for completion of threads

    }

    public static class myThread extends Thread {
        private Bank account;
        boolean isDepost;
        private double amount;

        public myThread(Bank account, boolean isDepost, double amount) {
            this.account = account;
            this.isDepost = isDepost;
            this.amount = amount;
        }

        @Override
        public void run() {
            if (isDepost) {
                deposit();
            } else {
                withdraw();
            }
        }

        private void deposit() {
            this.account.setAccountBalance(this.account.getAccountBalance() + this.amount);
            try {
                myThread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void withdraw() {
            this.account.setAccountBalance(this.account.getAccountBalance() - this.amount);
            try {
                myThread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
