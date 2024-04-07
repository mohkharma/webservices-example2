package com.example.demo.controller;

import com.example.demo.service.CategoryService;
import com.example.demo.dto.CategoryDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * Author: Mohammed Kharma
 */

@RestController
@RequestMapping("/api/category")
public class CategoryResource {
    private final Logger log = LoggerFactory.getLogger(CategoryResource.class);

    //@Autowired //@Autowired annotation is used for dependency injection.
    // In spring boot application, all loaded beans are eligible for
    // auto wiring to another bean.
    //The annotation @Autowired in spring boot is used to auto-wire a bean
    // into another bean. see https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring
    private CategoryService categoryService; //the use of interface rather than class is important for loose coupling

    // Constructor based  injection
    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok().body(categoryService.getAllCategories()); //ResponseEntity represents an HTTP response, including headers, body, and status.
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }


    /**
     * When Spring Boot finds an argument annotated with @Valid,
     * it automatically bootstraps the default JSR 380 implementation — Hibernate Validator —
     * and validates the argument (JSR 380 is a specification of the Java API
     * for bean validation, part of Jakarta EE and JavaSE.
     * This ensures that the properties of a bean meet specific criteria,
     * using annotations such as @NotNull, @Min, and @Max.;
     * <dependency>     <groupId>org.hibernate.validator</groupId>
     * <artifactId>hibernate-validator</artifactId>     <version>8.0.0.Final</version> </dependency>).
     * When the target argument fails to pass the validation,
     * Spring Boot throws a MethodArgumentNotValidException exception.
     *
     * @param categoryDto
     * @return
     */
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory
    (@Valid @RequestBody CategoryDto categoryDto) {
        if (categoryDto.getId() != null) {
            log.error("Cannot have an ID {}", categoryDto);
            throw new BadRequestException(CategoryResource.class.getSimpleName(),
                    "Id");
        }
        if (categoryDto.getName() ==null) {
            log.error("Cannot have an name {}", categoryDto);
            throw new BadRequestException(CategoryResource.class.getSimpleName(),
                    "Name");
        }
        return new ResponseEntity(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory
            (@Valid @RequestBody CategoryDto categoryDto
                    , @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(categoryService.updateCategory(categoryDto, id), HttpStatus.OK);
    }

    //    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") long id) {
        categoryService.deleteCategoryById(id);
//        return ResponseEntity.ok().headers(<add warnings....>).build();
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}
