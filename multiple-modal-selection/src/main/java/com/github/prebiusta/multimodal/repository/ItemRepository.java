package com.github.prebiusta.multimodal.repository;

import com.github.prebiusta.multimodal.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> getItemByPriceGreaterThan(double price);
}
