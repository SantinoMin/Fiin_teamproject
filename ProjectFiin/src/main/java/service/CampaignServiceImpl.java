package service;


import java.util.List;

import dao.CampaignDao;
import dao.CampaignDaoImpl;
import dto.Campaign;
import util.PageInfo;

public class CampaignServiceImpl implements CampaignService {

	  private CampaignDao campaignDao;
	  public CampaignServiceImpl() {
	    campaignDao = new CampaignDaoImpl();
	  }

	  @Override
	  public Campaign register(Campaign cam) throws Exception {
		  campaignDao.registerCampaign(cam);
		  return cam;
	  }
	  
	  @Override
	  public List<Campaign> campaignList(List<String> channel, Integer categoryId, PageInfo pageinfo) throws Exception {
		  Integer campaignCnt = campaignDao.selectCampaignCount(channel,categoryId);
		  Integer allPage = (int)Math.ceil((double)campaignCnt/8);
		  Integer startPage =(pageinfo.getCurPage()-1)/8*8+1;
			
		  Integer endPage = startPage+8-1;
		  if (endPage>allPage) endPage = allPage;
		  pageinfo.setAllPage(allPage);
	      pageinfo.setStartPage(startPage);
		  pageinfo.setEndPage(endPage);
			
		  Integer row = (pageinfo.getCurPage()-1)*8+1;
		  System.out.println(campaignCnt);

		  
		  return campaignDao.selectCampaignList(row,channel,categoryId);
		}

	@Override
	public List<Campaign> campaignListForMain() throws Exception {
		return campaignDao.selectCampaignListForMain();
	}

	@Override
	public Campaign detail(Integer campaignNum) throws Exception {
		return campaignDao.selectCampaign(campaignNum);
	}
	@Override
	public List<Campaign> campaignListForAdvertiser(Integer advertiserNum) throws Exception {
		return campaignDao.selectCampaignListForAdvertiser(advertiserNum);
	}

	/*
	 * @Override public List<Campaign> getCampaignList(List<String> channels,
	 * Integer category, Integer page) throws Exception {
	 * if(page>getCampaignMaxPage(channels, category)) return null; int row
	 * =(page-1)*8;
	 * 
	 * return campaignDao.selectCampaignList(row,channels,category); }
	 * 
	 * @Override public Integer getCampaignMaxPage(List<String> channels, Integer
	 * category) throws Exception { // TODO Auto-generated method stub return null;
	 * }
	 */

}
