package com.seuprojeto.marketplace.application.dto;

import java.util.List;

public class CartRequest {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public static class Item {
        public String name;
        public double price;
        public int quantity;
    }
}