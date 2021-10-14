package com.backend.ecommerce.service;

import com.backend.ecommerce.dto.ProduitDto;
import com.backend.ecommerce.model.Category;
import com.backend.ecommerce.model.Produit;
import com.backend.ecommerce.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    public void createProduit(ProduitDto produitDto, Category category){
        Produit produit = new Produit();
        produit.setDescription(produitDto.getDescription());
        produit.setPrix(produitDto.getPrix());
        produit.setImageUrl(produitDto.getImageUrl());
        produit.setNom(produitDto.getNom());
        produit.setCreated_at(produitDto.getCreated_at());
        produit.setCategory(category);

        produitRepository.save(produit);
    }
    public ProduitDto getProduitDto(Produit produit){
        ProduitDto produitDto = new ProduitDto();
        produitDto.setDescription(produit.getDescription());
        produitDto.setPrix(produit.getPrix());
        produitDto.setImageUrl(produit.getImageUrl());
        produitDto.setNom(produit.getNom());
        produitDto.setCreated_at(produit.getCreated_at());
        produitDto.setCategoryId(produit.getCategory().getId());
        produitDto.setId(produit.getId());
        return produitDto;
    }

    public List<ProduitDto> getAllProduits(){
        List<Produit> allProduits = produitRepository.findAll();

        List<ProduitDto> produitDtos = new ArrayList<>();
        for(Produit produit: allProduits){
            produitDtos.add(getProduitDto(produit));
        }
        return produitDtos;
    }

    public void updateProduit(ProduitDto produitDto, Integer produitId) throws Exception {
        Optional<Produit> optionalProduit = produitRepository.findById(produitId);
        // throw an exception if product does exits
        if(!optionalProduit.isPresent()){
            throw new Exception("Ce produit n'existe pas ");
        }

        Produit produit = optionalProduit.get();

        produit.setDescription(produitDto.getDescription());
        produit.setPrix(produitDto.getPrix());
        produit.setImageUrl(produitDto.getImageUrl());
        produit.setNom(produitDto.getNom());
        produit.setCreated_at(produitDto.getCreated_at());

        produitRepository.save(produit);
    }
}
