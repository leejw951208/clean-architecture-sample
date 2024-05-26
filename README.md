# 헥사고날 아키텍처
헥사고날 아키텍처 기반 상품 주문, 주문 조회 API
## 흐름
![헥사고날 흐름도](https://github.com/leejw951208/hexagonal-architecture/assets/108619836/a871ba80-b0cc-4bf4-b660-7fafca2d8b21)
1. OrderSaveUseCases 인터페이스를 통해 회원, 비회원 상품 주문 비즈니스 로직을 정의하고 OrderSaveService에 구현합니다.
2. UserOrderSavePort 인터페이스를 통해 주문 테이블과 통신하는 UserOrderCommandAdapter를 구현합니다.
3. OrderSaveService에서 UserOrderSave 객체를 생성하고 UserOrderSavePort를 통해 해당 객체를 인자로 넘깁니다.
4. UserOrderCommandAdapter에서 받은 객체를 엔티티 객체로 변환하고 데이터 영속화를 수행합니다.
