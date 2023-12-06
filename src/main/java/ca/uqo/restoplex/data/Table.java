package ca.uqo.restoplex.data;

enum TABLE_STATE {FREE, ORDERING, OCCUPIED}

record Table(long id, short capacity, TABLE_STATE state) {}
