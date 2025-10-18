package Client;

import Server.UserList;

import java.rmi.Naming;
import java.util.Scanner;
import java.util.logging.Logger;

public class UserClient {
    private static Logger logger = Logger.getLogger("global");

    public static void main(String[] args) {
        try {
            logger.info("UserClient starting");
            UserList userList=(UserList) Naming.lookup("UserServer");
            Scanner sc=new Scanner(System.in);
            while(true) {
                System.out.println("Scegli:\nadd *user* -> Aggiungi utente\ndelete *user* -> Rimuovi utente\nlist -> Stampa lista\nstop -> Termina il programma");
                String temp=sc.nextLine();
                String[] s = temp.split(" ");
                switch (s[0]) {
                    case "add":
                        userList.addUser(s[1]);
                        break;
                    case "delete":
                        userList.removeUser(s[1]);
                        break;
                    case "list":
                        System.out.println(userList.getUsers());
                        break;
                    case "stop":
                        System.exit(0);
                    default:
                        System.err.println("invalid command");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}