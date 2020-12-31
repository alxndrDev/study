package io.alxndr.jpashop.service;

import io.alxndr.jpashop.domain.item.Book;
import io.alxndr.jpashop.domain.item.Item;
import io.alxndr.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional  // overriding
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    // update 변경감지 사용
    @Transactional
    public void updateItem(Long itemId, Book param) {
        Book findBook = (Book) itemRepository.findOne(itemId);
        findBook.setPrice(param.getPrice());
        findBook.setName(param.getName());
        findBook.setStockQuantity(param.getStockQuantity());
    }


    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}
