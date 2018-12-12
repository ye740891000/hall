package com.wwx.hall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class HallApplicationTests {

	@Test
	public void contextLoads() {
		String message = "1$2*3$4";
		System.out.println(message.split("\\*").length);
//		 message = message.replace("$", "&");
//		System.out.println(message.replace("$", "&"));
	}

}
