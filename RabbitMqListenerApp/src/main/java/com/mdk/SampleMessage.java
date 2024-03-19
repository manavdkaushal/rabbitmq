package com.mdk;

import java.io.Serializable;

public class SampleMessage implements Serializable {
	private String name;
	private String desc;
	
	
	public SampleMessage(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	
	public static String send(String name, String desc) {
		return (new SampleMessage(name, desc)).toString();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "SampleMessage [name=" + name + ", desc=" + desc + "]";
	}
	
	
	
	
}
