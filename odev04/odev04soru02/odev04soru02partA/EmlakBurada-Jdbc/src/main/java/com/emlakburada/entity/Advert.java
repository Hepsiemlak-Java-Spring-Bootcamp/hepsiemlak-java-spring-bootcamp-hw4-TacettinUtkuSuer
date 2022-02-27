package com.emlakburada.entity;

public class Advert {

	public int id;
	public String title;
	public String address;
	public String photo;

	public Advert() {

	}

	public Advert(String title, String address, String photo) {
		this.title = title;
		this.address = address;
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Advert [id=" + id + ", baslık=" + title + ", adres=" + address + ", Fotoğraf=" + photo + "]";
	}

}
