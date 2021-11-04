package MELT.TestDomainItem.controller;

import MELT.TestDomainItem.domain.Item;
import MELT.TestDomainItem.domain.Message;
import MELT.TestDomainItem.service.ItemService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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
    @ApiIgnore
    public String test() {
        return "test_success";
    }

    /**
     * ID로 상품 정보를 조회한다.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value ="상품 조회", notes = "상품 ID로 상품 정보를 조회한다.")
    @ApiImplicitParam(name = "id", value = "상품 ID")
    public ResponseEntity<Message> findItem(@PathVariable Long id) {
        log.debug("ItemController.findItem()");

        Item findItem = itemService.findItem(id);
        // 조회된 상품이 없을 경우 Bad Request 출력
        if (findItem == null) {
            return new ResponseEntity<>(
                    new Message("403 Bad Request", "요청하신 상품이 존재하지 않습니다.", null)
                    ,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                new Message("200 OK", "상품을 성공적으로 조회하였습니다.", findItem), HttpStatus.OK);
    }

    /**
     * ID로 상품 재고를 변경한다.
     * @param id : 상품 ID
     * @param stock : 상품 재고
     * @return
     */
    @PutMapping("/{id}/{stock}")
    @ApiOperation(value = "상품 재고 변경", notes = "상품 ID에 해당하는 상품의 재고를 변경한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "상품 ID"),
            @ApiImplicitParam(name = "stock", value = "상품 재고")})

    public ResponseEntity changeStock(@PathVariable Long id, @PathVariable int stock) {
        log.debug("ItemController.changeStock() : id: {}, stock: {}", id, stock);
        itemService.changeStock(id, stock);
        return new ResponseEntity("success", HttpStatus.OK);
    }
}
