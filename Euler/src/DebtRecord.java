import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DebtRecord {

	String borrower = "";
	String lender = "";
	int amount = 0;

	DebtRecord() {
		// empty constructor
	}

	DebtRecord(String borrower, String lender, int amount) {
		this.borrower = borrower;
		this.lender = lender;
		this.amount = amount;
	}

	public static void main(String[] args) {
		List<DebtRecord> debt = new ArrayList<>();

		debt.add(new DebtRecord("Alex", "Blake", 2));
		debt.add(new DebtRecord("Blake", "Alex", 2));
		debt.add(new DebtRecord("Casey", "Alex", 5));
		debt.add(new DebtRecord("Blake", "Casey", 7));
		debt.add(new DebtRecord("Alex", "Blake", 4));
		debt.add(new DebtRecord("Alex", "Casey", 4));

		Map<String, Integer> accountList = new HashMap<>();

		for (DebtRecord d : debt) {
			if (!accountList.containsKey(d.borrower)) {
				accountList.put(d.borrower, 0);
				accountList.put(d.lender, 0);
			}
			accountList.replace(d.borrower, accountList.get(d.borrower) - d.amount);
			accountList.replace(d.lender, accountList.get(d.lender) + d.amount);

		}

		for (String key : accountList.keySet()) {
			System.out.println(key + " = " + accountList.get(key));
		}
		System.out.println("======================");
		
		List<Entry<String, Integer>> list = new ArrayList<>(accountList.entrySet());
		list.sort(Entry.comparingByValue());
		
		for (Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
	}

}
