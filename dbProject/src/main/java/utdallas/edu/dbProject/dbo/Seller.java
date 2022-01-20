package utdallas.edu.dbProject.dbo;

public class Seller {
	private int user_id;
	private String company_name;
	private long company_ein;
	private String account_type;
	private long account_number;
	private long routing_number;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public long getCompany_ein() {
		return company_ein;
	}
	public void setCompany_ein(long company_ein) {
		this.company_ein = company_ein;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public long getRouting_number() {
		return routing_number;
	}
	public void setRouting_number(long routing_number) {
		this.routing_number = routing_number;
	}
	@Override
	public String toString() {
		return "Seller [user_id=" + user_id + ", company_name=" + company_name + ", company_ein=" + company_ein
				+ ", account_type=" + account_type + ", account_number=" + account_number + ", routing_number="
				+ routing_number + "]";
	}
}
