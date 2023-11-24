package com.foronly.common.redis;

/**
 * <p>
 *
 * </p>
 *
 * @author li_cang_long
 * @since 2023/11/23 19:44
 */
public class Constants {

	/**
	 * 自动识别json对象白名单配置（仅允许解析的包名，范围越小越安全）
	 */
	public static final String[] JSON_WHITELIST_STR = {"org.springframework", "com.foronly"};
}
