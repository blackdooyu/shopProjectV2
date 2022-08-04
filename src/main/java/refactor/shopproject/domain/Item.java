package refactor.shopproject.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Item extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int quantity;

    private int salesQuantity;

    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.salesQuantity = 0;
    }

    // 상품 수량 변경
    public void changeQuantity(int quantity) {
        this.quantity = quantity;
    }

    //판매시 수량 변경
    public void sale(int quantity) {
        if (this.quantity < quantity) {

        }
        this.quantity -= quantity;
        this.salesQuantity += quantity;
    }

    // 주문 취소
    public void cancel() {
        this.quantity += salesQuantity;
        this.salesQuantity = 0;
    }

    //가격 메서드
    public int getTotalPrice(int quantity) {
        return this.price * quantity;
    }

}
