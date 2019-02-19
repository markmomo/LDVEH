package markmomo.com.company;


import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) {
        Informations infos = new Informations();
        boolean personIsCreated = false;

       /* List<String> noms = new ArrayList<String>();
        noms.add("gobelin1");
        noms.add("gobelin2");

        List<Integer> hab = new ArrayList<Integer>();
        hab.add(9);
        hab.add(9);

        List<Integer> endu = new ArrayList<Integer>();
        endu.add(8);
        endu.add(8);

        Creatures creatures = new Creatures(2,noms,hab,endu);*/



        String perso = "marco";
        int habP = 10;
        int enduP = 12;
        int chanceP = 11;

        Personnage personnage = new Personnage(perso,habP,enduP,chanceP);



        /*Personnage personnage = new Personnage();
        personnage.creerPerso();*/


        Creatures creatures = new Creatures();
        creatures.configCreatures();

        for (int i = 0 ;i < 20;i++){
            personnage.infoStatsPersonnage();
            creatures.infoStatsCreatures();
            infos.titreCombat();
            infos.titreLancerCombatPerso();
            int p = personnage.lancerCombatPerso();
            if (p == 9999){
                infos.titreResultatCombat();
                System.out.println("num " + (i+1));
                creatures.infoCreatureMorte();
            }else {
                infos.titreLancerCombatCreature();
                int c = creatures.lancerCombatCrea();
                infos.titreResultatCombat();
                System.out.println("num " + (i+1));
                if(p > c){
                    creatures.infligerDommageCreatures();
                    creatures.infoDommageCreatures();
                }else if (p < c) {
                    personnage.infligerDommagePersonnage();
                    personnage.infoDommageCreatures();
                } else infos.matchNul();
            }

        }


        for (int i = 4; i > 0; i--){
            personnage.lancerChancePerso();
            personnage.infoTirageChancePersonnage();
        }



    }
}
