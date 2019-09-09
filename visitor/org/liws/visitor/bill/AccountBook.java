package org.liws.visitor.bill;

import java.util.ArrayList;
import java.util.List;

/**
 * 账单数据结构
 */
class AccountBook {

    private List<IBill> listBill = new ArrayList<>();

    public void add(IBill bill) {
        listBill.add(bill);
    }

    public void show(IAccountBookVisitor visitor) {
        for (IBill b : listBill) {
            b.accept(visitor);
        }
    }
}
