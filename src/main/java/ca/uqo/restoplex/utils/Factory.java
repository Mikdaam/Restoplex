package ca.uqo.restoplex.utils;

import ca.uqo.restoplex.domain.Kouizine;
import ca.uqo.restoplex.domain.OrderController;
import ca.uqo.restoplex.domain.TablesController;

public final class Factory {
  private static class LazyHolder { // TODO : Make a singleton class for each controller
    private static final TablesController TABLES_CONTROLLER_INSTANCE = new TablesController();
    private static final Kouizine KOUIZINE_INSTANCE = new Kouizine();
    private static final OrderController ORDER_CONTROLLER_INSTANCE = new OrderController();
  }

  private Factory() {}

  public static Kouizine getKouizineInstance() {
    return LazyHolder.KOUIZINE_INSTANCE;
  }

  public static TablesController getTablesControllerInstance() {
    return LazyHolder.TABLES_CONTROLLER_INSTANCE;
  }
  
  public static OrderController getOrderControllerInstance() {
	    return LazyHolder.ORDER_CONTROLLER_INSTANCE;
  }
}
