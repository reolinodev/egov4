CREATE TABLE USER_TB
(
    user_id int NOT NULL,
    login_id varchar(50) not null,
    email varchar(50) not null,
    user_nm varchar(50) not null,
    user_pw varchar(255) not null,
    cell_phone varchar(100) not null,
    created_at timestamp,
    updated_at timestamp,
    last_login_at timestamp,
    use_yn varchar(1) DEFAULT 'Y'::character varying,
    primary key(user_id)
);

COMMENT ON TABLE public.user_tb IS '사용자';
COMMENT ON COLUMN public.user_tb.user_id IS '사용자 아이디';
COMMENT ON COLUMN public.user_tb.login_id IS '로그인 아이디';
COMMENT ON COLUMN public.user_tb.email IS '이메일';
COMMENT ON COLUMN public.user_tb.user_nm IS '사용자 명';
COMMENT ON COLUMN public.user_tb.user_pw IS '비밀번호';
COMMENT ON COLUMN public.user_tb.cell_phone IS '휴대폰';
COMMENT ON COLUMN public.user_tb.created_at IS '생성일';
COMMENT ON COLUMN public.user_tb.updated_at IS '수정일';
COMMENT ON COLUMN public.user_tb.last_login_at IS '마지막 로그인 일시';
COMMENT ON COLUMN public.user_tb.use_yn IS '사용 여부';

CREATE TABLE AUTH_TB
(
    auth_id int NOT NULL,
    auth_nm varchar(50) not null,
    auth_val varchar(20) not null,
    auth_role varchar(20) not null,
    ord varchar(10),
    bigo varchar(500),
    created_at timestamp,
    updated_at timestamp,
    updated_id int,
    use_yn varchar(1) DEFAULT 'Y'::character varying,
    primary key(auth_id)
);

COMMENT ON TABLE public.auth_tb IS '권한';
COMMENT ON COLUMN public.auth_tb.auth_id IS '권한 아이디';
COMMENT ON COLUMN public.auth_tb.auth_nm IS '권한 명';
COMMENT ON COLUMN public.auth_tb.auth_val IS '권한 값';
COMMENT ON COLUMN public.auth_tb.auth_role IS '권한 구분';
COMMENT ON COLUMN public.auth_tb.ord IS '순서';
COMMENT ON COLUMN public.auth_tb.bigo IS '비고';
COMMENT ON COLUMN public.auth_tb.created_at IS '생성일';
COMMENT ON COLUMN public.auth_tb.updated_at IS '수정일';
COMMENT ON COLUMN public.auth_tb.updated_id IS '수정자';
COMMENT ON COLUMN public.auth_tb.use_yn IS '사용 여부';

CREATE TABLE MENU_TB
(
    menu_id int NOT NULL,
    menu_nm varchar(50) not null,
    menu_lv int,
    parent_id int,
    menu_url varchar(200),
    menu_type varchar(10) not null,
    ord int,
    created_at timestamp,
    updated_at timestamp,
    updated_id int,
    use_yn varchar(1) DEFAULT 'Y'::character varying,
    main_yn varchar(1),
    primary key(menu_id)
);

COMMENT ON TABLE public.menu_tb IS '메뉴';
COMMENT ON COLUMN public.menu_tb.menu_id IS '메뉴 아이디';
COMMENT ON COLUMN public.menu_tb.menu_nm IS '메뉴 명';
COMMENT ON COLUMN public.menu_tb.menu_lv IS '메뉴 레벨';
COMMENT ON COLUMN public.menu_tb.parent_id IS '부모 아이디';
COMMENT ON COLUMN public.menu_tb.menu_url IS 'url';
COMMENT ON COLUMN public.menu_tb.menu_type IS '메뉴 타입';
COMMENT ON COLUMN public.menu_tb.ord IS '순서';
COMMENT ON COLUMN public.menu_tb.created_at IS '생성일';
COMMENT ON COLUMN public.menu_tb.updated_at IS '수정일';
COMMENT ON COLUMN public.menu_tb.updated_id IS '수정자';
COMMENT ON COLUMN public.menu_tb.use_yn IS '사용여부';
COMMENT ON COLUMN public.menu_tb.main_yn IS '메인화면 여부';

CREATE TABLE CODE_GRP_TB
(
    code_grp_id int NOT NULL,
    code_grp_nm varchar(50) not null,
    code_grp_val varchar(10) not null,
    created_at timestamp,
    updated_at timestamp,
    updated_id int,
    use_yn varchar(1) DEFAULT 'Y'::character varying,
    primary key(code_grp_id)
);
COMMENT ON TABLE public.code_grp_tb IS '코드 그룹';
COMMENT ON COLUMN public.code_grp_tb.code_grp_id IS '코드 그룹 아이디';
COMMENT ON COLUMN public.code_grp_tb.code_grp_nm IS '코드 그룹 명';
COMMENT ON COLUMN public.code_grp_tb.code_grp_val IS '코드 그룹 값';
COMMENT ON COLUMN public.code_grp_tb.created_at IS '생성일';
COMMENT ON COLUMN public.code_grp_tb.updated_at IS '수정일';
COMMENT ON COLUMN public.code_grp_tb.updated_id IS '수정자';
COMMENT ON COLUMN public.code_grp_tb.use_yn IS '사용여부';

CREATE TABLE CODE_TB
(
    code_id int NOT NULL,
    code_grp_id int NOT NULL,
    code_nm varchar(50) not null,
    code_val varchar(10) not null,
    bigo varchar(500),
    ord varchar(10),
    created_at timestamp,
    updated_at timestamp,
    updated_id int,
    use_yn varchar(1) DEFAULT 'Y'::character varying,
    primary key(code_id),
    foreign key (code_grp_id) REFERENCES CODE_GRP_TB (code_grp_id)
);

COMMENT ON TABLE public.code_tb IS '코드';
COMMENT ON COLUMN public.code_tb.code_id IS '코드 아이디';
COMMENT ON COLUMN public.code_tb.code_grp_id IS '코드 그룹 아이디';
COMMENT ON COLUMN public.code_tb.code_nm IS '코드 명';
COMMENT ON COLUMN public.code_tb.code_val IS '코드 값';
COMMENT ON COLUMN public.code_tb.bigo IS '비고';
COMMENT ON COLUMN public.code_tb.ord IS '순서';
COMMENT ON COLUMN public.code_tb.created_at IS '생성일';
COMMENT ON COLUMN public.code_tb.updated_at IS '수정일';
COMMENT ON COLUMN public.code_tb.updated_id IS '수정자';
COMMENT ON COLUMN public.code_tb.use_yn IS '사용여부';

CREATE TABLE AUTH_MENU_TB
(
    auth_id int NOT NULL,
    menu_id int NOT NULL,
    created_at timestamp,
    updated_at timestamp,
    updated_id int,
    use_yn varchar(1),
    primary key(auth_id, menu_id),
    foreign key (auth_id) REFERENCES AUTH_TB (auth_id),
    foreign key (menu_id) REFERENCES MENU_TB (menu_id)
);
COMMENT ON TABLE public.auth_menu_tb IS '권한 메뉴';
COMMENT ON COLUMN public.auth_menu_tb.auth_id IS '권한 아이디';
COMMENT ON COLUMN public.auth_menu_tb.menu_id IS '메뉴 아이디';
COMMENT ON COLUMN public.auth_menu_tb.created_at IS '생성일';
COMMENT ON COLUMN public.auth_menu_tb.updated_at IS '수정일';
COMMENT ON COLUMN public.auth_menu_tb.updated_id IS '수정자';
COMMENT ON COLUMN public.auth_menu_tb.use_yn IS '사용 여부';


CREATE TABLE USER_AUTH_TB
(
    user_id int NOT NULL,
    auth_id int NOT NULL,
    created_at timestamp,
    updated_at timestamp,
    updated_id int,
    use_yn varchar(1) NULL DEFAULT 'Y'::character varying,
    primary key(user_id, auth_id),
    foreign key (auth_id) REFERENCES AUTH_TB (auth_id),
    foreign key (user_id) REFERENCES USER_TB (user_id)
);
COMMENT ON TABLE public.user_auth_tb IS '권한 메뉴';
COMMENT ON COLUMN public.user_auth_tb.user_id IS '사용자 아이디';
COMMENT ON COLUMN public.user_auth_tb.auth_id IS '권한 아이디';
COMMENT ON COLUMN public.user_auth_tb.created_at IS '생성일';
COMMENT ON COLUMN public.user_auth_tb.updated_at IS '수정일';
COMMENT ON COLUMN public.user_auth_tb.updated_id IS '수정자';
COMMENT ON COLUMN public.user_auth_tb.use_yn IS '사용 여부';

CREATE TABLE LOGIN_HISTORY_TB
(
    user_id int NOT NULL,
    login_device varchar(50),
    device_browser varchar(200),
    created_at timestamp,
    foreign key (user_id) REFERENCES USER_TB (user_id)
);
COMMENT ON TABLE public.login_history_tb IS '로그인 내역';
COMMENT ON COLUMN public.login_history_tb.user_id IS '사용자 아이디';
COMMENT ON COLUMN public.login_history_tb.login_device IS '로그인 기기';
COMMENT ON COLUMN public.login_history_tb.device_browser IS '기기 브라우저';
COMMENT ON COLUMN public.login_history_tb.created_at IS '생성일';

CREATE TABLE UPDATE_HISTORY_TB
(
    user_id int NOT NULL,
    api varchar(200),
    created_at timestamp,
    foreign key (user_id) REFERENCES USER_TB (user_id)
);
COMMENT ON TABLE public.update_history_tb IS '로그인 내역';
COMMENT ON COLUMN public.update_history_tb.user_id IS '사용자 아이디';
COMMENT ON COLUMN public.update_history_tb.api IS 'API';
COMMENT ON COLUMN public.update_history_tb.created_at IS '생성일';

CREATE SEQUENCE user_seq START 1;
CREATE SEQUENCE auth_seq START 1;
CREATE SEQUENCE menu_seq START 1;
CREATE SEQUENCE code_grp_seq START 1;
CREATE SEQUENCE code_seq START 1;

CREATE FUNCTION getCodeNm (codeGrpVal varchar(50), codeVal varchar(50))
    RETURNS TABLE( codeNm varchar(50)) AS $$
begin
RETURN QUERY
SELECT B.CODE_NM
FROM CODE_GRP_TB A, CODE_TB B
WHERE A.CODE_GRP_ID = B.CODE_GRP_ID
  AND A.CODE_GRP_VAL  = codeGrpVal
  AND B.CODE_VAL = codeVal ;
END; $$
LANGUAGE 'plpgsql';


