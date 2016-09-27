package com.wang.shop.admin.service;

import com.wang.shop.admin.dao.AdminDao;
import com.wang.shop.admin.entity.Admin;
import com.wang.shop.util.PageBean;

public class AdminService {

	private AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	public Admin findAdminForLogin(String name, String password) {
		// TODO Auto-generated method stub
		return adminDao.findAdminForLogin(name,password);
	}
	public void saveAdmin(Admin admin) {
		 adminDao.saveAdmin(admin);
		
	}
	public PageBean<Admin> findPageBean(int page) {
		PageBean<Admin> pageBean=new PageBean<Admin>();
		pageBean.setPage(page);
		int limit=4;
		pageBean.setLimit(limit);
		int totalCount=adminDao.findAllCount();
		pageBean.setTotalCount(totalCount);
		int totalPage=totalCount%limit>0?totalCount/limit+1:totalCount/limit;
		pageBean.setTotalPage(totalPage);
		
		int begin=(page-1)*limit;
		pageBean.setList(adminDao.findAll(begin,limit));
		
		return pageBean;
	}
	public Admin findAdminById(int id) {
		return adminDao.findAdminById(id);
	}
	public void updateAdmin(Admin admin) {
		adminDao.updateAdmin(admin);
	}
	public void savePwd(Admin a) {

		adminDao.savePwd(a);
	}
	public void deleteAdminById(int id) {

		adminDao.deleteAdminById(id);
		
	}
}
