package com.wang.shop.admin.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wang.shop.admin.entity.Admin;
import com.wang.shop.admin.service.AdminService;
import com.wang.shop.util.PageBean;
import com.wang.shop.util.VCode;
/**
 * ����Ա��ϢAction
 * @author Administrator
 *
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin>,ServletRequestAware{

	private Admin admin=new Admin();
	private AdminService adminService;
	//��֤������
	private String verify;
	private int page;
	HttpServletRequest request;
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	/**
	 * ��¼����
	 * @return
	 */
	public String login(){
		admin=adminService.findAdminForLogin(admin.getName(),admin.getPassword());
		//String checkVerify=
		if(!verify.equalsIgnoreCase(VCode.content)){
			this.addActionError("��֤���������,����������");
			return INPUT;
		}
		System.out.println(VCode.content);
		System.out.println(admin);
		if(admin!=null){
			request.getSession().setAttribute("loginAdmin", admin);
		return "login_succ";
		}
		this.addActionError("�û������������,����������");
		return INPUT;
	}
	/**
	 * ע����ǰ�û�,�˻ص���½ҳ��
	 * @return
	 */
	public String logout(){
		request.getSession().removeAttribute("loginAdmin");
		return INPUT;
	}
	
	/**
	 * ��ӹ���Ա 
	 * @return
	 */
	public String add(){
		System.out.println(admin);
		adminService.saveAdmin(admin);
		return "add_succ";
	}
	
	/**
	 * ��ҳ��ʾ���й���Ա��Ϣ
	 * @return
	 */
	public String adminShow(){
		PageBean<Admin> pageBean=adminService.findPageBean(page);
		//System.out.println(pageBean);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "adminShow";
	}
	/**
	 * ��ת���޸Ĺ���Ա����
	 * @return
	 */
	public String intoUpdate(){
		admin =adminService.findAdminById(admin.getId());
		request.setAttribute("admin", admin);
		return "intoUpdate";
	}
	/**
	 * ���¹���Ա��Ϣ
	 */
	public String adminUpdate(){
		System.out.println(admin);
		adminService.updateAdmin(admin);
		return "adminUpdate_succ";
	}
	
	/**
	 * �޸Ĺ���Ա����
	 * @return
	 */
	public String updatePwd(){
		Admin a=(Admin)request.getSession().getAttribute("loginAdmin");
		a.setPassword(admin.getPassword());
		adminService.savePwd(a);
		
		return "updatePwd_succ";
	}
	/**
	 * ɾ������Ա
	 * @return
	 */
	public String adminDelete(){
		adminService.deleteAdminById(admin.getId());
		return "adminDelete";
	}
	
	
	
	@Override
	public Admin getModel() {
		return admin;
	}
	public void setVerify(String verify) {
		this.verify = verify;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
