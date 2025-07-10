package org.zerock.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	public int register(ReplyVO vo);

	public ReplyVO get(Long rno);


	public int modify(ReplyVO reply);
	
	public int remove(Long rno);


    // 특정 댓글 페이징 처리
	public List<ReplyVO> getList(Criteria cri, Long bno);

	// 게시물의 댓글을 페이지별로 나누어 반환
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
	
}
