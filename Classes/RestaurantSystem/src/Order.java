import java.util.*;
import javax.swing.UIDefaults.ProxyLazyValue;

public class Order extends Event{

	private final int maxItemNum = 500;

	public Item[] orderItems = new Item[maxItemNum];
	public Package[] orderPackages = new Package[maxItemNum];

	public int itemCount = 0;
	public int packageCount = 0;

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

