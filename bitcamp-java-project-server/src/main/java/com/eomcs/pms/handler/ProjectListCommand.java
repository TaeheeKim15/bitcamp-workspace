package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.service.ProjectService;

public class ProjectListCommand implements Command {

  ProjectService projectService;


  public ProjectListCommand(ProjectService projectService) {
    this.projectService = projectService;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in, Map<String,Object> context) {
    out.println("[프로젝트 목록]");

    try {
      List<Project> list = projectService.list();
      for (Project project : list) {
        out.printf("%d, %s, %s, %s, %s, [%s]\n",
            project.getNo(),
            project.getTitle(),
            project.getStartDate(),
            project.getEndDate(),
            project.getOwner(),
            project.getMembers());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
