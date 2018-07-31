package com.example.luca.prae_app.view.listeners;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Mapa;

public class MapaDownloadClickListener implements View.OnClickListener {

    private int mapaId;
    private Context context;

    public MapaDownloadClickListener(Context context, int mapaId){

        this.mapaId = mapaId;
        this.context = context;

    }
    @Override
    public void onClick(View view) {

        DownloadManager downloadManager = (DownloadManager) this.context.getSystemService(Context.DOWNLOAD_SERVICE);

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.context.getString(R.string.localhost)+"/baixarMapa/"+String.valueOf(this.mapaId)));

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        Long reference = downloadManager.enqueue(request);

    }
}
