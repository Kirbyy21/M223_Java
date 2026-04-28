package ch.samt.gardenwarehouse.service;

import ch.samt.gardenwarehouse.data.ItemRepository;
import ch.samt.gardenwarehouse.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item getByCode(String code) {
        List<Item> items = itemRepository.findByCode(code);
        if (items.isEmpty()) {
            return null;
        }
        return items.getFirst();
    }

    public Item sell(String code) {
        Item item = getByCode(code);
        if (item != null && item.getItemCount() > 0) {
            item.setItemCount(item.getItemCount() - 1);
            return itemRepository.save(item);
        }
        return null;
    }

    public Item add(String code, int number) {
        Item item = getByCode(code);
        if (item != null) {
            item.setItemCount(item.getItemCount() + number);
            return itemRepository.save(item);
        }
        return null;
    }

    public Item insert(Item item) {
        if (!itemRepository.findByCode(item.getCode()).isEmpty()) {
            return null;
        }
        return itemRepository.save(item);
    }
}
