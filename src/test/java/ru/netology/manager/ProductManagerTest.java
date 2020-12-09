package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book first = new Book(1, "Name1", 10, "Author1");
    Book second = new Book(2, "Name2", 20, "Author2");
    Book third = new Book(3, "Name3", 30, "Author3");
    Smartphone fourth = new Smartphone(4, "NameS1", 100, "Generator1");
    Smartphone fifth = new Smartphone(5, "NameS2", 200, "Generator2");
    Smartphone sixth = new Smartphone(6, "NameS3", 300, "Generator3");


    @Test
    public void shouldSearchByBookAuthor() {
        manager.add(first);
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searcyBy("Author1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmarthoneGenerator() {
        manager.add(sixth);
        Product[] expected = new Product[]{sixth};
        Product[] actual = manager.searcyBy("Generator3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        manager.add(second);
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searcyBy("Name2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmarthoneName() {
        manager.add(fourth);
        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searcyBy("NameS1");
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchBySomeBookAuthor () {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searcyBy("Author2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySomeBookName () {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searcyBy("Name3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNotBook() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searcyBy("Name3");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBySomeSmarthoneGenerator () {
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] expected = new Product[]{sixth};
        Product[] actual = manager.searcyBy("Generator3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySomeSmarthoneName () {
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searcyBy("NameS1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNotSmarthone() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searcyBy("NameS3");
        assertArrayEquals(expected, actual);
    }
}