package MELT.TestDomain.web.controller;

import MELT.TestDomain.domain.Item;
import MELT.TestDomain.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by melodist
 * User: MELT
 * Date: 2021-09-21 021
 * Time: 오후 5:07
 *
 * Test Controller
 */
@Slf4j
@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/test")
    public String test() {
        return "test_success";
    }

    /**
     * ID로 상품 정보를 조회한다.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Item> findItem(@PathVariable Long id) {
        log.debug("ItemController.findItem()");

        Item findItem = itemService.findItem(id);
        // 조회된 상품이 없을 경우 noContent 출력
        if (findItem == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(findItem);
    }

    /**
     * ID로 상품 재고를 변경한다.
     * @param id : 상품 ID
     * @param stock : 상품 재고
     * @return
     */
    @PutMapping("/{id}/{stock}")
    public ResponseEntity changeStock(@PathVariable Long id, @PathVariable int stock) {
        log.debug("ItemController.changeStock() : id: {}, stock: {}", id, stock);
        itemService.changeStock(id, stock);
        return new ResponseEntity("success", HttpStatus.OK);
    }
}
