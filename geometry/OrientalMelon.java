package geometry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class OrientalMelon {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        int[] length = new int[6];
        int maxWidthLocation=0, maxWidth=0, maxHeight=0, maxHeightLocation=0;
        int direction;
        for(int i=0;i<6;i++) {
            st = new StringTokenizer(br.readLine());
            direction = Integer.parseInt(st.nextToken());
            length[i]=Integer.parseInt(st.nextToken());
            //가장 긴 가로의 길이와 위치 찾기
            if((direction==1 || direction==2)&& maxWidth<length[i]) {
                maxWidth=length[i];
                maxWidthLocation=i;
            }
            //가장 긴 세로의 길이와 위치 찾기
            else if((direction==3 || direction==4)&& maxHeight<length[i]){
                maxHeight=length[i];
                maxHeightLocation=i;
            }
        }

        int right,left,minWidth,minHeight;

        if(maxWidthLocation+1==6)right=0;
        else right=maxWidthLocation+1;

        if(maxWidthLocation-1==-1)left=5;
        else left=maxWidthLocation-1;
        //빈 사각형의 세로 길이
        minHeight=Math.abs(length[right]-length[left]);

        if(maxHeightLocation+1==6)right=0;
        else right=maxHeightLocation+1;

        if(maxHeightLocation-1==-1)left=5;
        else left=maxHeightLocation-1;
        //빈 사각형의 가로 길이
        minWidth=Math.abs(length[right]-length[left]);

        System.out.println(((maxWidth*maxHeight)-(minHeight*minWidth)) * count);
    }
}