package com.wwx.hall.modules.sys.vo;


public class MessageBean {

	public String type;
	public String subtype;
	public String action;
	public String url;
	public String param;
	
	public MessageBean() {
	}

	public MessageBean(String type, String subtype, String action, String url, String param){
		this.type=type;
		this.subtype=subtype;
		this.action=action;
		this.url = url;
		this.param = param;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}

	public String toXml(){
		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<Uec>");
		sb.append("<Type>"+this.getType()+"</Type>");
		sb.append("<SubType>"+this.getSubtype()+"</SubType>");
		sb.append("<Action>"+this.getAction()+"</Action>");
		sb.append("<Url>"+this.getUrl()+"</Url>");
		sb.append("<Param>"+this.getParam()+"</Param>");
		sb.append("</Uec>");
		return sb.toString();
	}
}
