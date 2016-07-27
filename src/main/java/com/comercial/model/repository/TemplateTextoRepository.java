package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.notify.TemplateTexto;

@RepositoryRestResource(collectionResourceRel = "template", path = "template", exported = true)
public interface TemplateTextoRepository extends PagingAndSortingRepository<TemplateTexto, Long> {

}
