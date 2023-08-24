/**
 * https://robocode.sourceforge.io/license/epl-v10.html
 */
package snake;


import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.WinEvent;
import robocode.util.Utils;


/**
 * MetalGear
 * <p>
 * Drives at robots trying to ram them.
 * Fires when it hits them.
 *
 * @author Matheus Freitas Martins - 3031
 */
public class MetalGear extends Robot{
	
        
        
        private int procuraAlvo;
        private int sentido;
        private double movimentoDeBusca;

        static int i =0;

       
	/**
	 * run: Spin around looking for a target
	 */
	public void run(){

        // Set colors
          setColors(new Color(255, 0, 0), new Color(0, 0, 0), Color.red ,  Color.red, Color.black);

          sentido = -1;
          movimentoDeBusca = 90;
          procuraAlvo = 0;

          setAdjustGunForRobotTurn(true);                    

             // Robot main loop
             while(true) {
                 turnGunRight(movimentoDeBusca);
                 procuraAlvo++;
                 if(procuraAlvo > 15) {
                     ahead(15*sentido); 
                 }
                 else if(procuraAlvo > 5) { 
                     movimentoDeBusca = 20;
                 }
                 else if(procuraAlvo > 2) { 
                     movimentoDeBusca = -20; 
                 }

             }		
		
	}

	/**
	 * onScannedRobot:  We have a target.  Go get it.
	 */
	public void onScannedRobot(ScannedRobotEvent e){

            double deslocamento_mira, premedicao = 0, dist_deslocamento = 35*sentido;
            procuraAlvo = 0;

            deslocamento_mira = getHeading() + e.getBearing() - getRadarHeading();
            movimentoDeBusca = Utils.normalRelativeAngleDegrees(deslocamento_mira + premedicao);
            turnGunRight(movimentoDeBusca);


              if(e.getDistance() < 300){
                    fire(3);
                   //   dist_deslocamento += 80;
               }
              else{
                    switch(i)
                    {
                        case 0:   turnGunLeft(5); fire(1);  i++;    break;
                        case 1:   fire(3);  i++;   break;
                        case 2:  turnGunRight(3);  fire(1); i++;     break;
                        default:  i=0; 
                    }
           }

            turnRight(e.getBearing() - 90);
            ahead((dist_deslocamento+10)*sentido);              
		
	}
	/**
	 * onHitRobot:  Turn to face robot, fire hard, and ram him again!
	 */
	public void onHitRobot(HitRobotEvent e){
            double deslocamento_mira;
           // Desloca a mira para o robô inimigo e atira
           deslocamento_mira = getHeading() + e.getBearing() - getRadarHeading();
           movimentoDeBusca = Utils.normalRelativeAngleDegrees(deslocamento_mira);
           turnGunRight(movimentoDeBusca);
           fire(3);
           // Recuando...
           back(50*sentido);

	}
         public void onHitWall(HitWallEvent e){
            turnLeft(180 - e.getBearing());
            ahead(200);
            turnRight(50);
            ahead(50);

         }	
          public void onHitByBullet(HitByBulletEvent e){
              
            turnLeft(90 - e.getBearing());
            ahead(100);
        }
          public void onWin(WinEvent e){
            turnRight(36000);
        }
          
}
