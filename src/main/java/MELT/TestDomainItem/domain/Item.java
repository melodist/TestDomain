package MELT.TestDomainItem.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by melodist
 * User: MELT
 * Date: 2021-10-01 001
 * Time: 오후 9:52
 */
@Getter
@Entity
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
    private int stock;

    /******** 생성 메서드 ***********/

    /*******연관관계 메서드 **********/
    /**
     * 상품 재고를 변경한다.
     * @param stock
     */
    public void changeStock(int stock) {
        this.stock = stock;
    }
}
