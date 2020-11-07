package com.github.prebiusta.multimodal.service;

import com.github.prebiusta.multimodal.model.Item;
import com.github.prebiusta.multimodal.repository.ItemRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final ItemRepository itemRepository;

    public DataLoader(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void run(ApplicationArguments args) {
        initApp();
    }

    private void initApp() {
            itemRepository.save(new Item("iPhone 12", 877.99, "New iPhone 12 which as usually got overpriced"));
            itemRepository.save(new Item("iPhone 12 mini", 755.99, "New iPhone 12 mini, finally some small device"));
            itemRepository.save(new Item("iPhone 7", 330.12, "No more available, too old"));
    }
}
