package service;

import java.util.List;

import dto.Influencer;
import util.PageInfo;

public interface InfluencerService {
	void join(Influencer influencer) throws Exception;
	Influencer login(String userEmail, String password) throws Exception;
	boolean checkDoubleEmail(String userEmail) throws Exception;
	Influencer influencerRegister(Influencer influencer) throws Exception;
	Influencer influencerDetail(Integer influencerNum) throws Exception;
	Integer checkBookmarkCampaign(Integer InfluencerNum, Integer CampaignNum) throws Exception;
	boolean toggleBookmarkCampaign(Integer InfluencerNum, Integer CampaignNum) throws Exception;
	List<Influencer> influencerListForMain() throws Exception;
	String influencerFindEmail(String name, String mobileNumber) throws Exception;
	List<Influencer> influencerList(String channel, Integer categoryId, PageInfo pageInfo)throws Exception;
	String influencerFindPassword(String userEmail) throws Exception;
}
