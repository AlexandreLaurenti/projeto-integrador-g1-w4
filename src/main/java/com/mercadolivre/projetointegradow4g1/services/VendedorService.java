package com.mercadolivre.projetointegradow4g1.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mercadolivre.projetointegradow4g1.entities.Vendedor;
import com.mercadolivre.projetointegradow4g1.repositories.VendedorRepository;

@Service
public class VendedorService {

    private static VendedorRepository vendedorRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        VendedorService.vendedorRepository = vendedorRepository;
    }
  
    public void salvar(Vendedor vendedor) {
        vendedorRepository.save(vendedor);
    }

    public Vendedor buscar(Long id) {
        return vendedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vendedor não cadastrado."));
    }

    public List<Vendedor> listar() {
        return vendedorRepository.findAll();
    }
    
    public static boolean existe(Long id) {
    	return vendedorRepository.findById(id).isPresent();
    }
}