package ca.uqo.restoplex.data;

enum TABLE_STATE {}

record Table(long id, short capacity, TABLE_STATE state) {}
