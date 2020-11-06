package com.eomcs.pms.handler;

import java.util.Map;

public class Request {
  String commandPath;
  Map<String, Object> context;

  public Request(String commandPath, Map<String, Object> context) {
    this.commandPath = commandPath;
    this.context = context;
  }


  public String getCommandPath() {
    return commandPath;
  }

  public void setCommandPath(String commandPath) {
    this.commandPath = commandPath;
  }

  public Map<String, Object> getContext() {
    return context;
  }

  public void setContext(Map<String, Object> context) {
    this.context = context;
  }

}
