package comt.model;

public class adminInfo {
	private String admin_phone;
	private String admin_password;
	private String admin_name;
	
	public String getAdmin_phone() {
		return admin_phone;
	}
	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	
	public adminInfo(String admin_phone){
		super();
		this.admin_phone = admin_phone;
	}
	
	public adminInfo(String admin_phone,String admin_password,String admin_name){
		super();
		this.admin_phone=admin_phone;
		this.admin_password=admin_password;
		this.admin_name=admin_name;	
	}
	public adminInfo(){
		super();
	}
	

	@Override
	public String toString(){
		return "admin_info [admin_phone="+admin_phone+",admin_password="+admin_password+",admin_name="+admin_name+"]" ;
	}
	
}
