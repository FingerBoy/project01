package com.wang.shop.admin.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.wang.shop.admin.entity.Admin;
import com.wang.shop.util.PageHibernateCallback;
/**
 * 操作管理员信息的业务层
 * @author Administrator
 *
 */
public class AdminDao extends HibernateDaoSupport{

	public Admin findAdminForLogin(String name, String password) {
		String hql="from Admin a where a.name=? and a.password=?";
		List<Admin> list = (List<Admin>) this.getHibernateTemplate().find(hql, name,password);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		
		return null;
	}

	public void saveAdmin(Admin admin) {

		this.getHibernateTemplate().save(admin);
	}

	public int findAllCount() {
		String hql="select count(*) from Admin";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Admin> findAll(int begin,int limit) {
		String hql="from Admin";
		List<Admin> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Admin>(hql, new Object[]{}, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public Admin findAdminById(int id) {
	
		Admin admin=this.getHibernateTemplate().get(Admin.class, id);
		return admin;
	}

	public void updateAdmin(Admin admin) {

		this.getHibernateTemplate().update(admin);
	}

	public void savePwd(Admin a) {

		this.getHibernateTemplate().save(a);
	}

	public void deleteAdminById(int id) {
		HibernateTemplate template = this.getHibernateTemplate();
		Admin admin=template.get(Admin.class, id);
		template.delete(admin);
	}

	
}
