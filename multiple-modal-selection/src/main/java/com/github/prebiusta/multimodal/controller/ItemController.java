package com.github.prebiusta.multimodal.controller;

import com.github.prebiusta.multimodal.model.Item;
import com.github.prebiusta.multimodal.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {
    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public String index() {
        return "web/index";
    }

    @GetMapping("/items")
    public String allItems(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        model.addAttribute("editItem", new Item());
        return "web/items";
    }

    @PostMapping("/item/update")
    public String updateItem(@ModelAttribute("item") Item item) {
        itemRepository.save(item);
        return "redirect:/items";
    }

    @GetMapping("/item/{price}")
    public String test(@PathVariable Double price, Model model) {
        model.addAttribute("items", itemRepository.getItemByPriceGreaterThan(price));
        return "web/items";
    }

    @GetMapping("/basic")
    public String basic() {
        return "web/basic";
    }
}
