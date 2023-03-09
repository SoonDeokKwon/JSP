package co.dev.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.dev.common.DataSource;
import co.dev.mapper.NoticeMapper;
import co.dev.vo.NoticeVO;

public class NoticeServiceMybatis implements NoticeService{

	
	// jdbc: NoticeDAO dao;
	// mybatis: mapper;
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
	
	@Override
	public List<NoticeVO> noticeList(int page) { // 목록.
		// return mapper.noticeList();
		return mapper.noticeWithPaging(page);	}

	@Override
	public boolean addNotice(NoticeVO vo) { // 등록.
		System.out.println(vo);
		int r = mapper.insertNotice(vo);
		sqlSession.commit(); // 다른 세션에서 반영.
		return r == 1;
	}

	@Override
	public NoticeVO getNotice(int nid) {
		// TODO Auto-generated method stub
		mapper.updateCount(nid); //조회수 증가.
		return mapper.selectNotice(nid);
	}

	@Override
	public List<NoticeVO> noticeWithPaging(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCount() {
		return mapper.getTotalCount();
	}

	@Override
	public boolean noticeModify(NoticeVO vo) {
		System.out.println("vo:"+vo);
		int r = mapper.updateNotice(vo);
		return r == 1;
	}

	@Override
	public boolean noticeRemove(int nid) {
		return mapper.deleteNotice(nid);
	}

	

}
