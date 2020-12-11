package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data

    public class Smartphone extends Product {
        private String generator;

        public Smartphone() {
            super();
        }

        public Smartphone(int id, String name, int price, String generator) {
            super(id, name, price);
            this.generator = generator;
        }


}
