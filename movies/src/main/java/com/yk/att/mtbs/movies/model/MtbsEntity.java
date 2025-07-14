package com.yk.att.mtbs.movies.model;

public interface MtbsEntity<T> {

    T copy(boolean forceIsDeleted);

    boolean getIsDeleted();

    Integer getId();

}
