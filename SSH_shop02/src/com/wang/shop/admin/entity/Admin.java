package com.wang.shop.admin.entity;
/**
 * 管理员实体类
 * @author Administrator
 *
 */
public class Admin {

	private int id;//主键id
	private String name;//用户名
	private String password;//密码
	private String idCard;//身份证号
	private String email;//邮箱
	private String phone;//手机号
	private int role;//管理员权限
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password
				+ ", idCard=" + idCard + ", email=" + email + ", phone="
				+ phone + ", role=" + role + "]";
	}
	
	
}
