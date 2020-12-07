package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

public class ProductRepository {
    private Product[] items  = {
        new Book(1, "Name1", 10, "Author1"),
            new Book(2, "Name2", 20, "Author2"),
            new Book(3, "Name3", 30, "Author3"),
            new Smartphone(4, "NameS1", 100, "Generator1"),
            new Smartphone(5, "NameS2", 200, "Generator2"),
            new Smartphone(6, "NameS3", 300, "Generator3")
    };


    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public Product[] getItems() {
        return items;
    }

    public void setItems(Product[] items) {
        this.items = items;
    }
}
