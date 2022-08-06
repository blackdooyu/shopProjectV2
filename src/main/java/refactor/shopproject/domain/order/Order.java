package refactor.shopproject.domain.order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import refactor.shopproject.domain.BaseTime;
import refactor.shopproject.domain.OrderItem;
import refactor.shopproject.domain.member.Member;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseTime {

    @Id
    @Column(name = "order_id")
    private String orderId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_email")
    private Member member;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Embedded
    private OrderAddress orderAddress;

    private int orderTotalPrice;

    //주문 생성
    public static Order createOrder(String orderNumber, Member member, OrderAddress orderAddress, OrderItem... orderItems) {
        Order order = new Order();
        order.deliveryStatus = DeliveryStatus.READY;
        order.orderAddress = orderAddress;
        order.insertMember(member);
        order.setOrderId(orderNumber);

        for (OrderItem orderItem : orderItems) {
            orderItem.orderComplete(order);
            order.orderTotalPrice += orderItem.getTotalPrice();
        }
        return order;
    }

    public void setOrderId(String orderNumber) {
        this.orderId = LocalDate.now() + orderNumber;
    }


    private void insertMember(Member member) {
        this.member = member;
    }
}

