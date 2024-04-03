package tecyou;

public class Bill {
	
	private String name;
	private String account;
	private String type;
	private double money;
	private String time;
	private String memo;
	
	public Bill( String name, String account, String type, double money, String time, String memo) {
		super();
		
		this.name = name;
		this.account = account;
		this.type = type;
		this.money = money;
		this.time = time;
		this.memo = memo;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	

	
	
	

}
