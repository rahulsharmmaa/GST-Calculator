package rstechnologies.ml.gstcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText p = (EditText)findViewById(R.id.price);
        final EditText g = (EditText)findViewById(R.id.gst);
        final EditText a = (EditText)findViewById(R.id.amount);

        btnCalc = (Button)findViewById(R.id.btn_calculate);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st1 = p.getText().toString();
                String st2 = g.getText().toString();
                if (TextUtils.isEmpty(st1))
                {
                    p.setError("Enter Price");
                    p.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(st2))
                {
                    g.setError("Enter GST percentage");
                    g.requestFocus();
                    return;
                }

                float P = Float.parseFloat(st1);
                float G = Float.parseFloat(st2);

                float Price = cal(P);

                float GST = calG(G,Price);

                float ans = ans1(Price, GST);

                a.setText(String.valueOf(ans));
            }
        });
    }

    private float ans1(float Price, float GST) {

        return (float)(Price+GST);


    }

    private float calG(float G,float Price) {

        return (float)(Price*(G/100));
    }

    private float cal(float P) {

        return (float) (P);
    }
}
