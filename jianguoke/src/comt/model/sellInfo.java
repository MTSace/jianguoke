package comt.model;

public class sellInfo {
	private int sell_id;
	private String sell_password;
	private String sell_name;
	private String sell_type;
	private String sell_liceid;
	private String sell_addr;
	private String sell_phone1;
	private String sell_phone2;
	private int sell_level;
	private int sell_identstate;
	
	public int getSell_id() {
		return sell_id;
	}
	public void setSell_id(int sell_id) {
		this.sell_id = sell_id;
	}
	public String getSell_password() {
		return sell_password;
	}
	public void setSell_password(String sell_password) {
		this.sell_password = sell_password;
	}
	public String getSell_name() {
		return sell_name;
	}
	public void setSell_name(String sell_name) {
		this.sell_name = sell_name;
	}
	public String getSell_type() {
		return sell_type;
	}
	public void setSell_type(String sell_type) {
		this.sell_type = sell_type;
	}
	public String getSell_liceid() {
		return sell_liceid;
	}
	public void setSell_liceid(String sell_liceid) {
		this.sell_liceid = sell_liceid;
	}
	public String getSell_addr() {
		return sell_addr;
	}
	public void setSell_addr(String sell_addr) {
		this.sell_addr = sell_addr;
	}
	public String getSell_phone1() {
		return sell_phone1;
	}
	public void setSell_phone1(String sell_phone1) {
		this.sell_phone1 = sell_phone1;
	}
	public String getSell_phone2() {
		return sell_phone2;
	}
	public void setSell_phone2(String sell_phone2) {
		this.sell_phone2 = sell_phone2;
	}
	public int getSell_level() {
		return sell_level;
	}
	public void setSell_level(int sell_level) {
		this.sell_level = sell_level;
	}
	public int getSell_identstate() {
		return sell_identstate;
	}
	public void setSell_identstate(int sell_identstate) {
		this.sell_identstate = sell_identstate;
	}

	public sellInfo(){
		super();
	}
	
	public sellInfo(String sell_password){
		super();
		this.sell_password=sell_password;
	}
	
	public sellInfo(String sell_password,String sell_type){
		super();
		this.sell_password = sell_password;
		this.sell_type = sell_type;
	}
	
	public sellInfo(String sell_password,String sell_type,String sell_addr){
		super();
		this.sell_password = sell_password;
		this.sell_type = sell_type;
		this.sell_addr = sell_addr;
	}
	
	public sellInfo(String sell_password,String sell_type,String sell_addr,String sell_phone1){
		super();
		this.sell_password = sell_password;
		this.sell_type = sell_type;
		this.sell_addr = sell_addr;
		this.sell_phone1 = sell_phone1;
	}
	
	public sellInfo(String sell_password,String sell_type,String sell_addr,String sell_phone1,String sell_phone2){
		super();
		this.sell_password = sell_password;
		this.sell_type = sell_type;
		this.sell_addr = sell_addr;
		this.sell_phone1 = sell_phone1;
		this.sell_phone2 = sell_phone2;
	}
	
}
