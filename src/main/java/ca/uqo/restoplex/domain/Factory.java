package ca.uqo.restoplex.domain;

public final class Factory {
  private static class LazyHolder {
    private static final TablesController TABLES_CONTROLLER_INSTANCE = new TablesController();
    private static final Kouizine KOUIZINE_INSTANCE = new Kouizine();
  }

  private Factory() {}

  public static Kouizine getKouizineInstance() {
    return LazyHolder.KOUIZINE_INSTANCE;
  }

  public static TablesController getTablesControllerInstance() {
    return LazyHolder.TABLES_CONTROLLER_INSTANCE;
  }
}
