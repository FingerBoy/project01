package com.wang.shop.user.entity;

/**
 * 用户实体类 User
 * @author Administrator
 *
 */
public class User {

	private int id;//用户主键 id
	private String userNiName;//用户昵称
	private String username;//用户名
	private String password;//密码
	private String passwordok;//确认密码
	private String email;//电子邮箱
	private String mobile;//手机号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserNiName() {
		return userNiName;
	}
	public void setUserNiName(String userNiName) {
		this.userNiName = userNiName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordok() {
		return passwordok;
	}
	public void setPasswordok(String passwordok) {
		this.passwordok = passwordok;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userNiName=" + userNiName + ", username="
				+ username + ", password=" + password + ", passwordok="
				+ passwordok + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
	
}
