package units;

import units.Base.BaseHeroes.BaseHero;

/**Селюк*/
public class Villager extends BaseHero{
    {
        super.speciality = "Селюк";
        super.weapon = "fork";
    }
    private int delivery = 1;


    public Villager(String name){
        super.name = name;
    }
    
    public Villager(){
        super.name = "Безымянный";
    }
}


// if (command != 0){
//     switch (command) {
//         case 1:
//             if(iter2.hasNext()){
//                 BaseHero b = iter2.next();
//                 System.out.println(a.getSpeed() > b.getSpeed() ? a : b);
//                 command = a.getSpeed() > b.getSpeed() ? 2 : 1;
//                 s = a.getSpeed() > b.getSpeed() ? b.getSpeed() : a.getSpeed();
//             }
//             else System.out.println(a);
//                 break;
        
//         case 2:
//             if(iter1.hasNext()){
//                 BaseHero a = iter1.next();
//                 System.out.println(a.getSpeed() > b.getSpeed() ? a : b);
//                 command = a.getSpeed() > b.getSpeed() ? 2 : 1;
//                 s = a.getSpeed() > b.getSpeed() ? b.getSpeed() : a.getSpeed();
//             }
//             else System.out.println(a);
//             break;

//         default:
//             break;
// }}
// if(iter1.hasNext()){
//     BaseHero a = iter1.next();
//     if(a.getSpeed() < s)
//     if(iter2.hasNext()){
//         BaseHero b = iter2.next();
//         System.out.println(a.getSpeed() > b.getSpeed() ? a : b);
//         s = a.getSpeed() > b.getSpeed() ? b.getSpeed() : a.getSpeed();
//     }
//     else System.out.println(a);
// }
// else System.out.println(iter2.next());
// }