package MELT.TestDomain.repository;

import MELT.TestDomain.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Item Repository
 * Created by melodist
 * User: MELT
 * Date: 2021-10-01 001
 * Time: 오후 10:44
 */
@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    /**
     * Item 저장
     * @param item
     */
    public void save(Item item) {
        em.persist(item);
    }

}
