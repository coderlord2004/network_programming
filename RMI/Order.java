package ID_Wc1rBedr;

import java.io.Serializable;

public class Order implements Serializable {
    private static final long serialVersionUID = 20241132L;

    private String id;
    private String customerCode;
    private String orderDate;
    private String shippingType;
    private String orderCode;

    public Order() {
    }

    public Order(String id, String customerCode, String orderDate, String shippingType, String orderCode) {
        this.id = id;
        this.customerCode = customerCode;
        this.orderDate = orderDate;
        this.shippingType = shippingType;
        this.orderCode = orderCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", shippingType='" + shippingType + '\'' +
                ", orderCode='" + orderCode + '\'' +
                '}';
    }
}
