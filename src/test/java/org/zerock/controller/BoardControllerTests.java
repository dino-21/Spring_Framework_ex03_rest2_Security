package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
@WebAppConfiguration // 웹 애플리케이션 환경 설정
public class BoardControllerTests {
	@Autowired
	private WebApplicationContext ctx; // 웹 애플리케이션 컨텍스트 주입

	private MockMvc mockMvc; // MockMvc 객체

	// @Before 어노테이션을 사용하여 MockMvc 객체를 초기화
	@Before
	public void setup() {
		// MockMvc 객체를 설정
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception {
		// "/board/list" URL을 호출하여 컨트롤러의 동작을 테스트
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn() // 요청 결과를 반환
				.getModelAndView() // 모델과 뷰를 반환
				.getModelMap()); // 모델맵을 반환하여 로그 출력
	}

	@Test
	public void testResister() throws Exception {
		// // MockMvc를 사용하여 POST 요청을 시뮬레이트
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				// 요청 파라미터를 설정
				.param("title", "title.....1").param("content", "content.....1").param("writer", "writer.....1"))
				// 요청을 실행하고 결과 리턴
				.andReturn()
				// 객체 반환,
				.getModelAndView().getViewName();

		log.info(resultPage);
	}

	@Test
	public void testGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "4")).andReturn()
				// 객체 반환, 모델 데이터를 추출
				.getModelAndView().getModelMap());
	}

	@Test
	public void testModify() throws Exception {

		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/modify").param("bno", "3").param("title", "수정된 테스트 새글 제목1")
						.param("content", "수정된 테스트 새글 내용2").param("writer", "user03"))
				.andReturn().getModelAndView().getViewName();

		log.info(resultPage);

	}

	@Test
	public void testRemove() throws Exception {
		// 삭제전 DB의 게시물 번호 확인할 것
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "1")).andReturn()
				.getModelAndView().getViewName();
		log.info(resultPage);
	}
	
	
	@Test
    public void testListPaging() throws Exception {
        log.info(mockMvc.perform(
                MockMvcRequestBuilders.get("/board/list")
                        .param("pageNum", "1")
                        .param("amount", "5"))
                .andReturn().getModelAndView().getModelMap());
    }
	

}
