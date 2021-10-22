package exam.coffeeshop.service.impl;

import exam.coffeeshop.current.CurrentUser;
import exam.coffeeshop.model.entity.OrderEntity;
import exam.coffeeshop.model.service.OrderServiceModel;
import exam.coffeeshop.model.view.OrderViewModel;
import exam.coffeeshop.repository.OrderRepository;
import exam.coffeeshop.service.CategoryService;
import exam.coffeeshop.service.OrderService;
import exam.coffeeshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {


        OrderEntity order = modelMapper.map(orderServiceModel, OrderEntity.class);
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);


    }

    @Override
    public List<OrderViewModel> findAllOrdersOrderByPriceDesc() {

        return orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(orderEntity -> modelMapper.map(orderEntity, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
