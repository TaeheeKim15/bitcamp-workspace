package com.eomcs.pms.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.eomcs.context.ApplicationContextListener;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.domain.Task;
import com.google.gson.Gson;

// 게시물, 회원, 프로젝트, 작업 데이터를 파일에서 로딩하고 파일로 저장하는 일을 한다.
public class DataHandlerListener implements ApplicationContextListener {

  // 스태틱 멤버들이 공유하는 변수가 아니라면 로컬 변수로 만들라.
  List<Board> boardList = new ArrayList<>();
  File boardFile = new File("./board.json"); // 게시글을 저장할 파일 정보

  List<Member> memberList = new LinkedList<>();
  File memberFile = new File("./member.json"); // 회원을 저장할 파일 정보

  List<Project> projectList = new LinkedList<>();
  File projectFile = new File("./project.json"); // 프로젝트를 저장할 파일 정보

  List<Task> taskList = new ArrayList<>();
  File taskFile = new File("./task.json"); // 작업을 저장할 파일 정보



  @Override
  public void contextInitialized(Map<String, Object> context) {
    // 애플리케이션의 서비스가 시작되면 먼저 파일에서 데이터를 로딩한다
    // 파일에서 데이터 로딩
    loadObjects(boardList, boardFile, Board[].class);
    loadObjects(memberList, memberFile, Member[].class);
    loadObjects(projectList, projectFile, Project[].class);
    loadObjects(taskList, taskFile, Task[].class);

   // 옵저버가 파일에서 데이터 (게시글, 회원, 프로젝트, 작업)를 읽어
    // List 컬렉션에 저장한 다음,
    // 발행자(App 객체)가 사용할  수 있도록 맵 객체에 담아서 공유한다
    context.put("boardList", boardList);
    context.put("memberList", memberList);
    context.put("projectList", projectList);
    context.put("taskList", taskList);
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {

    // 데이터를 파일에 저장
    saveObjects(boardList, boardFile);
    saveObjects(memberList, memberFile);
    saveObjects(projectList, projectFile);
    saveObjects(taskList, taskFile);

  }

  // 파일에서 JSON 문자열을 읽어 지정한 타입의 객체를 생성한 후 컬렉션에 저장한다.
  private static <T> void loadObjects(Collection<T> list, // 객체를 담을 컬렉션
      File file, // JSON 문자열이 저장된 파일
      Class<T[]> clazz // JSON 문자열을 어떤 타입의 배열로 만들 것인지 알려주는 클래스 정보
  ) {
    BufferedReader in = null;

    try {
      in = new BufferedReader(new FileReader(file));

      list.addAll(Arrays.asList(new Gson().fromJson(in, clazz)));

      System.out.printf("'%s' 파일에서 총 %d 개의 객체를 로딩했습니다.\n", file.getName(), list.size());

    } catch (Exception e) {
      System.out.printf("'%s' 파일 읽기 중 오류 발생! - %s\n", file.getName(), e.getMessage());

    } finally {
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }



  // 이제 더이상 저장할 객체를 CsvObject로 제한할 필요가 없다.
  // 어떤 타입의 객체든지 JSON 형식으로 변환할 수 있기 때문이다.
  private static void saveObjects(Collection<?> list, File file) {
    BufferedWriter out = null;

    try {
      out = new BufferedWriter(new FileWriter(file));

      // 컬렉션 객체를 통째로 JSON 문자열로 내보내기
      Gson gson = new Gson();
      String jsonStr = gson.toJson(list);
      out.write(jsonStr);

      out.flush();

      System.out.printf("총 %d 개의 객체를 '%s' 파일에 저장했습니다.\n", list.size(), file.getName());

    } catch (IOException e) {
      System.out.printf("객체를 '%s' 파일에  쓰는 중 오류 발생! - %s\n", file.getName(), e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
      }
    }
  }



}
