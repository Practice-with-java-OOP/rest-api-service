package com.syphan.practice.boardinghouserestfullapi.controller;

import com.syphan.practice.commonservice.util.EntityValidationUtils;
import com.syphan.practice.commonservice.util.response.OpenApiWithDataResponse;
import com.syphan.practice.dto.registration.RoleCreateDto;
import com.syphan.practice.registrationservice.model.Role;
import com.syphan.practice.registrationservice.service.RoleService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Reference
    private RoleService roleService;

    @PreAuthorize("hasAuthority('UPMS_ROLE_READ')")
    @PostMapping
    public ResponseEntity<OpenApiWithDataResponse<Role>> addRole(@Valid @RequestBody RoleCreateDto reqParam,
                                                                 BindingResult bindingResult) {
        EntityValidationUtils.processBindingResults(bindingResult);
        return ResponseEntity.ok(new OpenApiWithDataResponse<Role>(roleService.create(reqParam)));
    }
}
