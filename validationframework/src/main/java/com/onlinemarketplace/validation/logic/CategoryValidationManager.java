package com.onlinemarketplace.validation.logic;

import org.springframework.stereotype.Component;

import com.onlinemarketplace.dataentity.enums.Status;
import com.onlinemarketplace.dto.domain.CategoryDto;

@Component
public class CategoryValidationManager extends ValidationManagerImpl<CategoryDto, Status> {

}
