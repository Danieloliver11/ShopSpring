package com.oliver.shopSpring.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oliver.shopSpring.entity.enums.OrderStatus;

@Entity
@Table(name = "TB_PEDIDOS")
public class OrderEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;
	
	private Integer statusPedido;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private UserEntity cliente;
	
	
	@OneToMany(mappedBy = "idPk.ordem")//
	private Set<OrdemItem> items = new HashSet<>();
	

	public OrderEntity(Long id, Instant momento,OrderStatus statusPedido, UserEntity cliente) {
		super();
		this.id = id;
		this.momento = momento;
		this.setStatusPedido(statusPedido);
		this.cliente = cliente;
	}
	
	

	public Set<OrdemItem> getItems() {
		return items;
	}


	public OrderEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public UserEntity getCliente() {
		return cliente;
	}

	public void setCliente(UserEntity cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public OrderStatus getStatusPedido() {
		return OrderStatus.valueOf(statusPedido) ;
	}

	public void setStatusPedido(OrderStatus statusPedido) {
		this.statusPedido = statusPedido.getCode();
	}
	
	
	

}
