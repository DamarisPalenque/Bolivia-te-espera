package damaris.example.com.proyectofinal;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by ARNOLD on 18/07/2015.
 */
public class ParseApplication extends Application{

    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "t7PsUuMjAZHtie24GFnGWbVWKScuaTXeFQwB2JZw", "fdnlhSTK9DX2iwXG0IIPtNV0WPyLAohzr0nw1qaf");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }
}
