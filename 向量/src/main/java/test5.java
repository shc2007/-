public class test5{
    public static void main(String[] args){
        VectorCart A,B,C;
        A=new VectorCart(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
        B=new VectorCart(Double.parseDouble(args[2]),Double.parseDouble(args[3]));
        C=new VectorCart(Double.parseDouble(args[4]),Double.parseDouble(args[5]));
        VectorCart AB=B.subtract(A);
        VectorCart AC=C.subtract(A);
        double cross=AB.cross(AC);
        double area=Math.abs(cross)/2.0;
        System.out.println("面积"+area);
        if (Math.abs(cross)<1e-10)
        {
            System.out.println("共线");
        } 
        else if(cross>0)
        {
            System.out.println("逆时针");
        } 
        else
        {
            System.out.println("顺时针");
        }
    }
}
