package mypackage.services;

import mypackage.models.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface SpringDataOwnerRepository extends CrudRepository<Owner, Long> {

    @Query("Select o from Owner o left join fetch o.dog where o.id=:id")
    Optional<Owner> getOwnerWithDog(@Param("id")Long id);
}
