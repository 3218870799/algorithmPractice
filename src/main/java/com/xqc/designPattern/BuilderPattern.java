package com.xqc.designPattern;

import lombok.Builder;
import lombok.Data;

public class BuilderPattern {
    public static void main(String[] args) {
        House house = new House.HouseBuilder.wall(new Wall()).window(new Window()).door(new Door()).build();
    }
}
@Data
@Builder
class House{
    private Window window;
    private Door door;
    private Wall wall;
}
class Window{

}
class Door{

}
class Wall{

}
