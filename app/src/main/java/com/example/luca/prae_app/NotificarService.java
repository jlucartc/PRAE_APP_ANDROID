package com.example.luca.prae_app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class NotificarService extends Service {
    public NotificarService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
