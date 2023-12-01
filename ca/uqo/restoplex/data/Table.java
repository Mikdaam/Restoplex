package ca.uqo.restoplex.data;

// TODO @Enumerated(EnumType.STRING) au dessus du champ de type TABLE_STATE dans la classe Entity
enum TABLE_STATE {FREE, ORDERING, OCCUPIED}

record Table(long id, short capacity, TABLE_STATE state) {}
