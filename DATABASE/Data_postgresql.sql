-- 권한 입력 --
INSERT INTO AUTH_TB(AUTH_ID,AUTH_NM,AUTH_VAL,AUTH_ROLE,ORD,BIGO,CREATED_AT)
VALUES(nextval('auth_seq'),'Super Admin','SADMIN','ADMIN','1','슈퍼 관리자',now());
INSERT INTO AUTH_TB(AUTH_ID,AUTH_NM,AUTH_VAL,AUTH_ROLE,ORD,BIGO,CREATED_AT)
VALUES(nextval('auth_seq'),'Manager','MANAGER','ADMIN','2','운영자',now());

-- 사용자 입력 입력 --
INSERT INTO USER_TB(USER_ID, LOGIN_ID,EMAIL,USER_NM,USER_PW,CELL_PHONE,CREATED_AT)
VALUES(nextval('user_seq'),'admin','admin@gmail.com','관리자','1111','01011112222',now());

-- 사용자 권한 입력 (사용자 아이디, 권한을 조회해서 넣어주세요)--
INSERT INTO USER_AUTH_TB (USER_ID, AUTH_ID, CREATED_AT)
SELECT  (SELECT USER_ID FROM USER_TB WHERE LOGIN_ID = 'admin'), (SELECT AUTH_ID FROM AUTH_TB WHERE AUTH_VAL = 'SADMIN' ), now()

-- 코드
INSERT INTO CODE_GRP_TB(CODE_GRP_ID,CODE_GRP_NM,CODE_GRP_VAL,CREATED_AT)
VALUES(nextval('code_grp_seq'),'사용여부','USE_YN',NOW());
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( NEXTVAL('CODE_SEQ'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'USE_YN'), '사용', 'Y', NULL, '1', NOW() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( NEXTVAL('CODE_SEQ'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'USE_YN'), '미사용', 'N', NULL, '2', NOW() );

INSERT INTO CODE_GRP_TB ( CODE_GRP_ID, CODE_GRP_NM, CODE_GRP_VAL, CREATED_AT )
VALUES ( nextval('code_grp_seq'),'권한구분', 'AUTH_ROLE', NOW() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( nextval('code_seq'),(SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'AUTH_ROLE'), '관리자 사이트', 'ADMIN', NULL, '1', now() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( nextval('code_seq'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'AUTH_ROLE'), '사용자 사이트', 'USER', NULL, '2', now() );

INSERT INTO CODE_GRP_TB ( CODE_GRP_ID, CODE_GRP_NM, CODE_GRP_VAL, CREATED_AT )
VALUES ( nextval('code_grp_seq'),'페이지 항목', 'PAGE_PER', NOW() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( nextval('code_seq'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'PAGE_PER'), '10개', '10', NULL, '1', now() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( nextval('code_seq'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'PAGE_PER'), '20개', '20', NULL, '2', now() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( nextval('code_seq'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'PAGE_PER'), '50개', '50', NULL, '3', now() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( nextval('code_seq'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'PAGE_PER'), '100개', '100', NULL, '4', now() );

INSERT INTO CODE_GRP_TB ( CODE_GRP_ID, CODE_GRP_NM, CODE_GRP_VAL, CREATED_AT )
VALUES ( nextval('code_grp_seq'),'메인 페이지', 'MAIN_URL', NOW() );

INSERT INTO CODE_GRP_TB(CODE_GRP_ID,CODE_GRP_NM,CODE_GRP_VAL,CREATED_AT)
VALUES(nextval('code_grp_seq'),'게시판 유형','BOARD_TYPE',NOW());
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( NEXTVAL('CODE_SEQ'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'BOARD_TYPE'), '목록형', 'LIST', NULL, '1', NOW() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( NEXTVAL('CODE_SEQ'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'BOARD_TYPE'), '갤러리형', 'GALLERY', NULL, '2', NOW() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( NEXTVAL('CODE_SEQ'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'BOARD_TYPE'), '웹진형', 'WEBZINE', NULL, '3', NOW() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( NEXTVAL('CODE_SEQ'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'BOARD_TYPE'), 'FAQ', 'FAQ', NULL, '4', NOW() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( NEXTVAL('CODE_SEQ'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'BOARD_TYPE'), 'QNA', 'QNA', NULL, '5', NOW() );

-- 메뉴등록
INSERT INTO public.menu_tb(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), '사용자 설정', 1, 0, '', 1, 'Y', 'url', 'ADMIN', 'N', NOW());
INSERT INTO public.menu_tb
(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), '메뉴 설정', 1, 0, '', 2, 'Y', 'url', 'ADMIN', 'N', NOW());
INSERT INTO public.menu_tb
(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), '게시판 설정', 1, 0, '', 3, 'Y', 'url', 'ADMIN', 'N', NOW());
INSERT INTO public.menu_tb
(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), '기타 설정', 1, 0, '', 4, 'Y', 'url', 'ADMIN', 'N', NOW());

INSERT INTO public.menu_tb
(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), '사용자 관리', 2, (select menu_id from menu_tb where menu_nm = '사용자 설정'), '/admin/user/user', 1, 'Y', 'url', 'ADMIN', 'N', NOW());
INSERT INTO public.menu_tb
(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), '권한 관리', 2, (select menu_id from menu_tb where menu_nm = '사용자 설정'), '/admin/user/auth', 2, 'Y', 'url', 'ADMIN', 'N', NOW());
INSERT INTO public.menu_tb
(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), '사용자 권한 관리', 2, (select menu_id from menu_tb where menu_nm = '사용자 설정'), '/admin/user/userAuth', 3, 'Y', 'url', 'ADMIN', 'N', NOW());
INSERT INTO public.menu_tb
(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), '메뉴 관리', 2, (select menu_id from menu_tb where menu_nm = '메뉴 설정'), '/admin/menu/menu', 1, 'Y', 'url', 'ADMIN', 'N', NOW());
INSERT INTO public.menu_tb
(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), '권한별 메뉴 관리', 2, (select menu_id from menu_tb where menu_nm = '메뉴 설정'), '/admin/menu/authMenu', 2, 'Y', 'url', 'ADMIN', 'N', NOW());
INSERT INTO public.menu_tb
(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), '코드 관리', 2, (select menu_id from menu_tb where menu_nm = '기타 설정'), '/admin/mng/code', 4, 'Y', 'url', 'ADMIN', 'N', NOW());
INSERT INTO public.menu_tb
(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), '게시판 관리', 2, (select menu_id from menu_tb where menu_nm = '게시판 설정'), '/admin/board/board', 1, 'Y', 'url', 'ADMIN', 'N', NOW());
INSERT INTO public.menu_tb
(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), '게시글 관리', 2, (select menu_id from menu_tb where menu_nm = '게시판 설정'), '/admin/board/post', 2, 'Y', 'url', 'ADMIN', 'N', NOW());
INSERT INTO public.menu_tb
(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), 'FAQ 관리', 2, (select menu_id from menu_tb where menu_nm = '게시판 설정'), '/admin/board/faq', 2, 'Y', 'url', 'ADMIN', 'N', NOW());
INSERT INTO public.menu_tb
(menu_id, menu_nm, menu_lv, parent_id, menu_url, ord, use_yn, menu_type, auth_role, main_yn, created_at)
VALUES(nextval('menu_seq'), 'QNA 관리', 2, (select menu_id from menu_tb where menu_nm = '게시판 설정'), '/admin/board/qna', 2, 'Y', 'url', 'ADMIN', 'N', NOW());


-- 코드
INSERT INTO CODE_GRP_TB(CODE_GRP_ID,CODE_GRP_NM,CODE_GRP_VAL,CREATED_AT)
VALUES(nextval('code_grp_seq'),'문의유형','QUESTION_TYPE',NOW());
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( NEXTVAL('CODE_SEQ'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'QUESTION_TYPE'), '회원가입', 'MEMBER', NULL, '1', NOW() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( NEXTVAL('CODE_SEQ'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'QUESTION_TYPE'), '데이터', 'DATA', NULL, '2', NOW() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( NEXTVAL('CODE_SEQ'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'QUESTION_TYPE'), '사이트 이용문의', 'SITE', NULL, '3', NOW() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( NEXTVAL('CODE_SEQ'), (SELECT CODE_GRP_ID FROM CODE_GRP_TB WHERE CODE_GRP_VAL = 'QUESTION_TYPE'), '기타', 'ETC', NULL, '4', NOW() );