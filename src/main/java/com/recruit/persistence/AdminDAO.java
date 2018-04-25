package com.recruit.persistence;

import java.util.List;

import com.recruit.domain.AdminCriteria;
import com.recruit.domain.AdminSearchCriteria;
import com.recruit.domain.BoardVO;
import com.recruit.domain.StatisticVO;

public interface AdminDAO {

	public BoardVO read(String id) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(String id) throws Exception;

	public List<BoardVO> listAll() throws Exception;

	public List<BoardVO> listPage(int page) throws Exception;

	public List<BoardVO> listCriteria(AdminCriteria cri) throws Exception;

	public int countPaging(AdminCriteria cri) throws Exception;

	public List<BoardVO> listSearch(AdminSearchCriteria cri) throws Exception;

	public int listSearchCount(AdminSearchCriteria cri) throws Exception;

	public BoardVO aread() throws Exception;

	public void aupdate(BoardVO vo) throws Exception;
	
	public String readpw(BoardVO vo) throws Exception;
	
	public int pcount()throws Exception;
	
	public int ccount()throws Exception;
	
	public List<StatisticVO> count_recruit() throws Exception;
	
	public List<StatisticVO> jobgroup_recruit() throws Exception;
	
	public List<StatisticVO> rgb_recruit() throws Exception;
	
	public List<StatisticVO> weekPerson() throws Exception;
	
	public List<StatisticVO> weekCompany() throws Exception;
	
	public void emailauth(BoardVO vo) throws Exception;
	
	public List<StatisticVO> weekResume() throws Exception;
	
	public List<StatisticVO> jobgroup_resume() throws Exception;
	
	public List<StatisticVO> rRgb_resume() throws Exception;
	
	public int weekPcount()throws Exception;
	
	public int weekCcount()throws Exception;
	
	public int weekResumeCount()throws Exception;
	
	public int weekRecruitCount()throws Exception;
	
}