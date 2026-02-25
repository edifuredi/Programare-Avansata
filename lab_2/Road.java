/**
 *
 * @author user
 */
package com.mycompany.lab_2;
public class Road {
    private String name;
    private String type;
    private int speedLimit;
    private Location L1,L2;
    public Road() {
    }

    public Road(String name, String type, int speedLimit, Location L1, Location L2) {
        this.name = name;
        this.type = type;
        this.speedLimit = speedLimit;
        this.L1 = L1;
        this.L2 = L2;
    }

    public String getName() {
        return name;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getL1() {
        return L1;
    }

    public Location getL2() {
        return L2;
    }

    @Override
    public String toString() {
        return "Road{" + "name=" + name + ", type=" + type + ", speedLimit=" + speedLimit + ", L1=" + L1 + ", L2=" + L2 + '}';
    }
    
}
