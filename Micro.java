import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class Micro extends Applet implements java.awt.event.ActionListener
{ 

        TextField userIn,a[]=new TextField[20];
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


        //<applet code="Micro.class" height=1000 width=1000></applet>
        public void init(){

                userIn=new TextField("00000000000000000000");
                input=new Button("Enter");
                input.addActionListener(this);

                for (int i=0;i<20;i++){
                        lin[i]=Color.BLACK;
                }
                
                dec=Color.BLACK;

                for (int i=0;i<2;i++){
                        ram[i]=Color.BLACK;
                }
                for (int i=0;i<2;i++){
                        orRam[i]=Color.BLACK;
                }
                for (int i=0;i<2;i++){
                        orRamConfirm[i]=Color.BLACK;
                }
                for (int i=0;i<2;i++){
                        rom[i]=Color.BLACK;
                }
                for (int i=0;i<2;i++){
                        orRom[i]=Color.BLACK;
                }
                for (int i=0;i<2;i++){
                        orRomConfirm[i]=Color.BLACK;
                }
                bhe=Color.BLACK;
                for (int i=0;i<2;i++){
                        data=Color.BLACK;
                }
                for (int i=0;i<2;i++){
                        dataTransRam[i]=Color.BLACK;
                }
                for (int i=0;i<2;i++){
                        dataTransRom[i]=Color.BLACK;
                }
                for (int i=0;i<3;i++){
                        rwm[i]=Color.BLACK;
                }
                for (int i=0;i<2;i++){
                        orDec[i]=Color.BLACK;
                }
                for (int i=0;i<2;i++){
                        y0[i]=Color.BLACK;
                }
                for (int i=0;i<2;i++){
                        y7[i]=Color.BLACK;
                }
                not=Color.BLACK;
                a16=Color.BLACK;

                add(userIn);
                userIn.setBounds(35, 25, 175, 25);
                setLayout(null);
                add(input);
                input.setBounds(230, 25, 75, 25);
                setLayout(null);
                
        }

        public void paint(Graphics g) {

        //All Text
                
        //Decoder
        g.setColor(dec);
        g.drawRect(70, 176, 180, 280);
        
        //RAM Chips
        //1
        g.setColor(ram[0]);
        g.drawRect(440,150, 90, 230);
        //2
        g.setColor(ram[1]);
        g.drawRect(750,150, 90, 230);
        //3
        g.setColor(rom[0]);
        g.drawRect(440,480, 90, 230);
        //4
        g.setColor(rom[1]);
        g.drawRect(750,480, 90, 230);
        
        //A17
        g.setColor(lin[17]);
        g.drawLine(20, 200, 70, 200);
        //A18
        g.setColor(lin[18]);
        g.drawLine(20, 316, 70, 316);
        //A19
        g.setColor(lin[19]);
        g.drawLine(20, 432, 70, 432);

        //Y0
        g.setColor(y0[0]);
        g.drawLine(250, 200, 277, 200);//towards or gate
        g.setColor(y0[1]);
        g.drawLine(323, 190, 323, 430);//towards chip
        g.drawLine(323, 430, 805, 430);
        g.drawLine(805, 430, 805, 404);
        g.drawLine(495, 430, 495, 404);

        //OR Gate of Y0
        g.setColor(orDec[0]);
        g.drawArc(258, 175, 30, 30, -90, 180);
        g.drawArc(268, 175, 10, 30, -90, 180);
        g.setColor(lin[16]);
        g.drawLine(260, 180, 277, 180);
        g.drawLine(260, 180, 260, 160);
        g.drawLine(265, 180, 265, 306); //towards not
        g.setColor(y0[1]);
        g.drawLine(288, 190, 323, 190);

        //Not Gate
        g.setColor(not);
        int x[]={255,265,275};
        int y[]={306,320,306};
        g.drawPolygon(x, y, 3);
        g.drawOval(262, 320, 6, 6);

        //Y7
        g.setColor(y7[0]);
        g.drawLine(250, 432, 277, 432);
        g.setColor(y7[1]);
        g.drawLine(300, 442, 300, 760);
        g.drawLine(300, 760, 805, 760);
        g.drawLine(805, 760, 805, 734);
        g.drawLine(495, 760, 495, 734);

        //OR Gate of Y7
        g.setColor(orDec[1]);
        g.drawArc(258, 427, 30, 30, -90, 180);
        g.drawArc(268, 427, 10, 30, -90, 180);
        g.setColor(a16);
        g.drawLine(265, 452, 277, 452);
        g.drawLine(265, 452, 265, 326); //towards not
        g.setColor(y7[1]);
        g.drawLine(288, 442, 300, 442);


        //DATA BUS
        //D8-D15
        
        g.setColor(data);
        g.drawLine(342, 68, 342, 800);
        g.drawLine(352, 73, 352, 805);
        g.drawArc(337, 68, 10, 5, 0, 180);
        g.drawArc(347, 68, 10, 5, 0, -180);
        g.drawArc(337, 800, 10, 5, 0, 180);
        g.drawArc(347, 800, 10, 5,0, -180);

        //D0-D7
        g.setColor(data);
        g.drawLine(652, 68, 652, 800);
        g.drawLine(662, 73, 662, 805);
        g.drawArc(647, 68, 10, 5, 0, 180);
        g.drawArc(657, 68, 10, 5, 0, -180);
        g.drawArc(647, 800, 10, 5, 0, 180);
        g.drawArc(657, 800, 10, 5,0, -180);

        //RAM ARROWS/A1-A15/RD/WR/M-IO/OR
        //1

        //Arrows
        g.setColor(dataTransRam[0]);
        g.drawLine(362, 160, 430, 160);
        g.drawLine(362, 160, 362, 156);
        g.drawLine(430, 160, 430, 156);

        g.drawLine(352, 165, 362, 156);
        g.drawLine(352, 165, 362, 174);
                
        g.drawLine(362, 170, 430, 170);
        g.drawLine(430, 170, 430, 174);
        g.drawLine(362, 170, 362, 174);

        g.drawLine(440, 165, 430, 156);
        g.drawLine(440, 165, 430, 174);

        //A1-A15
        g.setColor(lin[1]);
        g.drawLine(395, 182, 440, 182);
        g.setColor(lin[2]);
        g.drawLine(395, 192, 440, 192);
        g.setColor(lin[3]);
        g.drawLine(395, 202, 440, 202);
        g.setColor(lin[4]);
        g.drawLine(395, 212, 440, 212);
        g.setColor(lin[5]);
        g.drawLine(395, 222, 440, 222);
        g.setColor(lin[6]);
        g.drawLine(395, 232, 440, 232);
        g.setColor(lin[7]);
        g.drawLine(395, 242, 440, 242);
        g.setColor(lin[8]);
        g.drawLine(395, 252, 440, 252);
        g.setColor(lin[9]);
        g.drawLine(395, 262, 440, 262);
        g.setColor(lin[10]);
        g.drawLine(395, 272, 440, 272);
        g.setColor(lin[11]);
        g.drawLine(395, 282, 440, 282);
        g.setColor(lin[12]);
        g.drawLine(395, 292, 440, 292);
        g.setColor(lin[13]);
        g.drawLine(395, 302, 440, 302);
        g.setColor(lin[14]);
        g.drawLine(395, 312, 440, 312);
        g.setColor(lin[15]);
        g.drawLine(395, 322, 440, 322);
        
        //RD/WR/M-IO
        g.setColor(rwm[0]);
        g.drawLine(395, 336, 440, 336);
        g.setColor(rwm[1]);
        g.drawLine(395, 346, 440, 346);
        g.setColor(rwm[2]);
        g.drawLine(395, 356, 440, 356);

        //OR Gate below RAM Chips
        g.setColor(orRam[0]);
        g.drawArc(470,392,30,30, 0, 180);  
        g.drawArc(470, 402, 30, 10, 0, 180);
        
        g.setColor(orRamConfirm[0]);
        g.drawLine(485, 392, 485, 380);
        
        g.setColor(bhe);
        g.drawLine(475, 404, 475, 416);
        g.drawLine(475, 416, 445, 416);
        
        //2

        //Arrows
        g.setColor(dataTransRam[1]);
        g.drawLine(672, 160, 740, 160);
        g.drawLine(672, 160, 672, 156);
        g.drawLine(740, 160, 740, 156);

        g.drawLine(662, 165, 672, 156);
        g.drawLine(662, 165, 672, 174);

        g.drawLine(672, 170, 740, 170);
        g.drawLine(672, 170, 672, 174);
        g.drawLine(740, 170, 740, 174);

        g.drawLine(750, 165, 740, 156);
        g.drawLine(750, 165, 740, 174);
                
        //A1-A15
        g.setColor(lin[1]);
        g.drawLine(705, 182, 750, 182);
        g.setColor(lin[2]);
        g.drawLine(705, 192, 750, 192);
        g.setColor(lin[3]);
        g.drawLine(705, 202, 750, 202);
        g.setColor(lin[4]);
        g.drawLine(705, 212, 750, 212);
        g.setColor(lin[5]);
        g.drawLine(705, 222, 750, 222);
        g.setColor(lin[6]);
        g.drawLine(705, 232, 750, 232);
        g.setColor(lin[7]);
        g.drawLine(705, 242, 750, 242);
        g.setColor(lin[8]);
        g.drawLine(705, 252, 750, 252);
        g.setColor(lin[9]);
        g.drawLine(705, 262, 750, 262);
        g.setColor(lin[10]);
        g.drawLine(705, 272, 750, 272);
        g.setColor(lin[11]);
        g.drawLine(705, 282, 750, 282);
        g.setColor(lin[12]);
        g.drawLine(705, 292, 750, 292);
        g.setColor(lin[13]);
        g.drawLine(705, 302, 750, 302);
        g.setColor(lin[14]);
        g.drawLine(705, 312, 750, 312);
        g.setColor(lin[15]);
        g.drawLine(705, 322, 750, 322);

        //RD/WR/M-IO
        g.setColor(rwm[0]);
        g.drawLine(705, 336, 750, 336);
        g.setColor(rwm[1]);
        g.drawLine(705, 346, 750, 346);
        g.setColor(rwm[2]);
        g.drawLine(705, 356, 750, 356);

        //OR Gate below RAM Chips
        g.setColor(orRam[1]);
        g.drawArc(780,392,30,30, 0, 180);  
        g.drawArc(780, 402, 30, 10, 0, 180);

        g.setColor(orRamConfirm[1]);
        g.drawLine(795, 392, 795, 380);

        g.setColor(lin[0]);
        g.drawLine(785, 404, 785, 416);
        g.drawLine(785, 416, 755, 416);
        
        //3

        //Arrows
        g.setColor(dataTransRom[0]);
        g.drawLine(362, 490, 430, 490);
        g.drawLine(362, 490, 362, 486);
        g.drawLine(430, 490, 430, 486);

        g.drawLine(352, 495, 362, 486);
        g.drawLine(352, 495, 362, 504);

        g.drawLine(362, 500, 430, 500);
        g.drawLine(362, 500, 362, 504);
        g.drawLine(430, 500, 430, 504);

        g.drawLine(440, 495, 430, 486);
        g.drawLine(440, 495, 430, 504);

        //A1-A15
        g.setColor(lin[1]);
        g.drawLine(395, 512, 440, 512);
        g.setColor(lin[2]);
        g.drawLine(395, 522, 440, 522);
        g.setColor(lin[3]);
        g.drawLine(395, 532, 440, 532);
        g.setColor(lin[4]);
        g.drawLine(395, 542, 440, 542);
        g.setColor(lin[5]);
        g.drawLine(395, 552, 440, 552);
        g.setColor(lin[6]);
        g.drawLine(395, 562, 440, 562);
        g.setColor(lin[7]);
        g.drawLine(395, 572, 440, 572);
        g.setColor(lin[8]);
        g.drawLine(395, 582, 440, 582);
        g.setColor(lin[9]);
        g.drawLine(395, 592, 440, 592);
        g.setColor(lin[10]);
        g.drawLine(395, 602, 440, 602);
        g.setColor(lin[11]);
        g.drawLine(395, 612, 440, 612);
        g.setColor(lin[12]);
        g.drawLine(395, 622, 440, 622);
        g.setColor(lin[13]);
        g.drawLine(395, 632, 440, 632);
        g.setColor(lin[14]);
        g.drawLine(395, 642, 440, 642);
        g.setColor(lin[15]);
        g.drawLine(395, 652, 440, 652);

        //RD/WR/M-IO 
        g.setColor(rwm[0]);
        g.drawLine(395, 666, 440, 666);
        g.setColor(rwm[1]);
        g.drawLine(395, 676, 440, 676);
        g.setColor(rwm[2]);
        g.drawLine(395, 686, 440, 686);

        //OR Gate below RAM Chips
        g.setColor(orRom[0]);
        g.drawArc(470,722,30,30, 0, 180);  
        g.drawArc(470,732, 30, 10, 0, 180);

        g.setColor(orRomConfirm[0]);
        g.drawLine(485, 722, 485, 710);

        g.setColor(bhe);
        g.drawLine(475, 734, 475, 746);
        g.drawLine(475, 746, 445, 746);

        //4

        //Arrows
        g.setColor(dataTransRom[1]);
        g.drawLine(672, 490, 740, 490);
        g.drawLine(672, 490, 672, 486);
        g.drawLine(740, 490, 740, 486);

        g.drawLine(662, 495, 672, 486);
        g.drawLine(662, 495, 672, 504);

        g.drawLine(672, 500, 740, 500);
        g.drawLine(672, 500, 672, 504);
        g.drawLine(740, 500, 740, 504);

        g.drawLine(750, 495, 740, 486);
        g.drawLine(750, 495, 740, 504);
                
        //A1-15
        g.setColor(lin[1]);
        g.drawLine(705, 512, 750, 512);
        g.setColor(lin[2]);
        g.drawLine(705, 522, 750, 522);
        g.setColor(lin[3]);
        g.drawLine(705, 532, 750, 532);
        g.setColor(lin[4]);
        g.drawLine(705, 542, 750, 542);
        g.setColor(lin[5]);
        g.drawLine(705, 552, 750, 552);
        g.setColor(lin[6]);
        g.drawLine(705, 562, 750, 562);
        g.setColor(lin[7]);
        g.drawLine(705, 572, 750, 572);
        g.setColor(lin[8]);
        g.drawLine(705, 582, 750, 582);
        g.setColor(lin[9]);
        g.drawLine(705, 592, 750, 592);
        g.setColor(lin[10]);
        g.drawLine(705, 602, 750, 602);
        g.setColor(lin[11]);
        g.drawLine(705, 612, 750, 612);
        g.setColor(lin[12]);
        g.drawLine(705, 622, 750, 622);
        g.setColor(lin[13]);
        g.drawLine(705, 632, 750, 632);
        g.setColor(lin[14]);
        g.drawLine(705, 642, 750, 642);
        g.setColor(lin[15]);
        g.drawLine(705, 652, 750, 652);

        //RD/WR/M-IO
        g.setColor(rwm[0]);
        g.drawLine(705, 666, 750, 666);
        g.setColor(rwm[1]);
        g.drawLine(705, 676, 750, 676);
        g.setColor(rwm[2]);
        g.drawLine(705, 686, 750, 686);

        //OR Gate below RAM Chips
        g.setColor(orRom[1]);
        g.drawArc(780,722,30,30, 0, 180);
        g.drawArc(780, 732, 30, 10, 0, 180);

        g.setColor(orRomConfirm[1]);
        g.drawLine(795, 722, 795, 710);

        g.setColor(lin[0]);
        g.drawLine(785, 734, 785, 746);
        g.drawLine(785, 746, 755, 746);

        }

        @Override
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

                for (int i=0;i<2;i++){
                        ram[i]=Color.RED;
                        rom[i]=Color.RED;
                        dataTransRam[i]=Color.RED;
                        dataTransRom[i]=Color.RED;
                        orRamConfirm[i]=Color.RED;
                        orRomConfirm[i]=Color.RED;
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

                //Updatein color of OR Gates of RAM Chips to active
                for(int i=0;i<2;i++){
                        orRam[i]=Color.GREEN;
                }

                //Updatein color of OR Gates of ROM Chips to active
                for(int i=0;i<2;i++){
                        orRom[i]=Color.GREEN;
                }

                //Updating color of OR Gates of Decoder to active
                for(int i=0;i<2;i++){
                        orDec[i]=Color.GREEN;
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