package ui;

import Exceptions.InvalidInputException;
import Exceptions.NothingFoundException;
import Exceptions.OutOfMoneyException;
import Exceptions.WrongChoiceException;
import model.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.net.URL;

public class Main extends JFrame {
    public static void main(String[] args) throws IOException {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Canada Soccer League");
        mainFrame.setSize(2000, 450);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon image = new ImageIcon("C:\\Users\\Min\\Downloads\\rsz_1rsz_1200px-canadian_soccer_association_logosvg.png");
        mainFrame.setLayout(new FlowLayout());
        Standings CanadaSoccerLeague = new Standings();
        CanadaSoccerLeague.setName("Canada Soccer League");
        Scanner scanner = new Scanner(System.in);

        //Gets data from web
        BufferedReader br = null;
        try {
            URL url = new URL("https://www.ugrad.cs.ubc.ca/~cs210/2018w1/welcomemsg.html");
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            System.out.println(sb);
        } finally {
            if (br != null) {
                br.close();
            }
        }

        JPanel seasonPanel = new JPanel();
        JLabel soccerPic = new JLabel("",image,JLabel.CENTER);
        seasonPanel.setLayout(new BoxLayout(seasonPanel, BoxLayout.PAGE_AXIS));
        seasonPanel.add(soccerPic);
        CurrentSeason season = new CurrentSeason(2018);
        JLabel seasonLabel = new JLabel(season.makeSeason());
        seasonPanel.add(seasonLabel);

        JLabel welcome = new JLabel("Welcome!");
        seasonPanel.add(welcome);
        lineBreaker();
        mainFrame.add(seasonPanel);

        JPanel introducePanel = new JPanel();
        introducePanel.setLayout(new BoxLayout(introducePanel, BoxLayout.PAGE_AXIS));
        JLabel introduce = new JLabel("===Participating Teams===");
        introducePanel.add(introduce);
        Team calgary = new Team("Calgary Reds", Color.red);
        CanadaSoccerLeague.addTeam(calgary);
        Player player1 = new Player(calgary, 5, "Min", 19, "Defender");
        Player player2 = new Player(calgary, 20, "Anna", 20, "Midfielder");
        Player player3 = new Player(calgary, 9, "Alan", 19, "Attacker");
        Player player4 = new Player(calgary, 1, "Louis", 19, "Goalkeeper");
        JLabel calgaryIntro = new JLabel(calgary.getTeamName());
        calgaryIntro.setForeground(Color.red);
        introducePanel.add(calgaryIntro);
        calgary.addPlayer(player1);
        calgary.addPlayer(player2);
        calgary.addPlayer(player3);
        calgary.addPlayer(player4);
        lineBreaker();

        Team toronto = new Team("Toronto Blues", Color.blue);
        CanadaSoccerLeague.addTeam(toronto);
        Player player5 = new Player(toronto, 26, "Blues Defender", 37, "Defender");
        Player player6 = new Player(toronto, 8, "Blues Midfielder", 40, "Midfielder");
        Player player7 = new Player(toronto, 9, "Blues Attacker", 40, "Attacker");
        Player player8 = new Player(toronto, 1, "Blues Goalkeeper", 36, "Goalkeeper");
        JLabel torontoIntro = new JLabel(toronto.getTeamName());
        torontoIntro.setForeground(Color.blue);
        introducePanel.add(torontoIntro);
        toronto.addPlayer(player5);
        toronto.addPlayer(player6);
        toronto.addPlayer(player7);
        toronto.addPlayer(player8);
        lineBreaker();

        Team vancouver = new Team("Vancouver Greens", Color.green);
        CanadaSoccerLeague.addTeam(vancouver);
        Player player9 = new Player(vancouver, 7, "Greens Midfielder", 17, "Midfielder");
        Player player10 = new Player(vancouver, 11, "Greens Attacker", 25, "Attacker");
        Player player11 = new Player(vancouver, 4, "Greens Defender", 30, "Defender");
        Player player12 = new Player(vancouver, 1, "Greens Goalkeeper", 26, "Goalkeeper");
        JLabel vancouverIntro = new JLabel(vancouver.getTeamName());
        vancouverIntro.setForeground(Color.green);
        introducePanel.add(vancouverIntro);
        vancouver.addPlayer(player9);
        vancouver.addPlayer(player10);
        vancouver.addPlayer(player11);
        vancouver.addPlayer(player12);
        lineBreaker();

        Team edmonton = new Team("Edmonton Oranges", Color.orange);
        CanadaSoccerLeague.addTeam(edmonton);
        Player player13 = new Player(edmonton, 8, "Oranges Midfielder", 26, "Midfielder");
        Player player14 = new Player(edmonton, 10, "Oranges Attacker", 27, "Attacker");
        Player player15 = new Player(edmonton, 2, "Oranges Defender", 27, "Defender");
        Player player16 = new Player(edmonton, 1, "Oranges Goalkeeper", 23, "Goalkeeper");
        edmonton.addPlayer(player13);
        edmonton.addPlayer(player14);
        edmonton.addPlayer(player15);
        edmonton.addPlayer(player16);
        JLabel edmontonIntro = new JLabel(edmonton.getTeamName());
        edmontonIntro.setForeground(Color.orange);
        introducePanel.add(edmontonIntro);
        lineBreaker();
        mainFrame.add(introducePanel);

        CanadaSoccerLeague.initializeStandings();

        /*
        while (true) {
            System.out.println("Would like to view team information? (Answer Y or N)");
            String yesOrNo = null;
            try {
                yesOrNo = scanner.nextLine();
                if (!(yesOrNo.equals("Y") || yesOrNo.equals("N"))) {
                    throw new InvalidInputException();
                }
            } catch (InvalidInputException e) {
                System.out.println("Invalid input. Please try again");
            }
            if (yesOrNo.equals("Y")) {
                System.out.print("Select a team: ");
                String input = scanner.nextLine();
                Team t;
                try {
                    t = CanadaSoccerLeague.lookForTeam(input);
                } catch (InvalidInputException e) {
                    System.out.println("That team does not exist");
                    continue;
                }
                t.printTeamPlayers();
            }
            if (yesOrNo.equals("N")) {
                break;
            }
        }
        */

        JPanel teaminfo = new JPanel();
        JLabel ask = new JLabel("Would like to view team information? (Answer Y or N)");
        teaminfo.add(ask);
        JTextField yesOrNo = new JTextField(5);
        teaminfo.add(yesOrNo);
        JButton jButton = new JButton("Answer");
        teaminfo.add(jButton);
        GUI.ComboBox comboBox = new GUI.ComboBox(CanadaSoccerLeague);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    if (!(yesOrNo.getText().equals("Y") || yesOrNo.getText().equals("N"))) {
                        throw new InvalidInputException();
                    }
                } catch (InvalidInputException e) {
                    ask.setText("Invalid input. Please try again. Use Y or N");
                    ask.paintImmediately(ask.getVisibleRect());
                }

                if (yesOrNo.getText().equals("Y")) {
                    ask.setText("Type N when you are done.");
                    if (comboBox.getParent() == null) {
                        teaminfo.add(comboBox);

                    }
                }
                if (yesOrNo.getText().equals("N")) {
                    mainFrame.remove(teaminfo);
                    mainFrame.revalidate();
                    mainFrame.repaint();
                }
            }
        });
        mainFrame.add(teaminfo);
        mainFrame.pack();

        UserManager userManager = new UserManager();
        User user;
        while (true) {
            System.out.println("Are you a new user? (Answer Y or N)");
            String answer;
            try {
                answer = scanner.nextLine();
                if (!(answer.equals("Y") || (answer.equals("N")))) {
                    throw new InvalidInputException();
                }
            } catch (InvalidInputException e) {
                System.out.println("Invalid input. Please try again");
                continue;
            }
            try {
                userManager.setUsers(loadUser());
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("");
            }
            if (answer.equals("Y")) {
                System.out.println("Please enter your name");
                String input = scanner.nextLine();

                user = new User(input);
                userManager.addUser(user);
                break;
            } else {
                try {
                    if (userManager.getUsers().size() == 0) {
                        System.out.println("There are no existing players. Please make a new user");
                        continue;
                    }
                    System.out.println("Please enter your name");
                    String input = scanner.nextLine();
                    user = userManager.lookForUser(input);
                    break;
                } catch (NothingFoundException e) {
                    System.out.println("That user does not exist.");
                }
            }
        }
        saveUser(userManager.getUsers());


        Game bet = new Game();
        for (Team t : CanadaSoccerLeague.getTeams().values()) {
            try {
                t.setPoints(t.loadPointsStats());
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("");            }
        }
        while (true) {
            System.out.println("1.Bet 2.See Balance 3.View standings 4.Exit");
            try {
                bet.setAmount(loadBet());
                if(bet.getAmount()==0) {
                    System.out.println("You have zero coins");
                    bet.gameOver();
                }
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("");
            }
            int option = 0;
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
            }
            scanner.nextLine();
            if (option == 1) {
                bet.addObserver(user);
                System.out.print("Select the team you want to bet on: ");
                String selectTeam = scanner.nextLine();
                try {
                    Team tt = CanadaSoccerLeague.lookForTeam(selectTeam);
                    bet.setBetTeam(tt);
                } catch (InvalidInputException e) {
                    System.out.println("That team does not exist");
                    continue;
                }
                System.out.println("How much money do you want to bet?");
                try {
                    int betAmount = scanner.nextInt();
                    bet.betting(betAmount);
                    bet.startGame(CanadaSoccerLeague);
                    saveAmount(bet);
                    saveBetStats(user, bet);
                    for (Team t : CanadaSoccerLeague.getTeams().values())
                        t.savePointsStats();
                } catch (OutOfMoneyException e) {
                    System.out.println("Insufficient coins");
                } catch (InvalidInputException e) {
                    System.out.println("Please bet at least one coin");
                } catch (InputMismatchException e) {
                    System.out.println("Please enter an integer greater than 0");
                    scanner.nextLine();
                } finally {
                    System.out.println("Please continue");
                }
            } else if (option == 2) {
                System.out.println("Your balance is: " + bet.getAmount() + "coins :)");
            } else if (option == 3) {
                for (Team t : CanadaSoccerLeague.getTeams().values()) {
                    try {
                        t.setPoints(t.loadPointsStats());
                    } catch (ClassNotFoundException | IOException e) {
                        System.out.println("");
                    }
                }
                CanadaSoccerLeague.decideStandings();
                CanadaSoccerLeague.displayStandings();
            } else if (option == 4) {
                System.exit(0);
            } else
                try {
                    throw new WrongChoiceException();
                } catch (InvalidInputException e) {
                    System.out.println("Invalid input. Please try again");
                }
        }
    }

    public static void saveUser(HashMap<String, User> users) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("userlist.txt"));
        out.writeObject(users);
        out.close();
    }

    public static HashMap<String, User> loadUser() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("userlist.txt"));
        HashMap<String, User> users = (HashMap<String, User>) in.readObject();
        in.close();
        return users;
    }

    public static void saveAmount(Bet bet) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("bet.txt"));
        out.writeObject(bet.getAmount());
        out.close();
    }

    public static int loadBet() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("bet.txt"));
        int amount = (int) in.readObject();
        in.close();
        return amount;
    }

    public static void saveBetStats(User user, Bet bet) throws IOException {
        PrintWriter out = new PrintWriter(new FileOutputStream("betstats.txt", true));
        out.println(user.getName() + "'s number of coins: " + bet.getAmount());
        out.close();
    }

    public static void loadBetStats() {
        Paths.get("betstats.txt");
    }

    private static void lineBreaker() {
        System.out.println("");
    }
}

