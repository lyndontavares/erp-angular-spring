package com.comercial.model.specification;

public abstract class AbstractSpecification<T> implements Specification<T> {


  public abstract boolean isSatisfiedBy(T t);
 
  public Specification<T> and(final Specification<T> specification) {
    return new AndSpecification<T>(this, specification);
  }
 
  public Specification<T> or(final Specification<T> specification) {
    return new OrSpecification<T>(this, specification);
  }
 
  public Specification<T> not(final Specification<T> specification) {
    return new NotSpecification<T>(specification);
  }
  
}
