package com.fengxiaodong.socket.demo1;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Client client = new Client();
        Server server = new Server();
        server.server();
        Scanner in = new Scanner(System.in);
        String next = in.next();
        System.out.println(next);
        client.say(next);

    }
}
