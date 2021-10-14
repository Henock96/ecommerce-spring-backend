package com.backend.ecommerce.controller;

import com.backend.ecommerce.common.ApiResponse;
import com.backend.ecommerce.dto.ProduitDto;
import com.backend.ecommerce.model.Category;
import com.backend.ecommerce.repository.CategoryRepository;
import com.backend.ecommerce.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduit(@RequestBody ProduitDto produitDto){
      Optional<Category> optionalCategory = categoryRepository.findById(produitDto.getCategoryId());
      if(!optionalCategory.isPresent()){
          return new ResponseEntity<>(new ApiResponse(false, "Cette categorie n'existe pas"), HttpStatus.BAD_REQUEST);
      }
      produitService.createProduit(produitDto, optionalCategory.get());
      return new ResponseEntity<>(new ApiResponse(true,"Produit ajouté"),HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public  ResponseEntity<List<ProduitDto>> getProduits(){
        List<ProduitDto> produits = produitService.getAllProduits();

        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    //edit produit
    @PostMapping("/update/{produitId}")
    public ResponseEntity<ApiResponse> updateProduit(@PathVariable("produitId") Integer produitId, @RequestBody ProduitDto produitDto) throws Exception {
        Optional<Category> optionalCategory = categoryRepository.findById(produitDto.getCategoryId());
        if(!optionalCategory.isPresent()){
            return new ResponseEntity<>(new ApiResponse(false, "Cette categorie n'existe pas"), HttpStatus.BAD_REQUEST);
        }
        produitService.updateProduit(produitDto, produitId);
        return new ResponseEntity<>(new ApiResponse(true,"Produit modifié"),HttpStatus.OK);
    }
}
