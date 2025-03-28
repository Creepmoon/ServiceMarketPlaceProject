package main.webshop.service.orderService;

import lombok.RequiredArgsConstructor;
import main.webshop.Dto.Requests.OrderRequest;
import main.webshop.Dto.model.OrderModel;
import main.webshop.Dto.model.PersonModel;
import main.webshop.dao.BucketDao;
import main.webshop.dao.OrderDao;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private BucketDao bucketDao;

    private OrderDao orderDao;



    @Override
    public void CreateOrder(OrderRequest orderRequest, PersonModel owner) {
        OrderModel orderModel = OrderModel.builder()
                .bucketModel(bucketDao.GetUserBucket(owner))
                .date(new Date())
                .message(orderRequest.getMessage())
                .address(orderRequest.getAddres())
                .owner(owner)
                .finish(false)
                .build();
        orderDao.AddNewOrder(orderModel);
    }

    @Override
    public List<OrderModel> getAllOrders() {
        return orderDao.GetAllOrders();
    }

    public void finishOrder(OrderModel orderModel){
       orderDao.finishOrder(orderModel);
    }

}
