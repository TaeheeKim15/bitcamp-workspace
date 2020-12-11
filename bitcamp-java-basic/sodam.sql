-- 가게
DROP TABLE IF EXISTS tmk_store_info RESTRICT;

-- 환불
DROP TABLE IF EXISTS tmk_refund RESTRICT;

-- 결제
DROP TABLE IF EXISTS tmk_pay_info RESTRICT;

-- 상품찜
DROP TABLE IF EXISTS tmk_wishlist RESTRICT;

-- 공지사항
DROP TABLE IF EXISTS tmk_notice RESTRICT;

-- 결제수단
DROP TABLE IF EXISTS tmk_payment RESTRICT;

-- 리뷰
DROP TABLE IF EXISTS tmk_review RESTRICT;

-- 상품
DROP TABLE IF EXISTS tmk_product RESTRICT;

-- 사용자 상품
DROP TABLE IF EXISTS tmk_user_product RESTRICT;

-- 주문항목
DROP TABLE IF EXISTS tmk_order_product RESTRICT;

-- 사용자
DROP TABLE IF EXISTS tmk_user RESTRICT;

-- 주문
DROP TABLE IF EXISTS tmk_order RESTRICT;

-- 할인쿠폰
DROP TABLE IF EXISTS tmk_discount RESTRICT;

-- 관리자_카테고리
DROP TABLE IF EXISTS tmk_category_list RESTRICT;

-- 카테고리
DROP TABLE IF EXISTS tmk_category RESTRICT;

-- 할인쿠폰발급
DROP TABLE IF EXISTS tmk_my_counpon RESTRICT;

-- 리뷰평가
DROP TABLE IF EXISTS tmk_rgb RESTRICT;

-- 1:1문의
DROP TABLE IF EXISTS tmk_mtm RESTRICT;

-- 고객센터
DROP TABLE IF EXISTS tmk_sc RESTRICT;

-- 가게
CREATE TABLE tmk_store_info (
  sno        INTEGER      NOT NULL, -- 가게 번호
  uno        INTEGER      NOT NULL, -- 사용자번호
  sname      VARCHAR(50)  NOT NULL, -- 상호명
  sint       MEDIUMTEXT   NULL,     -- 가게소개
  spst       VARCHAR(6)   NULL,     -- 우편번호
  saddr      VARCHAR(255) NULL,     -- 기본주소
  s_det_addr VARCHAR(255) NULL,     -- 상세주소
  dyesno     INTEGER      NOT NULL, -- 배송여부
  sphoto     VARCHAR(255) NULL,     -- 가게사진
  edt        DATETIME     NULL,     -- 종료 영업시간
  sdt        DATETIME     NULL,     -- 시작 영업시간
  scdt       DATE         NOT NULL  -- 생성일
);

-- 가게
ALTER TABLE tmk_store_info
  ADD CONSTRAINT PK_tmk_store_info -- 가게 기본키
    PRIMARY KEY (
      sno -- 가게 번호
    );

-- 환불
CREATE TABLE tmk_refund (
  ono        INTEGER    NOT NULL, -- 주문 번호
  ref_reason MEDIUMTEXT NOT NULL, -- 환불사유
  ref_date   DATE       NOT NULL, -- 처리일
  ref_status INTEGER    NOT NULL  -- 처리상태
);

-- 환불
ALTER TABLE tmk_refund
  ADD CONSTRAINT PK_tmk_refund -- 환불 기본키
    PRIMARY KEY (
      ono -- 주문 번호
    );

-- 결제
CREATE TABLE tmk_pay_info (
  ono       INTEGER NOT NULL, -- 주문 번호
  pmno      INTEGER NOT NULL, -- 결제수단번호
  mcuno     INTEGER NOT NULL, -- 할인쿠폰번호
  tprice    INTEGER NOT NULL, -- 총상품금액
  dis_price INTEGER NOT NULL, -- 할인금액
  lst_price INTEGER NOT NULL, -- 최종결제금액
  dprice    INTEGER NOT NULL, -- 배송비
  pdt       DATE    NOT NULL  -- 결제일
);

-- 결제
ALTER TABLE tmk_pay_info
  ADD CONSTRAINT PK_tmk_pay_info -- 결제 기본키
    PRIMARY KEY (
      ono -- 주문 번호
    );

-- 결제 유니크 인덱스
CREATE UNIQUE INDEX UIX_tmk_pay_info
  ON tmk_pay_info ( -- 결제
    ono ASC -- 주문 번호
  );

-- 결제 유니크 인덱스2
CREATE UNIQUE INDEX UIX_tmk_pay_info2
  ON tmk_pay_info ( -- 결제
    mcuno ASC -- 할인쿠폰번호
  );

-- 상품찜
CREATE TABLE tmk_wishlist (
  uno  INTEGER NOT NULL, -- 사용자번호
  pno  INTEGER NOT NULL, -- 상품 번호
  wcdt DATE    NOT NULL  -- 생성일
);

-- 상품찜
ALTER TABLE tmk_wishlist
  ADD CONSTRAINT PK_tmk_wishlist -- 상품찜 기본키
    PRIMARY KEY (
      uno, -- 사용자번호
      pno  -- 상품 번호
    );

-- 공지사항
CREATE TABLE tmk_notice (
  nno      INTEGER     NOT NULL, -- 공지번호
  ntitle   VARCHAR(50) NOT NULL, -- 제목
  ncontent MEDIUMTEXT  NOT NULL, -- 내용
  ndate    DATE        NOT NULL, -- 등록일
  nv_cnt   INTEGER     NULL      -- 조회수
);

-- 공지사항
ALTER TABLE tmk_notice
  ADD CONSTRAINT PK_tmk_notice -- 공지사항 기본키
    PRIMARY KEY (
      nno -- 공지번호
    );

-- 결제수단
CREATE TABLE tmk_payment (
  pmno   INTEGER     NOT NULL, -- 결제수단번호
  pmname VARCHAR(50) NOT NULL  -- 결제수단명
);

-- 결제수단
ALTER TABLE tmk_payment
  ADD CONSTRAINT PK_tmk_payment -- 결제수단 기본키
    PRIMARY KEY (
      pmno -- 결제수단번호
    );

-- 리뷰
CREATE TABLE tmk_review (
  rno      INTEGER    NOT NULL, -- 리뷰번호
  sno      INTEGER    NOT NULL, -- 가게 번호
  uno      INTEGER    NOT NULL, -- 사용자번호
  rcontent MEDIUMTEXT NOT NULL, -- 내용
  rscore   INTEGER    NOT NULL, -- 가게평가점수
  cdt      DATE       NOT NULL  -- 등록일
);

-- 리뷰
ALTER TABLE tmk_review
  ADD CONSTRAINT PK_tmk_review -- 리뷰 기본키
    PRIMARY KEY (
      rno -- 리뷰번호
    );

-- 상품
CREATE TABLE tmk_product (
  pno   INTEGER      NOT NULL, -- 상품 번호
  sno   INTEGER      NOT NULL, -- 가게 번호
  pname VARCHAR(50)  NOT NULL, -- 상품명
  price INTEGER      NOT NULL, -- 가격
  stock INTEGER      NOT NULL, -- 재고여부
  photo VARCHAR(255) NULL,     -- 사진
  pint  MEDIUMTEXT   NULL,     -- 상품소개
  pcdt  DATE         NOT NULL  -- 생성일
);

-- 상품
ALTER TABLE tmk_product
  ADD CONSTRAINT PK_tmk_product -- 상품 기본키
    PRIMARY KEY (
      pno -- 상품 번호
    );

-- 사용자 상품
CREATE TABLE tmk_user_product (
  pno      INTEGER NOT NULL, -- 상품 번호
  uno      INTEGER NOT NULL, -- 사용자번호
  date     DATE    NOT NULL, -- 등록일
  quantity INTEGER NOT NULL  -- 상품 수량
);

-- 주문항목
CREATE TABLE tmk_order_product (
  ono    INTEGER NOT NULL, -- 주문 번호
  pno    INTEGER NOT NULL, -- 상품 번호
  price  INTEGER NOT NULL, -- 가격
  op_cnt INTEGER NOT NULL  -- 수량
);

-- 주문항목
ALTER TABLE tmk_order_product
  ADD CONSTRAINT PK_tmk_order_product -- 주문항목 기본키
    PRIMARY KEY (
      ono, -- 주문 번호
      pno  -- 상품 번호
    );

-- 사용자
CREATE TABLE tmk_user (
  uno      INTEGER      NOT NULL, -- 사용자번호
  name     VARCHAR(50)  NOT NULL, -- 이름
  email    VARCHAR(40)  NOT NULL, -- 이메일
  pwd      VARCHAR(50)  NOT NULL, -- 비밀번호
  pst      VARCHAR(6)   NULL,     -- 우편번호
  addr     VARCHAR(255) NULL,     -- 기본주소
  det_addr VARCHAR(255) NULL,     -- 상세주소
  tel      VARCHAR(30)  NULL,     -- 전화번호
  birth    VARCHAR(8)   NULL,     -- 생일
  status   INTEGER      NOT NULL, -- 계정상태
  auth     INTEGER      NOT NULL, -- 권한
  uphoto   VARCHAR(255) NULL,     -- 사진
  rdt      DATE         NOT NULL  -- 가입일
);

-- 사용자
ALTER TABLE tmk_user
  ADD CONSTRAINT PK_tmk_user -- 사용자 기본키
    PRIMARY KEY (
      uno -- 사용자번호
    );

-- 사용자 유니크 인덱스
CREATE UNIQUE INDEX UIX_tmk_user
  ON tmk_user ( -- 사용자
    email ASC -- 이메일
  );

-- 주문
CREATE TABLE tmk_order (
  ono     INTEGER      NOT NULL, -- 주문 번호
  uno     INTEGER      NOT NULL, -- 사용자번호
  odt     DATE         NOT NULL, -- 주문일
  request VARCHAR(255) NULL,     -- 요청사항
  dcmp    VARCHAR(50)  NULL,     -- 배송사
  tran_no VARCHAR(255) NULL,     -- 운송장번호
  dstatus INTEGER      NOT NULL  -- 배송상태
);

-- 주문
ALTER TABLE tmk_order
  ADD CONSTRAINT PK_tmk_order -- 주문 기본키
    PRIMARY KEY (
      ono -- 주문 번호
    );

-- 할인쿠폰
CREATE TABLE tmk_discount (
  cuno    INTEGER      NOT NULL, -- 쿠폰번호
  cuname  VARCHAR(50)  NOT NULL, -- 쿠폰명
  cuprice INTEGER      NOT NULL, -- 할인금액
  cuexp   DATE         NOT NULL, -- 유효기간
  cuint   VARCHAR(255) NOT NULL  -- 쿠폰설명
);

-- 할인쿠폰
ALTER TABLE tmk_discount
  ADD CONSTRAINT PK_tmk_discount -- 할인쿠폰 기본키
    PRIMARY KEY (
      cuno -- 쿠폰번호
    );

-- 관리자_카테고리
CREATE TABLE tmk_category_list (
  ctno   INTEGER     NOT NULL, -- 카테고리번호
  ctname VARCHAR(50) NOT NULL  -- 카테고리명
);

-- 관리자_카테고리
ALTER TABLE tmk_category_list
  ADD CONSTRAINT PK_tmk_category_list -- 관리자_카테고리 기본키
    PRIMARY KEY (
      ctno -- 카테고리번호
    );

-- 관리자_카테고리 유니크 인덱스
CREATE UNIQUE INDEX UIX_tmk_category_list
  ON tmk_category_list ( -- 관리자_카테고리
    ctname ASC -- 카테고리명
  );

-- 카테고리
CREATE TABLE tmk_category (
  sno  INTEGER NOT NULL, -- 가게 번호
  ctno INTEGER NOT NULL  -- 카테고리번호
);

-- 카테고리
ALTER TABLE tmk_category
  ADD CONSTRAINT PK_tmk_category -- 카테고리 기본키
    PRIMARY KEY (
      sno,  -- 가게 번호
      ctno  -- 카테고리번호
    );

-- 할인쿠폰발급
CREATE TABLE tmk_my_counpon (
  mcuno      INTEGER NOT NULL, -- 할인쿠폰번호
  uno        INTEGER NOT NULL, -- 사용자번호
  cuno       INTEGER NOT NULL, -- 쿠폰번호
  mcudt      DATE    NOT NULL, -- 발급일
  mcu_status INTEGER NULL      -- 사용여부
);

-- 할인쿠폰발급
ALTER TABLE tmk_my_counpon
  ADD CONSTRAINT PK_tmk_my_counpon -- 할인쿠폰발급 기본키
    PRIMARY KEY (
      mcuno -- 할인쿠폰번호
    );

-- 리뷰평가
CREATE TABLE tmk_rgb (
  uno   INTEGER NOT NULL, -- 사용자번호
  rno   INTEGER NOT NULL, -- 리뷰번호
  rtype INTEGER NULL,     -- 평가유형
  rcdt  DATE    NOT NULL  -- 생성일
);

-- 리뷰평가
ALTER TABLE tmk_rgb
  ADD CONSTRAINT PK_tmk_rgb -- 리뷰평가 기본키
    PRIMARY KEY (
      uno, -- 사용자번호
      rno  -- 리뷰번호
    );

-- 1:1문의
CREATE TABLE tmk_mtm (
  qno     INTEGER     NOT NULL, -- 문의 번호
  uno     INTEGER     NOT NULL, -- 사용자번호
  title   VARCHAR(50) NOT NULL, -- 제목
  content MEDIUMTEXT  NOT NULL, -- 내용
  COL     DATE        NOT NULL, -- 등록일
  qtype   INTEGER     NOT NULL, -- 문의유형
  qstatus INTEGER     NOT NULL  -- 처리상태
);

-- 1:1문의
ALTER TABLE tmk_mtm
  ADD CONSTRAINT PK_tmk_mtm -- 1:1문의 기본키
    PRIMARY KEY (
      qno -- 문의 번호
    );

-- 1:1문의 유니크 인덱스
CREATE UNIQUE INDEX UIX_tmk_mtm
  ON tmk_mtm ( -- 1:1문의
    uno ASC -- 사용자번호
  );

-- 고객센터
CREATE TABLE tmk_sc (
  scno      INTEGER     NOT NULL, -- 게시글 번호
  sctype    INTEGER     NOT NULL, -- 문의유형
  sctitle   VARCHAR(50) NOT NULL, -- 제목
  sccontent MEDIUMTEXT  NOT NULL  -- 내용
);

-- 고객센터
ALTER TABLE tmk_sc
  ADD CONSTRAINT PK_tmk_sc -- 고객센터 기본키
    PRIMARY KEY (
      scno -- 게시글 번호
    );

-- 가게
ALTER TABLE tmk_store_info
  ADD CONSTRAINT FK_tmk_user_TO_tmk_store_info -- 사용자 -> 가게
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES tmk_user ( -- 사용자
      uno -- 사용자번호
    );

-- 환불
ALTER TABLE tmk_refund
  ADD CONSTRAINT FK_tmk_pay_info_TO_tmk_refund -- 결제 -> 환불
    FOREIGN KEY (
      ono -- 주문 번호
    )
    REFERENCES tmk_pay_info ( -- 결제
      ono -- 주문 번호
    );

-- 결제
ALTER TABLE tmk_pay_info
  ADD CONSTRAINT FK_tmk_order_TO_tmk_pay_info -- 주문 -> 결제
    FOREIGN KEY (
      ono -- 주문 번호
    )
    REFERENCES tmk_order ( -- 주문
      ono -- 주문 번호
    );

-- 결제
ALTER TABLE tmk_pay_info
  ADD CONSTRAINT FK_tmk_payment_TO_tmk_pay_info -- 결제수단 -> 결제
    FOREIGN KEY (
      pmno -- 결제수단번호
    )
    REFERENCES tmk_payment ( -- 결제수단
      pmno -- 결제수단번호
    );

-- 결제
ALTER TABLE tmk_pay_info
  ADD CONSTRAINT FK_tmk_my_counpon_TO_tmk_pay_info -- 할인쿠폰발급 -> 결제
    FOREIGN KEY (
      mcuno -- 할인쿠폰번호
    )
    REFERENCES tmk_my_counpon ( -- 할인쿠폰발급
      mcuno -- 할인쿠폰번호
    );

-- 상품찜
ALTER TABLE tmk_wishlist
  ADD CONSTRAINT FK_tmk_user_TO_tmk_wishlist -- 사용자 -> 상품찜
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES tmk_user ( -- 사용자
      uno -- 사용자번호
    );

-- 상품찜
ALTER TABLE tmk_wishlist
  ADD CONSTRAINT FK_tmk_product_TO_tmk_wishlist -- 상품 -> 상품찜
    FOREIGN KEY (
      pno -- 상품 번호
    )
    REFERENCES tmk_product ( -- 상품
      pno -- 상품 번호
    );

-- 리뷰
ALTER TABLE tmk_review
  ADD CONSTRAINT FK_tmk_store_info_TO_tmk_review -- 가게 -> 리뷰
    FOREIGN KEY (
      sno -- 가게 번호
    )
    REFERENCES tmk_store_info ( -- 가게
      sno -- 가게 번호
    );

-- 리뷰
ALTER TABLE tmk_review
  ADD CONSTRAINT FK_tmk_user_TO_tmk_review -- 사용자 -> 리뷰
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES tmk_user ( -- 사용자
      uno -- 사용자번호
    );

-- 상품
ALTER TABLE tmk_product
  ADD CONSTRAINT FK_tmk_store_info_TO_tmk_product -- 가게 -> 상품
    FOREIGN KEY (
      sno -- 가게 번호
    )
    REFERENCES tmk_store_info ( -- 가게
      sno -- 가게 번호
    );

-- 사용자 상품
ALTER TABLE tmk_user_product
  ADD CONSTRAINT FK_tmk_product_TO_tmk_user_product -- 상품 -> 사용자 상품
    FOREIGN KEY (
      pno -- 상품 번호
    )
    REFERENCES tmk_product ( -- 상품
      pno -- 상품 번호
    );

-- 사용자 상품
ALTER TABLE tmk_user_product
  ADD CONSTRAINT FK_tmk_user_TO_tmk_user_product -- 사용자 -> 사용자 상품
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES tmk_user ( -- 사용자
      uno -- 사용자번호
    );

-- 주문항목
ALTER TABLE tmk_order_product
  ADD CONSTRAINT FK_tmk_order_TO_tmk_order_product -- 주문 -> 주문항목
    FOREIGN KEY (
      ono -- 주문 번호
    )
    REFERENCES tmk_order ( -- 주문
      ono -- 주문 번호
    );

-- 주문항목
ALTER TABLE tmk_order_product
  ADD CONSTRAINT FK_tmk_product_TO_tmk_order_product -- 상품 -> 주문항목
    FOREIGN KEY (
      pno -- 상품 번호
    )
    REFERENCES tmk_product ( -- 상품
      pno -- 상품 번호
    );

-- 주문
ALTER TABLE tmk_order
  ADD CONSTRAINT FK_tmk_user_TO_tmk_order -- 사용자 -> 주문
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES tmk_user ( -- 사용자
      uno -- 사용자번호
    );

-- 카테고리
ALTER TABLE tmk_category
  ADD CONSTRAINT FK_tmk_category_list_TO_tmk_category -- 관리자_카테고리 -> 카테고리
    FOREIGN KEY (
      ctno -- 카테고리번호
    )
    REFERENCES tmk_category_list ( -- 관리자_카테고리
      ctno -- 카테고리번호
    );

-- 카테고리
ALTER TABLE tmk_category
  ADD CONSTRAINT FK_tmk_store_info_TO_tmk_category -- 가게 -> 카테고리
    FOREIGN KEY (
      sno -- 가게 번호
    )
    REFERENCES tmk_store_info ( -- 가게
      sno -- 가게 번호
    );

-- 할인쿠폰발급
ALTER TABLE tmk_my_counpon
  ADD CONSTRAINT FK_tmk_user_TO_tmk_my_counpon -- 사용자 -> 할인쿠폰발급
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES tmk_user ( -- 사용자
      uno -- 사용자번호
    );

-- 할인쿠폰발급
ALTER TABLE tmk_my_counpon
  ADD CONSTRAINT FK_tmk_discount_TO_tmk_my_counpon -- 할인쿠폰 -> 할인쿠폰발급
    FOREIGN KEY (
      cuno -- 쿠폰번호
    )
    REFERENCES tmk_discount ( -- 할인쿠폰
      cuno -- 쿠폰번호
    );

-- 리뷰평가
ALTER TABLE tmk_rgb
  ADD CONSTRAINT FK_tmk_user_TO_tmk_rgb -- 사용자 -> 리뷰평가
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES tmk_user ( -- 사용자
      uno -- 사용자번호
    );

-- 리뷰평가
ALTER TABLE tmk_rgb
  ADD CONSTRAINT FK_tmk_review_TO_tmk_rgb -- 리뷰 -> 리뷰평가
    FOREIGN KEY (
      rno -- 리뷰번호
    )
    REFERENCES tmk_review ( -- 리뷰
      rno -- 리뷰번호
    );

-- 1:1문의
ALTER TABLE tmk_mtm
  ADD CONSTRAINT FK_tmk_user_TO_tmk_mtm -- 사용자 -> 1:1문의
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES tmk_user ( -- 사용자
      uno -- 사용자번호
    );