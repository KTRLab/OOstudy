package inter.repository;

import java.lang.reflect.Field;

/**
 * 列レベルのメタデータのマッピング情報クラス.
 * 
 * テーブルカラムとオブジェクトフィールドをマッピングします.
 */

public class ColumnMap {
	private String columnName;
	private String fieldName;
	private Field field;
	private MetaDataMap dataMap;

	public ColumnMap(String columnName, String fieldName, MetaDataMap dataMap) throws Exception {
		this.columnName = columnName;
		this.fieldName = fieldName;
		this.dataMap = dataMap;
		initField();
	}

	public String getColumnName() {
		return columnName;
	}

	public void setField(Object subject, Object columnValue) throws Exception {
		try {
			field.set(subject, columnValue);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getValue(Object subject) throws Exception {
		try {
			return field.get(subject);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private void initField() throws Exception {
		try {
			field = dataMap.getDomainClass().getDeclaredField(fieldName);
			field.setAccessible(true);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}


}
