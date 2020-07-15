package dev.innov8.athena.repositories;

import dev.innov8.athena.domain.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository<T extends Resource> extends JpaRepository<T, Integer>, CustomResourceRepository {

}
