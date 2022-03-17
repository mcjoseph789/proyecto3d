
package ejemplolwjgl;

import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.internal.util.xml.impl.Input;
import org.lwjgl.LWJGLException;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;


public class Primera3D {
    
    private static int movimientox=0;
    private static int movimientoz=0;
    private static int movimientoy=0;
    
    private static int rotay=45;
    private static int rotax=30;
    private static int rotaz=0;
    
    private Vector3f positon = new Vector3f(0,0,0);
    
    public static void main(String[] args){
        escena();
    }
    
    private static void escena(){
        ventana();
        init();
        
        while(!Display.isCloseRequested()){
            manejoEventos();
            display();
        }
        Display.destroy();
    }

    private static void ventana() {
        try {
            Display.setDisplayMode(new DisplayMode(900,900));
            Display.create();
            Display.setTitle("Ejemplo LWJGL 3D");
            Display.setVSyncEnabled(true);
            
        } catch (LWJGLException ex) {
            Logger.getLogger(Primera3D.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void init() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(-10,10,-10,10,-100,100);
        
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        glClearColor(0,0,0,0);
        
    }

    private static void display() {
        glClear(GL_COLOR_BUFFER_BIT);
        glLoadIdentity();
        glPushMatrix();
        glRotated(rotax,1,0,0);
        glRotated(rotay,0,1,0);
        glRotated(rotaz,0,0,1);
        ejes();
        limites();
        glTranslated(movimientox,movimientoy,movimientoz);
        cubo();
        glPopMatrix();
        Display.update();
    }
    private static void limites(){
        glBegin(GL_LINE_STRIP);
        glColor3f(1,1,0);
        glVertex3f(-5,6,-5);
        glVertex3f(6,6,-5);
        glVertex3f(6,6,6);
        glVertex3f(-5,6,6);
        glVertex3f(-5,6,-5);
        
        glVertex3f(-5,-5,-5);
        glVertex3f(6,-5,-5);
        glVertex3f(6,-5,6);
        glVertex3f(-5,-5,6);
        glVertex3f(-5,-5,-5);
        glEnd();
        
        glBegin(GL_LINES);
        glVertex3f(6,6,-5);
        glVertex3f(6,-5,-5);
        
        glVertex3f(6,6,6);
        glVertex3f(6,-5,6);
        
        glVertex3f(-5,6,6);
        glVertex3f(-5,-5,6);
        glEnd();
    }
    private static void ejes(){
        glBegin(GL_LINES);
        glColor3f(1,0,0);
        glVertex3f(-1,0,0);
        glVertex3f(1,0,0);
            
        glColor3f(0,1,0);
        glVertex3f(0,-1,0);
        glVertex3f(0,1,0);
            
        glColor3f(0,0,1);
        glVertex3f(0,0,-1);
        glVertex3f(0,0,1);
        
        glEnd();
                
            
    }
    
    private static void cubo() {
        glBegin(GL_QUADS);
            glColor3d(1,0,0);
            glVertex3d(0,0,0);
            glVertex3d(1,0,0);
            glVertex3d(1,1,0);
            glVertex3d(0,1,0);
            
            glColor3d(0,1,0);
            glVertex3d(0,0,0);
            glVertex3d(0,0,1);
            glVertex3d(1,0,1);
            glVertex3d(1,0,0);
            
            glColor3d(0,0,1);
            glVertex3d(0,0,0);
            glVertex3d(0,1,0);
            glVertex3d(0,1,1);
            glVertex3d(0,0,1);
            
            glColor3d(0,1,1);
            glVertex3d(1,0,0);
            glVertex3d(1,0,1);
            glVertex3d(1,1,1);
            glVertex3d(1,1,0);
            
            glColor3d(1,0,1);
            glVertex3d(0,0,1);
            glVertex3d(1,0,1);
            glVertex3d(1,1,1);
            glVertex3d(0,1,1);
            
            glColor3d(1,1,0);
            glVertex3d(0,1,0);
            glVertex3d(1,1,0);
            glVertex3d(1,1,1);
            glVertex3d(0,1,1);
            
            
        glEnd();
    }
    
    private static void manejoEventos(){
        //reset
        if(Keyboard.isKeyDown(Keyboard.KEY_0)){
            movimientox=0;
            movimientoz=0;
            movimientoy=0;
            rotay=45;
            rotax=30;
            rotaz=0;
        }
        //lados
        if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)&&movimientox<5){
            movimientox+=1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)&&movimientox>-5){
            movimientox-=1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_UP)&&movimientoz<5){
            movimientoz+=1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)&&movimientoz>-5){
            movimientoz-=1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_W)&&movimientoy<5){
            movimientoy+=1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)&&movimientoy>-5){
            movimientoy-=1;
        }
        
        //rotacion
        if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
            rotay+=1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_E)){
            rotax+=1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_R)){
            rotaz+=1;
        }
        
        //camara
        if(Keyboard.isKeyDown(Keyboard.KEY_J)){
            ;
        }

    }
}
