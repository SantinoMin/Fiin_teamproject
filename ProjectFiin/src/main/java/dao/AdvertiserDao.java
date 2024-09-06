package dao;

import dto.Advertiser;

public interface AdvertiserDao {
	void insertAdvertiser(Advertiser advertiser) throws Exception;
	Advertiser selectAdvertiser(Integer advertiserNum) throws Exception;
	void updateAdvertiser(Advertiser advertiser) throws Exception;
}