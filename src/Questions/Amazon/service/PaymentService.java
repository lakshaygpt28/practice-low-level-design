package Questions.Amazon.service;

import Questions.Amazon.model.Order;
import Questions.Amazon.model.OrderStatus;

import java.math.BigDecimal;

public class PaymentService {

    public void processPayment(Order order, double transferredAmount) {
        // process payment
        if (order.getCost().compareTo(BigDecimal.valueOf(transferredAmount)) <= 0) {
            System.out.println("Payment processed successfully for Order id: " + order.getId());
            order.setStatus(OrderStatus.PROCESSING);
        }
    }
}
