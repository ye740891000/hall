package com.wwx.hall.common.utils;

/**
 * 常量
 *
 * @author 王伟欣
 * @email 740891000@qq.com
 * @date 2016年11月15日 下午1:23:52
 */
public class Constant {
	/** 超级管理员ID */
	public static final int SUPER_ADMIN = 1;
	/** 数据权限过滤 */
	public static final String SQL_FILTER = "sql_filter";
	/**
	 * 菜单类型
	 *
	 * @author 王伟欣
	 * @email 740891000@qq.com
	 * @date 2016年11月15日 下午1:24:29
	 */
    public enum MenuType {
        /**
         * 目录
         */
    	CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 定时任务状态
     *
     * @author 王伟欣
     * @email 740891000@qq.com
     * @date 2016年12月3日 上午12:07:22
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
    	NORMAL(0),
        /**
         * 暂停
         */
    	PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3);

        private int value;

        CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

	/**
	 * C端用户类型
	 */
	public enum MaterialType {
		/**
		 * 视频
		 */
		VIDEO("VIDEO"),
		/**
		 * 图片
		 */
		IMAGE("IMAGE"),
		/**
		 * PPT
		 */
		PPT("PPT"),
		/**
		 * 网址
		 */
		WWW("WWW"),
		/**
		 * EXE
		 */
		EXE("EXE");

		private String value;

		MaterialType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * C端用户类型
	 */
	public enum UserType {
		/**
		 * 目录
		 */
		WX("WX"),
		/**
		 * 菜单
		 */
		APP("APP");

		private String value;

		UserType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
}
