package xyz.fluxinc.gravestonexpcompat;

public class Helper {

    public static int calculateExperience(int experience) {
        return (int) Math.floor(experience * Config.xpMultiplier);
    }
}
