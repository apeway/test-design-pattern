package org.liws.visitor.bill;

public class Test {

    public static void main(String[] args) {
        AccountBook accountBook = new AccountBook();
        accountBook.add(new OutBill(3000));
        accountBook.add(new InBill(5000));
        accountBook.add(new OutBill(4000));
        accountBook.add(new InBill(8000));
        
        System.out.println("\ncpa 访问：");
        CPA cpa = new CPA();
        accountBook.show(cpa);

        System.out.println("boss 访问：");
        Boss boss = new Boss();
        accountBook.show(boss);
        boss.getResult();
    }

}