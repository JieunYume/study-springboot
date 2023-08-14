// 메인 클래스
public class Main {
    public static void main(String[] args) {
        // 인스턴스 생성
        Car myCar = new Car("Hyundai", "G80", 2022);

        // 메서드 호출
        myCar.displayInfo();
        myCar.accelerate();
        myCar.brake();
    }
}