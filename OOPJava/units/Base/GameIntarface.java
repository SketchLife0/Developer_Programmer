package units.Base;

import java.util.ArrayList;
import units.Base.BaseHeroes.BaseHero;
import units.Base.PlayingField;

/**
 * GameIntarface
 */
public interface GameIntarface {
    void step(ArrayList <BaseHero> allies, ArrayList <BaseHero> enemy, PlayingField map); 
    String getInfo();
} 