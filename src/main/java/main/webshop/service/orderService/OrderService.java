package main.webshop.service.orderService;

import main.webshop.Dto.Requests.OrderRequest;
import main.webshop.Dto.model.BucketModel;
import main.webshop.Dto.model.OrderModel;
import main.webshop.Dto.model.PersonModel;

import java.util.List;

public interface OrderService {

    public void CreateOrder(OrderRequest orderRequest, PersonModel owner);

    public List<OrderModel> getAllOrders();


}
