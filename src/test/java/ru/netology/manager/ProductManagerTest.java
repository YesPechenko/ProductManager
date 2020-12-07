package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void shouldSearchByBookAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(1, "Name1", 10, "Author1")};
        Product[] actual = manager.searcyBy("Author1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmarthoneGenerator() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(6, "NameS3", 300, "Generator3")};
        Product[] actual = manager.searcyBy("Generator3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(2, "Name2", 20, "Author2")};
        Product[] actual = manager.searcyBy("Name2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmarthoneName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone (4, "NameS1", 100, "Generator1")};
        Product[] actual = manager.searcyBy("NameS1");
        assertArrayEquals(expected, actual);
    }


}