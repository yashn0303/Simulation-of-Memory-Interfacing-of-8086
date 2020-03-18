import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;



public class MicroV3 extends Applet implements java.awt.event.ActionListener
{ 

        TextField userIn,a[],startRam,startRom,errorMessage;
        Font er;
        final static int ax=300,ay=10,aw=200,ah=25;
        Button input;
        Color lin[]=new Color[20];//addreslines
        Color dec;//decoder
        Color ram[]=new Color[2];//ram chips
        Color orRam[]=new Color[2];//or gates of ram
        Color orRamConfirm[]=new Color[2];//Output of OR gate below RAM Chips 
        Color rom[]=new Color[2];//ROM chips  
        Color orRom[]=new Color[2];//or gates of ROM
        Color orRomConfirm[]=new Color[2];//Output of OR gate below ROM Chips 
        Color bhe;//bhe from prossesor 
        Color data;//data bus 
        Color dataTransRam[]=new Color[2];
        Color dataTransRom[]=new Color[2];
        Color rwm[]=new Color[3];//RD?WD?M-IO lines 
        Color orDec[]=new Color[2];//OR gates of Decoder
        Color y0[]=new Color[2]; //y0 before OR and After OR
        Color y7[]=new Color[2];//y7 before OR and After OR
        Color not;
        Color a16;//a16 after not
        String status=new String("Waiting For the input for Simulation...................");
        final static int x=70,y=300,wi=180,hi=280;


        //<applet code="MicroV3.class" height=1000 width=1000></applet>
        public void init(){

                Frame title=(Frame)this.getParent().getParent();
                title.setTitle("Simulation of Memory Mangement in 8086");
                Label address=new Label("Address of Memory Location: ");
                userIn=new TextField("10000000000000000111");
                Label stRam=new Label("Starting Address of RAM: ");
                startRam=new TextField("00000000000000000111");
                Label stRom=new Label("Starting Address of ROM: ");
                startRom=new TextField("00000000000000001111");
                Label addressBar[]=new Label[20];
                String uni[]={"\u2080","\u2081","\u2082","\u2083","\u2084","\u2085",
                                "\u2086","\u2087","\u2088","\u2089","\u2081\u2080",
                                "\u2081\u2081","\u2081\u2082","\u2081\u2083","\u2081\u2084",
                                "\u2081\u2085","\u2081\u2086","\u2081\u2087","\u2081\u2088",
                                "\u2081\u2089"};
                for(int i=0;i<20;i++){
                    addressBar[i]=new Label(String.valueOf("A"+uni[i]));
                }

                setBackground(Color.BLACK);

                errorMessage=new TextField();

                input=new Button("Enter");
                input.setBackground(Color.LIGHT_GRAY);
                input.setForeground(Color.BLACK);
                input.addActionListener(this);
                a=new TextField[20];
                for(int i=0;i<20;i++){

                    a[i]=new TextField(i);
                }
                dec=Color.WHITE;
                bhe=Color.WHITE;
                not=Color.WHITE;
                a16=Color.WHITE;

                for (int i=0;i<20;i++){
                    lin[i]=Color.WHITE;
                }
                for (int i=0;i<2;i++){
                        ram[i]=Color.WHITE;
                        orRam[i]=Color.WHITE;
                        orRamConfirm[i]=Color.WHITE;
                        rom[i]=Color.WHITE;
                        rom[i]=Color.WHITE;
                        orRom[i]=Color.WHITE;
                        orRomConfirm[i]=Color.WHITE;
                        data=Color.WHITE;
                        dataTransRam[i]=Color.WHITE;
                        dataTransRom[i]=Color.WHITE;
                        rwm[i]=Color.WHITE;
                        orDec[i]=Color.WHITE;
                        y0[i]=Color.WHITE;
                        y7[i]=Color.WHITE;
                }

                setLayout(new FlowLayout());
                setFont(new Font("Serif",Font.BOLD,13));
                setForeground(Color.WHITE);
                add(address);
                address.setBounds(ax, ay, aw, ah);
                setLayout(null);
                add(stRam);
                stRam.setBounds(ax+25, ay+30, aw-30, ah);
                setLayout(null);
                add(stRom);
                stRom.setBounds(ax+25, ay+60, aw-30, ah);
                setLayout(null);

                setFont(new Font("San Serif",Font.PLAIN,12));
                add(userIn);
                userIn.setBounds(ax+200, ay, aw-25, ah);
                setLayout(null);
                add(startRam);
                startRam.setBounds(ax+200, ay+30, aw-25, ah);
                setLayout(null);
                add(startRom);
                startRom.setBounds(ax+200, ay+60, aw-25, ah);
                setLayout(null);
                add(input);
                input.setBounds(ax+164, ay+90, aw-125, ah);
                setLayout(null);
                
            
                for(int i=0,x1=50;i<20;i++,x1+=45){
                    a[i].setEditable(false);
                    a[i].setEnabled(false);
                    add(a[i]);
                    a[i].setBounds(x1, ay+120, aw-175, ah);
                    setLayout(null);
                }
                for(int i=0,x1=53;i<20;i++,x1+=45){
                    add(addressBar[i]);
                    addressBar[i].setBounds(x1, ay+150, aw-175, ah);
                    setLayout(null);
                }

                errorMessage.setEditable(false);
                errorMessage.setEnabled(false);
                errorMessage.setBackground(Color.RED);
                errorMessage.setForeground(Color.WHITE);
                add(errorMessage);
                errorMessage.setBounds(100, 350, 800, 90);
                errorMessage.setVisible(false);
                setLayout(null);
                
                
        }

        public void paint(Graphics g) {

                
        //Decoder
        g.setColor(dec);
        g.drawRect(x, y, wi, hi);
        
        //RAM Chips
        for (int i=0, x1=x+370,y1=y-26,w=wi-90,h=hi-50;i<2;i++,x1+=310){
                g.setColor(ram[i]);
                g.drawRect(x1, y1, w, h);
        }
        //ROM Chips
        for (int i=0, x1=x+370,y1=y+304,w=wi-90,h=hi-50;i<2;i++,x1+=310){
                g.setColor(rom[i]);
                g.drawRect(x1, y1, w, h);
        }
        //A17/A18/A19
        for (int i=17, x1=x-50,y1=y+24,x2=x,y2=y+24;i<20;i++,y1+=116,y2+=116){
                g.setColor(lin[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //Y0
        g.setColor(y0[0]);
        g.drawLine(x+180, y+24, x+207, y+24);//towards or gate
        g.setColor(y0[1]);
        for (int i=0, x1=x+218,y1=y+14,x2=x+253,y2=y+14;i<5;i++){
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
        for (int i=0, x1=x+188,y1=y-1,w=wi-150,h=hi-250,a1=-90,a2=180;i<2;i++,x1+=10,w-=20){
                g.drawArc(x1, y1, w,h,a1,a2);
        }
        g.setColor(lin[16]);
        for (int i=0, x1=x+190,y1=y+4,x2=x+190,y2=y-16;i<2;i++,x2+=17,y2+=20){
                g.drawLine(x1, y1, x2, y2);
        }
        g.drawLine(x+195, y+4, x+195, y+130); //towards not
        

        //Not Gate
        g.setColor(not);
        {
        int x1[]={x+185,x+195,x+205};
        int y1[]={y+130,y+144,y+130};
        g.drawPolygon(x1, y1, 3);
        }
        g.drawOval(x+192, y+144, wi-174, hi-274);

        //Y7
        g.setColor(y7[0]);
        g.drawLine(x+180, y+256, x+207, y+256);
        g.setColor(y7[1]);
        for (int i=0, x1=x+218,y1=y+266,x2=x+230,y2=y+266;i<5;i++){
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
        for (int i=0, x1=x+188,y1=y+251,w=wi-150,h=hi-250,a1=-90,a2=180;i<2;i++,x1+=10,w-=20){
                g.drawArc(x1, y1, w,h,a1,a2);
        }
        g.setColor(a16);
        //Towards Not included
        for (int i=0, x1=x+195,y1=y+276,x2=x+195,y2=y+150;i<2;i++,x2+=12,y2+=126){
                g.drawLine(x1, y1, x2, y2);
        }

        //DATA BUS
        //D8-D15
        
        g.setColor(data);
        //Lines
        for (int i=0, x1=x+272,y1=y-108,x2=x+272,y2=y+624;i<2;i++,x1+=10,y1+=5,x2+=10,y2+=5){
                g.drawLine(x1, y1, x2, y2);
        }
        //Arc Top and Bottom
        for (int i=0, x1=x+267,y1=y-108,w=wi-170,h=hi-275,a1=0,a2=180;i<2;i++,x1+=10,a2-=360){
                g.drawArc(x1, y1, w,h,a1,a2);
        }
        for (int i=0, x1=x+267,y1=y+624,w=wi-170,h=hi-275,a1=0,a2=180;i<2;i++,x1+=10,a2-=360){
                g.drawArc(x1, y1, w,h,a1,a2);
        }

        //D0-D7
        g.setColor(data);
        //Lines
        for (int i=0, x1=x+582,y1=y-108,x2=x+582,y2=y+624;i<2;i++,x1+=10,y1+=5,x2+=10,y2+=5){
                g.drawLine(x1, y1, x2, y2);
        }
        //Arc Top and Bottom
        for (int i=0, x1=x+577,y1=y-108,w=wi-170,h=hi-275,a1=0,a2=180;i<2;i++,x1+=10,a2-=360){
                g.drawArc(x1, y1, w,h,a1,a2);
        }
        for (int i=0, x1=x+577,y1=y+624,w=wi-170,h=hi-275,a1=0,a2=180;i<2;i++,x1+=10,a2-=360){
                g.drawArc(x1, y1, w,h,a1,a2);
        }

        //RAM ARROWS/A1-A15/RD/WR/M-IO/OR
        //1

        //Arrows
        g.setColor(dataTransRam[0]);

        //Parallel Lines of Arrow
        for (int i=0, x1=x+292,y1=y-16,x2=x+360,y2=y-16;i<2;i++,y1+=10,y2+=10){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow left
        for (int i=0, x1=x+292,y1=y-16,x2=x+292,y2=y-20;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow Right
        for (int i=0, x1=x+360,y1=y-16,x2=x+360,y2=y-20;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of left
        for (int i=0, x1=x+282,y1=y-11,x2=x+292,y2=y-20;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of Right
        for (int i=0, x1=x+370,y1=y-11,x2=x+360,y2=y-20;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }

        //A1-A15
        for (int i=0, x1=x+325,y1=y+6,x2=x+370,y2=y+6;i<15;i++,y1+=10,y2+=10){
                g.setColor(lin[i]);
                g.drawLine(x1, y1, x2, y2);
        }
        
        //RD/WR/M-IO
        for (int i=0, x1=x+325,y1=y+160,x2=x+370,y2=y+160;i<3;i++,y1+=10,y2+=10){
                g.setColor(rwm[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //OR Gate below RAM Chips
        g.setColor(orRam[0]);
        for (int i=0, x1=x+400,y1=y+216,w=30,h=30,a1=0,a2=180;i<2;i++,y1+=10,h-=20){
                g.drawArc(x1, y1, w,h,a1,a2);
        }
        
        g.setColor(orRamConfirm[0]);
        g.drawLine(x+415, y+216, x+415, y+204);
        
        g.setColor(bhe);
        for (int i=0, x1=x+405,y1=y+228,x2=x+405,y2=y+240;i<2;i++,y1+=12,x2-=30){
                g.drawLine(x1, y1, x2, y2);
        }
        
        //2

        //Arrows
        g.setColor(dataTransRam[1]);
        
        //Parallel Lines of Arrow
        for (int i=0, x1=x+602,y1=y-16,x2=x+670,y2=y-16;i<2;i++,y1+=10,y2+=10){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow left
        for (int i=0, x1=x+602,y1=y-16,x2=x+602,y2=y-20;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow Right
        for (int i=0, x1=x+670,y1=y-16,x2=x+670,y2=y-20;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of left
        for (int i=0, x1=x+592,y1=y-11,x2=x+602,y2=y-20;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of Right
        for (int i=0, x1=x+680,y1=y-11,x2=x+670,y2=y-20;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
                
        //A1-A15
        for (int i=0, x1=x+635,y1=y+6,x2=x+680,y2=y+6;i<15;i++,y1+=10,y2+=10){
                g.setColor(lin[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //RD/WR/M-IO
        for (int i=0, x1=x+635,y1=y+160,x2=x+680,y2=y+160;i<3;i++,y1+=10,y2+=10){
                g.setColor(rwm[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //OR Gate below RAM Chips
        g.setColor(orRam[1]);
        for (int i=0, x1=x+710,y1=y+216,w=wi-150,h=hi-250,a1=0,a2=180;i<2;i++,y1+=10,h-=20){
                g.drawArc(x1, y1, w,h,a1,a2);
        }

        g.setColor(orRamConfirm[1]);
        g.drawLine(x+725, y+216, x+725, y+204);

        g.setColor(lin[0]);
        for (int i=0, x1=x+715,y1=y+228,x2=x+715,y2=y+240;i<2;i++,y1+=12,x2-=30){
                g.drawLine(x1, y1, x2, y2);
        }
        
        //3

        //Arrows
        g.setColor(dataTransRom[0]);
        //Parallel Lines of Arrow
        for (int i=0, x1=x+292,y1=y+314,x2=x+360,y2=y+314;i<2;i++,y1+=10,y2+=10){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow left
        for (int i=0, x1=x+292,y1=y+314,x2=x+292,y2=y+310;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow Right
        for (int i=0, x1=x+360,y1=y+314,x2=x+360,y2=y+310;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of left
        for (int i=0, x1=x+282,y1=y+319,x2=x+292,y2=y+310;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of Right
        for (int i=0, x1=x+370,y1=y+319,x2=x+360,y2=y+310;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }

        //A1-A15
        for (int i=0, x1=x+325,y1=y+336,x2=x+370,y2=y+336;i<15;i++,y1+=10,y2+=10){
                g.setColor(lin[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //RD/WR/M-IO 
        for (int i=0, x1=x+325,y1=y+490,x2=x+370,y2=y+490;i<3;i++,y1+=10,y2+=10){
                g.setColor(rwm[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //OR Gate below RAM Chips
        g.setColor(orRom[0]);
        for (int i=0, x1=x+400,y1=y+546,w=wi-150,h=hi-250,a1=0,a2=180;i<2;i++,y1+=10,h-=20){
                g.drawArc(x1, y1, w,h,a1,a2);
        }
        g.setColor(orRomConfirm[0]);
        g.drawLine(485, y+546, 485, y+534);

        g.setColor(bhe);
        for (int i=0, x1=x+405,y1=y+558,x2=x+405,y2=y+570;i<2;i++,y1+=12,x2-=30){
                g.drawLine(x1, y1, x2, y2);
        }

        //4

        //Arrows
        g.setColor(dataTransRom[1]);

        //Parallel Lines of Arrow
        for (int i=0, x1=x+602,y1=y+314,x2=x+670,y2=y+314;i<2;i++,y1+=10,y2+=10){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow left
        for (int i=0, x1=x+602,y1=y+314,x2=x+602,y2=y+310;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Small Lines for Formation of Arrow Right
        for (int i=0, x1=x+670,y1=y+314,x2=x+670,y2=y+310;i<2;i++,y1+=10,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of left
        for (int i=0, x1=x+592,y1=y+319,x2=x+602,y2=y+310;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
        //Angle of Right
        for (int i=0, x1=x+680,y1=y+319,x2=x+670,y2=y+310;i<2;i++,y2+=18){
                g.drawLine(x1, y1, x2, y2);
        }
                
        //A1-15
        for (int i=0, x1=x+635,y1=y+336,x2=x+680,y2=y+336;i<15;i++,y1+=10,y2+=10){
                g.setColor(lin[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //RD/WR/M-IO
        for (int i=0, x1=x+635,y1=y+490,x2=x+680,y2=y+490;i<3;i++,y1+=10,y2+=10){
                g.setColor(rwm[i]);
                g.drawLine(x1, y1, x2, y2);
        }

        //OR Gate below RAM Chips
        g.setColor(orRom[1]);
        for (int i=0, x1=x+710,y1=y+546,w=wi-150,h=hi-250,a1=0,a2=180;i<2;i++,y1+=10,h-=20){
                g.drawArc(x1, y1, w,h,a1,a2);
        }

        g.setColor(orRomConfirm[1]);
        g.drawLine(x+725, y+546, x+725, y+534);

        g.setColor(lin[0]);
        for (int i=0, x1=x+715,y1=y+558,x2=x+715,y2=y+570;i<2;i++,y1+=12,x2-=30){
                g.drawLine(x1, y1, x2, y2);
        }
        //Show the Status of Applet
        showStatus(status);
        }

        public void actionPerformed(ActionEvent arg0) {
                String in=userIn.getText();
                char[] add=new char[in.length()];
                errorMessage.setVisible(false);
                try {
                        if(in.length()<20){
                                throw new AddressSmallerThan20Exception("   Address is Smaller than 20!");
                        }else if (in.length()>20){
                                throw new AddressLargerThan20Exception("   Address is Larger than 20!");
                        }
                } catch (AddressSmallerThan20Exception e) {
                        er=new Font ("Roboto",Font.LAYOUT_NO_LIMIT_CONTEXT,50);
                        errorMessage.setFont(er);
                        errorMessage.setVisible(true);
                        errorMessage.setText(e.getMessage());
                } catch (AddressLargerThan20Exception e) {
                        er=new Font ("Roboto",Font.LAYOUT_NO_LIMIT_CONTEXT,50);
                        errorMessage.setFont(er);
                        errorMessage.setVisible(true);
                        errorMessage.setText(e.getMessage());
                } 
                
                String in2=startRam.getText();
                char[] sRam=new char[in2.length()];
                try {
                        if(in2.length()<20){
                                throw new AddressSmallerThan20Exception("   Address of RAM is Smaller than 20!");
                        }else if (in2.length()>20){
                                throw new AddressLargerThan20Exception("   Address of RAM is Larger than 20!");
                        }
                } catch (AddressSmallerThan20Exception e) {
                        er=new Font ("Roboto",Font.LAYOUT_NO_LIMIT_CONTEXT,40);
                        errorMessage.setFont(er);
                        errorMessage.setVisible(true);
                        errorMessage.setText(e.getMessage());
                } catch (AddressLargerThan20Exception e) {
                        er=new Font("Roboto",Font.LAYOUT_NO_LIMIT_CONTEXT,40);
                        errorMessage.setFont(er);
                        errorMessage.setVisible(true);
                        errorMessage.setText(e.getMessage());
                } 
                String in3=startRom.getText();
                char[] sRom=new char[in3.length()];
                try {
                        if(in3.length()<20){
                                throw new AddressSmallerThan20Exception("   Address of ROM is Smaller than 20!");
                        }else if (in3.length()>20){
                                throw new AddressLargerThan20Exception("   Address of ROM is Larger than 20!");
                        }
                } catch (AddressSmallerThan20Exception e) {
                        er=new Font("Roboto",Font.LAYOUT_NO_LIMIT_CONTEXT,40);
                        errorMessage.setFont(er);
                        errorMessage.setVisible(true);
                        errorMessage.setText(e.getMessage());
                } catch (AddressLargerThan20Exception e) {
                        er=new Font("Roboto",Font.LAYOUT_NO_LIMIT_CONTEXT,40);
                        errorMessage.setFont(er);
                        errorMessage.setVisible(true);
                        errorMessage.setText(e.getMessage());
                } 
                y0[0]=Color.RED;
                y7[0]=Color.RED;
                dec=Color.GREEN;
                data=Color.GREEN;
                not=Color.GREEN;

                //Initailizing Address
                for(int i=0;i<in.length();i++){
                        add[i]=(char) in.charAt(i);
                }
                //Initailizing Staring Address of RAM
                for(int i=0;i<in2.length();i++){
                    sRam[i]=(char) in2.charAt(i);
                }
                //Initailizing Staring Address of ROM
                for(int i=0;i<in3.length();i++){
                    sRom[i]=(char) in3.charAt(i);
                }

                //Setting the Address Line Values
                for(int i=0;i<20;i++){
                    a[i].setText("  "+String.valueOf(add[i]));
                }

                //Updateing color of OR Gates of RAM Chips to active/OR Gates of ROM Chips to active/OR Gates of Decoder to active
                for (int i=0;i<2;i++){
                        ram[i]=Color.YELLOW;
                        rom[i]=Color.YELLOW;
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
                if(sRam[17]==add[17]&&sRam[18]==add[18]&&sRam[19]==add[19])
                {
                        y0[0]=Color.BLUE;
                        y7[0]=Color.RED;
                }else if (sRom[17]==add[17]&&sRom[18]==add[18]&&sRom[19]==add[19]){
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
                        orRamConfirm[0]=Color.BLUE;
                }else if (y0[1]==Color.BLUE && bhe==Color.RED){
                        orRamConfirm[0]=Color.RED;
                }else if (y0[1]==Color.RED && bhe==Color.BLUE){
                        orRamConfirm[0]=Color.RED;
                }else if (y0[1]==Color.RED && bhe==Color.RED){
                        orRamConfirm[0]=Color.RED;
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
                        orRomConfirm[0]=Color.BLUE;
                }else if (y7[1]==Color.BLUE && bhe==Color.RED){
                        orRomConfirm[0]=Color.RED;
                }else if (y7[1]==Color.RED && bhe==Color.BLUE){
                        orRomConfirm[0]=Color.RED;
                }else if (y7[1]==Color.RED && bhe==Color.RED){
                    orRomConfirm[0]=Color.RED;
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
                status="Simulated Sucessfully!";
                repaint();
        }
        class AddressSmallerThan20Exception extends Exception{
                AddressSmallerThan20Exception(String str){
                        super(str);
                }
        }
        
        class AddressLargerThan20Exception extends Exception{
                AddressLargerThan20Exception(String str){
                        super(str);
                }
        }
}