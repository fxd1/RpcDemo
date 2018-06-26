package com.fengxiaodong.socket.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public void say(String info) {

        InputStream inputStream = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        Socket socket = null;
        try {
            socket = new Socket("localhost", 10086);

            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write(info);
            printWriter.flush();

            socket.shutdownOutput();
            inputStream = socket.getInputStream();

            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {

                System.out.println("client , server say is " + info);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            printWriter.close();
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
