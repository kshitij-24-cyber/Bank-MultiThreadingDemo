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
                try {
                    deposit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                withdraw();
            }
        }

        private void deposit() throws InterruptedException {
            this.account.setAccountBalance(this.account.getAccountBalance() + this.amount);
            myThread.sleep(2000);
        }

        private void withdraw() {
            this.account.setAccountBalance(this.account.getAccountBalance() - this.amount);
        }
    }
}
