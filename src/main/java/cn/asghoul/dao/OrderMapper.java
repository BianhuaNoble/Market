package cn.asghoul.dao;

import cn.asghoul.pojo.Order;
import cn.asghoul.pojo.dto.OrderPay;
import cn.asghoul.pojo.dto.OrderPayItems;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface OrderMapper {

    //点击立即购买/结算生成订单
    public void addorder(Order order);
    //添加订单详情
    public void addOrderItem(@Param("orderId") BigInteger orderId,@Param("itemId") BigInteger itemId);

    //删除订单
    public void delorder(@Param("orderId")BigInteger orderId);
    //删除订单商品表的的东西
    public void deleteOrderItem(@Param("orderId") BigInteger orderId);
    //查询未支付订单的Id
    public BigInteger notPayId();

    //查询订单
    public OrderPay selectOrders(@Param("orderId") BigInteger orderId);
    //查询订单里所有商品
    public List<OrderPayItems> allItems(@Param("orderId") BigInteger orderId);
    //查询订单Id对应买家Id
    public BigInteger getClientId(@Param("orderId") BigInteger orderId);

    //根据商品Id查询购物车Id
    public BigInteger returnCollectId(@Param("itemId") BigInteger itemId);
}
