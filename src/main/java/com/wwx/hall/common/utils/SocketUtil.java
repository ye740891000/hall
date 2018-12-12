package com.wwx.hall.common.utils;

import org.apache.commons.lang.StringUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Machine
 *
 * @author 无量天尊
 * @version 0.1v
 * @create 2018-09-12 18:08
 * @see
 **/
public class SocketUtil {


	public static void sendXmlToUecClient(final String ip, final String msg) {
		if (StringUtils.isBlank(msg)) {
			return;
		}
		Socket sock = null;
		OutputStream os = null;
		try {
			int port = 1234;
			int timeOut = 2000;
			sock = new Socket(ip, port);
			sock.setSoTimeout(timeOut);
			os = sock.getOutputStream();
			os.write((msg + "@").getBytes());
			os.flush();
		} catch (Exception e) {
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (sock != null) {
					sock.close();
				}
			} catch (Exception e) {
			}
		}
	}
}
