package com.guru.sishyan.models;

import lombok.Setter;

@Setter
public class Request {
    String description;
    Coordinate location;
    String area;
    Boolean isResolved=false;
    RequestType requestType;
    Hub hub=null;
}
