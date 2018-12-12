package com.wwx.hall.modules.sys.vo;

/**
 * MessageDto
 *
 * @author 无量天尊
 * @version 0.1v
 * @create 2018-09-26 10:39
 * @see
 **/
public class MessageDto {
	/**
	 * mac
	 */
	private String mac;

	/**
	 * tid
	 */
	private String tid;

	/**
	 * cid
	 */
	private String cid;

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public MessageDto() {
	}

	public MessageDto(String mac, String tid, String cid) {

		this.mac = mac;
		this.tid = tid;
		this.cid = cid;
	}
}
