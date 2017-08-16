package services;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import dao.DaoServicesTrack;
import decorator.Price;
import tracks.ServicesTrack;

public class Towel extends Price{
	private Price price;
	private ServicesTrack track;
	private DaoServicesTrack dao;
	
	public Towel() throws SQLException{
		track = new ServicesTrack();
		dao = new DaoServicesTrack();
	}
	
	public Towel(Price price) {
		this.price = price;
	}
	
	@Override
	public BigDecimal getPrice() {
		return price.getPrice().add(new BigDecimal(5));
	}

	@Override
	public String getDescription() {
		return price.getDescription() + "Рушник: " + 5 + " гривень.\n";
	}

	@Override
	public void setPrice(Date startDate) {
	}

	@Override
	public void updateTrack(int id) {
		dao.updateServicesTrack(track, id);
	}
	
}
