package Exectuion;/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 20-02-2022
 */

import Defination.Bank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        myThread.sleep(1000L);
        Bank account1 = new Bank(1, 1000);
        Bank accoutnt2 = new Bank(2, 2000);

        myThread[] thread = new myThread[6];
        //thread for account1
        thread[0] = new myThread(account1, true, 500);
        thread[1] = new myThread(account1, false, 300);
        thread[2] = new myThread(account1, true, 2500);

        //threads for account2
        thread[3] = new myThread(accoutnt2, true, 1500);
        thread[4] = new myThread(accoutnt2, true, 5200);
        thread[5] = new myThread(accoutnt2, false, 2500);

        // loop for starting thread
        for (int threads = 0; threads < 6; threads++) {
            thread[threads].start();

        }
        //loop for completion of threads
        for (int threads = 0; threads < 6; threads++) {
            thread[threads].join();
        }


        System.out.println("Amount in account 1:" + account1.getAccountBalance());
        System.out.println("Amount in account 2:" + accoutnt2.getAccountBalance());
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
            System.out.println("I am in :" + currentThread().getName());
           // synchronized ()-->
            /**
             * Synchronization in java is the capability to control the access of multiple threads to any shared resource.
             * In the Multithreading concept, multiple threads try to access the shared resources at a time to produce
             * inconsistent results.
             * The synchronization is necessary for reliable communication between threads
             */
            synchronized (this.account) {

                this.account.setAccountBalance(this.account.getAccountBalance() + this.amount);
                try {
                    myThread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void withdraw() {
            System.out.println("I am in :" + currentThread().getName());
            this.account.setAccountBalance(this.account.getAccountBalance() - this.amount);
            try {
                myThread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
