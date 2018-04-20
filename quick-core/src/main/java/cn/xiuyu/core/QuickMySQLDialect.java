package cn.xiuyu.core;

import org.hibernate.dialect.MySQL57Dialect;

public class QuickMySQLDialect extends MySQL57Dialect {
	@Override
	public boolean supportsCascadeDelete() {
		return true;
	}

	@Override
	public String getTableTypeString() {
		return " ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ";
	}

	@Override
	public boolean hasSelfReferentialForeignKeyBug() {
		return true;
	}
}
