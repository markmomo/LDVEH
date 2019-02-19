package markmomo.com.company;


import java.util.Scanner;

public class Personnage{
    private Informations infos = new Informations();
    private Dice dice6 = new Dice(6);
    private int lancer1;
    private int lancer2;
    private Scanner sc = new Scanner(System.in);

    private String nom;
    private int habilete;
    private int endurance;
    private int chance;

    public Personnage() {
    }

    public Personnage(String nom, int habilete, int endurance, int chance) {
        this.nom = nom;
        this.habilete = habilete;
        this.endurance = endurance;
        this.chance = chance;
    }

    public String getNom() {
        return nom;
    }

    public int getHabilete() {
        return habilete;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getChance() {
        return chance;
    }

    private String demanderNom(){
        System.out.println("veuillez entrer le nom du personnage");
        this.nom = sc.next();
        return this.nom;
    }

    private int demanderHab(){
        System.out.println("veuillez entrer l'habileté du personnage");
        this.habilete = sc.nextInt();
        return this.habilete;
    }

    private int demanderEndu(){
        System.out.println("veuillez entrer l'endurance du personnage");
        this.endurance = sc.nextInt();
        return this.endurance;
    }

    private int demanderChance(){
        System.out.println("veuillez entrer la chance du personnage");
        this.chance = sc.nextInt();
        return this.chance;
    }

    public void configurerPersonnage (){
        this.demanderNom();
        this.demanderHab();
        this.demanderEndu();
        this.demanderChance();
    }

    public void creerPerso(){
        this.demanderNom();

        infos.titreIirageCreationPersoHabilete();
        lancer1 = dice6.lancer();
        this.habilete = lancer1 + 6;
        System.out.println("des1 = " + lancer1 + " hab = " + this.habilete);

        infos.titreIirageCreationPersoEndurance();
        lancer1 = dice6.lancer();
        lancer2 = dice6.lancer();
        this.endurance = lancer1 + lancer2 + 12;
        System.out.println("des1 = " + lancer1 + "     " + "des2 = "+ lancer2 + "     " + "end = " + this.endurance);

        infos.titreIirageCreationPersoChance();
        lancer1 = dice6.lancer();
        this.chance = lancer1 + 6;
        System.out.println("des1 = " + lancer1 + " cha = " + this.chance);

    }

    public int lancerCombatPerso(){
        lancer1 = dice6.lancer();
        lancer2 = dice6.lancer();
        System.out.println("des1 = " + lancer1 + "     " + "des2 = "+ lancer2 + "     " + "hab = " + this.habilete);
        if (lancer1 == lancer2){
            System.out.println("COUP MORTEL !!!!!!!!!!");
            return 9999;
        }else {
            System.out.println("Score combat "+ this.nom + " " + (lancer1 + lancer2 + this.habilete));
            return lancer1 + lancer2 + this.habilete;
        }
    }



    public boolean lancerChancePerso(){
        lancer1 = dice6.lancer();
        lancer2 = dice6.lancer();
        return ((lancer1 + lancer2) <= this.chance);
    }

    public void infoTirageChancePersonnage (){
        System.out.println("                                                    ");
        System.out.println("---------------------------------------------------");
        System.out.println("LANCER CHANCE PERSO");
        System.out.println("---------------------------------------------------");
        System.out.println("des1 = " + lancer1 + "     " + "des2 = "+ lancer2 + "     " + "cha = " + this.chance);
        System.out.println("Score chance "+ this.nom + " " + (lancer1 + lancer2));
        System.out.println(this.nom + " est chanceux " + (lancer1 + lancer2 <= this.chance));
    }

    public void infligerDommagePersonnage(){
        this.endurance = this.endurance -1;
    }

    public void infoStatsPersonnage (){
        System.out.println("                                                    ");
        System.out.println("---------------------------------------------------");
        System.out.println("STATS PERSONNAGE");
        System.out.println("---------------------------------------------------");
        System.out.println("Nom : " + this.getNom());
        System.out.println("Hab : " + this.getHabilete());
        System.out.println("Endu : " + this.getEndurance());
        System.out.println("Chance : " +this.getChance());
    }

    public void infoDommageCreatures (){
        System.out.println(this.getNom() + " perd 1 pt ENDU");
        System.out.println("il passe a " + this.getEndurance());
    }

}


