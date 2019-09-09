package org.liws.visitor.bill;

/**
 * 账本访问者
 */
public interface IAccountBookVisitor {
    void view(OutBill consumerBill);
    void view(InBill incomeBill);
}

/**
 * 账本访问者--老板
 * 	查看总支出和总收入
 */
class Boss implements IAccountBookVisitor {

	private double totalConsumer;
	private double totalIncome;
	
	public void getResult() {
		System.out.println("累计支出了：" + totalConsumer);
		System.out.println("累计收入了：" + totalIncome);
		double result = totalIncome - totalConsumer;
		if(result >= 0) {
			System.out.println("累计净收入：" + result);
		} else {
			System.out.println("累计净支出：" + (-result));
		}
	}
	
	@Override public void view(OutBill outBill) {
		totalConsumer = totalConsumer + outBill.getAmount();
	}

	@Override  public void view(InBill inBill) {
		totalIncome = totalIncome + inBill.getAmount();
	}
}

/**
 * 账本访问者--会计
 *  记录每笔单子
 */
class CPA implements IAccountBookVisitor {

	int count = 0;

	@Override public void view(OutBill outBill) {
		count++;
		System.out.println("第" + count + "个单子消费了：" + outBill.getAmount());
	}

	@Override public void view(InBill inBill) {
		count++;
		System.out.println("第" + count + "个单子收入了：" + inBill.getAmount());
	}

}