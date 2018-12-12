package com.wwx.hall.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * TreadPoolConfig
 *
 * @author 无量天尊
 * @version 0.1v
 * @create 2018-09-12 16:47
 * @see
 **/
@Configuration
public class TreadPoolConfig {
	/**
	 * 队列线程
	 * @return
	 */
	@Bean(value = "queueThreadPool")
	public ExecutorService buildQueueThreadPool() {
		ThreadFactory threadFactory = new ThreadFactoryBuilder()
				.setNameFormat("consumer-queue-thread-%d").build();

		ExecutorService pool = new ThreadPoolExecutor(5, 30, 0L, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5), threadFactory, new ThreadPoolExecutor.AbortPolicy());

		return pool;
	}

}
