package com.laguna.videogames.videogames.controllers;

import com.laguna.videogames.videogames.dtos.CategoryRequestDto;
import com.laguna.videogames.videogames.dtos.CategoryResponseDto;
import com.laguna.videogames.videogames.models.Category;
import com.laguna.videogames.videogames.services.CategoryService;
import com.laguna.videogames.videogames.mappers.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        List<CategoryResponseDto> responseDtoList = categoryMapper.toResponse(categories);
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        CategoryResponseDto responseDto = categoryMapper.toResponse(category);
        return category != null ?
                new ResponseEntity<>(responseDto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

   // @PostMapping("/create")
   // public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
   // Category newCategory = categoryService.save(categoryMapper.toModel(categoryRequestDto));
    //  CategoryResponseDto responseDto = categoryMapper.toResponse(newCategory);
    //   return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    //  }

    @PostMapping("/create")
    public ResponseEntity<CategoryResponseDto> createCategory(
            @RequestBody CategoryRequestDto categoryRequestDto
    ) {
        Category categorySaved = categoryService.save(categoryMapper.toModel(categoryRequestDto));
        return ResponseEntity.created(null).body(categoryMapper.toResponse(categorySaved));
}

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDto categoryRequestDto) {
        Category updatedCategory = categoryService.update(id, categoryMapper.toModel(categoryRequestDto));
        CategoryResponseDto responseDto = categoryMapper.toResponse(updatedCategory);
        return updatedCategory != null ?
                new ResponseEntity<>(responseDto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
