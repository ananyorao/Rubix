import java.io.*;
class r_logic
{
    static int count=0; 
    static int[][][]cube=new int[6][3][3];
    static void main()throws IOException
    {
        BufferedReader rao=new BufferedReader(new InputStreamReader(System.in));
        /*int[][][]cub={{{4,4,4},{4,4,4},{4,4,4}},{{1,1,1},{1,1,1},{1,1,1}},{{3,3,3},{3,3,3},{3,3,3}},
        {{2,2,2},{2,2,2},{2,2,2}},{{5,5,5},{5,5,5},{5,5,5}},{{6,6,6},{6,6,6},{6,6,6}}};*/
        int[][][]cub={{{2,1,2},{1,3,4},{1,5,3}},{{3,2,6},{5,1,3},{2,4,2}},{{1,2,6},{6,2,4},{3,4,1}},
        {{6,6,3},{5,6,2},{1,5,6}},{{5,2,4},{6,5,3},{4,3,4}},{{5,3,5},{1,4,6},{4,1,5}}};
        /*int[][][]cub={{{4,5,4},{2,4,1},{6,4,5}},{{5,3,3},{6,6,1},{1,2,2}},{{3,4,4},{5,5,6},{1,5,3}},
        {{2,3,5},{1,1,1},{6,6,6}},{{3,6,2},{2,2,4},{5,2,4}},{{6,5,2},{4,3,3},{1,3,1}}};*/
        for(int a=0;a<6;a++)
            for(int b=0;b<3;b++)
                for(int c=0;c<3;c++)cube[a][b][c]=cub[a][b][c];
        disp();
        step1();
        step2();
        step3();
        step4();
        step5();
        step6();
        step7();
        disp();
        System.out.println("\n\ncount = "+count);
    }
    static void clock(int f)
    {
        count++;
        int[]ar=new int[3];
        for(int a=0;a<2;a++){
            ar[a]=cube[f][0][a];
            cube[f][0][a]=cube[f][2-a][0];
            cube[f][2-a][0]=cube[f][2][2-a];
            cube[f][2][2-a]=cube[f][a][2];
            cube[f][a][2]=ar[a];
        }
        if(f==0)
        for(int a=0;a<3;a++){
            ar[a]=cube[3][2][a];
            cube[3][2][a]=cube[4][0][2-a];
            cube[4][0][2-a]=cube[1][0][2-a];
            cube[1][0][2-a]=cube[5][0][2-a];
            cube[5][0][2-a]=ar[a];
        }
        else if(f==1)
        for(int a=0;a<3;a++){
            ar[a]=cube[0][2][a];
            cube[0][2][a]=cube[4][2-a][2];
            cube[4][2-a][2]=cube[2][0][2-a];
            cube[2][0][2-a]=cube[5][a][0];
            cube[5][a][0]=ar[a];
        }
        else if(f==2)
        for(int a=0;a<3;a++){
            ar[a]=cube[1][2][a];
            cube[1][2][a]=cube[4][2][a];
            cube[4][2][a]=cube[3][0][2-a];
            cube[3][0][2-a]=cube[5][2][a];
            cube[5][2][a]=ar[a];
        }
        else if(f==3)
        for(int a=0;a<3;a++){
            ar[a]=cube[2][2][a];
            cube[2][2][a]=cube[4][a][0];
            cube[4][a][0]=cube[0][0][2-a];
            cube[0][0][2-a]=cube[5][2-a][2];
            cube[5][2-a][2]=ar[a];
        }
        else if(f==4)
        for(int a=0;a<3;a++){
            ar[a]=cube[0][a][0];
            cube[0][a][0]=cube[3][a][0];
            cube[3][a][0]=cube[2][a][0];
            cube[2][a][0]=cube[1][a][0];
            cube[1][a][0]=ar[a];
        }
        else if(f==5)
        for(int a=0;a<3;a++){
            ar[a]=cube[0][2-a][2];
            cube[0][2-a][2]=cube[1][2-a][2];
            cube[1][2-a][2]=cube[2][2-a][2];
            cube[2][2-a][2]=cube[3][2-a][2];
            cube[3][2-a][2]=ar[a];
        }
    }
    static void anti(int f)
    {
        count++;
        int[]ar=new int[3];
        for(int a=0;a<2;a++){
            ar[a]=cube[f][0][a];
            cube[f][0][a]=cube[f][a][2];//cube[f][2-a][0];
            cube[f][a][2]=cube[f][2][2-a];
            cube[f][2][2-a]=cube[f][2-a][0];//cube[f][a][2];
            cube[f][2-a][0]=ar[a];
        }
        if(f==0)
        for(int a=0;a<3;a++){
            ar[a]=cube[3][2][a];
            cube[3][2][a]=cube[5][0][2-a];//cube[4][0][2-a];
            cube[5][0][2-a]=cube[1][0][2-a];
            cube[1][0][2-a]=cube[4][0][2-a];
            cube[4][0][2-a]=ar[a];
        }
        else if(f==1)
        for(int a=0;a<3;a++){
            ar[a]=cube[0][2][a];
            cube[0][2][a]=cube[5][a][0];//cube[4][2-a][2];
            cube[5][a][0]=cube[2][0][2-a];
            cube[2][0][2-a]=cube[4][2-a][2];
            cube[4][2-a][2]=ar[a];
        }
        else if(f==2)
        for(int a=0;a<3;a++){
            ar[a]=cube[1][2][a];
            cube[1][2][a]=cube[5][2][a];//cube[4][2][a];
            cube[5][2][a]=cube[3][0][2-a];
            cube[3][0][2-a]=cube[4][2][a];
            cube[4][2][a]=ar[a];
        }
        else if(f==3)
        for(int a=0;a<3;a++){
            ar[a]=cube[2][2][a];
            cube[2][2][a]=cube[5][2-a][2];//cube[4][a][0];
            cube[5][2-a][2]=cube[0][0][2-a];
            cube[0][0][2-a]=cube[4][a][0];
            cube[4][a][0]=ar[a];
        }
        else if(f==4)
        for(int a=0;a<3;a++){
            ar[a]=cube[0][a][0];
            cube[0][a][0]=cube[1][a][0];//cube[3][a][0];
            cube[1][a][0]=cube[2][a][0];
            cube[2][a][0]=cube[3][a][0];
            cube[3][a][0]=ar[a];
        }
        else if(f==5)
        for(int a=0;a<3;a++){
            ar[a]=cube[0][2-a][2];
            cube[0][2-a][2]=cube[3][2-a][2];//cube[1][2-a][2];
            cube[3][2-a][2]=cube[2][2-a][2];
            cube[2][2-a][2]=cube[1][2-a][2];
            cube[1][2-a][2]=ar[a];
        }
    }    
    static void step1()
    { 
        //step: top +
        //while(cube[2][0][1]!=cube[2][1][2]||cube[2][1][2]!=cube[0][1][1]||cube[2][2][1]!=cube[2][1][0])
        while(cube[2][0][1]!=cube[0][1][1]||cube[2][1][2]!=cube[0][1][1]||
        cube[2][2][1]!=cube[0][1][1]||cube[2][1][0]!=cube[0][1][1]){
        if(cube[1][1][0]==cube[0][1][1]){while(cube[2][1][0]==cube[0][1][1])clock(2);clock(4);}//face 1
        if(cube[0][1][0]==cube[0][1][1]){while(cube[2][1][0]==cube[0][1][1])clock(2);clock(4);clock(4);}
        if(cube[0][1][2]==cube[0][1][1]){while(cube[2][1][2]==cube[0][1][1])clock(2);anti(5);anti(5);}
        if(cube[1][1][2]==cube[0][1][1]){while(cube[2][1][2]==cube[0][1][1])clock(2);anti(5);}
        if(cube[1][0][1]==cube[0][1][1]){while(cube[2][0][1]==cube[0][1][1])clock(2);clock(1);
            while(cube[2][1][2]==cube[0][1][1])clock(2);anti(5);}
        if(cube[1][2][1]==cube[0][1][1]){while(cube[2][0][1]==cube[0][1][1])clock(2);anti(1);
            while(cube[2][1][2]==cube[0][1][1])clock(2);anti(5);}        
        if(cube[5][1][0]==cube[0][1][1]){while(cube[2][0][1]==cube[0][1][1])clock(2);clock(1);}//face 5
        if(cube[0][2][1]==cube[0][1][1]){while(cube[2][0][1]==cube[0][1][1])clock(2);clock(1);clock(1);}
        if(cube[5][1][2]==cube[0][1][1]){while(cube[2][2][1]==cube[0][1][1])clock(2);anti(3);}
        if(cube[0][0][1]==cube[0][1][1]){while(cube[2][2][1]==cube[0][1][1])clock(2);anti(3);anti(3);}
        if(cube[5][0][1]==cube[0][1][1]){while(cube[2][1][2]==cube[0][1][1])clock(2);clock(5);
            while(cube[2][2][1]==cube[0][1][1])clock(2);anti(3);}
        if(cube[5][2][1]==cube[0][1][1]){while(cube[2][1][2]==cube[0][1][1])clock(2);anti(5);
            while(cube[2][2][1]==cube[0][1][1])clock(2);anti(3);}        
        if(cube[4][1][0]==cube[0][1][1]){while(cube[2][2][1]==cube[0][1][1])clock(2);clock(3);}//face 4
        if(cube[0][0][1]==cube[0][1][1]){while(cube[2][2][1]==cube[0][1][1])clock(2);clock(3);clock(3);}
        if(cube[4][1][2]==cube[0][1][1]){while(cube[2][0][1]==cube[0][1][1])clock(2);anti(1);}
        if(cube[0][2][1]==cube[0][1][1]){while(cube[2][0][1]==cube[0][1][1])clock(2);anti(1);anti(1);}
        if(cube[4][0][1]==cube[0][1][1]){while(cube[2][1][0]==cube[0][1][1])clock(2);clock(4);
            while(cube[2][0][1]==cube[0][1][1])clock(2);anti(1);}
        if(cube[4][2][1]==cube[0][1][1]){while(cube[2][1][0]==cube[0][1][1])clock(2);anti(4);
            while(cube[2][0][1]==cube[0][1][1])clock(2);anti(1);}        
        if(cube[3][1][0]==cube[0][1][1]){while(cube[2][1][0]==cube[0][1][1])clock(2);anti(4);}//face 3
        if(cube[0][1][0]==cube[0][1][1]){while(cube[2][1][0]==cube[0][1][1])clock(2);anti(4);anti(4);}
        if(cube[3][1][2]==cube[0][1][1]){while(cube[2][1][2]==cube[0][1][1])clock(2);clock(5);}
        if(cube[0][1][2]==cube[0][1][1]){while(cube[2][1][2]==cube[0][1][1])clock(2);clock(5);clock(5);}
        if(cube[3][0][1]==cube[0][1][1]){while(cube[2][2][1]==cube[0][1][1])clock(2);anti(3);
            while(cube[2][1][0]==cube[0][1][1])clock(2);anti(4);}
        if(cube[4][2][1]==cube[0][1][1]){while(cube[2][2][1]==cube[0][1][1])clock(2);clock(3);
            while(cube[2][1][0]==cube[0][1][1])clock(2);anti(4);}}
        int fg=0;
        while(cube[0][0][1]!=cube[0][1][1]||cube[0][1][2]!=cube[0][1][1]||
        cube[0][2][1]!=cube[0][1][1]||cube[0][1][0]!=cube[0][1][1])
        //while(fg!=4)
        {
            if(cube[1][2][1]==cube[1][1][1]){clock(1);clock(1);fg++;}
            if(cube[5][2][1]==cube[5][1][1]){clock(5);clock(5);fg++;}
            if(cube[3][0][1]==cube[3][1][1]){clock(3);clock(3);fg++;}
            if(cube[4][2][1]==cube[4][1][1]){clock(4);clock(4);fg++;} 
            clock(2);
        }    
        //step: 2nd layer
        //step: bottom +
        //step: face lineups
        //step: bottom corners
    }
    static void step2()
    {
        //step: top corners
        while((cube[0][2][2]!=cube[0][1][1]||cube[1][0][2]!=cube[1][1][1]||cube[5][0][0]!=cube[5][1][1])||
            (cube[0][0][2]!=cube[0][1][1]||cube[3][2][2]!=cube[3][1][1]||cube[5][0][2]!=cube[5][1][1])||
            (cube[0][0][0]!=cube[0][1][1]||cube[4][0][0]!=cube[4][1][1]||cube[3][2][0]!=cube[3][1][1])||
            (cube[0][2][0]!=cube[0][1][1]||cube[1][0][0]!=cube[1][1][1]||cube[4][0][2]!=cube[4][1][1]))
        {
            if((cube[0][2][2]==cube[0][1][1]||cube[1][0][2]==cube[0][1][1]||cube[5][0][0]==cube[0][1][1])&&
            (cube[0][2][2]!=cube[1][1][1]&&cube[1][0][2]!=cube[1][1][1]&&cube[5][0][0]!=cube[1][1][1])||
            (cube[0][2][2]!=cube[5][1][1]&&cube[1][0][2]!=cube[5][1][1]&&cube[5][0][0]!=cube[5][1][1]))
            {anti(5);anti(2);clock(5);}
            if(cube[5][0][0]==cube[0][1][1]&&cube[1][0][2]==cube[5][1][1]&&cube[0][2][2]==cube[1][1][1])//500
            {anti(5);anti(2);clock(5);clock(2);anti(5);anti(2);clock(5);clock(2);}
            else if(cube[5][0][0]==cube[1][1][1]&&cube[1][0][2]==cube[0][1][1]&&cube[0][2][2]==cube[5][1][1])//102
            {anti(5);clock(2);clock(5);anti(2);anti(5);clock(2);clock(5);}
            else if(cube[2][0][2]==cube[1][1][1]&&cube[1][2][2]==cube[0][1][1]&&cube[5][2][0]==cube[5][1][1])//122
            {anti(2);anti(5);clock(2);clock(5);}
            else if(cube[5][2][0]==cube[1][1][1]&&cube[2][0][2]==cube[0][1][1]&&cube[1][2][2]==cube[5][1][1])//202
            {anti(5);anti(2);anti(2);clock(5);clock(2);anti(5);anti(2);clock(5);}
            else if(cube[1][2][2]==cube[1][1][1]&&cube[5][2][0]==cube[0][1][1]&&cube[2][0][2]==cube[5][1][1])//520 ok
            {anti(5);anti(2);clock(5);}
            
            if((cube[0][2][0]==cube[0][1][1]||cube[4][0][2]==cube[0][1][1]||cube[1][0][0]==cube[0][1][1])&&
            (cube[0][2][0]!=cube[4][1][1]&&cube[4][0][2]!=cube[4][1][1]&&cube[1][0][0]!=cube[4][1][1])||
            (cube[0][2][0]!=cube[1][1][1]&&cube[4][0][2]!=cube[1][1][1]&&cube[1][0][0]!=cube[4][1][1]))
            {anti(1);anti(2);clock(1);}
            if(cube[1][0][0]==cube[0][1][1]&&cube[4][0][2]==cube[1][1][1]&&cube[0][2][0]==cube[4][1][1])//100
            {anti(1);anti(2);clock(1);clock(2);anti(1);anti(2);clock(1);clock(2);}
            else if(cube[1][0][0]==cube[4][1][1]&&cube[4][0][2]==cube[0][1][1]&&cube[0][2][0]==cube[1][1][1])//402
            {anti(1);clock(2);clock(1);anti(2);anti(1);clock(2);clock(1);}
            else if(cube[2][0][0]==cube[4][1][1]&&cube[4][2][2]==cube[0][1][1]&&cube[1][2][0]==cube[1][1][1])//422 ok
            {anti(2);anti(1);clock(2);clock(1);}
            else if(cube[1][2][0]==cube[4][1][1]&&cube[2][0][0]==cube[0][1][1]&&cube[4][2][2]==cube[1][1][1])//200
            {anti(1);anti(2);anti(2);clock(1);clock(2);anti(1);anti(2);clock(1);}
            else if(cube[4][2][2]==cube[4][1][1]&&cube[1][2][0]==cube[0][1][1]&&cube[2][0][0]==cube[1][1][1])//120
            {anti(1);anti(2);clock(1);}
            
            if((cube[0][0][0]==cube[0][1][1]||cube[3][2][0]==cube[0][1][1]||cube[4][0][0]==cube[0][1][1])&&
            (cube[0][0][0]!=cube[4][1][1]&&cube[3][2][0]!=cube[4][1][1]&&cube[4][0][0]!=cube[4][1][1])||
            (cube[0][0][0]!=cube[3][1][1]&&cube[3][2][0]!=cube[3][1][1]&&cube[4][0][0]!=cube[3][1][1]))
            {anti(4);anti(2);clock(4);}
            if(cube[4][0][0]==cube[0][1][1]&&cube[0][0][0]==cube[3][1][1]&&cube[3][2][0]==cube[4][1][1])//400
            {anti(4);anti(2);clock(4);clock(2);anti(4);anti(2);clock(4);clock(2);}
            else if(cube[4][0][0]==cube[3][1][1]&&cube[3][2][0]==cube[0][1][1]&&cube[0][0][0]==cube[4][1][1])//320  ok
            {anti(4);clock(2);clock(4);anti(2);anti(4);clock(2);clock(4);}
            else if(cube[4][2][0]==cube[4][1][1]&&cube[3][0][0]==cube[0][1][1]&&cube[2][2][0]==cube[3][1][1])//300
            {anti(2);anti(4);clock(2);clock(4);}
            else if(cube[3][0][0]==cube[4][1][1]&&cube[2][2][0]==cube[0][1][1]&&cube[4][2][0]==cube[3][1][1])//220
            {anti(4);anti(2);anti(2);clock(4);clock(2);anti(4);anti(2);clock(4);}
            else if(cube[2][2][0]==cube[4][1][1]&&cube[4][2][0]==cube[0][1][1]&&cube[3][0][0]==cube[3][1][1])//420
            {anti(4);anti(2);clock(4);}
            
            if((cube[0][0][2]==cube[0][1][1]||cube[5][0][2]==cube[0][1][1]||cube[3][2][0]==cube[0][1][1])&&
            (cube[0][0][2]!=cube[5][1][1]&&cube[5][0][2]!=cube[5][1][1]&&cube[3][2][0]!=cube[5][1][1])||
            (cube[0][0][2]!=cube[3][1][1]&&cube[5][0][2]!=cube[3][1][1]&&cube[3][2][0]!=cube[3][1][1]))
            {anti(3);anti(2);clock(3);}
            if(cube[3][2][2]==cube[0][1][1]&&cube[5][0][2]==cube[3][1][1]&&cube[0][0][2]==cube[5][1][1])//322
            {anti(3);anti(2);clock(3);clock(2);anti(3);anti(2);clock(3);clock(2);}
            else if(cube[0][0][2]==cube[3][1][1]&&cube[5][0][2]==cube[0][1][1]&&cube[3][2][2]==cube[5][1][1])//502
            {anti(3);clock(2);clock(3);anti(2);anti(3);clock(2);clock(3);}
            else if(cube[2][2][2]==cube[5][1][1]&&cube[5][2][2]==cube[0][1][1]&&cube[3][0][2]==cube[3][1][1])//522
            {anti(2);anti(3);clock(2);clock(3);}
            else if(cube[3][0][2]==cube[5][1][1]&&cube[2][2][2]==cube[0][1][1]&&cube[5][2][2]==cube[3][1][1])//222
            {anti(3);anti(2);anti(2);clock(3);clock(2);anti(3);anti(2);clock(3);}
            else if(cube[5][2][2]==cube[5][1][1]&&cube[3][0][2]==cube[0][1][1]&&cube[2][2][2]==cube[3][1][1])//302
            {anti(3);anti(2);clock(3);}
            clock(2);
        }
    }
    static void step3()
    {
        //step: 2nd layer
        int fg=0;
        while(cube[1][1][0]!=cube[1][1][1]||cube[1][1][2]!=cube[1][1][1]||cube[5][1][0]!=cube[5][1][1]||cube[5][1][2]!=cube[5][1][1]||
        cube[3][1][0]!=cube[3][1][1]||cube[3][1][2]!=cube[3][1][1]||cube[4][1][0]!=cube[4][1][1]||cube[4][1][2]!=cube[4][1][1])
        {
            fg=0;
            if(cube[1][2][1]==cube[1][1][1]){   //face 1
                if(cube[2][0][1]==cube[4][1][1]){//top to rt
                    clock(2);clock(4);anti(2);anti(4);anti(2);anti(1);clock(2);clock(1);fg++;}
                else if(cube[2][0][1]==cube[5][1][1]){//top to lt
                    anti(2);anti(5);clock(2);clock(5);clock(2);clock(1);anti(2);anti(1);fg++;}
            }
            
            if(cube[5][2][1]==cube[5][1][1]){   //face 5
                if(cube[2][1][2]==cube[1][1][1]){//top to rt
                    clock(2);clock(1);anti(2);anti(1);anti(2);anti(5);clock(2);clock(5);fg++;}
                else if(cube[2][1][2]==cube[3][1][1]){//top to lt
                    anti(2);anti(3);clock(2);clock(3);clock(2);clock(5);anti(2);anti(5);fg++;}
            }
            
            if(cube[3][0][1]==cube[3][1][1]){   //face 3
                if(cube[2][2][1]==cube[5][1][1]){//top to rt
                    clock(2);clock(5);anti(2);anti(5);anti(2);anti(3);clock(2);clock(3);fg++;}
                else if(cube[2][2][1]==cube[4][1][1]){//top to lt
                    anti(2);anti(4);clock(2);clock(4);clock(2);clock(3);anti(2);anti(3);fg++;}
            }
            
            if(cube[4][2][1]==cube[4][1][1]){   //face 4
                if(cube[2][1][0]==cube[3][1][1]){//top to rt
                    clock(2);clock(3);anti(2);anti(3);anti(2);anti(4);clock(2);clock(4);fg++;}
                else if(cube[2][1][0]==cube[1][1][1]){//top to lt
                    anti(2);anti(1);clock(2);clock(1);clock(2);clock(4);anti(2);anti(4);fg++;}
            }
            if(fg==0)//mis-matches
            {
                if(cube[1][1][1]!=cube[1][1][0]||cube[4][1][1]!=cube[4][1][2])//1 to rt
                    {clock(2);clock(4);anti(2);anti(4);anti(2);anti(1);clock(2);clock(1);}
                if(cube[1][1][1]!=cube[1][1][2]||cube[5][1][1]!=cube[5][1][0])//1 to lt
                    {anti(2);anti(5);clock(2);clock(5);clock(2);clock(1);anti(2);anti(1);}
                if(cube[5][1][1]!=cube[5][1][0]||cube[1][1][1]!=cube[1][1][2])//5 to rt
                {clock(2);clock(1);anti(2);anti(1);anti(2);anti(5);clock(2);clock(5);}
                if(cube[5][1][1]!=cube[5][1][2]||cube[3][1][1]!=cube[3][1][2])//5 to lt
                {anti(2);anti(3);clock(2);clock(3);clock(2);clock(5);anti(2);anti(5);}
                if(cube[3][1][1]!=cube[3][1][2]||cube[5][1][1]!=cube[5][1][2])//3 to rt
                {clock(2);clock(5);anti(2);anti(5);anti(2);anti(3);clock(2);clock(3);}
                if(cube[3][1][1]!=cube[3][1][0]||cube[4][1][1]!=cube[4][1][0])//3 to lt
                {anti(2);anti(4);clock(2);clock(4);clock(2);clock(3);anti(2);anti(3);}
                if(cube[4][1][1]!=cube[4][1][0]||cube[3][1][1]!=cube[3][1][0])//4 to rt
                {clock(2);clock(3);anti(2);anti(3);anti(2);anti(4);clock(2);clock(4);}
                if(cube[4][1][1]!=cube[4][1][2]||cube[1][1][1]!=cube[1][1][0])//4 to lt
                {anti(2);anti(1);clock(2);clock(1);clock(2);clock(4);anti(2);anti(4);}
            }
            clock(2);
        }
    }
    static void step4()
    {
        //step: bottom +
        while(cube[2][0][1]!=cube[2][1][1]||cube[2][1][0]!=cube[2][1][1]||
        cube[2][2][1]!=cube[2][1][1]||cube[2][1][2]!=cube[2][1][1])
        {
            if(cube[1][2][1]!=cube[2][1][1]){anti(2);continue;}
            if(cube[2][1][0]==cube[2][1][1]&&cube[2][1][2]!=cube[2][1][1]){anti(2);continue;}
            clock(1);clock(4);clock(2);anti(4);anti(2);anti(1);
        }
    }
    static void step5()
    {
        //step: face lineups
        while(cube[1][1][1]!=cube[1][2][1]||cube[5][1][1]!=cube[5][2][1]||
        cube[3][1][1]!=cube[3][0][1]||cube[4][1][1]!=cube[4][2][1])
        {
            if(cube[1][1][1]==cube[1][2][1]&&cube[4][1][1]==cube[4][2][1]) //consequetive
                {clock(1);clock(2);anti(1);clock(2);clock(1);clock(2);clock(2);anti(1);clock(2);}
            else if(cube[3][1][1]==cube[3][0][1]&&cube[4][1][1]==cube[4][2][1])
                {clock(4);clock(2);anti(4);clock(2);clock(4);clock(2);clock(2);anti(4);clock(2);}
            else if(cube[3][1][1]==cube[3][0][1]&&cube[5][1][1]==cube[5][2][1])
                {clock(3);clock(2);anti(3);clock(2);clock(3);clock(2);clock(2);anti(3);clock(2);}
            else if(cube[1][1][1]==cube[1][2][1]&&cube[5][1][1]==cube[5][2][1])
                {clock(5);clock(2);anti(5);clock(2);clock(5);clock(2);clock(2);anti(5);clock(2);}
                
            else if(cube[5][1][1]==cube[5][2][1]&&cube[4][1][1]==cube[4][2][1]) //opposite
                {clock(1);clock(2);anti(1);clock(2);clock(1);clock(2);clock(2);anti(1);clock(2);}
            else if(cube[3][1][1]==cube[3][0][1]&&cube[1][1][1]==cube[1][2][1])
                {clock(4);clock(2);anti(4);clock(2);clock(4);clock(2);clock(2);anti(4);clock(2);}
            else clock(2);
        }
    }
    static void step6()
    {
        //step: bottom corners allignment
        while((((cube[1][2][0]!=cube[1][1][1]&&cube[2][0][0]!=cube[1][1][1]&&cube[4][2][2]!=cube[1][1][1])||  
        (cube[1][2][0]!=cube[4][1][1]&&cube[2][0][0]!=cube[4][1][1]&&cube[4][2][2]!=cube[4][1][1]))&&
        (cube[1][2][0]==cube[2][1][1]||cube[2][0][0]==cube[2][1][1]||cube[4][2][2]==cube[2][1][1]))||        
        (((cube[4][2][0]!=cube[4][1][1]&&cube[3][0][0]!=cube[4][1][1]&&cube[2][2][0]!=cube[4][1][1])||   
        (cube[4][2][0]!=cube[3][1][1]&&cube[3][0][0]!=cube[3][1][1]&&cube[2][2][0]!=cube[3][1][1]))&&
        (cube[4][2][0]==cube[2][1][1]||cube[3][0][0]==cube[2][1][1]||cube[2][2][0]==cube[2][1][1]))||        
        (((cube[3][0][2]!=cube[5][1][1]&&cube[2][2][2]!=cube[5][1][1]&&cube[5][2][2]!=cube[5][1][1])||  
        (cube[3][0][2]!=cube[3][1][1]&&cube[2][2][2]!=cube[3][1][1]&&cube[5][2][2]!=cube[3][1][1]))&&
        (cube[3][0][2]==cube[2][1][1]||cube[2][2][2]==cube[2][1][1]||cube[5][2][2]==cube[2][1][1]))||        
        (((cube[5][2][0]!=cube[1][1][1]&&cube[2][0][2]!=cube[1][1][1]&&cube[1][2][2]!=cube[1][1][1])||  
        (cube[5][2][0]!=cube[5][1][1]&&cube[2][0][2]!=cube[5][1][1]&&cube[1][2][2]!=cube[5][1][1]))&&
        (cube[5][2][0]==cube[2][1][1]||cube[2][0][2]==cube[2][1][1]||cube[1][2][2]==cube[2][1][1])))
        {
            if((cube[1][2][0]==cube[1][1][1]||cube[2][0][0]==cube[1][1][1]||cube[4][2][2]==cube[1][1][1])&&   //face 1
            (cube[1][2][0]==cube[4][1][1]||cube[2][0][0]==cube[4][1][1]||cube[4][2][2]==cube[4][1][1])&&
            (cube[1][2][0]==cube[2][1][1]||cube[2][0][0]==cube[2][1][1]||cube[4][2][2]==cube[2][1][1]))
                {clock(2);clock(4);anti(2);anti(5);clock(2);anti(4);anti(2);clock(5);}
            else if((cube[4][2][0]==cube[4][1][1]||cube[3][0][0]==cube[4][1][1]||cube[2][2][0]==cube[4][1][1])&&   //face 4
            (cube[4][2][0]==cube[3][1][1]||cube[3][0][0]==cube[3][1][1]||cube[2][2][0]==cube[3][1][1])&&
            (cube[4][2][0]==cube[2][1][1]||cube[3][0][0]==cube[2][1][1]||cube[2][2][0]==cube[2][1][1]))
                {clock(2);clock(3);anti(2);anti(1);clock(2);anti(3);anti(2);clock(1);}
            else if((cube[3][0][2]==cube[5][1][1]||cube[2][2][2]==cube[5][1][1]||cube[5][2][2]==cube[5][1][1])&&   //face 3
            (cube[3][0][2]==cube[3][1][1]||cube[2][2][2]==cube[3][1][1]||cube[5][2][2]==cube[3][1][1])&&
            (cube[3][0][2]==cube[2][1][1]||cube[2][2][2]==cube[2][1][1]||cube[5][2][2]==cube[2][1][1]))
                {clock(2);clock(5);anti(2);anti(4);clock(2);anti(5);anti(2);clock(4);}
            else if((cube[5][2][0]==cube[1][1][1]||cube[2][0][2]==cube[1][1][1]||cube[1][2][2]==cube[1][1][1])&&   //face 5
            (cube[5][2][0]==cube[5][1][1]||cube[2][0][2]==cube[5][1][1]||cube[1][2][2]==cube[5][1][1])&&
            (cube[5][2][0]==cube[2][1][1]||cube[2][0][2]==cube[2][1][1]||cube[1][2][2]==cube[2][1][1]))
                {clock(2);clock(1);anti(2);anti(3);clock(2);anti(1);anti(2);clock(3);}
            else 
                {clock(2);clock(4);anti(2);anti(5);clock(2);anti(4);anti(2);clock(5);}
        }
    }
    static void step7()
    {
        //step: bottom corners solve
        while(cube[2][0][0]!=cube[2][1][1]||cube[2][0][2]!=cube[2][1][1]||
        cube[2][2][0]!=cube[2][1][1]||cube[2][2][2]!=cube[2][1][1])
        {
            while(cube[2][0][0]!=cube[2][1][1])
            {anti(4);anti(0);clock(4);clock(0);}
            clock(2);
        }
    }
    static void disp()
    {
        System.out.println("\n--------------new-------------------");
        for(int a=0;a<6;a++)
        {
            System.out.println("\n");
            for(int b=0;b<3;b++){
                System.out.println();
                for(int c=0;c<3;c++){
                    if(cube[a][b][c]==1)System.out.print("W  ");
                    else if(cube[a][b][c]==2)System.out.print("O  ");
                    else if(cube[a][b][c]==3)System.out.print("R  ");
                    else if(cube[a][b][c]==4)System.out.print("G  ");
                    else if(cube[a][b][c]==5)System.out.print("B  ");
                    else if(cube[a][b][c]==6)System.out.print("Y  ");
                    else System.out.print(cube[a][b][c]+"  ");
                }
            }
        }
    }
}