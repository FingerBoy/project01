package com.wang.shop.admin.entity;
/**
 * ����Աʵ����
 * @author Administrator
 *
 */
public class Admin {

	private int id;//����id
	private String name;//�û���
	private String password;//����
	private String idCard;//���֤��
	private String email;//����
	private String phone;//�ֻ���
	private int role;//����ԱȨ��
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
