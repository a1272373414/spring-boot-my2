package com.tangj.springboot.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

public interface JpaService<T, ID extends Serializable> {

	public abstract List<T> findAll();

	public abstract List<T> findAll(Sort paramSort);

	public abstract List<T> findAll(Iterable<ID> paramIterable);

	public abstract <S extends T> List<S> save(Iterable<S> paramIterable);

	public abstract void flush();

	public abstract <S extends T> S saveAndFlush(S paramS);

	public abstract void deleteInBatch(Iterable<T> paramIterable);

	public abstract void deleteAllInBatch();

	public abstract T getOne(ID paramID);

	public abstract <S extends T> List<S> findAll(Example<S> paramExample);

	public abstract <S extends T> List<S> findAll(Example<S> paramExample, Sort paramSort);

}
