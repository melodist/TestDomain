package MELT.TestDomain.web.controller;

import MELT.TestDomain.domain.Item;
import MELT.TestDomain.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by melodist
 * User: MELT
 * Date: 2021-09-21 021
 * Time: 오후 5:07
 *
 * Test Controller
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final ItemService itemService;

    @GetMapping("/test")
    public String test() {
        return "test_success";
    }

    @PutMapping("/decreaseStock/{id}/{count}")
    public Item decreaseStock(@PathVariable Long id, @PathVariable int count) {
        return itemService.decreaseStock(id, count);
    }
}
