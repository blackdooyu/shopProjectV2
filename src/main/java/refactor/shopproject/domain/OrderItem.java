package refactor.shopproject.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import refactor.shopproject.domain.member.Member;
import refactor.shopproject.domain.order.Order;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderItem extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    private int orderQuantity;

    private int totalPrice;

    // 장바구니 기능을 위한 연관관계
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_email")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Enumerated(EnumType.STRING)
    private OrderItemStatus orderItemStatus;

    //주문 아이템 생성
    public static OrderItem createOrderItem(Member member, Item item, int orderQuantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.orderQuantity = orderQuantity;
        orderItem.totalPrice = item.getTotalPrice(orderQuantity);
        orderItem.orderItemStatus = OrderItemStatus.SHOPPING_BASKET;
        orderItem.creteInsertDependency(member, item);
        return orderItem;
    }


    // 주문 아이템 생성시 연관관계 주입
    private void creteInsertDependency(Member member, Item item) {
        this.member = member;
        this.item = item;
    }

    // 실질적으로 주문이 됐을때의 로직
    public void orderComplete(Order order) {
        this.order = order;
        this.orderItemStatus = OrderItemStatus.ORDER;
        this.item.sale(this.orderQuantity);
    }
}
