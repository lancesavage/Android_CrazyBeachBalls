package edu.csci153.crazybeachballs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class CrazyBeachballs extends Activity {
    /** Called when the activity is first created. */
	
	boolean sflag1;
	boolean sflag2;
	boolean sflag3;
	boolean sflag4;
	
	int aFlag;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //define widgets
        
        final Button rotateBtn = (Button)findViewById(R.id.rotateBtn);
        
        final Button alphaBtn = (Button)findViewById(R.id.alphaBtn);
        
        final Button translateBtn = (Button)findViewById(R.id.translateBtn);
        
        final Button scaleBtn = (Button)findViewById(R.id.scaleBtn);
        
        final ImageView ivR = (ImageView)findViewById(R.id.rotateIV);
        final ImageView ivA = (ImageView)findViewById(R.id.alphaIV);
        final ImageView ivT = (ImageView)findViewById(R.id.translateIV);
        final ImageView ivS = (ImageView)findViewById(R.id.scaleIV);
        
        ivR.setAdjustViewBounds(true);
        ivA.setAdjustViewBounds(true);
        ivT.setAdjustViewBounds(true);
        ivS.setAdjustViewBounds(true);
        
       final Animation r = AnimationUtils.loadAnimation(this, R.anim.rotate);
       final Animation a = AnimationUtils.loadAnimation(this, R.anim.alpha);
       final Animation t = AnimationUtils.loadAnimation(this, R.anim.translate);
       final Animation s = AnimationUtils.loadAnimation(this, R.anim.scale);
        
       
        
        //implement animation listener inner class
        
        class AniListener1 implements Animation.AnimationListener{
        	
			@Override
			public void onAnimationStart(Animation animation){
				
				if(sflag1 == true){
				rotateBtn.setText("Stop");
					sflag1 =false;
				}
				/*
				switch(aFlag){
				
					case 1:
						rotateBtn.setText("Stop");
						
						break;
				
					case 2:
						alphaBtn.setText("Stop");
						
						break;
					
					case 3:
						translateBtn.setText("Stop");
						
						break;
					
					case 4:
						scaleBtn.setText("Stop");
						
						break;
					
					default:
						
						break;
				}
				*/
		
			}//end start
			
			
	
			@Override    	
			public void onAnimationEnd(Animation animation){
        		
				
				if(sflag1 == false){
					rotateBtn.setText("Start");

					sflag1 = true;
					
				}
				/*
				switch(aFlag){
				
				case 1:
				
					rotateBtn.setText("Start");
					
					
					break;
		
				case 2:
					
					alphaBtn.setText("Start");
					
					
					break;
			
				case 3:
			
					translateBtn.setText("Start");
					
					
					break;
			
				case 4:
			
					scaleBtn.setText("Start");
					
					
					break;
			
				default:
				
					break;
				}
				
        		*/
        	}//end end
        
			@Override
			public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
				
			}//end repeat 
        	
        }// end ani innerclass
        
        
        class AniListener2 implements Animation.AnimationListener{
        	
			@Override
			public void onAnimationStart(Animation animation){
				
				if(sflag2 == true){
				alphaBtn.setText("Stop");
					sflag2 =false;
				}
		
			}//end start
			
			
	
			@Override    	
			public void onAnimationEnd(Animation animation){
        		
				
				if(sflag2 == false){
					alphaBtn.setText("Start");
					sflag2 = true;
				}
				
		
        	}//end end
        
			@Override
			public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
				
			}//end repeat 
        	
        }// end ani innerclass
        

        class AniListener3 implements Animation.AnimationListener{
        	
			@Override
			public void onAnimationStart(Animation animation){
				
				if(sflag3 == true){
				translateBtn.setText("Stop");
					sflag3 =false;
				}
		
			}//end start
			
			
	
			@Override    	
			public void onAnimationEnd(Animation animation){
        		
				
				if(sflag3 == false){
					translateBtn.setText("Start");
					sflag3 = true;
				}
				
		
        	}//end end
        
			@Override
			public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
				
			}//end repeat 
        	
        }// end ani innerclass
        

        class AniListener4 implements Animation.AnimationListener{
        	
			@Override
			public void onAnimationStart(Animation animation){
				
				if(sflag4 == true){
				scaleBtn.setText("Stop");
					sflag4 =false;
				}
		
			}//end start
			
			
	
			@Override    	
			public void onAnimationEnd(Animation animation){
        		
				
				if(sflag4 == false){
					scaleBtn.setText("Start");

					sflag4 = true;
					
				}
				
		
        	}//end end
        
			@Override
			public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
				
			}//end repeat 
        	
        }// end ani innerclass
        
        r.setAnimationListener(new AniListener1());
        a.setAnimationListener(new AniListener2());
        t.setAnimationListener(new AniListener3());
        s.setAnimationListener(new AniListener4());
        
        //set up button listeners 
        rotateBtn.setOnClickListener(new Button.OnClickListener(){
        	
        	public void onClick(View v){
        		System.out.println(r.hasStarted());
    			System.out.println(r.hasEnded());
        		if(r.hasStarted() == false || r.hasEnded() == true){
        			
        		ivR.startAnimation(r);
        		r.setRepeatCount(-1);
        		
        		sflag1 = true;
        		}else
        		
        		if(r.hasStarted()){
        			r.setRepeatCount(0);
        		}
        		
        		
        	}
        });
        
        
        alphaBtn.setOnClickListener(new Button.OnClickListener(){
        	
        	public void onClick(View v){
        		if(a.hasStarted() == false){
        		ivA.startAnimation(a);
        		a.setRepeatCount(-1);

        		sflag2 = true;
        		}else
        		if(a.hasStarted()){
        			a.setRepeatCount(0);
        		}
        		        		
        	}
        });
        
     
        translateBtn.setOnClickListener(new Button.OnClickListener(){
        	
        	public void onClick(View v){
        		
        		if(t.hasStarted() == false){
        			sflag3 = true;
        			ivT.startAnimation(t);
        			t.setRepeatCount(-1);
        		}else
        		if(t.hasStarted()){
        			t.setRepeatCount(0);
            		
        		}
        	
        	
        	}
        });
       
        
        
        scaleBtn.setOnClickListener(new Button.OnClickListener(){
        	
        	public void onClick(View v){
        		
        		if(s.hasStarted() == false){
        		sflag4 = true;
        		
        		ivS.startAnimation(s);
        		s.setRepeatCount(-1);
        		}
        		if(s.hasStarted()){
        			s.setRepeatCount(0);
        		}
        		
        	}
        });
       
        //end buttonListeners
        
    }//end on create
    
    
}//end class