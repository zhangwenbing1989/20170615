package cn.javass.chapter2.csv;


public class Data {

	private static final String PREFIX = "\"";
	private static final String SUFFIX = "\"";
	private static final String SEPERATOR = ",";
	private static final String NEW_LINE = "\r\n";
	
	private String id;
	private String name;
	private String age;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		return sb
				.append(PREFIX).append(id).append(SUFFIX)
				.append(SEPERATOR)
				.append(PREFIX).append(name).append(SUFFIX)
				.append(SEPERATOR)
				.append(PREFIX).append(age).append(SUFFIX)
				.append(NEW_LINE)
				.toString();
	}
}
