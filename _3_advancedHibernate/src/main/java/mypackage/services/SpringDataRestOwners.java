package mypackage.services;

import mypackage.models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//samo zrobi resta!!
@RepositoryRestResource(path ="owners")
public interface SpringDataRestOwners extends CrudRepository<Owner, Long> {
}
