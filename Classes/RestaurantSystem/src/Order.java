import java.util.*;
import javax.swing.UIDefaults.ProxyLazyValue;

public class Order extends Event{

	private final int maxItemNum = 500;

	protected Item[] orderItems = new Item[maxItemNum];
	protected Package[] orderPackages = new Package[maxItemNum];

	protected int itemCount = 0;
	protected int packageCount = 0;

	public Order(int pax, String custName, Table table)
	{
		super.setCustName(custName);
		super.setPax(pax);
		super.setTable(table);
	}


	public String returnType()
	{
		return "Order";
	}

}

