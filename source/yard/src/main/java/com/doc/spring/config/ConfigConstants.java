/**
 * 
 */
package com.doc.spring.config;

import java.io.File;

/**
 * @author Elmehdi.zangui
 *
 */
public class ConfigConstants {
	
	public static final String CREATE_DB_SQL = "db"+File.separator+"sql"+File.separator+"create-db.Sql";
	public static final String INSERT_DB_SQL = "db"+File.separator+"sql"+File.separator+"insert-db.Sql";

	public static String xmlApplication="xml"+File.separator+"application.xml";
	public static String xmlBeans="xml"+File.separator+"beans.xml";
	
	public static String groovyApplication="groovy"+File.separator+"application.groovy";
	
	// Profile
	
	public static final String DERBY_PROFILE="deby";
	public static final String H2_PROFILE="h2";
	public static final String HSQL_PROFILE="hsql";
	
	
			
}
