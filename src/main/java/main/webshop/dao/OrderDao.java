package main.webshop.dao;

import main.webshop.Domain.Bucket;
import main.webshop.Domain.Order;
import main.webshop.Domain.Person;
import main.webshop.Dto.model.OrderModel;
import main.webshop.Dto.model.PersonModel;
import main.webshop.Repositories.BucketRepository;
import main.webshop.Repositories.OrderRepository;
import main.webshop.Repositories.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class OrderDao {
    OrderRepository orderRepository;
    BucketRepository bucketRepository;
    PersonRepository personRepository;

    public void AddNewOrder(OrderModel orderModel){

        Order order = Order.builder()
                .owner(personRepository.findByEmail(orderModel.getOwner().getEmail()))
                .bucket(bucketRepository.findFirstByOwnerOrderByIdDesc(personRepository
                        .findByEmail(orderModel.getOwner()
                                .getEmail())))
                .adress(orderModel.getAddress())
                .message(orderModel.getMessage())
                .dateOfCreation(orderModel.getDate())
                .finish(orderModel.isFinish())
                .build();
        orderRepository.save(order);
    }


    public List<OrderModel> GetAllOrders(){
        Stream<Order> orderStream = Optional.ofNullable(orderRepository.findAll())
                .map(List::stream)
                .orElse(Stream.empty());
        return orderStream
                .filter(Objects::nonNull)
                .map(OrderModel::fromEntity)
                .toList();
    }


    public List<OrderModel> GetAllUserOrders(PersonModel personModel){
        Person person = personRepository.findByEmail(personModel.getEmail());

        Stream<Order> orderStream = orderRepository.findAllByOwner(person).stream();

        return orderStream.filter(Objects::nonNull)
                .map(OrderModel::fromEntity)
                .toList();
    }

    public void finishOrder(OrderModel orderModel){
     Order order = Order.builder()
                .owner(personRepository.findByEmail(orderModel.getOwner().getEmail()))
                .bucket(bucketRepository.findFirstByOwnerOrderByIdDesc(personRepository
                        .findByEmail(orderModel.getOwner()
                                .getEmail())))
                .adress(orderModel.getAddress())
                .message(orderModel.getMessage())
                .dateOfCreation(orderModel.getDate())
                .finish(false)
                .build();
     orderRepository.delete(order);
     order.setFinish(true);
     orderRepository.save(order);
    }




}
