package com.eomcs.pms.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.pms.domain.Board;

// Mybatis 적용

public class BoardDaoImpl implements com.eomcs.pms.dao.BoardDao{

  SqlSessionFactory sqlSessionFactory;

  public BoardDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public int insert(Board board) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

      // => SqlSession 객체에 insert SQL 문을 실행하라고 명령한다.
      return sqlSession.insert("BoardDao.insert", board);
    }
  }

  @Override
  public int delete(int no) throws Exception {

    // 커밋과 관련된거기때문에 공유하면 안됨
    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
      return sqlSession.delete("BoardDao.delete", no);
    }
  }

  @Override
  public Board findByNo(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
      Board board = sqlSession.selectOne("BoardDao.findByNo", no);
      sqlSession.update("BoardDao.updateViewCount", no);
      return board;
    }
  }
  @Override
  public List<Board> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("BoardDao.findAll", keyword);
    }
  }

  @Override
  public int update(Board board) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
      return sqlSession.update("BoardDao.update", board);
    }
  }
}








