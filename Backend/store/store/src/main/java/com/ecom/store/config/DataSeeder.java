package com.ecom.store.config;

import com.ecom.store.model.Category;
import com.ecom.store.model.Product;
import com.ecom.store.repository.CategoryRepository;
import com.ecom.store.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Remove existing data and reset auto-increment
        productRepository.deleteAll();
        categoryRepository.deleteAll();
        entityManager.createNativeQuery("ALTER TABLE product AUTO_INCREMENT = 1").executeUpdate();
        entityManager.createNativeQuery("ALTER TABLE category AUTO_INCREMENT = 1").executeUpdate();

        // Create sample categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category homeAppliances = new Category();
        homeAppliances.setName("Home Appliances");

        // Save categories first
        categoryRepository.saveAll(Arrays.asList(electronics, clothing, homeAppliances));

        // Create sample products
        Product product1 = new Product();
        product1.setName("Smartphone");
        product1.setDescription("Latest model smartphone with high-end features.");
        product1.setImageUrl("https://example.com/smartphone.jpg");
        product1.setPrice(699.99);
        product1.setCategory(electronics);

        Product product2 = new Product();
        product2.setName("Laptop");
        product2.setDescription("Powerful laptop for professionals.");
        product2.setImageUrl("https://example.com/laptop.jpg");
        product2.setPrice(1299.99);
        product2.setCategory(electronics);

        Product product3 = new Product();
        product3.setName("T-Shirt");
        product3.setDescription("Comfortable cotton t-shirt.");
        product3.setImageUrl("https://example.com/tshirt.jpg");
        product3.setPrice(19.99);
        product3.setCategory(clothing);

        Product product4 = new Product();
        product4.setName("Jeans");
        product4.setDescription("Classic denim jeans.");
        product4.setImageUrl("https://example.com/jeans.jpg");
        product4.setPrice(49.99);
        product4.setCategory(clothing);

        Product product5 = new Product();
        product5.setName("Microwave Oven");
        product5.setDescription("Efficient and easy-to-use microwave oven.");
        product5.setImageUrl("https://example.com/microwave.jpg");
        product5.setPrice(199.99);
        product5.setCategory(homeAppliances);

        // Save products
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

    }
}
