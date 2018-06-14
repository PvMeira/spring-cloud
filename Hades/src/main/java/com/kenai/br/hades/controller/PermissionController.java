package com.kenai.br.hades.controller;

import com.kenai.br.hades.model.dto.PermissionDTO;
import com.kenai.br.hades.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
@Api(value = "Permission", description = "Permission Controller", tags = "Permission")
public class PermissionController {

    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Find a Permission by ID")
    public PermissionDTO findById(@ApiParam(name = "id", value = "Permission id", required = true)
                                  @PathVariable(value = "id", required = true) Long id){
        return this.permissionService.findById(id);
    }
}
