package units.Base;

import java.util.ArrayList;

import units.Base.BaseHeroes.BaseHero;

/**
 * GameIntarface
 */
public interface GameIntarface {
    void step(ArrayList <BaseHero> enemy); 
    String getInfo();
} 