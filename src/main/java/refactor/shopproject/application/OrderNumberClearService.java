package refactor.shopproject.application;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class OrderNumberClearService {

    public int orderNumber = 0;

    @Scheduled(cron = "0 0 0 * *")
    public void orderNumberClear() {
        this.orderNumber = 0;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }
}
