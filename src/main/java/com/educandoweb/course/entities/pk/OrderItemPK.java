package com.educandoweb.course.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;

@Embeddable
public class OrderItemPK implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product Product;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Product == null) ? 0 : Product.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		if (Product == null) {
			if (other.Product != null)
				return false;
		} else if (!Product.equals(other.Product))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}
	
}
