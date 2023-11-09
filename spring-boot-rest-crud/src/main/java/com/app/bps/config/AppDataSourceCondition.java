package com.app.bps.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * AppDataSourceCondition static inner classes are used to verify the @Conditional in AppDataSource
 * 
 * @author parth
 *
 */
public class AppDataSourceCondition {

	public static class H2DataSource implements Condition {
		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

			String dbDatasource = "h2";

			String dbEnvVal = context.getEnvironment().getProperty("app.datasource.enabled");

			if (!dbEnvVal.equals("oracle") && !dbEnvVal.equals("mysql") && !dbEnvVal.equals("postgresql")
					&& !dbEnvVal.equals("h2")) {
				System.out.println(
						"###############################################################################################");
				System.out.println("app.datasource.enabled supported property(h2/oracle/mysql/postgresql) not matched.");
				System.out.println("Enabling default H2 database.");
				System.out.println(
						"###############################################################################################");
			}

			return isDatasourceValid(context, dbDatasource);
		}

	}

	public static class OracleDataSource implements Condition {
		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
			return isDatasourceValid(context, "oracle");
		}

	}

	public static class MySQLDataSource implements Condition {
		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
			return isDatasourceValid(context, "mysql");
		}

	}
	
	public static class PostgreSQLDataSource implements Condition {
		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
			return isDatasourceValid(context, "postgresql");
		}

	}

	private static boolean isDatasourceValid(ConditionContext context, String dbDatasource) {
		String dbEnvVal = context.getEnvironment().getProperty("app.datasource.enabled");

		return dbDatasource.equals("h2") ? dbDatasource.equals("h2") : dbDatasource.equals(dbEnvVal);
	}

}
