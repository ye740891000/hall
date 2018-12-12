package com.wwx.hall.modules.sys.vo;

/**
 * UecXmlBuilder
 *
 * @author 无量天尊
 * @version 0.1v
 * @create 2018-09-14 10:58
 * @see
 **/
public class UecXmlBuilder {
	public String volumeControl(String action) {
		return new MessageBean("CONTROL", "VOLUME", action, "", "").toXml();
	}

	public String closeControl() {
		return new MessageBean("CONTROL", "SHUTDOWN", "", "", "").toXml();
	}

	public String rebootControl() {
		return new MessageBean("CONTROL", "REBOOT", "", "", "").toXml();
	}

	public String videoControl(String action) {
		String xml = "";
		if (action.equals("0")) {
			xml =  new MessageBean("CONTENT", "VIDEO", "PAUSE", "", "").toXml();
		} else if (action.equals("1")) {
			xml = new MessageBean("CONTENT", "VIDEO", "REPLAY", "", "").toXml();
		}
		return xml;
	}
	public String pptControl(String action) {
		String xml = "";
		if (action.equals("0")) {
			xml =  new MessageBean("CONTENT", "PPT", "PREV", "", "").toXml();
		} else if (action.equals("1")) {
			xml = new MessageBean("CONTENT", "PPT", "NEXT", "", "").toXml();
		}
		return xml;
	}

}
