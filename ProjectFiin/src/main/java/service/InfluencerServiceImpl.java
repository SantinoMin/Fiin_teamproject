package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.InfluencerDao;
import dao.InfluencerDaoImpl;
import dto.Influencer;
import util.PageInfo;

public class InfluencerServiceImpl implements InfluencerService {

	private InfluencerDao influencerDao;

	public InfluencerServiceImpl() {
		influencerDao = new InfluencerDaoImpl();
	}

	@Override
	public Influencer register(Influencer inf) throws Exception {

//    Member smember = memberDao.selectMember(member.getId());
//    if(smember!=null) throw new Exception("아이디 중복 오류");
//    memberDao.insertMember(member);

//    Influencer inff = influencerDao.registerInfluencer(inf.);

		influencerDao.registerInfluencer(inf);
		// dao에 데이터를 넣으면 끝 맞는지?
		return inf;

	}

	@Override
	public void join(Influencer influencer) throws Exception {
		Influencer sinfluencer = influencerDao.selectInfluencer(influencer.getInfluencerNum());
		if (sinfluencer != null)
			throw new Exception("아이디 중복 오류");
		influencerDao.insertInfluencer(influencer);
	}

	@Override
	public void login(Integer influencerNum, String password) throws Exception {
		Influencer influencer = influencerDao.selectInfluencer(influencerNum);
		if (influencer == null)
			throw new Exception("로그인 아이디 오류");
		if (!password.equals(influencer.getPassword()))
			throw new Exception("비밀번호 오류");

	}

	@Override
	public boolean checkDoubleEmail(String userEmail) throws Exception {
		Influencer influencer = influencerDao.selectInfluencerByEmail(userEmail);
		if (influencer == null)
			return false;
		return true;
	}

	@Override
	public List<Influencer> influencerList(PageInfo pageInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerInfluencer(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Influencer influencerDetail(Integer influencerNum) throws Exception {
		Influencer influencer = influencerDao.selectInfluencer(influencerNum);
		if(influencer == null) throw new Exception("인플루언서를 찾지 못했습니다.");
		return influencer;
	}

	@Override
	public Integer checkBookmark(Integer advertiserNum, Integer influencerNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean toggleBookmark(Integer advertiserNum, Integer influencerNum) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
