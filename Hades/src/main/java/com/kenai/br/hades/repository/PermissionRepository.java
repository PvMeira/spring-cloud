package com.kenai.br.hades.repository;

import com.kenai.br.hades.model.Permission;
import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends CrudRepository<Permission,Long> {

}
