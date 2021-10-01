package MELT.TestDomain.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by melodist
 * User: MELT
 * Date: 2021-10-01 001
 * Time: 오후 9:52
 */
@Entity
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
    private int stock;

    /******** 생성 메서드 ***********/

    /*******연관관계 메서드 **********/
    public void decreaseStock(int count) {
        this.stock -= count;
    }
}
