package ca.uqo.restoplex.domain;

public final class Factory {
  private static class LazyHolder {
    private static final TablesController TABLES_CONTROLLER_INSTANCE = new TablesController();
    private static final KouizineController KOUIZINE_CONTROLLER_INSTANCE = new KouizineController();
  }

  private Factory() {}

  public static KouizineController getKouizineControllerInstance() {
    return LazyHolder.KOUIZINE_CONTROLLER_INSTANCE;
  }

  public static TablesController getTablesControllerInstance() {
    return LazyHolder.TABLES_CONTROLLER_INSTANCE;
  }
}
