package utdallas.edu.dbProject.dbo;

import java.sql.Date;

public class Category {
	private Integer category_id;
	private String company_name;
	private Integer category_parent;
	private Date creation_date;
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public Integer getCategory_parent() {
		return category_parent;
	}
	public void setCategory_parent(Integer category_parent) {
		this.category_parent = category_parent;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", company_name=" + company_name + ", category_parent="
				+ category_parent + ", creation_date=" + creation_date + "]";
	}
}
