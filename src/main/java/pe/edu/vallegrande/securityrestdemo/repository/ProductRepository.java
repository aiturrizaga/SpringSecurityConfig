package pe.edu.vallegrande.securityrestdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.securityrestdemo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
