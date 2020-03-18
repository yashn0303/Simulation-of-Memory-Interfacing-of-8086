import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class MicroV2 extends Applet implements java.awt.event.ActionListener
{ 

        TextField userIn;
        Button input;
        Color lin[]=new Color[20];//addreslines
        Color dec;//decoder
        Color ram[]=new Color[2];//ram chips  *********
        Color orRam[]=new Color[2];//or gates of ram
        Color orRamConfirm[]=new Color[2];//Output of OR gate below RAM Chips  ************
        Color rom[]=new Color[2];//ROM chips  *********
        Color orRom[]=new Color[2];//or gates of ROM
        Color orRomConfirm[]=new Color[2];//Output of OR gate below ROM Chips  ************
        Color bhe;//bhe from prossesor *************
        Color data;//data bus *************** 1
        Color dataTransRam[]=new Color[2];
        Color dataTransRom[]=new Color[2];
        Color rwm[]=new Color[3];//RD?WD?M-IO lines 
        Color orDec[]=new Color[2];//OR gates of Decoder
        Color y0[]=new Color[2]; //y0 before OR and After OR
        Color y7[]=new Color[2];//y7 before OR and After OR
        Color not;
        Color a16;//a16 after not


        //<applet code="MicroV2.class" height=1000 width=1000></applet>
        public void init(){

                userIn=new TextField("00000000000000000000");
                input=new Button("Enter");
                input.addActionListener(this);
                add(userIn);
                add(input);
                for (int i=0;i<20;i++){
                        lin[i]=Color.BLACK;
                }
                
                dec=Color.BLACK;
                bhe=Color.BLACK;
                not=Color.BLACK;
                a16=Color.BLACK;

                for (int i=0;i<2;i++){
                        ram[i]=Color.BLACK;
                        orRam[i]=Color.BLACK;
                        orRamConfirm[i]=Color.BLACK;
                        rom[i]=Color.BLACK;
                        rom[i]=Color.BLACK;
                        orRom[i]=Color.BLACK;
                        orRomConfirm[i]=Color.BLACK;
                        data=Color.BLACK;
                        dataTransRam[i]=Color.BLACK;
                        dataTransRom[i]=Color.BLACK;
                        rwm[i]=Color.BLACK;
                        orDec[i]=Color.BLACK;
                        y0[i]=Color.BLACK;
                        y7[i]=Color.BLACK;
                }
        }

        public void paint(Graphics g) {
                
        //Decoder
        g.setColor(dec);
        g.drawRect(70, 176, 180, 280);
        
        //RAM Chips
        for (int i=0, x1=440,y1=150,w=90,h=230;i<2;i++,x1+=310){
                g.setColor(ram[i]);
                g.drawRect(x1, y1, w, h);
        }
        //ROM Chips
        for (int i=0, x1=440,y1=480,w=90,h=230;i<2;i++,x1+=310){
                g.setColor(rom[i]);
                g.drawRect(x1, y1, w, h);
        }
        //A17/A18/A19
        for (int i=17, x1=20,y1=200,x2=70,y2=200;i<20;i++,y1+=116,y2+=116){
                g.setColor(lin[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //Y0
        g.setColor(y0[0]);
        g.drawLine(250, 200, 277, 200);//towards or gate
        g.setColor(y0[1]);
        for (int i=0, x1=288,y1=190,x2=323,y2=190;i<5;i++){
                if(i==1){
                        x1+=35;
                        y2+=240;
                }else if(i==2){
                        y1+=240;
                        x2+=482;
                }else if(i==3){
                        x1+=482;
                        y2-=26;
                }else if(i==4){
                        x1-=310;
                        x2-=310;
                }
                g.drawLine(x1, y1, x2, y2);
        }

        //OR Gate of Y0
        g.setColor(orDec[0]);
        for (int i=0, x1=258,y1=175,w=30,h=30,a1=-90,a2=180;i<2;i++,x1+=10,w-=20){
                g.drawArc(x1, y1, w,h,a1,a2);
        }
        g.setColor(lin[16]);
        for (int i=0, x1=260,y1=180,x2=260,y2=160;i<2;i++,x2+=17,y2+=20){
                g.drawLine(x1, y1, x2, y2);
        }
        g.drawLine(265, 180, 265, 306); //towards not
        

        //Not Gate
        g.setColor(not);
        {
        int x1[]={255,265,275};
        int y1[]={306,320,306};
        g.drawPolygon(x1, y1, 3);
        }
        g.drawOval(262, 320, 6, 6);

        //Y7
        g.setColor(y7[0]);
        g.drawLine(250, 432, 277, 432);
        g.setColor(y7[1]);
        for (int i=0, x1=288,y1=442,x2=300,y2=442;i<5;i++){
                if(i==1){
                        x1+=12;
                        y2+=318;
                }else if(i==2){
                        y1+=318;
                        x2+=505;
                }else if(i==3){
                        x1+=505;
                        y2-=26;
                }else if(i==4){
                        x1-=310;
                        x2-=310;
                }
                g.drawLine(x1, y1, x2, y2);
        }
        //OR Gate of Y7
        g.setColor(orDec[1]);
        for (int i=0, x1=258,y1=427,w=30,h=30,a1=-90,a2=180;i<2;i++,x1+=10,w-=20){
                g.drawArc(x1, y1, w,h,a1,a2);
        }
        g.setColor(a16);
        //Towards Not included
        for (int i=0, x1=265,y1=452,x2=265,y2=326;i<2;i++,x2+=12,y2+=126){
                g.drawLine(x1, y1, x2, y2);
        }

        //DATA BUS
        //D8-D15
        
        g.setColor(data);
        //Lines
        for (int i=0, x1=342,y1=68,x2=342,y2=800;i<2;i++,x1+=10,y1+=5,x2+=10,y2+=5){
                g.drawLine(x1, y1, x2, y2);
        }
        //Arc Top and Bottom
        for (int i=0, x1=337,y1=68,w=10,h=5,a1=0,a2=180;i<2;i++,x1+=10,a2-=360){
                g.drawArc(x1, y1, w,h,a1,a2);
        }
        for (int i=0, x1=337,y1=800,w=10,h=5,a1=0,a2=180;i<2;i++,x1+=10,a2-=360){
                g.drawArc(x1, y1, w,h,a1,a2);
        }

        //D0-D7
        g.setColor(data);
        //Lines
        for (int i=0, x1=652,y1=68,x2=652,y2=800;i<2;i++,x1+=10,y1+=5,x2+=10,y2+=5){
                g.drawLine(x1, y1, x2, y2);
        }
        //Arc Top and Bottom
        for (int i=0, x1=647,y1=68,w=10,h=5,a1=0,a2=180;i<2;i++,x1+=10,a2-=360){
                g.drawArc(x1, y1, w,h,a1,a2);
        }
        for (int i=0, x1=647,y1=800,w=10,h=5,a1=0,a2=180;i<2;i++,x1+=10,a2-=360){
                g.drawArc(x1, y1, w,h,a1,a2);
        }

        //RAM ARROWS/A1-A15/RD/WR/M-IO/OR
        //1

        //Arrows
        g.setColor(dataTransRam[0]);

        //Parallel Lines of Arrow
        for (int i=0, x1=362,y1=160,x2=430,y2=160;i<2;i++,y1+=10,y2+=10){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow left
        for (int i=0, x1=362,y1=160,x2=362,y2=156;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow Right
        for (int i=0, x1=430,y1=160,x2=430,y2=156;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of left
        for (int i=0, x1=352,y1=165,x2=362,y2=156;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of Right
        for (int i=0, x1=440,y1=165,x2=430,y2=156;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }

        //A1-A15
        for (int i=0, x1=395,y1=182,x2=440,y2=182;i<15;i++,y1+=10,y2+=10){
                g.setColor(lin[i]);
                g.drawLine(x1, y1, x2, y2);
        }
        
        //RD/WR/M-IO
        for (int i=0, x1=395,y1=336,x2=440,y2=336;i<3;i++,y1+=10,y2+=10){
                g.setColor(rwm[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //OR Gate below RAM Chips
        g.setColor(orRam[0]);
        for (int i=0, x1=470,y1=392,w=30,h=30,a1=0,a2=180;i<2;i++,y1+=10,h-=20){
                g.drawArc(x1, y1, w,h,a1,a2);
        }
        
        g.setColor(orRamConfirm[0]);
        g.drawLine(485, 392, 485, 380);

        
        g.setColor(bhe);
        for (int i=0, x1=475,y1=404,x2=475,y2=416;i<2;i++,y1+=12,x2-=30){
                g.drawLine(x1, y1, x2, y2);
        }
        
        //2

        //Arrows
        g.setColor(dataTransRam[1]);
        
        //Parallel Lines of Arrow
        for (int i=0, x1=672,y1=160,x2=740,y2=160;i<2;i++,y1+=10,y2+=10){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow left
        for (int i=0, x1=672,y1=160,x2=672,y2=156;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow Right
        for (int i=0, x1=740,y1=160,x2=740,y2=156;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of left
        for (int i=0, x1=662,y1=165,x2=672,y2=156;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of Right
        for (int i=0, x1=750,y1=165,x2=740,y2=156;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
                
        //A1-A15
        for (int i=0, x1=705,y1=182,x2=750,y2=182;i<15;i++,y1+=10,y2+=10){
                g.setColor(lin[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //RD/WR/M-IO
        for (int i=0, x1=705,y1=336,x2=750,y2=336;i<3;i++,y1+=10,y2+=10){
                g.setColor(rwm[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //OR Gate below RAM Chips
        g.setColor(orRam[1]);
        for (int i=0, x1=780,y1=392,w=30,h=30,a1=0,a2=180;i<2;i++,y1+=10,h-=20){
                g.drawArc(x1, y1, w,h,a1,a2);
        }

        g.setColor(orRamConfirm[1]);
        g.drawLine(795, 392, 795, 380);

        g.setColor(lin[0]);
        for (int i=0, x1=785,y1=404,x2=785,y2=416;i<2;i++,y1+=12,x2-=30){
                g.drawLine(x1, y1, x2, y2);
        }
        
        //3

        //Arrows
        g.setColor(dataTransRom[0]);
        //Parallel Lines of Arrow
        for (int i=0, x1=362,y1=490,x2=430,y2=490;i<2;i++,y1+=10,y2+=10){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow left
        for (int i=0, x1=362,y1=490,x2=362,y2=486;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow Right
        for (int i=0, x1=430,y1=490,x2=430,y2=486;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of left
        for (int i=0, x1=352,y1=495,x2=362,y2=486;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of Right
        for (int i=0, x1=440,y1=495,x2=430,y2=486;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }

        //A1-A15
        for (int i=0, x1=395,y1=512,x2=440,y2=512;i<15;i++,y1+=10,y2+=10){
                g.setColor(lin[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //RD/WR/M-IO 
        for (int i=0, x1=395,y1=666,x2=440,y2=666;i<3;i++,y1+=10,y2+=10){
                g.setColor(rwm[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //OR Gate below RAM Chips
        g.setColor(orRom[0]);
        for (int i=0, x1=470,y1=722,w=30,h=30,a1=0,a2=180;i<2;i++,y1+=10,h-=20){
                g.drawArc(x1, y1, w,h,a1,a2);
        }
        g.setColor(orRomConfirm[0]);
        g.drawLine(485, 722, 485, 710);

        g.setColor(bhe);
        for (int i=0, x1=475,y1=734,x2=475,y2=746;i<2;i++,y1+=12,x2-=30){
                g.drawLine(x1, y1, x2, y2);
        }

        //4

        //Arrows
        g.setColor(dataTransRom[1]);

        //Parallel Lines of Arrow
        for (int i=0, x1=672,y1=490,x2=740,y2=490;i<2;i++,y1+=10,y2+=10){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow left
        for (int i=0, x1=672,y1=490,x2=672,y2=486;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow Right
        for (int i=0, x1=740,y1=490,x2=740,y2=486;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of left
        for (int i=0, x1=662,y1=495,x2=672,y2=486;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of Right
        for (int i=0, x1=750,y1=495,x2=740,y2=486;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
                
        //A1-15
        for (int i=0, x1=705,y1=512,x2=750,y2=512;i<15;i++,y1+=10,y2+=10){
                g.setColor(lin[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //RD/WR/M-IO
        for (int i=0, x1=705,y1=666,x2=750,y2=666;i<3;i++,y1+=10,y2+=10){
                g.setColor(rwm[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //OR Gate below RAM Chips
        g.setColor(orRom[1]);
        for (int i=0, x1=780,y1=722,w=30,h=30,a1=0,a2=180;i<2;i++,y1+=10,h-=20){
                g.drawArc(x1, y1, w,h,a1,a2);
        }

        g.setColor(orRomConfirm[1]);
        g.drawLine(795, 722, 795, 710);

        g.setColor(lin[0]);
        for (int i=0, x1=785,y1=734,x2=785,y2=746;i<2;i++,y1+=12,x2-=30){
                g.drawLine(x1, y1, x2, y2);
        }

        }

        public void actionPerformed(ActionEvent arg0) {
                String in=userIn.getText();
                char[] add=new char[in.length()];
                y0[0]=Color.RED;
                y7[0]=Color.RED;
                dec=Color.GREEN;
                data=Color.GREEN;
                not=Color.GREEN;

                for(int i=0;i<in.length();i++){
                        add[i]=(char) in.charAt(i);
                }

                //Updateing color of OR Gates of RAM Chips to active/OR Gates of ROM Chips to active/OR Gates of Decoder to active
                for (int i=0;i<2;i++){
                        ram[i]=Color.RED;
                        rom[i]=Color.RED;
                        dataTransRam[i]=Color.RED;
                        dataTransRom[i]=Color.RED;
                        orRamConfirm[i]=Color.RED;
                        orRomConfirm[i]=Color.RED;
                        orRam[i]=Color.GREEN;
                        orRom[i]=Color.GREEN;
                        orDec[i]=Color.GREEN;
                }

                //Updating color of Address Lines
                for (int i=0;i<add.length;i++)
                {
                        if ('1'==add[i]){
                                lin[i]=Color.RED;
                        }else
                        {
                                lin[i]=Color.BLUE;
                        }
                }

                //Updating color of y0 lines
                if('0'==add[17]&&'0'==add[18]&&'0'==add[19])
                {
                        y0[0]=Color.BLUE;
                        y7[0]=Color.RED;
                }else if ('1'==add[17]&&'1'==add[18]&&'1'==add[19]){
                        y7[0]=Color.BLUE;
                        y0[0]=Color.RED;
                }

                //Updating color of A16 not line
                if ('0'==add[16]){
                        a16=Color.RED;
                }else
                        a16=Color.BLUE;

                //Output of y0
                if (y0[0]==Color.BLUE && lin[16]==Color.BLUE){
                        y0[1]=Color.BLUE;
                }else if (y0[0]==Color.BLUE && lin[16]==Color.RED){
                        y0[1]=Color.RED;
                }else if (y0[0]==Color.RED && lin[16]==Color.BLUE){
                        y0[1]=Color.RED;
                }else if (y0[0]==Color.RED && lin[16]==Color.RED){
                        y0[1]=Color.RED;
                }
                
                //Output of y1
                if (y7[0]==Color.BLUE && a16==Color.BLUE){
                        y7[1]=Color.BLUE;
                }else if (y7[0]==Color.BLUE && a16==Color.RED){
                        y7[1]=Color.RED;
                }else if (y7[0]==Color.RED && a16==Color.BLUE){
                        y7[1]=Color.RED;
                }else if (y7[0]==Color.RED && a16==Color.RED){
                        y7[1]=Color.RED;
                }

                //Updating BHE
                if (lin[0]==Color.RED){
                        bhe=Color.BLUE;
                }else{
                        bhe=Color.RED;
                }

                //Output of OR Gate Below Ram Chip 1
                if (y0[1]==Color.BLUE && bhe==Color.BLUE){
                        orRamConfirm[1]=Color.BLUE;
                }else if (y0[1]==Color.BLUE && bhe==Color.RED){
                        orRamConfirm[1]=Color.RED;
                }else if (y0[1]==Color.RED && bhe==Color.BLUE){
                        orRamConfirm[1]=Color.RED;
                }else if (y0[1]==Color.RED && bhe==Color.RED){
                        orRamConfirm[1]=Color.RED;
                }

                //Output of OR Gate below RAM Chip 2
                if (y0[1]==Color.BLUE && lin[0]==Color.BLUE){
                        orRamConfirm[1]=Color.BLUE;
                }else if (y0[1]==Color.BLUE && lin[0]==Color.RED){
                        orRamConfirm[1]=Color.RED;
                }else if (y0[1]==Color.RED && lin[0]==Color.BLUE){
                        orRamConfirm[1]=Color.RED;
                }else if (y0[1]==Color.RED && lin[0]==Color.RED){
                        orRamConfirm[1]=Color.RED;
                }

                //Output of OR Gate Below ROM Chip 1
                if (y7[1]==Color.BLUE && bhe==Color.BLUE){
                        orRomConfirm[1]=Color.BLUE;
                }else if (y7[1]==Color.BLUE && bhe==Color.RED){
                        orRomConfirm[1]=Color.RED;
                }else if (y7[1]==Color.RED && bhe==Color.BLUE){
                        orRomConfirm[1]=Color.RED;
                }else if (y7[1]==Color.RED && bhe==Color.RED){
                    orRomConfirm[1]=Color.RED;
                }

                //Output of OR Gate below R0M Chip 2
                if (y7[1]==Color.BLUE && lin[0]==Color.BLUE){
                        orRomConfirm[1]=Color.BLUE;
                }else if (y7[1]==Color.BLUE && lin[0]==Color.RED){
                        orRomConfirm[1]=Color.RED;
                }else if (y7[1]==Color.RED && lin[0]==Color.BLUE){
                        orRomConfirm[1]=Color.RED;
                }else if (y7[1]==Color.RED && lin[0]==Color.RED){
                    orRomConfirm[1]=Color.RED;
                }
                
                //Updating the Active RAM and Rom Chips
                for (int i=0;i<2;i++){
                        if(orRamConfirm[i]==Color.BLUE){
                                ram[i]=Color.GREEN;
                        }
                        if(orRomConfirm[i]==Color.BLUE){
                                rom[i]=Color.GREEN;
                        }
                }

                //Updating the Data Bus For active Chips
                for (int i=0;i<2;i++){
                        if(ram[i]==Color.GREEN){
                                dataTransRam[i]=Color.GREEN;
                        }
                        if(rom[i]==Color.GREEN){
                                dataTransRom[i]=Color.GREEN;
                        }
                }

                repaint();
        }
}