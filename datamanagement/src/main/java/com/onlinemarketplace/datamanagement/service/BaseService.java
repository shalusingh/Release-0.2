package com.onlinemarketplace.datamanagement.service;

import javax.persistence.EntityManager;

public interface BaseService<T> {
	public T getRepository();
    public EntityManager getEntityManager();

}
