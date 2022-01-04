
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SwScreenBuilder {
    static int[] i = {1,2,3,4,5,6,7,8,9,10,12,14,15,16,18,20,22,24,25,26,28,30,32,35,36,38,
            40,42,45,48,50,55,58,60,65,68,70,72,75,78,80,82,85,86,90,95,98,100,110,120,125,130,
            135,136,140,142,145,146,150,156,160,170,180,190,200,210,220,230,240,250,256,260,
            270,280,290,300,320,340,350,360,370,380,390,400,420,450,460,480,500,510,520,550,
            580,600,610,620,630,640,650,660,670,680,700,800,820,850,880,900,920,950,960,980,
            1000,1024,1050,1080,1100,1200,1250,1300,1400,1500,1600,1800,1920};

    public static void main(String[] args) {
        // TODO Auto-generated method stub

//		300,360,420,480,500,520,560,600,640,680,720,760,780,800,820,860,
//		900,960,1000,1080,1200,1400,1600,1920,2000

        int[] j = {300,360,420,480,500,520,560,600,640,680,720,760,780,800,820,860,
                900,960,1000,1080,1200,1400,1600,1920,2000};

        for(int m =0;m<j.length;m++){
            System.out.println(" \n适配大小"+j[m]+"\n");
            createFile(j[m]);
        }
    }
    private static void createFile(int n) {
        File file=new File("F:\\AndroidSwScreen\\values-sw"+n+"dp");
        if(!file.exists()){//如果文件夹不存在
            file.mkdir();//创建文件夹
        }

        try{//异常处理

            BufferedWriter bw=new BufferedWriter(new FileWriter("F:\\AndroidSwScreen\\values-sw"+n+"dp"+"\\dimens.xml"));
            bw.write("<resources>\n");

            for(int k =0;k<i.length;k++){
                System.out.println();
                bw.write("  <dimen name=\"dp"+i[k]+"\">"+Math.round(i[k]*(n/300.0))+"dp</dimen>\n");
            }
            bw.write("</resources>\n");
            bw.close();//一定要关闭文件
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
