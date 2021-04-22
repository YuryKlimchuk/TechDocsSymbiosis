package com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity;

import java.util.List;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.Entities.Asm;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.Filter;

public interface BasicServiceInterface<T, Key> {
	

	/**
	 * @return колекцию отфильтрованных сущностей
	 * @param filters колекция фильтров через которые необходимо пропустить все сущности 
	 */
	public List<T> getFilteredEntities(Filter<T> filters);
	
	
	public T getEntity(Key id);
	
	public long addEntity(T entity);
	
	public long deleteEntity(Key id);
	
	public long update(Key id, T newEntity);
	
	/**
	 * @return возращает карту, key - объект сборки, value - количество.
	 * @param entityId id сущности, type -  тип сущности
	 */
	public Map<Asm, Long> getSpecificationRowsByEntityId(long entityId);
	
	
	/**
	 * @return возращает ключ в случае если получилось добавить элемент
	 * @param entity сущность для добавления в таблицу
	 */
	public Key getSpecificationRowsByEntityId(T entity);


}
