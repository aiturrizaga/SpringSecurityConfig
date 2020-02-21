package pe.edu.vallegrande.securityrestdemo.error;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Product id not found: " + id);
    }
}
