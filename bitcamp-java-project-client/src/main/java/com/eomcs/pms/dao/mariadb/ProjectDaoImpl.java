package com.eomcs.pms.dao.mariadb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.pms.domain.Project;

public class ProjectDaoImpl implements com.eomcs.pms.dao.ProjectDao {

  SqlSessionFactory sqlSessionFactory;


  public ProjectDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public int insert(Project project) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      // 프로젝트 정보 입력
      return sqlSession.insert("ProjectDao.insert", project);
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("ProjectDao.delete", no);
    }
  }

  @Override
  public Project findByNo(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("ProjectDao.findByNo", no);
    }
  }

  @Override
  public List<Project> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("ProjectDao.findAll", keyword);
    }
  }


  @Override
  public List<Project> findByDetailKeyword(Map<String,Object> keywords) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("ProjectDao.findByDetailKeyword", keywords);
    }
  }

  @Override
  public int update(Project project) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("ProjectDao.update", project);

    }
  }

  @Override
  public int deleteMembers(int projectNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("ProjectDao.delete", projectNo);
    }
  }

  @Override
  public int insertMembers(Project project) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("ProjectDao.insertMembers", project);
    }
  }
}

