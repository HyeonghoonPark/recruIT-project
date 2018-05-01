package com.recruit.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.recruit.domain.BoardVO;
import com.recruit.domain.MessageVO;
import com.recruit.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession session;
	private static String namespace = "com.recruit.mapper.UserMapper";


	@Override
	public BoardVO login(LoginDTO dto) throws Exception {

		return session.selectOne(namespace + ".login", dto);
	}

	@Override
	public BoardVO idoverlap(String id) throws Exception{
		return session.selectOne(namespace+".idoverlap", id);
	}
	
	@Override
	public void create(BoardVO vo) throws Exception {
	  session.insert(namespace + ".create", vo);
	}

	@Override
	public void Ccreate(BoardVO vo) throws Exception{
		session.insert(namespace+".Ccreate", vo);
	}
	
	// 로그인 한 사용자의 sessionKey와 sessionLimit를 업데이트 하는 기능
	// DAO와 userMapper.xml과 DAOImpl은 같이 다닌다.
	@Override
	public void keepLogin(String id, String sessionId, Date next) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next);

		session.update(namespace + ".keepLogin", paramMap);

	}

	// loginCookie에 기록된 값으로 사용자의 정보를 조회하는 기능
	@Override
	public BoardVO checkUserWithSessionKey(String value) {

		return session.selectOne(namespace + ".checkUserWithSessionKey", value);

	}
	
	@Override
	public void insertUser(BoardVO vo) throws Exception {
		session.insert(namespace +".insertUser", vo);
	}

	@Override
	public void createAuthKey(String email, String authCode) throws Exception {
		// TODO Auto-generated method stub
		BoardVO vo = new BoardVO();
		vo.setAuthCode(authCode);
		vo.setEmail(email);

		session.selectOne(namespace + ".createAuthKey", vo);
	}
	
	@Override
	public void userAuth(String email) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".userAuth", email);
	}
	
	@Override
	public BoardVO pread(LoginDTO dto) throws Exception{
		return session.selectOne(namespace+".pread", dto);
	}
	
	@Override
	public BoardVO cread(LoginDTO dto) throws Exception{
		return session.selectOne(namespace+".cread", dto);
	}
	
	@Override
	public BoardVO emailoverlap(String email) throws Exception{
		return session.selectOne(namespace+".emailoverlap", email);
	}

	@Override
	public void ppwchk(LoginDTO dto, String pw) throws Exception{
		BoardVO vo = new BoardVO();
		vo.setId(dto.getId());
		vo.setEmail(dto.getEmail());
		vo.setPname(dto.getPname());
		vo.setPw(pw);
		session.update(namespace+".ppwchk", vo);
	}
	
	@Override
	public void cpwchk(LoginDTO dto, String pw) throws Exception{
		BoardVO vo = new BoardVO();
		vo.setId(dto.getId());
		vo.setEmail(dto.getEmail());
		vo.setCname(dto.getCname());
		vo.setPw(pw);
		session.update(namespace+".cpwchk", vo);
	}
	
	@Override
	public BoardVO getPw(LoginDTO dto) throws Exception{
		return session.selectOne(namespace+".getPw", dto);
	}
	
	@Override
	public String getId(LoginDTO dto) throws Exception{
		return session.selectOne(namespace + ".getId", dto);
	}
	
	@Override
	public BoardVO userread(String id) throws Exception{
		return session.selectOne(namespace+".userRead", id);
	}
	
	@Override
	public BoardVO getppw(LoginDTO dto) throws Exception{
		return session.selectOne(namespace+".getppw", dto);
	}
	
	@Override
	public BoardVO getcpw(LoginDTO dto) throws Exception{
		return session.selectOne(namespace+".getcpw", dto);
	}
	
	@Override
	public int countURmessage(String id) throws Exception{
		return session.selectOne(namespace+".countURmessage", id);
	}
	
	@Override
	public List<MessageVO> readFivemessage(String id) throws Exception{
		return session.selectList(namespace+".readFivemessage", id);
	}
	
	@Override
	public List<MessageVO> readAllmessage(String id) throws Exception{
		return session.selectList(namespace+".readAllmessage", id);
	}
	
	@Override
	public List<MessageVO> Readmessage_paging(MessageVO msvo)throws Exception{
		return session.selectList(namespace+".Readmessage_paging", msvo);
	}//페이징
	
	@Override
	public String Maxmassagebno(MessageVO msvo)throws Exception{
		System.out.println("최소값"+msvo.getBno());
		return session.selectOne(namespace+".Maxmassagebno", msvo);
	}//페이징
	
	
	@Override
	public void CreadAPRmessage(MessageVO msvo)throws Exception{//소연 이력서 열람했다는 알림
		session.insert(namespace+".CreadAPRmessage", msvo);
	}
	
	@Override
	public void PAppliedmessage(MessageVO msvo)throws Exception{//소연 이력서 지원했다는 알림
		session.insert(namespace+".PAppliedmessage", msvo);
	}
	
	@Override
	public void Readedmessage(MessageVO msvo)throws Exception{
		session.update(namespace + ".Readedmessage", msvo);
	} //메시지 확인 서비스
	
	@Override
	public void AreadQNAmessage(MessageVO msvo)throws Exception{
		//지훈 Q&A 등록했다는 알림
		session.insert(namespace+".AreadQNAmessage", msvo);
	}
}