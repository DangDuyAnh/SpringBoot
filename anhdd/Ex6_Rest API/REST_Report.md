## 1. Khái niệm

- REST là từ viết tắt của Representational State Transfer: Nó là một trong những dạng chuyển đổi cấu trúc, với kiểu kiến trúc thường được viết API. Rest thường sử dụng dụng phương thức HTTP đơn giản để có thể tạo ra giao tiếp giữa các máy.
- API là từ viết tắt của cụm từ Application Programming Interface, đây là tập hợp những quy tắc và cơ chế mà theo đó thì: Một ứng dụng hoặc một thành phần nào đó sẽ tương tác với một ứng dụng hoặc một số thành phần khác. API có thể sẽ được trả về dữ liệu mà người dùng cần cho chính ứng dụng của bạn với những kiểu dữ liệu được dùng phổ biến như JSON hoặc XML. 

## 2. Cấu trúc REST

- Hệ thống hoạt động theo mô hình client-server, trong đó server là tập hợp các service nhỏ lắng nghe các request từ client. Với từng request khác nhau thì có thể một hoặc nhiều service xử lý.
- Stateless (phi trạng thái). Đơn giản server và client không lưu trạng thái của nhau
- Khả năng caching : Các response có thể lấy ra từ cache
- Chuẩn hóa các interface : Đây là một trong những đặc tính quan trọng của hệ thống REST. Bằng cách tạo ra các quy ước chuẩn để giao tiếp giữa các thành phần trong hệ thống, đơn giản hóa việc client có thể tương tác với server. Các quy ước này áp dụng cho toàn bộ các service giúp cho người sử dụng hệ thống của bạn dễ dụng hơn. Dễ hiểu hơn trên hệ thống đặt ra 1 chuẩn API để người dùng dù là mobile, web đều có thể kết nối vào được.
- Phân lớp hệ thống : trong hệ thống REST chia tách các thành phần hệ thống theo từng lớp, mỗi lớp chỉ sử dụng lớp ở dưới nó và giao tiếp với lớp ở ngay trên nó mà thôi. Điều này giúp giảm độ phức tạp của hệ thống, giúp các thành phần tách biệt nhau từ đó dễ dàng mở rộng từng thành phần.

## 3. REST và RESTful
Restful thường để diễn tả các dịch vụ ứng dụng web cài đặt theo kiến trúc REST
