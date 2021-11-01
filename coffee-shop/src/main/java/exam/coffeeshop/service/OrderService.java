package exam.coffeeshop.service;

import exam.coffeeshop.model.service.OrderServiceModel;
import exam.coffeeshop.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {

    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersOrderByPriceDesc();

    void readyOrder(Long id);
}
