package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// o también se puede usar @Component
@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategory(int idCategory) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategory);
    }

    public Optional<List<Producto>> getScarceProducts(int quantity) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
    }

    public Optional<Producto> getProduct(int productId) {
        return productoCrudRepository.findById(productId);
    }

    public Producto save(Producto product) {
        return productoCrudRepository.save(product);
    }

    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
