package sg.edu.np.mad.madpractical3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListActivity extends AppCompatActivity {
    ImageView imgIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imgIcon = findViewById(R.id.icon);
        imgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(ListActivity.this, "yeah", Toast.LENGTH_SHORT).show();
                AlertDialog dialog = createDialog();
                dialog.show();
            }
        });
    }

        AlertDialog createDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("i cannot take this anymore");
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Random rand = new Random();
                int upperbound = 99999;
                int randInt = rand.nextInt(upperbound);
                String randNum = randInt + "";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("Key", randNum);
                startActivity(intent);
            }

        });
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(ListActivity.this, "closed", Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
        }


}