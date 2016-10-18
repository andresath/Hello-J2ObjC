package com.pets.core.petstore.domain.models;

/**
 * Order Confirmation
 * An Order Confirmation View Model/App Model
 */
public class OrderConfirmationModel {
    private Long orderId = null;
    private Long orderQuantity = null;
    private String orderStatus = null;
    private String orderShipDate = null;
    private String petName = null;
    private String petId = null;
    private PetModel petModel = null;

    public PetModel getPetModel() {
        return petModel;
    }

    public OrderConfirmationModel setPetModel(PetModel petModel) {
        this.petModel = petModel;
        return this;
    }

    public Long getOrderId() {
        return orderId;
    }

    public OrderConfirmationModel setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public Long getOrderQuantity() {
        return orderQuantity;
    }

    public OrderConfirmationModel setOrderQuantity(Long orderQuantity) {
        this.orderQuantity = orderQuantity;
        return this;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public OrderConfirmationModel setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public String getOrderShipDate() {
        return orderShipDate;
    }

    public OrderConfirmationModel setOrderShipDate(String orderShipDate) {
        this.orderShipDate = orderShipDate;
        return this;
    }
}

