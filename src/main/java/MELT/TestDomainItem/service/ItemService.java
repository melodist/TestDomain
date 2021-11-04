package MELT.TestDomainItem.service;

import MELT.TestDomainItem.domain.Item;
import MELT.TestDomainItem.repository.ItemRepository;
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

    /**
     * ID로 상품 정보를 조회한다.
     * @param id
     * @return
     */
    public Item findItem(Long id) {
        return itemRepository.findOne(id);
    }

    public void changeStock(Long id, int stock) {
        Item findItem = itemRepository.findOne(id);
        findItem.changeStock(stock);
    }
}
