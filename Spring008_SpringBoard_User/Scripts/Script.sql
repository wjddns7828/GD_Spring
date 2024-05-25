--게시글 리스트
SELECT SEQ ,ID ,TITLE ,CONTENT ,STEP ,"DEPTH" ,"REF" ,DELFLAG ,REGDATE 
	FROM ANSWERBOARD a 
--게시글 삭제하기
	UPDATE ANSWERBOARD SET DELFLAG ='Y'
	WHERE DELFLAG ='N'
	AND SEQ IN('21','22');
--게시글 작성하기
	INSERT INTO HR.ANSWERBOARD
	(SEQ, ID, TITLE, CONTENT, "REF", STEP, "DEPTH", REGDATE, DELFLAG)
			VALUES(ANSERBOARD_SEQ.NEXTVAL, '', '', 
			'', 0, 0,
			(SELECT NVL(MAX(REF),0)+1 FROM ANSWERBOARD a), SYSDATE , 'N'
	);
--게시글 상세보기
	SELECT SEQ ,ID ,TITLE ,CONTENT ,STEP ,"DEPTH" ,"REF" ,DELFLAG ,REGDATE 
		FROM ANSWERBOARD a
		WHERE SEQ='';
--답글 업데이트
	UPDATE ANSWERBOARD SET STEP = STEP +1
		WHERE "REF" = (SELECT "REF" FROM ANSWERBOARD a WHERE SEQ='')
		AND STEP  > (SELECT STEP FROM ANSWERBOARD a2 WHERE SEQ=''); 
--답글 작성
	INSERT INTO HR.ANSWERBOARD
	(SEQ, ID, TITLE, CONTENT, "REF", STEP, "DEPTH", REGDATE, DELFLAG)
		VALUES(ANSWERBOARD_SEQ,NEXTVAL,'','','',
		(SELECT "REF" FROM ANSWERBOARD a3 WHERE SEQ='')+1,
		(SELECT STEP FROM ANSWERBOARD a WHERE SEQ='')+1,
		(SELECT "DEPTH" FROM ANSWERBOARD a2 WHERE SEQ='')+1,
		'N',SYSDATE );
--로그인
	SELECT ID, NAME, EMAIL ,AUTH ,DELFLAG ,JOINDATE
	FROM USERINFO u 
	WHERE ID='user'
	AND PASSWORD ='1234';

--중복검사
	SELECT COUNT(*)
	FROM USERINFO u
	WHERE ID='user';

--회원가입
	INSERT INTO USERINFO (ID, NAME, PASSWORD,
							EMAIL,AUTH ,DELFLAG ,
							JOINDATE)
				VALUES('','','','',
						'U','N',SYSDATE);
--회원전체조회
	SELECT ID,NAME
		FROM USERINFO u ;
--회원상세 조회
	SELECT ID, NAME ,EMAIL ,AUTH ,DELFLAG ,TO_CHAR(JOINDATE,'YYYY-MM-DD') AS JOINDATE  
		FROM USERINFO u
		WHERE ID = '';
--회원검색(LIKE, WHEN)
	SELECT	ID,NAME
		FROM USERINFO u
		WHERE AUTH = 'U'
		AND ID LIKE ''
		AND NAME LIKE ''
--아이디 찾기
	SELECT ID 
		FROM USERINFO u2 
		WHERE NAME ='' AND EMAIL ='';
--패스워드 암호화
--회원 권한 변경
--게시글 복구 리스트
	SELECT SEQ ,ID ,TITLE ,CONTENT ,STEP ,"DEPTH" ,"REF" ,DELFLAG ,REGDATE 
		FROM ANSWERBOARD a 
			WHERE DELFLAG ='Y'
--복구 기능
	UPDATE ANSWERBOARD SET DELFLAG ='N'
		WHERE DELFLAG ='Y'
		AND SEQ IN('');