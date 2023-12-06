package ca.uqo.restoplex.domain;

public final class Factory {
  private static class LazyHolder {
    private static final TablesController TABLES_CONTROLLER_INSTANCE = new TablesController();
  }

  private Factory() {}

  public static TablesController getTablesControllerInstance() {
    return LazyHolder.TABLES_CONTROLLER_INSTANCE;
  }
}
