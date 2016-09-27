package com.wang.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.wang.shop.admin.entity.Admin;
import com.wang.shop.user.entity.User;
import com.wang.shop.util.PageHibernateCallback;

public class UserDao extends HibernateDaoSupport {

	/**
	 * 将用户信息保存到数据库,注册使用
	 * 
	 * @param user
	 */
	public void save(User user) {

		this.getHibernateTemplate().save(user);
	}

	/**
	 * 通过用户昵称查询User
	 * 
	 * @param userNiName
	 * @return
	 */
	public User findUserByName(String userNiName) {
		List<User> list = (List<User>) this.getHibernateTemplate().find(
				"select u from User u where u.userNiName=?", userNiName);
		if (list != null && list.size() > 0) {
		
			return list.get(0);
		}
		return null;
	}
	/**
	 * 用户登录检测
	 * @param user
	 * @return
	 */
	public User findUserForLogin(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find(
				"select u from User u where u.username=? and u.password=?",
				user.getUsername(), user.getPassword());
		System.out.println(list.size());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user) {
		this.getHibernateTemplate().update(user);
		return true;
	}
	
	public boolean checkPwd(String password,String userNiName){
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User u where u.userNiName=?", userNiName);
		if(password.equals(list.get(0).getPassword())){
			return true;
		}
		return false;
	}
	public boolean updatePwd(String userNiName,String newPassword){
		HibernateTemplate template = this.getHibernateTemplate();
		List<User> list = (List<User>) template.find("from User u where u.userNiName=?", userNiName);
		User u=list.get(0);
		u.setPassword(newPassword);
		u.setPasswordok(newPassword);
		System.out.println(u);
		template.update(u);
		return true;
	}

	public int findAllCount() {
		String hql="select count(*) from User";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<User> findAll(int begin, int limit) {
		String hql="from User";
		List<User> list=this.getHibernateTemplate().execute(new PageHibernateCallback<User>(hql, new Object[]{}, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public User findById(int id) {
		return this.getHibernateTemplate().get(User.class, id);
	}

	public void deleteUser(int id) {

		HibernateTemplate template = this.getHibernateTemplate();
		User user = template.get(User.class, id);
		System.out.println("user!!!"+user);
		
		template.delete(user);;
		
	}
}
