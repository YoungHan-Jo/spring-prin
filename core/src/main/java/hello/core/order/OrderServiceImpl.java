package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


// @RequiredArgsConstructor -> final이 붙은 필드를 모아서 생성자를 자도응로 생성해줌. 생성자Autowired랑 같은 효과
@Component
public class OrderServiceImpl implements OrderService {

    // final을 붙이면 무조건 값이 있어야함을 강요 // 생성자로 주입받은 값이 고정 되도록
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 단일책임의 원칙 잘 지킨 것/ 주문서비스에서는 할인정책까지 알 필요없음
        // 할인정책이 바뀌어도 할인정책쪽만 바꾸면 나머지에 자동으로 적용됨
        
        return new Order(memberId,itemName,itemPrice, discountPrice);
    }

    // 테스트 용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
