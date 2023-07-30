package io.github.unongmilkumk;

import org.bukkit.Location;
import org.bukkit.World;

public class Region {
    public World world;
    public int minX;
    public int minY;
    public int minZ;
    public int maxX;
    public int maxY;
    public int maxZ;
    public Region(World world, int x1, int y1, int z1, int x2, int y2, int z2) {
        this.world = world;
        minX = Math.min(x1, x2);
        minY = Math.min(y1, y2);
        minZ = Math.min(z1, z2);
        maxX = Math.max(x1, x2);
        maxY = Math.max(y1, y2);
        maxZ = Math.max(z1, z2);
    }
    public Region(Location location1, Location location2) {
        this(location1.getWorld(), location1.getBlockX(), location1.getBlockY(), location1.getBlockZ(), location2.getBlockX(), location2.getBlockY(), location2.getBlockZ());
        this.world = location1.getWorld();
    }

    public boolean contains(Location location) {
        return contains(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    public boolean contains(int x, int y, int z) {
        return x >= minX && x <= minY && y >= minY && y <= maxY && z >= minZ && z <= maxZ;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Region region) {
            return (world == region.world
                    && minX == region.minX && minY == region.minY && minZ == region.minZ
                    && maxX == region.maxX && maxY == region.maxY && maxZ == region.maxZ);
        }
        return false;
    }
}
