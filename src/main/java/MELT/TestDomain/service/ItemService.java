package MELT.TestDomain.service;

import MELT.TestDomain.domain.Item;
import MELT.TestDomain.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by melodist
 * User: MELT
 * Date: 2021-10-01 001
 * Time: 오후 10:49
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public Item decreaseStock(Long id, int count) {
        Item findItem = itemRepository.findOne(id);
        findItem.decreaseStock(count);
        itemRepository.save(findItem);
        return findItem;
    }
}
