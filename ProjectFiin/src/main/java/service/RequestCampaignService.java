package service;

public interface RequestCampaignService {
	
	boolean requestCampaign(Integer Influencer,Integer campaignNum)throws Exception;
	
	void acceptCampaign(Integer requestNum) throws Exception;
}
