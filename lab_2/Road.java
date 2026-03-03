/**
 *
 * @author user
 */
package com.mycompany.lab_2;

import java.util.Objects;

public class Road {
    private String name;
    private RoadType type;
    private int speedLimit;
    private Location L1,L2;
    public Road() {
    }

    public Road(String name, RoadType type, int speedLimit, Location L1, Location L2) {
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

    public RoadType getType() {
        return type;
    }
    
    public double getCost()
    {
        return 1.0/speedLimit;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.type);
        hash = 41 * hash + this.speedLimit;
        hash = 41 * hash + Objects.hashCode(this.L1);
        hash = 41 * hash + Objects.hashCode(this.L2);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Road other = (Road) obj;
        if (this.speedLimit != other.speedLimit) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.L1, other.L1)) {
            return false;
        }
        return Objects.equals(this.L2, other.L2);
    }

    
}
