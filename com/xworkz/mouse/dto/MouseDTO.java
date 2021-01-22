package com.xworkz.mouse.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mouse_dto")
public class MouseDTO implements Serializable{

//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MOUSE_ID")
	private double mouseID;
	
	@Column(name="BRAND")
	private String brand;
	
	@Column(name="WIRELESS")
	private boolean wireless;
	
	@Column(name="PRICE")
	private double price;
	
	public MouseDTO() {
		
	}

	public MouseDTO(int mouseID, String brand, boolean wireless, double price) {
		super();
		this.mouseID = mouseID;
		this.brand = brand;
		this.wireless = wireless;
		this.price = price;
	}



	public double getMouseID() {
		return mouseID;
	}

	public void setMouseID(double d) {
		this.mouseID = d;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean isWireless() {
		return wireless;
	}

	public void setWireless(boolean wIRELESS2) {
		this.wireless = wIRELESS2;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double pRICE2) {
		this.price = pRICE2;
	}

	@Override
	public String toString() {
		return "MouseDTO [mouseID=" + mouseID + ", brand=" + brand + ", wireless=" + wireless + ", price=" + price
				+ "]";
	}
	
}
