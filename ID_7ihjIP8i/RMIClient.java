package ID_7ihjIP8i;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

public class RMIClient {
    private static boolean nextPermutation(int[] a, int n) {
        int i = n - 2;
        while(i >= 0 && a[i] >= a[i+1]) {
            --i;
        }
        if (i<0) return false;
        int j = n-1;
        while(a[i] >= a[j]) --j;

        swap(a, i, j);
        int left = i + 1, right = n - 1;
        while(left < right) {
            swap(a, left, right);
            left++;
            right--;
        }
        return true;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        String host = "203.162.10.109";
        String studentCode = "B22DCCN154";
        String qCode = "7ihjIP8i";

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            DataService byteService = (DataService) registry.lookup("RMIDataService");

            String data = (String) byteService.requestData(studentCode, qCode);
            System.out.println(data);

            String[] numStr = data.split(", ");
            int[] a = new int[numStr.length];
            for (int i=0; i<numStr.length; i++) {
                a[i] = Integer.parseInt(numStr[i]);
            }

            StringBuilder request = new StringBuilder();
            if (nextPermutation(a, a.length)) {
                for (int x: a) {
                    request.append(x).append(",");
                }
                System.out.println(request);
            } else {
                Arrays.sort(a);
                for (int x: a) {
                    request.append(x).append(",");
                }
                System.out.println(request);
            }

            byteService.submitData(studentCode, qCode, request.substring(0, request.toString().length() - 1));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

//[Mã câu hỏi (qCode): Wc1rBedr].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để quản lý thông tin đơn hàng trong hệ thống thương mại điện tử. Chương trình sẽ ngẫu nhiên tạo ra đối tượng Order với các giá trị ban đầu và cung cấp cho RMI client như sau:
//Giao diện từ xa:
//public interface ObjectService extends Remote {
//    public Serializable requestObject(String studentCode, String qCode) throws RemoteException;
//    public void submitObject(String studentCode, String qCode, Serializable object) throws RemoteException;
//}
//Lớp Order gồm các thuộc tính: id String, customerCode String, orderDate String, shippingType String, orderCode String.
//        •	Trường dữ liệu: private static final long serialVersionUID = 20241132L;
//•	02 hàm khởi dựng:
//public Order()
//public Order(String id, String customerCode, String orderDate, String shippingType)
//Trong đó:
//        •	Interface ObjectService và lớp Order được viết trong package RMI.
//•	Đối tượng cài đặt giao diện từ xa ObjectService được đăng ký với RegistryServer: RMIObjectService.
//Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với đối tượng đơn hàng được nhận từ RMI Server:
//a. Triệu gọi phương thức requestObject để nhận đối tượng Order ngẫu nhiên từ server.
//b. Tạo mã orderCode cho đơn hàng dựa trên các quy tắc sau:
//        •	Bắt đầu bằng hai ký tự đầu của shippingType, viết in hoa.
//•	Kế đến là ba ký tự cuối của customerCode.
//•	Cuối cùng là ngày và tháng từ orderDate (theo định dạng "ddMM").
//Ví dụ: Nếu đơn hàng có mã khách hàng là "C123456", ngày đặt hàng là "2023-10-05", và loại giao hàng là "Express", thì mã orderCode sẽ là "EX4560510".
//c. Cập nhật giá trị orderCode trong đối tượng Order.
//d. Triệu gọi phương thức submitObject để gửi đối tượng Order đã được xử lý trở lại server.
//e. Kết thúc chương trình client.