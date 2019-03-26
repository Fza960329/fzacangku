package cn.com.taiji.bean;

public class XmlBean {
	private String name;
	private String id;
	
	public void start() {
		System.out.println("初始化方法");
	}
	public void stop() {
		System.out.println("销毁方法");
	}
	
	
	
	
	public XmlBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public XmlBean(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
