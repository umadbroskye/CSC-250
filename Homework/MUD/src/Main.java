public class Main {
    public static void main(String[] args) {
        Player p = new Player("Mike");

        Room hall0 = new Room("Hall 0");
        Room hall1 = new Room("Hall 1");
        Room hall2 = new Room("Hall 2");
        Room hall3 = new Room("Hall 3");
        Room lab1 = new Room("Lab 1");
        Room lab2 = new Room("Lab 2");
        Room lasercutter = new Room("Laser Cutter");
        Room esports = new Room("Esports");
        Room lobby = new Room("Lobby");
        Room network = new Room("Network");
        Room s120 = new Room("S120");
        Room s118b = new Room("S118B");
        Room sodaroom = new Room("Soda Room");
        Room entrance = new Room("Entrance");

        Exit h1_ent = new Exit(hall1, "north", entrance, "south");
        hall1.addExit(h1_ent);
        entrance.addExit(h1_ent);

        Exit h1_h0 = new Exit(hall1, "east", hall0, "west");
        hall1.addExit(h1_h0);
        hall0.addExit(h1_h0);

        Exit h1_h2 = new Exit(hall1, "west", hall2, "east");
        hall1.addExit(h1_h2);
        hall2.addExit(h1_h2);

        Exit h0_s120 = new Exit(hall0, "east", s120, "west");
        hall0.addExit(h0_s120);
        s120.addExit(h0_s120);

        Exit h0_lob = new Exit(hall0, "south", lobby, "north");
        hall0.addExit(h0_lob);
        lobby.addExit(h0_lob);

        Exit h2_h3 = new Exit(hall2, "west", hall3, "east");
        hall2.addExit(h2_h3);
        hall3.addExit(h2_h3);

        Exit h3_sod = new Exit(hall3, "north", sodaroom, "south");
        hall3.addExit(h3_sod);
        sodaroom.addExit(h3_sod);

        Exit h3_l1 = new Exit(hall3, "west", lab1, "east");
        hall3.addExit(h3_l1);
        lab1.addExit(h3_l1);

        Exit h3_s118b = new Exit(hall3, "south", s118b, "north");
        hall3.addExit(h3_s118b);
        s118b.addExit(h3_s118b);

        Exit sod_l2 = new Exit(sodaroom, "west", lab2, "east");
        sodaroom.addExit(sod_l2);
        lab2.addExit(sod_l2);

        Exit lob_esp = new Exit(lobby, "east", esports, "west");
        lobby.addExit(lob_esp);
        esports.addExit(lob_esp);

        Exit lob_las = new Exit(lobby, "south", lasercutter, "north");
        lobby.addExit(lob_las);
        lasercutter.addExit(lob_las);

        Exit lob_net = new Exit(lobby, "west", network, "east");
        lobby.addExit(lob_net);
        network.addExit(lob_net);

        entrance.addPlayer(p);

        entrance.display();
    }
}
