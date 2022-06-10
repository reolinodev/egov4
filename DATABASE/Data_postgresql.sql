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
SELECT  2, 1, now()

-- 코드
INSERT INTO CODE_GRP_TB(CODE_GRP_ID,CODE_GRP_NM,CODE_GRP_VAL,CREATED_AT)
VALUES(nextval('code_grp_seq'),'사용여부','USE_YN',NOW());
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( nextval('code_seq'), 1, '사용', 'Y', NULL, '1', now() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( nextval('code_seq'), 1, '미사용', 'N', NULL, '2', now() );

INSERT INTO CODE_GRP_TB ( CODE_GRP_ID, CODE_GRP_NM, CODE_GRP_VAL, CREATED_AT )
VALUES ( nextval('code_grp_seq'),'권한구분', 'AUTH_ROLE', NOW() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( nextval('code_seq'), 2, '관리자 사이트', 'ADMIN', NULL, '1', now() );
INSERT INTO CODE_TB ( CODE_ID, CODE_GRP_ID, CODE_NM, CODE_VAL, BIGO, ORD, CREATED_AT )
VALUES ( nextval('code_seq'), 2, '사용자 사이트', 'USER', NULL, '2', now() );