package sg.edu.np.mad.madpractical3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    Button btnFollowed;
    Boolean followed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnFollowed = findViewById(R.id.followButton);
        btnFollowed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(followed){
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                    followed = false;
                    btnFollowed.setText("FOLLOW");
                }
                else{
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                    followed = true;
                    btnFollowed.setText("UNFOLLOW");
                }
            }
        });

    }
}
//        Boolean followed = false;
//
//            };
//    };
