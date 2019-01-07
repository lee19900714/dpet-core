package com.dpet.commons;

public class Constants {
	
	/**
	 * 降序排序
	 */
	public static final String SORT_DOWN="0";
	
	/**
	 * 升序排序
	 */
	public static final String SORT_UP="1";
	
	/**
	 * 向后取数
	 */
	public static final String DIRECTION_BACK="0";

	/**
	 * 向前取数
	 */
	public static final String DIRECTION_PRE="1";

	/**
	 * 上拉刷新
	 */
	public static final Integer IS_PULLDOWN=1;
	
	/**
	 * 默认一个页面的开始值
	 */
	public static final Integer DEFAULT_START=0;
	
	/**
	 * 默认一个页面的数量
	 */
	public static final Integer DEFAULT_LIMIT=10;
	
	/**
	 * 默认排序字段
	 */
	public static final String DEFAULT_SORTER = "id";
	
	/**
	 * 默认排序方式
	 */
	public static final String DEFAULT_SORT = "DESC";
	
	/**
	 * 默认文件显示数量
	 */
	public static final Integer DEFAULT_FILE_LIMIT=3;
	
	/**
	 * 默认字符串的截取长度
	 */
	public static final Integer DEFAULT_SUBSTRING_LENGTH=60;
	
	/**
	 * 图片缩放的宽度
	 */
	public static final Integer PICTURE_RESIZE_WIDTH=150;
	
	/**
	 * 图片缩放的高度
	 */
	public static final Integer PICTURE_RESIZE_HEIGHT=150;
	
	/**
	 * 图片缩放的质量
	 */
	public static final float PICTURE_QUAILTY=0.60f;
	
	
	/**
	 * 图片缩放的高度
	 */
	public static final String RESIZE="RESIZE";
	
	/**
	 * 是否启用标记：开启
	 */
	public static final String ON = "TRUE";

	/**
	 * 是否启用标记：关闭
	 */
	public static final String OFF = "FALSE";
	/**
	 * JPush 通知类型消息
	 */
	public static final int JPUSH_MESSAGE_TYPE_NOTIFI = 1;
	/**
	 * JPush 透传类型消息
	 */
	public static final int JPUSH_MESSAGE_TYPE_TOUCHUAN = 2;
	
	/**
	 * web/mobile用户
	 */
	public static int ROLE_WebNormal = 1;
	/**
	 * 保车连管理员
	 */
	public static int ROLE_OpAdmin = 2;
	/**
	 * 保车连测试
	 */
	public static int ROLE_OpTestAdmin = 3;
	/**
	 * 保车连运营
	 */
	public static int ROLE_OpNormal = 4;
	/**
	 * 保车连财务
	 */
	public static int ROLE_OpFinance = 5;
	/**
	 * 保车连技师
	 */
	public static int ROLE_Technician = 6;
	/**
	 * 最大接单距离
	 */
	public static int MAX_ORDER_RAIDUS = 25;
	/**
	 * 询单默认排序：时间
	 */
	public static int ORDER_SORT_DEFALT = 0;
	/**
	 * 询单默认排序：距离
	 */
	public static int ORDER_SORT_LOCATION = 1;
	
	public static Integer TRUE_FLAG = 1;
	
	public static Integer FALSE_FLAG = 0;
	/**
	 * 提现状态：申请中，未处理
	 */
	public static Integer WITHDRAWALS_STATUS_APPLYING = 100;
	/**
	 * 提现状态：已处理，失败
	 */
	public static Integer WITHDRAWALS_STATUS_FAILED = -100;
	/**
	 * 提现状态：银行处理中，失败
	 */
	public static Integer WITHDRAWALS_STATUS_BANK = 150;
	/**
	 * 提现状态：成功
	 */
	public static Integer WITHDRAWALS_STATUS_SUCCESS = 200;
	
	/**
	 * 活动状态：启用
	 */
	public static final String CAMPAIGN_STATUS_OPEN = "1";
	
	/**
	 * 活动状态：关闭
	 */
	public static final String CAMPAIGN_STATUS_CLOSE = "0";
}
