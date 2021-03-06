package com.app.sports.stats.sportstat.app.client;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import com.app.sports.stats.sportstat.app.R;
import com.app.sports.stats.sportstat.app.backendlessObjects.Player;
import com.app.sports.stats.sportstat.app.backendlessUtil.BackendSettings;
import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;


/**
 * Created by Padraic Cashin on 25/02/2016.
 */

public class CreatePlayer extends AppCompatActivity implements View.OnClickListener {

    private EditText etPlayerName;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.player_create);

            etPlayerName = (EditText) findViewById(R.id.etPlayerName);
            Button bSubmit = (Button) findViewById(R.id.bSubmit);

            bSubmit.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.bSubmit:

                    String playerToBeCreated = etPlayerName.getText().toString();
                    createPlayer(playerToBeCreated);

                    break;
            }
        }


    public void createPlayer(final String playerName) {

        final Player player = new Player();
        player.setPlayerName(playerName);

        Backendless.initApp(this, BackendSettings.APP_ID, BackendSettings.SECRET_KEY, BackendSettings.VERSION);

        // save object synchronously
        /*Backendless.Persistence.save( playerName );*/

        // save object asynchronously
        Backendless.Persistence.save(player, new AsyncCallback<Player>(){

            public void handleResponse( Player response )
            {
                System.out.println("new player instance has been created called : " + player.getPlayerName());
            }

            public void handleFault( BackendlessFault fault )
            {
                System.out.println("an error has occurred, the error code can be retrieved with fault.getCode(): "
                        + fault.getCode() + ": " + fault.getMessage());
            }
        });
    }
}

