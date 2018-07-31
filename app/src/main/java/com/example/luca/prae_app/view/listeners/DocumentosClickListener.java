package com.example.luca.prae_app.view.listeners;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.example.luca.prae_app.R;
import com.example.luca.prae_app.models.Documento;
import com.example.luca.prae_app.models.Secao;

public class DocumentosClickListener implements View.OnClickListener {

    private Context context;
    private Documento documento;

    public DocumentosClickListener(Context context,Documento documento){

        this.context = context;
        this.documento = documento;

    }


    @Override
    public void onClick(View view) {

        DownloadManager downloadManager = (DownloadManager) this.context.getSystemService(Context.DOWNLOAD_SERVICE);

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.context.getString(R.string.localhost)+"/baixarDocumento/"+String.valueOf(this.documento.getId())));

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        Long reference = downloadManager.enqueue(request);

    }

}
