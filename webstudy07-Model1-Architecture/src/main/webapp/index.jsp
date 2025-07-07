<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model1 Architecture</title>
</head>
<body>
<h2>Model1 Architecture</h2>
<a href="step1-jsp-db.jsp">Mdeol1 설계방식 이전의 예:총 회원수 보기</a>
<br><br>
<img alt="Model1 설계방식" src="./images/Model1-Architecture.jpg"><br>
<%--
		Model1 설계방식으로 위 예제를 리랙토링 해본다
		리팩토링 : 입출력 동일하되 내부 구조 개선을 통한 가독성과 유지보수성 향상
		index --step2-model1-memeber-count.jsp <--> MemberDao <--> DB
					요청분석, javaBean(Dao) 연동			javabean(component)
					결과 View를 클라이언트에게 응답			데이터 연동 로직
																1. getAllMemberCount()
					2. jsp 구현
--%>

<a href="step2-model1-memeber-count.jsp">Model1 아키텍쳐를 적용한 회원 수 보기</a><br>
<a href="step3-model1-find-memeber-form.jsp">Model1 아키텍쳐를 적용한 회원 검색하기</a><br>

</body>
</html>