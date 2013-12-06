package com.akshai.cowsandbulls;

//import com.akshai.cowsandbulls.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
//import android.view.View;
import android.widget.Button;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity {
	
	 	int copy_R;
	 	int count=0;
	    int b[]=new int[3];
	    String turns[]={"","","","","","",""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int upper=987;
    	int lower=102;
    	do{
    	int R = (int) ((Math.random() * (upper - lower)) + lower);
    	copy_R=R;
    	
    	for(int i=0;i<3;i++){
    		
    		b[2-i]=R%10;
    		R=R/10;
    		}
    		}
    	while(b[0]==b[1]||b[1]==b[2]||b[0]==b[2]);
        }
    
   
    //public void selectno(){
    	//EditText guessvalue=(EditText)findViewById(R.id.guessbox);
    	//Integer num=Integer.parseInt(guessvalue.getText().toString());
    	//TextView result=(TextView)findViewById(R.id.result);
    	/*EditText guessbox=(EditText)findViewById(R.id.guessbox);
    	guessbox.setVisibility(View.VISIBLE);
    	Button hit=(Button)findViewById(R.id.hit);
    	hit.setVisibility(View.VISIBLE);
    	TextView result=(TextView)findViewById(R.id.result);
    	result.setVisibility(View.VISIBLE);
    	Button startgame=(Button)findViewById(R.id.startgame);
    	startgame.setVisibility(View.INVISIBLE);*/
    	
	/*int upper=987;
	int lower=102;
	do{
	int R = (int) ((Math.random() * (upper - lower)) + lower);
	copy_R=R;
	
	for(int i=0;i<3;i++){
		
		b[2-i]=R%10;
		R=R/10;
		}
		}
	while(b[0]==b[1]||b[1]==b[2]||b[0]==b[2]);
    }*/
    public void restartapp(View v){
    	Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
   i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
   startActivity(i);
    }
public void showresults(View v){
	count++;
	
	EditText guessvalue=(EditText)findViewById(R.id.guessbox);
	Integer num=Integer.parseInt(guessvalue.getText().toString());
	TextView result=(TextView)findViewById(R.id.result);
	int copy_num=num;
	int a[]=new int[3];
	//int b[]=new int[3];
	Integer cows=0,bulls=0;
	/*int copy_R;
	int upper=987;
	int lower=102;
	do{
	int R = (int) ((Math.random() * (upper - lower)) + lower);
	copy_R=R;
	
	for(int i=0;i<3;i++){
		
		b[2-i]=R%10;
		R=R/10;
		}
		}
	while(b[0]==b[1]||b[1]==b[2]||b[0]==b[2]);
	*/
	
		
		for(int i=0;i<3;i++){
			a[2-i]=copy_num%10;
			copy_num=copy_num/10;
			}
			
	if(a[0]==a[1]||a[1]==a[2]||a[0]==a[2])
	{
		result.setText("Enter a three digit number with distinct digits!!!\n Don't worry you didn't lose a turn...");
		count--;
	}
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<3;j++)
		{
			if(a[i]==b[j]&&i==j)
				bulls++;
			if(a[i]==b[j]&&i!=j)
				cows++;
				
		}
	}
	if(num<102||num>987)
	{
		result.setText("Enter a three digit number with distinct digits!!!\n Don't worry you didn't lose a turn...");
		count--;
	}
	else{
		if(bulls==3){
		result.setText("You win!!! The number was---"+copy_R);
		Button hit=(Button)findViewById(R.id.hit);
    	hit.setVisibility(View.INVISIBLE);
    	Button exitbutton=(Button)findViewById(R.id.exitbutton);
    	exitbutton.setVisibility(View.VISIBLE);
    	
    	guessvalue.setVisibility(View.INVISIBLE);
	}
		else{
	
	turns[count-1]=num.toString()+"-->"+bulls.toString()+"--BULL(S)--&--"+cows.toString()+"--COW(S)";
	if(count==1)
	{
		result.setText(turns[0]);
	}
	if(count==2)
	{
		result.setText(turns[1]+"\n"+turns[0]);
	}
	if(count==3)
	{
		result.setText(turns[2]+"\n"+turns[1]+"\n"+turns[0]);
	}
	if(count==4)
	{
		result.setText(turns[3]+"\n"+turns[2]+"\n"+turns[1]+"\n"+turns[0]);
	}
	if(count==5)
	{
		result.setText(turns[4]+"\n"+turns[3]+"\n"+turns[2]+"\n"+turns[1]+"\n"+turns[0]);
	}
	
	if(count==6)
	{
		result.setText(turns[5]+"\n"+turns[4]+"\n"+turns[3]+"\n"+turns[2]+"\n"+turns[1]+"\n"+turns[0]);
	}
	if(count==7)
	{
		Button hit=(Button)findViewById(R.id.hit);
    	hit.setVisibility(View.INVISIBLE);
    	Button exitbutton=(Button)findViewById(R.id.exitbutton);
    	exitbutton.setVisibility(View.VISIBLE);
    	guessvalue.setVisibility(View.INVISIBLE);
		result.setText(turns[6]+"\n"+turns[5]+"\n"+turns[4]+"\n"+turns[3]+"\n"+turns[2]+"\n"+turns[1]+"\n"+turns[0]+"\nGAME OVER!!! The number was"+copy_R);
		
	
	}
	}
		}
	//result.setText("---"+num.toString()+"---"+bulls.toString()+"---BULL(S)---AND---"+cows.toString()+"---COW(S)"+copy_R);
}

/*public int randomize()
{
	
	int b[] = null;
int R = (int) ((Math.random() * (upper - lower)) + lower);
int copy_R=R;

for(int i=0;i<3;i++){
	
	b[2-i]=R%10;
	R=R/10;
	}
if(b[0]==b[1]||b[1]==b[2]||b[0]==b[2]){
	
	return randomize();
}
return copy_R;
}*/
   
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
