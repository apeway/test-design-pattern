package org.liws.visitor.bill;

/**
 * 账单
 */
interface IBill {
    void accept(IAccountBookVisitor viewer);
}

/**
 * 收入账单
 */
class InBill implements IBill {

    private double amount;

    public double getAmount() {
        return amount;
    }
    
    public InBill(double amount) {
        this.amount = amount;
    }

    @Override public void accept(IAccountBookVisitor viewer) {
        viewer.view(this);
    }
}

/**
 * 消费账单
 */
class OutBill implements IBill {

    private double amount;
    
    public double getAmount() {
        return amount;
    }
    
    public OutBill(double amount) {
        this.amount = amount;
    }

    @Override public void accept(IAccountBookVisitor viewer) {
        viewer.view(this);
    }
}


