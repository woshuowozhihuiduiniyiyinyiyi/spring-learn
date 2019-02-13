package com.tj.spring.learn.controller;

import com.tj.spring.learn.entity.Owner;
import com.tj.spring.learn.mapper.OwnerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.Optional;

/**
 * @author tangj
 * @description
 * @since 2019/1/23 11:52
 */
@RestController
@RequestMapping("/owner")
@Validated
public class OwnerController {

    @Resource
    private OwnerMapper ownerMapper;

    @GetMapping("/detail/{id}")
    public ResponseEntity ownerDetail(@Min(value = 1) @PathVariable Integer id) {
        Optional<Owner> owner = ownerMapper.findById(id);
        return ResponseEntity.ok(owner.get());
    }
}
