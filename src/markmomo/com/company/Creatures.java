package markmomo.com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Creatures {
    Informations infos = new Informations();
    private Dice dice6 = new Dice(6);
    private Scanner sc = new Scanner(System.in);

    private int nombre;
    private List<String> nom = new ArrayList<String>();
    private List<Integer> habilete = new ArrayList<Integer>();
    private List<Integer> endurance = new ArrayList<Integer>();

    public Creatures() {
    }

    public Creatures(int nombre, List<String> nom, List<Integer> habilete, List<Integer> endurance) {
        this.nombre = nombre;
        this.nom = nom;
        this.habilete = habilete;
        this.endurance = endurance;
    }

    public int getNombre() {
        return nombre;
    }

    public List<String> getNom() {
        return nom;
    }

    public List<Integer> getHabilete() {
        return habilete;
    }

    public List<Integer> getEndurance() {
        return endurance;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public void setNom(List<String> nom) {
        this.nom = nom;
    }

    public void setHabilete(List<Integer> habilete) {
        this.habilete = habilete;
    }

    public void setEndurance(List<Integer> endurance) {
        this.endurance = endurance;
    }

    private int demanderNombre(){
        System.out.println("veuillez entrer le nombre de créatures");
        this.nombre = sc.nextInt();
        return this.nombre;
    }

    private List<String> demanderNom(){
        for (int i = this.nombre ;i > 0;i--) {
            System.out.println("veuillez entrer le nom de la créature");
            this.nom.add(sc.next());
        }return this.nom;
    }

    private List<Integer> demanderHab() {
        for (int i = nombre; i > 0; i--) {
            System.out.println("veuillez entrer l'habileté de la créature");
            this.habilete.add(Integer.parseInt((sc.next())));
        }
        return this.habilete;
    }

    private List<Integer> demanderEndu() {
        for (int i = nombre ;i > 0;i--) {
            System.out.println("veuillez entrer l'endurance de la créature");
            this.endurance.add(Integer.parseInt((sc.next())));
        }
        return this.endurance;
    }


    public void configCreatures () {
        infos.titreCreationCreatures();
        this.demanderNombre();
        this.demanderNom();
        this.demanderHab();
        this.demanderEndu();
    }

    public int lancerCombatCrea(){
        int lancer1 = dice6.lancer();
        int lancer2 = dice6.lancer();
        System.out.println("des1 = " + lancer1 + "     " + "des2 = "+ lancer2 + "     " + "hab = " + this.habilete);
        System.out.println("Score combat "+ this.nom.get(0) + " " + (lancer1 + lancer2 + this.habilete.get(0)));
        return lancer1 + lancer2 + this.habilete.get(0);
    }

    public void infligerDommageCreatures (){
        int z = this.endurance.get(0)-2;
        this.endurance.remove(0);
        this.endurance.add(0,z);
    }

    public void infoStatsCreatures (){
        System.out.println("                                                    ");
        System.out.println("---------------------------------------------------");
        System.out.println("STATS CREATURES");
        System.out.println("---------------------------------------------------");
        System.out.println("Nom : " + this.getNom());
        System.out.println("Hab : " + this.getHabilete());
        System.out.println("Endu : " + this.getEndurance());
    }

    public void infoDommageCreatures (){
        System.out.println(this.getNom().get(0) + " perd 2 pt ENDU");
        System.out.println("il passe a " + this.getEndurance());
    }

    public void infoCreatureMorte (){
        System.out.println(this.getNom().get(0) + " EST MORT !!!!");
    }


}
