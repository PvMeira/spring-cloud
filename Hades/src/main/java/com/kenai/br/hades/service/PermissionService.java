package com.kenai.br.hades.service;

import com.kenai.br.hades.model.dto.PermissionDTO;
import com.kenai.br.hades.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService  extends AbstractService{

    private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public PermissionDTO findById(Long id) {
        return this.map(this.permissionRepository
                            .findOne(id), PermissionDTO.class);
    }


}
