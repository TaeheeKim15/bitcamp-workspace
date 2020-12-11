-- 가게
CREATE TABLE tmk_store_info (
  sno        INTEGER      NOT NULL COMMENT '가게 번호', -- 가게 번호
  uno        INTEGER      NOT NULL COMMENT '사용자번호', -- 사용자번호
  sname      VARCHAR(50)  NOT NULL COMMENT '상호명', -- 상호명
  sint       MEDIUMTEXT   NULL     COMMENT '가게소개', -- 가게소개
  spst       VARCHAR(6)   NULL     COMMENT '우편번호', -- 우편번호
  saddr      VARCHAR(255) NULL     COMMENT '기본주소', -- 기본주소
  s_det_addr VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
  dyesno     INTEGER      NOT NULL COMMENT '배송여부', -- 배송여부
  sphoto     VARCHAR(255) NULL     COMMENT '가게사진', -- 가게사진
  edt        DATETIME     NULL     COMMENT '종료 영업시간', -- 종료 영업시간
  sdt        DATETIME     NULL     COMMENT '시작 영업시간', -- 시작 영업시간
  scdt       DATE         NOT NULL COMMENT '생성일' -- 생성일
)
COMMENT '가게';

-- 가게
ALTER TABLE tmk_store_info
  ADD CONSTRAINT PK_tmk_store_info -- 가게 기본키
    PRIMARY KEY (
      sno -- 가게 번호
    );

ALTER TABLE tmk_store_info
  MODIFY COLUMN sno INTEGER NOT NULL AUTO_INCREMENT COMMENT '가게 번호';

-- 상품
CREATE TABLE tmk_product (
  pno   INTEGER      NOT NULL COMMENT '상품 번호', -- 상품 번호
  sno   INTEGER      NOT NULL COMMENT '가게 번호', -- 가게 번호
  pname VARCHAR(50)  NOT NULL COMMENT '상품명', -- 상품명
  price INTEGER      NOT NULL COMMENT '가격', -- 가격
  stock INTEGER      NOT NULL COMMENT '재고여부', -- 재고여부
  photo VARCHAR(255) NULL     COMMENT '사진', -- 사진
  pint  MEDIUMTEXT   NULL     COMMENT '상품소개', -- 상품소개
  pcdt  DATE         NOT NULL COMMENT '생성일' -- 생성일
)
COMMENT '상품';

-- 상품
ALTER TABLE tmk_product
  ADD CONSTRAINT PK_tmk_product -- 상품 기본키
    PRIMARY KEY (
      pno -- 상품 번호
    );

ALTER TABLE tmk_product
  MODIFY COLUMN pno INTEGER NOT NULL AUTO_INCREMENT COMMENT '상품 번호';

-- 주문
CREATE TABLE tmk_order (
  ono     INTEGER      NOT NULL COMMENT '주문 번호', -- 주문 번호
  uno     INTEGER      NOT NULL COMMENT '사용자번호', -- 사용자번호
  odt     DATE         NOT NULL COMMENT '주문일', -- 주문일
  request VARCHAR(255) NULL     COMMENT '요청사항', -- 요청사항
  dcmp    VARCHAR(50)  NULL     COMMENT '배송사', -- 배송사
  tran_no VARCHAR(255) NULL     COMMENT '운송장번호', -- 운송장번호
  dstatus INTEGER      NOT NULL COMMENT '배송상태' -- 배송상태
)
COMMENT '주문';

-- 주문
ALTER TABLE tmk_order
  ADD CONSTRAINT PK_tmk_order -- 주문 기본키
    PRIMARY KEY (
      ono -- 주문 번호
    );

ALTER TABLE tmk_order
  MODIFY COLUMN ono INTEGER NOT NULL AUTO_INCREMENT COMMENT '주문 번호';

-- 고객센터
CREATE TABLE tmk_sc (
  scno      INTEGER     NOT NULL COMMENT '게시글 번호', -- 게시글 번호
  sctype    INTEGER     NOT NULL COMMENT '문의유형', -- 문의유형
  sctitle   VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
  sccontent MEDIUMTEXT  NOT NULL COMMENT '내용' -- 내용
)
COMMENT '고객센터';

-- 고객센터
ALTER TABLE tmk_sc
  ADD CONSTRAINT PK_tmk_sc -- 고객센터 기본키
    PRIMARY KEY (
      scno -- 게시글 번호
    );

ALTER TABLE tmk_sc
  MODIFY COLUMN scno INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시글 번호';

-- 장바구니
CREATE TABLE tmk_basket (
  bno  INTEGER NOT NULL COMMENT '장바구니 번호', -- 장바구니 번호
  uno  INTEGER NOT NULL COMMENT '사용자번호', -- 사용자번호
  pno  INTEGER NOT NULL COMMENT '상품 번호', -- 상품 번호
  bcnt INTEGER NOT NULL COMMENT '상품수량', -- 상품수량
  bcdt DATE    NOT NULL COMMENT '생성일' -- 생성일
)
COMMENT '장바구니';

-- 장바구니
ALTER TABLE tmk_basket
  ADD CONSTRAINT PK_tmk_basket -- 장바구니 기본키
    PRIMARY KEY (
      bno -- 장바구니 번호
    );

ALTER TABLE tmk_basket
  MODIFY COLUMN bno INTEGER NOT NULL AUTO_INCREMENT COMMENT '장바구니 번호';

-- 1:1문의
CREATE TABLE tmk_mtm (
  qno     INTEGER     NOT NULL COMMENT '문의 번호', -- 문의 번호
  uno     INTEGER     NOT NULL COMMENT '사용자번호', -- 사용자번호
  title   VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
  content MEDIUMTEXT  NOT NULL COMMENT '내용', -- 내용
  COL     DATE        NOT NULL COMMENT '등록일', -- 등록일
  qtype   INTEGER     NOT NULL COMMENT '문의유형', -- 문의유형
  qstatus INTEGER     NOT NULL COMMENT '처리상태' -- 처리상태
)
COMMENT '1:1문의';

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

ALTER TABLE tmk_mtm
  MODIFY COLUMN qno INTEGER NOT NULL AUTO_INCREMENT COMMENT '문의 번호';

-- 리뷰
CREATE TABLE tmk_review (
  rno      INTEGER    NOT NULL COMMENT '리뷰번호', -- 리뷰번호
  sno      INTEGER    NOT NULL COMMENT '가게 번호', -- 가게 번호
  uno      INTEGER    NOT NULL COMMENT '사용자번호', -- 사용자번호
  rcontent MEDIUMTEXT NOT NULL COMMENT '내용', -- 내용
  rscore   INTEGER    NOT NULL COMMENT '가게평가점수', -- 가게평가점수
  cdt      DATE       NOT NULL COMMENT '등록일' -- 등록일
)
COMMENT '리뷰';

-- 리뷰
ALTER TABLE tmk_review
  ADD CONSTRAINT PK_tmk_review -- 리뷰 기본키
    PRIMARY KEY (
      rno -- 리뷰번호
    );

ALTER TABLE tmk_review
  MODIFY COLUMN rno INTEGER NOT NULL AUTO_INCREMENT COMMENT '리뷰번호';

-- 카테고리
CREATE TABLE tmk_category (
  sno  INTEGER NOT NULL COMMENT '가게 번호', -- 가게 번호
  ctno INTEGER NOT NULL COMMENT '카테고리번호' -- 카테고리번호
)
COMMENT '카테고리';

-- 카테고리
ALTER TABLE tmk_category
  ADD CONSTRAINT PK_tmk_category -- 카테고리 기본키
    PRIMARY KEY (
      sno,  -- 가게 번호
      ctno  -- 카테고리번호
    );

-- 사용자
CREATE TABLE tmk_user (
  uno      INTEGER      NOT NULL COMMENT '사용자번호', -- 사용자번호
  name     VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  email    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  pwd      VARCHAR(50)  NOT NULL COMMENT '비밀번호', -- 비밀번호
  pst      VARCHAR(6)   NULL     COMMENT '우편번호', -- 우편번호
  addr     VARCHAR(255) NULL     COMMENT '기본주소', -- 기본주소
  det_addr VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
  tel      VARCHAR(30)  NULL     COMMENT '전화번호', -- 전화번호
  birth    VARCHAR(8)   NULL     COMMENT '생일', -- 생일
  status   INTEGER      NOT NULL COMMENT '계정상태', -- 계정상태
  auth     INTEGER      NOT NULL COMMENT '권한', -- 권한
  uphoto   VARCHAR(255) NULL     COMMENT '사진', -- 사진
  rdt      DATE         NOT NULL COMMENT '가입일' -- 가입일
)
COMMENT '사용자';

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

ALTER TABLE tmk_user
  MODIFY COLUMN uno INTEGER NOT NULL AUTO_INCREMENT COMMENT '사용자번호';

-- 관리자_카테고리
CREATE TABLE tmk_category_list (
  ctno   INTEGER     NOT NULL COMMENT '카테고리번호', -- 카테고리번호
  ctname VARCHAR(50) NOT NULL COMMENT '카테고리명' -- 카테고리명
)
COMMENT '관리자_카테고리';

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

ALTER TABLE tmk_category_list
  MODIFY COLUMN ctno INTEGER NOT NULL AUTO_INCREMENT COMMENT '카테고리번호';

-- 결제
CREATE TABLE tmk_pay_info (
  ono       INTEGER NOT NULL COMMENT '주문 번호', -- 주문 번호
  pmno      INTEGER NOT NULL COMMENT '결제수단번호', -- 결제수단번호
  mcuno     INTEGER NOT NULL COMMENT '할인쿠폰번호', -- 할인쿠폰번호
  tprice    INTEGER NOT NULL COMMENT '총상품금액', -- 총상품금액
  dis_price INTEGER NOT NULL COMMENT '할인금액', -- 할인금액
  lst_price INTEGER NOT NULL COMMENT '최종결제금액', -- 최종결제금액
  dprice    INTEGER NOT NULL COMMENT '배송비', -- 배송비
  pdt       DATE    NOT NULL COMMENT '결제일' -- 결제일
)
COMMENT '결제';

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

ALTER TABLE tmk_pay_info
  MODIFY COLUMN pmno INTEGER NOT NULL AUTO_INCREMENT COMMENT '결제수단번호';

-- 할인쿠폰
CREATE TABLE tmk_discount (
  cuno    INTEGER      NOT NULL COMMENT '쿠폰번호', -- 쿠폰번호
  cuname  VARCHAR(50)  NOT NULL COMMENT '쿠폰명', -- 쿠폰명
  cuprice INTEGER      NOT NULL COMMENT '할인금액', -- 할인금액
  cuexp   DATE         NOT NULL COMMENT '유효기간', -- 유효기간
  cuint   VARCHAR(255) NOT NULL COMMENT '쿠폰설명' -- 쿠폰설명
)
COMMENT '할인쿠폰';

-- 할인쿠폰
ALTER TABLE tmk_discount
  ADD CONSTRAINT PK_tmk_discount -- 할인쿠폰 기본키
    PRIMARY KEY (
      cuno -- 쿠폰번호
    );

ALTER TABLE tmk_discount
  MODIFY COLUMN cuno INTEGER NOT NULL AUTO_INCREMENT COMMENT '쿠폰번호';

-- 결제수단
CREATE TABLE tmk_payment (
  pmno   INTEGER     NOT NULL COMMENT '결제수단번호', -- 결제수단번호
  pmname VARCHAR(50) NOT NULL COMMENT '결제수단명' -- 결제수단명
)
COMMENT '결제수단';

-- 결제수단
ALTER TABLE tmk_payment
  ADD CONSTRAINT PK_tmk_payment -- 결제수단 기본키
    PRIMARY KEY (
      pmno -- 결제수단번호
    );

ALTER TABLE tmk_payment
  MODIFY COLUMN pmno INTEGER NOT NULL AUTO_INCREMENT COMMENT '결제수단번호';

-- 환불
CREATE TABLE tmk_refund (
  ono        INTEGER    NOT NULL COMMENT '주문 번호', -- 주문 번호
  ref_reason MEDIUMTEXT NOT NULL COMMENT '환불사유', -- 환불사유
  ref_date   DATE       NOT NULL COMMENT '처리일', -- 처리일
  ref_status INTEGER    NOT NULL COMMENT '처리상태' -- 처리상태
)
COMMENT '환불';

-- 환불
ALTER TABLE tmk_refund
  ADD CONSTRAINT PK_tmk_refund -- 환불 기본키
    PRIMARY KEY (
      ono -- 주문 번호
    );

-- 공지사항
CREATE TABLE tmk_notice (
  nno      INTEGER     NOT NULL COMMENT '공지번호', -- 공지번호
  ntitle   VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
  ncontent MEDIUMTEXT  NOT NULL COMMENT '내용', -- 내용
  ndate    DATE        NOT NULL COMMENT '등록일', -- 등록일
  nv_cnt   INTEGER     NULL     COMMENT '조회수' -- 조회수
)
COMMENT '공지사항';

-- 공지사항
ALTER TABLE tmk_notice
  ADD CONSTRAINT PK_tmk_notice -- 공지사항 기본키
    PRIMARY KEY (
      nno -- 공지번호
    );

ALTER TABLE tmk_notice
  MODIFY COLUMN nno INTEGER NOT NULL AUTO_INCREMENT COMMENT '공지번호';

-- 주문항목
CREATE TABLE tmk_order_product (
  ono    INTEGER NOT NULL COMMENT '주문 번호', -- 주문 번호
  pno    INTEGER NOT NULL COMMENT '상품 번호', -- 상품 번호
  price  INTEGER NOT NULL COMMENT '가격', -- 가격
  op_cnt INTEGER NOT NULL COMMENT '수량' -- 수량
)
COMMENT '주문항목';

-- 주문항목
ALTER TABLE tmk_order_product
  ADD CONSTRAINT PK_tmk_order_product -- 주문항목 기본키
    PRIMARY KEY (
      ono, -- 주문 번호
      pno  -- 상품 번호
    );

-- 상품찜
CREATE TABLE tmk_wishlist (
  uno  INTEGER NOT NULL COMMENT '사용자번호', -- 사용자번호
  pno  INTEGER NOT NULL COMMENT '상품 번호', -- 상품 번호
  wcdt DATE    NOT NULL COMMENT '생성일' -- 생성일
)
COMMENT '상품찜';

-- 상품찜
ALTER TABLE tmk_wishlist
  ADD CONSTRAINT PK_tmk_wishlist -- 상품찜 기본키
    PRIMARY KEY (
      uno, -- 사용자번호
      pno  -- 상품 번호
    );

-- 리뷰평가
CREATE TABLE tmk_rgb (
  uno   INTEGER NOT NULL COMMENT '사용자번호', -- 사용자번호
  rno   INTEGER NOT NULL COMMENT '리뷰번호', -- 리뷰번호
  rtype INTEGER NULL     COMMENT '평가유형', -- 평가유형
  rcdt  DATE    NOT NULL COMMENT '생성일' -- 생성일
)
COMMENT '리뷰평가';

-- 리뷰평가
ALTER TABLE tmk_rgb
  ADD CONSTRAINT PK_tmk_rgb -- 리뷰평가 기본키
    PRIMARY KEY (
      uno, -- 사용자번호
      rno  -- 리뷰번호
    );

-- 할인쿠폰발급
CREATE TABLE tmk_my_counpon (
  mcuno      INTEGER NOT NULL COMMENT '할인쿠폰번호', -- 할인쿠폰번호
  uno        INTEGER NOT NULL COMMENT '사용자번호', -- 사용자번호
  cuno       INTEGER NOT NULL COMMENT '쿠폰번호', -- 쿠폰번호
  mcudt      DATE    NOT NULL COMMENT '발급일', -- 발급일
  mcu_status INTEGER NULL     COMMENT '사용여부' -- 사용여부
)
COMMENT '할인쿠폰발급';

-- 할인쿠폰발급
ALTER TABLE tmk_my_counpon
  ADD CONSTRAINT PK_tmk_my_counpon -- 할인쿠폰발급 기본키
    PRIMARY KEY (
      mcuno -- 할인쿠폰번호
    );

ALTER TABLE tmk_my_counpon
  MODIFY COLUMN mcuno INTEGER NOT NULL AUTO_INCREMENT COMMENT '할인쿠폰번호';

-- 사용자 상품
CREATE TABLE tmk_user_product (
  pno  INTEGER NULL COMMENT '상품 번호', -- 상품 번호
  uno  INTEGER NULL COMMENT '사용자번호', -- 사용자번호
  COL  INTEGER NULL COMMENT '상품 수량', -- 상품 수량
  COL2 DATE    NULL COMMENT '등록일' -- 등록일
)
COMMENT '사용자 상품';

-- 가게
ALTER TABLE tmk_store_info
  ADD CONSTRAINT FK_tmk_user_TO_tmk_store_info -- 사용자 -> 가게
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

-- 주문
ALTER TABLE tmk_order
  ADD CONSTRAINT FK_tmk_user_TO_tmk_order -- 사용자 -> 주문
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES tmk_user ( -- 사용자
      uno -- 사용자번호
    );

-- 장바구니
ALTER TABLE tmk_basket
  ADD CONSTRAINT FK_tmk_user_TO_tmk_basket -- 사용자 -> 장바구니
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES tmk_user ( -- 사용자
      uno -- 사용자번호
    );

-- 장바구니
ALTER TABLE tmk_basket
  ADD CONSTRAINT FK_tmk_product_TO_tmk_basket -- 상품 -> 장바구니
    FOREIGN KEY (
      pno -- 상품 번호
    )
    REFERENCES tmk_product ( -- 상품
      pno -- 상품 번호
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

-- 환불
ALTER TABLE tmk_refund
  ADD CONSTRAINT FK_tmk_pay_info_TO_tmk_refund -- 결제 -> 환불
    FOREIGN KEY (
      ono -- 주문 번호
    )
    REFERENCES tmk_pay_info ( -- 결제
      ono -- 주문 번호
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