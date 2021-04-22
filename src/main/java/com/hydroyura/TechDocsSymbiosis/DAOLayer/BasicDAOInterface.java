package com.hydroyura.TechDocsSymbiosis.DAOLayer;

import java.util.List;

/**
 * Базовый интерфейс для слоя DAO, T тип сущности, Key - тип ключа (ID).
 * @autor Yury Klimchuk
*/
public interface BasicDAOInterface<T, Key> {
	
	public List<T> getAllEntities();
	public T getEntity(Key id);
	public long update(Key id, T newEntity);
	public long delete(Key id);
	public long addEntity(T entity);
	
}
