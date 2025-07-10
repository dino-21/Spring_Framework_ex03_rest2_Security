package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService{

	private ReplyMapper mapper;
	
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int register(ReplyVO vo) {
	    log.info("register... " + vo);
	    // 댓글 등록 시, 해당 게시물의 댓글 수를 1 증가
	    boardMapper.updateReplyCnt(vo.getBno(), 1);
		return mapper.insert(vo);  //댓글수 증가후 댓글등록
	      // 만약 댓글을 추가하다가 예외상황이 생기면 댓글수 +1도 롤백 됨(tx)
		
	}

	@Override
	public ReplyVO get(Long rno) {
		 log.info("get... " + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		 log.info("modify... " +vo);
		return mapper.update(vo);
	}

	@Transactional
	@Override
	public int remove(Long rno) {
		log.info("remove..." + rno);
		ReplyVO vo = mapper.read(rno);
		boardMapper.updateReplyCnt(vo.getBno(),-1);
		return mapper.delete(rno);
	}

	
	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}



}
