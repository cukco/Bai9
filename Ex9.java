import java.util.Scanner;
public class Ex33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int count=0;
        double sum=0;
        double max=-1;
        double min=500000001;
        double bonus=0;
        while(true){
            System.out.print("========== MENU ==========\n" +
                    "1. Nhập lương nhân viên\n" +
                    "2. Hiển thị thống kê\n" +
                    "3. Tính tổng tiền thưởng nhân viên\n" +
                    "4. Thoát\n" +
                    "Lựa chọn của bạn: ");
            n = sc.nextInt();
            if (n == 1) {
                System.out.print("--- Nhập lương nhân viên (nhập -1 để kết thúc) ---\n");
                double mark;
                do {
                    System.out.print("Nhập lương: ");
                    mark = sc.nextDouble();
                    if(mark==-1){
                        continue;
                    }else if(mark <0 || mark > 500000000){
                        System.out.println("Điểm không hợp lệ. Nhập lại.");
                        continue;
                    }
                    String phanloai = "";
                    if (mark >= 50000000) phanloai = "Cao";
                    else if (mark >= 15000000) phanloai = "Khá";
                    else if (mark >= 5000000) phanloai = "Trung bình";
                    else phanloai = "Yếu";
                    System.out.println("-> Phân loại: " + phanloai);
                    if(mark > max) max=mark;
                    if(mark < min) min=mark;
                    switch(phanloai){
                        case "Cao":
                            if(mark > 100000000) bonus+= mark*0.25;
                            else bonus+= mark*0.20;
                            break;
                        case "Khá":
                            bonus+= mark*0.15;
                            break;
                        case "Trung bình":
                            bonus+= mark*0.1;
                            break;
                        case "Yếu":
                            bonus+= mark*0.05;
                            break;
                        default:
                    }
                    count++;
                    sum+=mark;
                }while(mark != -1);
            }else if(n == 2){
                if(count==0){System.out.println("Chưa có dữ liệu");continue;}
                System.out.println("---Thống kê---");
                System.out.printf("Số nhân viên: %d\n",count);
                System.out.printf("Tổng lương: %,.0f\n",sum);
                System.out.printf("Lương trung bình: %,.0f\n",sum/count);
                System.out.printf("Lương cao nhất: %,.0f\nLương thấp nhất: %,.0f\n",max,min);
            }else if(n == 3){System.out.printf("Tổng số tiền thưởng nhân viên: %,.0f\n",bonus);}
        }

    }
}
