package com.wang.shop.user.service;

import com.wang.shop.admin.entity.Admin;
import com.wang.shop.user.dao.UserDao;
import com.wang.shop.user.entity.User;
import com.wang.shop.util.PageBean;

public class UserService {

	private UserDao userDao;
	
	public void save(User user) {
		userDao.save(user);
	}
	
	public User findUserByName(String userNiName){
		return userDao.findUserByName(userNiName);
	}
	
	public User findUserForLogin(User user){
		return userDao.findUserForLogin(user);
	}
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}
	
	public boolean checkAndUpdatePwd(String password,String newPassword,String userNiName){
		if(userDao.checkPwd(password, userNiName)){
			userDao.updatePwd(userNiName, newPassword);
			return true;
		}
		return false;
	}

	public PageBean<User> findByPage(int page) {
		PageBean<User> pageBean=new PageBean<User>();
		pageBean.setPage(page);
		int limit=4;
		pageBean.setLimit(limit);
		int totalCount=userDao.findAllCount();
		pageBean.setTotalCount(totalCount);
		int totalPage=totalCount%limit>0?totalCount/limit+1:totalCount/limit;
		pageBean.setTotalPage(totalPage);
		
		int begin=(page-1)*limit;
		pageBean.setList(userDao.findAll(begin,limit));
		
		return pageBean;
		
	}

	public User findById(int id) {
		return userDao.findById(id);
	}

	public void deleteUser(int id) {

		userDao.deleteUser(id);
	}
	
}
